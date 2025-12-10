package dev.sixik.noesisgui.nsgui;

/**
 * Used to describe the position of an item that is managed by ItemContainerGenerator.
 * <p>
 * Examples:
 * <ul>
 *   <li>To start generating forward from the beginning of the item list, specify position (-1, 0)
 *       and direction Forward.</li>
 *   <li>To start generating backward from the end of the list, specify position (-1, 0) and
 *       direction Backward.</li>
 *   <li>To generate the items after the element with index k, specify position (k, 0) and
 *       direction Forward.</li>
 * </ul>
 */
public class NSGeneratorPosition {

    /**
     * Index, with respect to realized elements.  The special value -1 refers to a fictitious
     * element at the beginning or end of the the list
     */
    public int index;

    /**
     * Offset, with respect to unrealized items near the indexed element. An offset of 0 refers to
     * the indexed element itself, an offset of 1 refers to the next (unrealized) item, and an
     * offset of -1 refers to the previous item
     */
    public int offset;

    public NSGeneratorPosition() {
        this(0, 0);
    }

    public NSGeneratorPosition(int index, int offset) {
        this.index = index;
        this.offset = offset;
    }
}
