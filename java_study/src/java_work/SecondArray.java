package java_work;

public class SecondArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SecondArray SA = new SecondArray();//같은 클래스 내에 있지만 static이 안붙어 있는걸 써야해서 일단 선언한다.
		
		
		int[] score = {90,100,50,10};
		String a = "abcdefghj";
		System.out.println("첫번쨰 점수 : "+score[0]);

		System.out.println("전체 점수 : ");
		for(int i=0;i<score.length;i++) //배열에는 length는 괄호없이 그냥 쓴다. 단, String은 str.length()가 맞다.
		{
			System.out.println(score[i]);
		}
		for(int j=0;j<a.length();j++)
		{
			System.out.println(a.charAt(j));
		}
		int result1 = add(score[2],20);
		System.out.println("result1 : "+result1);
		int result2 = SA.multiple(score[1],3);//같은 클래스 내에 있지만 static이 안붙어 있으니 위에서 선언한거에서 갖다 쓴다
		System.out.println("result2 : "+result2);
		
		int result3 =sumall(score);
		System.out.println("result3 : "+result3);
	}
	
	public static int add(int a, int b) {
		return a+b;
	}
	
	public int multiple(int a, int b) {
		return a*b;
	}
	
	public static int sumall(int[] array) {
		int sumtarget=0;
		for(int s : array)
		{
			sumtarget=add(sumtarget,s);
		}
		return sumtarget;
	}
	
}
