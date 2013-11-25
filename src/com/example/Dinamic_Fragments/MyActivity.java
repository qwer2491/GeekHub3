package com.example.Dinamic_Fragments;

import android.content.Intent;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.*;


public class MyActivity extends ActionBarActivity {



    FragmentTransaction fTrans;
    //Navigation Drawer and ActionBar
    //Intent intent=new Intent();

    FragmentTransaction tx;
    private DrawerLayout mDrawerLayout;
    private ListView mDrawerList;
    Intent intent;


    final String[] fragmentsList ={"com.example.Dinamic_Fragments.FragmentOrg","com.example.Dinamic_Fragments.FragmentAnimation", "com.example.Dinamic_Fragments.FragmentCourses", "com.example.Dinamic_Fragments.FragmentContacts","com.example.Dinamic_Fragments.FragmentMe","com.example.Dinamic_Fragments.FragmentExit"};
    //private String[] testArray;
    //Button exit;
    String [] listForList={"About Org","Ex. Anim","Courses list","Contacts","About me","Exit"};





    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        tx = getSupportFragmentManager().beginTransaction();
        FragmentOrg fragmentOrg = new FragmentOrg();
        if (!getResources().getBoolean(R.bool.istablet))    {
            tx.replace(R.id.content_frame,fragmentOrg).commit();
        }
        if (getResources().getBoolean(R.bool.istablet)) {
            tx.replace(R.id.fragment2ForTablet, fragmentOrg).commit();
        }
        //tx.replace(R.id.content_frame,fragmentOrg).commit();

        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
                mDrawerList = (ListView) findViewById(R.id.left_drawer);


        mDrawerList.setAdapter(new ArrayAdapter<String>(this,
                R.layout.tvlayouts, listForList));
        mDrawerList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, final View view, final int pos, long id) {
                mDrawerLayout.setDrawerListener(new DrawerLayout.SimpleDrawerListener() {

                    @Override
                    public void onDrawerClosed(View drawerView) {
                        super.onDrawerClosed(drawerView);
                        if (pos==5) {
                            finish();
                        }
                        else {
                            if (!getResources().getBoolean(R.bool.istablet))    {

                                switch (pos){
                                    case 0: intent=new Intent(MyActivity.this, MyActivityOrg.class );
                                        break;
                                    case 1: intent=new Intent(MyActivity.this, MyActivityAnimation.class );
                                        break;
                                    case 2: intent=new Intent(MyActivity.this, MyActivityCourses.class );
                                        break;
                                    case 3: intent=new Intent(MyActivity.this, MyActivityContacts.class );
                                        break;
                                    case 4: intent=new Intent(MyActivity.this, MyActivityMe.class );
                                        break;
                                }
                                finish();
                                startActivity(intent);

                            }
                            if (getResources().getBoolean(R.bool.istablet)) {
                                tx=getSupportFragmentManager().beginTransaction();
                                tx.replace(R.id.fragment2ForTablet, Fragment.instantiate(getApplicationContext(),fragmentsList[pos]));
                                tx.commit();
                            }
                        }

                    }
                });
                mDrawerLayout.closeDrawer(mDrawerList);
            }
        });

        //mDrawerLayout = (DrawerLayout) findViewById(R.id.tablet_left_panel);

       // getSupportActionBar().setDisplayHomeAsUpEnabled(true);
       // getSupportActionBar().setHomeButtonEnabled(true);
       /* mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mDrawerList.setAdapter(new ArrayAdapter<String>(this,
                R.layout.tvlayouts, listForList));
        mDrawerList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, final View view, final int pos, long id) {
                mDrawerLayout.setDrawerListener(new DrawerLayout.SimpleDrawerListener() {
                });








                mDrawerLayout.closeDrawer(mDrawerList);
            }
        });   */

    }






    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()) {
            case R.id.item1:  Toast toast = Toast.makeText(getApplicationContext(),
                    "Created by S.Syschik!\n" +
                    "Mail:qwer2491@gmail.com", Toast.LENGTH_SHORT);
                toast.show();
                break;
            case R.id.item2: tx=getSupportFragmentManager().beginTransaction();
                tx.replace(R.id.content_frame,Fragment.instantiate(MyActivity.this,"com.example.Dinamic_Fragments.FragmentOrg"));
                tx.commit();
        }





        return super.onOptionsItemSelected(item);    //To change body of overridden methods use File | Settings | File Templates.

    }

    /*

    public void onClick(View v) {
        fTrans = getSupportFragmentManager().beginTransaction();
        switch (v.getId()) {
            case R.id.butMain1:
                fTrans.replace(R.id.content_frame, f1);
                break;
            case R.id.butMain2:
                fTrans.replace(R.id.content_frame, f2);
                break;
            case R.id.butMain3:
                fTrans.remove(f1);
                fTrans.remove(f2);
                break;

            default:
                break;
        }

        fTrans.commit();
    }
        */

}