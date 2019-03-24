package thailand.soumbundit.jirawat.funnyquestion.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import thailand.soumbundit.jirawat.funnyquestion.R;

public class Unit3Fragment extends Fragment {

    public static Unit3Fragment unit3Instance(String uidString) {
        Unit3Fragment unit3Fragment = new Unit3Fragment();
        Bundle bundle = new Bundle();
        bundle.putString("Uid", uidString);
        unit3Fragment.setArguments(bundle);
        return unit3Fragment;
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }//Main Method

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_unit3,container,false);
        return view;
    }
}
