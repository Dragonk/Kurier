package pl.greywarden.komponenty.sec;

import java.io.*;
import java.security.AlgorithmParameters;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.*;
import javax.crypto.*;
import javax.crypto.spec.*;
import lombok.*;
import org.apache.commons.codec.binary.Base64;

@Setter
public class SzyfrowanieAES {
    
    private byte[] salt;
    private char[] aesPassword;
    private byte[] ivBytes;
    private final int keySize = 128;
    private final int pswdIterations = 65536;
    
    @Setter(AccessLevel.NONE) protected SecretKeyFactory factory;
    @Setter(AccessLevel.NONE) protected PBEKeySpec spec;
    @Setter(AccessLevel.NONE) protected SecretKey secretKey;
    @Setter(AccessLevel.NONE) protected SecretKeySpec secret;
    @Setter(AccessLevel.NONE) protected Cipher cipher;

    private SecretKeySpec createKey(){
        try{
            factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
            spec = new PBEKeySpec(aesPassword, salt, pswdIterations, keySize);
            secretKey = factory.generateSecret(spec);
        }catch(NoSuchAlgorithmException |InvalidKeySpecException e){throw new Error(e.getLocalizedMessage());}
        return new SecretKeySpec(secretKey.getEncoded(), "AES");
    }

    private Cipher createCipher() throws NoSuchAlgorithmException, NoSuchPaddingException {
        return Cipher.getInstance("AES/CBC/PKCS5Padding");
    }

    public String encrypt(String data){
        try{secret = createKey();
        cipher = createCipher();
        initIvBytes(createAlgorithmParameters());
        cipher.init(Cipher.ENCRYPT_MODE, secret);
        return new Base64().encodeAsString(cipher.doFinal(data.getBytes("UTF-8")));
        }catch(InvalidParameterSpecException|NoSuchAlgorithmException | NoSuchPaddingException | InvalidKeyException | UnsupportedEncodingException | IllegalBlockSizeException | BadPaddingException e){throw new Error(e.getLocalizedMessage());}
        
    }

    private AlgorithmParameters createAlgorithmParameters() {
        return this.cipher.getParameters();
    }

    private void initIvBytes(AlgorithmParameters ap) throws InvalidParameterSpecException {
        ivBytes = ap.getParameterSpec(IvParameterSpec.class).getIV();
    }

    public void saveSaltToFile(File target) throws IOException {
        writeBytesToFile(target, salt);
    }

    public void saveIvBytesToFile(File target) throws IOException {
        writeBytesToFile(target, ivBytes);
    }

    private void writeBytesToFile(File target, byte[] data) throws IOException {
        try (FileOutputStream output = new FileOutputStream(target)) {
            output.write(data);
        }
    }
}