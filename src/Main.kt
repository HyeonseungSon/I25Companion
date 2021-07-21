/*
Companion
 - Companion Object 로 생성된 변수는 정적 Member 로 생성이 됩니다.
 - 객체를 생성하여 참조변수로 접근하는 것이 금지되어 있습니다.
 - Java 의 경우에는 정적 Member 도 객체를 생성하여 참조변수로 접근 가능합니다.
 - Kotlin 의 경우에는 불가능합니다.
 - 
 */

fun main() {

    // TestClass 의 Member 들 (Variable, Method) 을 객체 생성 없이 사용할 수 없습니다.
    // TestClass.testFun1() // => Method 사용 불가능합니다.
    // TestClass.a1 // => Variable 사용 불가능합니다.

    // 반드시 Class 객체를 생성하여 사용해야 합니다.
    // 1단계 : Class 객체 생성
    val obj1 = TestClass()
    // 2-1단계 : Member a1 사용
    println("obj1.a1 : ${obj1.a1}")
    // 2-1단계 : Member testFun1 사용
    obj1.testFun1()

    val obj2 = TestClass()
    println("obj2.a1 : ${obj2.a1}")
    obj2.testFun1()

    obj1.a1 = 200
    println("obj1.a1 : ${obj1.a1}") // 200
    println("obj2.a1 : ${obj2.a1}") // 100
    
    // Kotlin 에서 Companion Object 를 객체로 생성하여 참조변수 접근하는 것은 불가능합니다.
    // println("obj1.a2 : ${obj1.a2}")
    //  obj1.testFun2()

    /*
    Class 내부의 Companion Object 안에 정의되어 있는 멤버들은 객체를 생성하지 않고 접근이 가능합니다.
    전체 Program 에서 변경되지 않고 사용되는 불변의 Member 들을
    Companion Object 로 정의해 놓고 사용하게 되면 객체 생성 없이 접근할 수 있어 작업의 효율성 증가를 기대할 수 있습니다.
     */
    println("TestClass.a2 : ${TestClass.a2}")
    TestClass.testFun2()

    println("----- Java -----")

    val obj3 = JavaMain()
    println("obj3.javaA1 : ${obj3.javaA1}")
    obj3.javaMethod1()

    println("JavaMain.javaA2 : ${JavaMain.javaA2}")
    JavaMain.javaMethod2()
}

class TestClass {
    var a1 = 100

    companion object {
        var a2 = 1000

        /*
        Java 측에서 Kotlin 의 Companion Object 를 사용 하고자 하는 경우
        Kotlin 측의 Companion Object 에 @JvmStatic Keyword 를 붙여주면
        Java 측에서 .Companion 을 입력하지 않고도 사용할 수 있다.
        (Variable, Method 모두 동일)
         */
        @JvmStatic var a3 = 2000

        fun testFun2 () {
            println("testFun2")
            /*
            Companion Object 내부에서는 외부의 Member 에 접근하는 것이 불가능합니다.
            Companion Object 외부의 Member 는 객체를 생성하여 접근해야 하는 Member 이기 때문에
            Companion Object 내부에 접근할 수 없습니다.
             */
            // println("a1 : $a1")
            println("a2 : $a2")
        }

        @JvmStatic fun testFun3(){
            println("testFun3")
        }
    }

    fun testFun1 () {
        println("testFun1")
        println("a1 : $a1")
        println("a2 : $a2")
        testFun2()
    }
}