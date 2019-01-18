package eu.lestard.redux.middlewares.thunk;

import java.util.function.Function;
import java.util.function.Supplier;

import eu.lestard.redux.DispatchFunction;
import eu.lestard.redux.Middleware;

public class ThunkMiddleware<S> implements Middleware<S> {

	@Override
	public Function<DispatchFunction, DispatchFunction> apply(DispatchFunction dispatch,
			Supplier<S> getState) {
		return next -> action -> {
			if (action instanceof Thunk) {
				Thunk<S> thunk = (Thunk<S>) action;

				thunk.accept(dispatch, getState);
			} else {
				next.accept(action);
			}
		};
	}
}
