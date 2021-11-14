package com.gugawag.pdist.servlets;


import com.gugawag.pdist.ejbs.MensagemService;
import com.gugawag.pdist.model.Mensagem;
import com.gugawag.pdist.model.Usuario;

import javax.ejb.EJB;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = {"/mensagem.do"})
public class MensagemServlet extends javax.servlet.http.HttpServlet {

    @EJB(lookup = "java:module/mensagemService")
    private MensagemService mensagemService;

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response)
            throws javax.servlet.ServletException, IOException {
        String operacao = request.getParameter("oper");
        PrintWriter resposta = response.getWriter();
        switch (operacao) {
            case "1": {
                long id = Integer.parseInt(request.getParameter("id"));
                String text = request.getParameter("nome");
                int myInt = (int) id;
                Mensagem m = new Mensagem(myInt,text);
                mensagemService.inserir(m);
            }
            case "2": {
                for(Mensagem m: mensagemService.listarMensagens()){
                    resposta.println(m.getTexto());
                }
                break;
            }
            case "3":{
                long id = Integer.parseInt(request.getParameter("id"));
                int myInt = (int) id;
                Mensagem m = mensagemService.listarPorId(myInt);

                resposta.println(m.getTexto());
            }

        }
    }

}
