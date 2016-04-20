package pl.greywarden.komponenty.sec;

import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;
import lombok.AccessLevel;
import lombok.Setter;

@Setter
public class DeszyfrowanieAES {

    private byte[] salt;
    private char[] aesPassword;
    private byte[] ivBytes;
    private final int keySize = 128;
    private final int pswdIterations = 65536;

    @Setter(AccessLevel.NONE)
    protected SecretKeyFactory factory;
    @Setter(AccessLevel.NONE)
    protected PBEKeySpec spec;
    @Setter(AccessLevel.NONE)
    protected SecretKey secretKey;
    @Setter(AccessLevel.NONE)
    protected Cipher cipher;
    @Setter(AccessLevel.NONE)
    protected SecretKeySpec secret;

    private SecretKeySpec createKey() {
        try {
            factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
            spec = new PBEKeySpec(aesPassword, salt, pswdIterations, keySize);
            secretKey = factory.generateSecret(spec);
            return new SecretKeySpec(secretKey.getEncoded(), "AES");
        } catch (InvalidKeySpecException | NoSuchAlgorithmException e) {
            throw new Error(e.getLocalizedMessage());
        }
    }

    private Cipher createCipher() throws NoSuchAlgorithmException, NoSuchPaddingException {
        return Cipher.getInstance("AES/CBC/PKCS5Padding");
    }

    public String decrypt(byte[] encrypted) {
        try {
            cipher = createCipher();
            secret = createKey();
            cipher.init(Cipher.DECRYPT_MODE, secret, new IvParameterSpec(ivBytes));
            return new String(cipher.doFinal(encrypted));
        } catch (BadPaddingException |
                IllegalBlockSizeException |
                InvalidAlgorithmParameterException |
                InvalidKeyException |
                NoSuchAlgorithmException |
                NoSuchPaddingException e) {
            throw new Error(e.getLocalizedMessage());
        }
    }
}
