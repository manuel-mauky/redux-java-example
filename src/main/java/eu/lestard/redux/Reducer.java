package eu.lestard.redux;

public interface Reducer<S> {

	S reduce(S state, Action action);

}
