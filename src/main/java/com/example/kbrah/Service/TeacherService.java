package com.example.kbrah.Service;

import com.example.kbrah.ApiExiption.ApiExcipstion;
import com.example.kbrah.Model.Teachers;
import com.example.kbrah.Repositry.TeacherRepositry;
import com.example.kbrah.Repositry.UserRepositry;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class TeacherService {
    private final TeacherRepositry teacherRepositry;
    private final UserRepositry userRepositry;

    public void addTeacher(Teachers teachers){
        teacherRepositry.save(teachers);
    }

    public List<Teachers> getTeacher(){
        List<Teachers>teachers =teacherRepositry.findAll();
        return teachers;
    }
    public void updateTeacher(int id,Teachers teacher) {
        Teachers teacher1=teacherRepositry.getById(id);
        if(teacher1==null){
            throw new ApiExcipstion("techear id not found");
        }
        teacher1.setName(teacher.getName());
        teacher1.setExperince(teacher.getExperince());
        teacherRepositry.save(teacher1);

    }

    public void deleteTeacher(int id) {
        Teachers teacher=teacherRepositry.getById(id);
        if(teacher==null) {
            throw new ApiExcipstion("techear id not found");
        }
        teacherRepositry.delete(teacher);

    }

    public boolean changeStatus( int teacherID) {
        Teachers teacher = teacherRepositry.findTeachersById(teacherID);
        if (teacher == null) {
            throw new ApiExcipstion("id teacher not found");
        }
            if(teacher.getStatue().equalsIgnoreCase("free")) {
                teacher.setStatue("busy");
                teacherRepositry.save(teacher);
            }else if(teacher.getStatue().equalsIgnoreCase("busy"))
            teacher.setStatue("free");
        teacherRepositry.save(teacher);
            return true;

    }

    public List<Teachers> freeTeachers(String statue){
        List<Teachers>teachersList=teacherRepositry.findTeachersByStatue(statue);
        return teachersList;
    }
    }


