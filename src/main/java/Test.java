public class Test {

    public static void main(String[] args) {
        for (int i = 0; i < 1000000; i++) {
            if (i < 1000) {
                System.out.println(i);
            } else if (i > 10000) {
                String iStr = String.valueOf(i);
                iStr = iStr.substring(iStr.length() - 4).trim();
                if (Integer.parseInt(iStr) <= 1000) {
                    System.out.println(iStr);
                }
            }
        }
    }

}
