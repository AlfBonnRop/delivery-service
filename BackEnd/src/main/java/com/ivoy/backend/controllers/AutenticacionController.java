package com.ivoy.backend.controllers;

import com.ivoy.backend.dao.UsuarioDao;
import com.ivoy.backend.models.Usuario;
import com.ivoy.backend.utils.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AutenticacionController {
    @Autowired
    private UsuarioDao usrDao;

    @Autowired
    private JWTUtil jwt;

    @RequestMapping(value="login",method= RequestMethod.POST)
    public String login(@RequestBody Usuario u){
        Usuario u2 = usrDao.obtenerUsuarioPorCredenciales(u);
        if (u2!=null){
            return jwt.create(String.valueOf(u2.getId_usuario()), String.valueOf(u2.getAdministrador()));
        }
        return "Okn't";
    }
}
