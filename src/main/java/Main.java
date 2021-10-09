import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        final Consumer<String> print = System.out::println;

        print.accept("안녕하세요!");
        printTool printTool = new printTool();
        printTool.print("안녕하세요!");

        List<Integer> values = Arrays.asList(7, 5, 123, 5, 42, 95, 68, 30, 42);

        List<Integer> result = values.stream()
            .filter(number -> number < 50)
            .distinct()
            .sorted(Integer::compare)
            .collect(Collectors.toList());
    }
}

class printTool {

    public printTool() {
    }

    public void print(final String value) {
        System.out.println(value);
    }
}
