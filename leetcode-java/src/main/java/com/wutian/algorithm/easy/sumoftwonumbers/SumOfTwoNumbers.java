package com.wutian.algorithm.easy.sumoftwonumbers;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @author liGuAngXin
 * @date 2021-6-28 20:36
 * @description 两数之和
 */
public class SumOfTwoNumbers {
    public static void main(String[] args) {
        int[] nums = new int[]{2, 7, 9, 11};
        int target = 9;
        SumOfTwoNumbers sum = new SumOfTwoNumbers();
        int[] result = sum.violenceTraversal(nums, target);
        System.out.println(Arrays.toString(result));

        int[] map = sum.withHash(nums, target);
        System.out.println(Arrays.toString(map));
    }

    public int[] violenceTraversal(int[] nums, int target){
        for (int i = 0, n = nums.length; i < n; i++){
            for (int j = i; j < nums.length; j++){
                if (nums[i] + nums[j] == target){
                    return new int[]{i, j};
                }
            }
        }
        return new int[0];
    }

    public int[] withHash(int[] nums, int target){
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0, n = nums.length; i < n; i++) {
            if (hashMap.containsKey(target - nums[i])){
                return new int[]{hashMap.get(target - nums[i]), i};
            }
            hashMap.put(nums[i], i);
        }
        return new int[0];
    }
}
