package com.example.yatra;

import static android.content.Context.MODE_PRIVATE;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.yatra.Adapter.Popularbikeadapter;
import com.example.yatra.Adapter.UserBookingAdapter;
import com.example.yatra.Adapter.favoritesAdapter;
import com.example.yatra.JSONSchemas.UserBokingModel.UserBookingModel;
import com.example.yatra.JSONSchemas.favoriteBikeByUser.favoriteBikeByUser;
import com.example.yatra.Models.favoriteslist;
import com.example.yatra.activity.MyBookingDetailsActivity;
import com.example.yatra.retrofit.ApiService;
import com.example.yatra.retrofit.ApiUtil;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FavoriteFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FavoriteFragment extends Fragment {

    RecyclerView favoritesView;
    List<favoriteslist> lists;
    favoritesAdapter adapter;
    Context mContext;
    LinearLayoutManager linearLayoutManager;
    ImageView img;
    private View view;





    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public FavoriteFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FavoriteFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static FavoriteFragment newInstance(String param1, String param2) {
        FavoriteFragment fragment = new FavoriteFragment();
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
        // Inflate the layout for this fragment
       // initData();
         view = inflater.inflate(R.layout.fragment_favorite, container, false);
    initRecycleView(view);
    return view;
    }

    private void initRecycleView(View view) {

        SharedPreferences sharedPreferences = getActivity().getSharedPreferences("USER", MODE_PRIVATE);
        // SharedPreferences.Editor sh = sharedPreferences.edit();
        String token = sharedPreferences.getString("TOKENLOGIN", "");
        // Log.v("token",token);
        // fetchPosts(token = "Bearer ${sessionManager.fetchAuthToken()}")
        ApiService apiService = ApiUtil.getApiService();
        apiService.getfavoriteBikeByUser(token = "Bearer " + token).enqueue(new Callback<favoriteBikeByUser>() {
            @Override
            public void onResponse(Call<favoriteBikeByUser> call, Response<favoriteBikeByUser> response) {
                if (response.code() == 200) {
                    favoriteBikeByUser fav = response.body();
                    favoritesView = view.findViewById(R.id.favoritesView);
                    adapter = new favoritesAdapter(fav.getFavorites(), mContext);
                    linearLayoutManager = new LinearLayoutManager(mContext);
                    linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
                    favoritesView.setLayoutManager(linearLayoutManager);
                    favoritesView.setAdapter(adapter);
                    adapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onFailure(Call<favoriteBikeByUser> call, Throwable t) {

            }
        });






    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mContext = context;
    }

//    private void initRecycleView(View view) {
//        recyclerView = view.findViewById(R.id.favoritesView);
//        layoutManager=new LinearLayoutManager(mContext);
//        layoutManager.setOrientation(RecyclerView.VERTICAL);
//        recyclerView.setLayoutManager(layoutManager);
//        adapter = new favoritesAdapter(lists);
//        recyclerView.setAdapter(adapter);
//        adapter.notifyDataSetChanged();
//    }
//
//    private void initData() {
//        lists = new ArrayList<>();
//        lists.add(new favoriteslist(R.drawable.popular_11,"Ktm","duke"));
//        lists.add(new favoriteslist(R.drawable.popular_13,"tvs","duke"));
//    }


}