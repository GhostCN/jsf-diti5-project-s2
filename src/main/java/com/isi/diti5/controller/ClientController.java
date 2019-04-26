package com.isi.diti5.controller;
import com.isi.diti5.model.Client;
import com.isi.diti5.service.AbstractFacade;
import com.isi.diti5.service.ClientFacade;
import com.isi.diti5.service.ClientFacadeLocal;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@ManagedBean(name = "clientBean", eager = true)
@SessionScoped
public class ClientController implements Serializable {
    public ClientController(){
        client = new Client();

    }

    private Client client;
    private List< Client> clients;


    public List<Client> getClients() {
        clients = clientFacade.findAll();
        return clients;
    }

    public void setClients(List<Client> clients) {
        this.clients = clients;
    }

    public ClientFacadeLocal getClientFacade() {
        return clientFacade;
    }

    public void setClientFacade(ClientFacadeLocal clientFacade) {
        this.clientFacade = clientFacade;
    }

    @EJB
    private ClientFacadeLocal clientFacade;



    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

   /* public String saveClient(){


        try {
            clientFacade.create(client);
            System.out.println("Success!!!");
            return "client?faces-redirect=true";
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return "client";

    }*/
    public String deleteClient(Client client){
        try {
            clientFacade.remove(client);
            return "client?faces-redirect=true";
        }catch (Exception e){
            e.printStackTrace();
        }
        return "client";
    }

    public String editClient(Client client){
        try {
            this.client = client ;
            return "clientedit?faces-redirect=true";
        }catch (Exception e){
            e.printStackTrace();
        }
        return "clientedit?faces-redirect=true";
    }

    public String updateClient(){
        try {
            clientFacade.edit(client);
            client = new Client();
            return "client?faces-redirect=true";
        }catch (Exception e){
            e.printStackTrace();
        }
        return "client?faces-redirect=true";
    }


    public String addClient() {
        try {
            clientFacade.create(client);
            System.out.println("Success!!!");
            client = new Client();
            return "client?faces-redirect=true";
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return "client?faces-redirect=true";
    }
}
