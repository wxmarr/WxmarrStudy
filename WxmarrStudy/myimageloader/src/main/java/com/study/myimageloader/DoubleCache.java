package com.study.myimageloader;

import android.graphics.Bitmap;

/**
 * Created by wxmarr on 2017/11/16.
 * 双缓存。获取图片时先从内存缓存中获取，如果内存中没有缓存该图片，再从SD卡中获取。
 * 缓存图片也是在SD卡和内存中都缓存一份。
 */

public class DoubleCache {
    ImageCache mMemoryCache = new ImageCache();
    DiskCache mDiskCache = new DiskCache();

    public Bitmap get(String url) {
        Bitmap bitmap = mMemoryCache.get(url);
        if (bitmap == null) {
            bitmap = mDiskCache.get(url);
        }
        return bitmap;
    }

    public void put(String url, Bitmap bitmap) {
        mMemoryCache.put(url, bitmap);
        mDiskCache.put(url, bitmap);
    }


}
