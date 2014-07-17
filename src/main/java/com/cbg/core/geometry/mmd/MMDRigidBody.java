package com.cbg.core.geometry.mmd;

public class MMDRigidBody {
    private String name;
    private Long boneId;
    private Long collisionGroupId;
    private Long collisionMaskId;
    private Long shape;
    private float shapeWidth;
    private float shapeHeight;
    private float shapeDepth;
    
    private float x;
    private float y;
    private float z;
    
    private float rx;
    private float ry;
    private float rz;
    
    private float mass;
    private float linearDampCoef;
    private float angularDampCoef;
    private float recoilCoef;
    private float friction;
    
    private Long bodyType;

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
     * @return the boneId
     */
    public Long getBoneId() {
        return boneId;
    }

    /**
     * @param boneId the boneId to set
     */
    public void setBoneId(Long boneId) {
        this.boneId = boneId;
    }

    /**
     * @return the collisionGroupId
     */
    public Long getCollisionGroupId() {
        return collisionGroupId;
    }

    /**
     * @param collisionGroupId the collisionGroupId to set
     */
    public void setCollisionGroupId(Long collisionGroupId) {
        this.collisionGroupId = collisionGroupId;
    }

    /**
     * @return the collisionMaskId
     */
    public Long getCollisionMaskId() {
        return collisionMaskId;
    }

    /**
     * @param collisionMaskId the collisionMaskId to set
     */
    public void setCollisionMaskId(Long collisionMaskId) {
        this.collisionMaskId = collisionMaskId;
    }

    /**
     * @return the shape
     */
    public Long getShape() {
        return shape;
    }

    /**
     * @param shape the shape to set
     */
    public void setShape(Long shape) {
        this.shape = shape;
    }

    /**
     * @return the shapeWidth
     */
    public float getShapeWidth() {
        return shapeWidth;
    }

    /**
     * @param shapeWidth the shapeWidth to set
     */
    public void setShapeWidth(float shapeWidth) {
        this.shapeWidth = shapeWidth;
    }

    /**
     * @return the shapeHeight
     */
    public float getShapeHeight() {
        return shapeHeight;
    }

    /**
     * @param shapeHeight the shapeHeight to set
     */
    public void setShapeHeight(float shapeHeight) {
        this.shapeHeight = shapeHeight;
    }

    /**
     * @return the shapeDepth
     */
    public float getShapeDepth() {
        return shapeDepth;
    }

    /**
     * @param shapeDepth the shapeDepth to set
     */
    public void setShapeDepth(float shapeDepth) {
        this.shapeDepth = shapeDepth;
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
     * @return the rx
     */
    public float getRx() {
        return rx;
    }

    /**
     * @param rx the rx to set
     */
    public void setRx(float rx) {
        this.rx = rx;
    }

    /**
     * @return the ry
     */
    public float getRy() {
        return ry;
    }

    /**
     * @param ry the ry to set
     */
    public void setRy(float ry) {
        this.ry = ry;
    }

    /**
     * @return the rz
     */
    public float getRz() {
        return rz;
    }

    /**
     * @param rz the rz to set
     */
    public void setRz(float rz) {
        this.rz = rz;
    }

    /**
     * @return the mass
     */
    public float getMass() {
        return mass;
    }

    /**
     * @param mass the mass to set
     */
    public void setMass(float mass) {
        this.mass = mass;
    }

    /**
     * @return the linearDampCoef
     */
    public float getLinearDampCoef() {
        return linearDampCoef;
    }

    /**
     * @param linearDampCoef the linearDampCoef to set
     */
    public void setLinearDampCoef(float linearDampCoef) {
        this.linearDampCoef = linearDampCoef;
    }

    /**
     * @return the angularDampCoef
     */
    public float getAngularDampCoef() {
        return angularDampCoef;
    }

    /**
     * @param angularDampCoef the angularDampCoef to set
     */
    public void setAngularDampCoef(float angularDampCoef) {
        this.angularDampCoef = angularDampCoef;
    }

    /**
     * @return the recoilCoef
     */
    public float getRecoilCoef() {
        return recoilCoef;
    }

    /**
     * @param recoilCoef the recoilCoef to set
     */
    public void setRecoilCoef(float recoilCoef) {
        this.recoilCoef = recoilCoef;
    }

    /**
     * @return the friction
     */
    public float getFriction() {
        return friction;
    }

    /**
     * @param friction the friction to set
     */
    public void setFriction(float friction) {
        this.friction = friction;
    }

    /**
     * @return the bodyType
     */
    public Long getBodyType() {
        return bodyType;
    }

    /**
     * @param bodyType the bodyType to set
     */
    public void setBodyType(Long bodyType) {
        this.bodyType = bodyType;
    }
}
