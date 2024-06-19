package es.davidrico.jakarata.cdi.servicios;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import es.davidrico.jakarata.cdi.configuracion.ProductoServicePrincipal;
import es.davidrico.jakarata.cdi.configuracion.Service;
import es.davidrico.jakarata.cdi.interceptores.Logging;
import es.davidrico.jakarata.cdi.modelos.Categoria;
import es.davidrico.jakarata.cdi.modelos.Producto;
import es.davidrico.jakarata.cdi.repositorios.CrudRepository;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Service
@ProductoServicePrincipal
public class ProductoServiceJdbcImpl implements ProductoService{
    @Inject
    private CrudRepository<Producto> crudRepositoryJdbc;

    @Inject
    private CrudRepository<Categoria> crudRepositoryCategoriaJdbc;

    @Override
    public List<Producto> listar() {
        try {
            return crudRepositoryJdbc.listar();
        } catch (SQLException throwables) {
            throw new ServiceJdbcException(throwables.getMessage(), throwables.getCause());
        }
    }

    @Override
    public Optional<Producto> porId(Long id) {
        try {
            return Optional.ofNullable(crudRepositoryJdbc.porId(id));
        } catch (SQLException throwables) {
            throw new ServiceJdbcException(throwables.getMessage(), throwables.getCause());

        }
    }

    @Override
    public void guardar(Producto producto) {
        try {
            crudRepositoryJdbc.guardar(producto);
        } catch (SQLException throwables) {
            throw new ServiceJdbcException(throwables.getMessage(), throwables.getCause());
        }
    }

    @Override
    public void eliminar(Long id) {
        try {
            crudRepositoryJdbc.eliminar(id);
        } catch (SQLException throwables) {
            throw new ServiceJdbcException(throwables.getMessage(), throwables.getCause());
        }
    }

    @Override
    public List<Categoria> listarCategoria() {
        try {
            return crudRepositoryCategoriaJdbc.listar();
        } catch (SQLException throwables) {
            throw new ServiceJdbcException(throwables.getMessage(), throwables.getCause());
        }
    }

    @Override
    public Optional<Categoria> porIdCategoria(Long id) {
        try {
            return Optional.ofNullable(crudRepositoryCategoriaJdbc.porId(id));
        } catch (SQLException throwables) {
            throw new ServiceJdbcException(throwables.getMessage(), throwables.getCause());
        }
    }
}
