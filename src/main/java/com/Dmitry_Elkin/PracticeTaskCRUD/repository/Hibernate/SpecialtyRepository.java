package com.Dmitry_Elkin.PracticeTaskCRUD.repository.Hibernate;


import com.Dmitry_Elkin.PracticeTaskCRUD.model.Specialty;


public class SpecialtyRepository extends HibernateRepository<Specialty>{
    public SpecialtyRepository() {
        super(Specialty.class);
    }
}
