package org.aihdint.aihd.introSlider;

import android.Manifest;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.FloatRange;
import android.support.annotation.Nullable;
import android.view.View;

import org.aihdint.aihd.Login;
import org.aihdint.aihd.R;
import org.aihdint.aihd.app.AppController;

import agency.tango.materialintroscreen.MaterialIntroActivity;
import agency.tango.materialintroscreen.SlideFragmentBuilder;
import agency.tango.materialintroscreen.animations.IViewTranslation;

public class IntroActivity extends MaterialIntroActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        enableLastSlideAlphaExitTransition(true);

        getBackButtonTranslationWrapper()
                .setEnterTranslation(new IViewTranslation() {
                    @Override
                    public void translate(View view, @FloatRange(from = 0, to = 1.0) float percentage) {
                        view.setAlpha(percentage);
                    }
                });

        addSlide(new CustomSlide());

        addSlide(new SlideFragmentBuilder()
                .backgroundColor(R.color.light_green)
                .buttonsColor(R.color.permission_buttons)
                .possiblePermissions(new String[]{})
                .neededPermissions(new String[]{Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.ACCESS_NETWORK_STATE})
                .image(R.drawable.logo)
                .title("Permissions required")
                .description("Proceed if all permissions have been granted.")
                .build());
    }

    @Override
    public void onFinish() {
        super.onFinish();

        AppController.getInstance().getSessionManager().setIntro(true);

        Intent intent = new Intent(IntroActivity.this, Login.class);
        startActivity(intent);
    }
}