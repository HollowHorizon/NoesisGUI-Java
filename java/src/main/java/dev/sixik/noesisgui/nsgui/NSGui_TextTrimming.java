package dev.sixik.noesisgui.nsgui;

/**
 * Describes how text is trimmed when it overflows the edge of its containing box
 */
public enum NSGui_TextTrimming {

    /**
     * Not trimmed
     */
    TextTrimming_None,

    /**
     * Trimmed at a character boundary. An ellipsis(...) is drawn in place of remaining text
     */
    TextTrimming_CharacterEllipsis,

    /**
     * Trimmed at a word boundary. An ellipsis(...) is drawn in place of remaining text
     */
    TextTrimming_WordEllipsis
}
