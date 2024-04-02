package com.example.kbrah.Controller;

import com.example.kbrah.Model.PlatForms;

import com.example.kbrah.Service.PlatFormService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping("/api/v1/kbrah/platforms")
@AllArgsConstructor
public class PlatFormsController {
    private final PlatFormService platFormService;
    private  static  final  Logger logger= LoggerFactory.getLogger(PlatFormsController.class);


    @PostMapping("/add")
    public ResponseEntity addPlatform(@RequestBody @Valid PlatForms platForms){
                logger.info("inside add PlatForm");
                platFormService.addPlatForms(platForms);
        return ResponseEntity.status(200).body("added");
    }


    @GetMapping("/get")
    public ResponseEntity getplatForm(){
                logger.info("inside get PlatForms");
                return ResponseEntity.status(200).body(platFormService.getPlatForms());
    }
    @PutMapping("/update/{id}")
    public ResponseEntity update(@PathVariable int id , @RequestBody @Valid PlatForms platForms) {
                logger.info("inside update PlatForms");
            platFormService.updatePlatForms(id, platForms);
            return ResponseEntity.status(200).body("updated");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deletePlatForms(@PathVariable int id) {
                logger.info("inside delete PlatForms");
        platFormService.deletePlatForms(id);
        return ResponseEntity.status(200).body("deleted");

    }

    @PutMapping("/openSetion/{platFormID}/{teacherId}/{courseId}")
public ResponseEntity openSession(@PathVariable int platFormID,@PathVariable int teacherId,@PathVariable int courseId){
                logger.info("inside open PlatForms");
   platFormService.openSetion(platFormID,teacherId,courseId);

       return ResponseEntity.status(200).body("session is opend");



}

    @PutMapping("/closeSetion/{platFormID}/{teacherId}")
    public ResponseEntity closeSession(@PathVariable int platFormID,@PathVariable int teacherId){
                logger.info("inside close PlatForms");
       platFormService.closeSestion(platFormID,teacherId);
       return ResponseEntity.status(200).body("session is closed");

    }

@GetMapping("/search_NotStarSestion")
public ResponseEntity searchOpenPlatForms(){
            logger.info("inside search open PlatForms");
        return ResponseEntity.status(200).body(platFormService.byOpenSestion());
}

}
