package andres.dev.com.weatherapp;

import android.app.Activity;
import android.os.AsyncTask;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.util.Pair;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONObject;

import andres.dev.com.weatherapp.Model.CityInformation;
import andres.dev.com.weatherapp.Provider.Information;
import andres.dev.com.weatherapp.Provider.ServerConnection;
import butterknife.ButterKnife;
import butterknife.InjectView;


public class CityWeather extends ActionBarActivity {

    private CityInformation City;

    @InjectView(R.id.wh_cityName)
    TextView cityName;

    @InjectView(R.id.wh_cityImage)
    ImageView imageCity;

    @InjectView(R.id.wh_date)
    TextView dateWeather;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_city_weather);
        ButterKnife.inject(this);
        init();
    }

    private void init(){
        City = Information.currentCity;
        Picasso.with(this).load(City.urlImage).placeholder(R.drawable.cityload).into(imageCity);
        cityName.setText(City.cityName);
        if(City.JSON)
            new DownloadData().execute();
    }


    private void updateInfo(){
        City =  Information.currentCity;
        dateWeather.setText(City.Forecast.get(0).Date);
    }


    private class DownloadData extends AsyncTask< Pair<String,String>,String,String> {

        protected String doInBackground(Pair<String,String>...data){
            try{

                String result = ServerConnection.requestPOST(Information.currentCity.sourceData, data);
                publishProgress(result);
                JSONObject jsonObject = new JSONObject(result);

                JSONArray jsonArray = (((jsonObject.getJSONObject("query")).getJSONObject("results")).getJSONObject("channel")).getJSONObject("item").getJSONArray("forecast");
                publishProgress(jsonArray.toString());
                Information.currentCity.addForecast(jsonArray);

                return "Success";

            }
            catch (Exception e) {
                Log.d("ReadWeatherJSONFeedTask", e.getMessage());
            }
            return null;
        }


        protected void onProgressUpdate(String... progress) {
            Toast.makeText(CityWeather.this, progress[0], Toast.LENGTH_LONG).show();
        }


        protected void onPostExecute(String result) {
            if(result != null) {
                updateInfo();
            }
        }

    }

}
