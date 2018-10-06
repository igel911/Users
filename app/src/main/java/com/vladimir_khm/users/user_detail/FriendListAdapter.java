package com.vladimir_khm.users.user_detail;

import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.vladimir_khm.users.R;
import com.vladimir_khm.users.databinding.FriendItemBinding;
import com.vladimir_khm.users.model.Friend;

import java.util.List;

public class FriendListAdapter extends RecyclerView.Adapter<FriendListAdapter.FriendHolder> {

    private List<Friend> mDataSet;


    FriendListAdapter(List<Friend> dataSet) {
        mDataSet = dataSet;
    }

    @NonNull
    @Override
    public FriendHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new FriendHolder(
                DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()),
                        R.layout.friend_item,
                        parent,
                        false));
    }

    @Override
    public void onBindViewHolder(@NonNull FriendHolder holder, int position) {
        holder.bind(mDataSet.get(position));
    }

    @Override
    public int getItemCount() {
        return mDataSet.size();
    }

    static class FriendHolder extends RecyclerView.ViewHolder {

        private FriendItemBinding mBinding;


        FriendHolder(FriendItemBinding binding) {
            super(binding.getRoot());
            mBinding = binding;
        }

        void bind(Friend friend) {
            mBinding.setFriend(friend);
            mBinding.executePendingBindings();
        }
    }
}