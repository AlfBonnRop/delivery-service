package com.ivoy.backend.controllers;

import com.ivoy.backend.dao.UsuarioDao;
import com.ivoy.backend.models.Usuario;
import com.ivoy.backend.utils.JWTUtil;
import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;
import io.jsonwebtoken.MalformedJwtException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import org.springframework.web.bind.annotation.*;

//@PathVariable int id

@RestController
@CrossOrigin(origins = "*")
public class UsuarioController {

    @Autowired
    private UsuarioDao usrDao;
    @Autowired
    private JWTUtil jwt;
    public String sesionActiva(String token){
        try{
            return jwt.getKey(token);
        }catch (MalformedJwtException ex){
            return null;
        }
    }

    public Usuario getUsuarioToken(String token){
        String id =sesionActiva(token);
        if (id != null){
            return usrDao.getUsuario(id);
        }else{
            return null;
        }
    }

    @RequestMapping(value = "usuario/{id}", method = RequestMethod.GET)
    public Usuario getUsuarioId(@RequestHeader(value="Autenticacion") String token,@PathVariable String id){
        String ids = sesionActiva(token);
        if(ids!=null){
            return usrDao.getUsuario(id);
        }
        return null;
    }



    @RequestMapping(value = "usuario", method = RequestMethod.POST)
    public void registrarUsuario(@RequestBody Usuario u){
        System.out.println("Si 1");
        Argon2 ar = Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2id);
        u.setPassword(ar.hash(2,1024,1,u.getPassword()));
        usrDao.registrarUsuario(u);
    }

}
