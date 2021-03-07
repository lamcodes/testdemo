package com.company;

import java.util.ArrayList;
import java.util.List;

public class t4 {


    public static void main(String[] args) {
        int[] x = {1,2,3};
        t4 t44 = new t4();
        for (List<Integer> l:t44.subsets(x)
             ) {
            System.out.println(l);
        }
    }
    List<List<Integer>> subsets(int[] nums) {
        // 记录走过的路径
        List<Integer> track = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        backtrack(nums, 0, track,res);
        return res;
    }

    void backtrack(int[] nums, int start, List<Integer> track, List<List<Integer>> res) {
        res.add(track);
        for (int i = start; i < nums.length; i++) {
            // 做选择
            track.add(nums[i]);
            // 回溯
            backtrack(nums, i + 1, track,res);
            // 撤销选择
            track.remove(i);
        }
    }

}
