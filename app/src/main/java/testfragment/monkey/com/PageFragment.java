package testfragment.monkey.com;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Description:
 * Author: lanjing
 * Time: 2017/6/21 14:30
 */

public class PageFragment extends Fragment {

    private TextView mTvInfo;
    private View mView;

    public static PageFragment getInstance(Bundle bundle){
        PageFragment pageFragment = new PageFragment();
        pageFragment.setArguments(bundle);
        return pageFragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.fragment_page,container,false);
        setTitle();
        return mView;
    }

    private void setTitle() {
        mTvInfo = (TextView)mView.findViewById(R.id.tv_info);
        Bundle args = getArguments();
        if(args!=null){
            String title = args.getString("title");
            if(TextUtils.isEmpty(title)){
                title = "Null";
            }
            mTvInfo.setText(title);
        }
    }

    @Override
    public String toString() {
        return mTvInfo.getText().toString();
    }
}
