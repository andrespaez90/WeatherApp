package andres.dev.com.weatherapp.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import andres.dev.com.weatherapp.CityWeather;
import andres.dev.com.weatherapp.Model.CityInformation;
import andres.dev.com.weatherapp.Provider.Information;
import andres.dev.com.weatherapp.R;

/**
 * Created by INNSO SAS on 30/08/2015.
 */
public class recycleAdapter extends RecyclerView.Adapter<recycleAdapter.DataViewHolder> {

    private ArrayList<CityInformation> visibleItems;
    private ArrayList<CityInformation> allItems;
    private Context mContext;

    public recycleAdapter(ArrayList<CityInformation> data, Context context){
        mContext = context;
        allItems = data;
        flushFilter();
    }

    @Override
    public DataViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.item_list, viewGroup, false);

        DataViewHolder tvh = new DataViewHolder(itemView,mContext);
        itemView.setOnClickListener(tvh);


        return tvh;
    }


    @Override
    public void onBindViewHolder(DataViewHolder data, int i) {
        CityInformation item = visibleItems.get(i);
        data.bindItem(item);
    }

    @Override
    public int getItemCount() {
        return visibleItems.size();
    }

    public void flushFilter(){
        visibleItems = new ArrayList<CityInformation>();
        visibleItems.addAll(allItems);
        notifyDataSetChanged();
    }

    public void setFilter(String queryText) {

        visibleItems = new ArrayList<CityInformation>();
        for (CityInformation item: allItems) {
            if (item.cityName.toLowerCase().contains(queryText))
                visibleItems.add(item);
        }
        notifyDataSetChanged();
    }


    public static class DataViewHolder extends RecyclerView.ViewHolder implements  View.OnClickListener{

        private ImageView imageView;
        private TextView txtTitle;
        private int mRowHeight;

        private Context mContext;
        private CityInformation city;

        public DataViewHolder(View itemView, Context context) {
            super(itemView);
            mRowHeight = 100;
            mContext = context;
            imageView = (ImageView)itemView.findViewById(R.id.itemImage);
            txtTitle = (TextView)itemView.findViewById(R.id.itemname);
        }

        public void bindItem(CityInformation item) {
            city = item;
            txtTitle.setText(city.cityName);
            Picasso.with(mContext).load(city.urlImage).placeholder(R.drawable.cityload).into(imageView);
        }

        @Override
        public void onClick(View v) {
            Information.currentCity = city;
            Intent intent = new Intent(mContext, CityWeather.class);
            mContext.startActivity(intent);
        }
    }

}
