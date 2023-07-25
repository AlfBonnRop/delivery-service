package com.ivoy.backend.dao;

import com.ivoy.backend.models.Usuario;
import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
@Transactional
public class UsuarioDaoImp implements UsuarioDao{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Usuario> getUsuarios() {
        String query = "FROM Usuario";
        return entityManager.createQuery(query).getResultList();
    }

    @Override
    public Usuario getUsuario(String id) {
        String query = "FROM Usuario WHERE id = :id";
        List<Usuario> l = entityManager.createQuery(query).setParameter("id", id).getResultList();
        if(l.isEmpty()){return null;}
        return l.get(0);
    }

    @Override
    public void registrarUsuario(Usuario u){
        entityManager.merge(u);
    }

    @Override
    public Usuario obtenerUsuarioPorCredenciales(Usuario u){
        String query = "FROM Usuario WHERE email = :email";
        List<Usuario> l = entityManager.createQuery(query).setParameter("email", u.getEmail()).getResultList();
        if(l.isEmpty()){
            return null;}
        Argon2 ar = Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2id);
        String passHash = l.get(0).getPassword();
        if (ar.verify(passHash, u.getPassword())){
            return l.get(0);
        }else{
            return null;
        }
    }


}
