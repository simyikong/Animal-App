package com.example.animalapp.ui.slideshow;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;
import androidx.viewpager2.widget.ViewPager2;

import com.example.animalapp.R;
import com.example.animalapp.databinding.FragmentSlideshowBinding;

import java.util.Arrays;
import java.util.List;

public class SlideshowFragment extends Fragment {

    private ViewPager2 viewPager;
    private FragmentSlideshowBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        SlideshowViewModel slideshowViewModel =
                new ViewModelProvider(this).get(SlideshowViewModel.class);

        binding = FragmentSlideshowBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

//        final TextView textView = binding.textSlideshow;
//        slideshowViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ImageButton backToHomeButton = view.findViewById(R.id.backToHomeButton);

        List<Integer> imagePaths = Arrays.asList(
                R.drawable.image1,
                R.drawable.image2);

        // Set up ViewPager Adapter
        SlideshowAdapter slideshowAdapter = new SlideshowAdapter(imagePaths);
        viewPager.setAdapter(slideshowAdapter);

        // Set up click listener
        backToHomeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Navigate back to HomeFragment
                Navigation.findNavController(requireView()).navigateUp();
            }
        });

        ImageButton buttonNext = view.findViewById(R.id.buttonNext);

        buttonNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Navigate to the next image in the slideshow
                int currentItem = viewPager.getCurrentItem();
                if (currentItem < slideshowAdapter.getItemCount() - 1) {
                    viewPager.setCurrentItem(currentItem + 1);
                }
            }
        });
    }
}