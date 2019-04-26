package com.isi.diti5.controller;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;

@ManagedBean(name = "home", eager = true)
@SessionScoped
public class HomeController {

    public HomeController() {
    }

   /* public String index()
    {
        return "Hello World!";
    }*/
    public String getMessage() {
        return "Bonjour L'admin";
    }
}
