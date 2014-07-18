/**
 * 
 */
package com.cbg.core.geometry.mmd;

/**
 * @author Siebe
 *
 */
public class MMDMaterial {
    private float r;
    private float g;
    private float b;
    private float a;
    
    private float specular;
    private float rs;
    private float gs;
    private float bs;
    
    private float ra;
    private float ga;
    private float ba;
    
    private int toonIndex;
    private int edgeFlag;
    private long indexAffectedCount;
    private String textureFilename;
    /**
     * @return the r
     */
    public float getR() {
        return r;
    }
    /**
     * @param r the r to set
     */
    public void setR(float r) {
        this.r = r;
    }
    /**
     * @return the g
     */
    public float getG() {
        return g;
    }
    /**
     * @param g the g to set
     */
    public void setG(float g) {
        this.g = g;
    }
    /**
     * @return the b
     */
    public float getB() {
        return b;
    }
    /**
     * @param b the b to set
     */
    public void setB(float b) {
        this.b = b;
    }
    /**
     * @return the a
     */
    public float getA() {
        return a;
    }
    /**
     * @param a the a to set
     */
    public void setA(float a) {
        this.a = a;
    }
    /**
     * @return the specular
     */
    public float getSpecular() {
        return specular;
    }
    /**
     * @param specular the specular to set
     */
    public void setSpecular(float specular) {
        this.specular = specular;
    }
    /**
     * @return the rs
     */
    public float getRs() {
        return rs;
    }
    /**
     * @param rs the rs to set
     */
    public void setRs(float rs) {
        this.rs = rs;
    }
    /**
     * @return the gs
     */
    public float getGs() {
        return gs;
    }
    /**
     * @param gs the gs to set
     */
    public void setGs(float gs) {
        this.gs = gs;
    }
    /**
     * @return the bs
     */
    public float getBs() {
        return bs;
    }
    /**
     * @param bs the bs to set
     */
    public void setBs(float bs) {
        this.bs = bs;
    }
    /**
     * @return the ra
     */
    public float getRa() {
        return ra;
    }
    /**
     * @param ra the ra to set
     */
    public void setRa(float ra) {
        this.ra = ra;
    }
    /**
     * @return the ga
     */
    public float getGa() {
        return ga;
    }
    /**
     * @param ga the ga to set
     */
    public void setGa(float ga) {
        this.ga = ga;
    }
    /**
     * @return the ba
     */
    public float getBa() {
        return ba;
    }
    /**
     * @param ba the ba to set
     */
    public void setBa(float ba) {
        this.ba = ba;
    }
    /**
     * @return the toonIndex
     */
    public int getToonIndex() {
        return toonIndex;
    }
    /**
     * @param toonIndex the toonIndex to set
     */
    public void setToonIndex(int toonIndex) {
        this.toonIndex = toonIndex;
    }
    /**
     * @return the edgeFlag
     */
    public int getEdgeFlag() {
        return edgeFlag;
    }
    /**
     * @param edgeFlag the edgeFlag to set
     */
    public void setEdgeFlag(int edgeFlag) {
        this.edgeFlag = edgeFlag;
    }
    /**
     * @return the indexAffectedCount
     */
    public long getIndexAffectedCount() {
        return indexAffectedCount;
    }
    /**
     * @param indexAffectedCount the indexAffectedCount to set
     */
    public void setIndexAffectedCount(long indexAffectedCount) {
        this.indexAffectedCount = indexAffectedCount;
    }
    /**
     * @return the textureFilename
     */
    public String getTextureFilename() {
        return textureFilename;
    }
    /**
     * @param textureFilename the textureFilename to set
     */
    public void setTextureFilename(String textureFilename) {
        this.textureFilename = textureFilename;
    }
}
