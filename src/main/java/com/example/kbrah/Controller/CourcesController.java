package com.example.kbrah.Controller;

import com.example.kbrah.Model.Courses;
import com.example.kbrah.Model.PlatForms;
import com.example.kbrah.Model.User;
import com.example.kbrah.Service.CourseService;
import com.example.kbrah.Service.PlatFormService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/kbrah/course")
@AllArgsConstructor
public class CourcesController {
    private final CourseService courseService;
//    Logger logger= LoggerFactory.getLogger(CourcesController.class);


    @PostMapping("/add")
    public ResponseEntity addCourse(@RequestBody @Valid Courses courses){
        //        logger.info("inside add Courses");
        courseService.addCourse(courses);
        return ResponseEntity.status(200).body("added");
    }


    @GetMapping("/get")
    public ResponseEntity getCourses(){
        //        logger.info("inside get Courses");
        return ResponseEntity.status(200).body(courseService.getCourses());
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateCourse(@PathVariable int id , @RequestBody @Valid Courses courses) {
        //        logger.info("inside update Courses");
           courseService.updateCourses(id, courses);
            return ResponseEntity.status(200).body("updated");
        }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteCourse(@PathVariable int id) {
        //        logger.info("inside delete Courses");
        courseService.deleteCourses(id);
        return ResponseEntity.status(200).body("deleted");

    }


    @GetMapping("/top_course")
    public ResponseEntity topCourse(){
        //        logger.info("inside display top Courses");
        return ResponseEntity.status(200).body(courseService.TopCourse());
    }



    @PutMapping("add_seats/{courseId}/{userId}/{amount}")
    public ResponseEntity NumberOfSeats(@PathVariable int courseId,@PathVariable int userId,@PathVariable int amount) {
        //        logger.info("inside NumberOfSeats in Courses");
           boolean addSeats=courseService.addSeats(userId,courseId,amount);
           if(addSeats) {
               return ResponseEntity.status(200).body("added");
           }
        return ResponseEntity.status(200).body("you not allowed");
       }



       @GetMapping("/open_courses")
       public ResponseEntity searchOpenCourse(){
           //        logger.info("inside search Open Course");
        return ResponseEntity.status(200).body(courseService.openCourses());

       }
    }






