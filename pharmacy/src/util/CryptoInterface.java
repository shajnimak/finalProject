package util;

import javax.crypto.SecretKey;

public interface CryptoInterface {
    SecretKey getKey();
    String encrypt();
    String decrypt();

}
