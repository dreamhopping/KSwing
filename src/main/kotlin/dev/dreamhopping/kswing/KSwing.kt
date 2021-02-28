package dev.dreamhopping.kswing

import dev.dreamhopping.kswing.font.KSwingFontBuilder
import java.awt.Container
import java.awt.Font
import java.awt.event.WindowAdapter
import java.awt.event.WindowEvent
import javax.swing.*


/**
 * Constructs a [JFrame]
 *
 * @param width The width of the frame in pixels, default is 800
 * @param height The height of the frame in pixels, default is 600
 * @param title The title to display on the window of the JFrame, default is null
 */
inline fun frame(title: String? = null, width: Int = 800, height: Int = 600, init: JFrame.() -> Unit = {}): JFrame {
    val frame = JFrame()
    frame.apply(init)

    frame.title = title
    frame.setSize(width, height)
    return frame
}

/**
 * Constructs a [JPanel]
 */
inline fun panel(init: JPanel.() -> Unit = {}) = JPanel().apply(init)

/**
 * Constructs a [JDialog] and automatically sets it to visible if [showDialog] is true
 *
 * @param showDialog If the dialog should be automatically shown when created, default is true
 */
inline fun dialog(
    title: String? = null,
    width: Int = 400,
    height: Int = 300,
    showDialog: Boolean = true,
    init: JDialog.() -> Unit = {}
): JDialog {
    val dialog = JDialog().apply(init)

    dialog.title = title
    dialog.setSize(width, height)
    dialog.isVisible = showDialog

    return dialog
}

/**
 * Constructs a [JPanel] and adds it to the parent [JFrame]
 */
inline fun JFrame.panel(layout: String? = null, init: JPanel.() -> Unit = {}): JPanel {
    val panel = JPanel().apply(init)

    this.add(panel, layout)
    return panel
}

/**
 * Constructs a [JButton] with optional custom text, then adds it to the parent [Container]
 *
 * @param text The text to display on the button
 */
inline fun Container.button(text: String? = null, layout: String? = null, init: JButton.() -> Unit = {}): JButton {
    // Construct the button & modify the text
    val button = JButton().apply(init)
    button.text = text

    this.add(button, layout)
    return button
}

/**
 * Constructs a [JLabel] with optional custom text, then adds it to the parent [Container]
 *
 * @param text The text to display on the label
 */
inline fun Container.label(text: String? = null, layout: String? = null, init: JLabel.() -> Unit = {}): JLabel {
    val label = JLabel().apply(init)
    label.text = text

    this.add(label, layout)
    return label
}

/**
 * Constructs a [JMenuBar], then adds it to the parent [Container]
 */
inline fun Container.menuBar(layout: String? = null, init: JMenuBar.() -> Unit): JMenuBar {
    val menuBar = JMenuBar().apply(init)

    this.add(menuBar, layout)
    return menuBar
}

/**
 * Constructs a [JMenu] with optional custom text, then adds it to the parent [JMenuBar]
 *
 * @param text The text to be displayed on the menu item, default to null
 */
inline fun JMenuBar.menu(text: String? = null, init: JMenu.() -> Unit): JMenu {
    val menu = JMenu(text).apply(init)

    this.add(menu)
    return menu
}

/**
 * Constructs a [JMenuItem] with optional custom text, then adds it to the parent [JMenu]
 *
 * @param text The text to be displayed on the menu item, default to null
 */
inline fun JMenu.menuItem(text: String? = null, init: JMenuItem.() -> Unit): JMenuItem {
    val menuItem = JMenuItem(text).apply(init)

    this.add(menuItem)
    return menuItem
}

/**
 * A wrapper for [JMenu.addActionListener] to make the code more understandable, onClick is a more suitable name
 */
inline fun JMenuItem.onClick(crossinline action: () -> Unit) = addActionListener { action() }

/**
 * Sets [JFrame.defaultCloseOperation] to [WindowConstants.EXIT_ON_CLOSE]
 */
fun JFrame.exitOnClose() {
    this.defaultCloseOperation = WindowConstants.EXIT_ON_CLOSE
}

/**
 * Calls [JFrame.setVisible] to display the frame, a bit cleaner than the property access syntax
 */
fun JFrame.showFrame() {
    isVisible = true
}

/**
 * Calls [UIManager.setLookAndFeel] to use the [UIManager.getSystemLookAndFeelClassName] as the look and feel
 */
fun useSystemLookAndFeel() = UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName())

/**
 * Calls the supplied action when the [JFrame] is closed
 */
inline fun JFrame.onClose(crossinline action: () -> Unit = {}) {
    addWindowListener(object : WindowAdapter() {
        override fun windowClosing(e: WindowEvent) {
            action()
        }
    })
}

/**
 * A wrapper for [JButton.addActionListener] to make the code more understandable, onClick is a more suitable name
 */
inline fun JButton.onClick(crossinline action: () -> Unit) = addActionListener { action() }

/**
 * Sets the [JComponent.font] property using [KSwingFontBuilder]
 */
inline fun JComponent.font(init: KSwingFontBuilder.() -> Unit = {}) {
    font = KSwingFontBuilder().apply(init).build()
}

/**
 * Sets the [JComponent.font] property using [KSwingFontBuilder]
 *
 * @param name The name of the font, default to the property's existing font name
 * @param weight The weight of the font, default to [Font.PLAIN]
 * @param size The size of the font, default to the property's existing font size
 */
fun JComponent.font(name: String = font.name, weight: Int = Font.PLAIN, size: Int = font.size) {
    font = KSwingFontBuilder(name, weight, size).build()
}
