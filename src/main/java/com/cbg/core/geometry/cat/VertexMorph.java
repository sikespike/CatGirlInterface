/**
 * 
 */
package com.cbg.core.geometry.cat;

import java.util.List;

import com.cbg.core.util.StringUtil;

/**
 * @author Siebe
 * 
 */
public class VertexMorph {
    private String name;
    private int type;
    private List<MorphData> data;

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        StringBuilder b = new StringBuilder();

        b.append("{");

        b.append(StringUtil.jsonParamater("name", this.name)).append(",type:")
                .append(this.type)
                .append(StringUtil.jsonParamater("data", this.data));

        b.append("}");

        return b.toString();
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name
     *            the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the type
     */
    public int getType() {
        return type;
    }

    /**
     * @param type
     *            the type to set
     */
    public void setType(int type) {
        this.type = type;
    }

    /**
     * @return the data
     */
    public List<MorphData> getData() {
        return data;
    }

    /**
     * @param data
     *            the data to set
     */
    public void setData(List<MorphData> data) {
        this.data = data;
    }
}
