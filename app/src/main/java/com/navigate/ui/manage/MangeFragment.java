package com.navigate.ui.manage;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.navigate.R;
import com.navigate.adapter.EditAdapter;
import com.navigate.model.DBTraveller;
import com.navigate.model.Hoteldata;
import com.navigate.model.ItemData;

import java.util.ArrayList;
import java.util.List;
//import com.navigate.ui.home.HomeViewModel;

public class MangeFragment extends Fragment {

//    private FragmentMangeBinding binding;
//
//    public View onCreateView(@NonNull LayoutInflater inflater,
//                             ViewGroup container, Bundle savedInstanceState) {
//        MangeViewModel mangeViewModel =
//                new ViewModelProvider(this).get(MangeViewModel.class);
//
//        binding = FragmentMangeBinding.inflate(inflater, container, false);
//        View root = binding.getRoot();
//
//        final TextView textView = binding.managetest;
//        mangeViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
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
    public static MangeFragment mangeFragment(){

        MangeFragment mangeFragment = new MangeFragment();
        return  mangeFragment;
    }

    @NonNull
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedIntanceState){
        View rootView = inflater.inflate(R.layout.fragment_mange, null);

        rv = (RecyclerView) rootView.findViewById(R.id.edit_recycle_view);
        rv.setLayoutManager(new LinearLayoutManager(getActivity()));


        DBTraveller dbTraveller = new DBTraveller(getContext());
        ArrayList<Hoteldata> hotel_data = dbTraveller.getDataHotel();
        List<ItemData> itemDataList = new ArrayList<>();

//        System.out.println(hotel_data.size());

        for (int i=0; i< hotel_data.size(); i++){
            itemDataList.add(new ItemData(
                    hotel_data.get(i).getHotelname(),
                    hotel_data.get(i).getLocation(),
                    hotel_data.get(i).getId()));
        }
        rv.setAdapter(new EditAdapter(getActivity(), itemDataList));


        return rootView;
    }


    @Override
    public String toString(){
        return "HomeFragment";
    }

}