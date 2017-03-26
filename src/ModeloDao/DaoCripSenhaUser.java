/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModeloDao;

import org.apache.commons.codec.binary.Base64;

/**
 *
 * @author Daniel Lucas
 */
public class DaoCripSenhaUser {
    /**
     * Codifica string na base 64 (Encoder)
     */
    public static String codificaBase64Encoder(String msg) {
        return new Base64().encodeToString(msg.getBytes());
    }

    /**
     * Decodifica string na base 64 (Decoder)
     */
      public static String decodificaBase64Decoder(String msg) {
          return new String(new Base64().decode(msg));
      }
}
