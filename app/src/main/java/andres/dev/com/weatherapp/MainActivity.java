package andres.dev.com.weatherapp;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

import andres.dev.com.weatherapp.Adapter.recycleAdapter;
import andres.dev.com.weatherapp.Model.CityInformation;
import andres.dev.com.weatherapp.Provider.Information;
import andres.dev.com.weatherapp.Uties.TAGs.ActivityTags;
import butterknife.ButterKnife;
import butterknife.InjectView;


public class MainActivity extends ActionBarActivity {

    @InjectView(R.id.main_recView)
    RecyclerView cityList;

    ArrayList<CityInformation> list = Information.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.inject(this);
        createList();

        Intent i = new Intent(this, SplashActivity.class);
        startActivityForResult(i, ActivityTags.SPLASH.code());


    }

    private void createList(){
        cityList.setHasFixedSize(true);
        final recycleAdapter adaptador = new recycleAdapter(list,this);

        cityList.setAdapter(adaptador);
        cityList.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
    }

}
