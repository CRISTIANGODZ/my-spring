package ioc.util;

/**
 * @author DyingZhang
 * @date 2023-10-12 下午 5:14
 * @discription
 */
public class StringUtils {

    public static String toCamelPattern(String str) {
        char ch = str.charAt(0);
        if (ch >= 65 && ch <= 90) {
            ch += 32;
        }
        return String.valueOf(ch).concat(str.substring(1));
    }
}
