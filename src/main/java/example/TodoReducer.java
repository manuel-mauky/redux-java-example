package example;


import eu.lestard.redux.Action;
import eu.lestard.redux.Reducer;

import java.util.ArrayList;
import java.util.List;

public class TodoReducer implements Reducer<TodoState> {

	@Override
	public TodoState reduce(TodoState oldState, Action action) {
		if (action instanceof AddItemAction) {
			AddItemAction addItemAction = (AddItemAction) action;

			List<String> oldItems = oldState.getItems();

			List<String> newItems = new ArrayList<>(oldItems);
			newItems.add(addItemAction.getValue());

			return oldState.withItems(newItems);
		}

		return oldState;
	}
}
