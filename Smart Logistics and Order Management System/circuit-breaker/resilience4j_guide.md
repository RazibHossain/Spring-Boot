# Resilience4j Configuration -- Complete Guide

## ✅ Configuration Example

``` properties
# Circuit Breaker
resilience4j.circuitbreaker.instances.paymentService.slidingWindowSize=5
resilience4j.circuitbreaker.instances.paymentService.failureRateThreshold=50
resilience4j.circuitbreaker.instances.paymentService.waitDurationInOpenState=10s

# Retry
resilience4j.retry.instances.paymentService.maxAttempts=3
resilience4j.retry.instances.paymentService.waitDuration=1s

# TimeLimiter (Timeout)
resilience4j.timelimiter.instances.paymentService.timeoutDuration=3s
```

------------------------------------------------------------------------

## 🧠 Concept Breakdown

### 🔌 Circuit Breaker

-   **slidingWindowSize = 5**
    -   Tracks last 5 calls
-   **failureRateThreshold = 50**
    -   Opens circuit if ≥ 50% calls fail
-   **waitDurationInOpenState = 10s**
    -   Stops calls for 10 seconds before testing again

#### Example:

    Calls: ❌ ❌ ✅ ❌ ❌
    Failure Rate = 80% → Circuit OPEN

------------------------------------------------------------------------

### 🔁 Retry

-   **maxAttempts = 3**
    -   Total 3 tries per request
-   **waitDuration = 1s**
    -   1 second delay between retries

#### Example:

    1st try ❌
    2nd try ❌
    3rd try ✅

------------------------------------------------------------------------

### ⏱ TimeLimiter (Timeout)

-   **timeoutDuration = 3s**
    -   Cancels request if it takes more than 3 seconds

------------------------------------------------------------------------

## 🔄 Combined Flow

### Scenario: Payment Service is Slow & Failing

1.  Request sent
2.  Takes \> 3s → Timeout
3.  Retry happens (max 3 times)
4.  Still failing → counted as failure
5.  Failure rate exceeds 50%
6.  Circuit Breaker OPENS

### After Circuit Opens

-   No calls go to Payment Service
-   Fallback method is returned immediately

------------------------------------------------------------------------

## 🎯 Simple Analogy

  Feature           Meaning
  ----------------- ---------------------
  Retry             Try again
  Timeout           Don't wait too long
  Circuit Breaker   Stop trying
  Fallback          Backup response

------------------------------------------------------------------------

## ⚠️ Common Mistakes

-   Too many retries → system overload
-   Too low timeout → false failures
-   No fallback → bad user experience
-   Wrong window size → unstable system

------------------------------------------------------------------------

## 🧩 Real-World Tip

Always balance: - Retry count - Timeout duration - Circuit breaker
threshold

These 3 together define system stability.
