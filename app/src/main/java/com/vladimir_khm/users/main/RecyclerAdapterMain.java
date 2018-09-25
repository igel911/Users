package com.vladimir_khm.users.main;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.vladimir_khm.users.R;
import com.vladimir_khm.users.model.User;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RecyclerAdapterMain extends RecyclerView.Adapter<RecyclerAdapterMain.ViewHolder> {

    private OnItemClickListener mListener;
    private List<User> mData;

    RecyclerAdapterMain(List<User> dataSet, OnItemClickListener listener) {
        mData = dataSet;
        mListener = listener;
    }

    @NonNull
    @Override
    public RecyclerAdapterMain.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.rv_main_layout, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        view.setOnClickListener(v -> mListener.onItemClick(mData.get(viewHolder.getAdapterPosition())));
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerAdapterMain.ViewHolder holder, int position) {
        User user = mData.get(position);
        holder.mTextViewName.setText(user.getName());
        holder.mTextViewCompany.setText(user.getCompany());
        holder.mTextViewGender.setText(user.getGender());
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.tvUserNameMain) TextView mTextViewName;
        @BindView(R.id.tvUserCompanyMain) TextView mTextViewCompany;
        @BindView(R.id.tvUserGenderMain) TextView mTextViewGender;

        ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }
}
