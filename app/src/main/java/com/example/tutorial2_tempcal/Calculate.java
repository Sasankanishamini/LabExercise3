package com.example.tutorial2_tempcal;

public class  Calculate {

    protected float convertCelciusToFahrenheit(Float value) {
        Float ans = (value * 9/5) + 32;
        return ans;
    }
    protected float convertFahrenheitToCelcius(Float value) {
        Float ans = (value - 32) * 5/9;
        return ans; }
}
