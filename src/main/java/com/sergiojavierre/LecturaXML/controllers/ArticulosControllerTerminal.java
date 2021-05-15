package com.sergiojavierre.LecturaXML.controllers;


import com.sergiojavierre.LecturaXML.dao.DAOFactory;
import com.sergiojavierre.LecturaXML.entities.Articulo;
import com.sergiojavierre.LecturaXML.entities.Categoria;
import com.sergiojavierre.LecturaXML.entities.Imagen;


import java.util.List;
import java.util.Scanner;

public class ArticulosControllerTerminal {

    Scanner scanner = new Scanner(System.in);

    public void DosArticulos() {
        System.out.println(DAOFactory.getInstance().getDAOarticulos().getAll().get(0));
        System.out.println(DAOFactory.getInstance().getDAOarticulos().getAll().get(1));


    }

    public void ArticulosCon2Categorias() {
        List<Articulo> articulos = DAOFactory.getInstance().getDAOarticulos().getAll();
        for (int i = 0; i < articulos.size(); i++) {
            List<Categoria> categorias = articulos.get(i).getCategorias();
            if (categorias.size() >= 2) {
                System.out.println(articulos.get(i));
            }
        }
    }

    public void getArticulo1() {
        List<Articulo> articulos = DAOFactory.getInstance().getDAOarticulos().getAll();
        for (int i = 0; i < articulos.size(); i++) {

            if (articulos.get(i).getCodigo().contains("1")) {
                System.out.println(articulos.get(i));
            }
        }
    }

    public void getCategoriaContieneCine() {
        List<Articulo> articulos = DAOFactory.getInstance().getDAOarticulos().getAll();
        for (int i = 0; i < articulos.size(); i++) {
            List<Categoria> categorias = articulos.get(i).getCategorias();
            for (int j = 0; j < categorias.size(); j++) {
                if (categorias.get(j).getNombre().contains("CINE")) {
                    System.out.println(categorias);
                }

            }

        }


    }

    public void getCategoriasCINEFILO() {
        List<Articulo> articulos = DAOFactory.getInstance().getDAOarticulos().getAll();
        for (int i = 0; i < articulos.size(); i++) {
            List<Categoria> categorias = articulos.get(i).getCategorias();
            for (int j = 0; j < categorias.size(); j++) {
                if (categorias.get(j).getNombre().equals("CINEFILO")) {
                    System.out.println(categorias);
                }

            }

        }

    }


    public void ActualizarCategoria() {
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
        System.out.println("guardado");
    }


    public void EliminarArticulo1() {
        List<Articulo> articulos = DAOFactory.getInstance().getDAOarticulos().getAll();
        for (int i = 0; i < articulos.size(); i++) {
            if (articulos.get(i).getCodigo().equals("1")) {
                articulos.remove(i);
            }
        }
        DAOFactory.getInstance().getDAOarticulos().save(articulos);
        System.out.println("Guardado");
    }

    public void EliminarCategoriaQueContenga() {
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

    }

    public void añadirimagen() {
        List<Articulo> articulos = DAOFactory.getInstance().getDAOarticulos().getAll();
        for (int i = 0; i < articulos.size(); i++) {
            List<Categoria> categorias = articulos.get(i).getCategorias();
            for (int j = 0; j < categorias.size(); j++) {
                if (categorias.get(j).getNombre().contains("CINE")) {
                    articulos.get(i).añadirimagen(new Imagen("IMAGEN.JPG"));
                }
            }
        }
    }
    public void insertarArticulo(String codigo){
        Articulo articulo = new Articulo(codigo);
        DAOFactory.getInstance().getDAOarticulos().crear(articulo);
        System.out.println("articulo guardado");
    }
}

