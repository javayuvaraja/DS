package com.yuva.java8;

public class DefaultInterfaceTest {

}

interface Alpha {
	default void print() {
		System.out.println("Alpha...");
	}
}

interface Gamma extends Alpha {
	default void print() {
		System.out.println("Gamma...");
	}
}


interface Beta extends Alpha {
	default void print() {
		System.out.println("Beta...");
	}
}

interface Delta extends Gamma, Beta {

	// If this interface doesnt overide print method compilation fails because of duplication method
	
	@Override
	default void print() {
		// TODO Auto-generated method stub
		Beta.super.print();
	}
}




interface A  {
	default void print() {
		System.out.println("Beta...");
	}	
}


interface B  {
	default void print() {
		System.out.println("Beta...");
	}	
}

class C implements A, B {

	
	// If this class doesnt overide print method compilation fails because of duplication method
	
	@Override
	public void print() {
		A.super.print();
	}
	
}
