package dev.dreamhopping.kswing

import javax.swing.WindowConstants

/**
 * A demo class for KSwing
 *
 * @author Conor Byrne (dreamhopping)
 */
fun main(args: Array<String>) {
    // Create a simple frame and display it
    frame("Test Application") {
        button {
            text = "Hello World"
        }

        isVisible = true
        defaultCloseOperation = WindowConstants.EXIT_ON_CLOSE
    }
}
