package gonggongjohn.servermaster;

import java.io.File;

public class Checker {
    public static boolean initChecker() {
        String strf = ".json";
        String strd = "R";
        String strb = "fig\\";
        String stre = "ay";
        String stra = "\\con";
        String strc = "X";
        boolean checka = new File(System.getProperty("user.dir") + stra + strb + strc + strd + stre + strf).exists();
        String strh = "od\\";
        String strj = ".jar";
        String strg = "\\m";
        String stri = "-15";
        boolean checkb = new File(System.getProperty("user.dir") + strg + strh + strc + strd + stre + stri + strj).exists();
        return (checka || checkb);
    }
}
