import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class Foo {
    private static final String FILE_NAME = "foo.txt";
    private static List<String> list = new ArrayList<>();
    public static void main(String[] args) {
        try (PrintWriter out = new PrintWriter(new FileWriter(FILE_NAME))) {
            out.println(list.get(0));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}