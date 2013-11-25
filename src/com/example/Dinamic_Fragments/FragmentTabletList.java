package com.example.Dinamic_Fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/**
 * Created with IntelliJ IDEA.
 * User: Sergey
 * Date: 09.11.13
 * Time: 22:14
 * To change this template use File | Settings | File Templates.
 */
public class FragmentTabletList extends Fragment {
    ListView lv;
    final String[] fragMassive ={"com.example.Dinamic_Fragments.FragmentOrg","com.example.Dinamic_Fragments.FragmentAnimation", "com.example.Dinamic_Fragments.FragmentCourses", "com.example.Dinamic_Fragments.FragmentContacts","com.example.Dinamic_Fragments.FragmentMe","com.example.Dinamic_Fragments.FragmentExit"};
    String[] arr = new String[]{"About Org","Ex. Anim","Courses list","Contacts","About me"};


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
               View fragmentTabletListView = inflater.inflate(R.layout.left_tablet_panel,container,false);
        lv = (ListView) fragmentTabletListView.findViewById(R.id.listView);
        lv.setAdapter(new ArrayAdapter<String>(getActivity().getApplicationContext(),R.layout.tvlayouts,arr));
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(getResources().getBoolean(R.bool.istablet)){
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragment2ForTablet, Fragment.instantiate(getActivity().getApplicationContext(),fragMassive[position])).commit();
                    }

            }
        });

        return  fragmentTabletListView;


    }
}















