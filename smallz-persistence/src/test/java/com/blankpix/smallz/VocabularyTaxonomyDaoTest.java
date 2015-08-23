package com.blankpix.smallz;

import static org.junit.Assert.assertNotNull;

import java.sql.Timestamp;

import javax.annotation.Resource;

import org.joda.time.DateTime;
import org.junit.Test;
import org.springframework.transaction.annotation.Transactional;

import com.blankpix.smallz.model.reference.Taxonomy;
import com.blankpix.smallz.model.reference.Vocabulary;
import com.blankpix.smallz.persistence.dao.GenericDao;

@Transactional
public class VocabularyTaxonomyDaoTest extends GenericDaoTest<Vocabulary> {

	@Resource(name = "VocabularyDao")
    private GenericDao<Vocabulary> dao;
	
	private Vocabulary vocabulary;

	@Resource(name = "TaxonomyDao")
    private GenericDao<Taxonomy> taxonomyDao;
	
	private Taxonomy taxonomy;
	
	@Override
	protected Vocabulary getEntity() {
		vocabulary = new Vocabulary();
		vocabulary.setName("vocabulary name");
		vocabulary.setDescription("description");
		vocabulary.setStartDt(new Timestamp(DateTime.now().getMillis()));
		return vocabulary;
	}

	@Override
	protected GenericDao<Vocabulary> getDAO() {
		
		return dao;
	}

	@Override
	protected long getId() {
		
		return vocabulary.getId();
	}
	
	@Test
	public void testCreateTaxonomy() {
		taxonomy = new Taxonomy();
		taxonomy.setName("taxonomy name");
		taxonomy.setDescription("description");
		taxonomy.setStartDt(new Timestamp(DateTime.now().getMillis()));
		
		assertNotNull(vocabulary.getId());
		taxonomy.setVocabulary(vocabulary);
		
		taxonomy = taxonomyDao.create(taxonomy);
		assertNotNull(taxonomy.getId());
		
	}

}
