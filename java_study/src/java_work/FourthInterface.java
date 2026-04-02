package java_work;

public class FourthInterface {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Car brandnewcar = new Car();
		Person brandnewperson = new Person();
		brandnewcar.move();
		brandnewperson.move();
		
		Moveable[] units = new Moveable[2];
		units[0] = new Car();
		units[1] = new Person();
		
		for (Moveable M : units)
		{
			M.move();
		}
		
		ElectricCar EC = new ElectricCar();
		EC.move();
		EC.fuel();
	}

}

//인터페이스 - 설계도인데 가져다가 다른데서 채워야하는 설계도다.
//메소드 명만 선언해두고 이걸 받아쓰는 놈들은 따로 그 내용을 선언한다.
interface Moveable{
	void move();
}

class Car implements Moveable{
	@Override
	public void move() {
		System.out.println("바퀴로 움직인다");
	}
}

class Person implements Moveable{
	@Override
	public void move() {
		System.out.println("다리로 움직인다");
	}
}
//추상 클래스 - 이거 상속받으면 클래스 상속받듯이 있는 함수는 사용가능.
//단, abstract로 선언한건 interface처럼 반드시 자식이 다시 선언해야함.
//그리고 추상 클래스는 일반 클래스와 달리 WheelVehicle 변수명 = new WheelVehicle() 이거 안됨. 이거 막으려고 추상클래스 쓰는거.
//왜 막는가? 다같이 업무할 때, 일일히 전해도 꼭 쓰는놈들 막기 위해서 + fuel처럼 같은 이름에 다른 기능을 구현해야 할 수 있어서.
abstract class WheelVehicle implements Moveable {
	@Override
	public void move() {
		System.out.println("바퀴로 움직인다");
	}
	
	abstract void fuel();
}
// 3. 실제 구현 (클래스)
class ElectricCar extends WheelVehicle {
    @Override
    void fuel() {
        System.out.println("전기를 충전합니다.");
    }
}

// 상속도 받고 인터페이스 여러개 받는것도 가능

