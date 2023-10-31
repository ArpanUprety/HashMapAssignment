public class Utilities {
    public static int parseInt(String s, int ifInvalid) {
        try {
            return Integer.parseInt(s);
        } catch (Exception e) {
            return ifInvalid;
        }
    }
}
