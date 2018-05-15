package com.example.skd.myapp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * @author: skd
 * @date 2018/5/15
 * @Desc FragmentStackActivity
 */
public class FragmentStackActivity extends FragmentActivity {
    int mStackLevel = 0;
    private FragmentManager supportFragmentManager;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragmengstack);
        addFragmentToStack();
    }

    void addFragmentToStack() {
        supportFragmentManager = getSupportFragmentManager();
        Fragment newFragment = CountingFragment.newInstance(mStackLevel);
        FragmentTransaction ft = supportFragmentManager.beginTransaction();
        ft.replace(R.id.content, newFragment);
        ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        ft.addToBackStack(null);
        ft.commit();
    }

    public void pop(View view) {
        fragmentPop();

    }

    private void fragmentPop() {
        int count = supportFragmentManager.getBackStackEntryCount();
        Log.d("FragmentStackActivity", "count:" + count);

        if (count>1){
            supportFragmentManager.popBackStack();
        }else {
            finish();
        }
    }

    public void push(View view) {
        mStackLevel++;
        addFragmentToStack();
    }

    @Override
    public void onBackPressed() {
        fragmentPop();


    }

    public static class CountingFragment extends Fragment {
        int mNum;
        private static int[] sColorValue = new int[]{
                android.R.color.holo_blue_light,
                android.R.color.holo_green_light,
                android.R.color.holo_orange_light,
                android.R.color.holo_red_light};

        /**
         * Create a new instance of CountingFragment, providing "num" as an
         * argument.
         */
        static CountingFragment newInstance(int num) {
            CountingFragment f = new CountingFragment();

            // Supply num input as an argument.
            Bundle args = new Bundle();
            args.putInt("num", num);
            f.setArguments(args);
            return f;
        }

        /**
         * When creating, retrieve this instance's number from its arguments.
         */
        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            mNum = getArguments() != null ? getArguments().getInt("num") : 1;
        }

        /**
         * The Fragment's UI is just a simple text view showing its instance
         * number.
         */
        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View v = inflater.inflate(R.layout.fragment_stack_layout, container, false);
            View tv = v.findViewById(R.id.text);
            ((TextView) tv).setText("Fragment #" + mNum);
            tv.setBackgroundDrawable(getResources().getDrawable(android.R.drawable.gallery_thumb));
            Log.v("TAG", "mNum % 3 " + mNum % 3);
            tv.setBackgroundColor(getActivity().getResources().getColor(sColorValue[mNum % 3]));
            return v;
        }
    }
}
