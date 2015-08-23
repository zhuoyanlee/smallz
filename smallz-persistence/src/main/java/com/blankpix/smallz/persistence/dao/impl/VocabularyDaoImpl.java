package com.blankpix.smallz.persistence.dao.impl;

import org.springframework.stereotype.Repository;

import com.blankpix.smallz.model.reference.Vocabulary;
import com.blankpix.smallz.persistence.dao.VocabularyDao;

@Repository("VocabularyDao")
public class VocabularyDaoImpl extends GenericDaoImpl<Vocabulary> implements VocabularyDao {
	
}
