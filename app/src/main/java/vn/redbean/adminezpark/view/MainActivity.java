package vn.redbean.adminezpark.view;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.google.firebase.messaging.FirebaseMessaging;
import com.wang.avi.AVLoadingIndicatorView;

import java.util.ArrayList;
import java.util.List;

import vn.redbean.adminezpark.R;
import vn.redbean.adminezpark.adapter.OrderAdapter;
import vn.redbean.adminezpark.model.Data;
import vn.redbean.adminezpark.presenter.OrderDetailsPresenterImpl;
import vn.redbean.adminezpark.utils.Config;
import vn.redbean.adminezpark.utils.NotificationUtils;

public class MainActivity extends AppCompatActivity implements OrderDetailsView {

    private static final String TAG = MainActivity.class.getSimpleName();

    private BroadcastReceiver mRegistrationBroadcastReceiver;
    private OrderAdapter adapter;
    private OrderDetailsPresenterImpl presenter;

    private RecyclerView recyclerView;
    private AVLoadingIndicatorView loading;
    private SwipeRefreshLayout swipeRefreshLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        presenter = new OrderDetailsPresenterImpl(this);
        presenter.create();
    }

    @Override
    public void onSetupControls() {
        swipeRefreshLayout = findViewById(R.id.swipeRefreshLayout);

        adapter = new OrderAdapter(new ArrayList<>());
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);

        loading = findViewById(R.id.loading);
    }

    @Override
    public void onSetupEvents() {
        mRegistrationBroadcastReceiver = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                if (intent.getAction().equals(Config.REGISTRATION_COMPLETE)) {
                    FirebaseMessaging.getInstance().subscribeToTopic(Config.TOPIC_GLOBAL);
                    displayFirebaseRegId();
                } else if (intent.getAction().equals(Config.PUSH_NOTIFICATION)) {
                    String message = intent.getStringExtra("message");
                    presenter.getListOrderDetails();
                }
            }
        };
        displayFirebaseRegId();

        swipeRefreshLayout.setOnRefreshListener(() -> {
            presenter.getListOrderDetails();
        });
    }

    @Override
    public void onGettingListOrder() {
        adapter.clear();
        swipeRefreshLayout.setRefreshing(false);
        recyclerView.setVisibility(View.GONE);
        loading.setVisibility(View.VISIBLE);
    }

    @Override
    public void onGetListOrderDetailsSuccess(String message, boolean result, List<Data> list) {
        swipeRefreshLayout.setRefreshing(false);
        loading.setVisibility(View.GONE);
        recyclerView.setVisibility(View.VISIBLE);

        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
        if (result) {
            adapter.newList(list);
        }
    }

    @SuppressLint("SetTextI18n")
    private void displayFirebaseRegId() {
        SharedPreferences pref = getApplicationContext().getSharedPreferences(Config.SHARED_PREF, 0);
        String regId = pref.getString("regId", null);
        if (!TextUtils.isEmpty(regId))
            Log.e(TAG, "Firebase reg id: " + regId);
    }

    @Override
    protected void onResume() {
        super.onResume();
        LocalBroadcastManager.getInstance(this).registerReceiver(mRegistrationBroadcastReceiver, new IntentFilter(Config.REGISTRATION_COMPLETE));
        LocalBroadcastManager.getInstance(this).registerReceiver(mRegistrationBroadcastReceiver, new IntentFilter(Config.PUSH_NOTIFICATION));
        NotificationUtils.clearNotifications(getApplicationContext());
        presenter.getListOrderDetails();
    }

    @Override
    protected void onPause() {
        LocalBroadcastManager.getInstance(this).unregisterReceiver(mRegistrationBroadcastReceiver);
        super.onPause();
    }
}
