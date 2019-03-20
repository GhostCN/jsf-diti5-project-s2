package com.isi.diti5.controller;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean(name = "home", eager = true)
@RequestScoped
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
