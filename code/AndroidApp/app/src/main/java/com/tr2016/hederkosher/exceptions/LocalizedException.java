package com.tr2016.hederkosher.exceptions;

import android.content.Context;

/**
 * Created by user on 29/11/16.
 */

public class LocalizedException extends Exception {
    private static final long serialVersionUID = 511553950546209386L;

    /**
     * Идентификатор ресурса с описанием ошибки.
     */
    private final int resourceID;

    /**
     * Дополнительные данные.
     */
    private final String extra;

    public LocalizedException(int resourceID, String extra) {
        this.resourceID = resourceID;
        this.extra = extra;
    }

    public LocalizedException(int resourceID) {
        this(resourceID, null);
    }

    /**
     * Возвращает текст ошибки.
     * @return
     */
    public String getString(Context context) {
        if (extra == null)
            return context.getString(resourceID);
        else
            return context.getString(resourceID, extra);
    }
}
