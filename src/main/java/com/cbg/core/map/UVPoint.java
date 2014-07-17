/**
 * 
 */
package com.cbg.core.map;

/**
 * @author Siebe
 *
 */
public class UVPoint{

    private double x;
    private double y;
    
    /**
     * 
     */
    public UVPoint() {
        this.x=0;
        this.y=0;
    }

    public UVPoint(double x, double y){
        this.x=x;
        this.y=y;
    }

    /**
     * @return the x
     */
    public double getX() {
        return x;
    }

    /**
     * @param x the x to set
     */
    public void setX(double x) {
        this.x = x;
    }

    /**
     * @return the y
     */
    public double getY() {
        return y;
    }

    /**
     * @param y the y to set
     */
    public void setY(double y) {
        this.y = y;
    }
    
    
}
