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
    private MMDRigidBody sourceRigidBody;
    private MMDRigidBody destRigidBody;
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
     * @param name
     *            the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the sourceRigidBody
     */
    public MMDRigidBody getSourceRigidBody() {
        return sourceRigidBody;
    }

    /**
     * @param sourceRigidBody the sourceRigidBody to set
     */
    public void setSourceRigidBody(MMDRigidBody sourceRigidBody) {
        this.sourceRigidBody = sourceRigidBody;
    }

    /**
     * @return the destRigidBody
     */
    public MMDRigidBody getDestRigidBody() {
        return destRigidBody;
    }

    /**
     * @param destRigidBody the destRigidBody to set
     */
    public void setDestRigidBody(MMDRigidBody destRigidBody) {
        this.destRigidBody = destRigidBody;
    }

    /**
     * @return the location
     */
    public Vector getLocation() {
        return location;
    }

    /**
     * @param location
     *            the location to set
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
     * @param rotation
     *            the rotation to set
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
     * @param minLoc
     *            the minLoc to set
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
     * @param maxLoc
     *            the maxLoc to set
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
     * @param minRot
     *            the minRot to set
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
     * @param maxRot
     *            the maxRot to set
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
     * @param springConst
     *            the springConst to set
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
     * @param springRotConst
     *            the springRotConst to set
     */
    public void setSpringRotConst(Vector springRotConst) {
        this.springRotConst = springRotConst;
    }
}
