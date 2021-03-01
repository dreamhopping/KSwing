package dev.dreamhopping.kswing

import java.awt.*
import javax.swing.Box
import javax.swing.BoxLayout

/**
 * A demo for KSwing
 *
 * @author Conor Byrne (dreamhopping)
 */
fun main(args: Array<String>) {
    // Set the look and feel
    useSystemLookAndFeel()

    // Create a JFrame
    frame("KSwing Demo Application", 1280, 720) {
        // Create a panel to be shown in the center of the frame
        panel(BorderLayout.CENTER) {
            // Set the layout to a box layout
            layout = BoxLayout(this, BoxLayout.Y_AXIS)

            // Add a bit of padding from the top
            add(Box.createRigidArea(Dimension(0, 10)))

            // Create a title label
            label("Welcome to KSwing") {
                font(size = 30, weight = Font.BOLD)
                alignmentX = Component.CENTER_ALIGNMENT
            }

            // Create a subtitle label
            label("This is an example showing the things that KSwing can do!") {
                font(size = 15)
                alignmentX = Component.CENTER_ALIGNMENT
            }
        }

        // Create a button which will display a dialog when clicked
        button("Show Dialog", BorderLayout.SOUTH) {
            // Set the font weight to bold
            font(size = 15)

            // Display a dialog when clicked
            onClick {
                dialog("Dialog") {
                    // Set the layout
                    layout = FlowLayout()

                    // Add an example label
                    label("This is a dialog") {
                        font(size = 17, weight = Font.ITALIC)
                    }

                    // Add a button to dismiss the dialog
                    button("Close") {
                        onClick {
                            this@dialog.dispose()
                        }
                    }
                }
            }
        }

        // Create a menu bar that has an item which will dispose of the frame
        menuBar(BorderLayout.NORTH) {
            menu("File") {
                menuItem("Exit") { onClick { this@frame.dispose() } }
            }
        }

        // Show the frame
        exitOnClose()
        showFrame()
    }
}
