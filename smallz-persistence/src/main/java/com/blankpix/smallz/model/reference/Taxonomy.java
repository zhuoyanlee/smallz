package com.blankpix.smallz.model.reference;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.blankpix.smallz.model.AuditDtls;

@Entity
public class Taxonomy extends AuditDtls{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	private String name;
	
	private String description;

	@ManyToOne(optional = false)
    @JoinColumn(name = "vid", nullable = false)
	private Vocabulary vocabulary;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Vocabulary getVocabulary() {
		return vocabulary;
	}

	public void setVocabulary(Vocabulary vocabulary) {
		this.vocabulary = vocabulary;
	}
	
	
}
