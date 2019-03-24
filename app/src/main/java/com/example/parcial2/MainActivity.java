package com.example.parcial2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText edt_name, edt_description, edt_price;
    RadioButton rdb_tools, rdb_medicine, rdb_clothes;

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
        setContentView(R.layout.activity_main);
        edt_name = findViewById(R.id.edtName);
        edt_description = findViewById(R.id.edtDescription);
        edt_price = findViewById(R.id.edtPrice);
        rdb_tools = findViewById(R.id.rdbTools);
        rdb_medicine = findViewById(R.id.rdbMedicine);
        rdb_clothes = findViewById(R.id.rdbClothes);

    }
    public void Save (View btnSave){
        name = edt_name.getText().toString().trim();
        description = edt_description.getText().toString().trim();
        price = edt_price.getText().toString().trim();

        if(TextUtils.isEmpty(name)){
            edt_name.setError("Required field");
            edt_name.requestFocus();
        }
        else if(TextUtils.isEmpty(description)){
            edt_description.setError("Required field");
            edt_description.requestFocus();
        }
        else if(TextUtils.isEmpty(price)){
            edt_price.setError("Required field");
            edt_price.requestFocus();
        }
        else{
            if(rdb_tools.isChecked()){
                salePrice = Double.parseDouble(price) * 0.10;
                salePrice = salePrice + Double.parseDouble(price);
                type = "tools";
            }
            else if(rdb_medicine.isChecked()){
                salePrice = Double.parseDouble(price) * 0.20;
                salePrice = salePrice + Double.parseDouble(price);
                type = "medicine";
            }
            else if(rdb_clothes.isChecked()){
                salePrice = Double.parseDouble(price) * 0.30;
                salePrice = salePrice + Double.parseDouble(price);
                type = "clothes";
            }
            code++;

            Intent obj = new Intent(getApplicationContext(), VerDatos.class);
            obj.putExtra(nameSend, name);
            obj.putExtra(descriptionSend, description);
            obj.putExtra(priceSend, price);
            obj.putExtra(typeSend, type);
            obj.putExtra(codeSend, code);
            obj.putExtra(salePriceSend, salePrice);

            startActivityForResult(obj, id);

            Toast.makeText(getApplicationContext(), "data saved", Toast.LENGTH_SHORT).show();

        }
    }
    @Override
    public void onActivityResult(int codeResult, int codeActivity, Intent data){
        if(codeResult == id){
            if(codeActivity == RESULT_OK){
                edt_name.setText("");
                edt_price.setText("");
                edt_description.setText("");
                edt_name.requestFocus();
            }
            else{
                code --;
            }
        }
    }

    public void Clear (View btnClear){
        edt_name.setText("");
        edt_description.setText("");
        edt_price.setText("");
        edt_name.requestFocus();
    }
}
