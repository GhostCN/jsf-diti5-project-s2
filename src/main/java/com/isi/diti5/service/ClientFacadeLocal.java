/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.isi.diti5.service;



import com.isi.diti5.model.Client;

import javax.ejb.Local;
import java.util.List;

/**
 *
 * @author mac
 */
@Local
public interface ClientFacadeLocal {

    void create(Client client);

    void edit(Client client);

    void remove(Client client);
     Client find(Long id);
     List<Client> findAll();


}
