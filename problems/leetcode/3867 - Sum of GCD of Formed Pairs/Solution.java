import java.util.Arrays; // No need to import this when solving on leetcode

class Solution {
    public int gcd(int a, int b) {

        while (b != 0) {
            int remainder = a % b;
            a = b;
            b = remainder;
        }

        return a;
    }

    public long gcdSum(int[] nums) {
        int n = nums.length;
        int[] prefixGCD = new int[n];
        int max = nums[0];
        prefixGCD[0] = gcd(nums[0], max);
        for (int i = 1; i < n; ++i) {
            max = Math.max(max, nums[i]);
            prefixGCD[i] = gcd(nums[i], max);
        }

        Arrays.sort(prefixGCD);
        long sum = 0;
        for (int i = 0; i < n/2; ++i){
            sum += gcd(prefixGCD[i], prefixGCD[n - i - 1]);
        }
        return sum;
    }
}