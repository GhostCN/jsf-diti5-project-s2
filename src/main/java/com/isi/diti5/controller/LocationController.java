package com.isi.diti5.controller;
import com.isi.diti5.model.Client;
import com.isi.diti5.model.Location;
import com.isi.diti5.model.Vehicule;
import com.isi.diti5.service.ClientFacadeLocal;
import com.isi.diti5.service.LocationFacadeLocal;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
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



   
    public String deleteLocation(Location location){
        try {
            locationFacade.remove(location);
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
            locationFacade.create(location);
            System.out.println("Success!!!");
            location = new Location();
            return "location?faces-redirect=true";
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return "location?faces-redirect=true";
    }

    public void getclient(String numpiece)
    {
        location.setIdclient(clientFacade.getClientByNumpiece(numpiece));

    }
}
