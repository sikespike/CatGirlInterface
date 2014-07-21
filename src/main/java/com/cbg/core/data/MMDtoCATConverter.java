/**
 * 
 */
package com.cbg.core.data;

import com.cbg.core.data.cat.CATExporter;
import com.cbg.core.data.mmd.MMDImporter;
import com.cbg.core.data.mmd.MMDModel;
import com.cbg.studio.server.domain.CATModel;

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
        System.out
                .println("----------------------------- Importing MMD Model ------------------------------");
        mmdImporter.run();
        System.out
                .println("---------------------------------- Complete ------------------------------------");
        MMDModel mmdModel = mmdImporter.getModel();

        System.out
                .println("-------------------------- Transforming to CAT Model ---------------------------");
        MMDtoCATTransformer transformer = new MMDtoCATTransformer(mmdModel);
        transformer.run();
        System.out
                .println("---------------------------------- Complete ------------------------------------");
        CATModel catModel = transformer.getCatModel();

        CATExporter catExporter = new CATExporter(catModel, this.catModelFile);

        System.out
                .println("----------------------------- Exporting CAT Model ------------------------------");
        catExporter.run();
        System.out
                .println("---------------------------------- Complete ------------------------------------");
    }
}
