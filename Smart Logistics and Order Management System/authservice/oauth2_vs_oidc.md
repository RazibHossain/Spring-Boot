# OAuth2 vs OIDC — Study Notes

---

## 1. OAuth2 — Authorization Only

> **Core purpose:** OAuth2 is for **authorization**, NOT authentication.

### What it does
- The auth server **authenticates the user** (via login) — yes, this happens
- Then **issues an access token** to the client app
- The client uses this token to **access APIs/resources**

### What it does NOT do
- Does **not** expose who the user is in a standard format
- Does **not** provide structured user profile/identity info
- Does **not** define how apps should use identity

### OAuth2 Token Response
```json
{
  "access_token": "abc123"
}
```
> ⚠️ This token only means **"this client is allowed"** — it does NOT say **who the user is**.

### The Classic Confusion

**Q: Does the auth server authenticate the user if it only gives an access token?**

| | Answer |
|---|---|
| ✅ | YES — authentication **already happened** (user logged in) |
| ✅ | The server verified who the user is internally |
| ❌ | But OAuth2 does **NOT expose that identity** to your app in a standard way |

### Analogy — Security Guard + Wristband
```
Security guard checks your ID  →  You are authenticated ✅
Guard gives you a wristband    →  You get an access token ✅
Wristband has no details       →  No identity info printed ❌
```

### What the Authorization Server Does (in OAuth2)
| Role | Action |
|---|---|
| Authenticates user | Verifies login credentials |
| Authorizes client | Grants requested scopes |
| Issues tokens | Returns access token to client |

---

## 2. OIDC (OpenID Connect) — Authentication + Identity

> **Core purpose:** OIDC is built **on top of OAuth2** and adds **user authentication** + **standardized identity information**.

### What it adds over OAuth2
- Introduces the **ID Token** (a JWT) alongside the access token
- The ID Token contains a **structured, trusted user profile**
- Apps now know **exactly who logged in**

### OIDC Token Response
```json
{
  "access_token": "abc123",
  "id_token": {
    "sub": "zahin",
    "email": "zahin@gmail.com",
    "name": "Zahin",
    "role": "admin"
  }
}
```

### Common ID Token Claims
| Claim | Meaning |
|---|---|
| `sub` | Unique user ID (subject) |
| `email` | User's email address |
| `name` | User's full name |
| `role` | User's role (if included) |

### Analogy — Security Guard + Badge
```
Security guard checks your ID  →  You are authenticated ✅
Guard gives you a badge        →  You get an access token ✅
Badge has name/photo/email     →  You get identity info ✅
Apps know exactly who you are  →  Standard identity format ✅
```

---

## 3. Side-by-Side Comparison

| Feature | OAuth2 | OIDC |
|---|---|---|
| **Purpose** | Authorization | Authentication + Authorization |
| **Answers** | *"Is this client allowed?"* | *"Who is this user, and are they allowed?"* |
| **Token issued** | Access Token only | Access Token + **ID Token** |
| **User identity exposed?** | ❌ No standard way | ✅ Yes, via ID Token (JWT) |
| **Knows username/email?** | ❌ Not directly | ✅ Yes |
| **Built on** | Itself | OAuth2 |

---

## 4. Quick Mental Model

```
OAuth2  →  "Here's a token. You have access."          (authorization)
OIDC    →  "Here's a token. You have access.
            AND here's exactly who you are."            (authorization + identity)
```

---

## 5. JWT — How It Fits In

> **JWT (JSON Web Token)** is a compact, self-contained token format used to securely transmit information between parties as a signed JSON object.

### JWT Structure
A JWT has **3 parts**, separated by dots:
```
xxxxx.yyyyy.zzzzz
  │      │      │
Header  Payload  Signature
```

**Header** — token type and signing algorithm
```json
{
  "alg": "HS256",
  "typ": "JWT"
}
```

**Payload** — the actual claims/data
```json
{
  "sub": "zahin",
  "email": "zahin@gmail.com",
  "role": "admin",
  "exp": 1712345678
}
```

**Signature** — verifies the token wasn't tampered with
```
HMACSHA256(base64(header) + "." + base64(payload), secret)
```

> ✅ The signature means: **if the payload is changed, the signature breaks** — so the receiver knows it's been tampered with.

---

### JWT in OAuth2

In OAuth2, the **access token** *can be* a JWT — but it's not required. OAuth2 doesn't mandate any token format.

**When OAuth2 uses JWT as access token:**
```json
{
  "access_token": "eyJhbGciOiJSUzI1NiJ9.eyJzdWIiOiJ6YWhpbiIsInNjb3BlIjoicmVhZCJ9.signature"
}
```

The resource server (API) can **decode and verify** this JWT locally without calling the auth server every time.

| Without JWT (opaque token) | With JWT access token |
|---|---|
| API must call auth server to validate | API validates locally by checking signature |
| Extra network round-trip | Faster — no extra call needed |
| Auth server is the only one that knows what token means | Token is self-contained and readable |

> ⚠️ Even as a JWT, the OAuth2 access token still does **not guarantee a standard identity format** — it may have scopes and expiry, but not necessarily a user profile.

---

### JWT in OIDC

OIDC **mandates** that the **ID Token is always a JWT**. This is the core addition OIDC makes.

**Full OIDC token response:**
```json
{
  "access_token": "eyJhbGci....",
  "token_type": "Bearer",
  "expires_in": 3600,
  "id_token": "eyJhbGciOiJSUzI1NiJ9.eyJzdWIiOiJ6YWhpbiIsImVtYWlsIjoiemFoaW5AZ21haWwuY29tIn0.signature"
}
```

**Decoded ID Token payload:**
```json
{
  "sub": "zahin",
  "email": "zahin@gmail.com",
  "name": "Zahin",
  "iss": "https://auth.example.com",
  "aud": "my-app-client-id",
  "exp": 1712345678,
  "iat": 1712342078
}
```

| Claim | Meaning |
|---|---|
| `sub` | Unique user ID |
| `email` | User's email |
| `name` | User's display name |
| `iss` | Issuer — who issued this token |
| `aud` | Audience — which app this token is for |
| `exp` | Expiry time (Unix timestamp) |
| `iat` | Issued at time |

> ✅ Because the ID Token is a **signed JWT**, the app can verify it without calling the auth server — and trust the user identity inside it.

---

### JWT Role Summary

| Token | Protocol | Format | Purpose |
|---|---|---|---|
| Access Token | OAuth2 | Opaque string or JWT | Authorize API calls |
| ID Token | OIDC | Always JWT | Carry verified user identity |
| Refresh Token | OAuth2 / OIDC | Opaque string | Get new access tokens silently |

---

### Why JWT Makes Sense for OIDC

```
Without JWT:
  App gets ID  →  App calls auth server  →  "Who is this user?"  →  Gets profile
  (extra network call every time)

With JWT (ID Token):
  App gets ID Token  →  App decodes JWT locally  →  Gets profile instantly ✅
  (no extra call — data is inside the token, signature proves it's trustworthy)
```

---

## 6. Key Takeaways

- ✅ OAuth2 **does authenticate** the user internally — but doesn't share that identity with your app
- ✅ OAuth2 gives an **access token** — useful for calling APIs, not for knowing the user
- ✅ OAuth2 access token *can be* a JWT, but it's **not required** — format is flexible
- ✅ OIDC adds an **ID token** — always a JWT, with structured, trusted user details
- ✅ JWT's **signature** makes tokens self-verifiable — no need to call the auth server again
- ✅ Use **OAuth2** when you just need API access on behalf of a user
- ✅ Use **OIDC** when your app needs to know **who the logged-in user is**
- ✅ **ID Token = who you are** (OIDC/JWT) | **Access Token = what you can do** (OAuth2)
