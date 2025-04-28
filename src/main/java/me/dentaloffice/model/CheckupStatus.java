package me.dentaloffice.model;
public enum CheckupStatus {

    SCHEDULED("scheduled"),
    COMPLETED("completed"),
    CANCELLED("canceled");

    private final String value;

    CheckupStatus(String value){
        this.value = value;
    }

    public String getValue(){
        return value;
    }
}
