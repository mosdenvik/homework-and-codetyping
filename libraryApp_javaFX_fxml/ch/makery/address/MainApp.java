package ch.makery.address;

import java.io.IOException;

import ch.makery.address.model.Book;
import ch.makery.address.view.BookEditDialogController;
import ch.makery.address.view.BookOverviewController;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class MainApp extends Application {

	
	private Stage primaryStage;
	private BorderPane rootLayout;
	private ObservableList<Book> bookData = FXCollections.observableArrayList();
	
	public MainApp(){
		bookData.add(new Book("The Complete Reference", "Herbert Schildt"));
		bookData.add(new Book("Thinking in Java", "Bruse Eckel"));
		bookData.add(new Book("Core Java", "Cay S. Horstmann, Gary Cornell"));
		bookData.add(new Book("Algorithms", "Robert Sedgewick, Kevin Wayne"));
		bookData.add(new Book("Head First Java", "Kathy Sierra, Bert Bates"));
		bookData.add(new Book("Patterns in Java vol.1", "Mark Grand"));
	}
	
	public ObservableList<Book> getBookData(){
		return bookData;
	}
	
	
	@Override
	public void start(Stage primaryStage) {
		this.primaryStage = primaryStage;
		this.primaryStage.setTitle("Library");
		
		initRootLayout();
		
		showBookOverview();
	}

	

	private void initRootLayout() {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainApp.class.getResource("view/RootLayout.fxml"));
			rootLayout = (BorderPane) loader.load();
			
			Scene scene = new Scene(rootLayout);
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private void showBookOverview() {
		try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/BookOverview.fxml"));
            AnchorPane bookOverview = (AnchorPane) loader.load();

            rootLayout.setCenter(bookOverview);
            
            BookOverviewController controller = loader.getController();
            controller.setMainApp(this);
        } catch (IOException e) {
            e.printStackTrace();
        }
	}

	public Stage getPrimaryStage() {
        return primaryStage;
    }
	
	public boolean showBookEditDialog(Book book){
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainApp.class.getResource("view/BookEditDialog.fxml"));
			AnchorPane page = (AnchorPane) loader.load();
		
			Stage dialogStage = new Stage();
			dialogStage.setTitle("Edit Book");
			dialogStage.initModality(Modality.WINDOW_MODAL);
			dialogStage.initOwner(primaryStage);
			Scene scene = new Scene(page);
			dialogStage.setScene(scene);
			
			BookEditDialogController controller = loader.getController();
			controller.setDialogStage(dialogStage);
			controller.setBook(book);
			
			dialogStage.showAndWait();
			return controller.isOkClicked();
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	
	
	
	
	
	public static void main(String[] args) {
		launch(args);
	}
}
