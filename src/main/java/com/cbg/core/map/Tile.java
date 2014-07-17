package com.cbg.core.map;

import java.util.ArrayList;
import java.util.List;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class Tile {
    public static int LIMIT = 4;
    
    private List<Point> points;
    
    
    public Tile() {
        points = new ArrayList<Point>();
        
    }

    public Tile(List<Point> points){
        super();
        this.points = points;
    }
    
    public void addPoint(Point p){
        if(points.size() < LIMIT){
            points.add(p);
        }
    }
    
    public List<Point> getPoints(){
        return points;
    }
    
    public void createElement(Element el, Document doc){
        Element coord = doc.createElement("coordinates");
        for(Point p:points){
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
