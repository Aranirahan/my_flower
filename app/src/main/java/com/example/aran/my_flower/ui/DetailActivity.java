

package com.example.aran.my_flower.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.aran.my_flower.R;
import com.example.aran.my_flower.model.helper.Constants;
import com.example.aran.my_flower.model.pojo.Flower;
import com.squareup.picasso.Picasso;

public class DetailActivity extends AppCompatActivity {

    private ImageView mPhoto;
    private TextView mName, mId, mCategory, mInstruction, mPrice;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Intent intent = getIntent();

        Flower flower = (Flower) intent.getSerializableExtra(Constants.REFERENCE.FLOWER);

        configViews();

        mId.setText(String.format("%d", flower.getProductId()));
        mName.setText(flower.getName());
        mCategory.setText(flower.getCategory());
        mInstruction.setText(flower.getInstructions());
        mPrice.setText(String.format("$%.2f", flower.getPrice()));

        if (flower.isFromDatabase()) {
            mPhoto.setImageBitmap(flower.getPicture());
        } else {
            Picasso.get().load(Constants.HTTP.BASE_URL + "/photos/" + flower.getPhoto()).into(mPhoto);

        }
    }

    private void configViews() {
        mPhoto =  findViewById(R.id.flowerPhoto);
        mName = findViewById(R.id.flowerName);
        mId = findViewById(R.id.flowerId);
        mCategory = findViewById(R.id.flowerCategory);
        mInstruction = findViewById(R.id.flowerInstruction);
        mPrice =  findViewById(R.id.flowerPrice);

    }
}
