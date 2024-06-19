package es.davidrico.jakarata.cdi.repositorios;

import es.davidrico.jakarata.cdi.modelos.Usuario;

import java.sql.SQLException;

public interface UsuarioRepository extends CrudRepository<Usuario> {
    Usuario porUsername(String username) throws SQLException;
}
