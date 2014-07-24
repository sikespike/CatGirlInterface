package com.cbg.core;

import com.cbg.core.data.MMDtoCATConverter;
import com.cbg.core.map.MapConverter;

/**
 * 
 */

/**
 * @author Siebe
 * 
 */
public class CatGirlInterface {

    /**
     * @param args
     */
    public static void main(String[] args) {
        System.out.println("Running with parameters: " + args[0] + ", "
                + args[1] + ", " + args[2] + ", " + args[3]);
        String[] action = args[1].split(":");
        if (action[0].equalsIgnoreCase("map")) {
            if (action[1].equalsIgnoreCase("convert")) {
                String source = args[0] + "/" + args[2];
                String dest = args[0] + "/" + args[3];

                MapConverter converter = new MapConverter(source, dest);
                System.out.println("Starting Convert...");
                converter.run();
                System.out.println("Finished.");
            }
        } else if (action[0].equalsIgnoreCase("model")) {
            if (action[1].equalsIgnoreCase("convert")) {
                String source = args[0] + "/" + args[2];
                String dest = args[0] + "/" + args[3];

                MMDtoCATConverter converter = new MMDtoCATConverter(source,
                        dest);
                System.out.println("Starting Convert...");
                converter.run();
                System.out.println("Finished.");
            }
        }
    }
}
