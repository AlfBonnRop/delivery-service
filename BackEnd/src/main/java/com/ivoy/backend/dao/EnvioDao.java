package com.ivoy.backend.dao;

import com.ivoy.backend.models.Envio;
import com.ivoy.backend.models.Usuario;

import java.util.List;

public interface EnvioDao {
    void crearEnvio(Envio envio);
    List<Envio> getEnviosPendientes();
    List<Envio> getEnviosPendientes(String id);
    List<Envio> getEnviosEntregados();
    List<Envio> getEnviosEntregados(String usrId);
    Envio getEnvio(String envId);
    void marcarEnvio(String id);
    void asignarEnvio(String idE, String idR);
    /*
    Envio modificarEnvio(Envio envio); */
}





