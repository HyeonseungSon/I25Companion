public class JavaMain {

    public int javaA1 = 100;

    public static int javaA2 = 200;

    public void javaMethod1(){
        System.out.println("javaMethod1");
    }

    public static void javaMethod2(){
        System.out.println("javaMethod2");
    }

    public static void main(String [] args){

        TestClass t1 = new TestClass();
        System.out.printf("t1.a1 : %d\n", t1.getA1());
        t1.testFun1();

        // Java 에서 Kotlin 의 Companion Object 를 호출하고 싶은 경우에는 Object 앞에 .Companion 을 붙여주면 됩니다.
        System.out.printf("TestClass.a2 : %d\n", TestClass.Companion.getA2());
        TestClass.Companion.testFun2();

        /*
        Kotlin 측에서 개발자가 @JvmStatic Keyword 를 사용하여 구현해 놓았기 때문에
        위의 경우와는 다르게 .Companion Keyword 를 사용하지 않고도 Kotlin 측의 Companion Object 호출이 가능합니다.
         */
        System.out.printf("TestClass.a3 : %d\n", TestClass.getA3());
        TestClass.testFun3();

    }
}
