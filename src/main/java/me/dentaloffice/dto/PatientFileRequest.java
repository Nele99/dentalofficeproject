package me.dentaloffice.dto;

import org.jboss.resteasy.plugins.providers.multipart.MultipartFormDataInput;

public class PatientFileRequest {
    private MultipartFormDataInput input;

    public MultipartFormDataInput getInput() {
        return input;
    }

    public void setInput(MultipartFormDataInput input) {
        this.input = input;
    }
}