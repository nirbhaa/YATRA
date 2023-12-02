package com.example.yatra;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.yatra.Adapter.ImageSliderAdapter;
import com.example.yatra.Adapter.OfferAdapter;
import com.example.yatra.Adapter.Popularbikeadapter;
import com.example.yatra.JSONSchemas.BikesRespose;
import com.example.yatra.JSONSchemas.Offer.OfferModel;
import com.example.yatra.JSONSchemas.SliderImage.AdapterSlider;
import com.example.yatra.Models.Offerlist;
import com.example.yatra.Models.PopularBikeList;
import com.example.yatra.retrofit.ApiService;
import com.example.yatra.retrofit.ApiUtil;
import com.google.android.material.slider.Slider;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link OfferFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class OfferFragment extends Fragment {

    RecyclerView recyclerView;
    List<Offerlist> lists;
    OfferAdapter adapter;
    Context mContext;
    LinearLayoutManager layoutManager;
    ImageView img;
    private View view;
    RecyclerView offeradd;
    OfferAdapter offerAdapter;




    LinearLayoutManager linearLayoutManager;


    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public OfferFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment OfferFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static OfferFragment newInstance(String param1, String param2) {
        OfferFragment fragment = new OfferFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        //initData();
        view = inflater.inflate(R.layout.fragment_offer, container, false);
        initRecycleView(view);
        return view;
    }
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mContext = context;
    }

    private void initRecycleView(View view) {
//        recyclerView = view.findViewById(R.id.favoritesView);
//        layoutManager=new LinearLayoutManager(mContext);
//        layoutManager.setOrientation(RecyclerView.VERTICAL);
//        recyclerView.setLayoutManager(layoutManager);
//        adapter = new OfferAdapter(lists);
//        recyclerView.setAdapter(adapter);
//        adapter.notifyDataSetChanged();

        ApiService apiService = ApiUtil.getApiService();
        apiService.getOffer().enqueue(new Callback<OfferModel>() {
            @Override
            public void onResponse(Call<OfferModel> call, Response<OfferModel> response) {
                if (response.isSuccessful()) {
                    OfferModel offerModel = response.body();
                    offeradd = view.findViewById(R.id.offerView);
                    offerAdapter = new OfferAdapter(offerModel.getData(), mContext);
                    linearLayoutManager = new LinearLayoutManager(mContext);
                    linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
                    offeradd.setLayoutManager(linearLayoutManager);
                    offeradd.setAdapter(offerAdapter);
                    offerAdapter.notifyDataSetChanged();
                }
            }
            @Override
            public void onFailure(Call<OfferModel> call, Throwable t) {

            }
        });



    }


    //static design
//    private void initData() {
//        lists = new ArrayList<>();
//        lists.add(new Offerlist(R.drawable.offer_2,"Our  offer will be start from Ashadh 2080.\n" +
//                "Hope you all take this offer . "));
//
//    }
}
