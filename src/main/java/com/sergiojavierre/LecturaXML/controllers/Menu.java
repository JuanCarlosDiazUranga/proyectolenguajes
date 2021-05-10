package com.sergiojavierre.LecturaXML.controllers;

import java.util.Scanner;

public class Menu {
    Scanner scanner = new Scanner(System.in);
    //JugadoresControllesrTerminal jugadoresTerminal= new JugadoresControllesrTerminal();
    public void menu(){
        System.out.println("OPCIONES");
        System.out.println("--------");
        System.out.println("1) Mostrar por consola\n2) Actualizar por consola\n3) Salir");
        System.out.print("Opcion:");
        String opcion = scanner.nextLine();
        if (opcion.equals("1")){
            menuMostrar();
        }else if (opcion.equals("2")){
            menuActualizar();
        } else if (opcion.equals("3")){
            System.out.println("Gracias por jugar ;)");
            return;
        }
        else {
            System.out.println(opcion + "No es una opcion");
            menu();
        }
    }


    private void menuMostrar(){
        System.out.println("OPCIONES MENU MOSTRAR");
        System.out.println("---------------------");
        System.out.println("1) Mostrar dos elementos\n" +
                "2) Jugadores con mas de 2 videojuegos\n" +
                "3) Videojuegos que contengan 'cyber'\n" +
                "4) Jugadores que se llamen Unai\n" +
                "5) Atras");
        System.out.print("Opcion:");
        String opcion = scanner.nextLine();
        if (opcion.equals("1")){

            System.out.println("-----------------------------------------------------");
            menu();
        }else if (opcion.equals("2")){

            System.out.println("-----------------------------------------------------");
            menu();
        }else if (opcion.equals("3")){

            System.out.println("-----------------------------------------------------");
            menu();
        }else if (opcion.equals("4")){

            System.out.println("-----------------------------------------------------");
            menu();
        }else if (opcion.equals("5")){
            System.out.println("-----------------------------------------------------");
            menu();
        }
    }
    private void menuActualizar(){
        System.out.println("OPCIONES MENU INSERTAR");
        System.out.println("---------------------");
        System.out.println("1) Añadir nuevo elemento\n" +
                "2) Añadir atributo\n" +
                "3) Actualizar componente de jugador\n" +
                "4) Añadir atributo con condicion\n" +
                "5) Eliminar elementos con un dato\n" +
                "6) Eliminar elementos cuyos atributos contengan un dato\n" +
                "7) Atras");
        System.out.print("Opcion:");
        String opcion = scanner.nextLine();
        if (opcion.equals("1")){
            System.out.print("nombre del jugador: ");
            String nombre = scanner.nextLine();

            System.out.println("-----------------------------------------------------");
            menu();
        }else if (opcion.equals("2")){

            System.out.println("-----------------------------------------------------");
            menu();
        }else if (opcion.equals("3")){

            System.out.println("-----------------------------------------------------");
            menu();
        }else if (opcion.equals("4")){

            System.out.println("-----------------------------------------------------");
            menu();
        }else if (opcion.equals("5")){

            System.out.println("-----------------------------------------------------");
            menu();
        }else if (opcion.equals("6")){

            System.out.println("-----------------------------------------------------");
            menu();
        }else if (opcion.equals("7")){
            System.out.println("-----------------------------------------------------");
            menu();
        }else {
            System.out.println("No es una opcion");
            menuActualizar();
        }
    }

}


