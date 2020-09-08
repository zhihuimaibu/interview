package exception;

public class test {
    public static void main(String[] args) {
        try {
            test();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static void test() throws Exception {
        throw new Exception("1123");
    }
}
