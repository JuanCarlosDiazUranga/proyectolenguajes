package com.sergiojavierre.LecturaXML.controllers;

import com.sergiojavierre.LecturaXML.dao.DAOFactory;
import com.sergiojavierre.LecturaXML.entities.Articulo;
import com.sergiojavierre.LecturaXML.entities.Categoria;
import com.sergiojavierre.LecturaXML.entities.Imagen;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;
@Controller
public class ArticulosController {
    //Dos datos (elementos hijos o atributos) de todos los elementos de un documento
    @GetMapping("/DosArticulos")
    public String DosArticulos(Model model) {
        List<Articulo> articulos = new ArrayList<>();
        articulos.add(DAOFactory.getInstance().getDAOarticulos().getAll().get(0));
        articulos.add(DAOFactory.getInstance().getDAOarticulos().getAll().get(1));
        model.addAttribute("articulos", articulos);
        return "articulos";
    }
//Los elementos que cumplan una condición de comparación (mayor, menor, igual, etc.)
    @GetMapping("/DosCategorias")
    public String Dosacticulos(Model model) {
        List<Articulo> articulos = DAOFactory.getInstance().getDAOarticulos().getAll();
        List<Articulo> articuloaPasar = new ArrayList<>();
        for (int i = 0; i < articulos.size(); i++) {
            List<Categoria> categorias = articulos.get(i).getCategorias();
            if (categorias.size() >= 2) {
                articuloaPasar.add(articulos.get(i));
            }
        }
        model.addAttribute("articulos", articuloaPasar);
        return "articulos";
    }
//Los elementos que contengan una cadena de texto en su interior o uno de sus atributos
    @GetMapping("/CategoriaCine")
    public String categoriacine(Model model) {
        List<Articulo> articulos = DAOFactory.getInstance().getDAOarticulos().getAll();
        List<Articulo> articuloaPasar = new ArrayList<>();
        for (int i = 0; i < articulos.size(); i++) {
            List<Categoria> categorias = articulos.get(i).getCategorias();
            for (int j = 0; j < categorias.size(); j++) {
                if (categorias.get(j).getNombre().contains("CINE")) {
                    articuloaPasar.add(articulos.get(i));
                }
            }
        }
        model.addAttribute("articulos", articuloaPasar);
        return "articulos";
    }
    //Los elementos que sean un texto exacto en su interior o uno de sus atributos
    @GetMapping("/CategoriaCINEFILO")
    public String CategoriaCINEFILO(Model model) {
        List<Articulo> articulos = DAOFactory.getInstance().getDAOarticulos().getAll();
        List<Articulo> articuloaPasar = new ArrayList<>();
        for (int i = 0; i < articulos.size(); i++) {
            List<Categoria> categorias = articulos.get(i).getCategorias();
            for (int j = 0; j < categorias.size(); j++) {
                if (categorias.get(j).getNombre().equals(             "CINEFILO")) {
                    articuloaPasar.add(articulos.get(i));
                }
            }
        }
        model.addAttribute("articulos", articuloaPasar);
        return "articulos";
    }
//Los elementos que contengan un dato
    @GetMapping("/DeleteUnElementoContengaCine")
    public String DeleteUnElementoContengaCine(Model model){
        List<Articulo> articulos = DAOFactory.getInstance().getDAOarticulos().getAll();
        for (int i = 0; i < articulos.size(); i++) {
            List<Categoria> categorias = articulos.get(i).getCategorias();
            for (int j = 0; j < categorias.size(); j++) {
                if (categorias.get(j).getNombre().contains("comunica")) {
                    articulos.remove(i);
                }
            }
        }
        DAOFactory.getInstance().getDAOarticulos().save(articulos);
        return "articulos";
    }
    //Los elementos cuyos atributos contengan un dato
    @GetMapping("/DeleteElementoIgualA")
    public String DeleteElementoIgualA(Model model){
        List<Articulo> articulos = DAOFactory.getInstance().getDAOarticulos().getAll();
        for (int i = 0; i < articulos.size(); i++) {
            List<Categoria> categorias = articulos.get(i).getCategorias();
            for (int j = 0; j < categorias.size(); j++) {
                if (categorias.get(j).getNombre().equals("electronica")) {
                    articulos.remove(i);
                }
            }
        }
        DAOFactory.getInstance().getDAOarticulos().save(articulos);
        return "articulos";
    }
//Un elemento a un elemento padre
   @GetMapping("/CrearArticulo")
    public String CrearArticulo(Model model, @RequestParam String codigo, @RequestParam Integer precio){
        Articulo articulo = new Articulo(codigo,precio,null,null);
      DAOFactory.getInstance().getDAOarticulos().crear(articulo);
      return "articulos";
   }
    //Añade un atributo a los elementos que cumplan una condición

    @GetMapping("/CrearCategoria")
    public String CrearCategoria(Model model, @RequestParam String articulocodigo, String categoria){
        List<Articulo> articulos = DAOFactory.getInstance().getDAOarticulos().getAll();
        Categoria categorias = new Categoria(categoria);
        int articulo = Integer.parseInt(articulocodigo);
        DAOFactory.getInstance().getDAOarticulos().crearcategoria(articulocodigo,categorias);
        return "articulos";
    }
//El valor de un atributo realizando un filtro sobre cualquier atributo
    @GetMapping("/ActualizarCategoria")
    public String ActualizarCategoria(Model model){
        List<Articulo> articulos = DAOFactory.getInstance().getDAOarticulos().getAll();
        for (int i = 0; i < articulos.size(); i++) {
            List<Categoria> categorias = articulos.get(i).getCategorias();
            for (int j = 0; j < categorias.size(); j++) {
                if (categorias.get(j).getNombre().contains("CINE")) {
                    categorias.get(j).setNombre("CINEFILOSS");
                }
            }
        }
        DAOFactory.getInstance().getDAOarticulos().save(articulos);
        return "articulos";
    }
    @GetMapping("/AñadirImagen")
    public String AñadirImagen(Model model){
        List<Articulo> articulos = DAOFactory.getInstance().getDAOarticulos().getAll();
        for (int i = 0; i < articulos.size(); i++) {
            List<Categoria> categorias = articulos.get(i).getCategorias();
            for (int j = 0; j < categorias.size(); j++) {
                if (categorias.get(j).getNombre().contains("CINE")) {
                    articulos.get(i).añadirimagen(new Imagen("IMAGEN1"));
                }
            }
        }
        DAOFactory.getInstance().getDAOarticulos().save(articulos);
        return "articulos";
    }
}
