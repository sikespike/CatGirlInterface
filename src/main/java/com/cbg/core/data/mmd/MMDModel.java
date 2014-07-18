package com.cbg.core.data.mmd;

import java.util.List;
import java.util.Map;

import com.cbg.core.geometry.mmd.MMDBone;
import com.cbg.core.geometry.mmd.MMDIk;
import com.cbg.core.geometry.mmd.MMDJoint;
import com.cbg.core.geometry.mmd.MMDMaterial;
import com.cbg.core.geometry.mmd.MMDRigidBody;
import com.cbg.core.geometry.mmd.MMDTriangle;
import com.cbg.core.geometry.mmd.MMDVertex;
import com.cbg.core.geometry.mmd.MMDVertexMorph;

public class MMDModel {
    private MMDHeader header;
    private List<MMDVertex> vertexList;
    private List<MMDTriangle> triangleList;
    private List<MMDMaterial> materialList;
    private List<MMDBone> boneList;
    private List<MMDIk> ikList;
    private List<MMDVertexMorph> vertexMorphList;
    private List<MMDVertexMorph> facialMorphList;
    private Map<String, List<MMDBone>> displayBoneGroups;
    private List<String> toonTextureList;
    private List<MMDRigidBody> rigidBodyList;
    private List<MMDJoint> jointList;
    
    /**
     * @return the header
     */
    public MMDHeader getHeader() {
        return header;
    }
    /**
     * @param header the header to set
     */
    public void setHeader(MMDHeader header) {
        this.header = header;
    }
    /**
     * @return the vertexList
     */
    public List<MMDVertex> getVertexList() {
        return vertexList;
    }
    /**
     * @param vertexList the vertexList to set
     */
    public void setVertexList(List<MMDVertex> vertexList) {
        this.vertexList = vertexList;
    }
    /**
     * @return the triangleList
     */
    public List<MMDTriangle> getTriangleList() {
        return triangleList;
    }
    /**
     * @param triangleList the triangleList to set
     */
    public void setTriangleList(List<MMDTriangle> triangleList) {
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
     * @return the displayBoneGroups
     */
    public Map<String, List<MMDBone>> getDisplayBoneGroups() {
        return displayBoneGroups;
    }
    /**
     * @param displayBoneGroups the displayBoneGroups to set
     */
    public void setDisplayBoneGroups(Map<String, List<MMDBone>> displayBoneGroups) {
        this.displayBoneGroups = displayBoneGroups;
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
    /**
     * @return the facialMorphList
     */
    public List<MMDVertexMorph> getFacialMorphList() {
        return facialMorphList;
    }
    /**
     * @param facialMorphList the facialMorphList to set
     */
    public void setFacialMorphList(List<MMDVertexMorph> facialMorphList) {
        this.facialMorphList = facialMorphList;
    }
}
