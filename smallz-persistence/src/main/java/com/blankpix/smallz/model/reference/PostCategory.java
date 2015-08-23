
package com.blankpix.smallz.model.reference;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.blankpix.smallz.model.AuditDtls;

/**
 * An item in an order
 */
@Entity
public class PostCategory extends AuditDtls{
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	private String description;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "Post [id=" + id + ", description=" + description + "]";
	}
	
}
