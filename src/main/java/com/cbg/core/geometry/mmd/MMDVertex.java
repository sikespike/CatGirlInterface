/**
 * 
 */
package com.cbg.core.geometry.mmd;

/**
 * @author Siebe
 *
 */
public class MMDVertex {
    private float x;
    private float y;
    private float z;
    
    private float xn;
    private float yn;
    private float zn;
    
    private float u;
    private float v;
    
    private int bone0Index;
    private int bone1Index;
    
    private int bone0Weight;
    private int edgeFlag;
    /**
     * @return the x
     */
    public float getX() {
        return x;
    }
    /**
     * @param x the x to set
     */
    public void setX(float x) {
        this.x = x;
    }
    /**
     * @return the y
     */
    public float getY() {
        return y;
    }
    /**
     * @param y the y to set
     */
    public void setY(float y) {
        this.y = y;
    }
    /**
     * @return the z
     */
    public float getZ() {
        return z;
    }
    /**
     * @param z the z to set
     */
    public void setZ(float z) {
        this.z = z;
    }
    /**
     * @return the xn
     */
    public float getXn() {
        return xn;
    }
    /**
     * @param xn the xn to set
     */
    public void setXn(float xn) {
        this.xn = xn;
    }
    /**
     * @return the yn
     */
    public float getYn() {
        return yn;
    }
    /**
     * @param yn the yn to set
     */
    public void setYn(float yn) {
        this.yn = yn;
    }
    /**
     * @return the zn
     */
    public float getZn() {
        return zn;
    }
    /**
     * @param zn the zn to set
     */
    public void setZn(float zn) {
        this.zn = zn;
    }
    /**
     * @return the u
     */
    public float getU() {
        return u;
    }
    /**
     * @param u the u to set
     */
    public void setU(float u) {
        this.u = u;
    }
    /**
     * @return the v
     */
    public float getV() {
        return v;
    }
    /**
     * @param v the v to set
     */
    public void setV(float v) {
        this.v = v;
    }
    /**
     * @return the bone0Index
     */
    public int getBone0Index() {
        return bone0Index;
    }
    /**
     * @param bone0Index the bone0Index to set
     */
    public void setBone0Index(int bone0Index) {
        this.bone0Index = bone0Index;
    }
    /**
     * @return the bone1Index
     */
    public int getBone1Index() {
        return bone1Index;
    }
    /**
     * @param bone1Index the bone1Index to set
     */
    public void setBone1Index(int bone1Index) {
        this.bone1Index = bone1Index;
    }
    /**
     * @return the bone0Weight
     */
    public int getBone0Weight() {
        return bone0Weight;
    }
    /**
     * @param bone0Weight the bone0Weight to set
     */
    public void setBone0Weight(int bone0Weight) {
        this.bone0Weight = bone0Weight;
    }
    /**
     * @return the edgeFlag
     */
    public int getEdgeFlag() {
        return edgeFlag;
    }
    /**
     * @param edgeFlag the edgeFlag to set
     */
    public void setEdgeFlag(int edgeFlag) {
        this.edgeFlag = edgeFlag;
    }
}
