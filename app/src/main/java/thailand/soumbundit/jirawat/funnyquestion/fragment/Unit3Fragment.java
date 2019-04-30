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
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;

import thailand.soumbundit.jirawat.funnyquestion.R;
import thailand.soumbundit.jirawat.funnyquestion.utility.MyConstant;
import thailand.soumbundit.jirawat.funnyquestion.utility.MyConstantUnit3;

public class Unit3Fragment extends Fragment {
    MyConstant myConstant = new MyConstant();
    MyConstantUnit3 myConstantUnit3 = new MyConstantUnit3();
    private String uidString, nameUnitString, timeTestString, warmUpString, presentString = "non", practiseString;
    Integer[] positionPractice1Ints = {0, 0, 0, 0};
    Integer[] positionPractice2Ints = {0, 0, 0, 0, 0,0};
    Integer[] positionPractice3Ints = {0, 0, 0, 0, 0, 0};
    Integer[] positionPractice4Ints = {0, 0, 0, 0, 0, 0};
    Integer[] positionPractice5Ints = {0, 0, 0, 0, 0, 0};
    int[] scoreListening1Ints = {0, 0, 0, 0};


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

        choiceSpinnerPractice1();
        choiceSpinnerPractice2();
        choiceSpinnerPractice3();
        choiceSpinnerPractice4();

        choiceSpinnerPractice5();
        choiceSpinnerPractice6();
        choiceSpinnerPractice7();
        choiceSpinnerPractice8();
        choiceSpinnerPractice9();
        choiceSpinnerPractice10();

        choiceSpinnerPractice11();
        choiceSpinnerPractice12();
        choiceSpinnerPractice13();
        choiceSpinnerPractice14();
        choiceSpinnerPractice15();
        choiceSpinnerPractice16();

        choiceSpinnerPractice17();
        choiceSpinnerPractice18();
        choiceSpinnerPractice19();
        choiceSpinnerPractice20();
        choiceSpinnerPractice21();
        choiceSpinnerPractice22();

        choiceSpinnerPractice23();
        choiceSpinnerPractice24();
        choiceSpinnerPractice25();
        choiceSpinnerPractice26();
        choiceSpinnerPractice27();
        choiceSpinnerPractice28();

        choiceSpinnerListening1();
        choiceSpinnerListening2();
        choiceSpinnerListening3();
        choiceSpinnerListening4();


        checkFloating();

    }//Main Method



    public  void  checkScoreListening1(int indexSpinner, int position){
        int [] answerListening1Ints = myConstantUnit3.getAnswerListening1Ints();
        if(position == answerListening1Ints[indexSpinner]){
            scoreListening1Ints[indexSpinner] = 1;
        }else
        {
            scoreListening1Ints[indexSpinner] = 0;
        }

    }

    public void  choiceSpinnerListening1() {
        String[] strings = myConstantUnit3.getListeningChoiceSpinner1();
        Spinner spinner = getView().findViewById(R.id.unit3SpinListening1);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1, strings);
        spinner.setAdapter(arrayAdapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
                checkScoreListening1(0,position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    public void  choiceSpinnerListening2() {
        String[] strings = myConstantUnit3.getListeningChoiceSpinner1();
        Spinner spinner = getView().findViewById(R.id.unit3SpinListening2);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1, strings);
        spinner.setAdapter(arrayAdapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
                checkScoreListening1(1,position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    public void  choiceSpinnerListening3() {
        String[] strings = myConstantUnit3.getListeningChoiceSpinner1();
        Spinner spinner = getView().findViewById(R.id.unit3SpinListening3);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1, strings);
        spinner.setAdapter(arrayAdapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
                checkScoreListening1(2,position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    public void  choiceSpinnerListening4() {
        String[] strings = myConstantUnit3.getListeningChoiceSpinner1();
        Spinner spinner = getView().findViewById(R.id.unit3SpinListening4);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1, strings);
        spinner.setAdapter(arrayAdapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
                checkScoreListening1(3,position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }







    public  void  getPositionPractice5(int indexSpinner, int position){
        positionPractice5Ints[indexSpinner] = position;
    }

    public  void  choiceSpinnerPractice23() {
        String[] strings = myConstantUnit3.getPracticeChoiceSpinner2();
        Spinner spinner = getView().findViewById(R.id.unit3SpinPractice23);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1, strings);
        spinner.setAdapter(arrayAdapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
                getPositionPractice5(0,position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

    }

    public  void  choiceSpinnerPractice24() {
        String[] strings = myConstantUnit3.getPracticeChoiceSpinner2();
        Spinner spinner = getView().findViewById(R.id.unit3SpinPractice24);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1, strings);
        spinner.setAdapter(arrayAdapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
                getPositionPractice5(1,position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

    }

    public  void  choiceSpinnerPractice25() {
        String[] strings = myConstantUnit3.getPracticeChoiceSpinner2();
        Spinner spinner = getView().findViewById(R.id.unit3SpinPractice25);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1, strings);
        spinner.setAdapter(arrayAdapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
                getPositionPractice5(2,position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

    }

    public  void  choiceSpinnerPractice26() {
        String[] strings = myConstantUnit3.getPracticeChoiceSpinner2();
        Spinner spinner = getView().findViewById(R.id.unit3SpinPractice26);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1, strings);
        spinner.setAdapter(arrayAdapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
                getPositionPractice5(3,position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

    }

    public  void  choiceSpinnerPractice27() {
        String[] strings = myConstantUnit3.getPracticeChoiceSpinner2();
        Spinner spinner = getView().findViewById(R.id.unit3SpinPractice27);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1, strings);
        spinner.setAdapter(arrayAdapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
                getPositionPractice5(4,position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

    }

    public  void  choiceSpinnerPractice28() {
        String[] strings = myConstantUnit3.getPracticeChoiceSpinner2();
        Spinner spinner = getView().findViewById(R.id.unit3SpinPractice28);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1, strings);
        spinner.setAdapter(arrayAdapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
                getPositionPractice5(5,position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

    }

    public  void  getPositionPractice4(int indexSpinner, int position){
        positionPractice4Ints[indexSpinner] = position;
    }

    public  void  choiceSpinnerPractice17() {
        String[] strings = myConstantUnit3.getPracticeChoiceSpinner2();
        Spinner spinner = getView().findViewById(R.id.unit3SpinPractice17);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1, strings);
        spinner.setAdapter(arrayAdapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
                getPositionPractice4(0,position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

    }

    public  void  choiceSpinnerPractice18() {
        String[] strings = myConstantUnit3.getPracticeChoiceSpinner2();
        Spinner spinner = getView().findViewById(R.id.unit3SpinPractice18);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1, strings);
        spinner.setAdapter(arrayAdapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
                getPositionPractice4(1,position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

    }

    public  void  choiceSpinnerPractice19() {
        String[] strings = myConstantUnit3.getPracticeChoiceSpinner2();
        Spinner spinner = getView().findViewById(R.id.unit3SpinPractice19);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1, strings);
        spinner.setAdapter(arrayAdapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
                getPositionPractice4(2,position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

    }

    public  void  choiceSpinnerPractice20() {
        String[] strings = myConstantUnit3.getPracticeChoiceSpinner2();
        Spinner spinner = getView().findViewById(R.id.unit3SpinPractice20);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1, strings);
        spinner.setAdapter(arrayAdapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
                getPositionPractice4(3,position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

    }

    public  void  choiceSpinnerPractice21() {
        String[] strings = myConstantUnit3.getPracticeChoiceSpinner2();
        Spinner spinner = getView().findViewById(R.id.unit3SpinPractice21);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1, strings);
        spinner.setAdapter(arrayAdapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
                getPositionPractice4(4,position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

    }

    public  void  choiceSpinnerPractice22() {
        String[] strings = myConstantUnit3.getPracticeChoiceSpinner2();
        Spinner spinner = getView().findViewById(R.id.unit3SpinPractice22);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1, strings);
        spinner.setAdapter(arrayAdapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
                getPositionPractice4(5,position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

    }

    public  void  getPositionPractice3(int indexSpinner, int position){
        positionPractice3Ints[indexSpinner] = position;
    }

    public  void  choiceSpinnerPractice11() {
        String[] strings = myConstantUnit3.getPracticeChoiceSpinner2();
        Spinner spinner = getView().findViewById(R.id.unit3SpinPractice11);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1, strings);
        spinner.setAdapter(arrayAdapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
                getPositionPractice3(0,position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

    }

    public  void  choiceSpinnerPractice12() {
        String[] strings = myConstantUnit3.getPracticeChoiceSpinner2();
        Spinner spinner = getView().findViewById(R.id.unit3SpinPractice12);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1, strings);
        spinner.setAdapter(arrayAdapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
                getPositionPractice3(1,position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

    }

    public  void  choiceSpinnerPractice13() {
        String[] strings = myConstantUnit3.getPracticeChoiceSpinner2();
        Spinner spinner = getView().findViewById(R.id.unit3SpinPractice13);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1, strings);
        spinner.setAdapter(arrayAdapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
                getPositionPractice3(2,position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

    }

    public  void  choiceSpinnerPractice14() {
        String[] strings = myConstantUnit3.getPracticeChoiceSpinner2();
        Spinner spinner = getView().findViewById(R.id.unit3SpinPractice14);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1, strings);
        spinner.setAdapter(arrayAdapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
                getPositionPractice3(3,position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

    }

    public  void  choiceSpinnerPractice15() {
        String[] strings = myConstantUnit3.getPracticeChoiceSpinner2();
        Spinner spinner = getView().findViewById(R.id.unit3SpinPractice15);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1, strings);
        spinner.setAdapter(arrayAdapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
                getPositionPractice3(4,position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

    }

    public  void  choiceSpinnerPractice16() {
        String[] strings = myConstantUnit3.getPracticeChoiceSpinner2();
        Spinner spinner = getView().findViewById(R.id.unit3SpinPractice16);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1, strings);
        spinner.setAdapter(arrayAdapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
                getPositionPractice3(5,position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

    }

    public  void  getPositionPractice2(int indexSpinner, int position){
        positionPractice2Ints[indexSpinner] = position;
    }

    public void choiceSpinnerPractice5() {
        String[] strings = myConstantUnit3.getPracticeChoiceSpinner2();
        Spinner spinner = getView().findViewById(R.id.unit3SpinPractice5);
        ArrayAdapter arrayAdapter = new ArrayAdapter(getActivity(), android.R.layout.simple_list_item_1, strings);
        spinner.setAdapter(arrayAdapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
                getPositionPractice2(0,position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    public void choiceSpinnerPractice6() {
        String[] strings = myConstantUnit3.getPracticeChoiceSpinner2();
        Spinner spinner = getView().findViewById(R.id.unit3SpinPractice6);
        ArrayAdapter arrayAdapter = new ArrayAdapter(getActivity(), android.R.layout.simple_list_item_1, strings);
        spinner.setAdapter(arrayAdapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
                getPositionPractice2(1,position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    public void choiceSpinnerPractice7() {
        String[] strings = myConstantUnit3.getPracticeChoiceSpinner2();
        Spinner spinner = getView().findViewById(R.id.unit3SpinPractice7);
        ArrayAdapter arrayAdapter = new ArrayAdapter(getActivity(), android.R.layout.simple_list_item_1, strings);
        spinner.setAdapter(arrayAdapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
                getPositionPractice2(2,position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    public void choiceSpinnerPractice8() {
        String[] strings = myConstantUnit3.getPracticeChoiceSpinner2();
        Spinner spinner = getView().findViewById(R.id.unit3SpinPractice8);
        ArrayAdapter arrayAdapter = new ArrayAdapter(getActivity(), android.R.layout.simple_list_item_1, strings);
        spinner.setAdapter(arrayAdapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
                getPositionPractice2(3,position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    public void choiceSpinnerPractice9() {
        String[] strings = myConstantUnit3.getPracticeChoiceSpinner2();
        Spinner spinner = getView().findViewById(R.id.unit3SpinPractice9);
        ArrayAdapter arrayAdapter = new ArrayAdapter(getActivity(), android.R.layout.simple_list_item_1, strings);
        spinner.setAdapter(arrayAdapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
                getPositionPractice2(4,position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    public void choiceSpinnerPractice10() {
        String[] strings = myConstantUnit3.getPracticeChoiceSpinner2();
        Spinner spinner = getView().findViewById(R.id.unit3SpinPractice10);
        ArrayAdapter arrayAdapter = new ArrayAdapter(getActivity(), android.R.layout.simple_list_item_1, strings);
        spinner.setAdapter(arrayAdapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
                getPositionPractice2(5,position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }


    public void getPositionPractice1(int indexSpinner, int position) {
        positionPractice1Ints[indexSpinner] = position;
        // Log.d(tag2, "positionPractice1Ints[" + indexSpinner + "] = " + position);
    }

    public void choiceSpinnerPractice1() {
        Spinner spinner = getView().findViewById(R.id.unit3SpinPractice1);
        String[] strings = myConstantUnit3.getPracticeChioceSpinner1();
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1, strings);
        spinner.setAdapter(arrayAdapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
                getPositionPractice1(0, position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    public void choiceSpinnerPractice2() {
        Spinner spinner = getView().findViewById(R.id.unit3SpinPractice2);
        String[] strings = myConstantUnit3.getPracticeChioceSpinner1();
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1, strings);
        spinner.setAdapter(arrayAdapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
                getPositionPractice1(1, position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    public void choiceSpinnerPractice3() {
        Spinner spinner = getView().findViewById(R.id.unit3SpinPractice3);
        String[] strings = myConstantUnit3.getPracticeChioceSpinner1();
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1, strings);
        spinner.setAdapter(arrayAdapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
                getPositionPractice1(2, position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    public void choiceSpinnerPractice4() {
        Spinner spinner = getView().findViewById(R.id.unit3SpinPractice4);
        String[] strings = myConstantUnit3.getPracticeChioceSpinner1();
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1, strings);
        spinner.setAdapter(arrayAdapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
                getPositionPractice1(3, position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

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

        calculatePractice1();
        calculatePractice2();
        calculatePractice3();
        calculatePractice4();
        calculatePractice5();

        calculatePractice6();

        calculatePractice7();

        calculateListening1();

    }

    private void calculateListening1() {
        int sumScore = 0;
        for (int i = 0; i < scoreListening1Ints.length; i += 1) {
            sumScore += scoreListening1Ints[i];
        }
        Log.d(tag2, "scoreListening1==>" + sumScore);
    }

    private void calculatePractice7() {
        int sumScore = 0;

        RadioButton radioButton1 = getView().findViewById(R.id.unit3RbPractice6d);
        RadioButton radioButton2 = getView().findViewById(R.id.unit3RbPractice7b);
        RadioButton radioButton3 = getView().findViewById(R.id.unit3RbPractice8c);
        RadioButton radioButton4 = getView().findViewById(R.id.unit3RbPractice9b);
        RadioButton radioButton5 = getView().findViewById(R.id.unit3RbPractice10a);
        RadioButton radioButton6 = getView().findViewById(R.id.unit3RbPractice11b);
        RadioButton radioButton7 = getView().findViewById(R.id.unit3RbPractice12c);
        RadioButton radioButton8 = getView().findViewById(R.id.unit3RbPractice13b);

        if (radioButton1.isChecked()) { sumScore += 1; }
        if (radioButton2.isChecked()) { sumScore += 1; }
        if (radioButton3.isChecked()) { sumScore += 1; }
        if (radioButton4.isChecked()) { sumScore += 1; }
        if (radioButton5.isChecked()) { sumScore += 1; }
        if (radioButton6.isChecked()) { sumScore += 1; }
        if (radioButton7.isChecked()) { sumScore += 1; }
        if (radioButton8.isChecked()) { sumScore += 1; }

        Log.d(tag2, "scorePractice7==>" + sumScore);
    }


    private void calculatePractice6() {
        int sumScore = 0;

        RadioButton radioButton1 = getView().findViewById(R.id.unit3RbPractice1False);
        RadioButton radioButton2 = getView().findViewById(R.id.unit3RbPractice2True);
        RadioButton radioButton3 = getView().findViewById(R.id.unit3RbPractice3True);
        RadioButton radioButton4 = getView().findViewById(R.id.unit3RbPractice4True);
        RadioButton radioButton5 = getView().findViewById(R.id.unit3RbPractice5False);

        if(radioButton1.isChecked()){ sumScore += 1;}
        if(radioButton2.isChecked()){ sumScore += 1;}
        if(radioButton3.isChecked()){ sumScore += 1;}
        if(radioButton4.isChecked()){ sumScore += 1;}
        if(radioButton5.isChecked()){ sumScore += 1;}

        Log.d(tag2, "scorePractice6==>" + sumScore);
    }

    private void calculatePractice5() {
        int sumScore =0;
        Integer intA;
        int[] trueAnswerInts = myConstantUnit3.getAnswerPractice5ints();

        Collection<Integer> list;
        List<Integer> newList;

        list = Arrays.asList(positionPractice5Ints);
        newList = new ArrayList<>(new HashSet<>(list));

        for (int i = 0; i < newList.size(); i += 1) {
            intA = newList.get(i);
            for (int i1 = 0; i1 < trueAnswerInts.length; i1 += 1) {
                if (intA.equals(trueAnswerInts[i1])) {
                    sumScore += 1;
                }
            }
        }
        Log.d(tag2, "scorePractice5==>" + sumScore);


    }

    private void calculatePractice4() {
        int sumScore =0;
        Integer intA;
        int[] trueAnswerInts = myConstantUnit3.getAnswerPractice4ints();

        Collection<Integer> list;
        List<Integer> newList;

        list = Arrays.asList(positionPractice4Ints);
        newList = new ArrayList<>(new HashSet<>(list));

        for (int i = 0; i < newList.size(); i += 1) {
            intA = newList.get(i);
            for (int i1 = 0; i1 < trueAnswerInts.length; i1 += 1) {
                if (intA.equals(trueAnswerInts[i1])) {
                    sumScore += 1;
                }
            }
        }
        Log.d(tag2, "scorePractice4==>" + sumScore);


    }

    private void calculatePractice3() {
        int sumScore =0;
        Integer intA;
        int[] trueAnswerInts = myConstantUnit3.getAnswerPractice3Ints();

        Collection<Integer> list;
        List<Integer> newList;

        list = Arrays.asList(positionPractice3Ints);
        newList = new ArrayList<>(new HashSet<>(list));

        for (int i = 0; i < newList.size(); i += 1) {
            intA = newList.get(i);
            for (int i1 = 0; i1 < trueAnswerInts.length; i1 += 1) {
                if (intA.equals(trueAnswerInts[i1])) {
                    sumScore += 1;
                }
            }
        }
        Log.d(tag2, "scorePractice3==>" + sumScore);


    }

    private void calculatePractice2() {
        int sumScore =0;
        Integer intA;
        int[] trueAnswerInts = myConstantUnit3.getAnswerPractice2Ints();

        Collection<Integer> list;
        List<Integer> newList;

        list = Arrays.asList(positionPractice2Ints);
        newList = new ArrayList<>(new HashSet<>(list));

        for (int i = 0; i < newList.size(); i += 1) {
            intA = newList.get(i);
            for (int i1 = 0; i1 < trueAnswerInts.length; i1 += 1) {
                if (intA.equals(trueAnswerInts[i1])) {
                    sumScore += 1;
                }
            }
        }
        Log.d(tag2, "scorePractice2==>" + sumScore);


    }

    private void calculatePractice1() {
        int sumScore = 0;
        Integer intA;
        int[] trueAnswerInts = myConstantUnit3.getAnswerPractice1Ints();

        Collection<Integer> list;
        List<Integer> newList;

        list = Arrays.asList(positionPractice1Ints);
        newList = new ArrayList<>(new HashSet<>(list));

        for (int i = 0; i < newList.size(); i += 1) {
            intA = newList.get(i);
            for (int i1 = 0; i1 < trueAnswerInts.length; i1 += 1) {
                if (intA.equals(trueAnswerInts[i1])) {
                    sumScore += 1;
                }
            }
        }
        Log.d(tag2, "scorePractice1==>" + sumScore);

    }

    private void calculateWarmUp() {
        int sumScore = 0;
        String[] strings = new String[4];
        String[] trueAnswerStrings1 = myConstantUnit3.getAnswerWarmUpString();
        String s;
        Collection<String> list;
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
                    sumScore += 1;
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
