package com.jdc.app.entity;

public class SaleDetail {
	private int id;
	private Book book;
	private Category category;
	private Author author;
	private Sale sale;
	private int quantity;
	private int unitPrice;
	private boolean delete;
	/* Test Code */
	private String bookName;
	private int bookId;
	private int tax;
	
	public SaleDetail() {
		sale = new Sale();
	}

	public int getTax() {
		return tax;
	}

	public void setTax(int tax) {
		this.tax = tax;
	}

	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	/* Test Code */

	public boolean isDelete() {
		return delete;
	}

	public void setDelete(boolean delete) {
		this.delete = delete;
	}

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
	
//	public String getBookName() {
//		return book.getName();
//	}
	
	public int getSaleTax() {
//		return getSubTotal() * (10/100);
//		return getTax();
		return sale.getTax();
	}
	
	public int getSubTotal() {
		return getQuantity() * getUnitPrice();
	}
	
	public int getTotal() {
		return getSubTotal() + getTax();
	}
	
	
}
