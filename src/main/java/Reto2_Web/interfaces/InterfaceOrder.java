/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Reto2_Web.interfaces;

import Reto2_Web.modelo.Order;
import java.util.List;
import java.util.Optional;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;



/**
 *
 * @author Usuario
 */
public interface InterfaceOrder extends MongoRepository< Order, Integer> {
    /**
     * Retorna las ordenes de pedido de la zona recibida como parametro
     * @param zone
     * @return 
     */
    @Query("{'salesMan.zone': ?0}")
    List<Order> findByZone(final String zone);
    /**
     * Retorna las ordenes por el estado
     * @param status
     * @return 
     */    
    @Query("{status: ?0]")
        List<Order> findByStatus(final String status);
        
    //Para seleccionar la orden con el id maximo
    Optional<Order> findTopByOrderByIdDesc();
      
}
