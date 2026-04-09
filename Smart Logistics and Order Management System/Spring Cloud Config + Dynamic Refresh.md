# 🚀 Spring Cloud Config + Dynamic Refresh (Real Use Case Guide)

## 🔥 Real Use Case (Why this matters)

Imagine your system is LIVE in production:

---

## 🔥 Scenario 1: Feature Toggle

feature.discount.enabled=false

👉 You deploy → feature is OFF

Later:

feature.discount.enabled=true

✅ Without restart → feature becomes ON instantly

---

## 🔥 Scenario 2: Change API Rate Limit

rate.limit=10

Change to:

rate.limit=50

👉 No downtime  
👉 No redeploy  
👉 Instant effect

---

## 🔥 Scenario 3: Security / Config Fix

security.authorization.enabled=false

👉 Turn ON instantly without restart

---

# 🧠 Default Behavior (Problem)

Without refresh:

- Config changes → NOT applied ❌  
- Service restart required ❌  
- Deployment needed ❌  

---

# ✅ Solution: Runtime Refresh

Use Spring Boot Actuator + /actuator/refresh

---

# 🛠️ How to Implement

## 1. Add Dependency

<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-actuator</artifactId>
</dependency>

## 2. Enable Refresh Endpoint

management.endpoints.web.exposure.include=refresh

For testing:
management.endpoints.web.exposure.include=*

## 3. Add @RefreshScope

@RefreshScope
@Component
public class FeatureConfig {

    @Value("${feature.discount.enabled}")
    private boolean enabled;

    public boolean isEnabled() {
        return enabled;
    }
}

## 4. Update Config in Git

feature.discount.enabled=true

## 5. Trigger Refresh

POST http://localhost:9000/actuator/refresh

---

# 🔄 What Happens

1. Call /actuator/refresh  
2. Config Server contacted  
3. New properties fetched  
4. Beans recreated  
5. New values applied  

---

# ⚡ Important Notes

- Only @RefreshScope beans update  
- DB configs usually NOT refreshed  
- Best for feature flags & toggles  

---

# 🚀 Advanced

Use Spring Cloud Bus (Kafka/RabbitMQ):

Git change → Auto refresh all services

---

# 🧩 Real Usage

- Feature flags  
- Rate limiting  
- Logging level control  
- Security toggle  

---

# 🎯 Summary

Without Refresh ❌ Restart needed  
With Refresh ✅ Zero downtime
