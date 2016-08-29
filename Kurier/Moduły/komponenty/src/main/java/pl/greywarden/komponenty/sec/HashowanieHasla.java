package pl.greywarden.komponenty.sec;

import java.io.UnsupportedEncodingException;
import java.security.*;

public class HashowanieHasla {

    private MessageDigest digest;
    
    private HashowanieHasla(){
        try{
            this.digest = MessageDigest.getInstance("SHA1");
        }catch(NoSuchAlgorithmException e){throw new Error("Unsupported algorithm!");}
    }
    
    private static HashowanieHasla instance;
    
    public static HashowanieHasla getInstance(){
        return instance==null ? instance = new HashowanieHasla() : instance;
    }
    
    private byte[] getUTF8Bytes(String string){
        try{
            return string.getBytes("UTF-8");
        }catch(UnsupportedEncodingException e){throw new Error("Unsupported encoding!");}
    }
    
    public byte[] hashujHaslo(String haslo){
        byte[] bytes = getUTF8Bytes(haslo);
        return digest.digest(bytes);
    }
}