#함수
def add(a,b):
    return a+b

def greet(name="방문자"):
    print(f"안녕하세요, {name}님!")


result = add(10,10);
print(result)

greet("asdf")


#딕셔너리 생성
user_info = {"name":"잼민이","age":32,"job":"엔지니어"}
print(user_info["name"])

user_info["location"]="서울"#데이터 추가
user_info["age"]="132"#데이터 변경

print(user_info)

del user_info["job"] #데이터 삭제
print(user_info)

users=[{"name":"철","score":"100"},{"name":"영","score":"80"}]
print(users[0]["name"])
