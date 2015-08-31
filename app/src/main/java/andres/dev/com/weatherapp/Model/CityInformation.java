package andres.dev.com.weatherapp.Model;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;
import java.util.ArrayList;

import static org.xmlpull.v1.XmlPullParser.START_DOCUMENT;
import static org.xmlpull.v1.XmlPullParser.START_TAG;

/**
 * Created by INNSO SAS on 30/08/2015.
 */
public class CityInformation {

    public String cityName;
    public String urlImage;
    public String sourceData;
    public boolean JSON;

    public ArrayList<Weather> Forecast;

    public CityInformation(String name, String image, String data, boolean json){
        cityName = name;
        urlImage = image;
        sourceData = data;
        JSON = json;

        Forecast = new ArrayList<Weather>();
    }

    public void addForecast(JSONArray dataObject) throws JSONException {
        for(int i=0; i < dataObject.length(); i++){
            JSONObject forecast = dataObject.getJSONObject(i);
            Weather w = new Weather(forecast.getString("date"),forecast.getString("high"), forecast.getString("low"));
            Forecast.add(w);
        }

    }

    private static final String ns = null;

    public void addForecast(XmlPullParser parser) throws XmlPullParserException, IOException {
        String name = "";
        parser.next();
        while (parser.next() != XmlPullParser.END_DOCUMENT) {
            name = "";
            name = parser.getName();
            if( name != null && name.equals("yweather:forecast") ){
                Weather w = new Weather(parser.getAttributeValue(2),parser.getAttributeValue(4), parser.getAttributeValue(5));
                Forecast.add(w);
                parser.next();
            }
        }
    }



}
