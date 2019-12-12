package exam;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class SuperIterable<E> implements Iterable<E> {
    private Iterable<E> self;

    public SuperIterable(Iterable<E> self) {
        this.self = self;
    }

    public <F> SuperIterable<F> flatMap(Function<E, F> op) {
        List<F> results = new ArrayList<>();
        for (E e : self) {
            results.add(op.apply(e));
        }
        return new SuperIterable(results);
    }

    public <F> SuperIterable<F>  map(Function<E, F> op) {
        List<F> results = new ArrayList<>();
        for (E e : self) {
            results.add(op.apply(e));
        }
        return new SuperIterable(results);
    }

    public SuperIterable<E> filter(Predicate<E> pred) {
        List<E> res = new ArrayList<>();
        for (E e : self) {
            if (pred.test(e)) {
                res.add(e);
            }
        }
        return new SuperIterable<>(res);
    }

    @Override
    public Iterator<E> iterator() {
        return self.iterator();
    }
}
