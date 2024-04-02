package com.example.kbrah.Controller;

import com.example.kbrah.Model.Catogary;
import com.example.kbrah.Service.CatogaryService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
@AllArgsConstructor
@RestController
@RequestMapping("api/v1/kbrah/catogary")

public class CatogaryController {
    private final CatogaryService catogaryService;
    private  static  final  Logger logger= LoggerFactory.getLogger(CatogaryController.class);

    @PostMapping("/add")
    public ResponseEntity add(@RequestBody @Valid Catogary catogary){
        logger.info("add Catogary");
        catogaryService.addingCatogary(catogary);
        return ResponseEntity.status(200).body("added");
    }

    @GetMapping("/get")
    public ResponseEntity get(){
                logger.info("get Catogary");
        return ResponseEntity.status(200).body(catogaryService.gettingCatogary());
    }

    @PutMapping("/update/{id}")
    public ResponseEntity update(@PathVariable int id , @RequestBody @Valid Catogary catogary) {
                logger.info("update Catogary");
       catogaryService.updateCatogary(id, catogary);
       return ResponseEntity.status(200).body("updated");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity delete(@PathVariable int id) {
                logger.info("delete Catogary");
        catogaryService.deleteCatogary(id);
   return ResponseEntity.status(200).body("deleted");
    }




}
