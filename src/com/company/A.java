package com.company;

public class A extends c{
    public void test(){
       // super.test();继承父类的方法
        System.out.println("sonfangfa");
    }
    public static void main(String[] args) {

        A a=new A();
        a.tes();
        System.out.println();
    }


    void tes() {
        System.out.println("继承抽象");
    }
}
class B{

    protected void test(){
        System.out.println("father");
    }
    void test1(){
        System.out.println("test1baba");
    }
        }

        abstract class c{
    private int xx;

    abstract void tes();
        }
