public class Prime10001 {
    public static void main(String[] args) {
        long startTime = System.nanoTime();
        success();
        long endTime   = System.nanoTime();
        double totalTime = endTime - startTime;
        System.out.println(totalTime/1_000_000_000);
    }

    static void success() {
        int cnt = 5;
        for (int i = 11; cnt <= 10001; i+=2) {
            if (i % 3 != 0 && i % 5 != 0 && i % 7 != 0) {
                if (dwaDzielniki(i)) {
                    System.out.println(cnt + ": " + i);
                    cnt++;
                }
            }
        }
    }

    static boolean dwaDzielniki(int n) {
        
        int nSqrt = (int)Math.sqrt(n) + 1;
        //zeby sie nie iterowac do n, a do najwiekszej mozliwej wartosci jaka osiagnie dzielnik

        for (int i = 2; i < nSqrt; ++i) {
            if (n % i == 0) {
                return false;
            }
        }

        return true;
    }
}