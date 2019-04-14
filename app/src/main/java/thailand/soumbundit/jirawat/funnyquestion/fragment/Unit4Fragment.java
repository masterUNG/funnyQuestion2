package thailand.soumbundit.jirawat.funnyquestion.fragment;

import android.content.DialogInterface;
import android.media.MediaPlayer;
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

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import thailand.soumbundit.jirawat.funnyquestion.R;
import thailand.soumbundit.jirawat.funnyquestion.utility.MyConstant;
import thailand.soumbundit.jirawat.funnyquestion.utility.MyConstantUnit4;

public class Unit4Fragment extends Fragment {

    private MyConstant myConstant = new MyConstant();
    private MyConstantUnit4 myConstantUnit4 = new MyConstantUnit4();
    private MediaPlayer mediaPlayer1;
    private String uidString, nameUnitString, timeTestString, warmUpString, presentString = "non", practiseString;
    private String tag = "11NovV1";
    private String tag2 = "11NovV2";
    private int[] scorePractice4Ints = {0, 0, 0};


    public static Unit4Fragment unit4Instance(String uidString) {
        Unit4Fragment unit4Fragment = new Unit4Fragment();
        Bundle bundle = new Bundle();
        bundle.putString("Uid", uidString);
        unit4Fragment.setArguments(bundle);
        return unit4Fragment;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        findUidNameUnit();

        Choice1spinner();
        Choice2spinner();
        Choice3spinner();
        Choice4spinner();
        Choice5spinner();
        Choice6spinner();
        Choice7spinner();
        Choice8spinner();
        Choice9spinner();
        Choice10spinner();
        Choice11spinner();
        Choice12spinner();
        Choice13spinner();
        Choice14spinner();
        Choice15spinner();

        practice1Spinner();
        practice2Spinner();
        practice3Spinner();


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
        findTimeTest();
        calculateWarmUp();
        calculatePractise1();
        calculatePractise2();
        calculatePractise3();
    }

    private void calculatePractise3() {
        int sumScoreInt = 0;
        String [] trueAnswerString = myConstantUnit4.getPractice4True2();
        String[] strings = new String[2];

        EditText editText1 = getView().findViewById(R.id.unit2EdtPractise8);
        EditText editText2 = getView().findViewById(R.id.unit2EdtPractise9);

        strings[0] = editText1.getText().toString().trim();
        strings[1] = editText2.getText().toString().trim();

        for (int i = 0; i < scorePractice4Ints.length; i += 1) {
            sumScoreInt += scorePractice4Ints[i];
        }

        for(int i=0; i<strings.length; i+=1){
            strings[i] = strings[i].toLowerCase();
            if(strings[i].equals(trueAnswerString[i])){
                sumScoreInt +=1;
            }
        }

        Log.d(tag2, "scorePractice4 ==>" + sumScoreInt);
    }


    private void calculatePractise2() {
        int sumScoreInt = 0;
        RadioButton rb_answer1 = getView().findViewById(R.id.unit2RbPractise1True);
        RadioButton rb_answer2 = getView().findViewById(R.id.unit2RbPractise2True);
        RadioButton rb_answer3 = getView().findViewById(R.id.unit2RbPractise3True);
        RadioButton rb_answer4 = getView().findViewById(R.id.unit2RbPractise4True);
        RadioButton rb_answer5 = getView().findViewById(R.id.unit2RbPractise5True);
        RadioButton rb_answer6 = getView().findViewById(R.id.unit2RbPractise6True);
        RadioButton rb_answer7 = getView().findViewById(R.id.unit2RbPractise7True);
        RadioButton rb_answer8 = getView().findViewById(R.id.unit2RbPractise8True);
        RadioButton rb_answer9 = getView().findViewById(R.id.unit2RbPractise9True);
        RadioButton rb_answer10 = getView().findViewById(R.id.unit2RbPractise10True);

        if(rb_answer1.isChecked()){
            sumScoreInt += 1;
        }
        if(rb_answer2.isChecked()){
            sumScoreInt += 1;
        }
        if(rb_answer3.isChecked()){
            sumScoreInt += 1;
        }
        if(rb_answer4.isChecked()){
            sumScoreInt += 1;
        }
        if(rb_answer5.isChecked()){
            sumScoreInt += 1;
        }
        if(rb_answer6.isChecked()){
            sumScoreInt += 1;
        }
        if(rb_answer7.isChecked()){
            sumScoreInt += 1;
        }
        if(rb_answer8.isChecked()){
            sumScoreInt += 1;
        }
        if(rb_answer9.isChecked()){
            sumScoreInt += 1;
        }
        if(rb_answer10.isChecked()){
            sumScoreInt += 1;
        }

        Log.d(tag2, "scorePractice2==>" + sumScoreInt);

    }

    private void calculatePractise1() {
        int sumScoreInt = 0;
        String[] strings = new String[7];
        String[] trueAnswerString = myConstantUnit4.getPractice1True();

        EditText editText1 = getView().findViewById(R.id.unit2EdtPractise1);
        EditText editText2 = getView().findViewById(R.id.unit2EdtPractise2);
        EditText editText3 = getView().findViewById(R.id.unit2EdtPractise3);
        EditText editText4 = getView().findViewById(R.id.unit2EdtPractise4);
        EditText editText5 = getView().findViewById(R.id.unit2EdtPractise5);
        EditText editText6 = getView().findViewById(R.id.unit2EdtPractise6);
        EditText editText7 = getView().findViewById(R.id.unit2EdtPractise7);

        strings[0] = editText1.getText().toString().trim();
        strings[1] = editText2.getText().toString().trim();
        strings[2] = editText3.getText().toString().trim();
        strings[3] = editText4.getText().toString().trim();
        strings[4] = editText5.getText().toString().trim();
        strings[5] = editText6.getText().toString().trim();
        strings[6] = editText7.getText().toString().trim();

        for (int i = 0; i < strings.length; i += 1) {
            strings[i] = strings[i].toLowerCase();
            if (strings[i].equals(trueAnswerString[i])) {
                sumScoreInt += 1;
            }
        }

        Log.d(tag2, "scorePractice1 ==>" + sumScoreInt);


    }

    private void calculateWarmUp() {
        int sumScoreInt = 0;
        RadioButton rb_answer = getView().findViewById(R.id.unit2RbWarmUp1B);
        if (rb_answer.isChecked()) {
            sumScoreInt += 1;
        }
        Log.d(tag2, "scoreWarmUp ==>" + sumScoreInt);
    }



    private void  checkScorePractice4(int indexSpinner, int position) {
        int[] answerTrueInts = myConstantUnit4.getAnswerPractice4Int();

        if (position == answerTrueInts[indexSpinner]) {
            scorePractice4Ints[indexSpinner] = 1;
        } else {
            scorePractice4Ints[indexSpinner] = 0;
        }

    }

    private  void practice1Spinner() {
        Spinner spinner = getView().findViewById(R.id.unit2SpinnerPractice1);
        String[] strings = myConstantUnit4.getPractice4True();
        ArrayAdapter<String> stringArrayAdapter = new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_list_item_1, strings);
        spinner.setAdapter(stringArrayAdapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
                checkScorePractice4(0, position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    private  void practice2Spinner() {
        Spinner spinner = getView().findViewById(R.id.unit2SpinnerPractice2);
        String[] strings = myConstantUnit4.getPractice4True();
        ArrayAdapter<String> stringArrayAdapter = new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_list_item_1, strings);
        spinner.setAdapter(stringArrayAdapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
                checkScorePractice4(1, position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    private  void practice3Spinner() {
        Spinner spinner = getView().findViewById(R.id.unit2SpinnerPractice3);
        String[] strings = myConstantUnit4.getPractice4True();
        ArrayAdapter<String> stringArrayAdapter = new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_list_item_1, strings);
        spinner.setAdapter(stringArrayAdapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
                checkScorePractice4(2, position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }



    public void Choice1spinner() {
        Spinner spinner = getView().findViewById(R.id.choice1spinner);
        String[] strings = myConstantUnit4.getChoiceSpinnerItemStrings();
        ArrayAdapter<String> stringArrayAdapter = new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_list_item_1, strings);
        spinner.setAdapter(stringArrayAdapter);
    }

    public void Choice2spinner() {
        Spinner spinner = getView().findViewById(R.id.choice2spinner);
        String[] strings = myConstantUnit4.getChoiceSpinnerItemStrings();
        ArrayAdapter<String> stringArrayAdapter = new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_list_item_1, strings);
        spinner.setAdapter(stringArrayAdapter);
    }

    public void Choice3spinner() {
        Spinner spinner = getView().findViewById(R.id.choice3spinner);
        String[] strings = myConstantUnit4.getChoiceSpinnerItemStrings();
        ArrayAdapter<String> stringArrayAdapter = new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_list_item_1, strings);
        spinner.setAdapter(stringArrayAdapter);
    }

    public void Choice4spinner() {
        Spinner spinner = getView().findViewById(R.id.choice4spinner);
        String[] strings = myConstantUnit4.getChoiceSpinnerItemStrings();
        ArrayAdapter<String> stringArrayAdapter = new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_list_item_1, strings);
        spinner.setAdapter(stringArrayAdapter);
    }

    public void Choice5spinner() {
        Spinner spinner = getView().findViewById(R.id.choice5spinner);
        String[] strings = myConstantUnit4.getChoiceSpinnerItemStrings();
        ArrayAdapter<String> stringArrayAdapter = new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_list_item_1, strings);
        spinner.setAdapter(stringArrayAdapter);
    }

    public void Choice6spinner() {
        Spinner spinner = getView().findViewById(R.id.choice6spinner);
        String[] strings = myConstantUnit4.getChoiceSpinnerItemStrings();
        ArrayAdapter<String> stringArrayAdapter = new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_list_item_1, strings);
        spinner.setAdapter(stringArrayAdapter);
    }

    public void Choice7spinner() {
        Spinner spinner = getView().findViewById(R.id.choice7spinner);
        String[] strings = myConstantUnit4.getChoiceSpinnerItemStrings();
        ArrayAdapter<String> stringArrayAdapter = new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_list_item_1, strings);
        spinner.setAdapter(stringArrayAdapter);
    }

    public void Choice8spinner() {
        Spinner spinner = getView().findViewById(R.id.choice8spinner);
        String[] strings = myConstantUnit4.getChoiceSpinnerItemStrings();
        ArrayAdapter<String> stringArrayAdapter = new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_list_item_1, strings);
        spinner.setAdapter(stringArrayAdapter);
    }

    public void Choice9spinner() {
        Spinner spinner = getView().findViewById(R.id.choice9spinner);
        String[] strings = myConstantUnit4.getChoiceSpinnerItemStrings();
        ArrayAdapter<String> stringArrayAdapter = new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_list_item_1, strings);
        spinner.setAdapter(stringArrayAdapter);
    }

    public void Choice10spinner() {
        Spinner spinner = getView().findViewById(R.id.choice10spinner);
        String[] strings = myConstantUnit4.getChoiceSpinnerItemStrings();
        ArrayAdapter<String> stringArrayAdapter = new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_list_item_1, strings);
        spinner.setAdapter(stringArrayAdapter);
    }

    public void Choice11spinner() {
        Spinner spinner = getView().findViewById(R.id.choice11spinner);
        String[] strings = myConstantUnit4.getChoiceSpinnerItemStrings();
        ArrayAdapter<String> stringArrayAdapter = new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_list_item_1, strings);
        spinner.setAdapter(stringArrayAdapter);
    }

    public void Choice12spinner() {
        Spinner spinner = getView().findViewById(R.id.choice12spinner);
        String[] strings = myConstantUnit4.getChoiceSpinnerItemStrings();
        ArrayAdapter<String> stringArrayAdapter = new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_list_item_1, strings);
        spinner.setAdapter(stringArrayAdapter);
    }

    public void Choice13spinner() {
        Spinner spinner = getView().findViewById(R.id.choice13spinner);
        String[] strings = myConstantUnit4.getChoiceSpinnerItemStrings();
        ArrayAdapter<String> stringArrayAdapter = new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_list_item_1, strings);
        spinner.setAdapter(stringArrayAdapter);
    }

    public void Choice14spinner() {
        Spinner spinner = getView().findViewById(R.id.choice14spinner);
        String[] strings = myConstantUnit4.getChoiceSpinnerItemStrings();
        ArrayAdapter<String> stringArrayAdapter = new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_list_item_1, strings);
        spinner.setAdapter(stringArrayAdapter);
    }

    public void Choice15spinner() {
        Spinner spinner = getView().findViewById(R.id.choice15spinner);
        String[] strings = myConstantUnit4.getChoiceSpinnerItemStrings();
        ArrayAdapter<String> stringArrayAdapter = new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_list_item_1, strings);
        spinner.setAdapter(stringArrayAdapter);
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
        View view = inflater.inflate(R.layout.fragment_unit4, container, false);
        return view;
    }
}
