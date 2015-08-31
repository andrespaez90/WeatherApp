package andres.dev.com.weatherapp.Provider;

/**
 * Created by INNSO SAS on 30/08/2015.
 */
public class TemperatureConverter {

    public static String FahrenheittoCelsius(String fahrenheit ){
        double F = Double.parseDouble(fahrenheit);
        double c = (F - 32)/(5/9);
        return ""+c;
    }

    public static String Celsiustofahrenheit(String Celsius){
        double C = Double.parseDouble(Celsius);
        double f = (C*(9/5))+32;
        return ""+f;
    }
}
