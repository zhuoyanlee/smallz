package com.blankpix.smallz.persistence.dao.impl;

import org.springframework.stereotype.Repository;

import com.blankpix.smallz.model.reference.Taxonomy;
import com.blankpix.smallz.persistence.dao.TaxonomyDao;

@Repository("TaxonomyDao")
public class TaxonomyDaoImpl extends GenericDaoImpl<Taxonomy> implements TaxonomyDao {
	
}
