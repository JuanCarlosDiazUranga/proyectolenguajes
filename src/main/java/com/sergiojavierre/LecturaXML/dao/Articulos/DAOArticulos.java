package com.sergiojavierre.LecturaXML.dao.Articulos;


import com.sergiojavierre.LecturaXML.entities.Articulo;
import com.sergiojavierre.LecturaXML.entities.Categoria;

import java.util.List;

public interface DAOArticulos {
    public Articulo exists(String codigo);
    public String crear(Articulo articulo);
    public void eliminar(String codigo,Articulo articulo);
    public List<Articulo> getAll();
    public void save(List<Articulo> articulos);
    public void crearcategoria(String codigo, Categoria categoria);


}
