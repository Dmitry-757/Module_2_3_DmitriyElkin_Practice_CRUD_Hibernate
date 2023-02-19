package com.Dmitry_Elkin.PracticeTaskCRUD.controller;

import com.Dmitry_Elkin.PracticeTaskCRUD.model.Skill;
import com.Dmitry_Elkin.PracticeTaskCRUD.repository.Hibernate.SkillRepository;

import java.util.List;

public class SkillController {
    private SkillRepository repository = new SkillRepository();
    public Skill getById(long id){
        return repository.getById(id);
    }
    public List<Skill> getAll(){
        return repository.getAll();
    }

    public Skill insert(Skill item){
        return repository.insert(item);
    }

    public Skill update(Skill item){
        return repository.update(item);
    }

    public void delete(Skill item){
        item.setDeleted();
        update(item);
    }

    public void unDelete(Skill item){
        item.setUnDeleted();
        update(item);
    }

}
