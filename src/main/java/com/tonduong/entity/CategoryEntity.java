package com.tonduong.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name = "category")
@EntityListeners(AuditingEntityListener.class) // Lắng nghe ???
public class CategoryEntity extends BaseEntity {

	@Column(name = "code")
	private String code;

	@Column(name = "name")
	private String name;

	@OneToMany(mappedBy = "category")
	private List<NewEntity> news;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<NewEntity> getNews() {
		return news;
	}

	public void setNews(List<NewEntity> news) {
		this.news = news;
	}
}
