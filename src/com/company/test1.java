package com.company;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

//给定⼀个按开始时间从⼩到⼤排序的时间区间集合，请将重叠的区间合并。时间
//        区间集合⽤⼀个⼆维数组表示，⼆维数组的每⼀⾏表示⼀个时间区间（闭区间），
//        其中0位置元素表示时间区间开始，1位置元素表示时间区间结束。
//        例1：输⼊：[[1,3],[2,6],[8,10],[15,18]]
//        返回：[[1,6],[8,10],[15,18]]
//        解释：时间区间[1,3]和[2,6]有部分重叠，合并之后为[1,6]
//        例2：输⼊：[[1,4],[4,5]]
//        返回：[[1,5]]
//        解释：时间区间[1，4]和[4，5]重叠了⼀个时间点，合并之后为[1，5]
//        需要实现的⽅法原型：int[][]merge(int[][]intervals)
public class test1 {
    public static void main(String[] args) {
//        int[][] xx= {{1,3},
//            {2,6},{8,10},{15,18}};
//        String w ="worldisgood";
//        String ab ="world1s3d";
//        System.out.println(valid(w,ab));
//        int[][] aaa = merge(xx);
//        for (int i =0;i<aaa.length;i++){
//            System.out.println(Arrays.toString(aaa[i]));
//        }
        Class cl = fa.class;
        Field[] fields = cl.getFields();
        for (Field f:fields
             ) {
            System.out.println(f.toString());
        }
        Method[] methods = cl.getDeclaredMethods();
        for (Method m:methods
             ) {
            System.out.println(m.toString());
        }
        fa f = new fa();
        f.t2();

    }
  public static int[][] merge(int[][]intervals){
        List<int[]> result = new ArrayList<>();
      Arrays.sort(intervals, Comparator.comparingInt(o-> o[0]));
      int start =intervals[0][0];
      int end = intervals[0][1];
      for(int[] interval:intervals ) {
          if (interval[0] > end) {
              result.add(new int[]{start, end});
              start = interval[0];
          }
          end = Math.max(interval[1],end);
      }
      result.add(new int[]{start,end});
      return result.toArray(new int[][]{});
  }


   static boolean valid(String word,String abbr){
        char[] words=word.toCharArray();
        char[] abbrs=abbr.toCharArray();
        String numberTemp = "";
        int wordsIndex = 0;
       for (char temp : abbrs
            ) {
           if (Character.isDigit(temp)){
               numberTemp =numberTemp+temp;
               continue;
           }else {
               if (!"".equals(numberTemp)){
                   wordsIndex = wordsIndex + Integer.parseInt(numberTemp);
                   numberTemp = "";
               }
               if (wordsIndex>=words.length){
                   return false;
               }
               if (temp==words[wordsIndex]){
                   wordsIndex++;
                   continue;
               }else {
                   return false;
               }
           }

       }
       return wordsIndex==words.length;
  }


}
class fa {
    private int x=10;//反射无法查看private的属性
    public int x1=20;

    private void  t1(){//可以查看private的方法
        System.out.println("测试");
    }
    public void  t2(){
        System.out.println("2222");
        this.t1();
    }
}


//给定⼀个⾮空字符串s和⼀个缩写abbr，请校验它们是否匹配。假设字符串
//        中只包含⼩写字⺟，缩写中只包含⼩写字⺟和数字。缩写中的数字表示其缩略
//        的字符数；连续多位数字表示⼀个多位数。
//        例如，字符串“word”的缩写有且仅有以下这些：[“word","1ord","w1rd",
//        "wo1d","wor1","2rd","w2d","wo2","1o1d","1or1","w1r1","1o2","2r1",
//        "3d","w3",“4"]。
//        例1：输⼊：s=“internationalization"，abbr="i12iz4n"
//        返回：true
//        解释：abbr中的12表示有⼗⼆个字符被缩略了。
//        例2：输⼊：s=“apple"，abbr=“a2e"
//        返回：false
//        需要实现的⽅法原型：booleanvalid(Stringword,Stringabbr)

