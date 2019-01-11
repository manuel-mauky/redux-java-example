package eu.lestard.redux;

import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

public interface Middleware<S> extends BiFunction<DispatchFunction, Supplier<S>, Function<DispatchFunction,
		DispatchFunction>> {

	@Override
	Function<DispatchFunction, DispatchFunction> apply(DispatchFunction dispatch, Supplier<S> getState);

}
