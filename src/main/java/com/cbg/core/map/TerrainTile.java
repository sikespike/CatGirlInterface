/**
 * 
 */
package com.cbg.core.map;

import java.util.ArrayList;
import java.util.List;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

/**
 * @author Siebe
 *
 */
public class TerrainTile extends Tile {

    private List<UVPoint> upoints;
    /**
     * 
     */
    public TerrainTile() {
        super();
        upoints = new ArrayList<UVPoint>();
    }

    public TerrainTile(Tile t){
        super(t.getPoints());
        upoints = new ArrayList<UVPoint>();
    }
    
    /**
     * @param points
     * @param upoints
     */
    public TerrainTile(List<Point> points, List<UVPoint> upoints) {
        super(points);
        this.upoints = upoints;
    }

    public void addUVPoint(UVPoint p){
        if(upoints.size() < LIMIT){
            upoints.add(p);
        }
    }

    /* (non-Javadoc)
     * @see com.cbg.Tile#createElement(org.w3c.dom.Element, org.w3c.dom.Document)
     */
    @Override
    public void createElement(Element el, Document doc) {
        super.createElement(el, doc);
        
        Element coord = doc.createElement("uvcoordinates");
        for(UVPoint p:upoints){
            Element point = doc.createElement("point");
            Attr x = doc.createAttribute("x");
            x.setValue(p.getX() + "");
            point.setAttributeNode(x);

            Attr y = doc.createAttribute("y");
            y.setValue(p.getY() + "");
            point.setAttributeNode(y);
            
            coord.appendChild(point);
        }
        
        el.appendChild(coord);
    }

}
