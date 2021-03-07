package com.company;

class Example {
    String str = new String("good");
    char[] ch = { 'a', 'b', 'c' };

    public void change(String str, char ch[]) {
        this.str = "test ok";
        ch[0] = 'g';
        System.out.println(str);
    }

    public static void main(String args[]) {

        Example ex = new Example();
        ex.change(ex.str, ex.ch);
        System.out.print(ex.str + " and ");
        System.out.print(ex.ch);
        System.out.println("测试git");
    }

}