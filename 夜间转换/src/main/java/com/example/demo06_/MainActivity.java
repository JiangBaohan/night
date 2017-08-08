package com.example.demo06_;

import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

/**
 * 第一种设置夜间模式:通过重新给Activity设置主题,然后销毁Activity,
 * 在创建Activity,重新设置的主题才有效
 * <p>
 * 搭建环境
 * 1.再values中的colors里设置颜色属性
 * 2.再style.xml中定义两组主题,也就是日间主题和夜间主题
 * 3.创建attrs.xml文件
 * <p>
 * 使用代码
 * 4.需要夜间模式的布局引用attr自定义属性
 * 5.java代码
 * a.判断存储的类型;
 * b.点击事件,根据类型进行日夜的切换
 */
public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView bt_change;
    //默认是日间模式
    private int theme = R.style.AppTheme;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //判断是否有主题存储,必须再setContentView之前
        if (savedInstanceState != null) {
            theme = savedInstanceState.getInt("theme");
            setTheme(theme);
        }
        setContentView(R.layout.activity_main);
        //设置点击事件
        bt_change = (TextView) findViewById(R.id.bt_change);
        bt_change.setOnClickListener(this);


    }

    /**
     * 根据点击事件,完成日间模式切换代码.
     */
    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            //点击,完成日渐模式切换代码
            case R.id.bt_change:
                //三元运算符判断:true执行第一个:false执行第二个
                //三元运算符比if else效率高
                theme = (theme == R.style.AppTheme) ? R.style.NightAppTheme : R.style.AppTheme;
                //重新创建
                recreate();
                break;

            default:
                break;
        }
    }

    /**
     * 存
     *
     * @param outState
     */
    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("theme", theme);
    }

    /**
     * 取
     *
     * @param savedInstanceState
     */
    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        theme = savedInstanceState.getInt("theme");
    }
}
