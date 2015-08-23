package com.blankpix.smallz.persistence.dao;

import java.util.List;
import java.util.Map;

public interface GenericDao<T> {
	/**
     * Count rows based on given parameters
     * 
     * @param params Filter parameters
     * 
     * @return row count
     */
    long countAll(Map<String, Object> params);

    /**
     * Insert row
     * 
     * @param t Entity object
     * @return Created entity with generated id
     */
    T create(T t);

    /**
     * Delete row based on primary key
     * 
     * @param id ID, primary key
     */
    void delete(Object id);

    /**
     * Find a row based on given primary key
     * 
     * @param id ID, primary key
     * @return Entity object
     */
    T find(Object id);

    /**
     * Update row
     * 
     * @param t Entity object with updated values
     * @return Same object
     */
    T update(T t);

    /**
     * Load all entities in the table
     * @return List of entity objects
     */
    List<T> loadAll();
}
