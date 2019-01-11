package eu.lestard.redux.middlewares;

import java.util.function.Function;
import java.util.function.Supplier;

import eu.lestard.redux.DispatchFunction;
import eu.lestard.redux.Middleware;

public class LoggingMiddleware<S> implements Middleware<S> {

	@Override
	public Function<DispatchFunction, DispatchFunction> apply(DispatchFunction dispatch, Supplier<S> getState) {
		return next -> action -> {

			S stateBefore = getState.get();

			next.accept(action);

			S stateAfter = getState.get();

			System.out.println("dispatched action: " + action);
			System.out.println("state before:");
			System.out.println(stateBefore);
			System.out.println("state after:");
			System.out.println(stateAfter);
		};
	}

}
