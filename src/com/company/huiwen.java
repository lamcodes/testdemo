package com.company;

import java.util.Scanner;

public class huiwen {
    public static boolean isPalindrome(int x) {
        if (x<0) { return false; }
        int len=1;
        for (len=1; (x/len) >= 10; len*=10 );//求出数的长度 len与数一样长

        while (x != 0 ) { //一位数不用比较
            int left = x / len; //最左边的数
            int right = x % 10; //最右边的数

            if(left!=right){
                return false;
            }

            x = (x%len) / 10;//取模把数最左边的数字去掉，/10把数最右边的数字去掉，因为已经判断了左右相等了。
            len /= 100; //因为数去掉了左右两边两个数，长度需要去掉两位。
        }
        return true;
    }

    public static void main(String[] args) {
//        Scanner input = new Scanner(System.in);
//        int n = input.nextInt();
//        int sum = 0;
//        int i=0;
//        while (n>0){
//            if (isPalindrome(i)){
//                n--;
//                sum=sum+i;
//
//            }
//            i++;
//        }
//        System.out.println(sum);
        System.out.println(3%10);
    }

}
