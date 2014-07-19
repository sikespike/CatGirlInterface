/**
 * 
 */
package com.cbg.core.geometry.cat;

import com.cbg.core.geometry.Vector;
import com.cbg.core.geometry.Vector2;

/**
 * @author Siebe
 * 
 */
public class Vertex {
    private Vector position;
    private Vector normal;

    private Vector2 uv;

    public Vertex() {
        this.position = new Vector();
        this.normal = new Vector();
        this.uv = new Vector2();
    }

    @Override
    public String toString() {
        StringBuilder b = new StringBuilder();

        b.append("{position:").append(this.position.toString())
                .append(",normal:").append(this.normal.toString())
                .append(",uv:").append(this.uv.toString()).append("}");

        return b.toString();
    }

    public Vector getPosition() {
        return position;
    }

    public void setPosition(Vector position) {
        this.position = position;
    }

    public Vector getNormal() {
        return normal;
    }

    public void setNormal(Vector normal) {
        this.normal = normal;
    }

    public Vector2 getUv() {
        return uv;
    }

    public void setUv(Vector2 uv) {
        this.uv = uv;
    }
}
