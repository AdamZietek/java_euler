import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

public class Test
{
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new FileReader("C://Users//48604//Desktop//euler//test//text.txt"));

        String sth = in.readLine();
        in.close();

        PrintWriter out = new PrintWriter("C://Users//48604//Desktop//euler//test//text.txt");
        out.println("Bonifacy tu byl");
        out.close();
    }
}