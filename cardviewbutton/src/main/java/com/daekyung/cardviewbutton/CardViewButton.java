package com.daekyung.cardviewbutton;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.support.annotation.ColorInt;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.CardView;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by dae kyung kim on 2017. 4. 6..
 */

public class CardViewButton extends LinearLayout {

    private CardView cardView;
    private TextView textView;
    private ImageView imageView;
    private OnClickListener onClickListener;

    @Override
    public void setOnClickListener(@Nullable OnClickListener l) {
        onClickListener = l;
    }

    public CardViewButton(Context context) {
        super(context);
        initView();
    }

    public CardViewButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView();
        getAttrs(attrs);
    }

    public CardViewButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView();
        getAttrs(attrs, defStyleAttr);
    }

    private void setTypeArray(TypedArray typedArray) {

        float buttonTextSize = 15;
        String buttonText = null;
        String fontFamily = null;
        ColorStateList textColor = null;

        int cardViewBackgroundColor = typedArray.getColor(R.styleable.CardViewButton_centerIconButtonColor,
                ContextCompat.getColor(getContext(), R.color.colorPrimary));
        cardView.setCardBackgroundColor(cardViewBackgroundColor);

        Drawable drawable = typedArray.getDrawable(R.styleable.CardViewButton_centerIconButtonImageResource);
        if (drawable != null) {
            imageView.setImageDrawable(drawable);
        }

        textColor = typedArray.getColorStateList(R.styleable.CardViewButton_centerIconButtonTextColor);
        textView.setTextColor(textColor != null ? textColor : ColorStateList.valueOf(0xFF000000));

        fontFamily = typedArray.getString(R.styleable.CardViewButton_centerIconButtonFontFamily);
        textView.setTypeface(Typeface.create(fontFamily, Typeface.NORMAL));

        buttonTextSize = typedArray.getDimensionPixelSize(R.styleable.CardViewButton_centerIconButtonTextSize, 15);
        textView.setTextSize(TypedValue.COMPLEX_UNIT_PX, buttonTextSize);

        buttonText = typedArray.getString(R.styleable.CardViewButton_centerIconButtonText);
        textView.setText(buttonText);

        typedArray.recycle();
    }

    private void getAttrs(AttributeSet attrs) {
        TypedArray typedArray = getContext().obtainStyledAttributes(attrs, R.styleable.CardViewButton);
        setTypeArray(typedArray);
    }

    private void getAttrs(AttributeSet attrs, int defStyle) {
        TypedArray typedArray = getContext().obtainStyledAttributes(attrs, R.styleable.CardViewButton, defStyle, 0);
        setTypeArray(typedArray);
    }

    private void initView() {
        String infService = Context.LAYOUT_INFLATER_SERVICE;
        LayoutInflater layoutInflater = (LayoutInflater) getContext().getSystemService(infService);
        View view = layoutInflater.inflate(R.layout.widget_center_icon_button, this, false);
        addView(view);

        cardView = (CardView) findViewById(R.id.widget_center_icon_button_card_view);
        imageView = (ImageView) findViewById(R.id.widget_center_icon_button_image_view);
        textView = (TextView) findViewById(R.id.widget_center_icon_button_button);
        cardView.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if(onClickListener != null){
                    onClickListener.onClick(v);
                }
            }
        });
    }


    public void setCardViewBackgroundColor(@ColorInt int color){
        cardView.setCardBackgroundColor(color);
    }

    public void setCardViewBackgroundColor(@Nullable ColorStateList color){
        cardView.setCardBackgroundColor(color);
    }

    public void setButtonText(int resId){
        textView.setText(resId);
    }

    public void setButtonText(String text){
        textView.setText(text);
    }

    public CharSequence getButtonText() {
        return textView.getText();
    }

}
