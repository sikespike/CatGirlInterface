/**
 * 
 */
package com.cbg.core.data.mmd;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Siebe
 * 
 */
public class MMDImporterTest {
    @Test
    public void importTest() {
        MMDImporter importer = new MMDImporter(
                "/Users/Siebe/Documents/game_models/assets/catbeargirl_model/catbeargirl.pmd");
        
        importer.run();
        
        MMDModel m = importer.getModel();
        
        Assert.assertNotNull(m);
    }
}
