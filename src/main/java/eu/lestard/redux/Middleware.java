package eu.lestard.redux;

import java.util.function.BiFunction;
import java.util.function.Supplier;

public interface Middleware<S> extends BiFunction<DispatchFunction, Supplier<S>, DispatchFunction> {

	@Override
	DispatchFunction apply(DispatchFunction dispatch, Supplier<S> getState);

}
