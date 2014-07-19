/**
 * 
 */
package com.cbg.core.data.mmd;

import java.io.FileInputStream;
import java.math.BigInteger;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;

import com.cbg.core.geometry.Vector;
import com.cbg.core.geometry.mmd.MMDBone;
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

    /**
     * @return the model
     */
    public MMDModel getModel() {
        return model;
    }

    public void run() {
        try {
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

                initializeVertexBones();
                initializeBoneBones();
                initializeRigidBodies();
            } catch (Exception e) {
                throw new RuntimeException(e);
            } finally {
                this.fs.close();
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private void readHeader() throws Exception {
        byte[] fileVersion = new byte[3];
        byte[] modelName = new byte[20];
        byte[] modelComment = new byte[256];

        System.out.print("Reading header...");
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
        System.out.println("complete");
    }

    private float readFloat() throws Exception {
        byte[] array = new byte[4];

        fs.read(array);

        ByteBuffer b = ByteBuffer.wrap(array);
        return b.order(ByteOrder.LITTLE_ENDIAN).getFloat();
    }

    private void readVertices() throws Exception {
        int vertexCount = readUnsignedInt();
        List<MMDVertex> vertexList = new ArrayList<MMDVertex>();

        System.out.print("Reading Verticies...");
        for (int x = 0; x < vertexCount; x++) {
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
        System.out.println("complete");
        System.out.println(vertexList.size() + " verticies loaded.");
        this.model.setVertexList(vertexList);
    }

    private int readByte() throws Exception {
        byte[] array = new byte[1];

        fs.read(array);
        BigInteger b = new BigInteger(array);
        return b.intValue();
    }

    private int readUnsignedShort() throws Exception {
        byte[] array = new byte[2];

        fs.read(array);
        byte[] longArray = initByteArray(8);
        longArray = putByteArray(longArray, array);
        ByteBuffer b = ByteBuffer.wrap(longArray);
        int result = b.order(ByteOrder.LITTLE_ENDIAN).getInt();
        return result;
    }

    private int readUnsignedInt() throws Exception {
        byte[] array = new byte[4];

        fs.read(array);
        ByteBuffer b = ByteBuffer.wrap(array);
        int result = b.order(ByteOrder.LITTLE_ENDIAN).getInt();
        return result;
    }

    private byte[] putByteArray(byte[] to, byte[] from) {

        for (int x = 0; x < from.length; x++) {
            to[x] = from[x];
        }

        return to;
    }

    private byte[] initByteArray(int size) {
        byte[] array = new byte[size];

        for (int x = 0; x < size; x++) {
            array[x] = 0x0;
        }

        return array;
    }

    private void readPolygon() throws Exception {
        int polyCount = readUnsignedInt() / 3;

        List<MMDTriangle> polyList = new ArrayList<MMDTriangle>();

        List<MMDVertex> vertexList = this.model.getVertexList();

        System.out.print("Reading Polygons...");

        for (int x = 0; x < polyCount; x++) {
            MMDTriangle t = new MMDTriangle();

            t.addVertex(vertexList.get(this.readUnsignedShort()));

            t.addVertex(vertexList.get(this.readUnsignedShort()));

            t.addVertex(vertexList.get(this.readUnsignedShort()));

            polyList.add(t);
        }

        System.out.println("compelete");
        System.out.println(polyList.size() + " polygons read.");
        this.model.setTriangleList(polyList);
    }

    private void readMaterials() throws Exception {
        int matCount = readUnsignedInt();

        List<MMDMaterial> list = new ArrayList<MMDMaterial>();

        System.out.print("Reading Materials...");

        for (int x = 0; x < matCount; x++) {
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

        System.out.println("complete");
        System.out.println(list.size()+" materials read.");
        this.model.setMaterialList(list);
    }

    private String readString(int size) throws Exception {
        byte[] array = new byte[size];

        fs.read(array);

        String str = new String(array);

        return str.trim();
    }

    private void readBones() throws Exception {
        int boneCount = readUnsignedInt();

        List<MMDBone> list = new ArrayList<MMDBone>();

        System.out.print("Reading Bones...");
        for (int x = 0; x < boneCount; x++) {
            MMDBone b = new MMDBone();

            b.setName(readString(20));

            int parent = readUnsignedShort();
            parent = parent == 0xffff ? -1 : parent;
            b.setParentBoneIndex(parent);

            int child = readUnsignedShort();
            child = child == 0xffff ? -1 : child;
            b.setChildBoneIndex(child);

            b.setBoneType(readByte());
            b.setTargetBoneIndex(readUnsignedShort());

            b.setX(readFloat());
            b.setY(readFloat());
            b.setZ(readFloat());

            list.add(b);
        }

        System.out.println("complete");
        this.model.setBoneList(list);
    }

    private void readIK() throws Exception {
        int ikCount = readUnsignedInt();

        List<MMDIk> list = new ArrayList<MMDIk>();

        List<MMDBone> boneList = this.model.getBoneList();

        System.out.print("Reading IK...");
        for (int x = 0; x < ikCount; x++) {
            MMDIk k = new MMDIk();

            k.setBone(boneList.get(readUnsignedShort()));
            k.setTargetBone(boneList.get(readUnsignedShort()));

            k.setNumLinks(readByte());
            k.setItCount(readUnsignedShort());
            k.setMaxAngle(readFloat());

            List<MMDBone> childBones = new ArrayList<MMDBone>();
            for (int i = 0; i < k.getNumLinks(); i++) {
                childBones.add(boneList.get(readUnsignedShort()));
            }

            k.setChildBoneList(childBones);

            list.add(k);
        }
        System.out.println("complete");
        this.model.setIkList(list);
    }

    private void readMorphs() throws Exception {
        int morphCount = readUnsignedInt();

        List<MMDVertexMorph> list = new ArrayList<MMDVertexMorph>();

        System.out.print("Reading Morphs...");
        for (int x = 0; x < morphCount; x++) {
            MMDVertexMorph m = new MMDVertexMorph();

            m.setName(readString(20));
            long dataSize = readUnsignedInt();
            m.setType(readByte());

            List<MMDMorphData> morphData = new ArrayList<MMDMorphData>();

            for (long i = 0; i < dataSize; i++) {
                MMDMorphData d = new MMDMorphData();

                d.setIndex(readUnsignedInt());

                List<Vector> vList = readVectorList(3);

                d.setOffset(vList);

                morphData.add(d);
            }

            m.setMorphData(morphData);

            list.add(m);
        }

        System.out.println("complete");
        this.model.setVertexMorphList(list);
    }

    private Vector readVector() throws Exception {
        Vector v = new Vector();

        v.setX(readFloat());
        v.setY(readFloat());
        v.setZ(readFloat());
        v.setA(readFloat());

        return v;
    }

    private void readDisplayItems() throws Exception {
        int faceMorphCount = readByte();

        List<MMDVertexMorph> vertexMorphList = this.model.getVertexMorphList();

        List<MMDVertexMorph> facialMorphList = new ArrayList<MMDVertexMorph>();

        System.out.print("Reading Display Items...");
        for (int x = 0; x < faceMorphCount; x++) {
            facialMorphList.add(vertexMorphList.get(readUnsignedShort()));
        }

        Map<String, List<MMDBone>> displayBoneGroups = new HashMap<String, List<MMDBone>>();

        int boneListCount = readByte();

        LinkedHashSet<String> groupNames = new LinkedHashSet<String>();
        for (int x = 0; x < boneListCount; x++) {
            String groupName = readString(50);

            if (!groupNames.contains(groupName)) {
                List<MMDBone> list = new ArrayList<MMDBone>();
                displayBoneGroups.put(groupName, list);
            }
            groupNames.add(groupName);
        }

        List<MMDBone> boneList = this.model.getBoneList();
        String[] gNames = groupNames.toArray(new String[groupNames.size()]);
        int displayBones = readUnsignedInt();

        for (int x = 0; x < displayBones; x++) {
            int boneIndex = readUnsignedShort();
            int displayIndex = readByte();

            String groupName = gNames[displayIndex];

            displayBoneGroups.get(groupName).add(boneList.get(boneIndex));
        }

        System.out.println("complete");
        this.model.setFacialMorphList(facialMorphList);
        this.model.setDisplayBoneGroups(displayBoneGroups);
    }

    private void readExtendedData() throws Exception {
        int engFlag = readByte();
        System.out.print("Reading Extended Data...");
        if (engFlag == 1) {
            String name = readString(20);
            String comment = readString(256);

            for (int x = 0; x < this.model.getBoneList().size(); x++) {
                String boneName = readString(20);
            }

            for (int x = 0; x < this.model.getVertexMorphList().size(); x++) {
                String morphName = readString(20);
            }

            for (int x = 0; x < this.model.getDisplayBoneGroups().size(); x++) {
                String displayName = readString(50);
            }
        }
        System.out.println("complete");
    }

    private void readToonTextures() throws Exception {
        List<String> toonTextureList = new ArrayList<String>();

        System.out.print("Reading Toon Textures...");
        for (int x = 0; x < 10; x++) {
            toonTextureList.add(readString(100));
        }

        System.out.println("complete");
        this.model.setToonTextureList(toonTextureList);
    }

    private void readRigidBodies() throws Exception {
        int bodyCount = readUnsignedInt();

        List<MMDRigidBody> list = new ArrayList<MMDRigidBody>();

        List<MMDBone> boneList = this.model.getBoneList();

        System.out.print("Reading Rigid Bodies...");
        for (int x = 0; x < bodyCount; x++) {
            MMDRigidBody b = new MMDRigidBody();

            b.setName(readString(20));
            int boneId = readUnsignedShort();

            if (boneId != 0xffff) {
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

        System.out.println("complete");
        this.model.setRigidBodyList(list);
    }

    private List<Vector> readVectorList(int size) throws Exception {
        List<Vector> list = new ArrayList<Vector>();

        for (int i = 0; i < size; i++) {
            Vector v = readVector();
            list.add(v);
        }

        return list;
    }

    private void readJoints() throws Exception {
        int jointCount = readUnsignedInt();

        List<MMDJoint> list = new ArrayList<MMDJoint>();

        List<MMDRigidBody> rigidBodyList = this.model.getRigidBodyList();

        System.out.print("Reading Joints...");
        for (int x = 0; x < jointCount; x++) {
            MMDJoint j = new MMDJoint();

            j.setName(readString(20));
            j.setSourceRigidBody(rigidBodyList.get(Long.valueOf(
                    readUnsignedInt()).intValue()));
            j.setDestRigidBody(rigidBodyList.get(Long
                    .valueOf(readUnsignedInt()).intValue()));

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

        System.out.println("complete");
        this.model.setJointList(list);
    }

    private void initializeVertexBones() {
        List<MMDBone> boneList = this.model.getBoneList();

        System.out.print("Initializing Vertex Bones...");
        for (MMDVertex v : this.model.getVertexList()) {
            v.setBone0(boneList.get(v.getBone0Index()));
            v.setBone1(boneList.get(v.getBone1Index()));
        }
        System.out.println("complete");
    }

    private void initializeBoneBones() {
        List<MMDBone> boneList = this.model.getBoneList();

        System.out.print("Initializing Bone's Bones...");
        for (int x = 0; x < boneList.size(); x++) {
            MMDBone b = boneList.get(x);
            b.setIndex(x);
            int pbIndex = b.getParentBoneIndex();
            int cbIndex = b.getChildBoneIndex();
            int tbIndex = b.getTargetBoneIndex();

            if (pbIndex != -1) {
                b.setParentBone(boneList.get(pbIndex));
            }
            if (cbIndex != -1) {
                b.setChildBone(boneList.get(cbIndex));
            }
            if (tbIndex != -1) {
                b.setTargetBone(boneList.get(tbIndex));
            }
        }

        System.out.println("complete");
    }

    private void initializeRigidBodies() {
        List<MMDRigidBody> rigids = this.model.getRigidBodyList();

        System.out.print("Initializing Rigid Bodies...");
        int x = 0;
        for (MMDRigidBody r : rigids) {
            r.setIndex(x);
            x++;
        }

        System.out.println("complete");
    }
}
