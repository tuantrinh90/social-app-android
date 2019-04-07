package com.rozdoum.socialcomponents.utils;

import android.content.Context;
import android.content.Intent;
import android.graphics.Point;
import android.view.Display;
import android.view.WindowManager;

import com.rozdoum.socialcomponents.R;


public class Utils {

    public static int getDisplayWidth(Context context) {
        return getSize(context).x;
    }

    public static int getDisplayHeight(Context context) {
        return getSize(context).y;
    }

    private static Point getSize(Context context) {
        WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        Display display = wm.getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        return size;
    }

    public static void share(Context context, String link) {
        Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);
        sharingIntent.setType("text/plain");
        sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, link);
        context.startActivity(Intent.createChooser(sharingIntent, context.getString(R.string.send_intent_title)));
    }
}
