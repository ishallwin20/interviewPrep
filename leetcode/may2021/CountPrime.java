package may2021;

class CountPrime {
    public int countPrimes(int n) {
        if(n==0 || n==1 || n==2) return 0;
        int[] dp = new int[5000001];
        dp[0] = 1;
        dp[1] = 1;
        int count = 0;
        for(int i = 2;i<n;i++) {
            if(dp[i] == 0) {
                count ++;
                int maxScope = n / i;
                for (int j = 2; j <= maxScope && i * j < n; j++) {
                    dp[i * j] = 1;
                }
            }
        }

        /*int count = 0;

        for(int i=0;i<n;i++) {
            if(dp[i] == 0) count++;
        }
*/
        return count;
    }
    public static void main(String[] args) {
        CountPrime cp = new CountPrime();
        System.out.println(cp.countPrimes(100));
    }
}