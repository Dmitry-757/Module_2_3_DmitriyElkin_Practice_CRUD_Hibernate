package com.Dmitry_Elkin.PracticeTaskCRUD.repository.Hibernate;

import com.Dmitry_Elkin.PracticeTaskCRUD.model.Developer;
import com.Dmitry_Elkin.PracticeTaskCRUD.utils.HibernateUtil;
import org.hibernate.Session;

import java.util.ArrayList;
import java.util.List;

public class DeveloperRepository extends HibernateRepository<Developer>{
    public DeveloperRepository() {
        super(Developer.class);
    }

    @Override
    public Developer getById(long id) {
        Developer item;

        try(Session session = HibernateUtil.getSession()) {
            String hql = "select d from Developer d left join fetch d.skills where d.id = :pId";
            item = session.createQuery(hql, Developer.class)
                    .setParameter("pId", id)
                    .getSingleResult();
        }

        return item;
    }

    @Override
    public List<Developer> getAll() {
        List<Developer> itemList;

        try(Session session = HibernateUtil.getSession()) {
            String hql = "select d from Developer d left join fetch d.skills ";
            itemList = session.createQuery(hql, Developer.class).getResultList();
        }

        return itemList;
    }


}
