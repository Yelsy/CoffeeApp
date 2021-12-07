package com.example.coffeeapp.network;
import android.net.Uri;
import android.util.Log;
import android.content.res.Resources;
import com.example.coffeeapp.R;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringWriter;
import java.io.Writer;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class CoffeeEntry {
    private static final String TAG = CoffeeEntry.class.getSimpleName();

    public final String tittle;
    public final Uri dynamicUrl;
    public final String url;
    public final String price;
    public final String description;

    public CoffeeEntry(
            String tittle, String dynamicUrl, String url, String price, String description) {
        this.tittle = tittle;
        this.dynamicUrl = Uri.parse(dynamicUrl);
        this.url = url;
        this.price = price;
        this.description = description;
    }

    public static List<CoffeeEntry> initCoffeeEntryList(Resources resources) {
        InputStream inputStream = resources.openRawResource(R.raw.coffee);

        Writer writer = new StringWriter();
        char[] buffer = new char[1024];
        try {
            Reader reader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
            int pointer;
            while ((pointer = reader.read(buffer)) != -1) {
                writer.write(buffer, 0, pointer);
            }
        } catch (IOException exception) {
            Log.e(TAG, "Error writing/reading from the JSON file.", exception);
        } finally {
            try {
                inputStream.close();
            } catch (IOException exception) {
                Log.e(TAG, "Error closing the input stream.", exception);
            }
        }
        String jsonProductsString = writer.toString();
        Gson gson = new Gson();
        Type productListType = new TypeToken<ArrayList<CoffeeEntry>>() {
        }.getType();
        return gson.fromJson(jsonProductsString, productListType);


    }
}