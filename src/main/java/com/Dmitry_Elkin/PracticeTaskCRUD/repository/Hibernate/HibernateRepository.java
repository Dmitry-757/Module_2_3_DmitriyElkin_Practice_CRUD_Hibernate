package com.Dmitry_Elkin.PracticeTaskCRUD.repository.Hibernate;

import com.Dmitry_Elkin.PracticeTaskCRUD.utils.HibernateUtil;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.hibernate.query.criteria.HibernateCriteriaBuilder;

import java.util.List;

public abstract class HibernateRepository<T> {
    final Class<T> typeParameterClass;

    protected HibernateRepository(Class<T> typeParameterClass) {
        this.typeParameterClass = typeParameterClass;
    }

    public T insert(T item) {
        Session session = HibernateUtil.getSession();
        Transaction tx = session.beginTransaction();
        session.persist(item);
//        session.flush();
        tx.commit();
        session.close();
        return item;
    }

    public T update(T item) {
        Session session = HibernateUtil.getSession();
        Transaction tx = session.beginTransaction();
        session.merge(item);
        session.flush();
        tx.commit();
        session.close();
        return item;
    }

    public void delete(long id) {
        T item = getById(id);
        Session session = HibernateUtil.getSession();
        Transaction tx = session.beginTransaction();
//        session.beginTransaction();
        session.remove(item);
        session.getTransaction().commit();
//        session.flush();
        tx.commit();
        session.close();
    }

    public T getById(long id) {
        T item;
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        item = session.find(typeParameterClass, id);
//        item = session.get(typeParameterClass, id);
        session.getTransaction().commit();
        session.close();
        return item;
    }

    public List<T> getAll() {
        List<T> itemList;
        Session session = HibernateUtil.getSession();
        session.beginTransaction();

        String className = typeParameterClass.getName();
        itemList = session.createQuery("SELECT r FROM "+className+" r", typeParameterClass).getResultList();

//        HibernateCriteriaBuilder builder = session.getCriteriaBuilder();
//        CriteriaQuery<T> criteriaQuery = builder.createQuery(typeParameterClass);
////        Root<T> root = criteriaQuery.from(typeParameterClass);
//        Query<T> query = session.createQuery(criteriaQuery);
//        itemList = query.getResultList();


        session.getTransaction().commit();
        session.close();
        return itemList;
    }

}
