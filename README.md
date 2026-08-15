# sharazan-logging

**Sharazan** — модульный бэкенд-фреймворк на Kotlin, вдохновлённый архитектурой Ktor (declare-then-start композиция через Koin, без Spring-магии).

**logging** — минимальная общая логовая инфраструктура: константы имён MDC-ключей и slf4j/coroutines-slf4j зависимости, которые транзитивно тянутся всеми остальными модулями. Собственного поведения не имеет.

## Стек

- slf4j-api
- kotlinx-coroutines-slf4j

## Maven-координаты

```kotlin
implementation("com.github.37hulk37:sharazan-logging:1.0.0")
```
