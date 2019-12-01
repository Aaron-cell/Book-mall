package com.book.common.pojo;
/**
 * 数据导入solr实体类
 * @ClassName: BookSolr
 * @Title: BookSolr
 * @author: 
 * @date: 2019年8月22日
 */
public class BookSolr {
	private String id;
	private String bookName;
	private String sellPoint;
	private String author;
	private Long price;
	private String image;
	private String book_cat;
	private String bookDesc;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public String getSellPoint() {
		return sellPoint;
	}
	public void setSellPoint(String sellPoint) {
		this.sellPoint = sellPoint;
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
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getBook_cat() {
		return book_cat;
	}
	public void setBook_cat(String book_cat) {
		this.book_cat = book_cat;
	}
	public String getBookDesc() {
		return bookDesc;
	}
	public void setBookDesc(String bookDesc) {
		this.bookDesc = bookDesc;
	}
	
	
}
