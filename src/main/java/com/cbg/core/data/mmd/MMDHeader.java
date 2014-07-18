/**
 * 
 */
package com.cbg.core.data.mmd;

/**
 * @author Siebe
 *
 */
public class MMDHeader {
    private String fileVersion;
    private float versionNumber;
    private String modelName;
    private String modelComment;
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
}
