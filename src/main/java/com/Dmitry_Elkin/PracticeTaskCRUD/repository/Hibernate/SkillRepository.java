package com.Dmitry_Elkin.PracticeTaskCRUD.repository.Hibernate;


import com.Dmitry_Elkin.PracticeTaskCRUD.model.Skill;


public class SkillRepository extends HibernateRepository<Skill>{
    public SkillRepository() {
        super(Skill.class);
    }

}
