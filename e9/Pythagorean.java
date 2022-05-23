public class Pythagorean {
    public static void main(String[] args) {
        long startTime = System.nanoTime();
        fun();
        long endTime   = System.nanoTime();
        double totalTime = endTime - startTime;
        System.out.println(totalTime/1_000_000_000);
    }

    static void fun() {
        breakLoopName:
        for (int a=1; a<500; a++)
        {
            for (int b=1; b<500; b++)
            {
                if (a*a+b*b == (1000-a-b)*(1000-a-b)) {
                    System.out.println((a*b*(1000-a-b)));
                    break breakLoopName;
                }
            }
        }
    }

    // Moje uposledzone
    // static int fun() {

    //     for (int b = 1; b < 1000; ++b) {
    //         for (int c = 1; c < 1001; ++c) {
    //             int aSqr = (-1)*(b-c)*(b+c);
    //             double aSqrRoot = Math.sqrt(aSqr);

    //             if (Math.abs(aSqrRoot - (int)Math.sqrt(aSqr)) <= 1E-16) {
    //                 int a = (int)Math.round(aSqrRoot);
    //                 if (a+b+c == 1000) {
    //                     System.out.println(a + " " + b + " " + c);
    //                     System.out.println(a*b*c);
    //                 }
    //             }
    //         }
    //     }

    //     return 0;
    // }
}