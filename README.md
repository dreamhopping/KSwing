## KSwing

A modern and simple Kotlin DSL for Java Swing

### Usage

Creating a JFrame with a custom title and displaying it

```kotlin
frame("Test Application") {
    quitOnClose()
    showFrame()
}
```

Creating a JFrame with a custom title and JButton and displaying it

```kotlin
frame("Test Application") {
    button {
        text = "Hello World"
    }

    quitOnClose()
    showFrame()
}
```

Running code when the frame is closed

```kotlin
frame("Test Application") {
    ...
    
    onClose {
        // Do whatever you need to do here
        println("Frame has been closed!")
    }
}
```

**More documentation coming soon**