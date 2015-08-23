package com.blankpix.smallz.persistence.dao.impl;

import org.springframework.stereotype.Repository;

import com.blankpix.smallz.model.Post;
import com.blankpix.smallz.persistence.dao.PostDao;

@Repository("PostDao")
public class PostDaoImpl extends GenericDaoImpl<Post> implements PostDao {
	
}
