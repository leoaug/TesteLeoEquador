package br.com.onsys.util;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.io.IOUtils;

public class ArquivoUtil {

	public static String montarArquivoBASE64(String extensao,byte[] contents) {
		return "data:image/"+extensao+";base64," + new String(Base64.encodeBase64(contents));
	}
	
	
	public static byte[] converterURLtoByte(String urlString) {
		byte[] byteArray = null;
		try {
            URL url = new URL(urlString);
            try (InputStream inputStream = url.openStream()) {
            	byteArray = IOUtils.toByteArray(inputStream);       
            }
        } catch (IOException e) {
            e.printStackTrace();
        }		
		return byteArray;
	}
}
