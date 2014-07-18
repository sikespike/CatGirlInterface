/**
 * 
 */
package com.cbg.core.data.cat;

import java.util.List;
import java.util.Map;

import com.cbg.core.geometry.cat.Bone;
import com.cbg.core.geometry.cat.Joint;
import com.cbg.core.geometry.cat.Material;
import com.cbg.core.geometry.cat.Motion;
import com.cbg.core.geometry.cat.RigidBody;
import com.cbg.core.geometry.cat.Triangle;
import com.cbg.core.geometry.cat.VertexMorph;

/**
 * @author Siebe
 *
 */
public class CATModel {
    private List<Material> materials;
    private List<Triangle> polygons;
    private List<Bone> bones;
    private List<Motion> motions;
    private List<VertexMorph> vertexMorphList;
    private Map<String, List<Bone>> displayBoneGroups;
    private List<String> toonTextureList;
    private List<RigidBody> rigidBodyList;
    private List<Joint> jointList;
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
     * @return the polygons
     */
    public List<Triangle> getPolygons() {
        return polygons;
    }
    /**
     * @param polygons the polygons to set
     */
    public void setPolygons(List<Triangle> polygons) {
        this.polygons = polygons;
    }
    /**
     * @return the bones
     */
    public List<Bone> getBones() {
        return bones;
    }
    /**
     * @param bones the bones to set
     */
    public void setBones(List<Bone> bones) {
        this.bones = bones;
    }
    /**
     * @return the motions
     */
    public List<Motion> getMotions() {
        return motions;
    }
    /**
     * @param motions the motions to set
     */
    public void setMotions(List<Motion> motions) {
        this.motions = motions;
    }
    /**
     * @return the vertexMorphList
     */
    public List<VertexMorph> getVertexMorphList() {
        return vertexMorphList;
    }
    /**
     * @param vertexMorphList the vertexMorphList to set
     */
    public void setVertexMorphList(List<VertexMorph> vertexMorphList) {
        this.vertexMorphList = vertexMorphList;
    }
    /**
     * @return the displayBoneGroups
     */
    public Map<String, List<Bone>> getDisplayBoneGroups() {
        return displayBoneGroups;
    }
    /**
     * @param displayBoneGroups the displayBoneGroups to set
     */
    public void setDisplayBoneGroups(Map<String, List<Bone>> displayBoneGroups) {
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
    public List<RigidBody> getRigidBodyList() {
        return rigidBodyList;
    }
    /**
     * @param rigidBodyList the rigidBodyList to set
     */
    public void setRigidBodyList(List<RigidBody> rigidBodyList) {
        this.rigidBodyList = rigidBodyList;
    }
    /**
     * @return the jointList
     */
    public List<Joint> getJointList() {
        return jointList;
    }
    /**
     * @param jointList the jointList to set
     */
    public void setJointList(List<Joint> jointList) {
        this.jointList = jointList;
    }
}
