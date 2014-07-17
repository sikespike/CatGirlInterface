/**
 * 
 */
package com.cbg;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.net.URI;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

/**
 * @author Siebe
 * 
 */
public class MapConverter implements Runnable {
    private static int TILE_SIZE = 48;

    private String sourceFile;
    private String destFile;

    private int width;
    private int height;
    private double imageW;
    private double imageH;

    private Tile playerStart;
    private Tile playerFinish;
    private ArrayList<TerrainTile> tileList;

    /**
     * 
     */
    public MapConverter(String sourceFile, String destFile) {
        this.sourceFile = sourceFile;
        this.destFile = destFile;
        tileList = new ArrayList<TerrainTile>();
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Runnable#run()
     */
    public void run() {
        Path sourcePath = Paths.get(URI.create("file://"+this.sourceFile));
        
        System.out.println("Reading file:"+this.sourceFile);
        try {
            BufferedReader bf = Files.newBufferedReader(sourcePath, Charset.forName("UTF-8"));
            StringBuilder bs = new StringBuilder();
            String line = null;
            do{
                line = bf.readLine();
                bs.append(line != null?line.trim():"");
            }while(line != null);
            
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory
                    .newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(new InputSource(new ByteArrayInputStream(bs.toString().getBytes("utf-8"))));

            doc.getDocumentElement().normalize();

            parseMap(doc.getDocumentElement());

            NodeList tilesetElements = doc.getDocumentElement()
                    .getElementsByTagName("tileset");
            parseTileset(tilesetElements);

            NodeList layers = doc.getDocumentElement().getElementsByTagName(
                    "layer");
            parseLayers(layers);

            NodeList objectGroups = doc.getDocumentElement()
                    .getElementsByTagName("objectgroup");
            parseObjectGroups(objectGroups);

            renderFile();
        } catch (Exception t) {
            throw new RuntimeException(t);
        }

    }

    private void renderFile() throws Exception {
        DocumentBuilderFactory docFactory = DocumentBuilderFactory
                .newInstance();
        DocumentBuilder docBuilder = docFactory.newDocumentBuilder();

        Document doc = docBuilder.newDocument();
        Element rootElement = doc.createElement("level");
        doc.appendChild(rootElement);

        rootElement.appendChild(renderSizeElement(doc));

        rootElement.appendChild(renderPlayer(doc));

        rootElement.appendChild(renderMap(doc));

        // write the content into xml file
        TransformerFactory transformerFactory = TransformerFactory
                .newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        DOMSource source = new DOMSource(doc);
        StreamResult result = new StreamResult(new File(this.destFile));

        System.out.println("Writing to file:"+this.destFile);
        transformer.transform(source, result);
    }

    private Element renderMap(Document doc) {
        Element map = doc.createElement("map");

        for (TerrainTile t : this.tileList) {
            Element tile = doc.createElement("tile");
            t.createElement(tile, doc);
            map.appendChild(tile);
        }

        return map;
    }

    private Element renderPlayer(Document doc) {
        Element player = doc.createElement("player");

        Element ps = doc.createElement("start");
        this.playerStart.createElement(ps, doc);

        Element pf = doc.createElement("finish");
        this.playerFinish.createElement(pf, doc);

        player.appendChild(ps);
        player.appendChild(pf);
        return player;
    }

    private Element renderSizeElement(Document doc) {
        Element size = doc.createElement("size");

        Attr w = doc.createAttribute("width");
        w.setValue(this.width + "");
        size.setAttributeNode(w);

        Attr h = doc.createAttribute("height");
        h.setValue(this.height + "");
        size.setAttributeNode(h);

        Attr tw = doc.createAttribute("textureWidth");
        tw.setValue(this.imageW + "");
        size.setAttributeNode(tw);

        Attr th = doc.createAttribute("textureHeight");
        th.setValue(this.imageH + "");
        size.setAttributeNode(th);

        return size;
    }

    private void parseMap(Node map) {
        NamedNodeMap attributes = map.getAttributes();
        this.width = Integer.parseInt(attributes.getNamedItem("width")
                .getNodeValue());
        this.height = Integer.parseInt(attributes.getNamedItem("height")
                .getNodeValue());
    }

    private void parseTileset(NodeList tilesetList) {
        Node tilesetNode = tilesetList.item(0);

        Node image = tilesetNode.getFirstChild();
        NamedNodeMap attributes = image.getAttributes();

        this.imageW = Double.parseDouble(attributes.getNamedItem("width")
                .getNodeValue());
        this.imageH = Double.parseDouble(attributes.getNamedItem("height")
                .getNodeValue());
    }

    private void parseLayers(NodeList layers) {
        for (int x = 0; x < layers.getLength(); x++) {
            Node tileset = layers.item(x);

            String name = tileset.getAttributes().getNamedItem("name")
                    .getNodeValue();
            if (name.equalsIgnoreCase("terrain")) {
                parseTiles(tileset.getFirstChild().getChildNodes());
            }
        }
    }

    private void parseTiles(NodeList tiles) {
        for (int x = 0; x < tiles.getLength(); x++) {
            Node tile = tiles.item(x);

            int tileId = Integer.parseInt(tile.getAttributes()
                    .getNamedItem("gid").getNodeValue());

            if (tileId != 0) {
                tileId--;

                int hPos = (int) Math.floor(tileId / 10.0f);
                int wPos = tileId % 10;

                int xPos = hPos * TILE_SIZE;
                int yPos = wPos * TILE_SIZE;
                TerrainTile t = createTerrainTile(xPos, yPos);
                this.tileList.add(t);
            }
        }
    }

    private Tile createTile(int x, int y) {
        ArrayList<Point> points = new ArrayList<Point>();

        points.add(new Point(x, y));
        points.add(new Point(x + TILE_SIZE, y));
        points.add(new Point(x + TILE_SIZE, y + TILE_SIZE));
        points.add(new Point(x, y + TILE_SIZE));

        Tile t = new Tile(points);

        return t;
    }

    private TerrainTile createTerrainTile(int x, int y) {
        TerrainTile t = new TerrainTile(createTile(x, y));

        ArrayList<UVPoint> upoints = new ArrayList<UVPoint>();

        upoints.add(new UVPoint(x / this.imageH, y / this.imageW));
        upoints.add(new UVPoint((x + TILE_SIZE) / this.imageH, y / this.imageW));
        upoints.add(new UVPoint((x + TILE_SIZE) / this.imageH, (y + TILE_SIZE)
                / this.imageW));
        upoints.add(new UVPoint(x / this.imageH, (y + TILE_SIZE) / this.imageW));

        return t;
    }

    private void parseObjectGroups(NodeList objectGroups) {
        for (int x = 0; x < objectGroups.getLength(); x++) {
            Node group = objectGroups.item(x);

            String name = group.getAttributes().getNamedItem("name")
                    .getNodeValue();
            if (name.equalsIgnoreCase("player")) {
                parsePlayer(group.getChildNodes());
            } else if (name.equalsIgnoreCase("monsters")) {

            }
        }
    }

    private void parsePlayer(NodeList playerList) {
        for (int x = 0; x < playerList.getLength(); x++) {
            Node pNode = playerList.item(x);

            String name = pNode.getAttributes().getNamedItem("name")
                    .getNodeValue();

            int xPos = Integer.parseInt(pNode.getAttributes().getNamedItem("x")
                    .getNodeValue());

            int yPos = Integer.parseInt(pNode.getAttributes().getNamedItem("y")
                    .getNodeValue());

            if (name.equalsIgnoreCase("player_start")) {
                this.playerStart = this.createTile(xPos, yPos);
            } else if (name.equalsIgnoreCase("player_finish")) {
                this.playerFinish = this.createTile(xPos, yPos);
            }
        }
    }
}
