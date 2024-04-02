package com.example.kbrah.Service;

import com.example.kbrah.ApiExiption.ApiExcipstion;
import com.example.kbrah.Model.Catogary;
import com.example.kbrah.Repositry.CatogaryRepositry;
import com.example.kbrah.Repositry.CourseRepositry;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CatogaryService {
    private final CatogaryRepositry rebositryCatogary;
    private final CourseRepositry courseRepositry;
    public void addingCatogary(Catogary catogary){
        rebositryCatogary.save(catogary);
    }
    public List<Catogary> gettingCatogary(){
        return rebositryCatogary.findAll() ;
    }
    public boolean updateCatogary(int id , Catogary catogary){
        Catogary catogary1 = rebositryCatogary.getById(id);
        if(catogary1==null){
            return false;
        }
        catogary1.setName(catogary.getName());
        rebositryCatogary.save(catogary1);
        return true;
    }

    public void deleteCatogary(int id){
        Catogary catogary=rebositryCatogary.getById(id);
        if(catogary==null){
            throw new ApiExcipstion("id not found");
        }
        rebositryCatogary.deleteById(id);

    }

    public List<Catogary> byName(String catogary){
        List<Catogary> catogaris=rebositryCatogary.findCatogariesByName(catogary);
        return catogaris;   
    }


}
