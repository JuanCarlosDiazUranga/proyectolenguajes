package com.sergiojavierre.LecturaXML.controllers;

import com.sergiojavierre.LecturaXML.dao.DAOFactory;
import com.sergiojavierre.LecturaXML.entities.Articulo;
import com.sergiojavierre.LecturaXML.entities.Categoria;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

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

    @GetMapping("/ArticulosConDosCategorias")
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
            if (categorias.equals("CINEFILO")) {
                articuloaPasar.add(articulos.get(i));
            }
        }
        model.addAttribute("articulos", articuloaPasar);
        return "articulos";
    }
}
