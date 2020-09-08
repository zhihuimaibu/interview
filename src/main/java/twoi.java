public class twoi {

    public static void main(String[] args) {
        int j = 0;
        for (int i = 0; i < 100; i++) {
            //temp = j; j=j+1;j=temp
            j = j++;
        }
        System.out.println(j);
    }
}
