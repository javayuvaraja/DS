public class StrExample {
	public static void main(String[] args) {
		String s="Udhaya";
		String s1="Dhanagopalan";
		String s3="     My name is Udhaya";
		String s4="the-cat-is-sitting-on-the-mat";
		System.out.println(s.toUpperCase());//given string change in to uppercase
		System.out.println(s.toLowerCase());// change in to lowercase
		System.out.println(s.length());// the length of the string
		System.out.println(s.concat(s1));//is used for join the two string
		System.out.println(s1.indexOf('g'));// it is used for pointing the position of a given char , if its not it will give -1
		System.out.println(s1.indexOf('a'));// 
		System.out.println(s3.contains(s));//it is return a boolean true or false
		System.out.println(s3.trim( ));// it is used for triming the whitespace
		System.out.println(s4.substring(0,5));// it is used for display start and end char of the string
		System.out.println(s1.intern());// it will check the string in the pool or not
		System.out.println(s1.compareTo(s));
		System.out.println(s.lastIndexOf(3));
		System.out.println(s.indexOf(1));
		System.out.println(s1.replace("a","A"));
		String[] arr = s4.split("-"); 
		
			
	}
}
