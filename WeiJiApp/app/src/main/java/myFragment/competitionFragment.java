package myFragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ViewFlipper;


import com.example.mrchen.PersonCompetitionActivity;
import com.example.mrchen.TeamCompetitionActivity;
import com.example.mrchen.competition2.R;


import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

/**
 * Created by Mr.chen on 2016/9/28.
 */
public class competitionFragment extends Fragment {

    @InjectView(R.id.flipper)
    ViewFlipper flipper;
    @InjectView(R.id.imagebutton1)
    ImageButton imagebutton1;
    @InjectView(R.id.imagebutton2)
    ImageButton imagebutton2;
    private int[] resId = {R.mipmap.first, R.mipmap.second, R.mipmap.third};
    ImageButton imageButton;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.tab03, container, false);
        ButterKnife.inject(this, view);
        for (int i = 0; i < resId.length; i++) {
            flipper.addView(getImageView(resId[i]));
        }

        flipper.setInAnimation(getActivity(), R.anim.in);
        flipper.setOutAnimation(getActivity(), R.anim.out);
        flipper.setFlipInterval(3000);
        flipper.startFlipping();


        return view;


    }

    private ImageView getImageView(int resId) {
        ImageView imageView = new ImageView(getActivity());
        imageView.setBackgroundResource(resId);
        return imageView;

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.reset(this);
    }


    @OnClick({R.id.imagebutton1, R.id.imagebutton2})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.imagebutton1:
                Intent intent=new Intent(getActivity(), PersonCompetitionActivity.class);
                startActivity(intent);
                break;
            case R.id.imagebutton2:
                Intent intent1=new Intent(getActivity(), TeamCompetitionActivity.class);
                startActivity(intent1);
                break;
        }
    }



}
