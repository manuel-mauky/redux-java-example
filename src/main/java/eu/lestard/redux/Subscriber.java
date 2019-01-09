package eu.lestard.redux;

@FunctionalInterface
public interface Subscriber<S> {

	void onChange(S state);

}
