package me.dentaloffice.model;
public enum UserRole {

    SCHEDULED("superadmin"),
    COMPLETED("admin"),
    CANCELLED("user");

    private final String value;

    UserRole(String value){
        this.value = value;
    }

    public String getValue(){
        return value;
    }
}