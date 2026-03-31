#같은 폴더에 있는 파이썬은 아래처럼 import 가능. 단, 해당 파이썬 파일에 __main__이런거 안해놔서 전부 다 가져옴
from secondday import add
import math
import random
print(add(5,100))

print(f"랜덤숫자:{random.randint(1,100)}")
