package zhixingshunxu;

public class B {
	 public B() {
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
	    {
	    	System.out.println("父类静态方法块1测试");
	    }
	    public static void print2(){
	    	System.out.println("父类静态方法测试");
	    }
	    {
	    	System.out.println("父类静态方法块2测试");
	    }
}
