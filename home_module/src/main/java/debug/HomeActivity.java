package debug;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import com.mabin.dav.common.model.base.BaseFragment;
import com.mabin.dav.common.model.connect.FragmentOperateCallBack;
import com.mabin.dav.common.model.utils.ResourceUtil;
import com.mabin.module.home.view.HomeFragment;

public class HomeActivity extends AppCompatActivity implements FragmentOperateCallBack {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(ResourceUtil.getLayoutId("test_layout"));

        Fragment contentFragment = BaseFragment.instantiate(this, HomeFragment.class.getName(), null);
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.add(ResourceUtil.getId("home_main_layout"), contentFragment);
        transaction.commit();
    }

    @Override
    public void addFragment(BaseFragment fragment) {
        Bundle args = fragment.getArguments();
        if (args == null) {
            args = new Bundle();
            fragment.setArguments(args);
        }
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.add(ResourceUtil.getId("home_main_layout"), fragment);
        transaction.commit();
    }

    @Override
    public void replaceFragment(BaseFragment fragment) {
        Bundle args = fragment.getArguments();
        if (args == null) {
            args = new Bundle();
            fragment.setArguments(args);
        }
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(ResourceUtil.getId("home_main_layout"), fragment);
        transaction.commit();

    }

    @Override
    public void closeAllFragment() {
        finish();
        overridePendingTransition(0, 0);
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}
