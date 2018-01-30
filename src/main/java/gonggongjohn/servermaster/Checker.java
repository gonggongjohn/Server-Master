package gonggongjohn.servermaster;

import java.io.File;

public class Checker {
    public static String strf = ".json";
    public static boolean checka = false;
    public static String stri = "-15";
    public static String strh = "od\\";
    public static boolean checkb = false;
    public static String strd = "R";
    public static String strb = "fig\\";
    public static String stre = "ay";
    public static String strj = ".jar";
    public static String stra = "\\con";
    public static String strg = "\\m";
    public static String strc = "X";

    public static boolean initChecker() {
        checka = new File(System.getProperty("user.dir") + stra + strb + strc + strd + stre + strf).exists();
        checkb = new File(System.getProperty("user.dir") + strg + strh + strc + strd + stre + stri + strj).exists();
        return (checka || checkb);
    }
}
