package day16;

public class Ex7_String_Replace {

	public static void main(String[] args) {
		String str = "I love C";
		System.out.println(str);
		str = str.replace("C", "JAVA");
		System.out.println(str);
		str = str + ". JAVA is programig languge";
		System.out.println(str);
		str = str.replace("JAVA", "C");
		System.out.println(str);
	}

}
