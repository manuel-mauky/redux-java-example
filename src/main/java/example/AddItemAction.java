package example;


import eu.lestard.redux.Action;

import java.util.Objects;

public class AddItemAction implements Action {
	private final String value;

	public AddItemAction(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		AddItemAction that = (AddItemAction) o;
		return Objects.equals(value, that.value);
	}

	@Override
	public int hashCode() {
		return Objects.hash(value);
	}

	@Override
	public String toString() {
		return "AddItem(" + this.value + ")";
	}
}
