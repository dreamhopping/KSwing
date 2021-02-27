package dev.dreamhopping.kswing

import java.awt.Font
import java.awt.Insets
import javax.swing.BoxLayout
import javax.swing.border.EmptyBorder


/**
 * A demo for KSwing
 *
 * @author Conor Byrne (dreamhopping)
 */
fun main(args: Array<String>) {
    // Create a simple frame and display it
    frame("Test Application") {
        // Create the panel
        panel {
            // Setup the layout of the panel
            layout = BoxLayout(this, BoxLayout.Y_AXIS)
            border = EmptyBorder(Insets(50, 80, 50, 80))

            // Add a button to the frame
            button("Hello World") {
                onClick {
                    println("Hello World")
                }

                centerHorizontally()
            }

            // Add a label to the frame
            label("This is a label") {
                centerHorizontally()
            }

            // Add another label to the frame with some style
            label("This is another label, it is bigger and bolder!") {
                // Alternatively, you could do this: font(size = 16, weight = Font.BOLD)
                font {
                    size = 16
                    weight = Font.BOLD
                }

                centerHorizontally()
            }
        }

        // Print a string when the frame is closed
        onClose {
            println("Goodbye :(")
        }

        // Tell it to kill the process when it is closed & show the frame
        quitOnClose()
        showFrame()
    }
}
