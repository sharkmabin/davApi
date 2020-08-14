package debug;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.mabin.dav.common.model.base.BaseFragment;
import com.mabin.dav.common.model.connect.FragmentOperateCallBack;
import com.mabin.dav.common.model.utils.ResourceUtil;
import com.mabin.dav.photo.module.view.PhotoFragment;

public class PhotoDebugActivity extends AppCompatActivity implements FragmentOperateCallBack {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(ResourceUtil.getLayoutId("activity_photo_debug"));

        Fragment contentFragment = BaseFragment.instantiate(this, PhotoFragment.class.getName(), null);
        Bundle bundle = new Bundle() ;
        bundle.putString("title","photo");
        contentFragment.setArguments(bundle);

        addFragment((BaseFragment) contentFragment);
    }

    @Override
    public void addFragment(BaseFragment fragment) {
        Bundle args = fragment.getArguments();
        if (args == null) {
            args = new Bundle();
            fragment.setArguments(args);
        }
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.add(ResourceUtil.getId("photo_content"), fragment);
        transaction.commit();
    }

    @Override
    public void replaceFragment(BaseFragment fragment) {

    }

    @Override
    public void closeAllFragment() {

    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}