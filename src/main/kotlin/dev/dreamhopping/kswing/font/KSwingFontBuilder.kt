package dev.dreamhopping.kswing.font

import dev.dreamhopping.kswing.font
import java.awt.Font
import javax.swing.JLabel

/**
 * A builder class for [Font], used for setting a font for a [JComponent] with the [font] function
 *
 * @author Conor Byrne (dreamhopping)
 */
class KSwingFontBuilder(
    /**
     * The name of the font used, this is default to Swing's default font
     */
    var name: String? = null,

    /**
     * The weight of the font, this is default to [Font.PLAIN]
     */
    var weight: Int = Font.PLAIN,

    /**
     * The size of the font, this is default to the default font size for a [JLabel]
     */
    var size: Int = JLabel().font.size
) {
    fun build() = Font(name, weight, size)
}
