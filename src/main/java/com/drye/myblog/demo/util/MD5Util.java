package com.drye.myblog.demo.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5Util {
    public static String generateMd5(String str){
        char[] hexDigits ={'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};
        StringBuffer stringBuffer=new StringBuffer();
        String retStr=null;
        try {
            MessageDigest md5=MessageDigest.getInstance("MD5");
            byte [] digest =md5.digest(str.getBytes());
            char[] retChar = new char[digest.length * 2];
            for(int i=0,k=0;i<digest.length;i++){
                byte _byte = digest[i];//256内数字值
                /*
                 * >>>无符号右移4位 也就是/2^2 除以4，拿到单个字节的低4位，在于 1111 1111 相与，就能得到了。
                 * eg: _byte = 164  二进制：1010 0100
                 * _byte >>>4 & 0xf = 0000 0100 & 1111 1111 = 0100 = 4 -->0x4
                 * _byte 在移动后为 _byte = 0000 1010 & 0xf = 1010 = 10 -->0xA 【高4位】
                 * 所以这个字节转为十六进制为： A4
                 */
                retChar[k++] = hexDigits[_byte >>> 4 & 0xf];
                retChar[k++] = hexDigits[_byte & 0xf];

            }
            retStr = new String(retChar);
            System.out.println("retStr>>: " + retStr+"长度"+retStr.length());
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return retStr;
    }
}
