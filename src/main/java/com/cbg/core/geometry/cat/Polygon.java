/**
 * 
 */
package com.cbg.core.geometry.cat;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Siebe
 *
 */
public abstract class Polygon {
    protected List<Vertex> verts;
    
    public Polygon(){
        verts = new ArrayList<Vertex>();
    }
    
    public Polygon(List<Vertex> verts){
        this.verts = verts;
    }
    
    public void addVertex(Vertex v){
        if(verts == null){
            verts = new ArrayList<Vertex>();
        }
        
        verts.add(v);
    }

    /**
     * @return the verts
     */
    public List<Vertex> getVerticies() {
        return verts;
    }

    /**
     * @param verts the verts to set
     */
    public void setVerticies(List<Vertex> verticies) {
        this.verts = verticies;
    }
    
    @Override
    public String toString(){
        StringBuilder b = new StringBuilder();
        
        b.append("{polygon:[");
        for(int x=0;x<this.verts.size();x++){
            Vertex v = this.verts.get(x);
            
            b.append(v.toString());
            
            if(x+1 != this.verts.size()){
                b.append(",");
            }
        }
        b.append("]}");
        
        return b.toString();
    }
}
