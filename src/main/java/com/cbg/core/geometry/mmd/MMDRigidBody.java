package com.cbg.core.geometry.mmd;

import com.cbg.studio.server.domain.geometry.Vector;

public class MMDRigidBody {
    private int index;
    private String name;
    private MMDBone bone;
    private int collisionGroupId;
    private int collisionMaskId;
    private int shape;

    private Vector size;
    private Vector position;
    private Vector rotation;

    private float mass;
    private float velocityAtt;
    private float rotationAtt;
    private float bounce;
    private float friction;

    private int mode;

    /**
     * @return the index
     */
    public int getIndex() {
        return index;
    }

    /**
     * @param index
     *            the index to set
     */
    public void setIndex(int index) {
        this.index = index;
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
     * @return the bone
     */
    public MMDBone getBone() {
        return bone;
    }

    /**
     * @param bone
     *            the bone to set
     */
    public void setBone(MMDBone bone) {
        this.bone = bone;
    }

    /**
     * @return the collisionGroupId
     */
    public int getCollisionGroupId() {
        return collisionGroupId;
    }

    /**
     * @param collisionGroupId
     *            the collisionGroupId to set
     */
    public void setCollisionGroupId(int collisionGroupId) {
        this.collisionGroupId = collisionGroupId;
    }

    /**
     * @return the collisionMaskId
     */
    public int getCollisionMaskId() {
        return collisionMaskId;
    }

    /**
     * @param collisionMaskId
     *            the collisionMaskId to set
     */
    public void setCollisionMaskId(int collisionMaskId) {
        this.collisionMaskId = collisionMaskId;
    }

    /**
     * @return the shape
     */
    public int getShape() {
        return shape;
    }

    /**
     * @param shape
     *            the shape to set
     */
    public void setShape(int shape) {
        this.shape = shape;
    }

    /**
     * @return the size
     */
    public Vector getSize() {
        return size;
    }

    /**
     * @param size
     *            the size to set
     */
    public void setSize(Vector size) {
        this.size = size;
    }

    /**
     * @return the position
     */
    public Vector getPosition() {
        return position;
    }

    /**
     * @param position
     *            the position to set
     */
    public void setPosition(Vector position) {
        this.position = position;
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
     * @return the mass
     */
    public float getMass() {
        return mass;
    }

    /**
     * @param mass
     *            the mass to set
     */
    public void setMass(float mass) {
        this.mass = mass;
    }

    /**
     * @return the velocityAtt
     */
    public float getVelocityAtt() {
        return velocityAtt;
    }

    /**
     * @param velocityAtt
     *            the velocityAtt to set
     */
    public void setVelocityAtt(float velocityAtt) {
        this.velocityAtt = velocityAtt;
    }

    /**
     * @return the rotationAtt
     */
    public float getRotationAtt() {
        return rotationAtt;
    }

    /**
     * @param rotationAtt
     *            the rotationAtt to set
     */
    public void setRotationAtt(float rotationAtt) {
        this.rotationAtt = rotationAtt;
    }

    /**
     * @return the bounce
     */
    public float getBounce() {
        return bounce;
    }

    /**
     * @param bounce
     *            the bounce to set
     */
    public void setBounce(float bounce) {
        this.bounce = bounce;
    }

    /**
     * @return the friction
     */
    public float getFriction() {
        return friction;
    }

    /**
     * @param friction
     *            the friction to set
     */
    public void setFriction(float friction) {
        this.friction = friction;
    }

    /**
     * @return the mode
     */
    public int getMode() {
        return mode;
    }

    /**
     * @param mode
     *            the mode to set
     */
    public void setMode(int mode) {
        this.mode = mode;
    }
}
