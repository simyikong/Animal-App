package com.example.animalapp.ui.slideshow;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.animalapp.R;

import java.util.List;

public class SlideshowAdapter extends RecyclerView.Adapter<SlideshowAdapter.SlideshowViewHolder> {

    private List<Integer> images; // Replace with your image data (e.g., list of resource IDs)

    public SlideshowAdapter(List<Integer> images) {
        this.images = images;
    }

    @NonNull
    @Override
    public SlideshowViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Inflate the item_slideshow.xml layout for each item
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_slideshow, parent, false);
        return new SlideshowViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SlideshowViewHolder holder, int position) {
        // Bind the image data to the ImageView in each item
        holder.bind(images.get(position));
    }

    @Override
    public int getItemCount() {
        return images.size();
    }

    static class SlideshowViewHolder extends RecyclerView.ViewHolder {

        private ImageView imageView;

        public SlideshowViewHolder(@NonNull View itemView) {
            super(itemView);
            // Find the ImageView in the inflated layout
            imageView = itemView.findViewById(R.id.imageView);
        }

        public void bind(int imageResource) {
            // Set the image resource to the ImageView
            imageView.setImageResource(imageResource);
        }
    }
}
