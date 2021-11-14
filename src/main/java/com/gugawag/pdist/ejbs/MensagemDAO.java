package com.gugawag.pdist.ejbs;


import com.gugawag.pdist.model.Mensagem;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class MensagemDAO {

    @PersistenceContext(unitName="default")
    private EntityManager em;

    public void inserirMensagem(Mensagem mensagem){
        em.persist(mensagem);
    }

    public List<Mensagem> listarMensagens(){
        return em.createQuery("FROM Mensagem").getResultList();
    }

    public Mensagem listarMensagemPorId(Integer id){
        String idMensagem = Integer.toString(id);
        return (Mensagem) em.createQuery("FROM MENSAGEM WHERE ID = "+"idMensagem");
    }
}
