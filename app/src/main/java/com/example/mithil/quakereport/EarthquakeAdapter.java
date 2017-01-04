package com.example.mithil.quakereport;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/**
 * Created by Mithil on 12/6/2016.
 */

public class EarthquakeAdapter extends ArrayAdapter<Earthquake> {

    private static final String LOCATION_SEPARATOR = " of ";

    public EarthquakeAdapter(Context context, List<Earthquake> earthquakes) {
        super(context, 0, earthquakes);
    }


    @NonNull
    @Override
    public View getView(int position, View convertView, @NonNull ViewGroup parent) {

        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_item_earthquake, parent, false);
        }

        Earthquake currentEarthquake = getItem(position);
        long timeInMilliSeconds = currentEarthquake.getTimeInMilliSeconds();
        String place = currentEarthquake.getPlace();
        double magnitude = currentEarthquake.getMagnitude();

        TextView magnitudeTextView = (TextView) listItemView.findViewById(R.id.earthquake_magnitude_textview);
        TextView dateTextView = (TextView) listItemView.findViewById(R.id.earthquake_date_textview);
        TextView timeTextView = (TextView) listItemView.findViewById(R.id.earthquake_time_textview);

        magnitudeTextView.setText(getFormatedMagnitude(magnitude));
        GradientDrawable magnitudeCircle = (GradientDrawable) magnitudeTextView.getBackground();
        magnitudeCircle.setColor(getMagnitudeColor(magnitude));

        Date dateObject = new Date(timeInMilliSeconds);
        dateTextView.setText(getFormatedDate(dateObject));
        timeTextView.setText(getFormatedTime(dateObject));
        setPlace(listItemView, place);

        return listItemView;
    }

    private int getMagnitudeColor(Double magnitude){
        int mag = (int) Math.floor(magnitude);

        switch (mag){
            case 0:
            case 1:
                return ContextCompat.getColor(getContext(), R.color.magnitude1);
            case 2:
                return ContextCompat.getColor(getContext(), R.color.magnitude2);
            case 3:
                return ContextCompat.getColor(getContext(), R.color.magnitude3);
            case 4:
                return ContextCompat.getColor(getContext(), R.color.magnitude4);
            case 5:
                return ContextCompat.getColor(getContext(), R.color.magnitude5);
            case 6:
                return ContextCompat.getColor(getContext(), R.color.magnitude6);
            case 7:
                return ContextCompat.getColor(getContext(), R.color.magnitude7);
            case 8:
                return ContextCompat.getColor(getContext(), R.color.magnitude8);
            case 9:
                return ContextCompat.getColor(getContext(), R.color.magnitude9);
            default:
                return ContextCompat.getColor(getContext(), R.color.magnitude10plus);

        }

    }

    private String getFormatedMagnitude(double magnitude) {
        DecimalFormat magnitudeFormat = new DecimalFormat("0.0");
        return magnitudeFormat.format(magnitude);
    }

    private String getFormatedDate(Date dateObject) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("LLL dd,yyyy", Locale.ENGLISH);
        return dateFormat.format(dateObject);
    }

    private String getFormatedTime(Date dateObject) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("h:mm a", Locale.ENGLISH);
        return dateFormat.format(dateObject);
    }

    private void setPlace(View listView, String place){
        String partOne, partTwo;
        TextView textViewPartOne = (TextView) listView.findViewById(R.id.earthquake_location_part_one_textview);
        TextView textViewPartTwo = (TextView) listView.findViewById(R.id.earthquake_location_part_two_textview);
        if(place.contains(LOCATION_SEPARATOR)){
            String parts[] = place.split(LOCATION_SEPARATOR);
            partOne = parts[0] + LOCATION_SEPARATOR;
            partTwo = parts[1];
        }
        else {
            partOne = getContext().getString(R.string.near_the);
            partTwo = place;
        }
        textViewPartOne.setText(partOne);
        textViewPartTwo.setText(partTwo);
    }

}
