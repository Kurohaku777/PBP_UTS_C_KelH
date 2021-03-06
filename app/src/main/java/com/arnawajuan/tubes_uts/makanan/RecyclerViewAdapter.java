package com.arnawajuan.tubes_uts.makanan;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.arnawajuan.tubes_uts.databinding.AdapterRecyclerViewBinding;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {
    private Context context;
    private List<Makanan> result;

    public RecyclerViewAdapter(){}

    public RecyclerViewAdapter(Context context, List<Makanan> result){
        this.context = context;
        this.result = result;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        AdapterRecyclerViewBinding binding = AdapterRecyclerViewBinding.inflate(layoutInflater, parent, false);
        return new MyViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {
        Makanan mkn = result.get(position);
        holder.bind(mkn);
    }

    @Override
    public int getItemCount() {
        return result.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private AdapterRecyclerViewBinding binding;

        public MyViewHolder(AdapterRecyclerViewBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void bind(Makanan M) {
            binding.setMkn(M);
            binding.executePendingBindings();
        }

        public void onClick(View view) {
            Toast.makeText(context, "You touch me?", Toast.LENGTH_SHORT).show();
        }
    }
}