package com.CK;

public class Main {

    public static void main(String[] args) {
        int[] arr = new int[]{4, 5, 6, 7, 0, 1, 2};
        int target = 9;
        Solution solution = new Solution();
        System.out.println(solution.search(arr, target));
    }
}

class Solution {
    public int search(int[] nums, int target) {
        if (nums.length == 0) return -1;
        int left = 0, right = nums.length - 1, mid, valMid;
        while (left + 1 < right) {
            mid = (left + right) / 2;
            valMid = nums[mid];
            if (valMid == target) return mid;
            else if (valMid >= nums[left]) {
                if (valMid > target && target >= nums[left]) right = mid;
                else left = mid;
            } else if (valMid <= nums[right]) {
                if (valMid < target && target <= nums[right]) left = mid;
                else right = mid;
            }
        }
        if (nums[left] == target) return left;
        if (nums[right] == target) return right;
        return -1;
    }
}