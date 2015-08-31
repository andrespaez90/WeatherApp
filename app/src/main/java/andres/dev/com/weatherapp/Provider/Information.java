package andres.dev.com.weatherapp.Provider;

import java.util.ArrayList;

import andres.dev.com.weatherapp.Model.CityInformation;

public class Information {

    public static CityInformation currentCity;

    private static ArrayList<CityInformation> data;

    public static ArrayList<CityInformation> getInstance(){
        if( data == null){
            Information inf = new Information();
            data = inf.addInfo();

        }
        return data;
    }

    private ArrayList<CityInformation> addInfo(){
        ArrayList<CityInformation> data = new ArrayList<>();

        CityInformation city = new CityInformation("Logroño","http://www.spain.info/export/sites/spaininfo/comun/carrusel-recursos/rioja/d_logrono_t2600021a.jpg","http://www.aemet.es/xml/municipios/localidad_26089.xml",false);
        data.add(city);

        city = new CityInformation("Honolulu", "http://www.aloha-hawaii.com/wp-content/uploads/2009/11/hawaii-kayaking.jpg","https://query.yahooapis.com/v1/public/yql?q=select%20*%20from%20weather.forecast%20where%20woeid%20in%20(select%20woeid%20from%20geo.places(1)%20where%20text%3D%22honolulu%22)&format=json&env=store%3A%2F%2Fdatatables.org%2Falltableswithkeys",true);
        data.add(city);

        city = new CityInformation ("Londres", "http://isae.es/blog/wp-content/uploads/2014/08/Londres+Fanny.jpg","https://query.yahooapis.com/v1/public/yql?q=select%20*%20from%20weather.forecast%20where%20woeid%20in%20(select%20woeid%20from%20geo.places(1)%20where%20text%3D%22london%22)&format=json&env=store%3A%2F%2Fdatatables.org%2Falltableswithkeys",true);
        data.add(city);

        city = new CityInformation("Paris","http://es.parisinfo.com/var/otcp/sites/images/media/1.-photos/50.-carrousel-550-x-278/vue-aerienne-paris-tour-eiffel-550x278-c-thinkstock/5070117-2-fre-FR/Vue-aerienne-Paris-Tour-Eiffel-550x278-C-Thinkstock_big_diaporama.jpg","https://query.yahooapis.com/v1/public/yql?q=select%20*%20from%20weather.forecast%20where%20woeid%20in%20(select%20woeid%20from%20geo.places(1)%20where%20text%3D%22paris%22)&format=json&env=store%3A%2F%2Fdatatables.org%2Falltableswithkeys",true);
        data.add(city);

        city = new CityInformation("Roma", "http://cdn1.mihistoriauniversal.com/wp-content/uploads/coliseo-romano-imperio-roma.jpg", "https://query.yahooapis.com/v1/public/yql?q=select%20*%20from%20weather.forecast%20where%20woeid%20in%20(select%20woeid%20from%20geo.places(1)%20where%20text%3D%22rome%22)&format=json&env=store%3A%2F%2Fdatatables.org%2Falltableswithkeys", true);
        data.add(city);


        return data;
    }


}
