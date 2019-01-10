package eu.lestard.redux.middlewares;

import java.util.List;
import java.util.function.Supplier;

import eu.lestard.redux.DispatchFunction;
import eu.lestard.redux.Middleware;

public class ListMiddleware<S> implements Middleware<S> {
	@Override
	public DispatchFunction apply(DispatchFunction dispatch, Supplier<S> getState) {
		return action -> {
			if (action instanceof List) {
				List actionList = (List) action;

				actionList.forEach(dispatch);
			} else {
				dispatch.accept(action);
			}
		};
	}
}
