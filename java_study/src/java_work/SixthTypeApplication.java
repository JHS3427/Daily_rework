package java_work;
import java.util.*;

public class SixthTypeApplication {

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Map<String, List<String>> phonemap = new HashMap<>();
		
		List<String> Apple = new ArrayList<>();
		List<String> SamSung = new ArrayList<>();
		Apple.add("아이폰 30");
		Apple.add("아이폰 300");
		SamSung.add("갤럭시 30");
		SamSung.add("갤럭시 3001");
		
		phonemap.put("애플", Apple);
		phonemap.put("삼성", SamSung);
		
		System.out.println("삼성 모델 : " + phonemap.get("삼성"));
		System.out.println("애플 모델 : " + phonemap.get("애플"));
		
		
		for(String i : phonemap.get("삼성"))
		{
			System.out.println(i);
		}
		
		Map<String,SmartPhone> SPs = new HashMap<>();

		SmartPhone SP1 = new SmartPhone();
		SP1.setPrice(1000000);
		SmartPhone SP2 = new SmartPhone();
		SP2.setPrice(3000000);
		SmartPhone SP3 = new SmartPhone();
		SP3.setPrice(5000000);
		
		List<SmartPhone> SPList = new ArrayList<>();//1번
		
		SPs.put("갤럭시A0", SP1);//2번
		SPs.put("갤럭시A5", SP2);
		SPs.put("갤럭시A10", SP3);
		
		Set<String> SPkeyset = SPs.keySet();
		
		for(String i : SPkeyset) {
			System.out.println(i);
			if(SPs.get(i).getPrice()>2000000)
			{
				System.out.println(i);
				System.out.println(SPs.get(i).getPrice());
			}
			
		}
		
	}
	
}

class SmartPhone {
    private int price;

    public void setPrice(int price) {//캡슐화 및 데이터 보호. 이상한 데이터가 들어오면 이걸 처리해서 저장하는 것.
        // 여기에 'new' 쓰지 말고, this와 매개변수만 사용해서 
        // 0보다 작으면 0으로 만드는 로직을 넣어보세요!
    	if(price<0)
    	{
    		price=0;
    	}
    	this.price=price;
    }
    public int getPrice() { // 값을 확인하기 위한 도구
    	return this.price;
    }
    // 모든 스마트폰의 공통 기능 (나중에 자식들이 재정의함)
    public void turnOn() {
        System.out.println("스마트폰의 전원을 켭니다.");
    }
}