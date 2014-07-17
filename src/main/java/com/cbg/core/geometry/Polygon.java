/**
 * 
 */
package com.cbg.core.geometry;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Siebe
 *
 */
public abstract class Polygon {
    protected List<Vertex> verticies;

    /**
     * @return the verticies
     */
    public List<Vertex> getVerticies() {
        return verticies;
    }

    /**
     * @param verticies the verticies to set
     */
    public void setVerticies(List<Vertex> verticies) {
        this.verticies = verticies;
    }
    
    public void addVertex(Vertex v){
        if(this.verticies == null){
            this.verticies = new ArrayList<Vertex>();
        }
        this.verticies.add(v);
    }
}
