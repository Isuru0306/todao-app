package com.navigate.ui.add;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.navigate.R;
import com.navigate.model.DBTraveller;

public class AddHoFragment extends Fragment {

//    private FragmentAddHoBinding binding;
//
//    public View onCreateView(@NonNull LayoutInflater inflater,
//                             ViewGroup container, Bundle savedInstanceState) {
//        AddHoViewModel addHoViewModel =
//                new ViewModelProvider(this).get(AddHoViewModel.class);
//
//        binding = FragmentAddHoBinding.inflate(inflater, container, false);
//        View root = binding.getRoot();
//
////        final TextView textView = binding.textAddho;
////        addHoViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
//        return root;
//    }
//
//    @Override
//    public void onDestroyView() {
//        super.onDestroyView();
//        binding = null;
//    }

    @NonNull
    public static AddHoFragment homeFragments(){

        AddHoFragment addHoFragment = new AddHoFragment();
        return  addHoFragment;
    }

    @NonNull
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedIntanceState){
        View rootView = inflater.inflate(R.layout.fragment_add_ho, null);

        TextView nameHotel = rootView.findViewById(R.id.hotel_name_t);
        TextView locationhotel = rootView.findViewById(R.id.location_t);
        TextView urlImage = rootView.findViewById(R.id.hotel_image_url);
        TextView hotelRating = rootView.findViewById(R.id.hotel_ratings);
        TextView hotelPrice = rootView.findViewById(R.id.hotel_price);

        Button addHoteBtn = rootView.findViewById(R.id.add_hotel_button);
        DBTraveller dbTraveller = new DBTraveller(getContext());
        addHoteBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               String name_hotel = nameHotel.getText().toString();
               String location_hotel = locationhotel.getText().toString();
               String url_image = urlImage.getText().toString();
               String hotel_rating = hotelRating.getText().toString();
               String hotel_price = hotelPrice.getText().toString();

               if (name_hotel.isEmpty() || location_hotel.isEmpty() ||
                       url_image.isEmpty() || hotel_rating.isEmpty() || hotel_price.isEmpty()){
                   Toast.makeText(getContext(), "All fields required ", Toast.LENGTH_SHORT).show();
               }else{

                   dbTraveller.addNewHotel(name_hotel, location_hotel, url_image, hotel_rating, hotel_price );
                   Toast.makeText(getContext(), "Hotel added successfully", Toast.LENGTH_SHORT).show();

                   nameHotel.setText("");
                   locationhotel.setText("");
                   urlImage.setText("");
                   hotelRating.setText("");
                   hotelPrice.setText("");
               }
            }
        });


//        rv.setAdapter(new MyAdapter(getActivity(), array));
        return rootView;
    }


    @Override
    public String toString(){
        return "HomeFragment";
    }


}