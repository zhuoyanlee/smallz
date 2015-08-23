package com.blankpix.smallz;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.blankpix.smallz.persistence.dao.GenericDao;

public abstract class GenericDaoTest<T> extends BaseTest {

    abstract protected T getEntity();

    abstract protected GenericDao<T> getDAO();

    abstract protected long getId();

    @Before
    public void testCreate() throws Exception {
        GenericDao<T> dao = getDAO();
        assertNotNull(dao.create(getEntity()));        
    }

    @Test
    public void testFind() throws Exception {
        GenericDao<T> dao = getDAO();
        T object = dao.find(getId());
        assertNotNull(object);
    }

    @Test
    public void testLoadAll() throws Exception {
        GenericDao<T> dao = getDAO();
        List<T> resultList = dao.loadAll();
        assertNotNull(resultList);
        assertEquals(1, resultList.size());
    }
}
