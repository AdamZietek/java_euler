import java.util.ArrayList;
import java.util.Scanner;

public class BigPrime {
    public static void main(String[] args) {

        long num = 0;

        System.out.println("Podaj liczbe: ");
        Scanner in = new Scanner(System.in);
        num = in.nextLong();
        in.close();
        
        bigPrime(num);
    }

    static ArrayList<Integer> bigPrime(long n) {
        ArrayList<Integer> p = new ArrayList<Integer>();
        
        long num = n;
        while (num != 1){
            for (long i = 2; i <= num; ++i){
                if (num % i == 0) {
                    num = num/i;
                    p.add((int)i);
                    break;
                }
            }
        }
        
        for (int x : p) {
            System.out.println(x);
        }

        return p;
    }
}