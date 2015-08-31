package andres.dev.com.weatherapp.Model;

/**
 * Created by INNSO SAS on 29/08/2015.
 */
public class Weather {

    public String Date;
    public String TempMax;
    public String TempMin;

    public Weather(String date, String tempMax, String tempMin) {
        Date = date;
        TempMax = tempMax;
        TempMin = tempMin;
    }
}
