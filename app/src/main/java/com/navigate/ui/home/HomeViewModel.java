//package com.navigate.ui.home;
//
//import androidx.lifecycle.LiveData;
//import androidx.lifecycle.MutableLiveData;
//import androidx.lifecycle.ViewModel;
//import androidx.recyclerview.widget.RecyclerView;
//
//import com.navigate.R;
//import com.navigate.adapter.ItemAdapter;
//import com.navigate.model.ItemData;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class HomeViewModel extends ViewModel {
//
//    private final MutableLiveData<String> mText;
//    private final MutableLiveData<String> mText1;
//    private final MutableLiveData<RecyclerView> itemdata;
//
//    RecyclerView recentRecycler, topPlacesRecycler;
//    ItemAdapter itemAdapter;
//    private long pressedTime;
//
//    public HomeViewModel() {
//        mText = new MutableLiveData<>();
//        mText1 = new MutableLiveData<>();
//        itemdata = new MutableLiveData<>();
//
//        List<ItemData> itemDataList = new ArrayList<>();
//        itemDataList.add(new ItemData(
//                "Mask",
//                "5.00",
//                "$70",
//                R.drawable.img,
//                "At a time when the people",
//                "7"));
//
//        mText.setValue("This is home fragment");
//        topPlacesRecycler = topPlacesRecycler.findViewById(R.id.top_places_recycler);
//        itemAdapter = new ItemAdapter(recentRecycler.getContext(), itemDataList);
//        topPlacesRecycler.setAdapter(itemAdapter);
//
//        mText.setValue("Hi isuru");
//        itemdata.setValue(topPlacesRecycler);
//    }
//
//    public LiveData<String> getText() {
//        return mText;
//    }
//
//    public LiveData<RecyclerView> getRecyclerView() {
//        return itemdata;
//    }
//
//}