package com.example.Dinamic_Fragments;

import android.os.Bundle;

/**
 * Created with IntelliJ IDEA.
 * User: Sergey
 * Date: 09.11.13
 * Time: 20:14
 * To change this template use File | Settings | File Templates.
 */
public class MyActivityAnimation extends MyActivity {
    FragmentAnimation fragAnim;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        //FragmentAnimation k = new FragmentAnimation();
        super.onCreate(savedInstanceState);    //To change body of overridden methods use File | Settings | File Templates.
                tx=getSupportFragmentManager().beginTransaction();
                fragAnim=new FragmentAnimation();

                 if (!getResources().getBoolean(R.bool.istablet))    {
                     tx.replace(R.id.content_frame,fragAnim);
                 }
                 if (getResources().getBoolean(R.bool.istablet)) {
                     tx.replace(R.id.fragment2ForTablet, fragAnim);
        }

        tx.commit();
    }
}
