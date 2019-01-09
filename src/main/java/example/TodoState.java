package example;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;

public class TodoState implements Serializable {
	private final List<String> items;

	public TodoState(List<String> items) {
		this.items = Collections.unmodifiableList(items);
	}

	public List<String> getItems() {
		return items;
	}

	public TodoState withItems(List<String> items) {
		if (items.equals(this.items)) {
			return this;
		} else {
			return new TodoState(items);
		}
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder("TodoState (items=" + items.size() + ")[\n");

		items.forEach(item -> builder.append("\t").append(item).append("\n"));

		builder.append("]");
		return builder.toString();
	}
}
