package quyntg.vn.session21_quizzemall;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.iv_play)
    ImageView iv_play;
    @BindView(R.id.iv_setting)
    ImageView iv_setting;
    @BindView(R.id.tv_score)
    TextView tv_score;
    @BindView(R.id.tv_hscore)
    TextView tv_hscore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        setupUI();
        setFont();
        addListeners();

    }

    private void setupUI() {
    }

    private void setFont() {
        Typeface typeface = Typeface.createFromAsset(getAssets(), "fonts/StencilStd.ttf");
        tv_score.setTypeface(typeface);
        tv_hscore.setTypeface(typeface);
    }

    private void addListeners(){
        iv_play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changeFragment(new PlayScreen(), true, null);
            }
        });
        iv_setting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changeFragment(new SettingScreen(), true, null);
            }
        });
    }

    public void changeFragment(Fragment fragment, boolean addToBackstack, String tag){
        FragmentTransaction fragmentTransaction = getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fl_container, fragment);
        if (addToBackstack) {
            fragmentTransaction.addToBackStack(tag);
        }
        fragmentTransaction.commit();
    }


}
