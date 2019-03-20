/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.isi.diti5.service;


import com.isi.diti5.model.Vehicule;

import javax.ejb.Local;
import java.util.List;

/**
 *
 * @author mac
 */
@Local
public interface VehiculeFacadeLocal {

    void create(Vehicule vehicule);

    void edit(Vehicule vehicule);

    void remove(Vehicule vehicule);

     Vehicule find(Long id);
     List<Vehicule> findAll();


    
}
