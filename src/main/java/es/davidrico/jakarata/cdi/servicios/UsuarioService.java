package es.davidrico.jakarata.cdi.servicios;

import es.davidrico.jakarata.cdi.modelos.Usuario;

import java.util.Optional;

public interface UsuarioService {
    Optional<Usuario> login(String username, String password);
}
