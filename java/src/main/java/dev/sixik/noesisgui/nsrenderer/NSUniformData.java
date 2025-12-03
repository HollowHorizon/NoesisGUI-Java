package dev.sixik.noesisgui.nsrenderer;

/**
 * Uniform shader values. For unused buffers, 'values' is set to null and 'numDwords' is zero.
 * A hash for the content is given to avoid unnecessary constant buffer updates
 */
public class NSUniformData {

    public long ptr;
    public int numDwords;
    public int hash;
}
