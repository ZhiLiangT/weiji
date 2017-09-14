package myFragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.mrchen.RunRecordActivity;
import com.example.mrchen.SettingsActivity;
import com.example.mrchen.StepCounterActivity;
import com.example.mrchen.competition2.R;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

/**
 * Created by Mr.chen on 2016/9/28.
 */
public class sportFragment extends Fragment {


    @InjectView(R.id.yundong_sprot_ditu)
    ImageButton yundongSprotDitu;
    @InjectView(R.id.yundong_sprot_shezhi)
    ImageButton yundongSprotShezhi;
    @InjectView(R.id.yundong_zongkuangkuang)
    LinearLayout yundongZongkuangkuang;
    @InjectView(R.id.sport_button)
    ImageButton sportButton;
    @InjectView(R.id.imageView2)
    ImageView imageView2;
    @InjectView(R.id.yundong_sport_kuang)
    LinearLayout yundongSportKuang;
    @InjectView(R.id.page_yundongjiru)
    Button pageYundongjiru;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.tab01, container, false);

        ButterKnife.inject(this, view);
        return view;


    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.reset(this);
    }

    @OnClick({R.id.yundong_sprot_ditu, R.id.yundong_sprot_shezhi, R.id.sport_button, R.id.page_yundongjiru})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.yundong_sprot_ditu:
                break;
            case R.id.yundong_sprot_shezhi:
                Intent intent2 = new Intent(getActivity(),SettingsActivity.class);
                startActivity(intent2);
                break;
            case R.id.sport_button:
                //跑步
                Intent intent = new Intent();
                intent.setClass(getActivity(), StepCounterActivity.class);
                Bundle bundle = new Bundle();
                bundle.putBoolean("run", false);
                intent.putExtras(bundle);
                startActivity(intent);
                break;
            case R.id.page_yundongjiru:
                //运动记录
                Intent intents=new Intent(getActivity(),RunRecordActivity.class);
                startActivity(intents);
                break;
        }
    }
}

