# Spring Boot `@Async` – Complete Guide (Start to End)

This document explains **Spring Boot `@Async`** from basics to advanced usage. You can directly upload this `.md` file to GitHub.

---

## 1. What is `@Async`?

`@Async` allows a method to run **asynchronously** in a separate thread. The caller does **not wait** for the method to finish execution.

### Key Benefits

* Improves application responsiveness
* Executes long-running tasks in background
* Non-blocking request handling

---

## 2. Enable Async Support

You must enable async processing in your Spring Boot application.

```java
@SpringBootApplication
@EnableAsync
public class MyApplication {
    public static void main(String[] args) {
        SpringApplication.run(MyApplication.class, args);
    }
}
```

⚠️ Without `@EnableAsync`, `@Async` will not work.

---

## 3. Basic `@Async` Example

### Service Class

```java
@Service
public class EmailService {

    @Async
    public void sendEmail(String to) {
        System.out.println("Thread: " + Thread.currentThread().getName());
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Email sent to " + to);
    }
}
```

### Controller

```java
@RestController
public class TestController {

    @Autowired
    private EmailService emailService;

    @GetMapping("/send")
    public String send() {
        emailService.sendEmail("test@gmail.com");
        return "Request accepted";
    }
}
```

### Output

```text
Request accepted
Thread: task-1
Email sent to test@gmail.com
```

---

## 4. Returning Value from `@Async`

Use `CompletableFuture`, `Future`, or `ListenableFuture`.

### Example using `CompletableFuture`

```java
@Async
public CompletableFuture<String> processData() {
    return CompletableFuture.completedFuture("Done");
}
```

### Calling Method

```java
CompletableFuture<String> result = service.processData();
System.out.println(result.get());
```

---

## 5. Custom Thread Pool (Highly Recommended)

By default, Spring uses `SimpleAsyncTaskExecutor` which is **not production-safe**.

### Create Executor Configuration

```java
@Configuration
@EnableAsync
public class AsyncConfig {

    @Bean(name = "taskExecutor")
    public Executor taskExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(5);
        executor.setMaxPoolSize(10);
        executor.setQueueCapacity(100);
        executor.setThreadNamePrefix("Async-");
        executor.initialize();
        return executor;
    }
}
```

### Use Custom Executor

```java
@Async("taskExecutor")
public void runTask() {
    System.out.println(Thread.currentThread().getName());
}
```

---

## 6. Exception Handling in `@Async`

Exceptions are **not propagated** to the caller.

### Handle Inside Method

```java
@Async
public void asyncTask() {
    try {
        int x = 10 / 0;
    } catch (Exception e) {
        e.printStackTrace();
    }
}
```

### Global Async Exception Handler

```java
@Configuration
public class AsyncExceptionConfig implements AsyncConfigurer {

    @Override
    public Executor getAsyncExecutor() {
        return new ThreadPoolTaskExecutor();
    }

    @Override
    public AsyncUncaughtExceptionHandler getAsyncUncaughtExceptionHandler() {
        return (ex, method, params) ->
            System.out.println("Exception in async method: " + method.getName());
    }
}
```

---

## 7. Common Mistakes

| Mistake                              | Result             |
| ------------------------------------ | ------------------ |
| Calling async method from same class | Runs synchronously |
| Method not `public`                  | `@Async` ignored   |
| Missing `@EnableAsync`               | `@Async` ignored   |
| Default executor in production       | Performance issues |

---

## 8. `@Async` with Transactions

⚠️ `@Async` creates a **new thread**, so transaction context is lost.

### Wrong

```java
@Transactional
@Async
public void saveData() {}
```

### Correct

```java
@Async
public void asyncMethod() {
    transactionalMethod();
}

@Transactional
public void transactionalMethod() {}
```

---

## 9. When to Use `@Async`

### Use Cases

* Email sending
* File processing
* Report generation
* Background DB tasks
* External API calls

### Avoid For

* Heavy CPU-bound jobs
* Distributed workflows (use Kafka / Batch)
* Critical transactional logic

---

## 10. Best Practices

* Always use a custom thread pool
* Keep async methods short
* Monitor thread usage
* Log thread names
* Avoid blocking calls inside async methods

---

## 11. Summary

* `@Async` enables background execution
* Requires `@EnableAsync`
* Must be `public` and called from another bean
* Use `CompletableFuture` for results
* Configure thread pool for production

---

✅ **This file is GitHub-ready**. Save it as:

```
async-spring-boot.md
```

and upload to your repository.

# Difference Between Async and Multi-threading

This document explains the difference between **asynchronous programming** and **multi-threading**. It is formatted as a Markdown file suitable for GitHub.

---

## 1️⃣ Core Difference

* **Asynchronous (Async)**: Focuses on **non-blocking execution**. The caller does not wait for the task to finish.
* **Multithreading**: Focuses on **parallel execution** using multiple threads to execute tasks simultaneously.

---

## 2️⃣ Definitions

### Asynchronous (Async)

* Task starts and **does not block** the caller.
* Result is handled later via callback, future, or promise.
* Example in Java Spring Boot:

```java
@Async
public void sendEmail() {}
```

### Multithreading

* Multiple threads execute tasks **in parallel**.
* Threads compete for CPU resources and may require synchronization.
* Example in Java:

```java
new Thread(() -> sendEmail()).start();
```

---

## 3️⃣ Key Differences

| Feature           | Async                      | Multithreading          |
| ----------------- | -------------------------- | ----------------------- |
| Main purpose      | Non-blocking execution     | Parallel execution      |
| Thread usage      | May use threads internally | Explicitly uses threads |
| Blocking          | Non-blocking               | Can be blocking         |
| Complexity        | Simple                     | Complex                 |
| Resource usage    | Efficient                  | Expensive               |
| Error handling    | Easier                     | Harder                  |
| Context switching | Minimal                    | High                    |
| Best for          | I/O tasks                  | CPU-intensive tasks     |

---

## 4️⃣ Execution Model

### Async

* Caller triggers task.
* Control returns immediately.
* Task completes later.
* Result handled via callback/future.

```
Request → Trigger Task → Continue Execution
                     ↳ Background Execution
```

### Multithreading

* Multiple threads execute tasks simultaneously.
* Threads may need synchronization.

```
Thread-1 → Task A
Thread-2 → Task B
Thread-3 → Task C
```

---

## 5️⃣ Real-World Analogy

* **Async**: Sending an email and continuing to work without waiting for confirmation.
* **Multithreading**: Multiple chefs cooking different dishes simultaneously.

---

## 6️⃣ In Spring Boot Context

* **Async (`@Async`)**:

  * High-level abstraction
  * Uses thread pool internally
  * Managed by Spring

* **Multithreading**:

  * Low-level control
  * Uses `Thread` or `ExecutorService`
  * Manual lifecycle management

---

## 7️⃣ When to Use

### Use Async When:

* I/O-bound tasks
* API calls
* Sending emails, notifications
* File upload/download

### Use Multithreading When:

* CPU-bound tasks
* Data processing
* Parallel computation
* Performance-critical logic

---

## 8️⃣ Common Interview Tips

* Async ≠ Multithreading
* Multithreading does not guarantee non-blocking behavior
* Async can run on a single thread
* Multi-threading requires synchronization and context switching

---

## 9️⃣ One-Line Answer for Interviews

> **Async focuses on non-blocking execution, while multithreading focuses on parallel execution using multiple threads.**
