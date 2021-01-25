package com.example.sematectodo4;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatEditText;

public class VazirEditText extends AppCompatEditText {
    public VazirEditText(@NonNull Context context) {
        super(context);
    }

    public VazirEditText(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        Typeface typeface = Typeface.createFromAsset(context.getAssets(), "vazir.ttf");
        this.setTypeface(typeface);
    }
}
