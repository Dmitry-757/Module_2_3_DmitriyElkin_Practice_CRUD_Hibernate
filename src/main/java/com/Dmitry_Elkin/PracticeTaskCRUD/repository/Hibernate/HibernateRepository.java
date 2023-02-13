package com.Dmitry_Elkin.PracticeTaskCRUD.repository.Hibernate;

import com.Dmitry_Elkin.PracticeTaskCRUD.utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public abstract class HibernateRepository<T> {
    final Class<T> typeParameterClass;

    protected HibernateRepository(Class<T> typeParameterClass) {
        this.typeParameterClass = typeParameterClass;
    }

    public void insert(T item) {
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        session.persist(item);
        session.close();
    }

    public T getById(long id) {
        T item = null;
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        item = session.find(typeParameterClass, id);
        session.close();
        return item;
    }

    public List<T> selectAll() {
        List<T> itemList;
        Session session = HibernateUtil.getSession();
        String className = typeParameterClass.getName();
        itemList = session.createQuery("SELECT r FROM "+className+" r", typeParameterClass).getResultList();
        session.close();
        return itemList;
    }


    public void update(T item) {
        Session session = HibernateUtil.getSession();
        Transaction tx = session.beginTransaction();
        session.merge(item);
        tx.commit();
        session.close();
    }

    public void delete(long id) {
        T item = getById(id);
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        session.remove(item);
        session.getTransaction().commit();
        session.close();
    }

}
