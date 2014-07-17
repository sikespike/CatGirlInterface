package com.cbg.core.data;

import java.util.List;

import com.cbg.core.geometry.MMDBone;
import com.cbg.core.geometry.MMDDisplayBone;
import com.cbg.core.geometry.MMDIk;
import com.cbg.core.geometry.Material;
import com.cbg.core.geometry.Triangle;
import com.cbg.core.geometry.Vertex;

public class MMDModel {
    private String fileVersion;
    private float versionNumber;
    private String modelName;
    private String modelComment;
    private Long vertexCount;
    private List<Vertex> verticies;
    private Long triangleCount;
    private List<Triangle> triangles;
    private Long materialCount;
    private List<Material> materials;
    private Long boneCount;
    private List<MMDBone> bones;
    private Long ikChainCount;
    private List<MMDIk> ikList;
    private List<String> boneGroupNames;
    private List<MMDDisplayBone> displayBoneList;
    
}
