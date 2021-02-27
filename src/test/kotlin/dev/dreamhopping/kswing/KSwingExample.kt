package dev.dreamhopping.kswing

/**
 * A demo for KSwing
 *
 * @author Conor Byrne (dreamhopping)
 */
fun main(args: Array<String>) {
    // Create a simple frame and display it
    frame("Test Application") {
        // Add a button to the frame
        button {
            text = "Hello World"

            onClick {
                println("Hello World")
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
