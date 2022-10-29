import model.RsaKey;
import util.RsaUtils;

import java.math.BigInteger;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map<String, RsaKey> keys = RsaUtils.generateKeys(397, 103);
        RsaKey publicKey = keys.get("public");
        RsaKey privateKey = keys.get("private");

        String message = "This is my sensitive data";

        BigInteger[] encodedMessage = RsaUtils.encode(message, publicKey);
        String decodedMessage = RsaUtils.decode(encodedMessage, privateKey);

        System.out.println("Message before encoding: " + message);
        System.out.println("Message after encoding and decoding: " + decodedMessage);
    }
}
