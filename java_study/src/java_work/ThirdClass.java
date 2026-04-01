package java_work;

public class ThirdClass {

	UpperBrother ub = new UpperBrother();
	// 메인이 static 이라 ThirdClass를 바깥에서 선언해버리면 ThirdClass를 static 에서 찾는데, 아직 ThirdClass는 만들어지지 않는 에러가 생긴다. 
	private int age=1000;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ThirdClass TC = new ThirdClass();
		System.out.println(TC.age);
		TC.age=10;//현재 선언한 TC의 age 변수 변경
		TC.setAge(-5);//선언한 TC의 setAge에 변수 전달.
		
		
		IPhone myPhone = new IPhone();
		myPhone.showModel();//상속안받은거.
		myPhone.setPrice(-500);//상속 받은거 사용1
		System.out.println(myPhone.getPrice());//상속 받은거 사용2;
		
		//이거는 핸드폰이 들어갈 칸만 만들어둔거지 핸드폰을 넣은게 아니다.
		//따라서 new SmartPhone[3];으로 하고 돌리면 다음 반복문에서 3번째칸(myBag[2])가 null이라 비어있다고 에러가 뜰꺼다.
		SmartPhone[] myBag = new SmartPhone[2];
        myBag[0] = new IPhone(); // 업캐스팅 (자동) - 자식 객체를 부모 타입 변수에 담는것.
        myBag[1] = new Galaxy(); // 업캐스팅 (자동)
        
        System.out.println("=== 1단계: 공통 기능 실행 (다형성) ===");
        for (SmartPhone p : myBag) {
            // p가 아이폰인지 갤럭시인지 몰라도 '스마트폰'이니까 turnOn은 무조건 있습니다.
            // 하지만 실행 결과는 각자(아이폰/갤럭시)의 방식으로 나옵니다!
        	
        	//이렇게 되면 부모의 turnOn이 아니라 각 자식의 turnon이 켜진다.
        	//이를 동적바인딩 이라고 한다.
            p.turnOn();
        }
        
        System.out.println("\n=== 2단계: 특수 기능 실행 (형변환) ===");
        for (SmartPhone p : myBag) {
            // p.airDrop(); // ❌ 에러! SmartPhone 이름표로는 아이폰 전용 기능을 못 찾음.
            // instanceof 이거 뜻 : 이 객체가 오른쪽으로 만들어진게 맞는지 확인해라.
            if (p instanceof IPhone) {
                // "너 아이폰인 거 다 알아!" 하고 형변환(Casting)
                IPhone tempIp = (IPhone) p; 
                tempIp.airDrop();
            } 
            else if (p instanceof Galaxy) {
                // "너는 갤럭시구나!" 하고 형변환(Casting)
                Galaxy tempGa = (Galaxy) p;
                tempGa.samsungPay();
            }
        }
	}
	
	public void setAge(int age) {

		ThirdClass TC = new ThirdClass();//메인에서 선언 했지만 여기선 선언 안해서 쓰려면 다시 선언해야함.
		if(age<0)
		{
			//여기서도 int age 선언이 불가능하다.
			System.out.println("0살 이하는 없다 이새끼야.");
			System.out.println(ub.age);
			//return;
		}
		System.out.println("this.age"+this.age);//메인에서 선언한 TC가 가리키는 곳에 있는 ThirdClass에 저장된 age값을 가져옴
		this.age=age;

		System.out.println("바깥에서 들어온 나이"+age);//매개변수로 들어온 값
		System.out.println("바깥에 설정된 나이"+TC.age);//setAge메소드에서 선언한 새로운 TC(main에서 가리키는곳이랑 다름)에서 값을 가져와서 1000을 가져옴.
		//여기서는 int age 선언을 못한다 - 변수로 age를 받았기 떄문임.
	}

}
//public 클래스는 한 파일당 하나만 있어야 하니까 얘는 그냥 클래스로 써야한다.
class UpperBrother{
	int age = 100;
}

//부모-자식 클래스 특징 - 다형성 - 여러 자식이 같은 기능을 수행해야 하는 경우 일단 부모로 선언(부모클래스 변수 = new 자식클래스)해서 반복문 돌리고,
//이후에 자식들 개별적으로 할 일 있으면 ( 자식클래스 새변수 = (자식클래스)기존변수 ) 이런식으로 쓴다.
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

// 자식 클래스 (상속) - 사용이유 : 1. 코드 재사용 // 2. 체계화(자식은 부모로 부터 나온다) // 3. 기능의 확장.
class IPhone extends SmartPhone {
    // 부모 기능을 물려받음
	public void showModel() {
        System.out.println("이것은 아이폰입니다.");
    }
	public void airDrop() {
        System.out.println("아이폰 전용 기능: 에어드랍을 시도합니다.");
    }
	//Override - 부모에게 있는 기능을 자식이 바꿔서 쓸 때 붙임. 부모에 없는데 이걸쓰면 에러로 걸림. 즉 오탈자 검수하기 좋음.
	@Override
    public void turnOn() {
        System.out.println("🍎 아이폰이 사과 로고와 함께 켜집니다.");
    }
}
//3. 자식 클래스 2: 갤럭시 (다형성 확인을 위해 추가)
class Galaxy extends SmartPhone {
 @Override
 public void turnOn() {
     System.out.println("🌌 갤럭시가 삼성 로고와 함께 켜집니다.");
 }

 public void samsungPay() {
     System.out.println("갤럭시 전용 기능: 삼성페이 결제를 시작합니다.");
 }
}