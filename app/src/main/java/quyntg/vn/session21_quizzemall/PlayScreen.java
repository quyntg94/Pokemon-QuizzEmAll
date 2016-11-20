package quyntg.vn.session21_quizzemall;


import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import butterknife.BindView;
import butterknife.ButterKnife;


/**
 * A simple {@link Fragment} subclass.
 */
public class PlayScreen extends Fragment {

    private static final String TAG = PlayScreen.class.toString();
    @BindView(R.id.A)
    RelativeLayout A;
    @BindView(R.id.B)
    RelativeLayout B;
    @BindView(R.id.C)
    RelativeLayout C;
    @BindView(R.id.D)
    RelativeLayout D;
    @BindView(R.id.tv_current_score)
    TextView tvScore;
    @BindView(R.id.tv_pkmname)
    TextView tvPkmName;
    @BindView(R.id.iv_pkm)
    ImageView ivPkm;

    ProgressBar pb_time;
    CountDownTimer countDownTimer;
    int time = 0;

    public PlayScreen() {

        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_play_screen, container, false);
        ButterKnife.bind(this, view);
        setupUI(view);
        setFont();
        addListener();
        return view;
    }

    private void setupUI(View view) {
        countDown(view);

        Glide.with(this).load(Uri.parse("file:///android_asset/images/Abra.png")).fitCenter().into(ivPkm);
    }

    private void setFont() {
        Typeface typeface = Typeface.createFromAsset(getActivity().getAssets(), "fonts/StencilStd.ttf");
        tvScore.setTypeface(typeface);
        Typeface typeface1 = Typeface.createFromAsset(getActivity().getAssets(), "fonts/PoplarStd.ttf");
        tvPkmName.setTypeface(typeface1);
    }

    private void addListener() {
        True(A);
        False(B);
    }


    void alphaByXml(TextView textView){
        Animation animation = AnimationUtils.loadAnimation(getContext(), R.anim.alpha);

        textView.startAnimation(animation);

    }

    void countDown(View view){
        pb_time = (ProgressBar) view.findViewById(R.id.progress);
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                pb_time.setProgress(2000);
                while (pb_time.getProgress() > 0) {
                    int s = pb_time.getProgress();
                    s--;
                    try {
                        Thread.sleep(100);
                        pb_time.setProgress(s);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        thread.start();
    }

    public void True(final RelativeLayout relativeLayout) {
        relativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                relativeLayout.setBackgroundResource(R.drawable.custom_view_circular_green);

            }
        });
    }

    public void False(final RelativeLayout relativeLayout) {
        relativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                relativeLayout.setBackgroundResource(R.drawable.custom_view_circular_red);


            }
        });
    }

}
