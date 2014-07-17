/**
 * 
 */
package com.cbg.core.geometry.mmd;

import java.util.List;

/**
 * @author Siebe
 *
 */
public class MMDVertexMorph {
    private String name;
    private Long type;
    private List<MMDMorphData> morphData;
    /**
     * @return the name
     */
    public String getName() {
        return name;
    }
    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }
    /**
     * @return the type
     */
    public Long getType() {
        return type;
    }
    /**
     * @param type the type to set
     */
    public void setType(Long type) {
        this.type = type;
    }
    /**
     * @return the morphData
     */
    public List<MMDMorphData> getMorphData() {
        return morphData;
    }
    /**
     * @param morphData the morphData to set
     */
    public void setMorphData(List<MMDMorphData> morphData) {
        this.morphData = morphData;
    }
}
