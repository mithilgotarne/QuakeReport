package com.example.mithil.quakereport;

import android.content.AsyncTaskLoader;
import android.content.Context;
import android.text.TextUtils;
import android.util.Log;

import java.util.List;

/**
 * Created by Mithil on 12/7/2016.
 */

public class EarthquakeLoader extends AsyncTaskLoader<List<Earthquake>> {

    private String url;

    public EarthquakeLoader(Context context, String url) {
        super(context);
        this.url = url;
    }

    @Override
    protected void onStartLoading() {
        forceLoad();
    }

    @Override
    public List<Earthquake> loadInBackground() {
        if (TextUtils.isEmpty(url))
            return null;
        Log.d("Earthquake Loader", "loadInBackground Executed");
        return QueryUtils.fetchEarthquakeList(url);
    }

}