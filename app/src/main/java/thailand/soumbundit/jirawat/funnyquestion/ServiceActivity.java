package thailand.soumbundit.jirawat.funnyquestion;

import android.content.res.Configuration;
import android.support.annotation.Nullable;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import thailand.soumbundit.jirawat.funnyquestion.fragment.PostUnit1Fragment;
import thailand.soumbundit.jirawat.funnyquestion.fragment.PostUnit2Fragment;
import thailand.soumbundit.jirawat.funnyquestion.fragment.PostUnit3Fragment;
import thailand.soumbundit.jirawat.funnyquestion.fragment.PreUnit1Fragment;
import thailand.soumbundit.jirawat.funnyquestion.fragment.PreUnit2Fragment;
import thailand.soumbundit.jirawat.funnyquestion.fragment.PreUnit3Fragment;
import thailand.soumbundit.jirawat.funnyquestion.fragment.PreUnit4Fragment;
import thailand.soumbundit.jirawat.funnyquestion.fragment.Unit1Fragment;
import thailand.soumbundit.jirawat.funnyquestion.fragment.Unit2Fragment;
import thailand.soumbundit.jirawat.funnyquestion.fragment.Unit3Fragment;
import thailand.soumbundit.jirawat.funnyquestion.fragment.Unit4Fragment;
import thailand.soumbundit.jirawat.funnyquestion.utility.MyConstant;

public class ServiceActivity extends AppCompatActivity implements View.OnClickListener {

    private String nameUserString, uidUserString;
    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle actionBarDrawerToggle;
    private TextView unit1TextView, unit2TextView, unit3TextView, unit4TextView, unit5TextView, unit6TextView,
            preUnit1TextView, preUnit2TextView, preUnit3TextView, preUnit4TextView, preUnit5TextView, preUnit6TextView,
            postUnit1TextView, postUnit2TextView, postUnit3TextView, postUnit4TextView, postUnit5TextView, postUnit6TextView;

    private ImageView unit1ImgView, unit2ImgView, unit3ImgView, unit4ImgView, unit5ImgView, unit6ImgView,
            preUnit1ImgView, preUnit2ImgView, preUnit3ImgView, preUnit4ImgView, preUnit5ImgView, preUnit6ImgView,
            postUnit1ImgView, postUnit2ImgView, postUnit3ImgView, postUnit4ImgView, postUnit5ImgView, postUnit6ImgView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service);

//        Find User
        findUser();

//        Create Toolbar
        createToolbar();
//          Unit Controller
        unitController();

//        Add Fragment
        addFragment(savedInstanceState);

    }  //Main Method

    private void addFragment(Bundle savedInstanceState) {
        if (savedInstanceState == null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .add(R.id.contentServiceFragment, Unit1Fragment.unit1Instance(uidUserString))
                    .commit();
            unit1ImgView.setImageResource(R.drawable.ic_action_check_ok);
        }
    }

    private void unitController() {
        MyConstant myConstant = new MyConstant();
        String[] strings = myConstant.getUnitTitleStrings();

        setPreUnitController(strings);
        setUnitController(strings);
        setPostUnitController(strings);

    }


    private void setPreUnitController(String[] strings) {
        preUnit1TextView = findViewById(R.id.txtPreUnit1);
        preUnit2TextView = findViewById(R.id.txtPreUnit2);
        preUnit3TextView = findViewById(R.id.txtPreUnit3);
        preUnit4TextView = findViewById(R.id.txtPreUnit4);
        preUnit5TextView = findViewById(R.id.txtPreUnit5);
        preUnit6TextView = findViewById(R.id.txtPreUnit6);

        preUnit1ImgView = findViewById(R.id.imgPreUnit1);
        preUnit2ImgView = findViewById(R.id.imgPreUnit2);
        preUnit3ImgView = findViewById(R.id.imgPreUnit3);
        preUnit4ImgView = findViewById(R.id.imgPreUnit4);
        preUnit5ImgView = findViewById(R.id.imgPreUnit5);
        preUnit6ImgView = findViewById(R.id.imgPreUnit6);

        preUnit1TextView.setText(strings[0]);
        preUnit2TextView.setText(strings[1]);
        preUnit3TextView.setText(strings[2]);
        preUnit4TextView.setText(strings[3]);
        preUnit5TextView.setText(strings[4]);
        preUnit6TextView.setText(strings[5]);

        preUnit1TextView.setOnClickListener(ServiceActivity.this);
        preUnit2TextView.setOnClickListener(ServiceActivity.this);
        preUnit3TextView.setOnClickListener(ServiceActivity.this);
        preUnit4TextView.setOnClickListener(ServiceActivity.this);
        preUnit5TextView.setOnClickListener(ServiceActivity.this);
        preUnit6TextView.setOnClickListener(ServiceActivity.this);
    }

    private void setUnitController(String[] strings) {
        unit1TextView = findViewById(R.id.txtUnit1);
        unit2TextView = findViewById(R.id.txtUnit2);
        unit3TextView = findViewById(R.id.txtUnit3);
        unit4TextView = findViewById(R.id.txtUnit4);
        unit5TextView = findViewById(R.id.txtUnit5);
        unit6TextView = findViewById(R.id.txtUnit6);

        unit1ImgView = findViewById(R.id.imgUnit1);
        unit2ImgView = findViewById(R.id.imgUnit2);
        unit3ImgView = findViewById(R.id.imgUnit3);
        unit4ImgView = findViewById(R.id.imgUnit4);
        unit5ImgView = findViewById(R.id.imgUnit5);
        unit6ImgView = findViewById(R.id.imgUnit6);

        unit1TextView.setText(strings[0]);
        unit2TextView.setText(strings[1]);
        unit3TextView.setText(strings[2]);
        unit4TextView.setText(strings[3]);
        unit5TextView.setText(strings[4]);
        unit6TextView.setText(strings[5]);

        unit1TextView.setOnClickListener(ServiceActivity.this);
        unit2TextView.setOnClickListener(ServiceActivity.this);
        unit3TextView.setOnClickListener(ServiceActivity.this);
        unit4TextView.setOnClickListener(ServiceActivity.this);
        unit5TextView.setOnClickListener(ServiceActivity.this);
        unit6TextView.setOnClickListener(ServiceActivity.this);
    }

    private void setPostUnitController(String[] strings) {
        postUnit1TextView = findViewById(R.id.txtPostUnit1);
        postUnit2TextView = findViewById(R.id.txtPostUnit2);
        postUnit3TextView = findViewById(R.id.txtPostUnit3);
        postUnit4TextView = findViewById(R.id.txtPostUnit4);
        postUnit5TextView = findViewById(R.id.txtPostUnit5);
        postUnit6TextView = findViewById(R.id.txtPostUnit6);

        postUnit1ImgView = findViewById(R.id.imgPostUnit1);
        postUnit2ImgView = findViewById(R.id.imgPostUnit2);
        postUnit3ImgView = findViewById(R.id.imgPostUnit3);
        postUnit4ImgView = findViewById(R.id.imgPostUnit4);
        postUnit5ImgView = findViewById(R.id.imgPostUnit5);
        postUnit6ImgView = findViewById(R.id.imgPostUnit6);

        postUnit1TextView.setText(strings[0]);
        postUnit2TextView.setText(strings[1]);
        postUnit3TextView.setText(strings[2]);
        postUnit4TextView.setText(strings[3]);
        postUnit5TextView.setText(strings[4]);
        postUnit6TextView.setText(strings[5]);

        postUnit1TextView.setOnClickListener(ServiceActivity.this);
        postUnit2TextView.setOnClickListener(ServiceActivity.this);
        postUnit3TextView.setOnClickListener(ServiceActivity.this);
        postUnit4TextView.setOnClickListener(ServiceActivity.this);
        postUnit5TextView.setOnClickListener(ServiceActivity.this);
        postUnit6TextView.setOnClickListener(ServiceActivity.this);
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        actionBarDrawerToggle.onConfigurationChanged(newConfig);
    }

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        actionBarDrawerToggle.syncState();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.itemExit) {
            myExit();
        }

        if (actionBarDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }


        return super.onOptionsItemSelected(item);
    }

    private void myExit() {
//        Sign Out
        FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();
        firebaseAuth.signOut();

//        Exit_App
        finish();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_service, menu);
        return super.onCreateOptionsMenu(menu);
    }

    private void findUser() {
        FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();
        FirebaseUser firebaseUser = firebaseAuth.getCurrentUser();
        nameUserString = firebaseUser.getDisplayName();
        uidUserString = firebaseUser.getUid();
    }

    private void createToolbar() {
        Toolbar toolbar = findViewById(R.id.toolbarService);
        setSupportActionBar(toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setSubtitle("Welcome " + nameUserString);

        drawerLayout = findViewById(R.id.drawerLayoutService);
        actionBarDrawerToggle = new ActionBarDrawerToggle(
                ServiceActivity.this,
                drawerLayout,
                R.string.open,
                R.string.close
        );

        drawerLayout.setDrawerListener(actionBarDrawerToggle);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }

    @Override
    public void onClick(View view) {

        drawerLayout.closeDrawers();
        int index = 0;
        switch (view.getId()) {
            case R.id.txtPreUnit1:
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.contentServiceFragment, PreUnit1Fragment.preUnit1Fragment(uidUserString))
                        .commit();
                setCheckImage("PreUnit1");
                break;


            case R.id.txtPreUnit2:
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.contentServiceFragment, PreUnit2Fragment.preUnit2Fragment(uidUserString))
                        .commit();
                setCheckImage("PreUnit2");
                break;

            case R.id.txtPreUnit3:
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.contentServiceFragment, PreUnit3Fragment.preUnit3Fragment(uidUserString))
                        .commit();
                setCheckImage("PreUnit3");
                break;

            case R.id.txtPreUnit4:
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.contentServiceFragment, PreUnit4Fragment.preUnit4Fragment(uidUserString))
                        .commit();
                setCheckImage("PreUnit4");

                break;

            case R.id.txtPreUnit5:

                break;

            case R.id.txtPreUnit6:

                break;

            case R.id.txtUnit1:
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.contentServiceFragment, Unit1Fragment.unit1Instance(uidUserString))
                        .commit();
                setCheckImage("Unit1");
                break;
            case R.id.txtUnit2:
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.contentServiceFragment, Unit2Fragment.unit2Fragment(uidUserString))
                        .commit();
                setCheckImage("Unit2");
                break;
            case R.id.txtUnit3:
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.contentServiceFragment, Unit3Fragment.unit3Instance(uidUserString))
                        .commit();
                setCheckImage("Unit3");
                break;
            case R.id.txtUnit4:
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.contentServiceFragment, Unit4Fragment.unit4Instance(uidUserString))
                        .commit();
                setCheckImage("Unit4");
                break;
            case R.id.txtUnit5:

                break;
            case R.id.txtUnit6:

                break;


            case R.id.txtPostUnit1:
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.contentServiceFragment, PostUnit1Fragment.postUnit1Fragment(uidUserString))
                        .commit();
                setCheckImage("PostUnit1");
                break;


            case R.id.txtPostUnit2:
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.contentServiceFragment, PostUnit2Fragment.postUnit2Fragment(uidUserString))
                        .commit();
                setCheckImage("PostUnit2");
                break;

            case R.id.txtPostUnit3:
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.contentServiceFragment, PostUnit3Fragment.postUnit3Fragment(uidUserString))
                        .commit();
                setCheckImage("PostUnit3");
                break;

            case R.id.txtPostUnit4:

                break;

            case R.id.txtPostUnit5:

                break;

            case R.id.txtPostUnit6:

                break;

        }


    } //onClick

    private void setCheckImage(String position) {
        if (position.equals("PreUnit1"))
            preUnit1ImgView.setImageResource(R.drawable.ic_action_check_ok);
        else preUnit1ImgView.setImageResource(R.drawable.ic_action_rectangle);

        if (position.equals("PreUnit2"))
            preUnit2ImgView.setImageResource(R.drawable.ic_action_check_ok);
        else preUnit2ImgView.setImageResource(R.drawable.ic_action_rectangle);

        if (position.equals("PreUnit3"))
            preUnit3ImgView.setImageResource(R.drawable.ic_action_check_ok);
        else preUnit3ImgView.setImageResource(R.drawable.ic_action_rectangle);

        if (position.equals("PreUnit4"))
            preUnit4ImgView.setImageResource(R.drawable.ic_action_check_ok);
        else preUnit4ImgView.setImageResource(R.drawable.ic_action_rectangle);

        if (position.equals("Unit1"))
            unit1ImgView.setImageResource(R.drawable.ic_action_check_ok);
        else unit1ImgView.setImageResource(R.drawable.ic_action_rectangle);

        if (position.equals("Unit2"))
            unit2ImgView.setImageResource(R.drawable.ic_action_check_ok);
        else unit2ImgView.setImageResource(R.drawable.ic_action_rectangle);

        if (position.equals("Unit3"))
            unit3ImgView.setImageResource(R.drawable.ic_action_check_ok);
        else unit3ImgView.setImageResource(R.drawable.ic_action_rectangle);

        if (position.equals("Unit4"))
            unit4ImgView.setImageResource(R.drawable.ic_action_check_ok);
        else unit4ImgView.setImageResource(R.drawable.ic_action_rectangle);

        if (position.equals("PostUnit1"))
            postUnit1ImgView.setImageResource(R.drawable.ic_action_check_ok);
        else postUnit1ImgView.setImageResource(R.drawable.ic_action_rectangle);

        if (position.equals("PostUnit2"))
            postUnit2ImgView.setImageResource(R.drawable.ic_action_check_ok);
        else postUnit2ImgView.setImageResource(R.drawable.ic_action_rectangle);

        if (position.equals("PostUnit3"))
            postUnit3ImgView.setImageResource(R.drawable.ic_action_check_ok);
        else postUnit3ImgView.setImageResource(R.drawable.ic_action_rectangle);

    }


} // Main Class
