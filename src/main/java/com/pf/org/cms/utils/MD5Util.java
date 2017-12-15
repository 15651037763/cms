package com.pf.org.cms.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @Auther: pf
 * @Date: 2017/12/14 16:38
 * @Description:
 */
public class MD5Util {
    private static final Logger log = LoggerFactory.getLogger(MD5Util.class);

    private static MessageDigest md = null;

    static {
        try {
            md = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            log.error("MD5 GetInstance :" + e);
        }
    }

    /**
     * MD5 加密
     * @param msg
     * @return String
     */
    public static final String getMD5(String msg) {
        if (msg == null) {
            return "";
        }

        md.update(msg.getBytes());
        byte[] b = md.digest();

        StringBuffer sb = new StringBuffer(32);
        int i = 0;
        for (int offset = 0, len = b.length; offset < len; offset++) {
            i = b[offset];
            if (i < 0) {
                i += 256;
            }
            if (i < 16) {
                sb.append("0");
            }
            sb.append(Integer.toHexString(i));
        }
        return sb.toString();
    }

    /**
     * 加密用户密码（加盐方式）
     * @param userCode
     * @param userPwd
     * @return String
     */
    public static final String encryptPwd(String userCode, String userPwd) {
        String s = new StringBuffer(userCode).append("@W2w").append(userPwd).toString();
        return getMD5(s);
    }
}
