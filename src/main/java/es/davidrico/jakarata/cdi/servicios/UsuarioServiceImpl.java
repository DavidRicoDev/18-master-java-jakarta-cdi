package es.davidrico.jakarata.cdi.servicios;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import es.davidrico.jakarata.cdi.configuracion.Service;
import es.davidrico.jakarata.cdi.modelos.Usuario;
import es.davidrico.jakarata.cdi.repositorios.UsuarioRepository;

import java.sql.SQLException;
import java.util.Optional;

@Service
public class UsuarioServiceImpl implements UsuarioService{
    private UsuarioRepository usuarioRepository;

    @Inject
    public UsuarioServiceImpl(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public Optional<Usuario> login(String username, String password) {
        try {
            return Optional.ofNullable(usuarioRepository.porUsername(username)).filter(u -> u.getPassword().equals(password));
        } catch (SQLException throwables) {
            throw new ServiceJdbcException(throwables.getMessage(), throwables.getCause());
        }
    }
}
