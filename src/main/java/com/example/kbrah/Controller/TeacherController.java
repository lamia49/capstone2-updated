package com.example.kbrah.Controller;

import com.example.kbrah.Model.Catogary;
import com.example.kbrah.Model.Teachers;
import com.example.kbrah.Service.TeacherService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/kbrah/teachers")
@AllArgsConstructor
public class TeacherController {

    private final TeacherService teacherService;
//    Logger logger= LoggerFactory.getLogger(TeacherController.class);


    @PostMapping("/add")
    public ResponseEntity addTeachers(@RequestBody @Valid Teachers teachers){

        //        logger.info("inside add Teachers");
        teacherService.addTeacher(teachers);
        return ResponseEntity.status(200).body("added");
    }


    @GetMapping("/get")
    public ResponseEntity getTeachers(){
        //        logger.info("inside get Teachers");
        return ResponseEntity.status(200).body(teacherService.getTeacher());
    }
    @PutMapping("/update/{id}")
    public ResponseEntity updateTeachers(@PathVariable int id , @RequestBody @Valid Teachers teachers) {
        //        logger.info("inside update Teachers");
    teacherService.updateTeacher(id, teachers);
    return ResponseEntity.status(200).body("updated");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteTeachers(@PathVariable int id) {
        //        logger.info("inside add Teachers");
        teacherService.deleteTeacher(id);
        return ResponseEntity.status(200).body("deleted");
    }


    @PutMapping("/chang-statue/{teacherId}")
    public ResponseEntity changeStatue(@PathVariable int teacherId){
        //        logger.info("inside change Statue Teachers");
      boolean check =teacherService.changeStatus(teacherId);
      if(check) {
          return ResponseEntity.status(200).body("change successfully");
      }
        return ResponseEntity.status(200).body("your not allowed");
    }




    @GetMapping("/aearch_by_statue_teachers/{statue}")
    public ResponseEntity SearchByStatueTeachers(@PathVariable String statue){
        //        logger.info("inside search by Statue Teachers");
        return ResponseEntity.status(200).body(teacherService.freeTeachers(statue));
    }

}
