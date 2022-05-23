package e2;

public class Fibonacci {
    public static void main(String[] args) {
        
        int val1 = 0, val2 = 1;
        int addEven = 0;
        
        while (val1 < 4_000_000 && val2 < 4_000_000){
            val1 = val1 + val2;
            val2 = val1 + val2;
            if (val1 % 2 == 0) {
                addEven += val1;
            }
            if (val2 % 2 == 0) {
                addEven += val2;
            }
        }
        
        System.out.println(addEven);
    }
}