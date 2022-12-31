package com.navigate.ui.gallery;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.navigate.R;
import com.navigate.adapter.GalleryAdapter;
import com.navigate.databinding.FragmentGalleryBinding;
import com.navigate.model.DBTraveller;
import com.navigate.model.Hoteldata;
import com.navigate.model.ItemData;

import java.util.ArrayList;
import java.util.List;

public class GalleryFragment extends Fragment {

//    private FragmentGalleryBinding binding;
//
//    public View onCreateView(@NonNull LayoutInflater inflater,
//                             ViewGroup container, Bundle savedInstanceState) {
//        GalleryViewModel galleryViewModel =
//                new ViewModelProvider(this).get(GalleryViewModel.class);
//
//        binding = FragmentGalleryBinding.inflate(inflater, container, false);
//        View root = binding.getRoot();
//
////        final TextView textView = binding.textGallery;
////        galleryViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
//        return root;
//    }
//
//    @Override
//    public void onDestroyView() {
//        super.onDestroyView();
//        binding = null;
//    }

    private RecyclerView rv;


    @NonNull
    public static GalleryFragment galleryFragment(){

        GalleryFragment galleryFragment = new GalleryFragment();
        return  galleryFragment;
    }

    @NonNull
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedIntanceState){
        View rootView = inflater.inflate(R.layout.fragment_gallery, null);

        rv = (RecyclerView) rootView.findViewById(R.id.gallery_recycler);
        rv.setLayoutManager(new GridLayoutManager(getActivity(), 2));


        DBTraveller dbTraveller = new DBTraveller(getContext());
        ArrayList<Hoteldata> hotel_data = dbTraveller.getDataHotel();
        List<ItemData> itemDataList = new ArrayList<>();

//        System.out.println(hotel_data.size());

        for (int i=0; i< hotel_data.size(); i++){
            itemDataList.add(new ItemData(hotel_data.get(i).getUrlhotel()));
        }

        rv.setAdapter(new GalleryAdapter(getActivity(), itemDataList));
//        rv.setAdapter(new MyAdapter(getActivity(), array));
        return rootView;
    }


    @Override
    public String toString(){
        return "HomeFragment";
    }





}