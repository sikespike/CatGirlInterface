package com.cbg.core.geometry.mmd;

public enum MMDBoneType {
    NORMAL(0),CENTER(1),IK(4),CO_ROTATE(9);
    
    private int type;
    
    private MMDBoneType(int type){
        this.type = type;
    }
    
    public static MMDBoneType getMMDBoneType(int type){
        switch(type){
        case 0:{
            return NORMAL;
        }
        case 1:{
            return CENTER;
        }
        case 4:{
            return IK;
        }
        case 9:{
            return CO_ROTATE;
        }
        default:
            throw new RuntimeException("MMDBoneType not found with ID:"+type);
        }
    }
    
    public int getType(){
        return this.type;
    }
}
