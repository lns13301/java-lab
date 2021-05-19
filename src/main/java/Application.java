import lab.stream.Item;
import lab.stream.MyStream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        List<String> alphabets = new ArrayList<>();
        alphabets.add("x");
        alphabets.add("a");
        alphabets.add("x");
        alphabets.add("b");

        System.out.println(MyStream.of(alphabets).filter(x -> x.equals("x")).distinct().count());

        List<Item> items = new ArrayList<>();
        items.add(new Item("포션", 3));
        items.add(new Item("음식", 5));
        items.add(new Item("검", 1));
        items.add(new Item("포션", 10));

        MyStream.of(items).map(Item::getName).forEach(System.out::println);

        List<List<String>> flatNames = new ArrayList<>();
        flatNames.add(Arrays.asList("a", "b", "c"));
        flatNames.add(Arrays.asList("d", "e", "f"));
        flatNames.add(Arrays.asList("g", "h", "i"));

        MyStream.of(flatNames).flatMap(MyStream::of).forEach(System.out::println);
    }
}
