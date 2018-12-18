package com.example.rafa.deardeath2characters;

public class Personaje {
    private String _nombre;
    private String _ataque;
    private String _defensa;
    private int image;

    public Personaje(String _nombre, String _ataque, String _defensa, int image) {
        this._nombre = _nombre;
        this._ataque = _ataque;
        this._defensa = _defensa;

        this.image = image;
    }

    public String get_nombre() {
        return _nombre;
    }

    public void set_nombre(String _nombre) {
        this._nombre = _nombre;
    }

    public String get_ataque() {
        return _ataque;
    }

    public void set_ataque(String _ataque) {
        this._ataque = _ataque;
    }

    public String get_defensa() {
        return _defensa;
    }

    public void set_defensa(String _defensa) {
        this._defensa = _defensa;
    }



    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
