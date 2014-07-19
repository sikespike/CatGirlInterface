/**
 * 
 */
package com.cbg.core.geometry.cat;

import java.io.Serializable;
import java.util.List;

import com.cbg.core.geometry.Vector;
import com.cbg.core.util.StringUtil;

/**
 * @author Siebe
 * 
 */
public class Joint implements Serializable{
    private static final long serialVersionUID = 1L;
    private String name;
    private RigidBody sourceRigidBody;
    private RigidBody destRigidBody;
    private List<Vector> location;
    private List<Vector> rotation;
    private List<Vector> minLoc;
    private List<Vector> maxLoc;
    private List<Vector> minRot;
    private List<Vector> maxRot;
    private List<Vector> springConst;
    private List<Vector> springRotConst;

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        StringBuilder b = new StringBuilder();

        b.append("{");
        b.append(StringUtil.jsonParamater("name", this.name))
                .append(",")
                .append(StringUtil.jsonParamater("sourceRigidBody",
                        this.sourceRigidBody))
                .append(",")
                .append(StringUtil.jsonParamater("location", this.location))
                .append(",")
                .append(StringUtil.jsonParamater("rotation", this.rotation))
                .append(",")
                .append(StringUtil.jsonParamater("minLoc", this.minLoc))
                .append(",")
                .append(StringUtil.jsonParamater("maxLoc", this.maxLoc))
                .append(",")
                .append(StringUtil.jsonParamater("minRot", this.minRot))
                .append(",")
                .append(StringUtil.jsonParamater("maxRot", this.maxRot))
                .append(",")
                .append(StringUtil.jsonParamater("maxRot", this.maxRot))
                .append(",")
                .append(StringUtil.jsonParamater("springConst",
                        this.springConst))
                .append(",")
                .append(StringUtil.jsonParamater("springRotConst",
                        this.springRotConst));
        b.append("}");

        return b.toString();
    }

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
    public RigidBody getSourceRigidBody() {
        return sourceRigidBody;
    }

    /**
     * @param sourceRigidBody
     *            the sourceRigidBody to set
     */
    public void setSourceRigidBody(RigidBody sourceRigidBody) {
        this.sourceRigidBody = sourceRigidBody;
    }

    /**
     * @return the destRigidBody
     */
    public RigidBody getDestRigidBody() {
        return destRigidBody;
    }

    /**
     * @param destRigidBody
     *            the destRigidBody to set
     */
    public void setDestRigidBody(RigidBody destRigidBody) {
        this.destRigidBody = destRigidBody;
    }

    /**
     * @return the location
     */
    public List<Vector> getLocation() {
        return location;
    }

    /**
     * @param location
     *            the location to set
     */
    public void setLocation(List<Vector> location) {
        this.location = location;
    }

    /**
     * @return the rotation
     */
    public List<Vector> getRotation() {
        return rotation;
    }

    /**
     * @param rotation
     *            the rotation to set
     */
    public void setRotation(List<Vector> rotation) {
        this.rotation = rotation;
    }

    /**
     * @return the minLoc
     */
    public List<Vector> getMinLoc() {
        return minLoc;
    }

    /**
     * @param minLoc
     *            the minLoc to set
     */
    public void setMinLoc(List<Vector> minLoc) {
        this.minLoc = minLoc;
    }

    /**
     * @return the maxLoc
     */
    public List<Vector> getMaxLoc() {
        return maxLoc;
    }

    /**
     * @param maxLoc
     *            the maxLoc to set
     */
    public void setMaxLoc(List<Vector> maxLoc) {
        this.maxLoc = maxLoc;
    }

    /**
     * @return the minRot
     */
    public List<Vector> getMinRot() {
        return minRot;
    }

    /**
     * @param minRot
     *            the minRot to set
     */
    public void setMinRot(List<Vector> minRot) {
        this.minRot = minRot;
    }

    /**
     * @return the maxRot
     */
    public List<Vector> getMaxRot() {
        return maxRot;
    }

    /**
     * @param maxRot
     *            the maxRot to set
     */
    public void setMaxRot(List<Vector> maxRot) {
        this.maxRot = maxRot;
    }

    /**
     * @return the springConst
     */
    public List<Vector> getSpringConst() {
        return springConst;
    }

    /**
     * @param springConst
     *            the springConst to set
     */
    public void setSpringConst(List<Vector> springConst) {
        this.springConst = springConst;
    }

    /**
     * @return the springRotConst
     */
    public List<Vector> getSpringRotConst() {
        return springRotConst;
    }

    /**
     * @param springRotConst
     *            the springRotConst to set
     */
    public void setSpringRotConst(List<Vector> springRotConst) {
        this.springRotConst = springRotConst;
    }
}
