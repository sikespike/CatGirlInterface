/**
 * 
 */
package com.cbg.core.data.cat;

import java.io.FileOutputStream;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @author Siebe
 *
 */
public class CATExporter implements Runnable{
    private String fileName;
    private CATModel model;
    
    public CATExporter(){
        super();
    }
    
    public CATExporter(String fileName){
        this.fileName = fileName;
    }
    
    public CATExporter(CATModel model, String fileName){
        this.fileName = fileName;
        this.model = model;
    }
    
    public void run() {
        try{
            Path path = Paths.get(URI.create("file://"+this.fileName));
            Files.deleteIfExists(path);
            FileOutputStream out = new FileOutputStream(this.fileName);
            
            CATModelBinaryWriter writer = new CATModelBinaryWriter(this.model,out);
            
            writer.writeModel();
            
            out.close();
        } catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public CATModel getModel() {
        return model;
    }

    public void setModel(CATModel model) {
        this.model = model;
    }
}
