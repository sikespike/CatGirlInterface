/**
 * 
 */
package com.cbg.core.geometry.mmd;

/**
 * @author Siebe
 *
 */
public class MMDBone {
    private String boneName;
    private int parentBone;
    private int childBone;
    private MMDBoneType boneType;
    private int targetBone;
    
    private float x;
    private float y;
    private float z;
    /**
     * @return the boneName
     */
    public String getBoneName() {
        return boneName;
    }
    /**
     * @param boneName the boneName to set
     */
    public void setBoneName(String boneName) {
        this.boneName = boneName;
    }
    /**
     * @return the parentBone
     */
    public int getParentBone() {
        return parentBone;
    }
    /**
     * @param parentBone the parentBone to set
     */
    public void setParentBone(int parentBone) {
        this.parentBone = parentBone;
    }
    /**
     * @return the childBone
     */
    public int getChildBone() {
        return childBone;
    }
    /**
     * @param childBone the childBone to set
     */
    public void setChildBone(int childBone) {
        this.childBone = childBone;
    }
    /**
     * @return the boneType
     */
    public MMDBoneType getBoneType() {
        return boneType;
    }
    /**
     * @param boneType the boneType to set
     */
    public void setBoneType(MMDBoneType boneType) {
        this.boneType = boneType;
    }
    /**
     * @return the targetBone
     */
    public int getTargetBone() {
        return targetBone;
    }
    /**
     * @param targetBone the targetBone to set
     */
    public void setTargetBone(int targetBone) {
        this.targetBone = targetBone;
    }
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
}
