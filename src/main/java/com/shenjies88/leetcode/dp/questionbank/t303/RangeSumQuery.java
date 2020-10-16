package com.shenjies88.leetcode.dp.questionbank.t303;

/**
 * @author shenjies88
 * @since 2020/09/17/17:43
 */
public class RangeSumQuery {
    public static void main(String[] args) {
        RangeSumQuery rangeSumQuery = new RangeSumQuery();
        NumArray numArray = rangeSumQuery.new NumArray(new int[]{-2, 0, 3, -5, 2, -1});
        System.out.println(numArray.sumRange(0, 2));
        System.out.println(numArray.sumRange(2, 5));
        System.out.println(numArray.sumRange(0, 5));
    }

    class NumArray {
        private final int[] nums;

        public NumArray(int[] nums) {
            this.nums = nums;
        }

        public int sumRange(int i, int j) {
            int sum = 0;
            for (; i <= j; i++) {
                sum += nums[i];
            }
            return sum;
        }
    }
}
