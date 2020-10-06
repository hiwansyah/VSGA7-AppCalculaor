package com.example.appcalculator;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private EditText angka1, angka2;
    private Button plus, minus, multiplication, division, clear;
    private TextView hasil;
    private String a, b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        angka1 = findViewById(R.id.angka_pertama);
        angka2 = findViewById(R.id.angka_kedua);

        plus = findViewById(R.id.btn_plus);
        minus = findViewById(R.id.btn_minus);
        multiplication = findViewById(R.id.btn_multiplication);
        division = findViewById(R.id.btn_division);
        clear = findViewById(R.id.btn_clear);
        hasil = findViewById(R.id.txt_hasil);

        plus.setOnClickListener(this);
        minus.setOnClickListener(this);
        multiplication.setOnClickListener(this);
        division.setOnClickListener(this);
        clear.setOnClickListener(this);


    }

    private void clear() {
        angka1.setText("");
        angka2.setText("");
        hasil.setText("0");
        angka1.requestFocus();
    }

    private boolean validasi() {
        a = angka1.getText().toString().trim();
        b = angka2.getText().toString().trim();
        boolean isEmpty = false;

        if (TextUtils.isEmpty(a)){
            isEmpty = true;
            angka1.setError("Tidak boleh kososng !");
        }
        if (TextUtils.isEmpty(b)){
            isEmpty = true;
            angka2.setError("Tidak boleh kososng !");
        }
        return isEmpty;
    }

    private void tambah() {
        double x = Double.parseDouble(a);
        double y = Double.parseDouble(b);
        double result = x + y;
        hasil.setText(String.valueOf(result));
    }
    private void kurang() {
        double x = Double.parseDouble(a);
        double y = Double.parseDouble(b);
        double result = x - y;
        hasil.setText(String.valueOf(result));
    }
    private void kali() {
        double x = Double.parseDouble(a);
        double y = Double.parseDouble(b);
        double result = x * y;
        hasil.setText(String.valueOf(result));
    }
    private void bagi() {
        double x = Double.parseDouble(a);
        double y = Double.parseDouble(b);
        double result = x / y;
        hasil.setText(String.valueOf(result));
    }



    @Override
    public void onClick(View v) {
        boolean isEmpty = validasi();
        switch (v.getId()){
            case R.id.btn_plus:
                if (!isEmpty){
                    tambah();
                }
                break;
            case R.id.btn_minus:
                if (!isEmpty){
                    kurang();
                }
                break;
            case R.id.btn_multiplication:
                if (!isEmpty){
                    kali();
                }
                break;
            case R.id.btn_division:
                if (!isEmpty){
                    bagi();
                }
                break;
            case R.id.btn_clear:
                if (!isEmpty) {
                    clear();
                    break;
                }


        }
    }

}