package com.example.e_bookapp.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.e_bookapp.MyAppication;
import com.example.e_bookapp.activities.DashboardUserActivity;
import com.example.e_bookapp.activities.PdfListAdminActivity;
import com.example.e_bookapp.activities.ShoppingCartActivity;
import com.example.e_bookapp.databinding.RowCartBinding;
import com.example.e_bookapp.databinding.RowCategoryBinding;
import com.example.e_bookapp.models.ModelCart;
import com.example.e_bookapp.models.ModelCategory;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.HashMap;

public class AdapterCart extends RecyclerView.Adapter<AdapterCart.HolderCart> {

    private Context context;
    public ArrayList<ModelCart> cartArrayList;
    private RowCartBinding binding;

    public AdapterCart(Context context, ArrayList<ModelCart> cartArrayList) {
        this.context = context;
        this.cartArrayList = cartArrayList;
    }

    @NonNull
    @Override
    public AdapterCart.HolderCart onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        binding = RowCartBinding.inflate(LayoutInflater.from(context),parent,false);
        return new AdapterCart.HolderCart(binding.getRoot());

    }

    @Override
    public void onBindViewHolder(@NonNull AdapterCart.HolderCart holder, int position) {
        ModelCart model = cartArrayList.get(position);
        String bookId = model.getBookId();
        String categoryId = model.getCategoryId();
        String title = model.getTitle();;
        String uid = model.getUid();

        holder.categoryTv.setText(title);


        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, ShoppingCartActivity.class);
                intent.putExtra("bookId", bookId);
                intent.putExtra("categoryTitle", title);
                context.startActivity(intent);
            }
        });

    }


    @Override
    public int getItemCount() {
        return cartArrayList.size();
    }


    public class HolderCart extends RecyclerView.ViewHolder {
        TextView categoryTv;

        public HolderCart(@NonNull View itemView) {
            super(itemView);
            categoryTv = binding.categoryTv;
        }
    }
}
