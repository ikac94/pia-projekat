package com.avio.model;

/**
 *
 * @author Ilija Knezevic
 */
public enum Sex {
    M("M"), F("F");
    
    private String desc;

    private Sex(String desc) {
        this.desc = desc;
    }

    public String getDesc() {
        return desc;
    }
    
    public static Sex ofValue(String desc) {
        for (Sex type : values()) {
            if (type.getDesc().equals(desc)) {
                return type;
            }
        }
        return null;
    }
}
