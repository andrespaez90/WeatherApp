package andres.dev.com.weatherapp.Provider;

/**
 * Created by INNSO SAS on 30/08/2015.
 */
public class TemperatureConverter {

    public static String FahrenheittoCelsius(String fahrenheit ){
        double F = Double.parseDouble(fahrenheit);
        int c = (int)redondear(((F - 32) * (5.0 / 9.0)));
        return ""+c;
    }

    public static String Celsiustofahrenheit(String Celsius){
        double C = Double.parseDouble(Celsius);
        double f = (C*(9.0/5.0))+32;
        return ""+f;
    }

    private static double redondear(double d){
        return Math.rint(d*100)/100;
    }
}
