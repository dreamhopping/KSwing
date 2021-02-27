## KSwing

A modern and simple Kotlin DSL for Java Swing

### Using in your projects

#### Gradle (Kotlin)

- Add the JitPack Repository

```groovy
repositories {
    maven(url = "https://jitpack.io")
}
```

- Add the dependency

```groovy
dependencies {
    // Use -SNAPSHOT for the latest
    implementation("com.github.dreamhopping:KSwing:-SNAPSHOT")
}
```

#### Gradle (Groovy)

- Add the JitPack Repository

```groovy
repositories {
    maven {
        url = "https://jitpack.io"
    }
}
```

- Add the dependency

```groovy
dependencies {
    // Use -SNAPSHOT for the latest
    implementation "com.github.dreamhopping:KSwing:-SNAPSHOT"
}
```

#### Maven

- Add the JitPack Repository

```xml

<repository>
    <id>jitpack.io</id>
    <url>https://jitpack.io</url>
</repository>
```

- Add the dependency

```xml
<!-- -Use -SNAPSHOT for latest -->
<dependency>
    <groupId>com.github.dreamhopping</groupId>
    <artifactId>KSwing</artifactId>
    <version>-SNAPSHOT</version>
</dependency>
```

### Examples

*To see all the features inside KSwing, check out
the [example class](https://github.com/dreamhopping/KSwing/blob/master/src/test/kotlin/dev/dreamhopping/kswing/KSwingExample.kt)*

**Creating a JFrame with a custom title and displaying it**

```kotlin
frame("Test Application") {
    showFrame()
}
```

**Creating a button inside of a JFrame**

```kotlin
frame("Test Application") {
    button("Hello World")

    showFrame()
}
```

**Adding a JPanel to a JFrame**

```kotlin
frame("My frame") {
    panel {
        // Components, etc. go here
    }
}
```

**Running code when the frame is closed**

```kotlin
frame("My frame") {
    onClose {
        println("Frame has been closed!")
    }
}
```

**Setting the font of a label, or any other component**

```kotlin
label("My label") {
    font(size = 17, weight = Font.BOLD)
}
```

**Showing a JDialog**

```kotlin
dialog("My dialog") {
    label("Hello world!")
} 
```
