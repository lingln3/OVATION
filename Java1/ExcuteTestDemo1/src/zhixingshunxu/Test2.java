package zhixingshunxu;

public class Test2 extends B {
    public Test2() {
        System.out.println("Test1�Ĺ��췽��");
    }
    {
    	System.out.println("���ྲ̬������1����");
    }
    public static void testT(){
    	System.out.println("���ྲ̬��������");
    }

    public static int k = print();
    {
    	System.out.println("���ྲ̬������2����");
    }
    public static int print() {
        System.out.println("Test print");
        return 522;
    }

    public static void main(String[] args) {
        System.out.println("main start");
        Test2 t1 = new Test2();
        Test2 t2  = new Test2();
    }
}