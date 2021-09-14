package org.example.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public final class HttpClientUtil {
    private HttpClientUtil() {
    }

    private static Logger log = LoggerFactory.getLogger(HttpClientUtil.class);

    public static String get(String url) {
        StringBuilder result = new StringBuilder();
        BufferedReader br = null;
        InputStream inputstream = null;
        InputStreamReader isr = null;
        try {
            URL readerUrl = new URL(url);
            URLConnection conn = readerUrl.openConnection();
            conn.connect();
            inputstream = conn.getInputStream();
            isr = new InputStreamReader(inputstream);
            br = new BufferedReader(isr);
            String json = "";
            while ((json = br.readLine()) != null) {
                result.append(json);
            }
        } catch (Exception e) {
            log.error(e.getMessage());
        }
        return result.toString();
    }
}
