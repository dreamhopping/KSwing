package dev.dreamhopping.kswing

import java.awt.Component
import java.awt.Container
import java.awt.event.WindowAdapter
import java.awt.event.WindowEvent
import javax.swing.*


/**
 * Constructs a [JFrame]
 * The default size is 800x600, this can be defined manually by using [frame]
 */
fun frame(init: JFrame.() -> Unit = {}): JFrame = frame(800, 600, init)

/**
 * Constructs a [JFrame] with a custom title
 * The default size is 800x600, this can be defined manually by using [frame]
 *
 * @param title The title to display on the frame
 */
fun frame(title: String, init: JFrame.() -> Unit = {}): JFrame {
    val frame = frame(init)
    frame.title = title

    return frame
}

/**
 * Constructs a [JFrame] with a custom width and height
 *
 * @param width The width of the frame in pixels
 * @param height The height of the frame in pixels
 */
fun frame(width: Int, height: Int, init: JFrame.() -> Unit = {}): JFrame {
    val frame = JFrame()
    frame.apply(init)

    frame.setSize(width, height)
    return frame
}

/**
 * Constructs a [JButton] then adds it to the parent [JFrame]
 */
fun Container.button(init: JButton.() -> Unit = {}): JButton {
    // Construct the button
    val button = JButton()
    button.apply(init)

    // Add the button to the frame and return it
    this.add(button)
    return button
}

/**
 * Constructs a [JButton] with custom text, then adds it to the parent [JFrame]
 *
 * @param text The text to display on the button
 */
fun Container.button(text: String, init: JButton.() -> Unit = {}): JButton {
    // Construct the button & modify the text
    val button = button(init)
    button.text = text

    return button
}

/**
 * Sets the defaultCloseOperation to [WindowConstants.EXIT_ON_CLOSE]
 */
fun JFrame.quitOnClose() {
    this.defaultCloseOperation = WindowConstants.EXIT_ON_CLOSE
}

/**
 * Calls [JFrame.setVisible] to display the frame, a bit cleaner than the property access syntax
 */
fun JFrame.showFrame() {
    isVisible = true
}

/**
 * Calls the supplied action when the JFrame is closed
 *
 * @param action The code to run when the JFrame is closed
 */
fun JFrame.onClose(action: () -> Unit) {
    addWindowListener(object : WindowAdapter() {
        override fun windowClosing(e: WindowEvent) {
            action()
        }
    })
}

/**
 * A wrapper for [JButton.addActionListener] to make the code more understandable, onClick is a more suitable name
 */
fun JButton.onClick(action: () -> Unit) {
    addActionListener {
        action()
    }
}

/**
 * Constructs a [JLabel] then adds it to the parent [JFrame]
 */
fun Container.label(init: JLabel.() -> Unit = {}): JLabel {
    val label = JLabel()
    label.init()

    this.add(label)
    return label
}

/**
 * Constructs a [JLabel] with custom text, then adds it to the parent [JFrame]
 *
 * @param text The text to display on the label
 */
fun Container.label(text: String, init: JLabel.() -> Unit = {}): JLabel {
    val label = label(init)
    label.text = text

    return label
}

/**
 * Constructs a [JPanel]
 */
fun panel(init: JPanel.() -> Unit = {}) = JPanel().apply(init)

/**
 * Constructs a [JPanel] and adds it to the parent [JFrame]
 */
fun JFrame.panel(init: JPanel.() -> Unit = {}): JPanel {
    val panel = JPanel().apply(init)

    this.add(panel)
    return panel
}

/**
 * Sets the [JComponent.alignmentX] property to [Component.CENTER_ALIGNMENT], which will horizontally center the component
 */
fun JComponent.centerHorizontally() {
    alignmentX = Component.CENTER_ALIGNMENT
}

/**
 * Sets the [JComponent.alignmentY] property to [Component.CENTER_ALIGNMENT], which will horizontally center the component
 */
fun JComponent.centerVertically() {
    alignmentY = Component.CENTER_ALIGNMENT
}