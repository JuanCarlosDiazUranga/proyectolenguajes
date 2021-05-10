package com.sergiojavierre.LecturaXML.entities;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import java.util.ArrayList;
import java.util.List;
@JacksonXmlRootElement(localName = "data")
public class Data {
    @JacksonXmlElementWrapper(localName = "articulos")
    @JacksonXmlProperty(localName = "articulo")
    List<Articulo> articulos;

    public Data(){}

    public Data(List<Articulo> articulos) {
        if(articulos != null) {
            this.articulos = articulos;
        }
        else this.articulos = new ArrayList<>();
    }

    public List<Articulo> getArticulos() {
        return articulos;
    }

    public void setJugadores(List<Articulo> articulos) {
        this.articulos = articulos;
    }
}

