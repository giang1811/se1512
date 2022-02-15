package utils;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Utils {

    public static DateFormat DATE_FORMATER = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public static String md5(String str) {
        String result = "";
        MessageDigest digest;
        try {
            digest = MessageDigest.getInstance("MD5");
            digest.update(str.getBytes());
            BigInteger bigInteger = new BigInteger(1, digest.digest());
            result = bigInteger.toString(16);
        } catch (NoSuchAlgorithmException e) {
        }
        return result;
    }

    public static int getDistanceTime(Date timeBegin, Date timeEnd) {
        if (timeEnd == null) {
            timeEnd = new Date();
        }
        long diffInMillies = Math.abs(timeEnd.getTime() - timeBegin.getTime());
        long diff = TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS);
        return (int) diff;
    }

    public static String getToday() {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date();
        return dateFormat.format(date);
    }
}
