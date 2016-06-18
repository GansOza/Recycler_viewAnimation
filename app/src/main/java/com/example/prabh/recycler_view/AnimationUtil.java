package com.example.prabh.recycler_view;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.support.v7.widget.RecyclerView;

/**
 * Created by prabh on 14-04-2016.
 */
public class AnimationUtil {
    public static void animate(RecyclerView.ViewHolder holder, boolean goesDown) {

        AnimatorSet animatorset = new AnimatorSet();
        ObjectAnimator animatorTranslateY = ObjectAnimator.ofFloat(holder.itemView,"translationY",goesDown==true ? 200:-200,0);
        animatorTranslateY.setDuration(1000);

        animatorset.playTogether(animatorTranslateY);
        animatorset.start();
    }
}
