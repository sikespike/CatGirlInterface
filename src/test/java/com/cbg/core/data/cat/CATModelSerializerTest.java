/**
 * 
 */
package com.cbg.core.data.cat;

import org.junit.Assert;
import org.junit.Test;

import com.cbg.core.data.MMDtoCATTransformer;
import com.cbg.core.data.mmd.MMDImporter;
import com.cbg.core.data.mmd.MMDModel;

/**
 * @author Siebe
 *
 */
public class CATModelSerializerTest {
    @Test
    public void testSerializer(){
        MMDImporter importer = new MMDImporter(
                "/Users/Siebe/Documents/game_models/assets/catbeargirl_model/catbeargirl.pmd");
        
        importer.run();
        
        MMDModel m = importer.getModel();
        
        MMDtoCATTransformer transformer = new MMDtoCATTransformer(m);
        
        transformer.run();
        
        CATModel catModel = transformer.getCatModel();
        
        CATModelSerializer serializer = new CATModelSerializer(catModel);
        
        String serializedModel = serializer.serialize();
        
        Assert.assertNotNull(serializedModel);
    }
}
