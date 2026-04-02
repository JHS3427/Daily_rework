#추상 클래스를 만들기 위한 라이브러리 임포트.
from abc import ABC, abstractmethod

class BaseBot(ABC):
    @abstractmethod
    def work(self):
        pass # 자식들이 알아서 다 만들어라!

class WebBot:
    def __init__(self, url):
        self._url = url

 # 추가로 bot.url = "https://google.com" 이짓하면 setter를 부르는거다.
 # 즉, setter가 없는 상태에서 bot.url = "aaaa" 이거로 _url값을 바꾸는게 불가능하다.
 # 에러 발생: AttributeError: can't set attribute 'url'
    @property
    def url(self):
        return self._url

    @url.setter
    def url(self, value):
        print(123)
        # 여기서 유효성 검사!
        if not value.startswith("http"):
            raise ValueError("유효한 URL 형식이 아닙니다.")
        
        # 조건에 맞게 가공해서 저장
        if not value.endswith("/"):
            self._url = value + "/"
        else:
            self._url = value

# 사용하는 쪽은 이전과 똑같이 씁니다.
bot = WebBot("https://naver.com")
print(bot.url)

#괴상하지만 이게 setter함수를 부른다. 이유 : 보기 직관적이라
#추가로 튜플 - 소괄호로 묶는 그거 - 로 묶어서 보내던지 그냥 다른 일반 메서드로 전달하는 경우도 있다.
bot.url = "https://google.com" # 자동으로 뒤에 '/'가 붙어서 저장됨


print(bot.url)
