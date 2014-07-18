package com.cbg.core.data.util;

import com.cbg.core.data.mmd.MMDImporter;

public class MMDUtils {

    public static MMDImporter getImporter(String fileName){
        MMDImporter im = new MMDImporter(fileName);
        
        return im;
    }

}
