package com.ivoy.backend.controllers;

import com.ivoy.backend.dao.EnvioDao;
import com.ivoy.backend.models.Envio;
import com.ivoy.backend.utils.JWTUtil;
import io.jsonwebtoken.MalformedJwtException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.web.PageableHandlerMethodArgumentResolver;
import org.springframework.util.AutoPopulatingList;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class EnvioController {
    @Autowired
    private EnvioDao envioDao;
    @Autowired
    private JWTUtil jwt;

    public String sesionActiva(String token){
        try {
            return jwt.getKey(token);
        }catch (MalformedJwtException ex){
            return null;
        }
    }

    public boolean isAdmin(String token){
        try{
            return jwt.getValue(token).equals("1");
        }catch (MalformedJwtException ex){
            return false;
        }
    }

    @RequestMapping(value="envio", method = RequestMethod.POST)
    public void crearEnvio(@RequestHeader(value="Autenticacion") String token,
                           @RequestBody Envio e){
        try{
            String usrId = sesionActiva(token);
            e.setId_usuario((Integer.valueOf(sesionActiva(token))));
            envioDao.crearEnvio(e);
        }catch(MalformedJwtException ex){
            System.out.println("No hay sesion iniciada error 403");
        }
    }

    @RequestMapping(value="envios/pendientes", method=RequestMethod.GET)
    public List<Envio> getEnviosPendientes(@RequestHeader(value="Autenticacion") String token){
        if(sesionActiva(token)!=null){
            return envioDao.getEnviosPendientes();
        }else{
            return null;
        }
    }
    @RequestMapping(value="envios/pendientesid", method=RequestMethod.GET)
    public List<Envio> getEnviosPendientesId(@RequestHeader(value="Autenticacion") String token){
        String id = sesionActiva(token);
        if(id!=null){
            return envioDao.getEnviosPendientes(id);
        }else{
            return null;
        }
    }

    @RequestMapping(value="envios/entregados", method=RequestMethod.GET)
    public List<Envio> getEnviosEntregados(@RequestHeader(value="Autenticacion") String token){
        if(sesionActiva(token)!=null){
            return envioDao.getEnviosEntregados();
        }else{
            return null;
        }
    }

    @RequestMapping(value="envios/entregadosid", method=RequestMethod.GET)
    public List<Envio> getEnviosEntregadosId(@RequestHeader(value="Autenticacion") String token){
        String id = sesionActiva(token);
        if(id!=null){
            return envioDao.getEnviosEntregados(id);
        }else{
            return null;
        }
    }

    @RequestMapping(value="envio/{id}", method=RequestMethod.GET)
    public Envio getEnvio(@RequestHeader(value="Autenticacion") String token,
                          @PathVariable String id){
        String idU = sesionActiva(id);
        if(id!= null){
            return envioDao.getEnvio(id);
        }
        return null;
    }

    @RequestMapping(value="envio/marcar/{id}", method=RequestMethod.POST)
    public void marcarEnvio(@RequestHeader(value="Autenticacion") String token,
                            @PathVariable String id){
        if(isAdmin(token)){
            envioDao.marcarEnvio(id);
        }else{
            System.out.println("Sin permisos necesarios");
        }
    }

    @RequestMapping(value="envio/{idE}/asignar/{idR}", method=RequestMethod.POST)
    public void asignarEnvio(@RequestHeader(value = "Autenticacion") String token,
                             @PathVariable String idE,
                             @PathVariable String idR){
        if(isAdmin(token)){
            envioDao.asignarEnvio(idE,idR);
        }else{
            System.out.println("Sin permisos necesarios");
        }
    }

}
