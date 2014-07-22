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
public class DetailViewActivity extends DraweredActivity {

    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

        setContentView(R.layout.city_view);

        Intent intent = getIntent();
        int cityId = intent.getIntExtra("InfoId",0);
        BaseInfo cityInfo = InfoFactory.getInfo(cityId);

        TextView description = (TextView)findViewById(R.id.cityViewDescription);
        TextView cityName = (TextView)findViewById(R.id.cityViewName);
        ImageView image = (ImageView)findViewById(R.id.cityViewImage);

        description.setText(cityInfo.getDescription());
        cityName.setText(cityInfo.getSubtitleString());
        image.setImageResource(cityInfo.getDrawable());

        DelicacyApplication.getInstance().setInDetailView();

    }

}

