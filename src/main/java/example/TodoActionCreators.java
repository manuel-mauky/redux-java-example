package example;

import java.util.Arrays;

public class TodoActionCreators {

	public static Object addItem(String text) {
		return Arrays.asList(
				new AddItemAction(text)
		);
	}

}
