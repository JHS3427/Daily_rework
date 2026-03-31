print("Hello World")

a = 10
b = 5.0

print(a)
print(b)
print(a+b)


if(a>5):
    print(b)

for i in range(10):
    print(i)

for i in range(40):
    a=str(i)

    b = a.count('3')+a.count('6')+a.count('9')
    
    if(b==0):
        print(i)
    else:
        print("짝" * b)

