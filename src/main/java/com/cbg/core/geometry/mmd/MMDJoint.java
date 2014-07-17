/**
 * 
 */
package com.cbg.core.geometry.mmd;

import com.cbg.core.geometry.Vector;

/**
 * @author Siebe
 *
 */
public class MMDJoint {
    private String name;
    private Long sourceRId;
    private Long destRId;
    private Vector location;
    private Vector rotation;
    private Vector minLoc;
    private Vector maxLoc;
    private Vector minRot;
    private Vector maxRot;
    private Vector springConst;
    private Vector springRotConst;
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
     * @return the sourceRId
     */
    public Long getSourceRId() {
        return sourceRId;
    }
    /**
     * @param sourceRId the sourceRId to set
     */
    public void setSourceRId(Long sourceRId) {
        this.sourceRId = sourceRId;
    }
    /**
     * @return the destRId
     */
    public Long getDestRId() {
        return destRId;
    }
    /**
     * @param destRId the destRId to set
     */
    public void setDestRId(Long destRId) {
        this.destRId = destRId;
    }
    /**
     * @return the location
     */
    public Vector getLocation() {
        return location;
    }
    /**
     * @param location the location to set
     */
    public void setLocation(Vector location) {
        this.location = location;
    }
    /**
     * @return the rotation
     */
    public Vector getRotation() {
        return rotation;
    }
    /**
     * @param rotation the rotation to set
     */
    public void setRotation(Vector rotation) {
        this.rotation = rotation;
    }
    /**
     * @return the minLoc
     */
    public Vector getMinLoc() {
        return minLoc;
    }
    /**
     * @param minLoc the minLoc to set
     */
    public void setMinLoc(Vector minLoc) {
        this.minLoc = minLoc;
    }
    /**
     * @return the maxLoc
     */
    public Vector getMaxLoc() {
        return maxLoc;
    }
    /**
     * @param maxLoc the maxLoc to set
     */
    public void setMaxLoc(Vector maxLoc) {
        this.maxLoc = maxLoc;
    }
    /**
     * @return the minRot
     */
    public Vector getMinRot() {
        return minRot;
    }
    /**
     * @param minRot the minRot to set
     */
    public void setMinRot(Vector minRot) {
        this.minRot = minRot;
    }
    /**
     * @return the maxRot
     */
    public Vector getMaxRot() {
        return maxRot;
    }
    /**
     * @param maxRot the maxRot to set
     */
    public void setMaxRot(Vector maxRot) {
        this.maxRot = maxRot;
    }
    /**
     * @return the springConst
     */
    public Vector getSpringConst() {
        return springConst;
    }
    /**
     * @param springConst the springConst to set
     */
    public void setSpringConst(Vector springConst) {
        this.springConst = springConst;
    }
    /**
     * @return the springRotConst
     */
    public Vector getSpringRotConst() {
        return springRotConst;
    }
    /**
     * @param springRotConst the springRotConst to set
     */
    public void setSpringRotConst(Vector springRotConst) {
        this.springRotConst = springRotConst;
    }
}
