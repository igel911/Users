package com.vladimir_khm.users.main;

import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.vladimir_khm.users.R;
import com.vladimir_khm.users.databinding.UserItemBinding;
import com.vladimir_khm.users.model.User;

import java.util.List;

public class UsersAdapter extends RecyclerView.Adapter<UsersAdapter.UserHolder> {

    private OnItemClickListener mListener;
    private List<User> mData;


    UsersAdapter(List<User> dataSet, OnItemClickListener listener) {
        mData = dataSet;
        mListener = listener;
    }

    @NonNull
    @Override
    public UserHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        UserItemBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()),
                R.layout.user_item,
                parent,
                false);
        UserHolder viewHolder = new UserHolder(binding);
        binding.getRoot().setOnClickListener(
                v -> mListener.onItemClick(mData.get(viewHolder.getAdapterPosition())));
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull UserHolder holder, int position) {
        holder.bind(mData.get(position));
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    static class UserHolder extends RecyclerView.ViewHolder {

        private UserItemBinding mBinding;


        UserHolder(UserItemBinding binding) {
            super(binding.getRoot());
            mBinding = binding;
        }

        void bind(User user) {
            mBinding.setUser(user);
            mBinding.executePendingBindings();
        }
    }
}
