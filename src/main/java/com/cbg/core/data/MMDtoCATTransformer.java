/**
 * 
 */
package com.cbg.core.data;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.cbg.core.data.cat.CATModel;
import com.cbg.core.data.mmd.MMDModel;
import com.cbg.core.geometry.Vector;
import com.cbg.core.geometry.Vector2;
import com.cbg.core.geometry.cat.Bone;
import com.cbg.core.geometry.cat.DisplayBoneGroupList;
import com.cbg.core.geometry.cat.Joint;
import com.cbg.core.geometry.cat.Material;
import com.cbg.core.geometry.cat.Motion;
import com.cbg.core.geometry.cat.RigidBody;
import com.cbg.core.geometry.cat.Triangle;
import com.cbg.core.geometry.cat.Vertex;
import com.cbg.core.geometry.mmd.MMDBone;
import com.cbg.core.geometry.mmd.MMDIk;
import com.cbg.core.geometry.mmd.MMDJoint;
import com.cbg.core.geometry.mmd.MMDMaterial;
import com.cbg.core.geometry.mmd.MMDRigidBody;
import com.cbg.core.geometry.mmd.MMDTriangle;
import com.cbg.core.geometry.mmd.MMDVertex;

/**
 * @author Siebe
 *
 */
public class MMDtoCATTransformer implements Runnable {
    private MMDModel mmdModel;
    private CATModel catModel;

    public MMDtoCATTransformer(MMDModel m) {
        this.mmdModel = m;
        this.catModel = new CATModel();
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Runnable#run()
     */
    public void run() {
        setMaterials();
        setBones();
        setPolygons();
        setMotions();
        setDisplayBoneGroupList();
        setToonTextureList();
        setRigidBodyList();
        setJointList();
    }

    private void setMaterials() {
        List<MMDMaterial> materialList = this.mmdModel.getMaterialList();
        List<Material> materials = new ArrayList<Material>();

        for (MMDMaterial mmdm : materialList) {
            Material m = new Material();

            Vector color = new Vector(mmdm.getR(), mmdm.getG(), mmdm.getB(),
                    mmdm.getA());

            m.setColor(color);

            Vector specLight = new Vector(mmdm.getRs(), mmdm.getGs(),
                    mmdm.getBs(), mmdm.getSpecular());

            m.setSpecLight(specLight);

            Vector ambientLight = new Vector(mmdm.getRa(), mmdm.getGa(),
                    mmdm.getBa(), 1.0f);

            m.setAmbientLight(ambientLight);

            m.setTexture(mmdm.getTextureFilename());

            materials.add(m);
        }

        this.catModel.setMaterials(materials);
    }

    private void setPolygons() {
        List<MMDTriangle> triangleList = this.mmdModel.getTriangleList();
        List<Triangle> polyList = new ArrayList<Triangle>();
        List<Bone> boneList = this.catModel.getBones();

        for (MMDTriangle mmdt : triangleList) {
            Triangle t = new Triangle();

            List<MMDVertex> mmdVertex = mmdt.getVerticies();
            List<Vertex> vertex = new ArrayList<Vertex>();

            for (MMDVertex mmdv : mmdVertex) {
                Vertex v = new Vertex();
                Vector position = new Vector(mmdv.getX(), mmdv.getY(),
                        mmdv.getZ(), 0.0f);
                Vector normal = new Vector(mmdv.getXn(), mmdv.getYn(),
                        mmdv.getZn(), 0.0f);
                Vector2 uv = new Vector2(mmdv.getU(), mmdv.getV());

                v.setPosition(position);
                v.setNormal(normal);
                v.setUv(uv);
                v.setBone0Weight(mmdv.getBone0Weight());

                v.setBone0(boneList.get(mmdv.getBone0Index()));
                v.setBone1(boneList.get(mmdv.getBone1Index()));

                vertex.add(v);
            }

            t.setVerticies(vertex);

            polyList.add(t);
        }

        this.catModel.setPolygons(polyList);
    }

    private void setBones() {
        List<MMDBone> mmdBoneList = this.mmdModel.getBoneList();
        List<Bone> boneList = new ArrayList<Bone>();
        
        for(MMDBone mmdb:mmdBoneList){
            Bone b = new Bone();
            
            b.setName(mmdb.getName());
            b.setType(mmdb.getBoneType());
            
            Vector position = new Vector(mmdb.getX(), mmdb.getY(),
                    mmdb.getZ(), 0.0f);
            
            b.setPosition(position);
            
            boneList.add(b);
        }
        
        for(int x=0;x<mmdBoneList.size();x++){
            MMDBone mmdb = mmdBoneList.get(x);
            Bone b = boneList.get(x);
            
            b.setParent(boneList.get(mmdb.getParentBoneIndex()));
            b.setChild(boneList.get(mmdb.getChildBoneIndex()));
            b.setTarget(boneList.get(mmdb.getTargetBoneIndex()));
        }
        
        this.catModel.setBones(boneList);
    }

    private void setMotions() {
        List<MMDIk> ikList = this.mmdModel.getIkList();
        List<Motion> motionList = new ArrayList<Motion>();
        List<Bone> boneList = this.catModel.getBones();
        
        for(MMDIk mmdik:ikList){
            Motion m = new Motion();
            
            m.setBone(boneList.get(mmdik.getBone().getIndex()));
            m.setTargetBone(boneList.get(mmdik.getTargetBone().getIndex()));
            m.setLinks(mmdik.getNumLinks());
            m.setIteration(mmdik.getItCount());
            m.setMaxAngle(mmdik.getMaxAngle());
            
            List<Bone> childBones = new ArrayList<Bone>();
            
            for(MMDBone mmdb :mmdik.getChildBoneList()){
                childBones.add(boneList.get(mmdb.getIndex()));
            }
            
            m.setChildBones(childBones);
            
            motionList.add(m);
        }
        
        this.catModel.setMotions(motionList);
    }

    private void setDisplayBoneGroupList() {
        Map<String, List<MMDBone>> displayBoneGroups = this.mmdModel.getDisplayBoneGroups();
        DisplayBoneGroupList groupList = new DisplayBoneGroupList();
        List<Bone> boneList = this.catModel.getBones();
        
        for(String key:displayBoneGroups.keySet()){
            List<MMDBone> mmdBones = displayBoneGroups.get(key);
            
            List<Bone> bones = new ArrayList<Bone>();
            
            for(MMDBone mmdb:mmdBones){
                bones.add(boneList.get(mmdb.getIndex()));
            }
            
            groupList.put(key, bones);
        }
        
        this.catModel.setDisplayBoneGroups(groupList);
    }

    private void setToonTextureList() {
        this.catModel.setToonTextureList(this.mmdModel.getToonTextureList());
    }

    private void setRigidBodyList() {
        List<MMDRigidBody> mmdRigidBodyList = this.mmdModel.getRigidBodyList();
        List<RigidBody> rigidBodyList = new ArrayList<RigidBody>();
        List<Bone> boneList = this.catModel.getBones();
        
        String[] types = {"sphere","box","capsule"};
        String[] modes = {"static","dynamic","bone"};
        
        for(MMDRigidBody mmdr:mmdRigidBodyList){
            RigidBody r = new RigidBody();
            
            r.setName(mmdr.getName());
            r.setBone(boneList.get(mmdr.getBone().getIndex()));
            r.setCollisionGroupId(mmdr.getCollisionGroupId());
            r.setCollisionMaskId(mmdr.getCollisionMaskId());
            r.setShape(types[mmdr.getShape()]);
            
            r.setSize(mmdr.getSize());
            r.setPosition(mmdr.getPosition());
            r.setRotation(mmdr.getRotation());
            
            r.setMass(mmdr.getMass());
            r.setVelocityAtt(mmdr.getVelocityAtt());
            r.setRotationAtt(mmdr.getRotationAtt());
            r.setBounce(mmdr.getBounce());
            r.setFriction(mmdr.getFriction());
            
            r.setMode(modes[mmdr.getMode()]);
            
            rigidBodyList.add(r);
        }
        
        this.catModel.setRigidBodyList(rigidBodyList);
    }

    private void setJointList() {
        List<MMDJoint> jointList = this.mmdModel.getJointList();
        List<RigidBody> rigidBodyList = this.catModel.getRigidBodyList();
        
        List<Joint> joints = new ArrayList<Joint>();
        
        for(MMDJoint mmdj:jointList){
            Joint j = new Joint();
            
            j.setName(mmdj.getName());
            j.setSourceRigidBody(rigidBodyList.get(mmdj.getSourceRigidBody().getIndex()));
            j.setDestRigidBody(rigidBodyList.get(mmdj.getDestRigidBody().getIndex()));
            j.setLocation(mmdj.getLocation());
            j.setRotation(mmdj.getRotation());
            j.setMinLoc(mmdj.getMinLoc());
            j.setMaxLoc(mmdj.getMaxLoc());
            j.setMinRot(mmdj.getMinRot());
            j.setMaxRot(mmdj.getMaxRot());
            j.setSpringConst(mmdj.getSpringConst());
            j.setSpringRotConst(mmdj.getSpringRotConst());
            
            joints.add(j);
        }
        
        this.catModel.setJointList(joints);
    }

    /**
     * @return the mmdModel
     */
    public MMDModel getMmdModel() {
        return mmdModel;
    }

    /**
     * @param mmdModel
     *            the mmdModel to set
     */
    public void setMmdModel(MMDModel mmdModel) {
        this.mmdModel = mmdModel;
    }

    /**
     * @return the catModel
     */
    public CATModel getCatModel() {
        return catModel;
    }

    /**
     * @param catModel
     *            the catModel to set
     */
    public void setCatModel(CATModel catModel) {
        this.catModel = catModel;
    }
}