/*
 * Copyright (C) 2017 Jared Rummler
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.jaredrummler.android.colorpicker;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.PixelFormat;
import android.graphics.Rect;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;

import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;

/**
 * This drawable will draw a simple white and gray chessboard pattern.
 * It's the pattern you will often see as a background behind a partly transparent image in many applications.
 */
public class AlphaPatternDrawable extends Drawable {
    private final Paint patternPaint;

    public AlphaPatternDrawable(int rectangleSize) {
        this(rectangleSize, 0xFFFFFFFF, 0xFFCBCBCB);
    }

    public AlphaPatternDrawable(int rectangleSize, @ColorInt int color1, @ColorInt int color2) {
        // Create a small bitmap to define the checkerboard pattern
        Bitmap patternBitmap = Bitmap.createBitmap(rectangleSize * 2, rectangleSize * 2, Config.ARGB_8888);
        Canvas patternCanvas = new Canvas(patternBitmap);

        Paint paint = new Paint();

        // Draw the checkerboard pattern on the small bitmap
        Rect rect = new Rect(0, 0, rectangleSize, rectangleSize);
        paint.setColor(color1);
        patternCanvas.drawRect(rect, paint);

        rect.offset(rectangleSize, rectangleSize);
        patternCanvas.drawRect(rect, paint);

        paint.setColor(color2);
        rect.offset(-rectangleSize, 0);
        patternCanvas.drawRect(rect, paint);

        rect.offset(rectangleSize, -rectangleSize);
        patternCanvas.drawRect(rect, paint);

        // Use the small bitmap as a shader for the Paint object
        BitmapShader shader = new BitmapShader(patternBitmap, Shader.TileMode.REPEAT, Shader.TileMode.REPEAT);
        patternPaint = new Paint();
        patternPaint.setShader(shader);
    }

    @Override
    public void draw(@NonNull Canvas canvas) {
        canvas.drawPaint(patternPaint);
    }

    @Override
    public int getOpacity() {
        return PixelFormat.UNKNOWN;
    }

    @Override
    public void setAlpha(int alpha) {
        throw new UnsupportedOperationException("Alpha is not supported by this drawable.");
    }

    @Override
    public void setColorFilter(ColorFilter cf) {
        throw new UnsupportedOperationException("ColorFilter is not supported by this drawable.");
    }
}
