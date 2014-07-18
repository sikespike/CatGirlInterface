/**
 * 
 */
package com.cbg.core.geometry.cat;

/**
 * @author Siebe
 *
 */
public class Vertex {
    private float[] point;
    private float[] normal;
    
    private float[] uv;
    
    public Vertex(){
        this.point = initVector(4);
        this.normal = initVector(4);
        this.uv = initVector(2);
    }
    
    private float[] initVector(int size){
        float[] vector = new float[size];
        
        for(int x=0;x<size;x++){
            vector[x] = 0.0f;
        }
        
        return vector;
    }

    /**
     * @return the point
     */
    public float[] getPoint() {
        return point;
    }

    /**
     * @param point the point to set
     */
    public void setPoint(float[] point) {
        this.point = point;
    }

    /**
     * @return the normal
     */
    public float[] getNormal() {
        return normal;
    }

    /**
     * @param normal the normal to set
     */
    public void setNormal(float[] normal) {
        this.normal = normal;
    }

    /**
     * @return the uv
     */
    public float[] getUv() {
        return uv;
    }

    /**
     * @param uv the uv to set
     */
    public void setUv(float[] uv) {
        this.uv = uv;
    }
}
