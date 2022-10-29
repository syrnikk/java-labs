package util;

import model.RsaKey;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.util.Map;

public class RsaUtils {
    /**
     * Generates private and public key
     *
     * @param p some prime number
     * @param q some prime number
     * @return private and public key
     */
    public static Map<String, RsaKey> generateKeys(int p, int q) {
        int n = p * q;
        int fi = (p - 1) * (q - 1);
        int e;
        for (e = 2; e < fi; e++) {
            if (euclid(e, fi) == 1) {
                break;
            }
        }
        int d = extendedEuclid(e, fi);
        return Map.of("public", new RsaKey(e, n), "private", new RsaKey(d, n));
    }

    /**
     * Encodes message with public key
     *
     * @param message some text to send
     * @param publicKey rsa public key
     * @return encoded message
     */
    public static BigInteger[] encode(String message, RsaKey publicKey) {
        BigInteger e = BigInteger.valueOf(publicKey.exponent());
        BigInteger n = BigInteger.valueOf(publicKey.n());
        byte[] bytes = message.getBytes(StandardCharsets.UTF_8);
        BigInteger[] encodedMessage = new BigInteger[bytes.length];
        for (int i = 0; i < bytes.length; i++) {
            encodedMessage[i] = BigInteger.valueOf(bytes[i]).modPow(e, n);
        }
        return encodedMessage;
    }

    /**
     *  Decodes message with private key
     *
     * @param encodedMessage some encoded text
     * @param privateKey rsa private key
     * @return original message
     */
    public static String decode(BigInteger[] encodedMessage, RsaKey privateKey) {
        BigInteger d = BigInteger.valueOf(privateKey.exponent());
        BigInteger n = BigInteger.valueOf(privateKey.n());
        byte[] bytes = new byte[encodedMessage.length];
        for (int i = 0; i < encodedMessage.length; i++) {
            bytes[i] = encodedMessage[i].modPow(d, n).byteValueExact();
        }
        return new String(bytes, StandardCharsets.UTF_8);
    }

    /**
     * Euclidean algorithm
     *
     * @param a number
     * @param b number
     * @return greatest common divisor
     */
    private static int euclid(int a, int b) {
        while (b != 0) {
            int temp = a % b;
            a = b;
            b = temp;
        }
        return a;
    }

    /**
     * Extended Euclidean algorithm
     *
     * @param a number
     * @param b number
     * @return multiplicative inverse
     */
    private static int extendedEuclid(int a, int b) {
        int x0 = 1;
        int x = 0;
        int b0 = b;
        while (b != 0) {
            int q = a / b;
            int temp = x;
            x = x0 - q * x;
            x0 = temp;
            temp = a % b;
            a = b;
            b = temp;
        }
        if (x0 < 0) {
            x0 = x0 + b0;
        }
        return x0;
    }
}
