package example;

import eu.lestard.redux.Store;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

public class TodoViewController {
	@FXML
	private ListView<String> items;
	@FXML
	private TextField input;

	private final Store<TodoState> store;

	public TodoViewController(Store<TodoState> store) {
		this.store = store;
	}

	public void initialize() {
		store.subscribe(newState -> {
			items.getItems().setAll(newState.getItems());
		});
	}

	public void addItem() {
		final String text = input.getText();

		store.dispatch(TodoActionCreators.addItem(text));

		input.setText("");
	}
}
