package thailand.soumbundit.jirawat.funnyquestion.fragment;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;

import java.lang.reflect.Array;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

import thailand.soumbundit.jirawat.funnyquestion.R;
import thailand.soumbundit.jirawat.funnyquestion.utility.MyConstant;
import thailand.soumbundit.jirawat.funnyquestion.utility.MyConstantUnit3;

public class Unit3Fragment extends Fragment {
    MyConstant myConstant = new MyConstant();
    MyConstantUnit3 myConstantUnit3 = new MyConstantUnit3();
    private String uidString, nameUnitString, timeTestString, warmUpString, presentString = "non", practiseString;
    int[] scoreWarmUp1Ints = {0, 0, 0, 0, 0, 0, 0};
    int[] scorePractice1Ints = {0, 0, 0, 0, 0, 0, 0, 0};
    private String tag = "11NovV1";
    private String tag2 = "11NovV2";

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
        findUidNameUnit();
        findTimeTest();


        checkFloating();

    }//Main Method


    public void checkFloating() {
        FloatingActionButton floatingActionButton = getView().findViewById(R.id.floatingCheck);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(tag, "You click floating");
                myAlertDialog();
            }
        });
    }

    private void myAlertDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setCancelable(false);
        builder.setIcon(R.drawable.ic_action_alert);
        builder.setTitle("Warning");
        builder.setMessage("Need to Exit?");
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
                processCheckScore();
            }
        });
        builder.show();
    }

    public void processCheckScore() {
        calculateWarmUp();


    }

    private void calculateWarmUp() {
        int sumScore = 0;
        String[] strings = new String[4];
        String[] trueAnswerStrings1 = myConstantUnit3.getAnswerWarmUpString();
        String s;
        Collection<String> list ;
        List<String> newList;

        EditText editText1 = getView().findViewById(R.id.unit3EdtWarmUp1);
        EditText editText2 = getView().findViewById(R.id.unit3EdtWarmUp2);
        EditText editText3 = getView().findViewById(R.id.unit3EdtWarmUp3);
        EditText editText4 = getView().findViewById(R.id.unit3EdtWarmUp4);


        strings[0] = editText1.getText().toString().toLowerCase().replaceAll("\\s", "");
        strings[1] = editText2.getText().toString().toLowerCase().replaceAll("\\s", "");
        strings[2] = editText3.getText().toString().toLowerCase().replaceAll("\\s", "");
        strings[3] = editText4.getText().toString().toLowerCase().replaceAll("\\s", "");

        list = Arrays.asList(strings);
        newList = new ArrayList<>(new HashSet<>(list));
        for (int i = 0; i < newList.size(); i += 1) {
            s = newList.get(i);
            for (int i1 = 0; i1 < trueAnswerStrings1.length; i1 += 1) {
                if (s.equals(trueAnswerStrings1[i1])) {
                    sumScore +=1;
                }
            }
        }

        Log.d(tag2, "scoreWarmUp==>" + sumScore);
    }


    public void findTimeTest() {
        Calendar calendar = Calendar.getInstance();
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yy HH:mm");
        timeTestString = dateFormat.format(calendar.getTime());
        Log.d(tag, "TimeTestString ==> " + timeTestString);
    }

    public void findUidNameUnit() {
        uidString = getArguments().getString("Uid");
        Log.d(tag, "uidSting ==> " + uidString);
        // find UnitID, Name Unit
        String[] strings = myConstant.getUnitTitleStrings();
        nameUnitString = strings[0];
        Log.d(tag, "nameUnitStirng ==> " + nameUnitString);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_unit3, container, false);
        return view;
    }
}
