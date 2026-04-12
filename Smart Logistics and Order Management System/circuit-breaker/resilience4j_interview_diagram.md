# Resilience4j -- Interview Q&A + Diagram Guide

------------------------------------------------------------------------

# 🎯 Interview Q&A Section

## 1. What is Circuit Breaker?

Circuit Breaker is a design pattern that prevents repeated calls to a
failing service.

👉 It stops calling the service when failures exceed a threshold.

------------------------------------------------------------------------

## 2. What are the states of Circuit Breaker?

-   **CLOSED** → Normal operation
-   **OPEN** → Calls are blocked
-   **HALF-OPEN** → Testing if service recovered

------------------------------------------------------------------------

## 3. What is slidingWindowSize?

Number of recent calls considered to calculate failure rate.

Example:

    slidingWindowSize = 5

------------------------------------------------------------------------

## 4. What is failureRateThreshold?

Percentage of failures required to open circuit.

Example:

    failureRateThreshold = 50

------------------------------------------------------------------------

## 5. What is Retry?

Retry automatically re-attempts failed requests.

------------------------------------------------------------------------

## 6. Difference between Retry and Circuit Breaker?

  Retry                        Circuit Breaker
  ---------------------------- ------------------------------
  Re-attempts failed calls     Stops calls completely
  Handles temporary failures   Handles system-wide failures

------------------------------------------------------------------------

## 7. What is TimeLimiter?

Limits how long a request can run.

------------------------------------------------------------------------

## 8. What is Fallback?

Backup method executed when: - Retry fails - Circuit is open - Timeout
occurs

------------------------------------------------------------------------

## 9. What happens when all are combined?

Flow: 1. Request sent 2. Timeout occurs 3. Retry triggers 4. Failures
increase 5. Circuit opens 6. Fallback returned

------------------------------------------------------------------------

## 10. Common Interview Trick Question

❓ What happens if Retry is high and Circuit Breaker is small?

👉 System overload + fast circuit open

------------------------------------------------------------------------

# 📊 Diagram Section

## 🔄 Full Flow Diagram

            ┌───────────────┐
            │   Client      │
            └──────┬────────┘
                   │
                   ▼
            ┌───────────────┐
            │ TimeLimiter   │ (Timeout > 3s ❌)
            └──────┬────────┘
                   │
                   ▼
            ┌───────────────┐
            │   Retry       │ (Max 3 attempts)
            └──────┬────────┘
                   │
                   ▼
            ┌───────────────┐
            │ CircuitBreaker│
            └──────┬────────┘
                   │
         ┌─────────┴─────────┐
         │                   │
         ▼                   ▼
    ┌──────────────┐   ┌──────────────┐
    │ Payment API  │   │  Fallback    │
    │ (Success)    │   │  Response    │
    └──────────────┘   └──────────────┘

------------------------------------------------------------------------

## 🔌 Circuit Breaker State Diagram

            CLOSED
              │
              │ (Failures > Threshold)
              ▼
             OPEN
              │
              │ (Wait Duration Passed)
              ▼
          HALF-OPEN
              │
       ┌──────┴──────┐
       │             │
    Success       Failure
       │             │
       ▼             ▼
     CLOSED        OPEN

------------------------------------------------------------------------

## ⚡ Retry Flow

    Request
      │
      ▼
    Try 1 ❌
      │
      ▼
    Try 2 ❌
      │
      ▼
    Try 3 ✅ (Success)

------------------------------------------------------------------------

## ⏱ Timeout Behavior

    Request Sent
         │
         ▼
    Waiting...
         │
         ├── < 3s → Success ✅
         │
         └── > 3s → Timeout ❌ → Fallback

------------------------------------------------------------------------

# 🚀 Final Tips (Interview Gold)

-   Always use **Fallback**
-   Keep **Retry low**
-   Set **Timeout carefully**
-   Tune **Circuit Breaker threshold based on traffic**

------------------------------------------------------------------------

# 🧩 Summary

  Feature           Purpose
  ----------------- -------------------------
  Retry             Handle temporary issues
  Timeout           Prevent long waits
  Circuit Breaker   Protect system
  Fallback          Ensure response

------------------------------------------------------------------------

This document is optimized for: ✅ Interviews\
✅ Real system design\
✅ Quick revision
