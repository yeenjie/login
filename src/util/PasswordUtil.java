package util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class PasswordUtil {
    public static String md5(String src) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("MD5");
        byte[] output = md.digest(src.getBytes());
        String ret = Base64.getEncoder().encodeToString(output);
        return ret;
    }
}
