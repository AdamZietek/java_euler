public class Prime2mil {
    public static void main(String[] args) {
        long startTime = System.nanoTime();
        fun();
        long endTime   = System.nanoTime();
        double totalTime = endTime - startTime;
        System.out.println(totalTime/1_000_000_000);
    }

    static void fun() {
        long sum = 2+3+5+7;
        //!! int byl za maly

        for (int i = 11; i < 2000000; i += 2) {
            if (i%3!=0 && i%5!=0 && i%7!=0) {
                if (isMultipleOfHigherPrimes(i) == false){
                    sum += i;
                }
            }
        }

        System.out.println(sum);
    }

    static boolean isMultipleOfHigherPrimes(int n) {
        
        int nMax = (int)Math.sqrt(n) + 1;
        for (int i = 2; i < nMax; ++i) {
            if (n%i == 0) { 
                return true; 
            }
        }

        return false;
    }
}