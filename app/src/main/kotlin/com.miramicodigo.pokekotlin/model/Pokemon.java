package com.miramicodigo.pokekotlin.model;

/**
 * Created by gusn8 on 23-06-17.
 */

public class Pokemon {
    private String name;
    private int cp;
    private int photo;

    public Pokemon(String name, int cp, int photo) {
        this.name = name;
        this.cp = cp;
        this.photo = photo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCp() {
        return cp;
    }

    public void setCp(int cp) {
        this.cp = cp;
    }

    public int getPhoto() {
        return photo;
    }

    public void setPhoto(int photo) {
        this.photo = photo;
    }
}
