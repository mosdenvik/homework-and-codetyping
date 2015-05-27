package ch.makery.address.view;

import org.controlsfx.dialog.Dialog;
import org.controlsfx.dialog.Dialogs;

import ch.makery.address.model.Book;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class BookEditDialogController {

	@FXML
	private TextField bookIDField;
	@FXML
	private TextField bookTitleField;
	@FXML
	private TextField bookAuthorField;
	@FXML
	private TextField bookPublishingHouseField;
	@FXML
	private TextField bookYearField;
	@FXML
	private TextField bookPagesField;

	private Stage dialogStage;
	private Book book;
	private boolean okClicked = false;

	@FXML
	private void initialize() {
	}

	public void setDialogStage(Stage dialogStage) {
		this.dialogStage = dialogStage;
	}

	public void setBook(Book book) {
		this.book = book;

		bookIDField.setText(Integer.toString(book.getBookID()));
		bookTitleField.setText(book.getBookTitle());
		bookAuthorField.setText(book.getBookAuthor());
		bookPublishingHouseField.setText(book.getBookPublishingHouse());
		bookYearField.setText(Integer.toString(book.getBookYear()));
		bookPagesField.setText(Integer.toString(book.getBookPages()));
	}

	public boolean isOkClicked() {
		return okClicked;
	}

	@FXML
    private void handleOk() {
    	if(isInputValid()){
    		book.setBookID(Integer.parseInt(bookIDField.getText()));
    		book.setBookTitle(bookTitleField.getText());
    		book.setBookAuthor(bookAuthorField.getText());
    		book.setBookPublishingHouse(bookPublishingHouseField.getText());
    		book.setBookYear(Integer.parseInt(bookYearField.getText()));
    		book.setBookPages(Integer.parseInt(bookPagesField.getText()));
    		
    		okClicked = true;
    		dialogStage.close();
    	}
	}

	@FXML
	private void handleCancel() {
		dialogStage.close();
	}

	private boolean isInputValid() {
		String errorMessage = "";

		if (bookIDField.getText() == null || bookIDField.getText().length() == 0) {
			errorMessage += "No valid book ID!\n";
		} else {
			try {
				Integer.parseInt(bookIDField.getText());
			} catch (NumberFormatException e) {
				errorMessage += "No valid book ID (must be an integer)!\n";
			}
		}
		if (bookTitleField.getText() == null || bookTitleField.getText().length() == 0) {
			errorMessage += "No valid book title!\n";
		}
		if (bookAuthorField.getText() == null || bookAuthorField.getText().length() == 0) {
			errorMessage += "No valid book author!\n";
		}
		if (bookPublishingHouseField.getText() == null || bookPublishingHouseField.getText().length() == 0) {
			errorMessage += "No valid book Publishing house!\n";
		}
		if (bookYearField.getText() == null	|| bookYearField.getText().length() == 0) {
			errorMessage += "No valid book year!\n";
		} else {
			try {
				Integer.parseInt(bookYearField.getText());
			} catch (NumberFormatException e) {
				errorMessage += "No valid book year (must be an integer)!\n";
			}
		}
		if (bookPagesField.getText() == null || bookPagesField.getText().length() == 0) {
			errorMessage += "No valid book pages!\n";
		} else {
			try {
				Integer.parseInt(bookPagesField.getText());
			} catch (NumberFormatException e) {
				errorMessage += "No valid book pages (must be an integer)!\n";
			}
		}

		if (errorMessage.length() == 0) {
			return true;
		} else {
			Dialogs.create()
				.title("Invalid Fields")
				.masthead("Please correct invalid fields")
				.message(errorMessage)
				.showError();
			return false;
		}
	}

}
