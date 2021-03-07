package com.company;

import java.lang.reflect.Array;
import java.sql.SQLOutput;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        int[] nums={};
        int[] x=new int[2];
       // System.out.println(5.0/2.0);
        System.out.println(Arrays.toString(searchRange(nums,6)));
        char j = '中';
        System.out.println(j);



    }
    public static int[] searchRange(int[] nums, int target) {
        int[] res = {-1,-1};
        int start=-1,end=-1;
        if (nums.length==0){
            return res;
        }
        for (int i =0;i<nums.length;i++){
            if (nums[i]==target){
                start=i;
                break;
            }
        }
        for (int j=nums.length-1;j>=0;j--){
            if (nums[j]==target){
                end=j;
                break;
            }
        }
        res[0]=start;
        res[1]=end;

        return res;
    }

    public static int numSub(String s) {
        int l=s.length();
        int j= 0;
        int x=0;
        for(int i= 0;i<l;i++){
            if (s.charAt(i)=='0'&&j==0){
                continue;
            }else if (s.charAt(i)=='0'&&j>0){
                x=x+num(j);
                j=0;
            }else if(s.charAt(i)=='1'){
                j++;
            }
        }
        x=x+num(j);
        x=Math.floorMod(x,(int)Math.pow(10,9)+7);

        return  x;
    }
    public  static int num(int n){
       int sum=0;
        if(n>0){
        return sum=num(n-1)+n;}
        else
            return sum;
    }
    public static int numIdenticalPairs(int[] nums) {
        int n = nums.length;
        if (n==0){
            return 0;
        }
        int cur=0;
        for(int i=0;i<n;i++){
            int j=n-1;
            while (i<j){
                if(nums[i]==nums[j]){
                    cur++;
                    j--;
                }else {
                    j--;
                }
            }
        }
        return cur;
    }
    public static int maxProfit(int[] prices) {
        int n = prices.length;
        int[] dp = new int[n+1];
        dp[0]=0;
        dp[1]=0;
        for (int i = n;i>0;i--){
            for (int j =i-1;j>0;j--){
                dp[i]=dp[j]+prices[i]-prices[j+1];
                dp[i-1]=dp[j]+prices[i-1]-prices[j+1];
                dp[i]=Math.max(dp[i],dp[i=1]);
            }
        }
        return dp[n];
    }
    public static int findRepeatNumber(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int re=-1;
        for (int n:nums
             ) {
            if (!set.add(n)){
                return n;
            }
        }
        return re;
    }
    public static int[] divingBoard(int shorter, int longer, int k) {
        if(k==0){
            int[] n =new int[0];
            return n;
        }
        if (shorter==longer){
            int[] n1={shorter*k};
            return n1;
        }
        int j=k+1;
        int[] nums= new int[j];
        for(int i=0;i<j;i++,k--){
            int res = shorter*k+longer*i;
            nums[i]=res;
        }
        return nums;
    }
    public static int firstMissingPositive(int[] nums) {
        Arrays.sort(nums);
        int len = nums.length;
        if(len <= 0){
            return 1;
        }

        int currentMin = 0;
        int lastNum = 0;
        for(int i = 0 ;i < len ; i++){
            if(nums[i] <=0){
                continue;
            }

            if(nums[i] > currentMin + 1){
                return  currentMin + 1;
            }else{
                if(lastNum == nums[i]){
                    continue;
                }
                lastNum = nums[i];
                currentMin = currentMin + 1;
            }
        }

        return currentMin +1;
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();
        int l =0,r=nums.length-1;
        Arrays.sort(nums);
        if (r<2){
            return lists;
        }
        while (l<r-1){
            if (nums[l]+nums[r]<=0){
                for (int i=1;i<=r-l;i++){
                    if (nums[r] == nums[r - 1]) {
                        continue;
                    }

                    if (nums[l]+nums[r]+nums[r-i]<0){
                        l++;
                        break;
                    }
                    else if (nums[l]+nums[r]+nums[r-i]==0){
                        lists.add(new ArrayList<>(Arrays.asList(nums[l],nums[r],nums[r-i])));
                        r--;
                        break;
                    }

                   }

            }else if (nums[l]+nums[r]>0){
                for (int j=1;j<r-l;j++){
                    if (nums[l]==nums[l+2]){
                    l++;
                     }
                    if (nums[l]+nums[r]+nums[l+j]>0){
                        r--;
                        break;
                    }
                    if (nums[l]+nums[r]+nums[l+j]==0){
                        lists.add(new ArrayList<>(Arrays.asList(nums[l],nums[r],nums[l+j])));
                        l++;
                        break;
                    }



                }

            }

        }

        return lists;
    }
    public static int[] daily(int[] T) {
        int length = T.length;
        int[] result = new int[length];
        Stack<Integer> stack = new Stack<Integer>();
        for (int i=0;i<length;i++){
            while (!stack.isEmpty()&&T[i]>T[stack.peek()]){
                result[stack.peek()] = i-stack.pop();
            }
            stack.push(i);
        }
        return result;
    }
    public static int[] dailyTemperatures(int[] T) {
        int[] ans = new int[T.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < T.length; i++) {
            while (!stack.isEmpty() && T[i] > T[stack.peek()]) {
                ans[stack.peek()] = i - stack.pop();
            }
            stack.push(i);
        }
        while (!stack.isEmpty()) {  //这里的代码可以不需要，因为ans数组在初始化的时候就是0，写出来是方便理解题目中“若没有比其大则为0”的条件
            ans[stack.pop()] = 0;
        }
        return ans;
    }

    public static int[] dailyTemperatures1(int[] T) {
        int length = T.length;
        int[] result = new int[length];

        //从右向左遍历
        for (int i = length - 2; i >= 0; i--) {
            // j+= result[j]是利用已经有的结果进行跳跃
            for (int j = i + 1; j < length; j+= result[j]) {
                if (T[j] > T[i]) {
                    result[i] = j - i;
                    break;
                } else if (result[j] == 0) { //遇到0表示后面不会有更大的值，那当然当前值就应该也为0
                    result[i] = 0;
                    break;
                }
            }
        }

        return result;}
    public static boolean isPalindrome(int x) {
        String str = String.valueOf(x);
        if (str.charAt(0)=='!'){
            return false;
        }
        int l=0;
        int n = str.length();
        int r=n-1;
        while (l<r){
            if (str.charAt(l)!=str.charAt(r)){
                return false;
            }else {
                l++;
                r--;
            }
        }
        return true;
    }
    public static int translateNum(int num) {

        String str=String.valueOf(num);
        int[] dp=new int[str.length()+1];
        dp[str.length()]=1;
        dp[str.length()-1]=1;
        for (int i=str.length()-2;i>=0;--i){
            dp[i]=dp[i+1];
            if (str.charAt(i)!='0'){
                int curNum=(str.charAt(i)-'0')*10+(str.charAt(i+1)-'0');
                if (curNum<26)
                    dp[i]+=dp[i+2];
            }
        }
        return dp[0];
    }

        public static  int translate(int num) {
            if(num<0){
                return 0;
            }
            String s=String.valueOf(num);
            int dp[]=new int[s.length()];
            dp[0]=1;
            if(num>9){
                if(s.charAt(0)=='1'||(s.charAt(0)=='2'&&s.charAt(1)<'6')){
                    dp[1]=2;
                }else {
                    dp[1]=1;
                }
            }
            for(int i=2;i<s.length();i++){
                if(s.charAt(i-1)=='1'||(s.charAt(i-1)=='2'&&s.charAt(i)<'6')){
                    dp[i]=dp[i-2]+dp[i-1];
                }else{
                    dp[i]=dp[i-1];
                }
            }
            return dp[s.length()-1];
        }


    public static int[] getStrongest(int[] arr, int k) {
        int len = arr.length;
        int m = (len -1)/2;
        Arrays.sort(arr);
        int[] max = new int[k];
        List<Integer> list= new ArrayList<>();
        int l=0,r=len-1;
        while (l<r){
        if(Math.abs(arr[r]-arr[m])>=Math.abs(arr[l]-arr[m])){
            list.add(arr[r]);
            r--;
        }else {
            list.add(arr[l]);
            l++;
        }
        }
        for (int i = 0 ; i<k ;i++){
            max[i]=list.get(i);
        }

    return max;
    }
    public static int[] shu(int[] nums, int n) {

        int[] x = new int[n];
        int[] y = new int[n];
        int[] num=new int[2*n];
        for(int i=0;i<n;i++){
            x[i]=nums[i];
        }
        for(int j=n,i=0;j<2*n;j++,i++){
            y[i]=nums[j];
        }
        for (int i=0 ,j=0;i<2*n;i=i+2,j++){
            num[i]=x[j];
        }
        for(int j=1,i=0;i<n;j=j+2,i++){
            num[j]=y[i];
        }
        return num;
    }
}
