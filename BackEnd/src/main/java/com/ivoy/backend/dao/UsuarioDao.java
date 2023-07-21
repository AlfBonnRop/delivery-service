package com.ivoy.backend.dao;

import java.util.List;
import com.ivoy.backend.models.Usuario;

public interface UsuarioDao {
    List<Usuario>getUsuarios();
    Usuario getUsuario(String id);
    void registrarUsuario(Usuario u);
    Usuario obtenerUsuarioPorCredenciales(Usuario u);
}
