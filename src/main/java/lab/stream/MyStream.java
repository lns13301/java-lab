package lab.stream;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class MyStream<T> {
    private List<T> list;

    public MyStream(List<T> list) {
        this.list = list;
    }

    public static <T> MyStream<T> of(List<T> list){
        return new MyStream<>(list);
    }

    public MyStream<T> filter(Predicate<? super T> predicate) {
        List<T> result = new ArrayList<>();
        for (T t : list) {
            if (predicate.test(t)) {
                result.add(t);
            }
        }
        return new MyStream<>(result);
    }

    public <R> MyStream<R> map(Function<? super T, ? extends R> mapper) {
        List<R> result = new ArrayList<>();
        for (T t : list) {
            result.add(mapper.apply(t));
        }
        return new MyStream<>(result);
    }

    public <R> MyStream<R> flatMap(Function<? super T, ? extends MyStream<? extends R>> mapper) {
        List<R> result = new ArrayList<>();
        for (T t : list) {
            MyStream<? extends R> apply = mapper.apply(t);
            apply.forEach(result::add);
        }
        return new MyStream<>(result);
    }

    public MyStream<T> distinct() {
        return new MyStream<>(new ArrayList<>(new HashSet<>(list)));
    }

    public List<T> toList() {
        return new ArrayList<>(list);
    }

    public Long count() {
        return (long) list.size();
    }

    public void forEach(Consumer<? super T> action) {
        for (T t : list) {
            action.accept(t);
        }
    }
}
