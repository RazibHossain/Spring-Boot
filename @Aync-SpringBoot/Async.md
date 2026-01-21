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
