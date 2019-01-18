package eu.lestard.redux.middlewares.thunk;

import java.util.function.BiConsumer;
import java.util.function.Supplier;

import eu.lestard.redux.DispatchFunction;

public interface Thunk<S> extends BiConsumer<DispatchFunction, Supplier<S>> {

	@Override
	void accept(DispatchFunction dispatch, Supplier<S> getState);

}
