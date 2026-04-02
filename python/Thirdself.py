class Phone:
    def call(self):
        print("띠리링~ 전화를 겁니다.")

#1. 상속방법 : 괄호 안에 부모의 이름을 넣는다.
class Galaxy(Phone):
    # 2. 생성자 (__init__): 객체가 만들어질 때 실행되는 약속된 함수
    # self는 자바의 this와 같습니다. "나 자신"을 가리키죠.
    # self는 무조건 매개변수의 첫번째 자리에 써야한다. 호출할땐 안써도 된다.
    #def __init__(self, model="ready"): 이렇게 해두면 안들어 왔을때의 defalut값을 정해둘 수 있다.
    #대신 기본값이 정해진건 뒤로 다른 기본값이 없는 변수 뒤로 빼야한다.
    #아니면 model = None같은거로 정해두고 if model is None: model="ready" 이런식으로 하던지
    def __init__(self, model):
        self.model = model  # 객체 안에 model이라는 데이터를 저장합니다.
        self.tester = model+"aaaaaaaa"
    # 3. 전용 메소드
    def samsung_pay(self):
        print(f"[{self.model}] 삼성페이 결제를 시작합니다.")
        
    # 4. 매직 메소드 (__str__): print(객체)를 했을 때 보여줄 문자열 정의
    # 이게 없이 print문을 찍으면 이 클래스의 메모리 주소값이 나온다.
    def __str__(self):
        return f"이것은 갤럭시 {self.model}입니다. 이것은 갤럭시 {self.tester}입니다."
    
    # --- 실행 부분 ---
# 객체 생성 (new가 필요 없습니다!)
s24 = Galaxy("S24 Ultra")

# 부모에게 물려받은 기능
s24.call()

# 갤럭시만의 전용 기능
s24.samsung_pay()

# __str__ 매직 메소드 확인
print(s24)

class SmartPhone:

    #이렇게 __변수 해두면 phone.__price 이런식으로 직접 접근이 불가능함.
    #이게 접근제어(캡슐화)
    def __init__(self, price):
        self.__price = price  # 진짜 숨기고 싶은 변수

    def get_price(self):
        return self.__price

    def __str__(self):
        return f"값은 : {self.__price}"

phone = SmartPhone(10000)
 
print(phone.get_price())
print(phone._SmartPhone__price)

print(phone)


class Camera:
    def take_photo(self):
        print("찰칵! 사진을 찍습니다.")

class MusicPlayer:
    def play_music(self):
        print("🎵 음악을 재생합니다.")

# 다중상속
class SmartPhone(Camera, MusicPlayer):
    pass

my_p = SmartPhone()
my_p.take_photo() # Camera의 기능
my_p.play_music() # MusicPlayer의 기능


class Father:
    def hobby(self):
        print("낚시가 최고지!")

class Mother:
    def hobby(self):
        print("독서가 최고야!")

#같은 이름의 변수가 있으면 왼쪽이 먼저 왔으니 왼쪽기준으로 간다.
class Child(Mother, Father): # Mother가 왼쪽!
    pass

c = Child()
c.hobby() # 출력: 독서가 최고야! (왼쪽인 Mother 우선)
