package com.example.kbrah.Controller;

import com.example.kbrah.Model.Cirtificate;
import com.example.kbrah.Model.PlatForms;
import com.example.kbrah.Service.CirtificateService;
import com.example.kbrah.Service.PlatFormService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/kbrah/cirtificat")
@AllArgsConstructor
public class CirtificatController {
    private final CirtificateService cirtificateService;
    private  static  final  Logger logger= LoggerFactory.getLogger(CirtificatController.class);

    @PostMapping("/add")
    public ResponseEntity add(@RequestBody @Valid Cirtificate cirtificate){
        logger.info("inside add Cirtificate");
            cirtificateService.addCirtificate(cirtificate);
            return ResponseEntity.status(200).body("added");

    }


    @GetMapping("/get")
    public ResponseEntity get(){
                logger.info("get Cirtificate");
        return ResponseEntity.status(200).body(cirtificateService.getCirtificate());
    }
    @PutMapping("/update/{id}")
    public ResponseEntity update(@PathVariable int id , @RequestBody @Valid Cirtificate cirtificate) {
                logger.info("inside update Cirtificate");
      cirtificateService.updatCirtificate(id,cirtificate);
      return ResponseEntity.status(200).body("updated");

    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity delete(@PathVariable int id) {
                logger.info("inside delete Cirtificate");
                cirtificateService.deleteCirtificate(id);
       return ResponseEntity.status(200).body("deleted");

    }


    @GetMapping("/user_Certificat/{userId}")
    public List userCertificat(@PathVariable int userId){
                logger.info("inside user Cirtificate display");
        return cirtificateService.userCertificat(userId);
    }


    @GetMapping("/studentPass/{courseId}")
    public ResponseEntity<Integer> studentPass(@PathVariable int courseId){
                logger.info("inside studentPass Cirtificate");
        Integer numberOfPassStudent=cirtificateService.byCourses(courseId);
        return ResponseEntity.status(200).body(numberOfPassStudent);
    }



}
