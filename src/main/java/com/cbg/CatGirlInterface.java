package com.cbg;

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
        }
    }

}
