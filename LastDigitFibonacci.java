import java.util.Scanner;

public class LastDigitFibonacci {

    private static int modOfString(String s, int mod) {
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch < '0' || ch > '9')
                continue; // safety (ignore non-digits)
            res = (res * 10 + (ch - '0')) % mod;
        }
        return res;
    }

    private static int lastDigitOfSum(String nStr) {
        int period = 60;

        // k = (n + 2) % 60 => (n%60 + 2) % 60
        int nMod = modOfString(nStr, period);
        int k = (nMod + 2) % period;

        // Compute F(k) mod 10
        int prev = 0, curr = 1;
        if (k == 0) {
            // F0 = 0 => (F0 - 1) mod 10 = 9
            return 9;
        }

        for (int i = 1; i < k; i++) {
            int next = (prev + curr) % 10;
            prev = curr;
            curr = next;
        }

        // Answer = (F(k) - 1) mod 10
        return (curr + 9) % 10;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String nStr = sc.next().trim();
        System.out.println(lastDigitOfSum(nStr));
    }

}