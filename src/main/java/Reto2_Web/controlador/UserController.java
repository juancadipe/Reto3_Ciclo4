/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Reto2_Web.controlador;
import Reto2_Web.servicio.UserService;
import Reto2_Web.modelo.User;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Juan Carlos Diaz Peña
 */
@RestController
@RequestMapping("/api/user/")
@CrossOrigin("*")
/**
 * Clase user controler
 */
public class UserController {
    
     @Autowired
     /**
      * metodo user services
      */
    private UserService userService;
     
     @GetMapping("/all")
     /**
      * Metodo user services 
      */
    public List<User> getAll() {
        return userService.getAll();
    }
    /**
     * Metodo get mapin para consultar con referencia al id
     * @param id corresponde al id del producto
     * @return 
     */
    @GetMapping("/{id}")
    /**
     * metodo para consultar por el id
     */
    public Optional<User> getUser(@PathVariable("id") Integer id) {
        return userService.getUser(id);
    }

    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
      
      /**
       * Metodo user create
       */
    public User create(@RequestBody User user) {
        return userService.create(user);
    }
    
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    /**
     * Metoso udate maping
     */
    public User update(@RequestBody User user) {
        return userService.update(user);
    }
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    /**
     * Metodo para el id
     */
    public boolean delete(@PathVariable("id") int id) {
        return userService.delete(id);
    }
    @GetMapping("/{email}/{password}")
    /**
     * Validacion email oassword
     */
    public User authenticateUser(@PathVariable("email") String email, @PathVariable("password") String password) {
        return userService.authenticateUser(email, password);
    }
      @GetMapping("/emailexist/{email}")
      /**
       * metodo validacion email
       */
    public boolean emailExists(@PathVariable("email") String email) {
        return userService.emailExists(email);
    }
}
