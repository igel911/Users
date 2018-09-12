package com.vladimir_khm.users.user_detail;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.vladimir_khm.users.R;
import com.vladimir_khm.users.model.Friend;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RecyclerAdapterDetail extends RecyclerView.Adapter<RecyclerAdapterDetail.ViewHolder> {

    private List<Friend> mData;


    RecyclerAdapterDetail(List<Friend> dataSet) {
        mData = dataSet;
    }

    @NonNull
    @Override
    public RecyclerAdapterDetail.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.rv_detail_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerAdapterDetail.ViewHolder holder, int position) {
        Friend friend = mData.get(position);
        holder.mTextViewName.setText(friend.getName());
        holder.mTextViewId.setText(String.valueOf(friend.getId()));
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.tvFriendNameDetail) TextView mTextViewName;
        @BindView(R.id.tvFriendIDDetail) TextView mTextViewId;


        ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }
}