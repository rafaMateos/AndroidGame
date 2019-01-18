package com.example.rafa.deardeath2characters;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import static android.support.v4.content.ContextCompat.startActivity;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link Personages.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link Personages#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Personages extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    private RecyclerView recyclerView;
    private List<Personaje> movieList;
    private RecyclerViewAdapter mAdapter;

    public Personages() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Personages.
     */
    // TODO: Rename and change types and number of parameters
    public static Personages newInstance(String param1, String param2) {
        Personages fragment = new Personages();
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

        getActivity().setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_FULL_SENSOR);

        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_personages, container, false);//

        GestoraPersonajes gestoraPersonajes = new GestoraPersonajes();
        movieList = new ArrayList<>();

        movieList = gestoraPersonajes.getPersonajes();

        RecyclerView myrv = view.findViewById(R.id.pepe);
        RecyclerViewAdapter myAdapter = new RecyclerViewAdapter(getActivity(),movieList);
        myrv.setLayoutManager(new GridLayoutManager(getActivity(),3));
        myrv.setAdapter(myAdapter);



        return view;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    /*
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }
*/
    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }



    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }

    public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {


        private Context mContext;
        private  List<Personaje> mData;
        private  IRecyclerCliks iRecyclerCliks;

        public RecyclerViewAdapter(Context mContext, List<Personaje> mData) {
            this.mContext = mContext;
            this.mData = mData;

        }

        @NonNull
        @Override
        public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

            View view;
            LayoutInflater mInflater = LayoutInflater.from(mContext);
            view = mInflater.inflate(R.layout.cardview_item,viewGroup,false);

            return new MyViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {
            myViewHolder.tv_Nombre.setText(mData.get(i).get_nombre());
            myViewHolder.image.setImageResource(mData.get(i).getImage());
        }



        @Override
        public int getItemCount() {

            return mData.size();
        }


        public  class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

            TextView tv_Nombre;
            ImageView image;

            public MyViewHolder(@NonNull View itemView) {

                super(itemView);
                itemView.setOnClickListener(this);
                tv_Nombre = (TextView) itemView.findViewById(R.id.NombrePer);
                image = (ImageView) itemView.findViewById(R.id.idImagen);

            }


            @Override
            public void onClick(View v) {

                Intent intent = new Intent(v.getContext(), Main2Activity.class);
                intent.putExtra("Personaje",mData.get(getAdapterPosition()));
                startActivity(intent);

            }


        }

    }

}
