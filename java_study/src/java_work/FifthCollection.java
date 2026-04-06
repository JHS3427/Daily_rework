package java_work;
import java.util.ArrayList; // 1. 도구 가져오기
import java.util.List;
import java.util.HashMap;
import java.util.Map;
import java.util.HashSet;
import java.util.Set;
import java.io.*;


public class FifthCollection {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 인터페이스(List) 타입으로 선언하고 실제 구현체(ArrayList)를 생성
		 // 이렇게 선언하면 fastFood는 List타입이고, 함수도 List에서 선언한것만 쓸 수 있다.
		//다만 instanceof 로 비교할때 true값이 나오려면 ArrayList를 비교해야 true다.
        List<String> fastFood = new ArrayList<>();

        // 1. 데이터 추가 (add)
        fastFood.add("햄버거");
        fastFood.add("피자");
        fastFood.add("치킨");
        fastFood.add("피자");
        fastFood.add("햄버거"); // 중복 허용!
        fastFood.add("치킨");

        // 2. 데이터 꺼내기 (get) - 인덱스는 0부터 시작
        System.out.println("0번 메뉴: " + fastFood.get(0));

        // 3. 데이터 삭제 (remove)
        fastFood.remove("햄버거"); // 값으로 삭제 가능 - 단 앞에 하나만 삭제함.
        fastFood.remove(2);     // 인덱스로 삭제 가능

        // 4. 전체 출력 및 크기 확인
        System.out.println("현재 남은 메뉴: " + fastFood);
        System.out.println("메뉴 개수: " + fastFood.size());
        
        
        // 인터페이스(Map) 타입으로 선언, 구현체(HashMap) 생성
        // <Key타입, Value타입>을 정해줍니다.
        // 타입 정하는거 빼면 파이썬 딕셔너리랑 비슷.
        Map<String, String> dictionary = new HashMap<>();

        // 1. 데이터 넣기 (put)
        dictionary.put("Java", "자바");
        dictionary.put("Python", "파이썬");
        dictionary.put("Spring", "스프링");

        // 2. 데이터 가져오기 (get)
        System.out.println("Java의 뜻: " + dictionary.get("Java"));

        // 3. 없는 키를 찾으면? null이 나옵니다.
        System.out.println("C++의 뜻: " + dictionary.get("C++"));

        // 4. 데이터 삭제
        dictionary.remove("Python");
        System.out.println("전체 사전: " + dictionary);
        
        
        Set<String> users = new HashSet<>();

        users.add("홍길동");
        users.add("임꺽정");
        users.add("홍길동"); // 중복! 들어가지 않습니다.

        System.out.println("사용자 명단: " + users); // [홍길동, 임꺽정]
        System.out.println("등록된 인원: " + users.size()); // 2명
        
                
     // ❌ 아래 코드는 빨간 줄(에러)이 떠서 실행조차 안 됩니다.
        // FileReader fr = new FileReader("test.txt");

        // ✅ 반드시 이렇게 '보험'을 들어야 자바가 허락해줍니다.
        try {
            FileReader fr = new FileReader("test.txt"); 
            System.out.println("파일을 찾았습니다!");
        } catch (FileNotFoundException e) {
            // 파일이 없을 때 실행될 '플랜 B'
            System.out.println("파일이 없네요. 경로를 확인하거나 파일을 생성하세요.");
        }
        
        
	}
	//throw는 해당위치에서 예외를 발생시키고, throws는 발생한 예외를 자신을 호출한 곳에서 예외로 던진다.
	//즉 아래의 함수가 에러가 발생하면 이걸 불러온 try-catch에서 에러로 판독하여 catch로 간다.
	//만약 이 함수 안에 try catch가 있고, 거기서 throw로 예외를 부르면 이 함수 안의 try-catch에서 catch가 작동하지만, 이 함수를 호출하는 try-catch는 정상작동한다. 
	public void myFileMethod() throws FileNotFoundException {
	    FileReader fr = new FileReader("test.txt"); 
	}
}
