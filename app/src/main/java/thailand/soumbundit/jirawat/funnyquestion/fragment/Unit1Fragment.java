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
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import thailand.soumbundit.jirawat.funnyquestion.R;
import thailand.soumbundit.jirawat.funnyquestion.utility.MyConstant;

public class Unit1Fragment extends Fragment {
    //    Explicit
    private MyConstant myConstant = new MyConstant();
    private MediaPlayer mediaPlayer1;
    private String uidString, nameUnitString, timeTestString, warmUpString, presentString = "non", practiseString;
    private String tag = "11NovV1";
    private String tag2 = "11NovV2";
    private int[] scoreWarmUpInts = new int[]{0, 0, 0};
    private int[] scorePractise3Ints = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    private int[] scoreListening1Ints = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
    private int[] scoreReading3Ints = new int[]{0, 0, 0, 0, 0};

    public static Unit1Fragment unit1Instance(String uidString) {
        Unit1Fragment unit1Fragment = new Unit1Fragment();
        Bundle bundle = new Bundle();
        bundle.putString("Uid", uidString);
        unit1Fragment.setArguments(bundle);
        return unit1Fragment;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

//      Find UID, Find UnitName of User
        findUidNameUnit();
//      About Warm Up
        firstSpinner();

        secondSpinner();

        thirdSpinner();

//      Answer Controller
//      answer4Controller();

//      Practise3 Match the names of digital devices with the pictures
        item1Spinner();
        item2Spinner();
        item3Spinner();
        item4Spinner();
        item5Spinner();
        item6Spinner();
        item7Spinner();
        item8Spinner();
        item9Spinner();
        item10Spinner();
        item11Spinner();
        item12Spinner();
        item13Spinner();
        item14Spinner();
        item15Spinner();
        item16Spinner();
        item17Spinner();
        item18Spinner();
        item19Spinner();
        item20Spinner();


//      Practice :listening
        playMedia1();

        Listening1spinner();
        Listening2spinner();
        Listening3spinner();
        Listening4spinner();
        Listening5spinner();
        Listening6spinner();
        Listening7spinner();
        Listening8spinner();


        Reading1spinner();
        Reading2spinner();
        Reading3spinner();
        Reading4spinner();
        Reading5spinner();


//        Check Floating
        checkFloating();

    } //Main Method


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
        calculatePractise4();
        calculateListening1();
        calculateLanguage1();
        calculateReading1();
        calculateReading2();
        calculateReading3();
        calculateReading4();
    }

    private void calculateReading4() {
        int sumScoreInt = 0;

        RadioButton rbAnswer1 = getView().findViewById(R.id.unit1RbReading4True);
        RadioButton rbAnswer2 = getView().findViewById(R.id.unit1RbReading5True);
        RadioButton rbAnswer3 = getView().findViewById(R.id.unit1RbReading6True);
        RadioButton rbAnswer4 = getView().findViewById(R.id.unit1RbReading7True);
        RadioButton rbAnswer5 = getView().findViewById(R.id.unit1RbReading8True);
        RadioButton rbAnswer6 = getView().findViewById(R.id.unit1RbReading9True);
        RadioButton rbAnswer7 = getView().findViewById(R.id.unit1RbReading10True);
        RadioButton rbAnswer8 = getView().findViewById(R.id.unit1RbReading11True);
        RadioButton rbAnswer9 = getView().findViewById(R.id.unit1RbReading12True);
        RadioButton rbAnswer10 = getView().findViewById(R.id.unit1RbReading13True);

        if(rbAnswer1.isChecked()){
            sumScoreInt += 1;
        }
        if(rbAnswer2.isChecked()){
            sumScoreInt += 1;
        }
        if(rbAnswer3.isChecked()){
            sumScoreInt += 1;
        }
        if(rbAnswer4.isChecked()){
            sumScoreInt += 1;
        }
        if(rbAnswer5.isChecked()){
            sumScoreInt += 1;
        }
        if(rbAnswer6.isChecked()){
            sumScoreInt += 1;
        }
        if(rbAnswer7.isChecked()){
            sumScoreInt += 1;
        }
        if(rbAnswer8.isChecked()){
            sumScoreInt += 1;
        }
        if(rbAnswer9.isChecked()){
            sumScoreInt += 1;
        }
        if(rbAnswer10.isChecked()){
            sumScoreInt += 1;
        }
        Log.d(tag2, "scoreReading4 ==>" + sumScoreInt);
    }

    private void calculateReading3() {
        int sumScoreReading3 = 0;
        for(int i =0; i< scoreReading3Ints.length;i+=1){
            sumScoreReading3 += scoreReading3Ints[i];
        }
        Log.d(tag2,"ScoreReading3 ==>" + sumScoreReading3);
    }

    private void calculateReading2() {
        int sumScoreInt = 0;
        RadioButton rdAnswer1 = getView().findViewById(R.id.unit1RbReading1A);
        RadioButton rdAnswer2 = getView().findViewById(R.id.unit1RbReading2A);
        RadioButton rdAnswer3 = getView().findViewById(R.id.unit1RbReading3A);

        if (rdAnswer1.isChecked()) {
            sumScoreInt += 1;
        }
        if (rdAnswer2.isChecked()) {
            sumScoreInt += 1;
        }
        if (rdAnswer3.isChecked()) {
            sumScoreInt += 1;
        }

        Log.d(tag2, "scoreReading2 ==>" + sumScoreInt);

    }

    private void calculateReading1() {
        String[] trueAnswerString = myConstant.getReadingTrueString();
        String[] strings = new String[3];
        int sumScoreInt = 0;

        EditText edtReadingText1 = getView().findViewById(R.id.unit1EdtReading1);
        EditText edtReadingText2 = getView().findViewById(R.id.unit1EdtReading2);
        EditText edtReadingText3 = getView().findViewById(R.id.unit1EdtReading3);

        strings[0] = edtReadingText1.getText().toString().trim();
        strings[1] = edtReadingText2.getText().toString().trim();
        strings[2] = edtReadingText3.getText().toString().trim();

        for (int i = 0; i < strings.length; i += 1) {
            strings[i] = strings[i].toLowerCase();
            for (int i1 = 0; i1 < trueAnswerString.length; i1 += 1) {
                if (strings[i].equals(trueAnswerString[i1])) {
                    sumScoreInt += 1;
                }
            }
        }
        Log.d(tag2, "scoreReading1 ==>" + sumScoreInt);
    }

    private void calculateLanguage1() {
        String[] trueAnswerString = myConstant.getLanguageTrueString();
        String[] strings = new String[5];
        int sumScoreInt = 0;

        EditText edtLanuageText1 = getView().findViewById(R.id.unit1EdtLanguage1);
        EditText edtLanuageText2 = getView().findViewById(R.id.unit1EdtLanguage2);
        EditText edtLanuageText3 = getView().findViewById(R.id.unit1EdtLanguage3);
        EditText edtLanuageText4 = getView().findViewById(R.id.unit1EdtLanguage4);
        EditText edtLanuageText5 = getView().findViewById(R.id.unit1EdtLanguage5);

        strings[0] = edtLanuageText1.getText().toString().trim();
        strings[1] = edtLanuageText2.getText().toString().trim();
        strings[2] = edtLanuageText3.getText().toString().trim();
        strings[3] = edtLanuageText4.getText().toString().trim();
        strings[4] = edtLanuageText5.getText().toString().trim();


        for (int i = 0; i < strings.length; i += 1) {
            if (strings[i].equals(trueAnswerString[i])) {
                sumScoreInt += 1;
            }
        }

        Log.d(tag2, "ScoreLanguage ==>" + sumScoreInt);
    }

    private void calculateListening1() {
        int sumScoreListening1 = 0;
        for (int i = 0; i < scoreListening1Ints.length; i += 1) {
            sumScoreListening1 += scoreListening1Ints[i];
        }
        Log.d(tag2, "ScoreListening ==>" + sumScoreListening1);
    }//calculateListening1

    private void calculatePractise4() {

        int scorePractise4Int = 0;
        RadioButton rbAnswer01 = getView().findViewById(R.id.unit1RbPractice01False);
        RadioButton rbAnswer02 = getView().findViewById(R.id.unit1RbPractice02False);
        RadioButton rbAnswer03 = getView().findViewById(R.id.unit1RbPractice03False);
        RadioButton rbAnswer04 = getView().findViewById(R.id.unit1RbPractice04False);
        RadioButton rbAnswer05 = getView().findViewById(R.id.unit1RbPractice05False);

        if (rbAnswer01.isChecked()) {
            scorePractise4Int += 1;
        }
        if (rbAnswer02.isChecked()) {
            scorePractise4Int += 1;
        }
        if (rbAnswer03.isChecked()) {
            scorePractise4Int += 1;
        }
        if (rbAnswer04.isChecked()) {
            scorePractise4Int += 1;
        }
        if (rbAnswer05.isChecked()) {
            scorePractise4Int += 1;
        }
        Log.d(tag2, "scorePractise4 ==>" + scorePractise4Int);

    }//calculatePractise4

    private void calculatePractise3() {
        int sumScorePractise3 = 0;
        for (int i = 0; i < scorePractise3Ints.length; i += 1) {
            sumScorePractise3 = sumScorePractise3 + scorePractise3Ints[i];
        }
        Log.d(tag2, "scorePractise3 ==>" + sumScorePractise3);
    }//calculatePractise3

    private void calculatePractise2() {

        final int trueInt = R.id.radC; //Choice C is true
        RadioButton rb_c = getView().findViewById(R.id.radC);
        if (rb_c.isChecked()) {
            Log.d(tag2, "scorePractise2==>" + 1);
        } else {
            Log.d(tag2, "scorePractise2==>" + 0);
        }
        //final RadioGroup radioGroup = getView().findViewById(R.id.ragCpuStand);
       /*
        final int[] ints = {0};

        RadioGroup radioGroup = getView().findViewById(R.id.ragCpuStand);
        radioGroup.clearCheck();
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int i) {
                if (i == trueInt) {
                   // ints[0] = 1;
                }
            }
        });

        Log.d(tag2, "scorePractise2==>" + ints[0]);
       */


    }//calculatePractice2

    private void calculatePractise1() {
        int scorePractise1Int = 0;
        String[] trueAnswerStrings = myConstant.getPractice1TrueString();

        EditText practise1EditText = getView().findViewById(R.id.unit1EdtPractice1);
        EditText practise2EditText = getView().findViewById(R.id.unit1EdtPractice2);
        EditText practise3EditText = getView().findViewById(R.id.unit1EdtPractice3);
        EditText practise4EditText = getView().findViewById(R.id.unit1EdtPractice4);
        EditText practise5EditText = getView().findViewById(R.id.unit1EdtPractice5);

        String[] strings = new String[5];
        strings[0] = practise1EditText.getText().toString().trim();
        strings[1] = practise2EditText.getText().toString().trim();
        strings[2] = practise3EditText.getText().toString().trim();
        strings[3] = practise4EditText.getText().toString().trim();
        strings[4] = practise5EditText.getText().toString().trim();

        for (int i = 0; i < strings.length; i += 1) {
            strings[i] = strings[i].toLowerCase();
        }

        for (int i = 0; i < strings.length; i += 1) {
            for (int i1 = 0; i1 < trueAnswerStrings.length; i1 += 1) {

                if (strings[i].equals(trueAnswerStrings[i1])) {
                    scorePractise1Int += 1;
                }
            } //for2
        } //for1

        Log.d(tag2, "scorePractise1 ==>" + scorePractise1Int);
    } //CalculatePractise1

    private void calculateWarmUp() {
        int sumScoreInt = 0;
        for (int i = 0; i < scoreWarmUpInts.length; i += 1) {
            sumScoreInt = sumScoreInt + scoreWarmUpInts[i];
        }
        String[] trueAnswerString = myConstant.getWarmupTrueString();
        EditText editWarmUpText1 = getView().findViewById(R.id.unit1EdtWarmUp1);
        EditText editWarmUpText2 = getView().findViewById(R.id.unit1EdtWarmUp2);
        EditText editWarmUpText3 = getView().findViewById(R.id.unit1EdtWarmUp3);
        EditText editWarmUpText4 = getView().findViewById(R.id.unit1EdtWarmUp4);
        EditText editWarmUpText5 = getView().findViewById(R.id.unit1EdtWarmUp5);

        String[] strings = new String[5];
        strings[0] = editWarmUpText1.getText().toString().trim();
        strings[1] = editWarmUpText2.getText().toString().trim();
        strings[2] = editWarmUpText3.getText().toString().trim();
        strings[3] = editWarmUpText4.getText().toString().trim();
        strings[4] = editWarmUpText5.getText().toString().trim();

        for (int i = 0; i < strings.length; i += 1) {
            strings[i] = strings[i].toLowerCase();
            if (strings[i].equals(trueAnswerString[i])) {
                sumScoreInt += 1;
            }
        }//for1

        warmUpString = Integer.toString(sumScoreInt);
        Log.d(tag, "warmUpString ==>" + warmUpString);
    } //CalculateWarmUp

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

    private void checkScoreReading3(int indexSpinner, int position) {
        int[] answerTrueInts = myConstant.getReading3Ints();

        if (position == answerTrueInts[indexSpinner]) {
            scoreReading3Ints[indexSpinner] = 1;
        } else {
            scoreReading3Ints[indexSpinner] = 0;
        }
    }

    private void Reading1spinner() {
        Spinner spinner = getView().findViewById(R.id.unit1SpinnerReading1);
        String[] strings = myConstant.getChioceSpinner7Strings();
        ArrayAdapter<String> stringArrayAdapter = new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_list_item_1, strings);
        spinner.setAdapter(stringArrayAdapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
                checkScoreReading3(0, position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    private void Reading2spinner() {
        Spinner spinner = getView().findViewById(R.id.unit1SpinnerReading2);
        String[] strings = myConstant.getChioceSpinner7Strings();
        ArrayAdapter<String> stringArrayAdapter = new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_list_item_1, strings);
        spinner.setAdapter(stringArrayAdapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
                checkScoreReading3(1, position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    private void Reading3spinner() {
        Spinner spinner = getView().findViewById(R.id.unit1SpinnerReading3);
        String[] strings = myConstant.getChioceSpinner7Strings();
        ArrayAdapter<String> stringArrayAdapter = new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_list_item_1, strings);
        spinner.setAdapter(stringArrayAdapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
                checkScoreReading3(2, position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    private void Reading4spinner() {
        Spinner spinner = getView().findViewById(R.id.unit1SpinnerReading4);
        String[] strings = myConstant.getChioceSpinner7Strings();
        ArrayAdapter<String> stringArrayAdapter = new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_list_item_1, strings);
        spinner.setAdapter(stringArrayAdapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
                checkScoreReading3(3, position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    private void Reading5spinner() {
        Spinner spinner = getView().findViewById(R.id.unit1SpinnerReading5);
        String[] strings = myConstant.getChioceSpinner7Strings();
        ArrayAdapter<String> stringArrayAdapter = new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_list_item_1, strings);
        spinner.setAdapter(stringArrayAdapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
                checkScoreReading3(4, position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }


    private void checkScoreListening1(int indexSpinner, int position) {
        int[] answerTrueInts = myConstant.getListening1Ints();

        if (position == answerTrueInts[indexSpinner]) {
            scoreListening1Ints[indexSpinner] = 1;
        } else {
            scoreListening1Ints[indexSpinner] = 0;
        }
    }

    private void Listening1spinner() {
        Spinner spinner = getView().findViewById(R.id.unit1SpinnerListening1);
        String[] strings = myConstant.getChioceSpinner5Strings();
        ArrayAdapter<String> stringArrayAdapter = new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_list_item_1, strings);
        spinner.setAdapter(stringArrayAdapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
                checkScoreListening1(0, position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    private void Listening2spinner() {
        Spinner spinner = getView().findViewById(R.id.unit1SpinnerListening2);
        String[] strings = myConstant.getChioceSpinner5Strings();

        ArrayAdapter<String> stringArrayAdapter = new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_list_item_1, strings);
        spinner.setAdapter(stringArrayAdapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
                checkScoreListening1(1, position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    private void Listening3spinner() {
        Spinner spinner = getView().findViewById(R.id.unit1SpinnerListening3);
        String[] strings = myConstant.getChioceSpinner5Strings();

        ArrayAdapter<String> stringArrayAdapter = new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_list_item_1, strings);
        spinner.setAdapter(stringArrayAdapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
                checkScoreListening1(2, position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    private void Listening4spinner() {
        Spinner spinner = getView().findViewById(R.id.unit1SpinnerListening4);
        String[] strings = myConstant.getChioceSpinner5Strings();

        ArrayAdapter<String> stringArrayAdapter = new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_list_item_1, strings);
        spinner.setAdapter(stringArrayAdapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
                checkScoreListening1(3, position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    private void Listening5spinner() {
        Spinner spinner = getView().findViewById(R.id.unit1SpinnerListening5);
        String[] strings = myConstant.getChioceSpinner5Strings();

        ArrayAdapter<String> stringArrayAdapter = new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_list_item_1, strings);
        spinner.setAdapter(stringArrayAdapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
                checkScoreListening1(4, position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    private void Listening6spinner() {
        Spinner spinner = getView().findViewById(R.id.unit1SpinnerListening6);
        String[] strings = myConstant.getChioceSpinner5Strings();

        ArrayAdapter<String> stringArrayAdapter = new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_list_item_1, strings);
        spinner.setAdapter(stringArrayAdapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
                checkScoreListening1(5, position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    private void Listening7spinner() {
        Spinner spinner = getView().findViewById(R.id.unit1SpinnerListening7);
        String[] strings = myConstant.getChioceSpinner5Strings();

        ArrayAdapter<String> stringArrayAdapter = new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_list_item_1, strings);
        spinner.setAdapter(stringArrayAdapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
                checkScoreListening1(6, position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    private void Listening8spinner() {
        Spinner spinner = getView().findViewById(R.id.unit1SpinnerListening8);
        String[] strings = myConstant.getChioceSpinner5Strings();

        ArrayAdapter<String> stringArrayAdapter = new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_list_item_1, strings);
        spinner.setAdapter(stringArrayAdapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
                checkScoreListening1(7, position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }


    private void playMedia1() {
        mediaPlayer1 = MediaPlayer.create(Unit1Fragment.this.getActivity(), R.raw.unit1);

        final Button button1 = getView().findViewById(R.id.playMedia1);///*****
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mediaPlayer1.isPlaying()) {
                    mediaPlayer1.pause();
                    button1.setText("Resume");
                } else {
                    mediaPlayer1.start();
                    button1.setText("Pause");
                }
            }
        });
    }//Play Media Clip1

    // Practise 3 Match the names of digital devices with the pictures
    private void checkScorePractise3(int indexSpinner, int position) {
        int[] answerTrueInts = myConstant.getPractise3Ints();

        if (position == answerTrueInts[indexSpinner]) {
            scorePractise3Ints[indexSpinner] = 1;
        } else {
            scorePractise3Ints[indexSpinner] = 0;
        }
    }

    private void item1Spinner() {
        Spinner spinner = getView().findViewById(R.id.unit1spinnerItem01);
        String[] strings = myConstant.getChoiceSpinnerItemStrings();
        ArrayAdapter<String> stringArrayAdapter = new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_list_item_1, strings);
        spinner.setAdapter(stringArrayAdapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                checkScorePractise3(0, position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    private void item2Spinner() {
        Spinner spinner = getView().findViewById(R.id.unit1spinnerItem02);
        String[] strings = myConstant.getChoiceSpinnerItemStrings();
        ArrayAdapter<String> stringArrayAdapter = new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_list_item_1, strings);
        spinner.setAdapter(stringArrayAdapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                checkScorePractise3(1, position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    private void item3Spinner() {
        Spinner spinner = getView().findViewById(R.id.unit1spinnerItem03);
        String[] strings = myConstant.getChoiceSpinnerItemStrings();
        ArrayAdapter<String> stringArrayAdapter = new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_list_item_1, strings);
        spinner.setAdapter(stringArrayAdapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                checkScorePractise3(2, position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    private void item4Spinner() {
        Spinner spinner = getView().findViewById(R.id.unit1spinnerItem04);
        String[] strings = myConstant.getChoiceSpinnerItemStrings();
        ArrayAdapter<String> stringArrayAdapter = new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_list_item_1, strings);
        spinner.setAdapter(stringArrayAdapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                checkScorePractise3(3, position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    private void item5Spinner() {
        Spinner spinner = getView().findViewById(R.id.unit1spinnerItem05);
        String[] strings = myConstant.getChoiceSpinnerItemStrings();
        ArrayAdapter<String> stringArrayAdapter = new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_list_item_1, strings);
        spinner.setAdapter(stringArrayAdapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                checkScorePractise3(4, position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    private void item6Spinner() {
        Spinner spinner = getView().findViewById(R.id.unit1spinnerItem06);
        String[] strings = myConstant.getChoiceSpinnerItemStrings();
        ArrayAdapter<String> stringArrayAdapter = new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_list_item_1, strings);
        spinner.setAdapter(stringArrayAdapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                checkScorePractise3(5, position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    private void item7Spinner() {
        Spinner spinner = getView().findViewById(R.id.unit1spinnerItem07);
        String[] strings = myConstant.getChoiceSpinnerItemStrings();
        ArrayAdapter<String> stringArrayAdapter = new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_list_item_1, strings);
        spinner.setAdapter(stringArrayAdapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                checkScorePractise3(6, position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    private void item8Spinner() {
        Spinner spinner = getView().findViewById(R.id.unit1spinnerItem08);
        String[] strings = myConstant.getChoiceSpinnerItemStrings();
        ArrayAdapter<String> stringArrayAdapter = new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_list_item_1, strings);
        spinner.setAdapter(stringArrayAdapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                checkScorePractise3(7, position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    private void item9Spinner() {
        Spinner spinner = getView().findViewById(R.id.unit1spinnerItem09);
        String[] strings = myConstant.getChoiceSpinnerItemStrings();
        ArrayAdapter<String> stringArrayAdapter = new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_list_item_1, strings);
        spinner.setAdapter(stringArrayAdapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                checkScorePractise3(8, position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    private void item10Spinner() {
        Spinner spinner = getView().findViewById(R.id.unit1spinnerItem10);
        String[] strings = myConstant.getChoiceSpinnerItemStrings();
        ArrayAdapter<String> stringArrayAdapter = new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_list_item_1, strings);
        spinner.setAdapter(stringArrayAdapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                checkScorePractise3(9, position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    private void item11Spinner() {
        Spinner spinner = getView().findViewById(R.id.unit1spinnerItem11);
        String[] strings = myConstant.getChoiceSpinnerItemStrings();
        ArrayAdapter<String> stringArrayAdapter = new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_list_item_1, strings);
        spinner.setAdapter(stringArrayAdapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                checkScorePractise3(10, position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    private void item12Spinner() {
        Spinner spinner = getView().findViewById(R.id.unit1spinnerItem12);
        String[] strings = myConstant.getChoiceSpinnerItemStrings();
        ArrayAdapter<String> stringArrayAdapter = new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_list_item_1, strings);
        spinner.setAdapter(stringArrayAdapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                checkScorePractise3(11, position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    private void item13Spinner() {
        Spinner spinner = getView().findViewById(R.id.unit1spinnerItem13);
        String[] strings = myConstant.getChoiceSpinnerItemStrings();
        ArrayAdapter<String> stringArrayAdapter = new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_list_item_1, strings);
        spinner.setAdapter(stringArrayAdapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                checkScorePractise3(12, position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    private void item14Spinner() {
        Spinner spinner = getView().findViewById(R.id.unit1spinnerItem14);
        String[] strings = myConstant.getChoiceSpinnerItemStrings();
        ArrayAdapter<String> stringArrayAdapter = new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_list_item_1, strings);
        spinner.setAdapter(stringArrayAdapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                checkScorePractise3(13, position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    private void item15Spinner() {
        Spinner spinner = getView().findViewById(R.id.unit1spinnerItem15);
        String[] strings = myConstant.getChoiceSpinnerItemStrings();
        ArrayAdapter<String> stringArrayAdapter = new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_list_item_1, strings);
        spinner.setAdapter(stringArrayAdapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                checkScorePractise3(14, position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    private void item16Spinner() {
        Spinner spinner = getView().findViewById(R.id.unit1spinnerItem16);
        String[] strings = myConstant.getChoiceSpinnerItemStrings();
        ArrayAdapter<String> stringArrayAdapter = new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_list_item_1, strings);
        spinner.setAdapter(stringArrayAdapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                checkScorePractise3(15, position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    private void item17Spinner() {
        Spinner spinner = getView().findViewById(R.id.unit1spinnerItem17);
        String[] strings = myConstant.getChoiceSpinnerItemStrings();
        ArrayAdapter<String> stringArrayAdapter = new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_list_item_1, strings);
        spinner.setAdapter(stringArrayAdapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                checkScorePractise3(16, position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    private void item18Spinner() {
        Spinner spinner = getView().findViewById(R.id.unit1spinnerItem18);
        String[] strings = myConstant.getChoiceSpinnerItemStrings();
        ArrayAdapter<String> stringArrayAdapter = new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_list_item_1, strings);
        spinner.setAdapter(stringArrayAdapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                checkScorePractise3(17, position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    private void item19Spinner() {
        Spinner spinner = getView().findViewById(R.id.unit1spinnerItem19);
        String[] strings = myConstant.getChoiceSpinnerItemStrings();
        ArrayAdapter<String> stringArrayAdapter = new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_list_item_1, strings);
        spinner.setAdapter(stringArrayAdapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                checkScorePractise3(18, position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    private void item20Spinner() {
        Spinner spinner = getView().findViewById(R.id.unit1spinnerItem20);
        String[] strings = myConstant.getChoiceSpinnerItemStrings();
        ArrayAdapter<String> stringArrayAdapter = new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_list_item_1, strings);
        spinner.setAdapter(stringArrayAdapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                checkScorePractise3(19, position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    private void checkScore(int indexSpinner, int position, int[] answerTrueInts) {
        for (int i = 0; i < answerTrueInts.length; i += 1) {
            if (position == answerTrueInts[i]) {
                scoreWarmUpInts[indexSpinner] = 1;
                break;
            } else {
                scoreWarmUpInts[indexSpinner] = 0;
            }//for
        }//checkScore
    }


    private void firstSpinner() {
        Spinner spinner = getView().findViewById(R.id.unit1SpinnerWarmUp1);
        String[] strings = myConstant.getChoiceSpinner1Strings();
        ArrayAdapter<String> stringArrayAdapter = new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_list_item_1, strings);
        spinner.setAdapter(stringArrayAdapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                checkScore(0, position, myConstant.getAnswer1TrueInts());
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    private void secondSpinner() {
        Spinner spinner = getView().findViewById(R.id.unit1SpinnerWarmUp2);
        String[] strings = myConstant.getChoiceSpinner2Strings();
        ArrayAdapter<String> stringArrayAdapter = new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_list_item_1, strings);
        spinner.setAdapter(stringArrayAdapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                checkScore(1, position, myConstant.getAnswer2TrueInts());
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    private void thirdSpinner() {
        Spinner spinner = getView().findViewById(R.id.unit1SpinnerWarmUp3);
        String[] strings = myConstant.getChoiceSpinner3Strings();
        ArrayAdapter<String> stringArrayAdapter = new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_list_item_1, strings);
        spinner.setAdapter(stringArrayAdapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                checkScore(2, position, myConstant.getAnswer3TrueInts());
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_unit1, container, false);
        return view;
    }
}
