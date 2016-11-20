package quyntg.vn.session21_quizzemall;


import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;


/**
 * A simple {@link Fragment} subclass.
 */
public class SettingScreen extends Fragment {

    @BindView(R.id.iv_gen1)
    ImageView gen1;
    @BindView(R.id.iv_gen2)
    ImageView gen2;
    @BindView(R.id.iv_gen3)
    ImageView gen3;
    @BindView(R.id.iv_gen4)
    ImageView gen4;
    @BindView(R.id.iv_gen5)
    ImageView gen5;
    @BindView(R.id.iv_gen6)
    ImageView gen6;
    @BindView(R.id.tv_gen)
    TextView tv_gen;

    public SettingScreen() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_setting_screen, container, false);
        ButterKnife.bind(this, view);
        setupUI();
        setFont();
        addListeners();
        return view;
    }

    private void setupUI(){

    }

    private void setFont(){
        Typeface typeface = Typeface.createFromAsset(getActivity().getAssets(), "fonts/PoplarStd.ttf");
        tv_gen.setTypeface(typeface);
    }

    private void addListeners(){
        fade(gen1);
        fade(gen2);
        fade(gen3);
        fade(gen4);
        fade(gen5);
        fade(gen6);
    }

    public void fade(final ImageView imageView) {
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (((ColorDrawable) imageView.getBackground()).getColor() == Color.parseColor("#00FFFFFF")) {
                    imageView.setBackgroundColor(
                            Color.parseColor("#88FFFFFF")
                    );
                } else {
                    imageView.setBackgroundColor(
                            Color.parseColor("#00FFFFFF")
                    );
                }

            }
        });
    }

}
