package zhixingshunxu;
class A {
    public A() {
        System.out.println("A的构造方法");
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
    	System.out.println("父类静态方法块1测试");
    }
    public static void print2(){
    	System.out.println("父类静态方法测试");
    }
    static {
    	System.out.println("父类静态方法块2测试");
    }
}

public class Test1 extends A {
    public Test1() {
        System.out.println("Test1的构造方法");
    }
    static{
    	System.out.println("子类静态方法块1测试");
    }
    public static void testT(){
    	System.out.println("子类静态方法测试");
    }

    public static int k = print();
    static {
    	System.out.println("子类静态方法块2测试");
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