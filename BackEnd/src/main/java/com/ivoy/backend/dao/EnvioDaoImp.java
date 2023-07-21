package com.ivoy.backend.dao;

import com.ivoy.backend.models.Envio;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class EnvioDaoImp implements EnvioDao {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void crearEnvio(Envio envio){
        entityManager.merge(envio);
    }

    @Override
    public List<Envio> getEnviosPendientes(){
        String query = "FROM Envio WHERE entregado = 0";
        return entityManager.createQuery(query).getResultList();
    }
    @Override
    public List<Envio> getEnviosPendientes(String id){
        String query = "FROM Envio WHERE id_usuario = :id AND entregado = 0";
        return entityManager.createQuery(query).setParameter("id",id).getResultList();
    }

    @Override
    public List<Envio> getEnviosEntregados(){
        String query = "FROM Envio WHERE entregado = 1";
        return entityManager.createQuery(query).getResultList();
    }
    @Override
    public List<Envio> getEnviosEntregados(String id){
        String query = "FROM Envio WHERE id_usuario = :id AND entregado = 1";
        return entityManager.createQuery(query).setParameter("id",id).getResultList();
    }

    @Override
    public Envio getEnvio(String envId){
        String query="FROM Envio WHERE id = :id";
        List<Envio> l = entityManager.createQuery(query).setParameter("id", envId).getResultList();
        if(l.isEmpty()){
            return null;
        }
        return l.get(0);
    }

    @Override
    public void marcarEnvio(String id) {
        String query ="FROM Envio WHERE id = :id";
        List<Envio> l = entityManager.createQuery(query).setParameter("id", id).getResultList();
        if(l.isEmpty()){
            System.out.println("Error, no existe ningun envio con el id: "+id);
        }else{
            Envio e = l.get(0);
            e.setEntregado(1);
            entityManager.merge(e);
        }
    }

    @Override
    public void asignarEnvio(String idE, String idR) {
        String query ="FROM Envio WHERE id = :id";
        List<Envio> l = entityManager.createQuery(query).setParameter("id", idE).getResultList();
        if(l.isEmpty()){
            System.out.println("Error, no existe ningun envio con el id: "+ idE);
        }else{
            Envio e = l.get(0);
            e.setId_repartidor(Integer.parseInt(idR));
            entityManager.merge(e);
        }
    }

}
