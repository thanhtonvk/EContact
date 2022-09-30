package com.utehy.econtact.Tools;

import android.graphics.Color;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Map;

public class Common {
    public static String BASE_URL = "http://117.4.121.197:6786/api/";
    public static String FACILITY_ID = "00000000-0000-8000-0000-000000000000";
    public static String TOKEN;
    public static Map<String, String> STUDENT_BY_FAMILY;
    public static Map<String, Object> LOGIN_USER;
    public static Map<String, String> HOCKI;

    public static int[] colors = new int[]{Color.CYAN, Color.DKGRAY, Color.BLUE, Color.GREEN, Color.RED, Color.YELLOW, Color.MAGENTA, Color.BLACK};

    public static String toMD5(String content) {
        try {
            // Static getInstance method is called with hashing MD5
            MessageDigest md = MessageDigest.getInstance("MD5");

            // digest() method is called to calculate message digest
            // of an input digest() return array of byte
            byte[] messageDigest = md.digest(content.getBytes());

            // Convert byte array into signum representation
            BigInteger no = new BigInteger(1, messageDigest);

            // Convert message digest into hex value
            String hashtext = no.toString(16);
            while (hashtext.length() < 32) {
                hashtext = "0" + hashtext;
            }
            return hashtext;
        }

        // For specifying wrong message digest algorithms
        catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

}
