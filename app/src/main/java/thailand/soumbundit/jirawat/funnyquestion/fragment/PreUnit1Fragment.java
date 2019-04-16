

package thailand.soumbundit.jirawat.funnyquestion.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import thailand.soumbundit.jirawat.funnyquestion.R;

public class PreUnit1Fragment extends Fragment{

    public static PreUnit1Fragment preUnit1Fragment(String uidString) {
        PreUnit1Fragment preUnit1Fragment  = new PreUnit1Fragment();
        Bundle bundle = new Bundle();
        bundle.putString("Uid", uidString);
        preUnit1Fragment.setArguments(bundle);
        return preUnit1Fragment;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_preunit1, container, false);
        return view;
    }

}
