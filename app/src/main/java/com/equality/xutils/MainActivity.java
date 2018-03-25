package com.equality.xutils;

import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.KeyEvent;
import android.widget.Toast;

import com.equality.xutils.common.activity.BaseActivity;
import com.equality.xutils.common.adapter.BasePageAdapter;
import com.equality.xutils.common.entity.TabEntity;
import com.equality.xutils.fragment.BluetoothFragment;
import com.equality.xutils.fragment.PersonalFragment;
import com.equality.xutils.fragment.ToolsFragment;
import com.equality.xutils.fragment.WIFIFragment;
import com.equality.xutils.utils.ActivityUtils;
import com.flyco.tablayout.CommonTabLayout;
import com.flyco.tablayout.listener.CustomTabEntity;
import com.flyco.tablayout.listener.OnTabSelectListener;

import java.util.ArrayList;

import butterknife.BindView;

/**
 * description
 *
 * @author WangYaoDong
 * @date 2018/3/23 11:50
 */
public class MainActivity extends BaseActivity {

    @BindView(R.id.vp_content)
    ViewPager viewPager;
    @BindView(R.id.tab)
    CommonTabLayout tabLayout;

    private String[] mTitles = {"诊断工具", "WIFI连接", "蓝牙连接", "个人设置"};
    private ArrayList<Fragment> mFragments = new ArrayList<>();
    private ArrayList<CustomTabEntity> mTabEntities = new ArrayList<>();
    private int[] mIconSelectIds = {
            R.drawable.ic_main_tools, R.drawable.ic_main_wifi,
            R.drawable.ic_main_bluetooth, R.drawable.ic_main_person};
    private int[] mIconUnSelectIds = {
            R.drawable.ic_main_tools_normal, R.drawable.ic_main_wifi_normal,
            R.drawable.ic_main_bluetooth_normal, R.drawable.ic_main_person_normal};

    @Override
    public int getViewByXml() {
        return R.layout.activity_main;
    }

    @Override
    public void initView() {
        mFragments.add(new ToolsFragment());
        mFragments.add(new WIFIFragment());
        mFragments.add(new BluetoothFragment());
        mFragments.add(new PersonalFragment());
        for (int i = 0; i < mTitles.length; i++) {
            mTabEntities.add(new TabEntity(mTitles[i], mIconSelectIds[i], mIconUnSelectIds[i]));
        }

        viewPager.setAdapter(new BasePageAdapter(getSupportFragmentManager(), mFragments, mTitles));
        viewPager.setOffscreenPageLimit(mTitles.length - 1);

        tabLayout.setTabData(mTabEntities);
        tabLayout.setOnTabSelectListener(new OnTabSelectListener() {
            @Override
            public void onTabSelect(int position) {
                viewPager.setCurrentItem(position);
            }

            @Override
            public void onTabReselect(int position) {
            }
        });

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                tabLayout.setCurrentTab(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        viewPager.setCurrentItem(0);
    }

    @Override
    public void initData() {

    }

    /* ************************** 双击退出 begin ********************************** */

    private long exitTime = 0;

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK && event.getAction() == KeyEvent.ACTION_DOWN) {
            if ((System.currentTimeMillis() - exitTime) > 2000) {
                Toast.makeText(getApplicationContext(), R.string.tip_press_again_to_exit,
                        Toast.LENGTH_SHORT).show();
                exitTime = System.currentTimeMillis();
            } else {
                overridePendingTransition(android.R.anim.slide_in_left, android.R.anim.slide_out_right);
                // 结束退出
                ActivityUtils.getInstance().finishAllActivity();
                // ActivityUtils.getInstance().AppExit(this);
            }
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
    /* ************************** 双击退出 end ********************************** */
}
