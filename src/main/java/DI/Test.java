package DI;

public class Test {

    private DiTest diTest;
//    private T1 t1;

    public Test(DiTest diTest){
        this.diTest = diTest;
//        t1 = new T1();
    }

    public void show(){
        diTest.testPrint();
//        t1.t1print();
    }
}
