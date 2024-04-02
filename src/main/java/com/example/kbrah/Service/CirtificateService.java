package com.example.kbrah.Service;

import com.example.kbrah.ApiExiption.ApiExcipstion;
import com.example.kbrah.Model.Cirtificate;
import com.example.kbrah.Model.Courses;
import com.example.kbrah.Model.Teachers;
import com.example.kbrah.Model.User;
import com.example.kbrah.Repositry.CertificateRepositry;
import com.example.kbrah.Repositry.CourseRepositry;
import com.example.kbrah.Repositry.TeacherRepositry;
import com.example.kbrah.Repositry.UserRepositry;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CirtificateService {
    private final CertificateRepositry certificateRepositry;
    public final CourseRepositry courseRepositry;
    public  final TeacherRepositry teacherRepositry;
    public final UserRepositry userRepositry;

    public void addCirtificate(Cirtificate cirtificate){
        Courses courses=courseRepositry.findCoursesById(cirtificate.getCourseId());
        Teachers teachers=teacherRepositry.findTeachersById(cirtificate.getTeacherId());
        User user=userRepositry.findUserById(cirtificate.getUserId());
        if(teachers==null) {
            throw new ApiExcipstion("teacher id not found");
        }else if(user==null) {
            throw new ApiExcipstion("user id not found");
        }else if(courses==null){
            throw new ApiExcipstion("teacher id not found");
                }
        certificateRepositry.save(cirtificate);
        }

    public List<Cirtificate>getCirtificate(){
        List<Cirtificate>cirtificates=certificateRepositry.findAll();
        return cirtificates;
    }

    public void updatCirtificate(int id,Cirtificate cirtificate){
        Cirtificate cirtificate1=certificateRepositry.findCirtificateById(id);
        if(cirtificate1==null){
            throw  new ApiExcipstion("id not found");
        }
        cirtificate1.setName(cirtificate.getName());
        certificateRepositry.save(cirtificate1);

    }
    public void deleteCirtificate(int id) {
        Cirtificate cirtificate=certificateRepositry.getById(id);
        if(cirtificate==null) {
            throw  new ApiExcipstion("id not found");
        }
        certificateRepositry.delete(cirtificate);
    }


    public List<Cirtificate> userCertificat(int userID){
        List<Cirtificate>cirtificates=certificateRepositry.findCirtificateByUserId(userID);
        return cirtificates;
    }


    public Integer byCourses(int courseID){
        List<Cirtificate>cirtificates=certificateRepositry.findCirtificateByCourseId(courseID);

        return cirtificates.size();
    }




}
