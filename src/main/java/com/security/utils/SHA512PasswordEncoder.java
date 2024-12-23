package com.security.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class SHA512PasswordEncoder implements PasswordEncoder {

    private static final Logger log = LoggerFactory.getLogger(SHA512PasswordEncoder.class);

    @Override
    public String encode(CharSequence rawPassword) {
        return hashWithSHA512(rawPassword.toString());
    }

    @Override
    public boolean matches(CharSequence rawPassword, String encodedPassword) {
        return encode(rawPassword).equals(encodedPassword);
    }

    private static String hashWithSHA512(String password) {
        StringBuilder result = new StringBuilder();
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-512");
            byte[] digested = digest.digest(password.getBytes());
            for (byte b : digested) {
                result.append(
                        Integer.toHexString(0xFF & b)
                );
            }
        } catch (NoSuchAlgorithmException e) {
            log.error(String.valueOf(e));
        }
        return result.toString();
    }
}
