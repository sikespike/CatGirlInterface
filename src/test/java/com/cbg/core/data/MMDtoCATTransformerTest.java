/**
 * 
 */
package com.cbg.core.data;

import org.junit.Assert;

import org.junit.Test;

import com.cbg.core.data.cat.CATModel;
import com.cbg.core.data.mmd.MMDImporter;
import com.cbg.core.data.mmd.MMDModel;

/**
 * @author Siebe
 *
 */
public class MMDtoCATTransformerTest {
    @Test
    public void transformerTest(){
        MMDImporter importer = new MMDImporter(
                "/Users/Siebe/Documents/game_models/assets/catbeargirl_model/catbeargirl.pmd");
        
        importer.run();
        
        MMDModel m = importer.getModel();
        
        MMDtoCATTransformer transformer = new MMDtoCATTransformer(m);
        
        transformer.run();
        
        CATModel catModel = transformer.getCatModel();
        
        Assert.assertNotNull(catModel);
    }
}
