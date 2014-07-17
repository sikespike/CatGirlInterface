package com.cbg.core.data;

import java.util.List;

import com.cbg.core.geometry.MMDBone;
import com.cbg.core.geometry.MMDDisplayBone;
import com.cbg.core.geometry.MMDIk;
import com.cbg.core.geometry.MMDRigidBody;
import com.cbg.core.geometry.Material;
import com.cbg.core.geometry.Triangle;
import com.cbg.core.geometry.Vertex;

public class MMDModel {
    private String fileVersion;
    private float versionNumber;
    private String modelName;
    private String modelComment;
    private List<Vertex> verticies;
    private List<Triangle> triangles;
    private List<Material> materials;
    private List<MMDBone> bones;
    private List<MMDIk> ikList;
    private List<String> boneGroupNames;
    private List<MMDDisplayBone> displayBoneList;
    private List<String> toonTextures;
    private List<MMDRigidBody> rigidBodyList;
    /**
     * @return the fileVersion
     */
    public String getFileVersion() {
        return fileVersion;
    }
    /**
     * @param fileVersion the fileVersion to set
     */
    public void setFileVersion(String fileVersion) {
        this.fileVersion = fileVersion;
    }
    /**
     * @return the versionNumber
     */
    public float getVersionNumber() {
        return versionNumber;
    }
    /**
     * @param versionNumber the versionNumber to set
     */
    public void setVersionNumber(float versionNumber) {
        this.versionNumber = versionNumber;
    }
    /**
     * @return the modelName
     */
    public String getModelName() {
        return modelName;
    }
    /**
     * @param modelName the modelName to set
     */
    public void setModelName(String modelName) {
        this.modelName = modelName;
    }
    /**
     * @return the modelComment
     */
    public String getModelComment() {
        return modelComment;
    }
    /**
     * @param modelComment the modelComment to set
     */
    public void setModelComment(String modelComment) {
        this.modelComment = modelComment;
    }
    /**
     * @return the verticies
     */
    public List<Vertex> getVerticies() {
        return verticies;
    }
    /**
     * @param verticies the verticies to set
     */
    public void setVerticies(List<Vertex> verticies) {
        this.verticies = verticies;
    }
    /**
     * @return the triangles
     */
    public List<Triangle> getTriangles() {
        return triangles;
    }
    /**
     * @param triangles the triangles to set
     */
    public void setTriangles(List<Triangle> triangles) {
        this.triangles = triangles;
    }
    /**
     * @return the materials
     */
    public List<Material> getMaterials() {
        return materials;
    }
    /**
     * @param materials the materials to set
     */
    public void setMaterials(List<Material> materials) {
        this.materials = materials;
    }
    /**
     * @return the bones
     */
    public List<MMDBone> getBones() {
        return bones;
    }
    /**
     * @param bones the bones to set
     */
    public void setBones(List<MMDBone> bones) {
        this.bones = bones;
    }
    /**
     * @return the ikList
     */
    public List<MMDIk> getIkList() {
        return ikList;
    }
    /**
     * @param ikList the ikList to set
     */
    public void setIkList(List<MMDIk> ikList) {
        this.ikList = ikList;
    }
    /**
     * @return the boneGroupNames
     */
    public List<String> getBoneGroupNames() {
        return boneGroupNames;
    }
    /**
     * @param boneGroupNames the boneGroupNames to set
     */
    public void setBoneGroupNames(List<String> boneGroupNames) {
        this.boneGroupNames = boneGroupNames;
    }
    /**
     * @return the displayBoneList
     */
    public List<MMDDisplayBone> getDisplayBoneList() {
        return displayBoneList;
    }
    /**
     * @param displayBoneList the displayBoneList to set
     */
    public void setDisplayBoneList(List<MMDDisplayBone> displayBoneList) {
        this.displayBoneList = displayBoneList;
    }
    /**
     * @return the toonTextures
     */
    public List<String> getToonTextures() {
        return toonTextures;
    }
    /**
     * @param toonTextures the toonTextures to set
     */
    public void setToonTextures(List<String> toonTextures) {
        this.toonTextures = toonTextures;
    }
    /**
     * @return the rigidBodyList
     */
    public List<MMDRigidBody> getRigidBodyList() {
        return rigidBodyList;
    }
    /**
     * @param rigidBodyList the rigidBodyList to set
     */
    public void setRigidBodyList(List<MMDRigidBody> rigidBodyList) {
        this.rigidBodyList = rigidBodyList;
    }
}
