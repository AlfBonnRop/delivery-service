package com.ivoy.backend.controllers;

import com.ivoy.backend.dao.UsuarioDao;
import com.ivoy.backend.models.Usuario;
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

    @RequestMapping(value = "usuarios",method = RequestMethod.GET)
    public List<Usuario> getUsuarioId(){
        return usrDao.getUsuarios();
    }

    /*
    @RequestMapping(value = "usuario/{id}", method = RequestMethod.GET)
    public Usuario getUsuarioId(@PathVariable int id){

    }*/







}
