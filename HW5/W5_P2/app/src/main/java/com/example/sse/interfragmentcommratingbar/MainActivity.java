<<<<<<< HEAD
package com.example.sse.interfragmentcommratingbar;

import android.app.Activity;
import android.os.Bundle;

public class MainActivity extends Activity implements NavigateFragment.NavifateFragmentListner{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void updateIndex(int index) {
        DrawableFragment receivingFragment = (DrawableFragment)getFragmentManager().findFragmentById(R.id.drawable_fragment);
        receivingFragment.updatePicture(index);
    }
}
=======
package com.example.sse.interfragmentcommratingbar;

import android.app.Activity;
import android.os.Bundle;

public class MainActivity extends Activity implements NavigateFragment.NavifateFragmentListner {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void updateIndex(int index) {
        DrawableFragment receivingFragment = (DrawableFragment) getFragmentManager().findFragmentById(R.id.drawable_fragment);
        receivingFragment.updatePicture(index);
    }
}
>>>>>>> 246f2d692bd1f39442f4e9f5626fa79be0b0a55b
