package eu.lestard.redux;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

import javafx.application.Platform;

public class Store<S> {

	private S currentState;

	private Reducer<S> reducer;

	private DispatchFunction dispatch = action -> {
		S oldState = this.currentState;

		S newState = reducer.reduce(oldState, (Action) action);

		if (oldState != newState && !oldState.equals(newState)) {
			this.currentState = newState;

			notifySubscribers();
		}
	};


	private List<Subscriber<S>> subscribers = new ArrayList<>();

	@SafeVarargs
	public Store(S initialState, Reducer<S> rootReducer, Middleware<S>... middlewares) {
		this.currentState = initialState;
		this.reducer = rootReducer;

		for (Middleware<S> middleware : middlewares) {
			Function<DispatchFunction, DispatchFunction> middlewareFunction = middleware
					.apply(this::dispatch, this::getState);

			this.dispatch = middlewareFunction.apply(this.dispatch);
		}
	}

	public S getState() {
		return this.currentState;
	}

	public void dispatch(Object action) {
		if (Platform.isFxApplicationThread()) {
			this.dispatch.accept(action);
		} else {
			Platform.runLater(() -> this.dispatch.accept(action));
		}
	}

	private void notifySubscribers() {
		subscribers.forEach(subscriber -> subscriber.onChange(this.currentState));
	}

	public Subscription subscribe(Subscriber<S> subscriber) {
		subscribers.add(subscriber);

		subscriber.onChange(this.currentState);

		return () -> {
			subscribers.remove(subscriber);
		};
	}

}
