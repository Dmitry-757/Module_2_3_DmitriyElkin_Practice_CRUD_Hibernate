package com.Dmitry_Elkin.PracticeTaskCRUD.repository.Hibernate;


import com.Dmitry_Elkin.PracticeTaskCRUD.model.Specialty;
import com.Dmitry_Elkin.PracticeTaskCRUD.utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;


public class SpecialtyRepository {

    public void insert(Specialty item) {
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        session.persist(item);
        session.close();
    }

    public Specialty getById(long id) {
        Specialty item = null;
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        item = session.find(Specialty.class, id);
        session.close();
        return item;
    }

    public List<Specialty> selectAll() {
        List<Specialty> itemList;
        Session session = HibernateUtil.getSession();
//        CriteriaQuery<VinylRecord> cq = session.getCriteriaBuilder().createQuery(Specialty.class);
//        cq.from(Specialty.class);
//        List<Specialty> itemList = session.createQuery(cq).getResultList();
        itemList = session.createQuery("SELECT r FROM Specialty r", Specialty.class).getResultList();
        session.close();
        return itemList;
    }

//    public List<VinylRecord> searchByParam(String pName, String pAuthor, int pYear) {
//        List<VinylRecord> itemList = new LinkedList<>();
//
//        Session session = HibernateUtil.getSession();
//        if (pName!=""&&pAuthor!=""&&pYear>0){
//            String hql = "select r from VinylRecord r where r.name = :pName and r.author=:pAuthor and r.year = :pYear";
//            itemList = session.createQuery(hql, VinylRecord.class)
//                    .setParameter("pName",pName)
//                    .setParameter("pAuthor", pAuthor)
//                    .setParameter("pYear", pYear)
//                    .getResultList();
//
//        } else if (pName!=""&&pAuthor!="") {
//            String hql = "select r from VinylRecord r where r.name = :pName and r.author=:pAuthor";
//            itemList = session.createQuery(hql, VinylRecord.class)
//                    .setParameter("pName",pName)
//                    .setParameter("pAuthor", pAuthor)
//                    .getResultList();
//        } else if (pName!="") {
//            String hql = "select r from VinylRecord r where r.name = :pName ";
//            itemList = session.createQuery(hql, VinylRecord.class)
//                    .setParameter("pName",pName)
//                    .getResultList();
//
//        } else if (pAuthor!="") {
//            String hql = "select r from VinylRecord r where r.author=:pAuthor";
//            itemList = session.createQuery(hql, VinylRecord.class)
//                    .setParameter("pAuthor", pAuthor)
//                    .getResultList();
//        } else if (pYear>0) {
//            String hql = "select r from VinylRecord r where r.year = :pYear";
//            itemList = session.createQuery(hql, VinylRecord.class)
//                    .setParameter("pYear", pYear)
//                    .getResultList();
//        }
//        return itemList;
//    }


    public void update(Specialty item) {
        Session session = HibernateUtil.getSession();
        Transaction tx = session.beginTransaction();
        session.merge(item);
        tx.commit();
        session.close();
    }

    public void delete(long id) {
        Specialty record = getById(id);
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        session.remove(record);
        session.getTransaction().commit();
        session.close();
    }



}
