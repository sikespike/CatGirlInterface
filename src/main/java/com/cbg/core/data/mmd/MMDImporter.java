/**
 * 
 */
package com.cbg.core.data.mmd;

import java.io.FileInputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;

import com.cbg.core.geometry.Vector;
import com.cbg.core.geometry.mmd.MMDBone;
import com.cbg.core.geometry.mmd.MMDBoneType;
import com.cbg.core.geometry.mmd.MMDIk;
import com.cbg.core.geometry.mmd.MMDJoint;
import com.cbg.core.geometry.mmd.MMDMaterial;
import com.cbg.core.geometry.mmd.MMDMorphData;
import com.cbg.core.geometry.mmd.MMDRigidBody;
import com.cbg.core.geometry.mmd.MMDTriangle;
import com.cbg.core.geometry.mmd.MMDVertex;
import com.cbg.core.geometry.mmd.MMDVertexMorph;

/**
 * @author Siebe
 * 
 */
public class MMDImporter implements Runnable {
    private String fileName;
    private MMDModel model;
    private FileInputStream fs;

    public MMDImporter(String fileName) {
        this.fileName = fileName;
        model = new MMDModel();
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Runnable#run()
     */
    @Override
    public void run() {
        try{
            try {
                this.fs = new FileInputStream(this.fileName);

                readHeader();
                readVertices();
                readPolygon();
                readMaterials();
                readBones();
                readIK();
                readMorphs();
                readDisplayItems();
                readExtendedData();
                readToonTextures();
                readRigidBodies();
                readJoints();
                
            } catch (Exception e) {
                throw new RuntimeException(e);
            } finally {
                this.fs.close();
            }
        } catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    private void readHeader() throws Exception{
        byte[] fileVersion = new byte[3];
        byte[] modelName = new byte[20];
        byte[] modelComment = new byte[256];
        
        fs.read(fileVersion);
        float versionNumber = readFloat();
        fs.read(modelName);
        fs.read(modelComment);
        
        MMDHeader header = new MMDHeader();
        header.setFileVersion(new String(fileVersion));
        header.setVersionNumber(versionNumber);
        header.setModelName(new String(modelName));
        header.setModelComment(new String(modelComment));
        
        this.model.setHeader(header);
    }

    private float readFloat() throws Exception{
        byte[] array = new byte[4];
        
        fs.read(array);
        
        ByteBuffer b = ByteBuffer.wrap(array);
        return b.getFloat();
    }
    
    private void readVertices() throws Exception{
        long vertexCount = readUnsignedInt();
        List<MMDVertex> vertexList = new ArrayList<MMDVertex>();
        
        for(long x=0;x<vertexCount;x++){
            MMDVertex v = new MMDVertex();
            
            v.setX(readFloat());
            v.setY(readFloat());
            v.setZ(readFloat());
            
            v.setXn(readFloat());
            v.setYn(readFloat());
            v.setZn(readFloat());
            
            v.setU(readFloat());
            v.setV(readFloat());
            
            v.setBone0Index(readUnsignedShort());
            v.setBone1Index(readUnsignedShort());
            
            v.setBone0Weight(readByte());
            v.setEdgeFlag(readByte());
            
            vertexList.add(v);
        }
        
        this.model.setVertexList(vertexList);
    }

    private int readByte() throws Exception {
        byte[] array = new byte[1];
        
        fs.read(array);
        byte[] longArray = new byte[4];
        ByteBuffer b = ByteBuffer.wrap(longArray);
        b.put(array, 3, 1);
        return b.getInt();
    }
    
    private int readUnsignedShort() throws Exception{
        byte[] array = new byte[2];
        
        fs.read(array);
        byte[] longArray = new byte[4];
        ByteBuffer b = ByteBuffer.wrap(longArray);
        b.put(array, 2, 2);
        return b.getInt();
    }
    
    private long readUnsignedInt() throws Exception{
        byte[] array = new byte[4];
        
        fs.read(array);
        byte[] longArray = new byte[8];
        ByteBuffer b = ByteBuffer.wrap(longArray);
        b.put(array, 4, 4);
        return b.getLong();
    }
    
    private void readPolygon() throws Exception{
        long polyCount = readUnsignedInt();
        
        List<MMDTriangle> polyList = new ArrayList<MMDTriangle>();
        
        List<MMDVertex> vertexList = this.model.getVertexList();
        for(long x=0;x<polyCount;x++){
            MMDTriangle t = new MMDTriangle();
            
            t.addVertex(vertexList.get(this.readUnsignedShort()));
            t.addVertex(vertexList.get(this.readUnsignedShort()));
            t.addVertex(vertexList.get(this.readUnsignedShort()));
            
            polyList.add(t);
        }
        
        this.model.setTriangleList(polyList);
    }

    private void readMaterials() throws Exception{
        long matCount = readUnsignedInt();
        
        List<MMDMaterial> list = new ArrayList<MMDMaterial>();
        
        for(long x=0;x<matCount;x++){
            MMDMaterial m = new MMDMaterial();
            
            m.setR(readFloat());
            m.setG(readFloat());
            m.setB(readFloat());
            m.setA(readFloat());
            
            m.setSpecular(readFloat());
            m.setRs(readFloat());
            m.setGs(readFloat());
            m.setBs(readFloat());
            
            m.setRa(readFloat());
            m.setGa(readFloat());
            m.setBa(readFloat());
            
            m.setToonIndex(readByte());
            m.setEdgeFlag(readByte());
            
            m.setIndexAffectedCount(readUnsignedInt());
            m.setTextureFilename(readString(20));
            
            list.add(m);
        }
        
        this.model.setMaterialList(list);
    }

    private String readString(int size) throws Exception{
        byte[] array = new byte[size];
        
        fs.read(array);
        
        String str = new String(array);
        
        return str.trim();
    }
    
    private void readBones() throws Exception{
        long boneCount = readUnsignedInt();
        
        List<MMDBone> list = new ArrayList<MMDBone>();
        
        for(long x=0;x<boneCount;x++){
            MMDBone b = new MMDBone();
            
            b.setName(readString(20));
            
            int parent = readUnsignedShort();
            parent = parent == 0xffff ? -1:parent;
            b.setParentBone(parent);
            
            int child = readUnsignedShort();
            child = child == 0xffff ? -1:child;
            b.setChildBone(child);
            
            b.setBoneType(MMDBoneType.getMMDBoneType(readByte()));
            b.setTargetBone(readUnsignedShort());
            
            b.setX(readFloat());
            b.setY(readFloat());
            b.setZ(readFloat());
            
            list.add(b);
        }
        
        this.model.setBoneList(list);
    }

    private void readIK() throws Exception{
        long ikCount = readUnsignedInt();
        
        List<MMDIk> list = new ArrayList<MMDIk>();
        
        List<MMDBone> boneList = this.model.getBoneList();
        
        for(long x=0;x<ikCount;x++){
            MMDIk k = new MMDIk();
            
            k.setBone(boneList.get(readUnsignedShort()));
            k.setTargetBone(boneList.get(readUnsignedShort()));
            
            k.setNumLinks(readByte());
            k.setItCount(readUnsignedShort());
            k.setMaxAngle(readFloat());
            
            List<MMDBone> childBones = new ArrayList<MMDBone>();
            for(int i=0;i<k.getNumLinks();i++){
                childBones.add(boneList.get(readUnsignedShort()));
            }
            
            k.setChildBoneList(childBones);
            
            list.add(k);
        }
        
        this.model.setIkList(list);
    }

    private void readMorphs() throws Exception{
        long morphCount = readUnsignedInt();
        
        List<MMDVertexMorph> list = new ArrayList<MMDVertexMorph>();
        
        for(long x=0;x<morphCount;x++){
            MMDVertexMorph m = new MMDVertexMorph();
            
            m.setName(readString(20));
            long dataSize = readUnsignedInt();
            m.setType(readByte());
            
            List<MMDMorphData> morphData = new ArrayList<MMDMorphData>();
            
            for(long i=0;i<dataSize;i++){
                MMDMorphData d = new MMDMorphData();
                
                d.setIndex(readUnsignedInt());
                
                List<Vector> vList = readVectorList(3);
                
                d.setOffset(vList);
                
                morphData.add(d);
            }
            
            m.setMorphData(morphData);
            
            list.add(m);
        }
        
        this.model.setVertexMorphList(list);
    }

    private Vector readVector() throws Exception{
        Vector v = new Vector();
        
        v.setX(readFloat());
        v.setY(readFloat());
        v.setZ(readFloat());
        v.setA(readFloat());
        
        return v;
    }
    
    private void readDisplayItems() throws Exception{
        int faceMorphCount = readByte();
        
        List<MMDVertexMorph> vertexMorphList = this.model.getVertexMorphList();
        
        List<MMDVertexMorph> facialMorphList = new ArrayList<MMDVertexMorph>();
        
        for(int x=0;x<faceMorphCount;x++){
            facialMorphList.add(vertexMorphList.get(readUnsignedShort()));
        }
        
        Map<String, List<MMDBone>> displayBoneGroups = new HashMap<String,List<MMDBone>>();
        
        int boneListCount = readByte();
        
        LinkedHashSet<String> groupNames = new LinkedHashSet<String>();
        for(int x=0;x<boneListCount;x++){
            String groupName = readString(50);
            
            if(!groupNames.contains(groupName)){
                List<MMDBone> list = new ArrayList<MMDBone>();
                displayBoneGroups.put(groupName, list);
            }
            groupNames.add(groupName);
        }
        
        List<MMDBone> boneList = this.model.getBoneList();
        String[] gNames = groupNames.toArray(new String[groupNames.size()]);
        long displayBones = readUnsignedInt();
        
        for(long x=0;x<displayBones;x++){
            int boneIndex = readUnsignedShort();
            int displayIndex = readByte();
            
            String groupName = gNames[displayIndex];
            
            displayBoneGroups.get(groupName).add(boneList.get(boneIndex));
        }
        
        this.model.setFacialMorphList(facialMorphList);
        this.model.setDisplayBoneGroups(displayBoneGroups);
    }

    private void readExtendedData() throws Exception{
        int engFlag = readByte();
        
        if(engFlag == 1){
            String name = readString(20);
            String comment = readString(256);
            
            for(int x=0;x<this.model.getBoneList().size();x++){
                String boneName = readString(20);
            }
            
            for(int x=0;x<this.model.getVertexMorphList().size();x++){
                String morphName = readString(20);
            }
            
            for(int x=0;x<this.model.getDisplayBoneGroups().size();x++){
                String displayName = readString(50);
            }
        }
    }

    private void readToonTextures() throws Exception{
        List<String> toonTextureList = new ArrayList<String>();
        
        for(int x=0;x<10;x++){
            toonTextureList.add(readString(100));
        }
        
        this.model.setToonTextureList(toonTextureList);
    }

    private void readRigidBodies() throws Exception{
        long bodyCount = readUnsignedInt();
        
        List<MMDRigidBody> list = new ArrayList<MMDRigidBody>();
        
        List<MMDBone> boneList = this.model.getBoneList();
        
        for(long x=0;x<bodyCount;x++){
            MMDRigidBody b = new MMDRigidBody();
            
            b.setName(readString(20));
            int boneId = readUnsignedShort();
            
            if(boneId != 0xffff){
                b.setBone(boneList.get(boneId));
            }
            
            b.setCollisionGroupId(readByte());
            b.setCollisionMaskId(readUnsignedShort());
            b.setShape(readByte());
            
            List<Vector> size = readVectorList(3);
            b.setSize(size);
            
            List<Vector> position = readVectorList(3);
            b.setPosition(position);
            
            List<Vector> rotation = readVectorList(3);
            b.setRotation(rotation);
            
            b.setMass(readFloat());
            b.setVelocityAtt(readFloat());
            b.setRotationAtt(readFloat());
            b.setBounce(readFloat());
            b.setFriction(readFloat());
            b.setMode(readByte());
            
            list.add(b);
        }
        
        this.model.setRigidBodyList(list);
    }

    private List<Vector> readVectorList(int size) throws Exception{
        List<Vector> list = new ArrayList<Vector>();
        
        for(int i=0;i<size;i++){
            Vector v = readVector();
            list.add(v);
        }
        
        return list;
    }
    
    private void readJoints() throws Exception{
        long jointCount = readUnsignedInt();
        
        List<MMDJoint> list = new ArrayList<MMDJoint>();
        
        List<MMDRigidBody> rigidBodyList = this.model.getRigidBodyList();
        
        for(long x=0;x<jointCount;x++){
            MMDJoint j = new MMDJoint();
            
            j.setName(readString(20));
            j.setSourceRigidBody(rigidBodyList.get(Long.valueOf(readUnsignedInt()).intValue()));
            j.setDestRigidBody(rigidBodyList.get(Long.valueOf(readUnsignedInt()).intValue()));
            
            j.setLocation(readVectorList(3));
            j.setRotation(readVectorList(3));
            j.setMaxLoc(readVectorList(3));
            j.setMinLoc(readVectorList(3));
            j.setMaxRot(readVectorList(3));
            j.setMinRot(readVectorList(3));
            j.setSpringConst(readVectorList(3));
            j.setSpringRotConst(readVectorList(3));
            
            list.add(j);
        }
        
        this.model.setJointList(list);
    }
}
