package com.tr2016.hederkosher.utils;

/**
 * Created by user on 29/11/16.
 */

import android.os.Environment;

public interface Constants {

    public static final String APP_PREFS_NAME = Constants.class.getPackage().getName();
    public static final String APP_CACHE_PATH =
            Environment.getExternalStorageDirectory().getAbsolutePath() +
                    "/Android/data/" + APP_PREFS_NAME + "/cache/";

    // localhost
//	public static final String APP_SOURCE_IMAGES_URL = "http://10.0.2.2/images/";
// GitHub project storage
//    public static final String APP_SOURCE_IMAGES_URL = "https://github.com/Voldemar123/andriod-image-habrahabr-example/raw/master/res/drawable/";

    public static final String APP_SOURCE_IMAGES_URL = "hederkosher.tr2016.com.hederkosher/com.tr2016.hederkosher/";

    // pictures names list
    public static final String IMAGE_NAMES[] = {
            "image_user_mini.jpg",
            "img2.jpg",
            "img3.jpg"
    };

}