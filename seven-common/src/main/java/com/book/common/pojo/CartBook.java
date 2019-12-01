package com.book.common.pojo;
/**
 * cookie中存储的商品实体类
 * @ClassName: CartBook
 * @Title: CartBook
 * @author: 
 * @date: 2019年8月24日
 */
public class CartBook {
	
	private Long id;
	
	private String bookName;
	
	private String author;
	
	private Long price;
	
	private Integer num;
	
	private String image;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public Long getPrice() {
		return price;
	}

	public void setPrice(Long price) {
		this.price = price;
	}

	public Integer getNum() {
		return num;
	}

	public void setNum(Integer num) {
		this.num = num;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}
	
	
}	
