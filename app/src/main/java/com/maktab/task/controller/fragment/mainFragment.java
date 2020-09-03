package com.maktab.task.controller.fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.maktab.task.R;
import com.maktab.task.controller.activity.MainActivity2;


public class mainFragment extends Fragment {
    public static final String EXTRA_TASK_NUMBER="com.maktab.task.tasknumber";
    public static int num;

    EditText name,task;
    Button btn_submit;



    public mainFragment() {
        // Required empty public constructor
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);
        findViews(view);
        setListeners();
        return view;
    }

    private void findViews(View view){
        name=view.findViewById(R.id.name);
        task=view.findViewById(R.id.task);
        btn_submit=view.findViewById(R.id.btn_submit);
    }

    private void setListeners(){
        btn_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                num=Integer.parseInt(task.getText().toString());

                Intent intent=new Intent(getActivity(), MainActivity2.class);

               // intent.putExtra(EXTRA_TASK_NUMBER, num);
                startActivity(intent);


            }
        });

    }

}