public class Palindrome{
    public static void main(String[] args) {
        bruteforce();
    }

    static int bruteforce() {
        int maxPalindrome = 0;
        for (int i = 999; i > 0; --i) {
            for (int j = 999; j > 0; --j) {
                int l = i*j;
                if (isPalindrome(l) && l > 100000) {
                    if (l > maxPalindrome) {
                        maxPalindrome = l;
                    }
                }
            }
        }
        System.out.println(maxPalindrome);
        return maxPalindrome;
    }

    static boolean isPalindrome(int l) {
        String num = String.valueOf(l);
        int len = num.length();

        boolean flag = true;

        if (len % 2 == 0) {                                 //dla parzystego l; 999*999 = 998_001
            int i = 0, j = len-1;
            while (flag && i < len/2 && j >= len/2) {       //flaga false, gdy nie palindrom
                if (num.charAt(i) != num.charAt(j)) {
                    flag = false;
                }
                ++i;
                --j;
            }
            if (flag) {
                return true;
            }
        }
        
        return false;
    }
}