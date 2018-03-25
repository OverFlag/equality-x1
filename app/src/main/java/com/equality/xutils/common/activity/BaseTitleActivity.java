package com.equality.xutils.common.activity;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.equality.xutils.R;
import com.equality.xutils.common.toolbar.AbstractToolBarActivity;

/**
 * Created by 46786 on 2018/3/25.
 */
public abstract class BaseTitleActivity extends AbstractToolBarActivity {

    private Context context;
    /**
     * 标题
     */
    private TextView titleName;
    /**
     * 左边返回
     */
    private ImageView titleBack;
    /**
     * 左边 textView
     */
    private TextView titleLeftText;
    /**
     * 标题最右边的 textView
     */
    private TextView titleRightText;
    /**
     * 从右到左第一个 imageView
     */
    private ImageView titleImageOne;
    /**
     * 从右到左第二个 imageView
     */
    private ImageView titleImageTwo;
    /**
     * 分割线
     */
    private View viewLine;

    @Override
    public void onCreateCustomToolBar(Toolbar toolbar) {
        super.onCreateCustomToolBar(toolbar);
        getLayoutInflater().inflate(R.layout.tx_layout_base_title, toolbar);
        titleName = (TextView) toolbar.findViewById(R.id.title_name);
        titleLeftText = (TextView) toolbar.findViewById(R.id.title_left);
        titleBack = (ImageView) toolbar.findViewById(R.id.title_back);
        titleRightText = (TextView) toolbar.findViewById(R.id.title_right_text);
        titleImageOne = (ImageView) toolbar.findViewById(R.id.title_right_image_one);
        titleImageTwo = (ImageView) toolbar.findViewById(R.id.title_right_image_two);
        viewLine = toolbar.findViewById(R.id.view_line);
        // 设置toolbar的颜色
        toolbar.setBackgroundColor(ContextCompat.getColor(this, getToolbarColor()));
        // 主题
        getTitleName().setTextColor(getResources().getColor(R.color.white));
        getBackImage().setImageResource(R.drawable.tx_arrow_back);
        // 返回监听
        titleBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finishActivity();
            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = this;
        setTitleName(titleName);
    }

    /**
     * 获取toolbar的颜色 你可以重写这个方法自定义
     */
    protected int getToolbarColor() {
        return R.color.colorPrimary;
    }

    /**
     * 标题名称
     */
    protected abstract String getTitleString();

    /**
     * 设置title的标题
     */
    protected void setTitleName(TextView titleName) {
        titleName.setText(getTitleString());
    }

    /**
     * 设置右侧菜单
     */
    protected void setTitleRight(String text, View.OnClickListener listener) {
        titleRightText.setVisibility(View.VISIBLE);
        titleRightText.setText(text);
        titleRightText.setOnClickListener(listener);
    }

    protected void setTitleRight(int textResId, View.OnClickListener listener) {
        setTitleRight(getString(textResId), listener);
    }

    /**
     * 左侧显示
     */
    protected void setTitleLeftVisible(Boolean isBackVisible, Boolean leftTextVisible) {
        // 它俩默认显示
        if (!isBackVisible) {
            titleBack.setVisibility(View.GONE);
        }
        if (!leftTextVisible) {
            titleLeftText.setVisibility(View.GONE);
        }
    }

    /**
     * 右侧显示    (右侧目前只能显示以下三种: 一个文字、一个图片、两个图片)
     */
    protected void setTitleRightVisible(Boolean oneImageVisible, Boolean rightTextVisible, Boolean twoImageVisible) {
        // 显示imageViewOne
        if (oneImageVisible) {
            titleImageOne.setVisibility(View.VISIBLE);
        }
        // 显示右边的文字
        if (rightTextVisible) {
            titleRightText.setVisibility(View.VISIBLE);
        }
        // 显示imageViewTwo
        if (twoImageVisible) {
            titleImageTwo.setVisibility(View.VISIBLE);
        }
    }

    protected void hideBack() {
        titleBack.setVisibility(View.GONE);
    }

    protected TextView getTitleName() {
        return titleName;
    }

    protected ImageView getBackImage() {
        return titleBack;
    }

    protected TextView getTitleLeft() {
        return titleLeftText;
    }

    protected TextView getTitleRight() {
        return titleRightText;
    }

    protected ImageView getTitleImageOne() {
        return titleImageOne;
    }

    protected ImageView getTitleImageTwo() {
        return titleImageTwo;
    }

    protected View getViewLine() {
        return viewLine;
    }

    /**
     * exit activity
     * maybe you can rewrite this method
     */
    protected void finishActivity() {
        finish();
    }

}