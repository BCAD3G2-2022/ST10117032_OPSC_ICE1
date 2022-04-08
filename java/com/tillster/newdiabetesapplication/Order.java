package com.tillster.newdiabetesapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class Order extends AppCompatActivity implements View.OnClickListener {

    ImageView img_Pepper, img_Double, img_Avo, img_Bacon, img_Chicken, img_Rib, img_Vegan;

    //Instantiating DTO(Data Transfer Object) ==> its a Model
    Product product;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);

        img_Pepper = findViewById(R.id.img_Pepper);
        img_Double = findViewById(R.id.img_Double);
        img_Avo = findViewById(R.id.img_Avo);
        img_Bacon = findViewById(R.id.img_Bacon);
        img_Chicken = findViewById(R.id.img_Chicken);
        img_Rib = findViewById(R.id.img_Rib);
        img_Vegan = findViewById(R.id.img_Vegan);


        img_Pepper.setOnClickListener(this);
        img_Double.setOnClickListener(this);
        img_Avo.setOnClickListener(this);
        img_Bacon.setOnClickListener(this);
        img_Chicken.setOnClickListener(this);
        img_Rib.setOnClickListener(this);
        img_Vegan.setOnClickListener(this);



    }

    @Override
    public void onClick(View view) {

        product = new Product();

        switch (view.getId())
        {
            case R.id.img_Pepper:
            product.setBurgerName("Pepper Burger");
            product.setBurgerPrice("R49.95");
            Intent passPepperBurger = new Intent(Order.this,OrderDetails.class);
            passPepperBurger.putExtra("GetPepperBurgerName", product.getBurgerName());
            passPepperBurger.putExtra("GetPepperBurgerPrice", product.getBurgerPrice());

            passPepperBurger.putExtra("burgerImage",R.drawable.pepper);
            startActivity(passPepperBurger);
            break;

            case R.id.img_Double:
                product.setBurgerName("Double Burger");
                product.setBurgerPrice("R69.95");
                Intent passDoubleBurger = new Intent(Order.this,OrderDetails.class);
                passDoubleBurger.putExtra("GetDoubleBurgerName", product.getBurgerName());
                passDoubleBurger.putExtra("GetDoubleBurgerPrice", product.getBurgerPrice());

                passDoubleBurger.putExtra("doubleBurgerImage",R.drawable.doublepatty);
                startActivity(passDoubleBurger);
                break;


        }
    }
}