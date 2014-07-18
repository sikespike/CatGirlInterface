/**
 * 
 */
package com.cbg.core.geometry.mmd;

/**
 * @author Siebe
 *
 */
public class MMDBone {
    private String name;
    private int parentBoneIndex;
    private int childBoneIndex;
    private MMDBoneType boneType;
    private int targetBoneIndex;
    
    private float x;
    private float y;
    private float z;
    
    private MMDBone parentBone;
    private MMDBone childBone;
    private MMDBone targetBone;
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
     * @return the parentBoneIndex
     */
    public int getParentBoneIndex() {
        return parentBoneIndex;
    }
    /**
     * @param parentBoneIndex the parentBoneIndex to set
     */
    public void setParentBoneIndex(int parentBoneIndex) {
        this.parentBoneIndex = parentBoneIndex;
    }
    /**
     * @return the childBoneIndex
     */
    public int getChildBoneIndex() {
        return childBoneIndex;
    }
    /**
     * @param childBoneIndex the childBoneIndex to set
     */
    public void setChildBoneIndex(int childBoneIndex) {
        this.childBoneIndex = childBoneIndex;
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
     * @return the targetBoneIndex
     */
    public int getTargetBoneIndex() {
        return targetBoneIndex;
    }
    /**
     * @param targetBoneIndex the targetBoneIndex to set
     */
    public void setTargetBoneIndex(int targetBoneIndex) {
        this.targetBoneIndex = targetBoneIndex;
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
    /**
     * @return the parentBone
     */
    public MMDBone getParentBone() {
        return parentBone;
    }
    /**
     * @param parentBone the parentBone to set
     */
    public void setParentBone(MMDBone parentBone) {
        this.parentBone = parentBone;
    }
    /**
     * @return the childBone
     */
    public MMDBone getChildBone() {
        return childBone;
    }
    /**
     * @param childBone the childBone to set
     */
    public void setChildBone(MMDBone childBone) {
        this.childBone = childBone;
    }
    /**
     * @return the targetBone
     */
    public MMDBone getTargetBone() {
        return targetBone;
    }
    /**
     * @param targetBone the targetBone to set
     */
    public void setTargetBone(MMDBone targetBone) {
        this.targetBone = targetBone;
    }
}
