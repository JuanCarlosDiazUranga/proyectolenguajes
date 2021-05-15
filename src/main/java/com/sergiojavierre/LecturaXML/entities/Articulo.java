package com.sergiojavierre.LecturaXML.entities;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import java.util.ArrayList;
import java.util.List;

@JacksonXmlRootElement(localName = "articulo")
public class Articulo {
    @JacksonXmlProperty(isAttribute = true)
    private String codigo;

    @JacksonXmlProperty(isAttribute = true)
    private Integer precio;
    @JacksonXmlElementWrapper(localName = "categorias")
    @JacksonXmlProperty(localName = "categoria")
    private List<Categoria> categorias=new ArrayList<>();
    @JacksonXmlElementWrapper(localName = "imagenes")
    @JacksonXmlProperty(localName = "imagen")
    List<Imagen> imagenes = new ArrayList<>();


    public Articulo(String codigo){}
    public Articulo(){}

    public Articulo(String codigo, Integer precio,List<Categoria> categorias,List<Imagen> imagenes) {
        this.codigo = codigo;
        this.precio = precio;
        if(categorias != null) {
            this.categorias = categorias;
        }
        else this.categorias = new ArrayList<>();
        if(imagenes != null) {
            this.imagenes = imagenes;
        }
        else this.imagenes = new ArrayList<>();
    }

    public void añadircategoria(Categoria categoria){
        if(this.categorias == null){
            this.categorias = new ArrayList<>();
        }
        categorias.add(categoria);
    }


    public void añadirimagen(Imagen imagen){
        if(this.imagenes == null){
            this.imagenes = new ArrayList<>();
        }
        imagenes.add(imagen);
    }
    public List<Imagen>getImagenes(){
        return imagenes;
    }

    public List<Categoria> getCategorias() {
        return categorias;
    }

    public String getCodigo() {
        return codigo;
    }

    public Integer getPrecio() {
        return precio;
    }

    public String toString() {
        return "Articulo{" +
                "codigo='" + codigo + '\'' +
                ", precio=" + precio +
                ", categorias=" + categorias +
                '}';
    }
}
