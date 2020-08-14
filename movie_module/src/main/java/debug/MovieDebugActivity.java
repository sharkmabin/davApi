package debug;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.mabin.dav.common.model.base.BaseFragment;
import com.mabin.dav.common.model.connect.FragmentOperateCallBack;
import com.mabin.dav.common.model.utils.ResourceUtil;
import com.mabin.movie.module.view.MovieFragment;

public class MovieDebugActivity extends AppCompatActivity implements FragmentOperateCallBack {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(ResourceUtil.getLayoutId("activity_movie_debug"));
        Fragment contentFragment = BaseFragment.instantiate(this, MovieFragment.class.getName(), null);
        addFragment((BaseFragment) contentFragment) ;
    }

    @Override
    public void addFragment(BaseFragment fragment) {
        Bundle args = fragment.getArguments();
        if (args == null) {
            args = new Bundle();
            fragment.setArguments(args);
        }
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.add(ResourceUtil.getId("movieFragment"), fragment);
        transaction.commit();
    }

    @Override
    public void replaceFragment(BaseFragment fragment) {

    }

    @Override
    public void closeAllFragment() {

    }
}