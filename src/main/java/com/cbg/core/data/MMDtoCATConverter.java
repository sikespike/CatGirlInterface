/**
 * 
 */
package com.cbg.core.data;

import com.cbg.core.data.cat.CATExporter;
import com.cbg.core.data.cat.CATModel;
import com.cbg.core.data.mmd.MMDImporter;
import com.cbg.core.data.mmd.MMDModel;

/**
 * @author Siebe
 * 
 */
public class MMDtoCATConverter implements Runnable {
    private String mmdModelFile;
    private String catModelFile;

    public MMDtoCATConverter(String mmdFile, String catFile) {
        this.mmdModelFile = mmdFile;
        this.catModelFile = catFile;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Runnable#run()
     */
    public void run() {
        MMDImporter mmdImporter = new MMDImporter(this.mmdModelFile);
        
        mmdImporter.run();
        
        MMDModel mmdModel = mmdImporter.getModel();
        
        MMDtoCATTransformer transformer = new MMDtoCATTransformer(mmdModel);
        
        transformer.run();
        
        CATModel catModel = transformer.getCatModel();
        
        CATExporter catExporter = new CATExporter(catModel, this.catModelFile);
        
        catExporter.run();
    }
}
