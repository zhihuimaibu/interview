public class onei {
    static {
        int x = 5;
    }

    static int x, y;

    public static void main(String[] args) {
        x--;
        myMethod();
        System.out.println(x + y++ + x); //1
    }

    private static void myMethod() {//x=-1 y=0
        y = x++ + ++x; // -1+0 +1
    }//x=1 y=0
}
