package com.example.Dinamic_Fragments;

import android.os.Bundle;

/**
 * Created with IntelliJ IDEA.
 * User: Sergey
 * Date: 09.11.13
 * Time: 20:15
 * To change this template use File | Settings | File Templates.
 */
public class MyActivityContacts extends MyActivity {
    FragmentContacts fragContacts;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);    //To change body of overridden methods use File | Settings | File Templates.
        tx=getSupportFragmentManager().beginTransaction();
        fragContacts=new FragmentContacts();

        if (!getResources().getBoolean(R.bool.istablet))    {
            tx.replace(R.id.content_frame,fragContacts);
        }
        if (getResources().getBoolean(R.bool.istablet)) {
            tx.replace(R.id.fragment2ForTablet, fragContacts);
        }

        tx.commit();
    }
}
