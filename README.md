## KSwing

A modern and simple Kotlin DSL for Java Swing

### Usage

Creating a JFrame with a custom title and displaying it

```kotlin
frame("Test Application") {
    isVisible = true
    defaultCloseOperation = WindowConstants.EXIT_ON_CLOSE
}
```

Creating a JFrame with a custom title and JButton and displaying it

```kotlin
frame("Test Application") {
    button {
        text = "Hello World"
    }

    isVisible = true
    defaultCloseOperation = WindowConstants.EXIT_ON_CLOSE
}
```

**More documentation coming soon**