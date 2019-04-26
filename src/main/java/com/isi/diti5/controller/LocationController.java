package com.isi.diti5.controller;
import com.isi.diti5.model.Client;
import com.isi.diti5.model.Location;
import com.isi.diti5.model.Vehicule;
import com.isi.diti5.service.ClientFacadeLocal;
import com.isi.diti5.service.LocationFacadeLocal;
import com.isi.diti5.service.VehiculeFacadeLocal;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import java.io.Serializable;
import java.util.List;

@ManagedBean(name = "locationBean", eager = true)
@SessionScoped
public class LocationController implements Serializable {
    public LocationController(){
        initLocation();
    }
    private void initLocation()
    {
        location = new Location();
        location.setIdclient(new Client());
        location.setIdvehicule(new Vehicule());
    }
    private Location location ;
    private String message ;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    private List<Location> locations ;

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public List<Location> getLocations() {
        locations = locationFacade.findAll();
        return locations;
    }

    public void setLocations(List<Location> locations) {
        this.locations = locations;
    }

    @EJB
    private LocationFacadeLocal locationFacade;
    @EJB
    private ClientFacadeLocal clientFacade;
    @EJB
    private VehiculeFacadeLocal vehiculeFacade ;



   
    public String deleteLocation(Location location){
        try {
            locationFacade.remove(location);
            this.location = new Location();
            return "location?faces-redirect=true";
        }catch (Exception e){
            e.printStackTrace();
        }
        return "location";
    }

    public String editLocation(Location location){
        try {
            this.location = location ;
            return "locationedit?faces-redirect=true";
        }catch (Exception e){
            e.printStackTrace();
        }
        return "locationedit?faces-redirect=true";
    }
    public String detailsLocation(Location location){
        try {
            this.location = location ;
            return "locationdetails?faces-redirect=true";
        }catch (Exception e){
            e.printStackTrace();
        }
        return "locationdetails?faces-redirect=true";
    }

    public String updateLocation(){
        try {
            locationFacade.edit(location);
            location = new Location();
            return "location?faces-redirect=true";
        }catch (Exception e){
            e.printStackTrace();
        }
        return "location?faces-redirect=true";
    }


    public String addLocation() {
        try {
            Client c = clientFacade.getClientByNumpiece(location.getIdclient().getNumpiece());
            Vehicule v = vehiculeFacade.getVoitureByNMatricule(location.getIdvehicule().getMatricule());
            if(c == null || v == null)
            {
                 FacesMessage msg = new FacesMessage("Veillez d'abord renseigner les infos de la voiture ou du client","Veillez d'abord renseigner les infos de la voiture ou du client");
                  FacesContext.getCurrentInstance().addMessage(null,msg);
                  return "ko";
            }

            location.setIdclient(c);
            location.setIdvehicule(v);
           // location.setDate();
            locationFacade.create(location);
            System.out.println("Success!!!");
            location = new Location() ;
            return "location?faces-redirect=true";
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return "location?error=1&faces-redirect=true";
    }

    public void getclient()
    {
        location.setIdclient(clientFacade.getClientByNumpiece(location.getIdclient().getNumpiece()) );
        if(location.getIdclient() == null)
        {
            location.setIdclient(new Client());
        }


    }
    public void getVehicule()
    {
        location.setIdvehicule(vehiculeFacade.getVoitureByNMatricule(location.getIdvehicule().getMatricule()));
        message = "";
        if(location.getIdvehicule() == null)
        {
            location.setMontantlocation(0);
            location.setIdvehicule(new Vehicule());
        }

    }
    public void calculePrice()
    {
        if(location.getIdvehicule().getPrixjour() > 0 && location.getNbjour() > 0)
        {
            message = "";
            location.setMontantlocation(location.getIdvehicule().getPrixjour() * location.getNbjour());
        }
        else {
          //  FacesMessage msg = new FacesMessage("","Veillez d'abord renseigner les infos de la voiture");
         //   FacesContext.getCurrentInstance().addMessage(null,msg);

            message = "Veillez d'abord renseigner les infos de la voiture";
            location.setNbjour(0);
            location.setMontantlocation(0);
        }

    }
}
