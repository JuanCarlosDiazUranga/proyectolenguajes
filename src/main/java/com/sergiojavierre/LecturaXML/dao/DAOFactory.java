package com.sergiojavierre.LecturaXML.dao;

import com.sergiojavierre.LecturaXML.dao.Articulos.DAOArticulos;
import com.sergiojavierre.LecturaXML.dao.Articulos.DAOArticulosXML;

public class DAOFactory {


    private static DAOFactory daoFactory;
    private DAOArticulosXML daoarticulos;

    private DAOFactory(){}

    public static DAOFactory getInstance() {
        if(daoFactory == null){
            daoFactory = new DAOFactory();
        }
        return daoFactory;
    }
    public DAOArticulos getDAOarticulos(){
        if (daoarticulos==null){
            daoarticulos= new DAOArticulosXML();
        }
        return  daoarticulos;
    }
}
