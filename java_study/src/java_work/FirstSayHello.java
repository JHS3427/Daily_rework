package java_work;

public class FirstSayHello {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Hello2");
		int a = 10;
		System.out.println(a);
		double b = 1000;
		System.out.println(b);
		System.out.println(a+b);
		boolean c = true;
		boolean d = false;
		if(c)
		{
			System.out.println("T");
		}
		if(c&&d)
		{
			System.out.println("F");
		}
		if(c||d)
		{
			System.out.println("F");
		}
		for(int i=0;i<10;i++)
		{
			System.out.println(i);
		}
		//369게임 - 1~20
		for (int i = 1; i <= 20; i++)
		{
            if(i%3==0&&i<10)
            {
    			System.out.println("짝");
            }
            else if(i%3==1&&i>10)
            {
    			System.out.println("짝");
            }
            else
            {
    			System.out.println(i);
            }
        }
		//369게임 내 생각 - String str = String.valueOf(i); 이거로 배열로 바꿔서 할 수 있다.
		for (int i = 1; i <= 40; i++)
		{
			int palusenum=0;
			String numstr = String.valueOf(i);
			for(int j=0;j<numstr.length();j++)
			{
    			//System.out.println(numstr[j]); - numstr[j] 이부분은 c언어에서나 하는거고 자바는 다름.
				char onenum = numstr.charAt(j);
    			if(onenum=='3'||onenum=='6'||onenum=='9') // char은 비교할때 ''로 비교해야한다.
    			{
    				palusenum+=1;
    			}
			}
			if(palusenum==0)
			{
				System.out.println(i);
			}
			else
			{
				for(int k=0;k<palusenum;k++)
				{
					System.out.print("짝");
				}
			}
		}
		
	}

}
