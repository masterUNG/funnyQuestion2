package thailand.soumbundit.jirawat.funnyquestion.fragment;

import android.support.v4.app.Fragment;
import android.os.Bundle;

import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import thailand.soumbundit.jirawat.funnyquestion.R;

public class ReportFragment extends Fragment {


    public static ReportFragment reportFragment(String uidString) {
        ReportFragment reportFragment = new ReportFragment();
        Bundle bundle = new Bundle();
        bundle.putString("Uid", uidString);
        reportFragment.setArguments(bundle);
        return reportFragment;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_report, container, false);
        return view;
    }
}
