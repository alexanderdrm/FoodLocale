package com.mobiquity.localdel;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.LocalDel.R;

/**
 * Created by rsampath on 7/18/14.
 */
public class CityInfoActivity extends Activity {

    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

        setContentView(R.layout.city_view);

        Intent intent = getIntent();
        int cityId = intent.getIntExtra("CityId",0);
        CityInfo cityInfo = CityFactory.getCityById(cityId);

        TextView description = (TextView)findViewById(R.id.cityViewDescription);
        TextView cityName = (TextView)findViewById(R.id.cityViewName);
        ImageView image = (ImageView)findViewById(R.id.cityViewImage);

        description.setText(cityInfo.getDescription());
        cityName.setText(cityInfo.getSubtitleString());
        image.setImageResource(R.drawable.taj_mahal);


    }

}

