package com.company;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

 class heapsort {

        public static void main(String[] args) {
            int[] array = {1,8,7,6,5,4,3,2,9};
            System.out.println(Solution(array,4));

        }
        public static ArrayList<Integer> Solution(int[] array, int k) {
            ArrayList<Integer> result = new ArrayList<>();
            int length = array.length;
            if (k > length || k <= 0) {
                return result;
            }
//            PriorityQueue<Integer> maxheap = new PriorityQueue<Integer>(k, new Comparator<Integer>() {
//                @Override
//                public int compare(Integer o1, Integer o2) {
//
//                    return o1.compareTo(o2);
//                }
//            });
            PriorityQueue<Integer> maxheap = new PriorityQueue<>(k,(o1, o2) -> o1 - o2);//o1-o2升序排列。o2-o1降序。
            for (int a: array
                 ) {
                maxheap.add(a);
                if (maxheap.size()>k){
                    maxheap.poll();
                }

            }

            for(Integer num : maxheap){
                result.add(num);
            }
            return result;
        }

    }