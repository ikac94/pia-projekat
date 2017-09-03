package com.avio.model;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Ilija Knezevic
 */
public enum UserType {
    ADMIN("Admin"), PILOT("Pilot"), FLIGHT_ATTENDANT("Flight attendant"), WORKER("Worker");
    
    String desc;

    private UserType(String desc) {
        this.desc = desc;
    }

    public String getDesc() {
        return desc;
    }
    
    public static UserType ofValue(String desc) {
        for (UserType type : values()) {
            if (type.getDesc().equals(desc)) {
                return type;
            }
        }
        return null;
    }
    
    public static List<UserType> getValues() {
        return Arrays.asList(values());
    }
} 
