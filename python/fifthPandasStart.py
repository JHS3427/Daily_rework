import pandas as pd
import numpy as np

# 1. NumPy 배열을 이용해 데이터 만들기
# 0부터 11까지 3행 4열의 행렬 생성
# arrange(변수1,변수2,변수3) 1개만 있으면 그게 변수 2임. 변수 2까지 1씩 증가함.
# 변수가 2개 있으면 1,2번임. 1번에서 시작해서 2번까지 1씩 증가하는 배열 생성
# 변수 3개 있으면 1에서 2까지 3번만큼의 간격으로 증가
data = np.arange(12).reshape(3, 4)
data2 = np.arange(10,100,5)
print(data)
print(data2)

# 2. 이 NumPy 배열을 Pandas DataFrame으로 변환
df = pd.DataFrame(data, columns=['A', 'B', 'C', 'D'])

print("--- 생성된 데이터프레임 ---")
print(df)

# 3. 특정 열만 선택해서 NumPy 연산 적용해보기
print("\n--- 'A'열에만 100을 더하기 (벡터화 연산) ---")
print(df['A'] + 100)

#np.random.randn - 0~1사이의 무작위 숫자를 변수 개수만큼 생성
#만약 np.random.randn(5,3) 이런식이면 15개를 5행 3열로 뽑아
newdata = np.random.randn(15).reshape(5,3)
print(newdata)

df2 = pd.DataFrame(newdata,columns=['가','나','다'])

print(df2.head(3))

print(df2.describe()) # 이거로 평균,표준편차,최대,최소,갯수를 볼 수 있다.


#iloc 는 Integer locattion. 즉 숫자로 위치찾기 - df.iloc[1,2] 이런식
#iloc로 짝수행만 출력하려면 df.iloc[::2,:] 이렇게 하면 된다.
#loc는 그냥 location. 사람이 부르는 행이나 열의 이름으로 찾는거다.
#print(df2.iloc[[1,3],[0,2]]) 이런식으로 2,4행 가,다 열만 뽑아서 쓸수 있다.
print(df2['가'])
print(df2.iloc[0]) #첫번째 행 선택
print(df2.iloc[:,2])#3번째 컬럼 선
print("짝수행")
print(df2.iloc[::2])
print(df2.loc[0,'나']) #첫번째 행의 나열 값
print(df2.iloc[0]) #첫번째 행 선택
print("문제")
print(df2.iloc[1,2])
print(df2.loc[1,"다"])
print(df2.iloc[[1,3],[0,2]])

print("테스트")
condition=df2['가']>0
print(df2[condition])


print("문제2")
condi2=df2['나']<0
print(df2[condi2])

