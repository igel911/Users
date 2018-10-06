package com.vladimir_khm.users;

import android.databinding.BindingAdapter;
import android.databinding.BindingConversion;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.vladimir_khm.users.app.App;
import com.vladimir_khm.users.util.DateTimeConverter;

import org.joda.time.DateTime;


public class BindingAdapters {

    private BindingAdapters() {}

    @BindingAdapter({"app:url"})
    public static void loadImage(ImageView view, String url) {
        Glide.with(App.getAppContext()).load(url).into(view);
    }

//    @BindingConversion
//    public static String convertTagListToString(List<String> tagList) {
//        StringBuilder sb = new StringBuilder();
//        for (String tag: tagList) {
//            if (sb.length() > 0) sb.append("\n");
//            sb.append(tag);
//        }
//        return sb.toString();
//    }

    @BindingConversion
    public static String convertDateToString(DateTime registered) {
        return DateTimeConverter.toString(registered);
    }

    @BindingConversion
    public static String convertBooleanToString(boolean isActive) {
        return String.valueOf(isActive);
    }
}
