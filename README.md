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
    button("Hello World")

    quitOnClose()
    showFrame()
}
```

Adding a JPanel to a JFrame

```kotlin
frame("Test Application") {
    panel {
        label("Hello World")
    }
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

Setting the font of a label or any other component

```kotlin
label("My label") {
    font {
        size = 17
        weight = Font.BOLD
    }

    // Alternatively, you could do font(size = 17, weight = Font.BOLD)
}
```

**For a full example of what KSwing can do, check out
the [example class](https://github.com/dreamhopping/KSwing/blob/master/src/test/kotlin/dev/dreamhopping/kswing/KSwingExample.kt)**