/**
 * 
 */
package com.cbg.core.data.cat;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.List;

import com.cbg.studio.server.domain.CATModel;
import com.cbg.studio.server.domain.geometry.Bone;
import com.cbg.studio.server.domain.geometry.DisplayBoneGroupList;
import com.cbg.studio.server.domain.geometry.Joint;
import com.cbg.studio.server.domain.geometry.Material;
import com.cbg.studio.server.domain.geometry.Motion;
import com.cbg.studio.server.domain.geometry.RigidBody;
import com.cbg.studio.server.domain.geometry.Triangle;
import com.cbg.studio.server.domain.geometry.VertexMorph;

/**
 * @author Siebe
 * 
 */
public class CATModelBinaryWriter {
    private CATModel model;
    private ObjectOutputStream out;

    public CATModelBinaryWriter(CATModel model, FileOutputStream fileOut)
            throws Exception {
        this.model = model;
        this.out = new ObjectOutputStream(fileOut);
    }

    public void writeModel() throws Exception {
        this.out.writeObject(model);
        
        /*writeMaterials();

        writePolygons();

        writeBones();

        writeMotions();

        writeMorphs();

        writeDisplayBoneGroups();

        writeToonTextureList();

        writeRigidBodyList();

        writeJointList();*/

    }

    private void writeJointList() throws Exception{
        List<Joint> joints = this.model.getJointList();

        System.out.print("Serializing Joints...");

        this.out.writeObject(joints);
        
        System.out.println("complete");
    }

    private void writeRigidBodyList() throws Exception{
        List<RigidBody> bodies = this.model.getRigidBodyList();

        System.out.print("Serializing Rigid Bodies...");

        this.out.writeObject(bodies);
        
        System.out.println("complete");
    }

    private void writeToonTextureList() throws Exception{
        List<String> textures = this.model.getToonTextureList();

        System.out.print("Serializing Toon Textures...");

        this.out.writeObject(textures);
        
        System.out.println("complete");
    }

    private void writeDisplayBoneGroups() throws Exception{
        DisplayBoneGroupList displayBones = this.model.getDisplayBoneGroups();

        System.out.print("Serializing Display Bone Groups...");

        this.out.writeObject(displayBones);
        
        System.out.println("complete");
    }

    private void writeMorphs() throws Exception{

        List<VertexMorph> list = this.model.getVertexMorphList();

        System.out.print("Serializing Morphs...");

        this.out.writeObject(list);
        
        System.out.println("complete");
    }

    private void writeMotions() throws Exception{
        List<Motion> motions = this.model.getMotions();

        System.out.print("Serializing Motions...");

        this.out.writeObject(motions);
        
        System.out.println("complete");
    }

    private void writeBones() throws Exception{
        List<Bone> bones = this.model.getBones();

        System.out.print("Serializing Bones...");

        this.out.writeObject(bones);
        
        System.out.println("complete");
    }

    private void writePolygons() throws Exception{
        List<Triangle> poly = this.model.getPolygons();

        System.out.print("Serializing Polygons...");

        this.out.writeObject(poly);
        
        System.out.println("complete");
    }

    private void writeMaterials() throws Exception{
        List<Material> mat = this.model.getMaterials();

        System.out.print("Serializing Materials...");

        this.out.writeObject(mat);
        
        System.out.println("complete");
    }
}
