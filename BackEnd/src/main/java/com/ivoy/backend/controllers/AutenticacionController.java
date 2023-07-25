package com.ivoy.backend.controllers;

import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.ivoy.backend.dao.UsuarioDao;
import com.ivoy.backend.models.Usuario;
import com.ivoy.backend.utils.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
public class AutenticacionController {
    @Autowired
    private UsuarioDao usrDao;

    @Autowired
    private JWTUtil jwt;
    @Autowired
    ObjectMapper mapper;

    @RequestMapping(value="login",method= RequestMethod.POST)
    public ObjectNode login(@RequestBody Usuario u){
        Usuario u2 = usrDao.obtenerUsuarioPorCredenciales(u);
        if (u2!=null){
            ObjectNode objectNode = mapper.createObjectNode();
            objectNode.put("token",jwt.create(String.valueOf(u2.getId_usuario()), String.valueOf(u2.getAdministrador())));
            objectNode.put("admin", u2.getAdministrador());
            return objectNode;
        }
        return null;
    }

    @RequestMapping(value="admin", method=RequestMethod.GET)
    public ObjectNode isAdmin(@RequestHeader(value="Autenticacion") String token){
        ObjectNode objectNode = mapper.createObjectNode();
        objectNode.put("admin", jwt.getValue(token));
        return objectNode;


    }

}
