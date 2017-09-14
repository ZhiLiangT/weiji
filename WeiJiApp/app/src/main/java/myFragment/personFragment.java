package myFragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mrchen.PsCpDetailActivity;
import com.example.mrchen.competition2.R;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

import java.lang.reflect.Type;
import java.util.List;

import entity.Competition;
import utils.CommonAdapter;
import utils.NetUtil;
import utils.ViewHolder;
import butterknife.ButterKnife;

/**
 * Created by Mr.chen on 2016/10/5.
 */
public class personFragment extends Fragment {

    //List<Competition> competitions = new ArrayList<>();

    List<Competition> competitions;
    CommonAdapter<Competition> competitionApater;

    ListView personCompetition;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.tab05, container, false);

        personCompetition= (ListView) view.findViewById(R.id.psf_listView);

        initView();
        initData();
        initEvent();


        ButterKnife.inject(this, view);
        return view;

    }

    private void initEvent() {

       personCompetition.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getActivity(), "详情", Toast.LENGTH_SHORT).show();
                Log.i("personFragment", "onItemClick: 1");
                Intent intent=new Intent(getActivity(), PsCpDetailActivity.class);


                intent.putExtra("competition",competitions.get(position));

                startActivity(intent);

            }
        });



    }

    private void initData() {

        getCompetitionData();

    }

    private void initView() {



    }


    //获取网络数据
    public void getCompetitionData() {
        RequestParams requestParams = new RequestParams(NetUtil.url + "SelectCompetitionServlet");

        x.http().get(requestParams, new Callback.CommonCallback<String>() {

            @Override
            public void onSuccess(String result) {
                Log.i("personFragment", "onSuccess: 1" + result);
                Gson gson = new Gson();
                Type type = new TypeToken<List<Competition>>(){}.getType();
                competitions = gson.fromJson(result, type);
                Log.i("personFragment", "onSuccess: 22"+competitions);
                //competitions.clear();
                //competitions.addAll(newAllCompetitioms);
                Log.i("personFragment", "onSuccess: 333" + competitions);

                //设置listview的adapter;
                if (competitionApater == null) {

                    competitionApater = new CommonAdapter<Competition>(getActivity(), competitions, R.layout.pf_item) {
                        @Override
                        public void convert(ViewHolder viewHolder, Competition competition, int position) {

                            //设置item中控件的取值

                            TextView tvType = viewHolder.getViewById(R.id.psf_Type);
                            TextView tvTitle = viewHolder.getViewById(R.id.psf_Title);
                            TextView tvBeginTime = viewHolder.getViewById(R.id.psf_beginTime);
                            TextView tvEndTime = viewHolder.getViewById(R.id.psf_endTime);

                            tvType.setText(competition.getType());
                            tvTitle.setText(competition.getTitle());
                            tvBeginTime.setText(competition.getBeginTime());
                            tvEndTime.setText(competition.getEndTime());
                        }
                    };

                    personCompetition.setAdapter(competitionApater);

                } else {

                    competitionApater.notifyDataSetChanged();

                }
            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {

            }

            @Override
            public void onCancelled(CancelledException cex) {

            }

            @Override
            public void onFinished() {

            }
        });


    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.reset(this);
    }
}
