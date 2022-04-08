package com.tillster.newdiabetesapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class OrderDetails extends AppCompatActivity {

    ImageView img_chosenBurger;
    TextView txt_burgerName, txt_burgerPrice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_details);

        img_chosenBurger = findViewById(R.id.img_chosenBurger);
        txt_burgerName = findViewById(R.id.txt_burgerName);
        txt_burgerPrice = findViewById(R.id.txt_burgerPrice);

        //Pepper Burger
        String burgerPrice = getIntent().getStringExtra("GetPepperBurgerPrice");
        String burgerName = getIntent().getStringExtra("GetPepperBurgerName");
        int imageName = getIntent().getIntExtra("burgerImage", 0);

        Toast.makeText(this, burgerPrice + " " + burgerName, Toast.LENGTH_SHORT).show();


        txt_burgerName.setText(burgerName);
        txt_burgerPrice.setText(burgerPrice);
        img_chosenBurger.setImageResource(imageName);

        //Double Burger
        String DoubleBurgerPrice = getIntent().getStringExtra("GetDoubleBurgerPrice");
        String DoubleBurgerName = getIntent().getStringExtra("GetDoubleBurgerName");
        int DoubleImageName = getIntent().getIntExtra("doubleBurgerImage", 0);

        Toast.makeText(this, DoubleBurgerPrice + " " + DoubleBurgerName, Toast.LENGTH_SHORT).show();


        txt_burgerName.setText(DoubleBurgerName);
        txt_burgerPrice.setText(DoubleBurgerPrice);
        img_chosenBurger.setImageResource(DoubleImageName);

    }
}