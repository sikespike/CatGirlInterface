/**
 * 
 */
package com.cbg.core.geometry.mmd;

import java.util.List;

/**
 * @author Siebe
 *
 */
public class MMDIk {
    private MMDBone bone;
    private MMDBone targetBone;
    private int numLinks;
    private int itCount;
    private float maxAngle;
    private List<MMDBone> childBoneList;
    
    /**
     * @return the bone
     */
    public MMDBone getBone() {
        return bone;
    }
    /**
     * @param bone the bone to set
     */
    public void setBone(MMDBone bone) {
        this.bone = bone;
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
    /**
     * @return the numLinks
     */
    public int getNumLinks() {
        return numLinks;
    }
    /**
     * @param numLinks the numLinks to set
     */
    public void setNumLinks(int numLinks) {
        this.numLinks = numLinks;
    }
    /**
     * @return the itCount
     */
    public int getItCount() {
        return itCount;
    }
    /**
     * @param itCount the itCount to set
     */
    public void setItCount(int itCount) {
        this.itCount = itCount;
    }
    /**
     * @return the maxAngle
     */
    public float getMaxAngle() {
        return maxAngle;
    }
    /**
     * @param maxAngle the maxAngle to set
     */
    public void setMaxAngle(float maxAngle) {
        this.maxAngle = maxAngle;
    }
    /**
     * @return the childBoneList
     */
    public List<MMDBone> getChildBoneList() {
        return childBoneList;
    }
    /**
     * @param childBoneList the childBoneList to set
     */
    public void setChildBoneList(List<MMDBone> childBoneList) {
        this.childBoneList = childBoneList;
    }
}
