package thailand.soumbundit.jirawat.funnyquestion.fragment;

import android.content.DialogInterface;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
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

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import thailand.soumbundit.jirawat.funnyquestion.R;
import thailand.soumbundit.jirawat.funnyquestion.utility.MyConstant;

public class Unit1Fragment extends Fragment {
    //    Explicit
    private MyConstant myConstant = new MyConstant();
    private MediaPlayer mediaPlayer1;
    private String uidString, nameUnitString, timeTestString, warmUpString, practiseString, listeningString, languageString, readingString;
    private String tag = "11NovV1";
    private String tag2 = "11NovV2";
    private int[] scoreWarmUpInts = new int[]{0, 0, 0};
    private int[] scorePractice2aInts = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
    private int[] scorePractise3Ints = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    private int[] scoreListening1Ints = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
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

        Practise1spinner();
        Practise2spinner();
        Practise3spinner();
        Practise4spinner();
        Practise5spinner();
        Practise6spinner();
        Practise7spinner();
        Practise8spinner();


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



/*
        Reading1spinner();
        Reading2spinner();
        Reading3spinner();
        Reading4spinner();
        Reading5spinner();
*/

//        Check Floating
        checkFloating();
        checkFloating2();

    } //Main Method

    public void checkFloating2() {
        FloatingActionButton floatingActionButton = getView().findViewById(R.id.floatingCheck2);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               // Uri uri = Uri.parse("http://line.me/ti/p/@so_jirawat");
               // Intent intent = new Intent(Intent.ACTION_VIEW, uri);
               // startActivity(intent);
            }
        });
    }

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
        builder.setMessage("Need to check answers?");
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
                myAlertDialog2();
            }
        });
        builder.show();
    }

    private void myAlertDialog2() {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        String[] strings = new String[8];
        builder.setCancelable(false);
        builder.setIcon(R.drawable.ic_action_alert);
        builder.setTitle("Summary Unit2 Score");

        strings[0] = "Warm-up section";
        strings[1] = "You got: " + warmUpString + "% of Score\n";
        strings[2] = "Practice section";
        strings[3] = "You got: " + practiseString + "% of Score\n";
        strings[4] = "Listening section";
        strings[5] = "You got: " + listeningString + "% of Score\n";
        strings[6] = "Language section";
        strings[7] = "You got: " + languageString + "% of Score\n";

        builder.setItems(strings, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });

        //builder.setMessage("You got: " + pretestScoreString +"/10");

        builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        builder.show();
    }

    public void processCheckScore() {
        int scoreWarmUp, scorePractice, scoreListening, scoreLanguage, scoreReading = 0;

        findTimeTest();
        scoreWarmUp = calculateWarmUp();
        scoreWarmUp += calculatePractise1();

        scorePractice = calculatePractice2();
        scorePractice += calculatePractice2a();
        scorePractice += calculatePractice3();
        scorePractice += calculatePractice4();

        scoreListening = calculateListening1();

        scoreLanguage = calculateLanguage1();

/*
        scoreReading = calculateReading1();
        scoreReading += calculateReading2();
        scoreReading += calculateReading3();
        scoreReading += calculateReading4();
*/

        warmUpString = calculatePercent(scoreWarmUp, 8);
        practiseString = calculatePercent(scorePractice, 34);
        listeningString = calculatePercent(scoreListening, 8);
        languageString = calculatePercent(scoreLanguage, 5);

        //       readingString = Integer.toString(scoreReading);

    }

    private String calculatePercent(int score, int hiScore) {
        float calPercent;
        calPercent = (float) score * 100 / hiScore;
        BigDecimal bd = new BigDecimal(calPercent);
        BigDecimal bdSetScale = bd.setScale(1, BigDecimal.ROUND_HALF_UP);
        return bdSetScale.toString();
    }

    private int calculatePractice2a() {
        int sumScoreInt = 0;
        for (int i = 0; i < scorePractice2aInts.length; i += 1) {
            sumScoreInt += scorePractice2aInts[i];
        }
        Log.d(tag2, "scorePractice2a==>" + sumScoreInt);
        return sumScoreInt;
    }

    /*
        private int calculateReading4() {
            int sumScore = 0;

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

            if (rbAnswer1.isChecked()) { sumScore += 1; }
            if (rbAnswer2.isChecked()) { sumScore += 1; }
            if (rbAnswer3.isChecked()) { sumScore += 1; }
            if (rbAnswer4.isChecked()) { sumScore += 1; }
            if (rbAnswer5.isChecked()) { sumScore += 1; }
            if (rbAnswer6.isChecked()) { sumScore += 1; }
            if (rbAnswer7.isChecked()) { sumScore += 1; }
            if (rbAnswer8.isChecked()) { sumScore += 1; }
            if (rbAnswer9.isChecked()) { sumScore += 1; }
            if (rbAnswer10.isChecked()) { sumScore += 1; }
            Log.d(tag2, "scoreReading4 ==>" + sumScore);
            return sumScore;
        }

        private int calculateReading3() {
            int sumScoreReading3 = 0;
            for (int i = 0; i < scoreReading3Ints.length; i += 1) {
                sumScoreReading3 += scoreReading3Ints[i];
            }
            Log.d(tag2, "ScoreReading3 ==>" + sumScoreReading3);
            return sumScoreReading3;
        }

        private int calculateReading2() {
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
            return sumScoreInt;
        }

        private int calculateReading1() {
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
            return sumScoreInt;
        }
    */
    private int calculateLanguage1() {
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
        return sumScoreInt;
    }

    private int calculateListening1() {
        int sumScoreListening1 = 0;
        for (int i = 0; i < scoreListening1Ints.length; i += 1) {
            sumScoreListening1 += scoreListening1Ints[i];
        }
        Log.d(tag2, "ScoreListening ==>" + sumScoreListening1);
        return sumScoreListening1;
    }//calculateListening1

    private int calculatePractice4() {

        int scorePractise4Int = 0;
        RadioButton rbAnswer01 = getView().findViewById(R.id.unit1RbPractice01False);
        RadioButton rbAnswer02 = getView().findViewById(R.id.unit1RbPractice02True);
        RadioButton rbAnswer03 = getView().findViewById(R.id.unit1RbPractice03True);
        RadioButton rbAnswer04 = getView().findViewById(R.id.unit1RbPractice04True);
        RadioButton rbAnswer05 = getView().findViewById(R.id.unit1RbPractice05True);

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
        return scorePractise4Int;

    }//calculatePractise4

    private int calculatePractice3() {
        int sumScorePractise3 = 0;
        for (int i = 0; i < scorePractise3Ints.length; i += 1) {
            sumScorePractise3 = sumScorePractise3 + scorePractise3Ints[i];
        }
        Log.d(tag2, "scorePractise3 ==>" + sumScorePractise3);
        return sumScorePractise3;
    }//calculatePractice3

    private int calculatePractice2() {
        int sumScore = 0;
        //final int trueInt = R.id.radC; //Choice C is true
        RadioButton rb_c = getView().findViewById(R.id.radC);
        if (rb_c.isChecked()) {
            sumScore += 1;
            Log.d(tag2, "scorePractise2==>" + 1);
        } else {
            Log.d(tag2, "scorePractise2==>" + 0);
        }
        return sumScore;
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

    private int calculatePractise1() {
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
        return scorePractise1Int;
    } //CalculatePractise1

    private int calculateWarmUp() {
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
        Log.d(tag, "warmUpString ==>" + warmUpString);
        return sumScoreInt;
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

    private void checkScorePractise2a(int indexSpinner, int position) {
        int[] answerTrueInts = myConstant.getPractise2aInts();
        if (position == answerTrueInts[indexSpinner]) {
            scorePractice2aInts[indexSpinner] += 1;
        } else {
            scorePractice2aInts[indexSpinner] = 0;
        }
    }

    private void Practise1spinner() {
        Spinner spinner = getView().findViewById(R.id.unit1SpinnerPractice1);
        String[] strings = myConstant.getPractice2aTrue();
        ArrayAdapter<String> stringArrayAdapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1, strings);
        spinner.setAdapter(stringArrayAdapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
                checkScorePractise2a(0, position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    private void Practise2spinner() {
        Spinner spinner = getView().findViewById(R.id.unit1SpinnerPractice2);
        String[] strings = myConstant.getPractice2aTrue();
        ArrayAdapter<String> stringArrayAdapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1, strings);
        spinner.setAdapter(stringArrayAdapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
                checkScorePractise2a(1, position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    private void Practise3spinner() {
        Spinner spinner = getView().findViewById(R.id.unit1SpinnerPractice3);
        String[] strings = myConstant.getPractice2aTrue();
        ArrayAdapter<String> stringArrayAdapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1, strings);
        spinner.setAdapter(stringArrayAdapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
                checkScorePractise2a(2, position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    private void Practise4spinner() {
        Spinner spinner = getView().findViewById(R.id.unit1SpinnerPractice4);
        String[] strings = myConstant.getPractice2aTrue();
        ArrayAdapter<String> stringArrayAdapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1, strings);
        spinner.setAdapter(stringArrayAdapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
                checkScorePractise2a(3, position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    private void Practise5spinner() {
        Spinner spinner = getView().findViewById(R.id.unit1SpinnerPractice5);
        String[] strings = myConstant.getPractice2aTrue();
        ArrayAdapter<String> stringArrayAdapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1, strings);
        spinner.setAdapter(stringArrayAdapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
                checkScorePractise2a(4, position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    private void Practise6spinner() {
        Spinner spinner = getView().findViewById(R.id.unit1SpinnerPractice6);
        String[] strings = myConstant.getPractice2aTrue();
        ArrayAdapter<String> stringArrayAdapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1, strings);
        spinner.setAdapter(stringArrayAdapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
                checkScorePractise2a(5, position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    private void Practise7spinner() {
        Spinner spinner = getView().findViewById(R.id.unit1SpinnerPractice7);
        String[] strings = myConstant.getPractice2aTrue();
        ArrayAdapter<String> stringArrayAdapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1, strings);
        spinner.setAdapter(stringArrayAdapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
                checkScorePractise2a(6, position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    private void Practise8spinner() {
        Spinner spinner = getView().findViewById(R.id.unit1SpinnerPractice8);
        String[] strings = myConstant.getPractice2aTrue();
        ArrayAdapter<String> stringArrayAdapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1, strings);
        spinner.setAdapter(stringArrayAdapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
                checkScorePractise2a(7, position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }


/*
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
*/

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


    @Override
    public void onStop() {
        super.onStop();
        mediaPlayer1.stop();
    }


}
