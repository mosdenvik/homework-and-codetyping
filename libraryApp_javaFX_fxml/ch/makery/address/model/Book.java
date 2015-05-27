package ch.makery.address.model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Book {
	private final IntegerProperty bookID;
	private final StringProperty bookTitle;
	private final StringProperty bookAuthor;
	private final StringProperty bookPublishingHouse;
	private final IntegerProperty bookYear;
	private final IntegerProperty bookPages;

	public Book(){
		this(null, null);
	}
	
	public Book(String bookTitle, String bookAuthor){
		this.bookTitle = new SimpleStringProperty(bookTitle);
		this.bookAuthor = new SimpleStringProperty(bookAuthor);

		this.bookID = new SimpleIntegerProperty(000001);
		this.bookPublishingHouse = new SimpleStringProperty("any publishing house");
		this.bookYear = new SimpleIntegerProperty(2000);
		this.bookPages = new SimpleIntegerProperty(800);
	}

	public Integer getBookID(){
		return bookID.get();
	}
	public void setBookID(Integer bookID){
		this.bookID.set(bookID);
	}
	public IntegerProperty bookIDProperty() {
		return bookID;
	}

	
	
	public String getBookTitle(){
		return bookTitle.get();
	}
	public void setBookTitle(String bookTitle){
		this.bookTitle.set(bookTitle);
	}
	public StringProperty bookTitleProperty() {
		return bookTitle;
	}

	
	
	public String getBookAuthor(){
		return bookAuthor.get();
	}
	public void setBookAuthor(String bookAuthor){
		this.bookAuthor.set(bookAuthor);
	}
	public StringProperty bookAuthorProperty() {
		return bookAuthor;
	}

	
	
	public String getBookPublishingHouse(){
		return bookPublishingHouse.get();
	}
	public void setBookPublishingHouse(String bookPublishingHouse){
		this.bookPublishingHouse.set(bookPublishingHouse);
	}
	public StringProperty bookPublishingHouse() {
		return bookPublishingHouse;
	}

	
	
	public Integer getBookYear(){
		return bookYear.get();
	}
	public void setBookYear(Integer bookYear){
		this.bookYear.set(bookYear);
	}
	public IntegerProperty bookYear() {
		return bookYear;
	}

	
	
	public Integer getBookPages(){
		return bookPages.get();
	}
	public void setBookPages(Integer bookPages){
		this.bookPages.set(bookPages);
	}
	public IntegerProperty bookPages() {
		return bookPages;
	}
}
