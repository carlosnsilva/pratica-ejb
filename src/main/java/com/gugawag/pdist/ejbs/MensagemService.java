package com.gugawag.pdist.ejbs;

import com.gugawag.pdist.model.Mensagem;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import java.util.List;

@Stateless(name = "mensagemService")
@Remote
public class MensagemService {

    @EJB
    private MensagemDAO mensagemDAO;

    public void inserir(Mensagem mensagem){
        mensagemDAO.inserirMensagem(mensagem);
    }

    public List<Mensagem> listarMensagens(){
        return mensagemDAO.listarMensagens();
    }

    public Mensagem listarPorId(Integer id){
        return mensagemDAO.listarMensagemPorId(id);
    }
}
