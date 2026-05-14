package com.his.patientservice.utils;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;

public class PemUtils {
    public static PublicKey readPublicKey(String path) throws Exception {
        String key = Files.readString(Paths.get(path));

        key = key
                .replace(
                        "-----BEGIN PUBLIC KEY-----",
                        "")
                .replace(
                        "-----END PUBLIC KEY-----",
                        "")
                .replaceAll("\\s+", "");

        byte[] decoded = Base64.getDecoder().decode(key);

        X509EncodedKeySpec spec = new X509EncodedKeySpec(decoded);

        return KeyFactory.getInstance("RSA").generatePublic(spec);
    }
}
