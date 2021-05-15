package com.sergiojavierre.LecturaXML.controllers;

import java.util.Scanner;

public class Menu {
    Scanner scanner = new Scanner(System.in);
    ArticulosControllerTerminal articulosControllerTerminal= new ArticulosControllerTerminal();


    public void menu() {
        System.out.println("OPCIONES");
        System.out.println("--------");
        System.out.println("1)Consola\n2)Actualizar\n3) Salir");
        System.out.print("Opcion:");
        String opcion = scanner.nextLine();
        if (opcion.equals("1")){
            Mostrar();
        }else if (opcion.equals("2")){
            Actualizar();
        } else if (opcion.equals("3")){
            System.out.println("Gracias");
            return;
        }
        else {
            System.out.println(opcion + "No es una opcion");
            menu();
        }
    }
    private void Mostrar(){
        System.out.println("OPCIONES MENU MOSTRAR");
        System.out.println("---------------------");
        System.out.println("1) Mostrar dos elementos\n" +
                "2) Articulos con  2 categorias\n" +
                "3) Categoria que contengan 'CINE'\n" +
                "4) Categoria que se llamen CINEFILO\n" +
                "5) Atras");
        System.out.print("Opcion:");
        String opcion = scanner.nextLine();
        if (opcion.equals("1")){
            articulosControllerTerminal.DosArticulos();
            System.out.println("-----------------------------------------------------");
            menu();
        }else if (opcion.equals("2")){
            articulosControllerTerminal.ArticulosCon2Categorias();
            System.out.println("-----------------------------------------------------");
            menu();
        }else if (opcion.equals("3")){
            articulosControllerTerminal.getCategoriaContieneCine();
            System.out.println("-----------------------------------------------------");
            menu();
        }else if (opcion.equals("4")){
            articulosControllerTerminal.getCategoriasCINEFILO();
            System.out.println("-----------------------------------------------------");
            menu();
        }else if (opcion.equals("5")){
            System.out.println("-----------------------------------------------------");
            menu();
        }
    }
    private void Actualizar(){
        System.out.println("OPCIONES MENU INSERTAR");
        System.out.println("---------------------");
        System.out.println("1) Añadir nuevo elemento\n" +
                "2) Añadir articulo\n" +
                "3) Actualizar categoria de articulo\n" +
                "4) Añadir imagen a articulo\n" +
                "5) Eliminar articulo\n" +
                "6) Eliminar categoria que contiene 1 dato\n" +
                "7) Atras");
        System.out.print("Opcion:");
        String opcion = scanner.nextLine();
        if (opcion.equals("1")){
            System.out.print("codigo del articulo: ");
            String codigo = scanner.nextLine();
            articulosControllerTerminal.insertarArticulo(codigo);
            System.out.println("-----------------------------------------------------");
            menu();
        }else if (opcion.equals("2")){
            articulosControllerTerminal.getArticulo1();
            System.out.println("-----------------------------------------------------");
            menu();
        }else if (opcion.equals("3")){
            articulosControllerTerminal.ActualizarCategoria();
            System.out.println("-----------------------------------------------------");
            menu();
        }else if (opcion.equals("4")){
            articulosControllerTerminal.añadirimagen();
            System.out.println("-----------------------------------------------------");
            menu();
        }else if (opcion.equals("5")){
            articulosControllerTerminal.EliminarArticulo1();
            System.out.println("-----------------------------------------------------");
            menu();
        }else if (opcion.equals("6")){
            articulosControllerTerminal.EliminarCategoriaQueContenga();
            System.out.println("-----------------------------------------------------");
            menu();
        }else if (opcion.equals("7")){
            System.out.println("-----------------------------------------------------");
            menu();
        }else {
            System.out.println("No es una opcion");
            Actualizar();
        }
    }
}


