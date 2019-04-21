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

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import thailand.soumbundit.jirawat.funnyquestion.R;
import thailand.soumbundit.jirawat.funnyquestion.utility.MyConstant;
import thailand.soumbundit.jirawat.funnyquestion.utility.MyConstantUnit2;

public class Unit2Fragment extends Fragment {

    MyConstant myConstant = new MyConstant();
    MyConstantUnit2 myConstantUnit2 = new MyConstantUnit2();
    private String uidString, nameUnitString, timeTestString, warmUpString, presentString = "non", practiseString;
    int[] scoreWarmUp1Ints = {0, 0, 0, 0, 0, 0, 0};
    int[] scorePractice1Ints = {0, 0, 0, 0, 0, 0, 0, 0};
    private String tag = "11NovV1";
    private String tag2 = "11NovV2";


    public static Unit2Fragment unit2Fragment(String uidString) {
        Unit2Fragment unit2Fragment = new Unit2Fragment();
        Bundle bundle = new Bundle();
        bundle.putString("Uid", uidString);
        unit2Fragment.setArguments(bundle);
        return unit2Fragment;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        findUidNameUnit();

        choiceWarmUpSpinner1();
        choiceWarmUpSpinner2();
        choiceWarmUpSpinner3();
        choiceWarmUpSpinner4();
        choiceWarmUpSpinner5();
        choiceWarmUpSpinner6();
        choiceWarmUpSpinner7();

        choicePracticeSpinner1();
        choicePracticeSpinner2();
        choicePracticeSpinner3();
        choicePracticeSpinner4();
        choicePracticeSpinner5();
        choicePracticeSpinner6();
        choicePracticeSpinner7();
        choicePracticeSpinner8();


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
        calculateWarmUp1();
        calculatePractice1();
        calculatePractice2();
        calculatePractice3();
        calculateListening1();
        calculateLanguage1();

    }

    private void calculateLanguage1() {
        int sumScore = 0;
        String string1, string2, string3;
        String[] trueAnswerStrings1 = myConstantUnit2.getLanguage1EditText();
        String[] trueAnswerStrings2 = myConstantUnit2.getLanguage2EditText();
        String[] trueAnswerStrings3 = myConstantUnit2.getLanguage3EditText();

        EditText editText1 = getView().findViewById(R.id.unit2EdtLanguage1);
        EditText editText2 = getView().findViewById(R.id.unit2EdtLanguage2);
        EditText editText3 = getView().findViewById(R.id.unit2EdtLanguage3);

        string1 = editText1.getText().toString().toLowerCase().trim();
        string2 = editText2.getText().toString().toLowerCase().trim();
        string3 = editText3.getText().toString().toLowerCase().trim();

        for (int i = 0; i < trueAnswerStrings1.length; i += 1) {
            if (string1.equals(trueAnswerStrings1[i])) {
                sumScore += 1;
            }
        }
        for (int i = 0; i < trueAnswerStrings2.length; i += 1) {
            if (string2.equals(trueAnswerStrings2[i])) {
                sumScore += 1;
            }
        }
        for (int i = 0; i < trueAnswerStrings3.length; i += 1) {
            if (string3.equals(trueAnswerStrings3[i])) {
                sumScore += 1;
            }
        }
        Log.d(tag2, "scoreLanguage==>" + sumScore);

    }

    private void calculateListening1() {
        int sumScore = 0;
        String[] trueAnswerStrings = myConstantUnit2.getListening1EditText();
        String[] strings = new String[10];
        EditText editText1 = getView().findViewById(R.id.unit2EdtListening1);
        EditText editText2 = getView().findViewById(R.id.unit2EdtListening2);
        EditText editText3 = getView().findViewById(R.id.unit2EdtListening3);
        EditText editText4 = getView().findViewById(R.id.unit2EdtListening4);
        EditText editText5 = getView().findViewById(R.id.unit2EdtListening5);
        EditText editText6 = getView().findViewById(R.id.unit2EdtListening6);
        EditText editText7 = getView().findViewById(R.id.unit2EdtListening7);
        EditText editText8 = getView().findViewById(R.id.unit2EdtListening8);
        EditText editText9 = getView().findViewById(R.id.unit2EdtListening9);
        EditText editText10 = getView().findViewById(R.id.unit2EdtListening10);

        strings[0] = editText1.getText().toString().trim();
        strings[1] = editText2.getText().toString().trim();
        strings[2] = editText3.getText().toString().trim();
        strings[3] = editText4.getText().toString().trim();
        strings[4] = editText5.getText().toString().trim();
        strings[5] = editText6.getText().toString().trim();
        strings[6] = editText7.getText().toString().trim();
        strings[7] = editText8.getText().toString().trim();
        strings[8] = editText9.getText().toString().trim();
        strings[9] = editText10.getText().toString().trim();

        for (int i = 0; i < trueAnswerStrings.length; i += 1) {
            strings[i] = strings[i].toLowerCase();
            if (strings[i].equals(trueAnswerStrings[i])) {
                sumScore +=1;
            }
        }
        Log.d(tag2, "scoreListening==>" + sumScore);


    }

    private void calculatePractice3() {
        int sumScore = 0;
        for (int i = 0; i < scorePractice1Ints.length; i += 1) {
            sumScore += scorePractice1Ints[i];
        }
        Log.d(tag2, "scorePractice3==>" + sumScore);
    }

    private void calculatePractice2() {
        int sumScore = 0;
        String[] strings = new String[5];
        String[] trueAnswerStrings = myConstantUnit2.getPractice1EditText();


        EditText editText1 = getView().findViewById(R.id.unit2EdtPractice1);
        EditText editText2 = getView().findViewById(R.id.unit2EdtPractice2);
        EditText editText3 = getView().findViewById(R.id.unit2EdtPractice3);
        EditText editText4 = getView().findViewById(R.id.unit2EdtPractice4);
        EditText editText5 = getView().findViewById(R.id.unit2EdtPractice5);

        strings[0] = editText1.getText().toString().trim();
        strings[1] = editText2.getText().toString().trim();
        strings[2] = editText3.getText().toString().trim();
        strings[3] = editText4.getText().toString().trim();
        strings[4] = editText5.getText().toString().trim();

        for (int i = 0; i < strings.length; i += 1) {
            strings[i] = strings[i].toLowerCase();
            if (strings[i].equals(trueAnswerStrings[i])) {
                sumScore += 1;
            }
        }
        Log.d(tag2, "scorePractice2=>" + sumScore);

    }

    private void calculatePractice1() {
        int sumScore = 0;
        RadioButton radioButton1 = getView().findViewById(R.id.unit2RbPractice1a);
        RadioButton radioButton2 = getView().findViewById(R.id.unit2RbPractice2b);
        RadioButton radioButton3 = getView().findViewById(R.id.unit2RbPractice3c);
        RadioButton radioButton4 = getView().findViewById(R.id.unit2RbPractice4a);
        RadioButton radioButton5 = getView().findViewById(R.id.unit2RbPractice5a);
        RadioButton radioButton6 = getView().findViewById(R.id.unit2RbPractice6b);
        RadioButton radioButton7 = getView().findViewById(R.id.unit2RbPractice7b);
        RadioButton radioButton8 = getView().findViewById(R.id.unit2RbPractice8a);

        if (radioButton1.isChecked()) {
            sumScore += 1;
        }
        if (radioButton2.isChecked()) {
            sumScore += 1;
        }
        if (radioButton3.isChecked()) {
            sumScore += 1;
        }
        if (radioButton4.isChecked()) {
            sumScore += 1;
        }
        if (radioButton5.isChecked()) {
            sumScore += 1;
        }
        if (radioButton6.isChecked()) {
            sumScore += 1;
        }
        if (radioButton7.isChecked()) {
            sumScore += 1;
        }
        if (radioButton8.isChecked()) {
            sumScore += 1;
        }
        Log.d(tag2, "scorePractice1==>" + sumScore);
    }

    private void calculateWarmUp1() {
        int sumScore = 0;
        for (int i = 0; i < scoreWarmUp1Ints.length; i++) {
            sumScore += scoreWarmUp1Ints[i];
        }
        Log.d(tag2, "scoreWarmup==>" + sumScore);
    }


    private void checkScorePractice(int indexSpinner, int position) {
        int[] answerWarmUp1TrueInts = myConstantUnit2.getAnswerPractice1TrueInts();
        if (position == answerWarmUp1TrueInts[indexSpinner]) {
            scorePractice1Ints[indexSpinner] = 1;
        } else {
            scorePractice1Ints[indexSpinner] = 0;
        }

    }

    private void choicePracticeSpinner1() {
        String[] strings = myConstantUnit2.getPractice1ChoiceSpinner();
        Spinner spinner = getView().findViewById(R.id.unit2SpinnerPractice1);
        ArrayAdapter<String> stringArrayAdapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1, strings);
        spinner.setAdapter(stringArrayAdapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
                checkScorePractice(0, position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

    }

    private void choicePracticeSpinner2() {
        String[] strings = myConstantUnit2.getPractice1ChoiceSpinner();
        Spinner spinner = getView().findViewById(R.id.unit2SpinnerPractice2);
        ArrayAdapter<String> stringArrayAdapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1, strings);
        spinner.setAdapter(stringArrayAdapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
                checkScorePractice(1, position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

    }

    private void choicePracticeSpinner3() {
        String[] strings = myConstantUnit2.getPractice1ChoiceSpinner();
        Spinner spinner = getView().findViewById(R.id.unit2SpinnerPractice3);
        ArrayAdapter<String> stringArrayAdapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1, strings);
        spinner.setAdapter(stringArrayAdapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
                checkScorePractice(2, position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

    }

    private void choicePracticeSpinner4() {
        String[] strings = myConstantUnit2.getPractice1ChoiceSpinner();
        Spinner spinner = getView().findViewById(R.id.unit2SpinnerPractice4);
        ArrayAdapter<String> stringArrayAdapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1, strings);
        spinner.setAdapter(stringArrayAdapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
                checkScorePractice(3, position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

    }

    private void choicePracticeSpinner5() {
        String[] strings = myConstantUnit2.getPractice1ChoiceSpinner();
        Spinner spinner = getView().findViewById(R.id.unit2SpinnerPractice5);
        ArrayAdapter<String> stringArrayAdapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1, strings);
        spinner.setAdapter(stringArrayAdapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
                checkScorePractice(4, position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

    }

    private void choicePracticeSpinner6() {
        String[] strings = myConstantUnit2.getPractice1ChoiceSpinner();
        Spinner spinner = getView().findViewById(R.id.unit2SpinnerPractice6);
        ArrayAdapter<String> stringArrayAdapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1, strings);
        spinner.setAdapter(stringArrayAdapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
                checkScorePractice(5, position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

    }

    private void choicePracticeSpinner7() {
        String[] strings = myConstantUnit2.getPractice1ChoiceSpinner();
        Spinner spinner = getView().findViewById(R.id.unit2SpinnerPractice7);
        ArrayAdapter<String> stringArrayAdapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1, strings);
        spinner.setAdapter(stringArrayAdapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
                checkScorePractice(6, position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

    }

    private void choicePracticeSpinner8() {
        String[] strings = myConstantUnit2.getPractice1ChoiceSpinner();
        Spinner spinner = getView().findViewById(R.id.unit2SpinnerPractice8);
        ArrayAdapter<String> stringArrayAdapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1, strings);
        spinner.setAdapter(stringArrayAdapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
                checkScorePractice(7, position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

    }


    private void checkScoreWarmUp(int indexSpinner, int position) {
        int[] answerWarmUp1TrueInts = myConstantUnit2.getAnswerWarmUp1TrueInts();
        if (position == answerWarmUp1TrueInts[indexSpinner]) {
            scoreWarmUp1Ints[indexSpinner] = 1;
        } else {
            scoreWarmUp1Ints[indexSpinner] = 0;
        }

    }


    private void choiceWarmUpSpinner1() {
        String[] strings = myConstantUnit2.getWarmUp1ChoiceSpinner();
        Spinner spinner = getView().findViewById(R.id.unit2SpinnerWarmUp1);
        ArrayAdapter<String> stringArrayAdapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1, strings);
        spinner.setAdapter(stringArrayAdapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
                checkScoreWarmUp(0, position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    private void choiceWarmUpSpinner2() {
        String[] strings = myConstantUnit2.getWarmUp1ChoiceSpinner();
        Spinner spinner = getView().findViewById(R.id.unit2SpinnerWarmUp2);
        ArrayAdapter<String> stringArrayAdapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1, strings);
        spinner.setAdapter(stringArrayAdapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
                checkScoreWarmUp(1, position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    private void choiceWarmUpSpinner3() {
        String[] strings = myConstantUnit2.getWarmUp1ChoiceSpinner();
        Spinner spinner = getView().findViewById(R.id.unit2SpinnerWarmUp3);
        ArrayAdapter<String> stringArrayAdapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1, strings);
        spinner.setAdapter(stringArrayAdapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
                checkScoreWarmUp(2, position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    private void choiceWarmUpSpinner4() {
        String[] strings = myConstantUnit2.getWarmUp1ChoiceSpinner();
        Spinner spinner = getView().findViewById(R.id.unit2SpinnerWarmUp4);
        ArrayAdapter<String> stringArrayAdapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1, strings);
        spinner.setAdapter(stringArrayAdapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
                checkScoreWarmUp(3, position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    private void choiceWarmUpSpinner5() {
        String[] strings = myConstantUnit2.getWarmUp1ChoiceSpinner();
        Spinner spinner = getView().findViewById(R.id.unit2SpinnerWarmUp5);
        ArrayAdapter<String> stringArrayAdapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1, strings);
        spinner.setAdapter(stringArrayAdapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
                checkScoreWarmUp(4, position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    private void choiceWarmUpSpinner6() {
        String[] strings = myConstantUnit2.getWarmUp1ChoiceSpinner();
        Spinner spinner = getView().findViewById(R.id.unit2SpinnerWarmUp6);
        ArrayAdapter<String> stringArrayAdapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1, strings);
        spinner.setAdapter(stringArrayAdapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
                checkScoreWarmUp(5, position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    private void choiceWarmUpSpinner7() {
        String[] strings = myConstantUnit2.getWarmUp1ChoiceSpinner();
        Spinner spinner = getView().findViewById(R.id.unit2SpinnerWarmUp7);
        ArrayAdapter<String> stringArrayAdapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1, strings);
        spinner.setAdapter(stringArrayAdapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
                checkScoreWarmUp(6, position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
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
        View view = inflater.inflate(R.layout.fragment_unit2, container, false);
        return view;
    }
}
