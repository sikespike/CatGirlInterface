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
    private int ikBoneIndex;
    private int ikTailBoneIndex;
    private int numLinks;
    private int itCount;
    private float maxAngle;
    private List<Long> polyIndexList;
    /**
     * @return the ikBoneIndex
     */
    public int getIkBoneIndex() {
        return ikBoneIndex;
    }
    /**
     * @param ikBoneIndex the ikBoneIndex to set
     */
    public void setIkBoneIndex(int ikBoneIndex) {
        this.ikBoneIndex = ikBoneIndex;
    }
    /**
     * @return the ikTailBoneIndex
     */
    public int getIkTailBoneIndex() {
        return ikTailBoneIndex;
    }
    /**
     * @param ikTailBoneIndex the ikTailBoneIndex to set
     */
    public void setIkTailBoneIndex(int ikTailBoneIndex) {
        this.ikTailBoneIndex = ikTailBoneIndex;
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
     * @return the polyIndexList
     */
    public List<Long> getPolyIndexList() {
        return polyIndexList;
    }
    /**
     * @param polyIndexList the polyIndexList to set
     */
    public void setPolyIndexList(List<Long> polyIndexList) {
        this.polyIndexList = polyIndexList;
    }
}
