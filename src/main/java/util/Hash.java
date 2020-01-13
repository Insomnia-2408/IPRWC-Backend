package util;

import javax.xml.bind.DatatypeConverter;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

public class Hash {

    public static String hash(String hashable) throws NoSuchAlgorithmException {

        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        byte[] hash = digest.digest(hashable.getBytes(StandardCharsets.UTF_8));
        String readableHash = DatatypeConverter.printHexBinary(hash).toUpperCase();
        return readableHash;

    }

}
