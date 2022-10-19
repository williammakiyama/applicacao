/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 *
 * @author willi
 */
public class CriptografarSenha {

    public CriptografarSenha() {
    }    
    
    public static String encripta (String senha) {
//          try    {
//              MessageDigest digest = MessageDigest.getInstance("MD5");
//              digest.update(senha.getBytes());
//              BASE64Encoder encoder = new BASE64Encoder (); 
//              return encoder.encode(digest.digest()); 
//          }catch (NoSuchAlgorithmException ns) {
//              ns.printStackTrace ();
              return senha;
          }
    }
//}
