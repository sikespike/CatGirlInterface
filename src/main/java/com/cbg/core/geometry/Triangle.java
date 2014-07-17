/**
 * 
 */
package com.cbg.core.geometry;

import java.util.List;

/**
 * @author Siebe
 * 
 */
public class Triangle extends Polygon {

    /**
     * @param verticies
     *            the verticies to set
     */
    @Override
    public void setVerticies(List<Vertex> verticies) {
        if (verticies != null && verticies.size() == 3) {
            this.verticies = verticies;
        } else {
            throw new RuntimeException("A triangle has to have 3 verticies.");
        }
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.cbg.core.geometry.Polygon#addVertex(com.cbg.core.geometry.Vertex)
     */
    @Override
    public void addVertex(Vertex v) {
        if (this.verticies == null || this.verticies.size() < 3) {
            super.addVertex(v);
        } else {
            throw new RuntimeException(
                    "A triangle cannot have more than 3 verticies.");
        }

    }

}
