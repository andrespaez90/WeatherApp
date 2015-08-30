package andres.dev.com.weatherapp.Provider;

import android.net.Uri;
import android.util.Log;
import android.util.Pair;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by INNSO SAS on 30/08/2015.
 */
public class ServerConnection {

    public static String requestPOST(String url, Pair<String,String>... data){
        StringBuilder stringBuilder;

        try {
            URL service = new URL(url);
            HttpURLConnection connection = (HttpURLConnection) service.openConnection();
            connection.connect();
            InputStream in = connection.getInputStream();
            stringBuilder = readJSON(in);
            return (stringBuilder.toString());

        } catch (Exception e) {
            return e.getLocalizedMessage();
        }

    }



    private static StringBuilder readJSON(InputStream inputStream) throws IOException {
        StringBuilder stringBuilder = new StringBuilder();
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(inputStream));
        String line;
        while ((line = reader.readLine()) != null) {
            stringBuilder.append(line);
        }
        inputStream.close();
        return stringBuilder;
    }

}
