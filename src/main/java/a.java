class a {


    public static void main(String[] args) {

        String s = new String("hello");

        String t = new String("hello");

        char[] c = {'h', 'e', 'l', 'l', 'o'};
        System.out.println(t.equals(new String("hello")));
        System.out.println(t.equals(c));
        System.out.println(t == s);
        System.out.println(s.equals(t));
    }
}

