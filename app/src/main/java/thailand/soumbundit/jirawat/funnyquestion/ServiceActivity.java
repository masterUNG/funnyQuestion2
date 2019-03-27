package thailand.soumbundit.jirawat.funnyquestion;

import android.content.res.Configuration;
import android.support.annotation.Nullable;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import thailand.soumbundit.jirawat.funnyquestion.fragment.ServiceFragment;
import thailand.soumbundit.jirawat.funnyquestion.fragment.Unit1Fragment;
import thailand.soumbundit.jirawat.funnyquestion.fragment.Unit3Fragment;
import thailand.soumbundit.jirawat.funnyquestion.fragment.Unit4Fragment;
import thailand.soumbundit.jirawat.funnyquestion.utility.MyConstant;

public class ServiceActivity extends AppCompatActivity implements View.OnClickListener {

    private String nameUserString, uidUserString;
    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle actionBarDrawerToggle;
    private TextView unit1TextView, unit2TextView, unit3TextView,
            unit4TextView, unit5TextView, unit6TextView;

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
                    .add(R.id.contentServiceFragment, Unit3Fragment.unit3Instance(uidUserString))
                    .commit();
        }
    }

    private void unitController() {

        unit1TextView = findViewById(R.id.txtUnit1);
        unit2TextView = findViewById(R.id.txtUnit2);
        unit3TextView = findViewById(R.id.txtUnit3);
        unit4TextView = findViewById(R.id.txtUnit4);
        unit5TextView = findViewById(R.id.txtUnit5);
        unit6TextView = findViewById(R.id.txtUnit6);

        MyConstant myConstant = new MyConstant();
        String[] strings = myConstant.getUnitTitleStrings();
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

            case R.id.txtUnit1:
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.contentServiceFragment, Unit1Fragment.unit1Instance(uidUserString))
                        .commit();
                break;
            case R.id.txtUnit2:

                break;
            case R.id.txtUnit3:
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.contentServiceFragment, Unit3Fragment.unit3Instance(uidUserString))
                        .commit();

                break;
            case R.id.txtUnit4:
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.contentServiceFragment, Unit4Fragment.unit4Instance(uidUserString))
                        .commit();
                break;
            case R.id.txtUnit5:

                break;
            case R.id.txtUnit6:

                break;
        }


    } //onClick
} // Main Class
