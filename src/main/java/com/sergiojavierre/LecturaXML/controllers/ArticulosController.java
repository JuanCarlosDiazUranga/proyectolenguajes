package com.sergiojavierre.LecturaXML.controllers;

import com.sergiojavierre.LecturaXML.dao.DAOFactory;
import com.sergiojavierre.LecturaXML.entities.Articulo;
import com.sergiojavierre.LecturaXML.entities.Categoria;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;
@Controller
public class ArticulosController {
    @GetMapping("/DosArticulos")
    public String readarticulo(Model model) {
        List<Articulo> articulos = new ArrayList<>();
        articulos.add(DAOFactory.getInstance().getDAOarticulos().getAll().get(0));
        articulos.add(DAOFactory.getInstance().getDAOarticulos().getAll().get(1));
        model.addAttribute("articulos", articulos);
        return "articulos";
    }

    @GetMapping("/jugadoresDosJuegos")
    public String readUser(Model model) {
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

    @GetMapping("/DeleteUnElementoContengaCine")
    public String DeleteUnElementoContengaCine(Model model){
        List<Articulo> articulos = DAOFactory.getInstance().getDAOarticulos().getAll();
        for (int i = 0; i < articulos.size(); i++) {
            List<Categoria> categorias = articulos.get(i).getCategorias();
            for (int j = 0; j < categorias.size(); j++) {
                if (categorias.get(j).getNombre().contains("CINE")) {
                    articulos.remove(i);
                }
            }
        }
        DAOFactory.getInstance().getDAOarticulos().save(articulos);
        return "articulos";
    }
    @GetMapping("/DeleteElementoIgualA")
    public String DeleteElementoIgualA(Model model){
        List<Articulo> articulos = DAOFactory.getInstance().getDAOarticulos().getAll();
        for (int i = 0; i < articulos.size(); i++) {
            List<Categoria> categorias = articulos.get(i).getCategorias();
            for (int j = 0; j < categorias.size(); j++) {
                if (categorias.get(j).getNombre().equals("CINEFILO")) {
                    articulos.remove(i);
                }
            }
        }
        DAOFactory.getInstance().getDAOarticulos().save(articulos);
        return "articulos";
    }

@GetMapping("/CrearArticulo")
public String CrearArticulo(Model model, @RequestParam String codigo,@RequestParam Integer precio){
        Articulo articulo = new Articulo(codigo,precio);
        DAOFactory.getInstance().getDAOarticulos().crear(articulo);
        return "articulos";
        }

    @GetMapping("/CrearCategoria")
    public String CrearCategoria(Model model, @RequestParam String articulocodigo, String categoria){
        List<Articulo> articulos = DAOFactory.getInstance().getDAOarticulos().getAll();
        Categoria categorias = new Categoria(categoria);
        int articulo = Integer.parseInt(articulocodigo);
        DAOFactory.getInstance().getDAOarticulos().crearcategoria(articulocodigo,categorias);
        return "articulos";
    }
    @GetMapping("/actualizarAtributo")
    public String actualizarAtributo(Model model){
        List<Articulo> jugadores = DAOFactory.getInstance().getDAOarticulos().getAll();
        for (int i = 0; i < jugadores.size(); i++) {
            List<Categoria> videojuegos = jugadores.get(i).getCategorias();
            for (int j = 0; j < videojuegos.size(); j++) {
                if (videojuegos.get(j).getNombre().contains("cod")) {
                    videojuegos.get(j).setNombre("call of duty");
                }
            }
        }
        DAOFactory.getInstance().getDAOarticulos().save(jugadores);
        return "users";
    }
}
