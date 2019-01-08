package net.dlingogroups.dzikirsunnah;

import android.graphics.drawable.AnimatedImageDrawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class dzikir1 extends Fragment {
    View view;

    public dzikir1() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.dzikir1, container,false);
        return view;
    }
}
