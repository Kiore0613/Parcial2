package com.example.parcial2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class VerDatos extends AppCompatActivity {
    TextView tv_1, tv_2, tv_3, tv_4, tv_5, tv_6;

    String name, description, price, type;
    int code;
    double salePrice;
    final static int id = 1;
    final static String nameSend = "name";
    final static String descriptionSend = "description";
    final static String priceSend = "price";
    final static String typeSend = "type";
    final static String codeSend = "code";
    final static String salePriceSend = "sales";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ver_datos);
        tv_1 = findViewById(R.id.tv1);
        tv_2 = findViewById(R.id.tv2);
        tv_3 = findViewById(R.id.tv3);
        tv_4 = findViewById(R.id.tv4);
        tv_5 = findViewById(R.id.tv5);
        tv_6 = findViewById(R.id.tv6);

        Bundle data = getIntent().getExtras();

        name = data.getString(nameSend);
        description = data.getString(descriptionSend);
        code = data.getInt(codeSend);
        price = data.getString(priceSend);
        type = data.getString(typeSend);
        salePrice = data.getDouble(salePriceSend);

        tv_1.setText("Code: 00" + code);
        tv_2.setText("Name: " + name);
        tv_3.setText("Description: " + description);
        tv_4.setText("Category: " + type);
        tv_5.setText("Price: " + price);
        tv_6.setText("Sale price: " + salePrice);

    }
    public void Confirm(View btnConfirm){
        Toast.makeText(getApplicationContext(), "Save data", Toast.LENGTH_SHORT).show();
        setResult(RESULT_OK);
        finish();
    }
    public void Cancel (View btnCancel){
        finish();

    }

}
