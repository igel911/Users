package com.vladimir_khm.users.user_detail;

import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.vladimir_khm.users.R;
import com.vladimir_khm.users.databinding.TagItemBinding;

import java.util.List;

public class TagListAdapter extends RecyclerView.Adapter<TagListAdapter.TagHolder> {

    private List<String> mDataSet;


    TagListAdapter(List<String> dataSet) {
        mDataSet = dataSet;
    }

    @NonNull
    @Override
    public TagHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new TagHolder(
                DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()),
                        R.layout.tag_item,
                        parent,
                        false));
    }

    @Override
    public void onBindViewHolder(@NonNull TagHolder holder, int position) {
        holder.bind(mDataSet.get(position));
    }

    @Override
    public int getItemCount() {
        return mDataSet.size();
    }

    static class TagHolder extends RecyclerView.ViewHolder {

        private TagItemBinding mBinding;


        TagHolder(TagItemBinding binding) {
            super(binding.getRoot());
            mBinding = binding;
        }

        void bind(String tag) {
            mBinding.setTag(tag);
            mBinding.executePendingBindings();
        }
    }
}
