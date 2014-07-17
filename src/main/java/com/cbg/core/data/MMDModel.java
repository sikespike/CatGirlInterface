package com.cbg.core.data;

import java.util.List;

import com.cbg.core.geometry.Triangle;
import com.cbg.core.geometry.Vertex;
import com.cbg.core.geometry.mmd.MMDBone;
import com.cbg.core.geometry.mmd.MMDDisplayBone;
import com.cbg.core.geometry.mmd.MMDIk;
import com.cbg.core.geometry.mmd.MMDJoint;
import com.cbg.core.geometry.mmd.MMDMaterial;
import com.cbg.core.geometry.mmd.MMDRigidBody;
import com.cbg.core.geometry.mmd.MMDVertexMorph;

public class MMDModel {
    private String fileVersion;
    private float versionNumber;
    private String modelName;
    private String modelComment;
    private List<Vertex> vertexList;
    private List<Triangle> triangleList;
    private List<MMDMaterial> materialList;
    private List<MMDBone> boneList;
    private List<MMDIk> ikList;
    private List<MMDVertexMorph> vertexMorphList;
    private List<MMDDisplayBone> displayBoneList;
    private List<String> toonTextureList;
    private List<MMDRigidBody> rigidBodyList;
    private List<MMDJoint> jointList;
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
     * @return the vertexList
     */
    public List<Vertex> getVertexList() {
        return vertexList;
    }
    /**
     * @param vertexList the vertexList to set
     */
    public void setVertexList(List<Vertex> vertexList) {
        this.vertexList = vertexList;
    }
    /**
     * @return the triangleList
     */
    public List<Triangle> getTriangleList() {
        return triangleList;
    }
    /**
     * @param triangleList the triangleList to set
     */
    public void setTriangleList(List<Triangle> triangleList) {
        this.triangleList = triangleList;
    }
    /**
     * @return the materialList
     */
    public List<MMDMaterial> getMaterialList() {
        return materialList;
    }
    /**
     * @param materialList the materialList to set
     */
    public void setMaterialList(List<MMDMaterial> materialList) {
        this.materialList = materialList;
    }
    /**
     * @return the boneList
     */
    public List<MMDBone> getBoneList() {
        return boneList;
    }
    /**
     * @param boneList the boneList to set
     */
    public void setBoneList(List<MMDBone> boneList) {
        this.boneList = boneList;
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
     * @return the vertexMorphList
     */
    public List<MMDVertexMorph> getVertexMorphList() {
        return vertexMorphList;
    }
    /**
     * @param vertexMorphList the vertexMorphList to set
     */
    public void setVertexMorphList(List<MMDVertexMorph> vertexMorphList) {
        this.vertexMorphList = vertexMorphList;
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
     * @return the toonTextureList
     */
    public List<String> getToonTextureList() {
        return toonTextureList;
    }
    /**
     * @param toonTextureList the toonTextureList to set
     */
    public void setToonTextureList(List<String> toonTextureList) {
        this.toonTextureList = toonTextureList;
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
    /**
     * @return the jointList
     */
    public List<MMDJoint> getJointList() {
        return jointList;
    }
    /**
     * @param jointList the jointList to set
     */
    public void setJointList(List<MMDJoint> jointList) {
        this.jointList = jointList;
    }
}
