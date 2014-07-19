/**
 * 
 */
package com.cbg.core.geometry;

/**
 * @author Xif
 * 
 */
public class Vector2 {
    private float x;
    private float y;

    public Vector2(){
        this.x = 0.0f;
        this.y = 0.0f;
    }
    
    public Vector2(float[] vector){
        if(vector.length == 2){
            this.x = vector[0];
            this.y = vector[1];
        } else {
            throw new RuntimeException("Vector provided is of size:"+vector.length);
        }
    }
    
    @Override
    public String toString(){
        StringBuilder b = new StringBuilder();
        
        b.append("{x:").append(this.x).append(",y:").append(this.y).append("}");
        
        return b.toString();
    }
    
    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

}
