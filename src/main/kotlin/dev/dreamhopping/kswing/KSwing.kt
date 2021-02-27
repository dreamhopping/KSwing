package dev.dreamhopping.kswing

import java.awt.event.WindowAdapter
import java.awt.event.WindowEvent
import javax.swing.JButton
import javax.swing.JFrame
import javax.swing.WindowConstants


/**
 * Constructs a [JFrame]
 * The default size is 800x600, this can be defined manually by using [frame]
 */
fun frame(init: JFrame.() -> Unit): JFrame = frame(800, 600, init)

/**
 * Constructs a [JFrame] with a custom title
 *
 * @param title The title to display on the frame
 */
fun frame(title: String, init: JFrame.() -> Unit): JFrame {
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
fun frame(width: Int, height: Int, init: JFrame.() -> Unit): JFrame {
    val frame = JFrame()
    frame.apply(init)

    frame.setSize(width, height)
    return frame
}

/**
 * Constructs a [JButton] then adds it to the parent [JFrame]
 */
fun JFrame.button(init: JButton.() -> Unit): JButton {
    // Construct the button
    val button = JButton()
    button.apply(init)

    // Add the button to the frame and return it
    this.add(button)
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
 * @param action The code to call when the JFrame is closed
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
