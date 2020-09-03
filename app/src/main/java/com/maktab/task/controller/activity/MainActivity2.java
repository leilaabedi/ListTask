package com.maktab.task.controller.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;

import com.maktab.task.R;
import com.maktab.task.controller.fragment.listFragment;
import com.maktab.task.controller.fragment.mainFragment;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);



        FragmentManager fragmentManager = getSupportFragmentManager();

        //check if fragment exists in container (configuration changes save the fragments)
        Fragment fragment = fragmentManager.findFragmentById(R.id.fragment_container1);

        //create an add fragment transaction for CrimeDetailFragment
        if (fragment == null) {
            listFragment fragment1 = new listFragment();
            fragmentManager
                    .beginTransaction()
                    .add(R.id.fragment_container1, fragment1)
                    .commit();
        }


    }
}