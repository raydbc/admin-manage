package org.dbc.admin.utils;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.binary.Hex;
import org.apache.commons.lang3.StringUtils;

import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;

/**
 * @Author: ray, liu.
 * @Date: 2018/10/9 21:35
 */
@Slf4j
public class CryptAESUtils {
    private static CryptAESUtils instance;
    private static byte[] lock = new byte[0];

    private static final String AES = "AES";
    private static final String UTF8 = "UTF-8";
    private static final String cipherInstanceMode = "AES/ECB/PKCS5Padding";
    private static String privateKey = "2e79b275dad71e9c8ebab20873e684be";
    private static Cipher encryptCipher;//加密cipher
    private static Cipher decryptCipher;//解密chipher


    private CryptAESUtils() {
        try {
            //1.获得原始对称密钥的字节数组
            byte[] encodeFormat = Hex.decodeHex(privateKey.toCharArray());
            // 2.根据字节数组生成AES密钥
            SecretKey key = new SecretKeySpec(encodeFormat, AES);

            // 加密
            // 3.根据指定算法AES/ECB/PKCS5Padding自成密码器
            encryptCipher = Cipher.getInstance(cipherInstanceMode);
            // 4.初始化密码器，第一个参数为加密(Encrypt_mode)操作，第二个参数为使用的KEY
            encryptCipher.init(Cipher.ENCRYPT_MODE, key);

            // 解密
            // 5.根据指定算法AES/ECB/PKCS5Padding自成密码器
            decryptCipher = Cipher.getInstance(cipherInstanceMode);
            //6.初始化密码器，第一个参数为解密(Decrypt_mode)操作，第二个参数为使用的KEY
            decryptCipher.init(Cipher.DECRYPT_MODE, key);
        } catch (DecoderException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (NoSuchPaddingException e) {
            e.printStackTrace();
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static CryptAESUtils getInstance() {
        if (instance == null) {
            synchronized (lock) {
                instance = new CryptAESUtils();
            }
        }
        return instance;
    }

    /**
     * Aes加密
     *
     * @param context 明文
     * @return
     * @throws Exception
     */
    public static String encryption(String context) {
        try {
            if (StringUtils.isEmpty(context.trim())) return null;
            //加密后的明文也就变成了密文
            byte[] encryptResult = encryptCipher.doFinal(context.trim().getBytes(UTF8));
            //密码文Hex编码
            if(null == encryptResult) return null;
            return Hex.encodeHexString(encryptResult);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (IllegalBlockSizeException e) {
            e.printStackTrace();
        } catch (BadPaddingException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Aes解密
     *
     * @param context 密文
     * @return
     * @throws Exception
     * @throws UnsupportedEncodingException
     */
    public static String decryption(String context) {
        try {
            if (StringUtils.isEmpty(context.trim())) return null;
            if (context.indexOf("@") > -1) return context.trim();
            //这里的密文解密前先进行了Hex解码
            byte[] decryptResult = decryptCipher.doFinal(Hex.decodeHex(context.trim().toCharArray()));
            if (null == decryptResult) return null;
            return new String(decryptResult, UTF8);
        } catch (DecoderException e) {
            e.printStackTrace();
        } catch (IllegalBlockSizeException e) {
            e.printStackTrace();
        } catch (BadPaddingException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) throws Exception {
        //密文使用Hex解码
        //秘钥 Hex解码为什么秘钥要进行解码，因为秘钥是某个秘钥明文进行了Hex编码后的值，所以在使用的时候要进行解码
        //加密内容
        String content = "deepakkguptaa@gmail.com";
        //AES加密解密秘钥
        // 加密
        System.out.println("加密前：" + content);
        // 调用加密方法
        String encryptResultStr = CryptAESUtils.getInstance().encryption(content);
        System.out.println("加密后：" + encryptResultStr);
//        String str = "2cabeff1a7d1e7b4e4aba69aa91455bb86bbeac205252d09cd783772b19e277eb7df612ec998bc5f20b61fec7dd56702 ";
//        String content = "cf4d53d43dcf8b5cbb3e61a19d52d11d09853b557992632dcb1cc33556d07894b585f42083cc45556b1386c7ba42c18e";
//        // 调用解密方法
//        String result = CryptAESUtils.getInstance().decryption(str);
//        System.out.println("解密后：" + result);
    }
}
