package com.example.rafa.deardeath2characters;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

public class Personaje implements Parcelable {
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


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this._nombre);
        dest.writeString(this._ataque);
        dest.writeString(this._defensa);
        dest.writeInt(this.image);
    }

    protected Personaje(Parcel in) {
        this._nombre = in.readString();
        this._ataque = in.readString();
        this._defensa = in.readString();
        this.image = in.readInt();
    }

    public static final Creator<Personaje> CREATOR = new Creator<Personaje>() {
        @Override
        public Personaje createFromParcel(Parcel source) {
            return new Personaje(source);
        }

        @Override
        public Personaje[] newArray(int size) {
            return new Personaje[size];
        }
    };
}
