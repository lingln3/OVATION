package zhixingshunxu;
class A {
    public A() {
        System.out.println("A�Ĺ��췽��");
    }
    public static int i = test();
    public static int j = print();
    public static String s = "hello world";
    public static int test(){
    	System.out.println("A test");
    	return 2323;
    }
    public static int print() {
        System.out.println("A print");
        return 521;
    }
    static {
    	System.out.println("���ྲ̬������1����");
    }
    public static void print2(){
    	System.out.println("���ྲ̬��������");
    }
    static {
    	System.out.println("���ྲ̬������2����");
    }
}

public class Test1 extends A {
    public Test1() {
        System.out.println("Test1�Ĺ��췽��");
    }
    static{
    	System.out.println("���ྲ̬������1����");
    }
    public static void testT(){
    	System.out.println("���ྲ̬��������");
    }

    public static int k = print();
    static {
    	System.out.println("���ྲ̬������2����");
    }
    public static int print() {
        System.out.println("Test print");
        return 522;
    }

    public static void main(String[] args) {
        System.out.println("main start");
        Test1 t1 = new Test1();
        Test1 t2  = new Test1();
    }
}