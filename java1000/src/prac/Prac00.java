package prac;

public class Prac00 {

	public static void main(String[] args) {
		
		new Prac00().ss();
		
//		System.out.println("??");
	}
	
	public void ss() {
		int i1 = 12;
		int i2 = i1;
		int i3 = i1;
		String s1 = "s1";
		String s2 = new String("s1");
		
		System.out.println(s1.hashCode());
		System.out.println(s2.hashCode());
		
		if(s1 == s2) {
			System.out.println("s1=s2");
		} else {
			System.out.println("s1!=s2");
		}
		
		if(s2.hashCode() == s1.hashCode()) {
			System.out.println("s2=s3");
			
		}
		
	}

}
