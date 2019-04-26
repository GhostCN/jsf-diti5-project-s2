package com.isi.diti5.controller;
import com.isi.diti5.model.Client;
import com.isi.diti5.model.Vehicule;
import com.isi.diti5.service.ClientFacadeLocal;
import com.isi.diti5.service.VehiculeFacadeLocal;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import java.io.Serializable;
import java.util.List;

@ManagedBean(name = "vehiculeBean", eager = true)
@SessionScoped
public class VoitureController implements Serializable {
    public VoitureController(){
        vehicule = new Vehicule();

    }

    private Vehicule vehicule;
    private List< Vehicule> vehicules;

    public Vehicule getVehicule() {
        return vehicule;
    }

    public void setVehicule(Vehicule vehicule) {
        this.vehicule = vehicule;
    }

    public List<Vehicule> getVehicules() {
        vehicules = vehiculeFacade.findAll();
        return vehicules;
    }

    public void setVehicules(List<Vehicule> vehicules) {
        this.vehicules = vehicules;
    }

    @EJB
    private VehiculeFacadeLocal vehiculeFacade;




/*
    public String saveVehicule(){


        try {
            vehiculeFacade.create(vehicule);
            System.out.println("Success!!!");
            return "voiture?faces-redirect=true";
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return "voiture?faces-redirect=true";

    }*/
    public String deleteVehicule(Vehicule vehicule){
        try {
            vehiculeFacade.remove(vehicule);
            return "voiture?faces-redirect=true";
        }catch (Exception e){
            e.printStackTrace();
        }
        return "voiture";
    }

    public String editVehicule(Vehicule vehicule){
        try {
            this.vehicule = vehicule ;
            return "voitureedit?faces-redirect=true";
        }catch (Exception e){
            e.printStackTrace();
        }
        return "voiture?faces-redirect=true";
    }

    public String updateVehicule(){
        try {
            vehiculeFacade.edit(vehicule);
            vehicule = new Vehicule();
            return "voiture?faces-redirect=true";
        }catch (Exception e){
            e.printStackTrace();
        }
        return "voiture?faces-redirect=true";
    }


    public String addVehicule() {
        try {
            vehiculeFacade.create(vehicule);
            System.out.println("Success!!!");
            vehicule = new Vehicule();
            return "voiture?faces-redirect=true";
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return "voiture?faces-redirect=true";
    }
}
