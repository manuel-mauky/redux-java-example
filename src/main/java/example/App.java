package example;

import eu.lestard.easydi.EasyDI;
import eu.lestard.redux.Store;
import eu.lestard.redux.middlewares.ListMiddleware;
import eu.lestard.redux.middlewares.LoggingMiddleware;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.net.URL;
import java.util.Collections;

public class App extends Application {
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		EasyDI context = new EasyDI();

		TodoState initialState = new TodoState(Collections.emptyList());


		Store<TodoState> store = new Store<>(initialState, new TodoReducer(),
			new LoggingMiddleware<>(),
				new ListMiddleware<>()
		);

		context.bindInstance(Store.class, store);

		final URL location = this.getClass().getResource("TodoView.fxml").toURI().toURL();

		FXMLLoader fxmlLoader = new FXMLLoader(location);
		fxmlLoader.setControllerFactory(context::getInstance);

		final VBox parent = fxmlLoader.load();

		primaryStage.setScene(new Scene(parent));
		primaryStage.show();
	}
}