package com.demo.user;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button mCreateAccountBt;
    private AccountManager mAccountManager;
    private RecyclerView mAccountRlv;
    private AccountAdapter mAccountAdapter;
    private View mSearchAccountBt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mAccountManager = AccountManager.get(this);

        mCreateAccountBt = findViewById(R.id.m_create_account_bt);
        mSearchAccountBt = findViewById(R.id.m_search_account_bt);
        mCreateAccountBt.setOnClickListener(this);
        mSearchAccountBt.setOnClickListener(this);

        mAccountRlv = findViewById(R.id.m_account_list_rlv);
        mAccountRlv.setLayoutManager(new LinearLayoutManager(this));
        mAccountAdapter = new AccountAdapter();
        mAccountRlv.setAdapter(mAccountAdapter);
        //android.os.Process.killProcess(android.os.Process.myPid());
        // System.exit(0);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.m_search_account_bt:
                searchAccount();
                break;
            case R.id.m_create_account_bt:
                createAccount();
                break;
        }
    }

    private void searchAccount() {
        Account[] accounts = mAccountManager.getAccounts();
        Log.d("picher", "account length:" + accounts.length);
        mAccountAdapter.setDate(accounts);
    }

    private void createAccount() {
        Account picherAccount = new Account("picher", "com.patac");
        mAccountManager.addAccountExplicitly(picherAccount, "123456", null);
    }

    private void deldteAccount() {

    }

    private void switchAccount() {

    }


}
