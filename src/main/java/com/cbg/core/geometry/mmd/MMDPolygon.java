/**
 * 
 */
package com.cbg.core.geometry.mmd;

import java.util.ArrayList;
import java.util.List;


/**
 * @author Siebe
 *
 */
public abstract class MMDPolygon {
    protected List<MMDVertex> verticies;

    /**
     * @return the verticies
     */
    public List<MMDVertex> getVerticies() {
        return verticies;
    }

    /**
     * @param verticies the verticies to set
     */
    public void setVerticies(List<MMDVertex> verticies) {
        this.verticies = verticies;
    }
    
    public void addVertex(MMDVertex v){
        if(this.verticies == null){
            this.verticies = new ArrayList<MMDVertex>();
        }
        v.setPoly(this);
        this.verticies.add(v);
    }
}
