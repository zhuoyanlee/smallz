package com.blankpix.smallz.persistence.dao.impl;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.blankpix.smallz.persistence.dao.GenericDao;

public class GenericDaoImpl<T> implements GenericDao<T> {


    @PersistenceContext
    protected EntityManager em;

    private Class<T> type;

    public GenericDaoImpl(Class<T> type) {
        this.type = type;
    }

    @SuppressWarnings("unchecked")
    public GenericDaoImpl() {
        Type t = getClass().getGenericSuperclass();
        ParameterizedType pt = (ParameterizedType) t;
        type = (Class<T>) pt.getActualTypeArguments()[0];
    }

    public long countAll(final Map<String, Object> params) {
        final StringBuffer queryString = new StringBuffer("SELECT count(o) from ").append(type.getSimpleName()).append(" o ");
        final Query query = em.createQuery(queryString.toString());
        return (Long) query.getSingleResult();
    }

    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public T create(final T t) {
        em.persist(t);
        return t;
    }

    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public void delete(final Object id) {
        em.remove(em.getReference(type, id));
    }

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public T find(final Object id) {
        return (T) em.find(type, id);
    }

    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public T update(final T t) {
        return em.merge(t);
    }

    public List<T> loadAll() {
        final StringBuffer queryString = new StringBuffer("SELECT x from ").append(type.getSimpleName()).append(" x WHERE x.endDt IS NULL");
        Query query = em.createQuery(queryString.toString());
        return (List<T>) query.getResultList();
    }

}
