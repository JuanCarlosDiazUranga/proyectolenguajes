package com.sergiojavierre.LecturaXML.controllers;


import com.sergiojavierre.LecturaXML.dao.DAOFactory;
import com.sergiojavierre.LecturaXML.entities.Articulo;
import com.sergiojavierre.LecturaXML.entities.Categoria;


import java.util.List;
import java.util.Scanner;

public class ArticulosControllerTerminal {

    Scanner scanner = new Scanner(System.in);

    public void DosArticulos() {
        System.out.println(DAOFactory.getInstance().getDAOarticulos().getAll().get(0));
        System.out.println(DAOFactory.getInstance().getDAOarticulos().getAll().get(1));


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
                    categorias.get(j).setNombre("CINEFILO");
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

    /*Scanner scanner = new Scanner(System.in);
    public void muestraDosJugadores(){
        System.out.println(DAOFactory.getInstance().getDaoUsers().getAll().get(0));
        System.out.println(DAOFactory.getInstance().getDaoUsers().getAll().get(1));
    }
    public void jugadoresDosJuegos(){
        List<Jugador> jugadores = DAOFactory.getInstance().getDaoUsers().getAll();
        for (int i = 0; i < jugadores.size(); i++) {
            List<Videojuegos> videojuegos = jugadores.get(i).getVideojuegos();
            if (videojuegos.size() >= 2){
                System.out.println(jugadores.get(i));
            }
        }
    }

    public void juegoCyber(){
        List<Jugador> jugadores = DAOFactory.getInstance().getDaoUsers().getAll();
        for (int i = 0; i < jugadores.size(); i++) {
            List<Videojuegos> videojuegos = jugadores.get(i).getVideojuegos();
            for (int j = 0; j < videojuegos.size(); j++) {
                if (videojuegos.get(j).getNombre().contains("cyber")){
                    System.out.println(jugadores.get(i));
                }
            }
        }
    }

    public void jugadorUnai(){
        List<Jugador> jugadores = DAOFactory.getInstance().getDaoUsers().getAll();
        for (int i = 0; i < jugadores.size(); i++) {
            if (jugadores.get(i).getNombre().equals("unai")){
                System.out.println(jugadores.get(i));
            }
        }
    }

    public void insertarElemento(String nombre){
        Jugador jugador = new Jugador(nombre);
        DAOFactory.getInstance().getDaoUsers().add(jugador);
        System.out.println("jugador guardado");
    }

    public void insertarAtributo(){
        List<Jugador> jugadores = DAOFactory.getInstance().getDaoUsers().getAll();
        int i = 1;
        for (Jugador jugador : jugadores){
            System.out.println(i+") "+jugador.getNombre());
            i++;
        }
        System.out.print("Elige un jugador: ");
        String opcionJugador = scanner.nextLine();
        int opcionJugadorInt = Integer.parseInt(opcionJugador);
        System.out.print("Elige un videojuego: ");
        String opcionVideojuego = scanner.nextLine();
        Videojuegos videojuego = new Videojuegos(opcionVideojuego);
        DAOFactory.getInstance().getDaoUsers().addVideojuego(opcionJugadorInt,videojuego);
        System.out.println("Atributo guardado");
    }

    public void actualizarAtributo() {
        List<Jugador> jugadores = DAOFactory.getInstance().getDaoUsers().getAll();
        for (int i = 0; i < jugadores.size(); i++) {
            List<Videojuegos> videojuegos = jugadores.get(i).getVideojuegos();
            for (int j = 0; j < videojuegos.size(); j++) {
                if (videojuegos.get(j).getNombre().contains("cod")) {
                    videojuegos.get(j).setNombre("call of duty");
                }
            }
        }
        DAOFactory.getInstance().getDaoUsers().save(jugadores);
        System.out.println("guardado");
    }

    public void añadirAtributoCondicion(){
        List<Jugador> jugadores = DAOFactory.getInstance().getDaoUsers().getAll();
        for (int i = 0; i < jugadores.size(); i++) {
            List<Videojuegos> videojuegos = jugadores.get(i).getVideojuegos();
            for (int j = 0; j < videojuegos.size(); j++) {
                if (videojuegos.get(j).getNombre().contains("cyber")) {
                    jugadores.get(i).addComponente(new Componente(5));
                }
            }
        }
        DAOFactory.getInstance().getDaoUsers().save(jugadores);
        System.out.println("guardado");
    }

    public void eliminarElementos(){
        List<Jugador> jugadores = DAOFactory.getInstance().getDaoUsers().getAll();
        for (int i = 0; i < jugadores.size(); i++) {
            if (jugadores.get(i).getNombre().equals("unai")){
                jugadores.remove(i);
            }
        }
        DAOFactory.getInstance().getDaoUsers().save(jugadores);
        System.out.println("Guardado");
    }

    public void eliminarElementoAtributo(){
        List<Jugador> jugadores = DAOFactory.getInstance().getDaoUsers().getAll();
        for (int i = 0; i < jugadores.size(); i++) {
            List<Videojuegos> videojuegos = jugadores.get(i).getVideojuegos();
            for (int j = 0; j < videojuegos.size(); j++) {
                if (videojuegos.get(j).getNombre().contains("cyber")) {
                    jugadores.remove(i);
                }
            }
        }
        DAOFactory.getInstance().getDaoUsers().save(jugadores);
>>>>>>> 47ed7c46fba509ca7ce97d16270f1990e240224a
        System.out.println("guardado");
    }
}

<<<<<<< HEAD





=======
     */
    }
}
