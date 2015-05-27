package ch.makery.address.view;


import org.controlsfx.dialog.Dialogs;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import ch.makery.address.MainApp;
import ch.makery.address.model.Book;

public class BookOverviewController {
    @FXML
    private TableView<Book> bookTable;
    @FXML
    private TableColumn<Book, String> bookTitleColumn;
    @FXML
    private TableColumn<Book, String> bookAuthorColumn;

    @FXML
    private Label bookIDLabel;
    @FXML
    private Label bookTitleLabel;
    @FXML
    private Label bookAuthorLabel;
    @FXML
    private Label bookPublishingHouseLabel;
    @FXML
    private Label bookYearLabel;
    @FXML
    private Label bookPagesLabel;

    
    private MainApp mainApp;

    
    public BookOverviewController() {
    }

    
    @FXML
    private void initialize() {
        // Initialize the person table with the two columns.
        bookTitleColumn.setCellValueFactory(cellData -> cellData.getValue().bookTitleProperty());
        bookAuthorColumn.setCellValueFactory(cellData -> cellData.getValue().bookAuthorProperty());
        showBookDetails(null);
        bookTable.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> showBookDetails(newValue));
    }

    
    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;

        // Add observable list data to the table
        bookTable.setItems(mainApp.getBookData());
    }
    
    public void showBookDetails(Book book){
    	if(book != null){
    		bookIDLabel.setText(Integer.toString(book.getBookID()));
    		bookTitleLabel.setText(book.getBookTitle());
    		bookAuthorLabel.setText(book.getBookAuthor());
    		bookPublishingHouseLabel.setText(book.getBookPublishingHouse());
    		bookYearLabel.setText(Integer.toString(book.getBookYear()));
    		bookPagesLabel.setText(Integer.toString(book.getBookPages()));

    	}else{
    		bookIDLabel.setText("");
    		bookTitleLabel.setText("");
    		bookAuthorLabel.setText("");
    		bookPublishingHouseLabel.setText("");
    		bookYearLabel.setText("");
    		bookPagesLabel.setText("");

    	}
    }
    
    @FXML
    private void handleDeleteBook() {
        int selectedIndex = bookTable.getSelectionModel().getSelectedIndex();
        if(selectedIndex >= 0){
            bookTable.getItems().remove(selectedIndex);
        } else {
        	Dialogs.create()
            .title("No Selection")
            .masthead("No Book Selected")
            .message("Please select a book in the table.")
            .showWarning();
        }
    }
    
    @FXML
    private void handleNewBook() {
    	Book tempBook = new Book();
    	boolean okClicked = mainApp.showBookEditDialog(tempBook);
    	if (okClicked) {
    		mainApp.getBookData().add(tempBook);
    	}
    }
    
    @FXML
    private void handleEditBook() {
    	Book selectedBook = bookTable.getSelectionModel().getSelectedItem();
    	if (selectedBook != null) {
    		boolean okClicked = mainApp.showBookEditDialog(selectedBook);
    		if (okClicked) {
    			showBookDetails(selectedBook);
    		}
    	} else {
    		Dialogs.create()
            .title("No Selection")
            .masthead("No Book Selected")
            .message("Please select a book in the table.")
            .showWarning();
    	}
    }
}