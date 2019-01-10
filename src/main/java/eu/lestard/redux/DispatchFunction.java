package eu.lestard.redux;

import java.util.function.Consumer;

@FunctionalInterface
public interface DispatchFunction extends Consumer<Object> {

	@Override
	void accept(Object action);

}
