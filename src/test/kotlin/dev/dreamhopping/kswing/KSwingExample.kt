package dev.dreamhopping.kswing

import java.awt.FlowLayout
import java.awt.Font


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
        // Set the layout
        layout = FlowLayout()

        // Add components
        label("Welcome to KSwing") {
            font(size = 20, weight = Font.BOLD)
        }

        button("Show Dialog") {
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
                            this@dialog.isVisible = false
                        }
                    }
                }
            }
        }

        // Show the frame
        exitOnClose()
        showFrame()
    }
}
