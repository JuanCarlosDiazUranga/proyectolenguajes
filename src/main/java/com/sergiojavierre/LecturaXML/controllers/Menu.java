package com.sergiojavierre.LecturaXML.controllers;

import java.util.Scanner;

public class Menu {
    Scanner scanner = new Scanner(System.in);
    //JugadoresControllesrTerminal jugadoresTerminal= new JugadoresControllesrTerminal();
    public void menu() {
        System.out.println("OPCIONES");
        System.out.println("--------");
        System.out.println("1) Mostrar por consola\n2) Actualizar por consola\n3) Salir");
        System.out.print("Opcion:");
        String opcion = scanner.nextLine();
        if (opcion.equals("1")) {

        } else if (opcion.equals("2")) {

        } else if (opcion.equals("3")) {
            System.out.println("FIN ;)");
            return;
        } else {
            System.out.println(opcion + "INVALIDO");
            menu();
        }

    }
    }



