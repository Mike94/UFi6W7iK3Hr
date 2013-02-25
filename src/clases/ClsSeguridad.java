package clases;

import java.security.MessageDigest;

/**
 *
 * @author MK
 * @fecha: 04-june-2012
 * @descripcion: Se trata de una clase de implementara encriptacion como MD5,
 * SSL y otros......
 */
public class ClsSeguridad {

    /**
     * Algoritmos de Encriptacion: ---------------------------------------- SE
     * TIENE QUE TENER ENCUENTA LA LONGITUD DE LA CADENA QUE GUARDARA EL STRING
     * ENCRIPTADO -Para el Proyecto de SCAB, se considera "uPassword" de una
     * longitud de "VARCHAR(64)" -Con lo mencionado anteriormente, no
     * funcionaria para SHA-384 y SHA-512, pues estos son de mayor longitud...
     */
    public static String MD2 = "MD2";//Longitud:32
    public static String MD5 = "MD5";//Longitud:32
    public static String SHA1 = "SHA-1";//Longitud:40
    public static String SHA256 = "SHA-256";//Longitud:64
    public static String SHA384 = "SHA-384";//Longitud:96
    public static String SHA512 = "SHA-512";//Longitud:128

    /**
     * @autor MK
     * @function encriptar
     * @param textoParaEncriptar texto de entrada a la funcion para ser
     * encriptada
     * @param metodoEncriptacion Se señalara el metodo de encriptacion que
     * pueden ser: MD2,MD5,SHA-1,SHA-256,SHA-384,SHA-512
     * @return String, la cadena encriptada por el metodo elegido...
     */
    public String encriptar(String textoParaEncriptar, String metodoEncriptacion) {
        String encriptadoString = "";
        try {
            if (!textoParaEncriptar.equalsIgnoreCase("")) {//Pasamos el password obtenido del caja de password
                MessageDigest md = MessageDigest.getInstance(metodoEncriptacion);
                md.reset();
                md.update(textoParaEncriptar.getBytes());//Pasamos el psw a bytes
                byte bytes[] = md.digest();
                StringBuffer sb = new StringBuffer();
                for (int i = 0; i < bytes.length; i++) {
                    String hex = Integer.toHexString(0xff & bytes[i]);
                    if (hex.length() == 1) {
                        sb.append('0');
                    }
                    sb.append(hex);//Generamos el sb que se encuentra en HEX
                }
                encriptadoString = sb.toString();
            }
        } catch (Exception e) {
            System.out.println("----------Desde Seguridad.java-------------");
            System.out.println("La sentencia fracasó por:\n\n" + e.toString());
            System.out.println("----------Desde Seguridad.java-------------");
            e.printStackTrace();
        }
        return encriptadoString;
    }

    public String getMD2() {
        return MD2;
    }

    public String getMD5() {
        return MD5;
    }

    public String getSHA1() {
        return SHA1;
    }

    public String getSHA256() {
        return SHA256;
    }

    public String getSHA384() {
        return SHA384;
    }

    public String getSHA512() {
        return SHA512;
    }
}
