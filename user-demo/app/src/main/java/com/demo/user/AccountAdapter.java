package com.demo.user;

import android.accounts.Account;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class AccountAdapter extends RecyclerView.Adapter<AccountAdapter.ViewHolder> {

    private Account[] mDate;

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.user_recycle_account_item, parent, true));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Account account = mDate[position];
        holder.textView.setText(account.toString());
    }

    @Override
    public int getItemCount() {
        return mDate!=null?mDate.length:0;
    }

    public void setDate(Account[] accounts) {
        this.mDate = accounts;
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        private TextView textView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.user_recycle_account_name_tv);
        }
    }

}
