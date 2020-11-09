package com.journaldev.retrofitintro;

public class DashboardActivity extends BaseActivity {


    @Override
    int getContentViewId() {
        return R.layout.activity_dashboard;
    }

    @Override
    int getNavigationMenuItemId() {
        return R.id.navigation_dashboard;
    }

}
