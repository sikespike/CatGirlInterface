/**
 * 
 */
package com.cbg.core.geometry.cat;

import com.cbg.core.geometry.Vector;

/**
 * @author Siebe
 *
 */
public class Bone {
    private String name;
    private Bone parent;
    private Bone child;
    private int type;
    private Bone target;
    
    private Vector position;

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the parent
     */
    public Bone getParent() {
        return parent;
    }

    /**
     * @param parent the parent to set
     */
    public void setParent(Bone parent) {
        this.parent = parent;
    }

    /**
     * @return the child
     */
    public Bone getChild() {
        return child;
    }

    /**
     * @param child the child to set
     */
    public void setChild(Bone child) {
        this.child = child;
    }

    /**
     * @return the type
     */
    public int getType() {
        return type;
    }

    /**
     * @param type the type to set
     */
    public void setType(int type) {
        this.type = type;
    }

    /**
     * @return the target
     */
    public Bone getTarget() {
        return target;
    }

    /**
     * @param target the target to set
     */
    public void setTarget(Bone target) {
        this.target = target;
    }

    /**
     * @return the position
     */
    public Vector getPosition() {
        return position;
    }

    /**
     * @param position the position to set
     */
    public void setPosition(Vector position) {
        this.position = position;
    }
}
