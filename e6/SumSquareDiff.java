public class SumSquareDiff {
    public static void main(String[] args) {
        int sumOfSquaresNaturalTo10 = 0;
        int squareOfSumsNaturalTo10 = 0;
        int roznica = 0;

        for (int i = 1; i <= 100; ++i) {
            sumOfSquaresNaturalTo10 += Math.pow(i, 2);
            squareOfSumsNaturalTo10 += i;
        }
        squareOfSumsNaturalTo10 = (int)Math.pow(squareOfSumsNaturalTo10, 2);

        roznica = squareOfSumsNaturalTo10 - sumOfSquaresNaturalTo10;

        System.out.println("Roznica to " + roznica);
    }
}