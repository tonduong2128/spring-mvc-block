package com.tonduong.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name = "news")
@EntityListeners(AuditingEntityListener.class) // Lắng nghe ???
public class NewEntity extends BaseEntity {

	@Column(name = "title")
	private String title;

	@Column(name = "thumbnail")
	private String thumbnail;

	@Column(name = "shortdescription")
	@Lob
	private String shortDescription;

	@Column(name = "content")
	@Lob
	private String content;

//	@Column(name = "categoryid") //Khong can vi to tu gen
//	private Long categoryId;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "categoryid")
	private CategoryEntity category;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getThumbnail() {
		return thumbnail;
	}

	public void setThumbnail(String thumbnail) {
		this.thumbnail = thumbnail;
	}

	public String getShortDescription() {
		return shortDescription;
	}

	public void setShortDescription(String shortDescription) {
		this.shortDescription = shortDescription;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public CategoryEntity getCategoryId() {
		return category;
	}

	public void setCategoryId(CategoryEntity category) {
		this.category = category;
	}

}
