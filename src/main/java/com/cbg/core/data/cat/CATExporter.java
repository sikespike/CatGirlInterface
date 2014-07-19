/**
 * 
 */
package com.cbg.core.data.cat;

import java.io.BufferedWriter;
import java.net.URI;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

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
        String serializedModel = serializeModel();
        try{
            Path f = Files.createFile(Paths.get(URI.create("file://"+this.fileName)));
            BufferedWriter w = Files.newBufferedWriter(f, Charset.forName("UTF-8"), StandardOpenOption.CREATE_NEW);
            
            w.write(serializedModel);
            
            w.close();
        } catch (Exception e){
            throw new RuntimeException(e);
        }
    }
    
    private String serializeModel(){
        CATModelSerializer s = new CATModelSerializer(this.model);
        
        return s.serialize();
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
