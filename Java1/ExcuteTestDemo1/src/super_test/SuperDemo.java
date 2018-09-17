package super_test;

public class SuperDemo {
	public static void main(String[] args){
		Animal an1 = new Animal(10);
		Animal an2 = new Dog(10);
		an2.say();
		Dog dog = new Dog(10);
		System.out.println(an2.s);
//		Dog dog2 = (Dog) new Animal("dd");
//		dog2.say();//验证调用函数是父类的还是子类的
//		System.out.println(dog2.s);
	}
}

class Animal{
	String name;
	int height;
	public String s = "父类属性";
	public Animal(String name){
		this.name = name;
	}
	public Animal(int h){
		height = h;
	}
	public void say(){
		System.out.println("父类方法");
	}
}

class Dog extends Animal{
	int age;
	private Dog dog;
	public String s = "子类属性";
	public Dog(){super("hh");};
	public Dog(String nn){super("dd");};
	public Dog(String name,int age){
		this();
		dog = this;
		//super(name);
	}
	public Dog(int age){
		this("hh",19);
	}
	
	public void say(){
		System.out.println("子类方法");
	}
	public void say2(){
		System.out.println("new say 2");
	}
}
