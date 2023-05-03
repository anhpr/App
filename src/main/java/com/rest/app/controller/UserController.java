package com.rest.app.controller;

import com.rest.app.entity.User;
import com.rest.app.service.UserService;
import com.rest.app.service.impl.OrderSeviceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.sql.SQLException;
import java.util.List;
@Controller
@CrossOrigin
@RestController
@RequestMapping("/user")
public class UserController {

    public static User userCurrent = new User();
    @Autowired
    private UserService userService ;

    @PostMapping("/findUser")
    public ResponseEntity<?> getUserByUserName(@RequestBody User user )  {
        User user1= null;
        try {
            user1 = userService.findByUserName(user);
            return ResponseEntity.ok(user1);
        } catch (SQLException e) {
            return new ResponseEntity<String>(e.getMessage(),new HttpHeaders(), HttpStatus.CONFLICT);
        }

    }
    @PostMapping("/register")
    public ResponseEntity<?> createUser(@RequestBody User user){
        try{
            User user1 = userService.saveUser(user);
            return ResponseEntity.ok(user1);
        }catch (SQLException e){
            return new ResponseEntity<String>(e.getMessage(),new HttpHeaders(), HttpStatus.CONFLICT);
        }

    }
//    @GetMapping("/login")
//    private ModelAndView getLogin() {
//        ModelAndView model = new ModelAndView();
//        User user = new User();
//        model.addObject("user", user);
//        model.setViewName("Login");
//        return model;
//
//    }

//    @PostMapping("/login")
//    private ModelAndView getUser(@RequestBody User user){
//
////        ModelAndView model = new ModelAndView();
////        System.out.println(user.getName());
////        if (user.getName() == "" || user.getPassword() == ""){
////            model.addObject("mes", "User name or pasword is empty" );
////            model.setViewName("Login");
////        }else {
////            try {
////                User user1 = userService.findByUserName(user.getName());
////                if(user1.getPassword().equals(user.getPassword())){
////                    model.addObject("name",user.getName());
////                    model.addObject("items", OrderSeviceImpl.itemsOrder);
////                    model.setViewName("Home");
////                    userCurrent = user1;
////                }else {
////                    model.addObject("mes", "User name or pasword is incorrect" );
////                    model.setViewName("Login");
////                }
////            }catch (Exception e){
////                model.addObject("mes", "User name does not exit" );
////                model.setViewName("Login");
////                e.printStackTrace();
////            }
////
////        }
////        return model;
//    }
}
