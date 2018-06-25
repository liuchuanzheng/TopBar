package com.liuchuanzheng.lcz_topbar;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by 刘传政 on 2018/6/25 0025.
 * QQ:1052374416
 * 电话:18501231486
 * 作用:
 * 注意事项:
 */
public class TopBar extends LinearLayout {

    private TextView tv_left;
    private TextView tv_middle;
    private TextView tv_right;

    public TopBar(Context context) {
        //调用两参
        this(context, null);
    }

    public TopBar(Context context, @Nullable AttributeSet attrs) {
        //调用三参
        this(context, attrs, 0);
    }

    public TopBar(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs);
    }

    private void init(Context context, AttributeSet attrs) {
        LayoutInflater.from(context).inflate(R.layout.topbar_content, this);
        tv_left = findViewById(R.id.left);
        tv_middle = findViewById(R.id.middle);
        tv_right = findViewById(R.id.right);

//        通过attrs设置相关属性
        setStyle(context, attrs);
    }

    private void setStyle(Context context, AttributeSet attrs) {
        if (attrs != null){
            TypedArray array = context.obtainStyledAttributes(attrs,R.styleable.TopBar);
//            获取title
            String title = array.getString(R.styleable.TopBar_titleText);
            tv_middle.setText(title);
            //获取左侧文字
            String left = array.getString(R.styleable.TopBar_leftText);
            tv_left.setText(left);
            int left_textColor = array.getColor(R.styleable.TopBar_leftTextColor, Color.WHITE);
            tv_left.setTextColor(left_textColor);

//            获取左侧图片
            Drawable lDrawable = array.getDrawable(R.styleable.TopBar_leftBackground);
            if (lDrawable != null){
                tv_left.setBackground(lDrawable);
            }
//
            array.recycle();
        }
    }
}
