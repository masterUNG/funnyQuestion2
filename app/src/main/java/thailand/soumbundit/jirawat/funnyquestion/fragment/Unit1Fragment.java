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
import android.widget.RadioGroup;
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
    private int[] scorePractise3Ints = new int[]{0, 0, 0, 0, 0, 0};

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

//      Answer Controlle
//      answer4Controller();

//      Practise3
        item1Spinner();
        item2Spinner();
        item3Spinner();
        item4Spinner();
        item5Spinner();
        item6Spinner();

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


        Languagework1spinner();
        //  Languagework2spinner();
        //  Languagework3spinner();
        //  Languagework4spinner();
        //  Languagework5spinner();
        //  Languagework6spinner();
        //  Languagework7spinner();
        //  Languagework8spinner();
        //  Languagework9spinner();

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
    }

    private void calculatePractise3() {
        int sumScorePractise3 = 0;
        for (int i = 0; i < scorePractise3Ints.length; i += 1) {
            sumScorePractise3 = sumScorePractise3 + scorePractise3Ints[i];
        }
        Log.d(tag2, "scorePractise3 ==>" + sumScorePractise3);
    }//calculatePractise3

    private void calculatePractise2() {

        Log.d(tag2, "Start calculatePractise2" );
        final int trueInt = R.id.radC; //Choice C is true


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

        EditText practise1EditText = getView().findViewById(R.id.edtPractice1);
        EditText practise2EditText = getView().findViewById(R.id.edtPractice2);
        EditText practise3EditText = getView().findViewById(R.id.edtPractice3);
        EditText practise4EditText = getView().findViewById(R.id.edtPractice4);
        EditText practise5EditText = getView().findViewById(R.id.edtPractice5);

        String[] strings = new String[5];
        strings[0] = practise1EditText.getText().toString().trim();
        strings[1] = practise2EditText.getText().toString().trim();
        strings[2] = practise3EditText.getText().toString().trim();
        strings[3] = practise4EditText.getText().toString().trim();
        strings[4] = practise5EditText.getText().toString().trim();


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
        warmUpString = Integer.toString(sumScoreInt);
        Log.d(tag, "warmUpString ==>" + warmUpString);
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

    private void Reading1spinner() {
        Spinner spinner = getView().findViewById(R.id.readingspinner1);
        String[] strings = myConstant.getChioceSpinner7Strings();
        ArrayAdapter<String> stringArrayAdapter = new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_list_item_1, strings);
        spinner.setAdapter(stringArrayAdapter);
    }

    private void Reading2spinner() {
        Spinner spinner = getView().findViewById(R.id.readingspinner2);
        String[] strings = myConstant.getChioceSpinner7Strings();
        ArrayAdapter<String> stringArrayAdapter = new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_list_item_1, strings);
        spinner.setAdapter(stringArrayAdapter);
    }

    private void Reading3spinner() {
        Spinner spinner = getView().findViewById(R.id.readingspinner3);
        String[] strings = myConstant.getChioceSpinner7Strings();
        ArrayAdapter<String> stringArrayAdapter = new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_list_item_1, strings);
        spinner.setAdapter(stringArrayAdapter);
    }

    private void Reading4spinner() {
        Spinner spinner = getView().findViewById(R.id.readingspinner4);
        String[] strings = myConstant.getChioceSpinner7Strings();
        ArrayAdapter<String> stringArrayAdapter = new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_list_item_1, strings);
        spinner.setAdapter(stringArrayAdapter);
    }

    private void Reading5spinner() {
        Spinner spinner = getView().findViewById(R.id.readingspinner5);
        String[] strings = myConstant.getChioceSpinner7Strings();
        ArrayAdapter<String> stringArrayAdapter = new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_list_item_1, strings);
        spinner.setAdapter(stringArrayAdapter);
    }

    private void Languagework1spinner() {
        Spinner spinner = getView().findViewById(R.id.languagework1spinner);
        String[] strings = myConstant.getChioceSpinner6Strings();
        ArrayAdapter<String> stringArrayAdapter = new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_list_item_1, strings);
        spinner.setAdapter(stringArrayAdapter);
    }

    private void Languagework2spinner() {
        Spinner spinner = getView().findViewById(R.id.languagework2spinner);
        String[] strings = myConstant.getChioceSpinner6Strings();
        ArrayAdapter<String> stringArrayAdapter = new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_list_item_1, strings);
        spinner.setAdapter(stringArrayAdapter);
    }

    private void Languagework3spinner() {
        Spinner spinner = getView().findViewById(R.id.languagework3spinner);
        String[] strings = myConstant.getChioceSpinner6Strings();
        ArrayAdapter<String> stringArrayAdapter = new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_list_item_1, strings);
        spinner.setAdapter(stringArrayAdapter);
    }

    private void Languagework4spinner() {
        Spinner spinner = getView().findViewById(R.id.languagework4spinner);
        String[] strings = myConstant.getChioceSpinner6Strings();
        ArrayAdapter<String> stringArrayAdapter = new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_list_item_1, strings);
        spinner.setAdapter(stringArrayAdapter);
    }

    private void Languagework5spinner() {
        Spinner spinner = getView().findViewById(R.id.languagework5spinner);
        String[] strings = myConstant.getChioceSpinner6Strings();
        ArrayAdapter<String> stringArrayAdapter = new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_list_item_1, strings);
        spinner.setAdapter(stringArrayAdapter);
    }

    private void Languagework6spinner() {
        Spinner spinner = getView().findViewById(R.id.languagework6spinner);
        String[] strings = myConstant.getChioceSpinner6Strings();
        ArrayAdapter<String> stringArrayAdapter = new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_list_item_1, strings);
        spinner.setAdapter(stringArrayAdapter);
    }

    private void Languagework7spinner() {
        Spinner spinner = getView().findViewById(R.id.languagework7spinner);
        String[] strings = myConstant.getChioceSpinner6Strings();
        ArrayAdapter<String> stringArrayAdapter = new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_list_item_1, strings);
        spinner.setAdapter(stringArrayAdapter);
    }

    private void Languagework8spinner() {
        Spinner spinner = getView().findViewById(R.id.languagework8spinner);
        String[] strings = myConstant.getChioceSpinner6Strings();
        ArrayAdapter<String> stringArrayAdapter = new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_list_item_1, strings);
        spinner.setAdapter(stringArrayAdapter);
    }

    private void Languagework9spinner() {
        Spinner spinner = getView().findViewById(R.id.languagework9spinner);
        String[] strings = myConstant.getChioceSpinner6Strings();
        ArrayAdapter<String> stringArrayAdapter = new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_list_item_1, strings);
        spinner.setAdapter(stringArrayAdapter);
    }


    private void Listening1spinner() {
        Spinner spinner = getView().findViewById(R.id.listening1spinner);
        String[] strings = myConstant.getChioceSpinner5Strings();
        ArrayAdapter<String> stringArrayAdapter = new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_list_item_1, strings);
        spinner.setAdapter(stringArrayAdapter);
    }

    private void Listening2spinner() {
        Spinner spinner = getView().findViewById(R.id.listening2spinner);
        String[] strings = myConstant.getChioceSpinner5Strings();
        ArrayAdapter<String> stringArrayAdapter = new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_list_item_1, strings);
        spinner.setAdapter(stringArrayAdapter);
    }

    private void Listening3spinner() {
        Spinner spinner = getView().findViewById(R.id.listening3spinner);
        String[] strings = myConstant.getChioceSpinner5Strings();
        ArrayAdapter<String> stringArrayAdapter = new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_list_item_1, strings);
        spinner.setAdapter(stringArrayAdapter);
    }

    private void Listening4spinner() {
        Spinner spinner = getView().findViewById(R.id.listening4spinner);
        String[] strings = myConstant.getChioceSpinner5Strings();
        ArrayAdapter<String> stringArrayAdapter = new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_list_item_1, strings);
        spinner.setAdapter(stringArrayAdapter);
    }

    private void Listening5spinner() {
        Spinner spinner = getView().findViewById(R.id.listening5spinner);
        String[] strings = myConstant.getChioceSpinner5Strings();
        ArrayAdapter<String> stringArrayAdapter = new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_list_item_1, strings);
        spinner.setAdapter(stringArrayAdapter);
    }

    private void Listening6spinner() {
        Spinner spinner = getView().findViewById(R.id.listening6spinner);
        String[] strings = myConstant.getChioceSpinner5Strings();
        ArrayAdapter<String> stringArrayAdapter = new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_list_item_1, strings);
        spinner.setAdapter(stringArrayAdapter);
    }

    private void Listening7spinner() {
        Spinner spinner = getView().findViewById(R.id.listening7spinner);
        String[] strings = myConstant.getChioceSpinner5Strings();
        ArrayAdapter<String> stringArrayAdapter = new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_list_item_1, strings);
        spinner.setAdapter(stringArrayAdapter);
    }

    private void Listening8spinner() {
        Spinner spinner = getView().findViewById(R.id.listening8spinner);
        String[] strings = myConstant.getChioceSpinner5Strings();
        ArrayAdapter<String> stringArrayAdapter = new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_list_item_1, strings);
        spinner.setAdapter(stringArrayAdapter);
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


    private void checkScorePractise3(int indexSpinner, int position) {
        int[] answerTrueInts = myConstant.getPractise3Ints();

        if (position == answerTrueInts[indexSpinner]) {
            scorePractise3Ints[indexSpinner] = 1;
        } else {
            scorePractise3Ints[indexSpinner] = 0;
        }
    }

    private void item1Spinner() {
        Spinner spinner = getView().findViewById(R.id.spinnerItem1);
        String[] strings = myConstant.getChioceSpinnerItemStrings();
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
        Spinner spinner = getView().findViewById(R.id.spinnerItem2);
        String[] strings = myConstant.getChioceSpinnerItemStrings();
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
        Spinner spinner = getView().findViewById(R.id.spinnerItem3);
        String[] strings = myConstant.getChioceSpinnerItemStrings();
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
        Spinner spinner = getView().findViewById(R.id.spinnerItem4);
        String[] strings = myConstant.getChioceSpinnerItemStrings();
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
        Spinner spinner = getView().findViewById(R.id.spinnerItem5);
        String[] strings = myConstant.getChioceSpinnerItemStrings();
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
        Spinner spinner = getView().findViewById(R.id.spinnerItem6);
        String[] strings = myConstant.getChioceSpinnerItemStrings();
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


    private void answer4Controller() {
        EditText editText = getView().findViewById(R.id.u1edtAnswer);

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
        Spinner spinner = getView().findViewById(R.id.u1spinner1);
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
        Spinner spinner = getView().findViewById(R.id.u1spinner2);
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
        Spinner spinner = getView().findViewById(R.id.u1spinner3);
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
