package example;

import eu.lestard.redux.middlewares.thunk.Thunk;

public class TodoActionCreators {

	public static Object addItem(String text) {
		return new AddItemAction(text);
	}


	public static Thunk<TodoState> addItemWithThunk(String text) {
		return (dispatch, getState) -> new Thread(() -> {
			dispatch.accept(addItem(text));
		}).start();
	}
}
