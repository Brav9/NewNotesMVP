package com.hfad.newnotesmvp.data.model;

public class Note {

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    String uuid;
    String value;

    public Note(String uuid, String value) {
        this.uuid = uuid;
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
