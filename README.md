## [CodeSquad Cocoa](https://github.com/honeySleepr/CodeSquad/wiki/CodeSquad-Cocoa) ##
***
###11/11(목)

변수 선언시 final 붙이는건 상수(constant)라는 뜻 - 상수는 전부 대문자로 표기하는게 일반적
```
switch (ch) {

    case 'a':
    case 'u':
        System.out.println("소문자 모음.");
        break;   ///// 얘 지우면 ch = a 더라도 아래 "대문자 모음" 도 같이 인쇄됨
    
case 'A':
    case 'E':
        System.out.println(" 대문자 모음.");
        break;

    default:
        System.out.println("모음이 아닙니다.");
        break;
}
```
- 위처럼 여러개의 case 절을 사용할 수도 있음. 입력값에 해당되는 case가 없으면 default 실행
- break; 붙여주지 않으면 switch 문 밖으로 빠져나오지 않고 그 아래 case 도 실행

```
do{
//명령//
} while(j<10)
```
- 일단은 명령이 한번 실행 되고나서 while 문을 돌리는 형태

```
allLoop :
        for (int i = 2; i < 10; i++) {
            for (int j = 2; j < 10; j++) {
                if (i == 5) {
                    break allLoop;
                }
                System.out.println(i + " * " + j + " = " + (i * j));
            }
        }
```
- break; 는 원래 하나의 반복문만 빠져나오는데, 이렇게 label을 붙여 주고 빠져 나오고자 하는 반복문 바로 앞에 label을 달아주면 break 를 만났을때 여러 반복문을 한번에 빠져나올 수 있다.


메소드 영역 (낮은 주소) : 클래스에 대한 정보와 클래스 변수가 저장되는 영역
힙 영역 : new 키워드를 사용했을 때 생기는 인스턴스 변수가 저장되는 영역. 낮은 주소에서 -> 높은 주소 방향으로 할당됨
스탭 영역 (높은 주소) :  메소드가 호출될 때 메소드의 스택 프레임이 저장되는 영역. 메소드와 관련된 지역변수와 매개변수가 저장된다. 메소드의 호출이 완료되면 소멸한다. 높은 주소 -> 낮은 주소 방향으로 할당된다.

### 11/12 (금)  
배열도 객체다  
타입[] 배열이름 = new 타입[배열길이]  
타입[] 배열이름 = new 타입[]{"요소1","요소2" ..}  
Arrays.toString() : 배열을 [요소1, 요소2, ...] 형태의 문자열로 만들어준다  
Arrays.copyOf(arr1, newLength) : 배열(arr1)을 복사하여 newLength 의 크기를 가진 배열에 앞에서부터 붙여넣는다  
Enhance for 문( for(String e : arr) ) 에서 배열 요소 e 는 실제 배열의 복사본이기 때문에 e의 값을 변경하여도 원본 배열값에는 영향을 주지 않는다. 그러므로 이 경우에는 일반 for문을 사용해야한다.  

클래스의 예
클래스(class)
- 차(Car) : 설계도

필드(field)
- car.modelName = "람보르기니"
- car.modelYear = 2016
- car.color = "주황색"
- car.maxSpeed = 350

메소드(method)
- car.accelerate()
- car.brake()

인스턴스(instance)
- 내 차(myCar) : 설계도에 의해 생산된 차량
- 친구 차(friendCar) : 설계도에 의해 생산된 또 다른 차량


즉, 자동차 인스턴스는 모두 위와 같은 필드와 메소드를 가지게 될 것입니다.
하지만 각 인스턴스마다 가지고 있는 프로퍼티의 값은 전부 다를 것입니다.(??)

```
class Car {
    static int modelOutput; // 클래스 변수
    String modelName;       // 인스턴스 변수

    void method() {
        int something = 10; // 지역 변수
    }
}
```
클래스변수와 인스턴스 변수는 자동으로 초기화됨. 지역 변수(메소드에 생성)는 직접 초기화 해줘야함

인스턴스 변수는 인스턴스 마다 값이 달라질 수 있다.

클래스 변수는 Car.modelOutput 으로 불러오든, car1 이라는 인스턴스를 만들어 car1.modelOutput으로 불러오든 모두 같은 값을 공유한다. (다만 후자의 경우 Static 변수를 인스턴스로 참조할 필요 없다며 밑줄이 생긴다)