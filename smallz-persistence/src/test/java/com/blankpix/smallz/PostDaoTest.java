package com.blankpix.smallz;

import java.sql.Timestamp;

import javax.annotation.Resource;

import org.joda.time.DateTime;
import org.springframework.transaction.annotation.Transactional;

import com.blankpix.smallz.model.Post;
import com.blankpix.smallz.persistence.dao.GenericDao;

@Transactional
public class PostDaoTest extends GenericDaoTest<Post> {

	@Resource(name = "PostDao")
    private GenericDao<Post> dao;
	
	private Post post;
	
	@Override
	protected Post getEntity() {
		post = new Post();
		post.setDescription("description");
		post.setStartDt(new Timestamp(DateTime.now().getMillis()));
		return post;
	}

	@Override
	protected GenericDao<Post> getDAO() {
		
		return dao;
	}

	@Override
	protected long getId() {
		
		return post.getId();
	}

}
