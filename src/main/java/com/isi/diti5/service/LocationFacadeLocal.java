/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.isi.diti5.service;


import com.isi.diti5.model.Location;

import javax.ejb.Local;
import java.util.List;

/**
 *
 * @author mac
 */
@Local
public interface LocationFacadeLocal {

    void create(Location location);

    void edit(Location location);

    void remove(Location location);
     Location find(Long id);
     List<Location> findAll();


}
