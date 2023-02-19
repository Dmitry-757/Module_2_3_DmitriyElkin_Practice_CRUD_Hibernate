package com.Dmitry_Elkin.PracticeTaskCRUD.controller;

import com.Dmitry_Elkin.PracticeTaskCRUD.model.Specialty;
import com.Dmitry_Elkin.PracticeTaskCRUD.repository.Hibernate.SpecialtyRepository;

import java.util.List;

public class SpecialtyController {
    private SpecialtyRepository repository = new SpecialtyRepository();

    public Specialty getById(long id) {
        return repository.getById(id);
    }

    public List<Specialty> getAll() {
        return repository.getAll();
    }

    public Specialty insert(Specialty item) {
        return repository.insert(item);
    }

    public Specialty update(Specialty item) {
        return repository.update(item);
    }

    public void delete(Specialty item) {
        item.setDeleted();
        update(item);
    }

    public void unDelete(Specialty item) {
        item.setUnDeleted();
        update(item);
    }

}
