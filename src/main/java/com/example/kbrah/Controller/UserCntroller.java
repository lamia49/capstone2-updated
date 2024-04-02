package com.example.kbrah.Controller;

import com.example.kbrah.Model.User;
import com.example.kbrah.Service.UserService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/kbrah/users")
@AllArgsConstructor
public class UserCntroller {
    private final UserService userService;

    private  static  final  Logger logger= LoggerFactory.getLogger(UserCntroller.class);



    @PostMapping("add")
    public ResponseEntity add(@RequestBody @Valid User user){
        logger.info("inside add user");
        userService.addUser(user);
        return ResponseEntity.status(200).body("added");}

    @GetMapping("/get")
    public ResponseEntity get(){
        logger.info("inside get user");
        return ResponseEntity.status(200).body(userService.getUser());
    }

    @PutMapping("/update/{id}")
    public ResponseEntity update(@PathVariable int id , @RequestBody @Valid User user){
        logger.info(" inside update user");
        userService.updateUser(id,user);
        return ResponseEntity.status(200).body("updated");

    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity delete(@PathVariable int id){
        logger.info(" inside delete  user");
     userService.deleteUser(id);
     return ResponseEntity.status(200).body("deleted");
    }

    @PutMapping("/subscireb/{userId}/{courseId}")
    public ResponseEntity subscireb(@PathVariable int userId,@PathVariable int courseId){
        logger.info("inside subscireb user");
  boolean buy=userService.subscribe(courseId,userId);
  if (buy){
      return ResponseEntity.status(200).body("successfully subscribed");
  }
        return ResponseEntity.status(200).body("bad request");
    }


    @GetMapping("/check_subscribe/{userId}")
    public ResponseEntity checkUserSebscribe(@PathVariable int userId){
                logger.info("inside check User Sebscribe user");
        boolean check=userService.checkSubscribe(userId);
        if(check){
            return ResponseEntity.status(200).body("user does not have course");
        }
        return ResponseEntity.status(200).body("user have course");
    }


    @PutMapping("/specialDiscount/{userId}/{courseID}")
    public ResponseEntity speicilDiscount(@PathVariable int userId,@PathVariable int courseID){
                logger.info("inside speicil Discount user");
        boolean buy=userService.discoundSpecial(courseID,userId);
        if (buy){
            return ResponseEntity.status(200).body("successfully subscribed");
        }
        return ResponseEntity.status(200).body("you should have at least 5 Certificate");
    }



    @PutMapping("/discount/{userId}/{courseID}/{amount}")
    public ResponseEntity discount(@PathVariable int userId,@PathVariable int courseID,@PathVariable double amount){
                logger.info("inside Discount user");
        boolean buy=userService.discount(userId,courseID,amount);
        if (buy){
            return ResponseEntity.status(200).body("successfully discount");
        }
        return ResponseEntity.status(200).body("you are not allowed");
    }


}
