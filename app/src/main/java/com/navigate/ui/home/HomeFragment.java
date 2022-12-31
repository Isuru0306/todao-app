package com.navigate.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.navigate.R;
import com.navigate.adapter.ItemAdapter;
import com.navigate.model.Hoteldata;
import com.navigate.adapter.GalleryAdapter;
import com.navigate.model.DBTraveller;
import com.navigate.model.ItemData;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {

//    private FragmentHomeBinding binding;
//
//    public View onCreateView(@NonNull LayoutInflater inflater,
//                             ViewGroup container, Bundle savedInstanceState) {
//        HomeViewModel homeViewModel =
//                new ViewModelProvider(this).get(HomeViewModel.class);
//
//        binding = FragmentHomeBinding.inflate(inflater, container, false);
//        View root = binding.getRoot();
//
//        final TextView textView = binding.ssdsds;
//        final RecyclerView textView1 = binding.topPlacesRecycler;
//        homeViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
//        homeViewModel.getRecyclerView().observe(getViewLifecycleOwner(), textView1::);
//
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
    public static  HomeFragment homeFragments(){

        HomeFragment homeFragment = new HomeFragment();
        return  homeFragment;
    }

    @NonNull
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedIntanceState){
        View rootView = inflater.inflate(R.layout.fragment_home, null);

        rv = (RecyclerView) rootView.findViewById(R.id.top_places_recycler);
        rv.setLayoutManager(new LinearLayoutManager(getActivity()));


        DBTraveller dbTraveller = new DBTraveller(getContext());
        ArrayList<Hoteldata> hotel_data = dbTraveller.getDataHotel();
        List<ItemData> itemDataList = new ArrayList<>();

//        System.out.println(hotel_data.size());

        for (int i=0; i< hotel_data.size(); i++){
            System.out.println(hotel_data.get(i).getUrlhotel());
                itemDataList.add(new ItemData(
                        hotel_data.get(i).getHotelname() + ", "+ hotel_data.get(i).getLocation(),
                        hotel_data.get(i).getRatingshotels() ,
                        "RS."+ hotel_data.get(i).getPricehotes(),
                        hotel_data.get(i).getUrlhotel(),
                        "NUll",
                        "0"));
        }

        rv.setAdapter(new ItemAdapter(getActivity(), itemDataList));
//        rv.setAdapter(new MyAdapter(getActivity(), array));
        return rootView;
    }


    @Override
    public String toString(){
        return "HomeFragment";
    }


}