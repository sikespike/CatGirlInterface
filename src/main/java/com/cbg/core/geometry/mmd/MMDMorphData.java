/**
 * 
 */
package com.cbg.core.geometry.mmd;

import com.cbg.core.geometry.Vector;

/**
 * @author Siebe
 *
 */
public class MMDMorphData {
    private int index;
    private Vector offset;
    /**
     * @return the index
     */
    public int getIndex() {
        return index;
    }
    /**
     * @param index the index to set
     */
    public void setIndex(int index) {
        this.index = index;
    }
    /**
     * @return the offset
     */
    public Vector getOffset() {
        return offset;
    }
    /**
     * @param offset the offset to set
     */
    public void setOffset(Vector offset) {
        this.offset = offset;
    }
}
