/**
 * 
 */
package com.cbg.core.data.cat;

import java.util.List;

import com.cbg.core.geometry.cat.Bone;
import com.cbg.core.geometry.cat.DisplayBoneGroupList;
import com.cbg.core.geometry.cat.Joint;
import com.cbg.core.geometry.cat.Material;
import com.cbg.core.geometry.cat.Motion;
import com.cbg.core.geometry.cat.RigidBody;
import com.cbg.core.geometry.cat.Triangle;
import com.cbg.core.geometry.cat.VertexMorph;
import com.cbg.core.util.StringUtil;

/**
 * @author Siebe
 * 
 */
public class CATModelSerializer {
    private CATModel model;

    public CATModelSerializer(CATModel model) {
        this.model = model;
    }

    public String serialize() {
        StringBuilder b = new StringBuilder();

        b.append("{");
        b.append(serializeMaterials()).append(",");
        b.append(serializePolygons()).append(",");
        b.append(serializeBones()).append(",");
        b.append(serializeMotions()).append(",");
        b.append(serializeMorphs()).append(",");
        b.append(serializeDisplayBoneGroups()).append(",");
        b.append(serializeToonTextureList()).append(",");
        b.append(serializeRigidBodyList()).append(",");
        b.append(serializeJointList()).append(",");
        b.append("}");

        return b.toString();
    }

    private String serializeJointList() {
        StringBuilder b = new StringBuilder();

        List<Joint> joints = this.model.getJointList();

        System.out.print("Serializing Joints...");
        b.append("{joint:").append(StringUtil.serializeJsonList(joints))
                .append("}");

        System.out.println("complete");
        return b.toString();
    }

    private String serializeRigidBodyList() {
        StringBuilder b = new StringBuilder();

        List<RigidBody> bodies = this.model.getRigidBodyList();

        System.out.print("Serializing Rigid Bodies...");
        b.append("{rigidBody:").append(StringUtil.serializeJsonList(bodies))
                .append("}");

        return b.toString();
    }

    private String serializeToonTextureList() {
        StringBuilder b = new StringBuilder();

        List<String> textures = this.model.getToonTextureList();

        System.out.print("Serializing Toon Textures...");
        b.append("{toonTexture:").append(StringUtil.implodeJson(textures))
                .append("}");

        System.out.println("complete");
        return b.toString();
    }

    private String serializeDisplayBoneGroups() {
        StringBuilder b = new StringBuilder();

        DisplayBoneGroupList displayBones = this.model.getDisplayBoneGroups();

        System.out.print("Serializing Display Bone Groups...");
        b.append("{displayBoneGroup:").append(displayBones.toString())
                .append("}");

        System.out.println("complete");
        return b.toString();
    }

    private String serializeMorphs() {
        StringBuilder b = new StringBuilder();

        List<VertexMorph> list = this.model.getVertexMorphList();

        System.out.print("Serializing Morphs...");
        b.append("{morph:").append(StringUtil.serializeJsonList(list))
                .append("}");

        System.out.println("complete");
        return b.toString();
    }

    private String serializeMotions() {
        StringBuilder b = new StringBuilder();

        List<Motion> motions = this.model.getMotions();

        System.out.print("Serializing Motions...");
        b.append("{motion:").append(StringUtil.serializeJsonList(motions))
                .append("}");

        System.out.println("complete");
        return b.toString();
    }

    private String serializeBones() {
        StringBuilder b = new StringBuilder();

        List<Bone> bones = this.model.getBones();

        System.out.print("Serializing Bones...");
        b.append("{bone:").append(StringUtil.serializeJsonList(bones))
                .append("}");

        System.out.println("complete");
        return b.toString();
    }

    private String serializePolygons() {
        StringBuilder b = new StringBuilder();

        List<Triangle> poly = this.model.getPolygons();

        System.out.print("Serializing Polygons...");
        b.append("{polygon:").append(StringUtil.serializeJsonList(poly))
                .append("}");

        System.out.println("complete");
        return b.toString();
    }

    private String serializeMaterials() {
        StringBuilder b = new StringBuilder();

        List<Material> mat = this.model.getMaterials();

        System.out.print("Serializing Materials...");
        b.append("{material:").append(StringUtil.serializeJsonList(mat))
                .append("}");

        System.out.println("complete");
        return b.toString();
    }
}
