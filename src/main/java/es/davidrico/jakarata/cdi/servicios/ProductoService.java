package es.davidrico.jakarata.cdi.servicios;

import es.davidrico.jakarata.cdi.modelos.Categoria;
import es.davidrico.jakarata.cdi.modelos.Producto;

import java.util.List;
import java.util.Optional;

public interface ProductoService {
    List<Producto> listar();

    Optional<Producto> porId(Long id);

    void guardar(Producto producto);

    void eliminar(Long id);

    List<Categoria> listarCategoria();

    Optional<Categoria> porIdCategoria(Long id);
}
