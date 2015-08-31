package andres.dev.com.weatherapp.Model;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

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
}
