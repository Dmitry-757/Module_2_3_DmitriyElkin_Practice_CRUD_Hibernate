package com.Dmitry_Elkin.PracticeTaskCRUD.controller;

import com.Dmitry_Elkin.PracticeTaskCRUD.model.Developer;
import com.Dmitry_Elkin.PracticeTaskCRUD.repository.Hibernate.DeveloperRepository;

import java.util.List;

public class DeveloperController {
    private final DeveloperRepository repository = new DeveloperRepository();
    public Developer getById(long id){
        return repository.getById(id);
    }

    public List<Developer> getAll(){
        return repository.getAll();
    }

    public Developer insert(Developer item){
        return repository.insert(item);
    }

    public Developer update(Developer item){
        return repository.update(item);
    }

    public void delete(Developer item){
        item.setDeleted();
        update(item);
    }

    public void unDelete(Developer item){
        item.setUnDeleted();
        update(item);
    }

}
