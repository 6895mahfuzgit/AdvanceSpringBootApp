package com.AdvanceSpringBootApp.enums;

/**
 * Created by user on 22-Feb-17.
 */
public enum PlansEnum {

    BASIC(1, "BASIC"),
    PRO(2, "PRO");

    private final int id;
    private final String planeName;


    PlansEnum(int id, String planeName) {
        this.id = id;
        this.planeName = planeName;
    }

    public int getId() {
        return id;
    }

    public String getPlaneName() {
        return planeName;
    }
}
