package com.jdc.app.entity;

public class SaleDetail {
	private int id;
	private Book book;
	private Category category;
	private Author author;
	private Sale sale;
	private int quantity;
	private int unitPrice;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public Author getAuthor() {
		return author;
	}

	public void setAuthor(Author author) {
		this.author = author;
	}

	public Sale getSale() {
		return sale;
	}

	public void setSale(Sale sale) {
		this.sale = sale;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(int unitPrice) {
		this.unitPrice = unitPrice;
	}
	
	public String getCategoryName() {
		return category.getName();
	}

	public String getAuthorName() {
		return author.getName();
	}
	
	public String getBookName() {
		return book.getName();
	}
	
	public int getSaleTax() {
		return sale.getTax();
	}
	
	public int getSubTotal() {
		return getQuantity() * getUnitPrice();
	}
	
	public int getTotal() {
		return getSubTotal() + getSaleTax();
	}
}
