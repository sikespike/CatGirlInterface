 /**
 * 
 */
package com.cbg.core.geometry.cat;

import java.util.List;

import com.cbg.core.geometry.Vector;

/**
 * @author Siebe
 *
 */
public class MorphData {
    private long index;
    private List<Vector> offset;
    /**
     * @return the index
     */
    public long getIndex() {
        return index;
    }
    /**
     * @param index the index to set
     */
    public void setIndex(long index) {
        this.index = index;
    }
    /**
     * @return the offset
     */
    public List<Vector> getOffset() {
        return offset;
    }
    /**
     * @param offset the offset to set
     */
    public void setOffset(List<Vector> offset) {
        this.offset = offset;
    }
}
