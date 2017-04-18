package com.liucheng.android.criminalintent;

import android.support.v4.app.Fragment;

/**
 * Created by liucheng on 2017/4/11.
 */

public class CrimeListActivity extends SingleFragmentActivity {
    @Override
    protected Fragment createFragment() {
        return new CrimeListFragment();
    }
}
