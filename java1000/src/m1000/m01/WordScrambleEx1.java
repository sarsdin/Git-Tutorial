package m1000.m01;

import java.util.Scanner;

public class WordScrambleEx1 {
	public static int ss = 0;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
//		String[] strArr = {"CHANGE","LOVE","HOPE","VIEW"};
		String[] wordArr2 = new String[50];
		
		while(true) {
			for(int i=0; i<wordArr2.length; i++) {
				System.out.print("몇 개의 단어를 입력하시겠습니까? ");
				int wEa = sc.nextInt();
				if(i >= wEa) {
					System.out.print("그만 추가?[y/n] ");
					if(sc.next().equals("y")||sc.next().equals("Y")) {
						break;
					}
				}
				System.out.printf("%d번 단어 입력 gogo: ",i+1);
				wordArr2[i] = sc.next();
			}
			
			
			String answer = getAnswer(wordArr2);
			String question = getScrambledWord(answer);
		
			System.out.println("q를 입력하면 종료합니다.");
			System.out.println("Question:"+question);
			
			do {
				System.out.println("Your Answer is : ");
				String ans = sc.next();
				if(ans.toUpperCase().equals("Q")) {
					System.out.println("Program Exit");
					return;
				} else if(ans.equals(answer)) {
					System.out.println("정답!!");
					break;
				}
			} while(true);
			System.out.println("Program exit?? ");
			if( Character.toUpperCase(sc.next().charAt(0)) == 'Y') {
				return;
			}
		}
		
		
	}
	public static String getAnswer(String[] wordArr2) { //배열요소 중 임의로 반환
		System.out.println("임의의 단어 생성완료!");
		int cnt = 0;
		for(int i=0; i<wordArr2.length; i++) { //배열안에  몇번째 인덱스까지 값이 들어있는지 확인. 고로 배열의 실제크기를 알 수 있다. 
			if(wordArr2[i] == null) {
				break;
			}
			cnt++;							//cnt가 6번째에 밑의 if문이 null로 중단되면 배열의 실제 크기는 6개(0~5번인덱스까지)
		}
		System.out.println("cnt is: "+cnt);
		int rn = (int)(Math.random()*cnt);
		String rst = wordArr2[rn];  //랜덤리턴할 String 
//		System.out.println("test1");
		return rst;
	}
	
	public static String getScrambledWord(String answer) { //단어 섞기
//		System.out.println("str is: "+str);
//		System.out.println(str.length());
		int[] rd = new int[answer.length()];
		for(int i=0; i<rd.length; i++) {
			int rn = (int)(Math.random()*answer.length());
			rd[i] = rn;
//			chrto[i] = chr[rd[i]]; //이렇게 밑의 for문과 합칠 수도 있지만, 가독성을 위해 쪼개자..!
			for(int j=0; j<i; j++) {
				if(rd[i]==rd[j]) {	//str단어의 길이만큼인 중복제거된 인덱스 랜덤값 배열인 rn을 생성
					i--;
					break;
				}
			}
		}
		char[] chr = answer.toCharArray();
		char[] chrto = new char[answer.length()];
		for(int i=0; i<chr.length; i++) {
			chrto[i] = chr[rd[i]];		//중복제거된 랜덤숫자를 담고있는 int배열인 rd를 인덱스삼은   
		}						//chr배열을 i순서대로 배열이 길이만큼 새배열인 chrto로 넣으면 랜덤으로 문자가 들어간다.
		String rt = String.copyValueOf(chrto); //배열내용을 문자열로 전환.
		return rt;
		
		/*char[] chr = str.toCharArray();	
		for(int i=0; i<str.length(); i++) {
			int inx = (int)Math.random()*str.length();
			
			char temp = chr[i];				//str길이만큼 동안 계속 i번째 배열을 기준으로 랜덤이 나온숫자(inx)만큼 계속 배열의 값들을 교환한다. 계속...또 계속~!!!
			chr[i] = chr[inx];				//결국, chr안의 각 배열방안의 값들이 서로 랜덤하게 이동하기 때문에 섞인다. 
			chr[inx] = temp;				//중간에 같은 인덱스(i=3일때 inx도 3이나올때)가 될때는 값은 이동하지만 같은 값이므로 변경된게 아닌 결과가 도출된다. 
		}
		return String.valueOf(chr).toString();
		*/
	}
	
	
	
}
