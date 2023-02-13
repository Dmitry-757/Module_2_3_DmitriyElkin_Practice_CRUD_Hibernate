package com.Dmitry_Elkin.PracticeTaskCRUD.repository.Hibernate;

import com.Dmitry_Elkin.PracticeTaskCRUD.model.Developer;

public class DeveloperRepository extends HibernateRepository<Developer>{
    public DeveloperRepository() {
        super(Developer.class);
    }
}
