/**
 * 
 */
package com.cbg.core.geometry.cat;

import java.util.List;

import com.cbg.core.geometry.Vector;
import com.cbg.core.util.StringUtil;

/**
 * @author Siebe
 * 
 */
public class MorphData {
    private long index;
    private List<Vector> offset;

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        StringBuilder b = new StringBuilder();

        b.append("{");
        b.append("index:").append(this.index).append(",offset:")
                .append(StringUtil.serializeJsonList(this.offset));
        b.append("}");

        return b.toString();
    }

    /**
     * @return the index
     */
    public long getIndex() {
        return index;
    }

    /**
     * @param index
     *            the index to set
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
     * @param offset
     *            the offset to set
     */
    public void setOffset(List<Vector> offset) {
        this.offset = offset;
    }
}
