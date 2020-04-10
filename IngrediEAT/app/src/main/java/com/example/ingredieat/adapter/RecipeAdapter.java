package com.example.ingredieat.adapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ingredieat.R;
import com.example.ingredieat.base.Recipe;

import com.bumptech.glide.Glide;

import java.util.List;

public class RecipeAdapter extends RecyclerView.Adapter<RecipeAdapter.RecipeHolder> {
    private List<Recipe> recipes;
    private Context context;

    public RecipeAdapter(Context context, List<Recipe> list) {
        this.context = context;
        this.recipes = list;
    }

    @NonNull
    @Override
    public RecipeHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recipe_card, parent, false);

        return new RecipeHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final RecipeHolder holder, int position) {
        final Recipe recipe = recipes.get(position);
        holder.title.setText(recipe.getTitle());
        holder.likes.setText(recipe.getLikes());
        holder.rating.setRating(recipe.getStars());

        Glide.with(context).load(recipe.getImg()).into(holder.recipeImg);

        if (recipe.getLiked()) {
            holder.like.setVisibility(View.INVISIBLE);
            holder.liked.setVisibility(View.VISIBLE);
        }
        else{
            holder.like.setVisibility(View.VISIBLE);
            holder.liked.setVisibility(View.INVISIBLE);
        }
        holder.like.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                recipe.like();
                holder.like.setVisibility(View.INVISIBLE);
                holder.liked.setVisibility(View.VISIBLE);
                holder.likes.setText(recipe.getLikes());
            }
        });
        holder.liked.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                recipe.unlike();
                holder.like.setVisibility(View.VISIBLE);
                holder.liked.setVisibility(View.INVISIBLE);
                holder.likes.setText(recipe.getLikes());
            }
        });
        holder.recipeImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        holder.title.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }

    @Override
    public int getItemCount() {
        return recipes.size();
    }

    public class RecipeHolder extends RecyclerView.ViewHolder {
        private ImageButton recipeImg, like, liked;
        private TextView title, likes;
        private RatingBar rating;

        public RecipeHolder(View view) {
            super(view);
            recipeImg = view.findViewById(R.id.recipe_img);
            like = view.findViewById(R.id.like);
            liked = view.findViewById(R.id.liked);
            title = view.findViewById(R.id.recipe_title);
            likes = view.findViewById(R.id.like_count);
            rating = view.findViewById(R.id.rating_bar);
        }
    }

    public void setRecipes(List<Recipe> recipes){
        this.recipes = recipes;
    }
}
