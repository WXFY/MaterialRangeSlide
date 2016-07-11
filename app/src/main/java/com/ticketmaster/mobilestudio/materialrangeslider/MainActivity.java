package com.ticketmaster.mobilestudio.materialrangeslider;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import java.util.Currency;
import java.util.Locale;


public class MainActivity extends AppCompatActivity implements MaterialRangeSlider.RangeSliderListener {
    private MaterialRangeSlider priceSlider;
    private TextView minPriceTxt;
    private TextView maxPriceTxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        priceSlider = (MaterialRangeSlider)findViewById(R.id.price_slider);
        minPriceTxt = (TextView)findViewById(R.id.start);
        maxPriceTxt = (TextView)findViewById(R.id.end);
        priceSlider.setRangeSliderListener(this);
        priceSlider.setMin(1);
        priceSlider.setMax(100);
        findViewById(R.id.btn_launch_picker).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onLaunchSlider();
            }
        });
        findViewById(R.id.btn_reset).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                priceSlider.reset();
            }
        });
    }
    public void onLaunchSlider() {
        PriceRangePickerDialogFragment.newInstance(0, 100, 0, 100, Currency.getInstance(Locale.getDefault()).getSymbol())
                .show(getSupportFragmentManager(), "slider");
    }

    @Override
    public void onMaxChanged(int newValue) {
        maxPriceTxt.setText(String.valueOf(newValue));
    }

    @Override
    public void onMinChanged(int newValue) {
        minPriceTxt.setText(String.valueOf(newValue));
    }
}
