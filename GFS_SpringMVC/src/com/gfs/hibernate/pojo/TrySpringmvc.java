package com.gfs.hibernate.pojo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * TrySpringmvc entity. @author MyEclipse Persistence Tools
 */

@Entity
@Table(name="TrySpringmvc")
public class TrySpringmvc implements java.io.Serializable {

	// Fields

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String name;
	private String file;

	// Constructors

	/** default constructor */
	public TrySpringmvc() {
	}

	/** full constructor */
	public TrySpringmvc(String name, String file) {
		this.name = name;
		this.file = file;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFile() {
		return this.file;
	}

	public void setFile(String file) {
		this.file = file;
	}

}