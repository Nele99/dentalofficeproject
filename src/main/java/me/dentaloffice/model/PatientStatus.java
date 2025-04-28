package me.dentaloffice.model;
public enum PatientStatus {
    PRIVATE("private"),
    INSURED("insured");
    private final String value;
    PatientStatus(String value){
        this.value = value;
    }
    public String getValue(){
        return value;
    }
}
