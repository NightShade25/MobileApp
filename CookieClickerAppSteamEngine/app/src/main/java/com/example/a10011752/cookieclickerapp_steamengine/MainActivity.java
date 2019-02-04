package com.example.a10011752.cookieclickerapp_steamengine;

import android.support.constraint.ConstraintLayout;
import android.support.constraint.ConstraintSet;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    ImageView tv;
    ConstraintLayout layout;
    int clickval = 1;
    TextView score;
    int totalscore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv = findViewById(R.id.id_image);
        layout = findViewById(R.id.id_layout);
        score = findViewById(R.id.id_score);

        final ScaleAnimation animation = new ScaleAnimation (1.0F, 1.5F, 1.0F, 1.5F, Animation.RELATIVE_TO_SELF, .5F, Animation.RELATIVE_TO_SELF, .5F);

        animation.setDuration(400);


        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(animation);
                clickeywhickey();
                totalscore+=clickval;
                score.setText(totalscore + "");
            }
        });
    }

    public void clickeywhickey(){
        float HOR_BIAS = (float)(Math.random()*0.64f)+0.18f;
//float HOR_BIAS = 0.82f;
        final TextView textViewInCode;

        textViewInCode = new TextView(this);
        textViewInCode.setId(View.generateViewId());
        textViewInCode.setText("+"+clickval);

        ConstraintLayout.LayoutParams p = new ConstraintLayout.LayoutParams(ConstraintLayout.LayoutParams.WRAP_CONTENT, ConstraintLayout.LayoutParams.WRAP_CONTENT);

        textViewInCode.setLayoutParams(p);

        layout.addView(textViewInCode);

        ConstraintSet constraintSet = new ConstraintSet();
        constraintSet.clone(layout);

        constraintSet.connect(textViewInCode.getId(),ConstraintSet.BOTTOM,layout.getId(),ConstraintSet.BOTTOM);
        constraintSet.connect(textViewInCode.getId(),ConstraintSet.TOP,layout.getId(),ConstraintSet.BOTTOM);
        constraintSet.connect(textViewInCode.getId(),ConstraintSet.LEFT,layout.getId(),ConstraintSet.LEFT);
        constraintSet.connect(textViewInCode.getId(),ConstraintSet.RIGHT,layout.getId(),ConstraintSet.RIGHT);

        constraintSet.setHorizontalBias(textViewInCode.getId(),HOR_BIAS);
        constraintSet.setVerticalBias(textViewInCode.getId(),1f);

        constraintSet.applyTo(layout);

        textViewInCode.animate().translationY(-150).alpha(0.0f).setDuration(2000);
    }
}
