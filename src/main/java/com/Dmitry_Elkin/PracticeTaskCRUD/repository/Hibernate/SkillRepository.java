package com.Dmitry_Elkin.PracticeTaskCRUD.repository.Hibernate;


import com.Dmitry_Elkin.PracticeTaskCRUD.model.Skill;
import com.Dmitry_Elkin.PracticeTaskCRUD.utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;


public class SkillRepository {

    public void insert(Skill item) {
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        session.persist(item);
        session.close();
    }

    public Skill getById(long id) {
        Skill item = null;
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        item = session.find(Skill.class, id);
        session.close();
        return item;
    }

    public List<Skill> selectAll() {
        List<Skill> itemList;
        Session session = HibernateUtil.getSession();
        itemList = session.createQuery("SELECT r FROM Skill r", Skill.class).getResultList();
        session.close();
        return itemList;
    }


    public void update(Skill item) {
        Session session = HibernateUtil.getSession();
        Transaction tx = session.beginTransaction();
        session.merge(item);
        tx.commit();
        session.close();
    }

    public void delete(long id) {
        Skill item = getById(id);
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        session.remove(item);
        session.getTransaction().commit();
        session.close();
    }



}
