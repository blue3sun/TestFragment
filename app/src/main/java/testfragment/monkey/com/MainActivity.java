package testfragment.monkey.com;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.Toast;

public class MainActivity extends FragmentActivity {

    private Button mBtnSkip;
    private FrameLayout mFlContainer;
    private FragmentManager mFragmentManager;
    private FragmentTransaction mFragmentTransaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        mFlContainer = (FrameLayout)findViewById(R.id.fl_container);
        mBtnSkip = (Button)findViewById(R.id.btn_skip);
        mBtnSkip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadFragment("Second Fragment");
            }
        });
        mFragmentManager = getSupportFragmentManager();
        loadFragment("First Fragment");
    }
    public void loadFragment(String title){
        Bundle bundle = new Bundle();
        bundle.putString("title",title);
        PageFragment pageFragment = PageFragment.getInstance(bundle);
        mFragmentTransaction = mFragmentManager.beginTransaction();
        mFragmentTransaction.add(R.id.fl_container,pageFragment);
        mFragmentTransaction.addToBackStack(null);
        mFragmentTransaction.commit();
        Fragment fragment = mFragmentManager.findFragmentById(R.id.fl_container);
        if(fragment!=null){
            showToast("findFragmentById: "+fragment.toString());
        }else{
            showToast("findFragmentById: fragment is null");
        }
    }
    public void showToast(String tips){
        Toast.makeText(MainActivity.this,tips,Toast.LENGTH_LONG).show();
    }
}
