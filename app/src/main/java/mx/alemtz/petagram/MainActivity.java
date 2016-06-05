package mx.alemtz.petagram;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

import java.util.ArrayList;

import mx.alemtz.petagram.adapter.PageAdapter;
import mx.alemtz.petagram.fragments.Fragment2;
import mx.alemtz.petagram.fragments.Fragment_recyclerview;

public class MainActivity extends AppCompatActivity {

    private Toolbar actionbar;
    private TabLayout tablemain;
    private ViewPager viewpagermain;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        tablemain = (TabLayout) findViewById(R.id.tabmain);
        viewpagermain = (ViewPager) findViewById(R.id.viewpagermain);
        setUpViewPager();



        //define  toolbar
        actionbar = (Toolbar) findViewById(R.id.actionbar1);
        setSupportActionBar (actionbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        actionbar.setNavigationIcon(R.mipmap.footprint);
        SetNavigation();


    }

    private ArrayList<Fragment> agregarFragments (){
        ArrayList<Fragment> fragments = new ArrayList<>();
        fragments.add (new Fragment_recyclerview());
        fragments.add (new Fragment2());
        return fragments;
    }



    public void setUpViewPager (){
        viewpagermain.setAdapter(new PageAdapter(getSupportFragmentManager(), agregarFragments()));
        tablemain.setupWithViewPager(viewpagermain);
        tablemain.getTabAt(0).setIcon(R.mipmap.home);
        tablemain.getTabAt(1).setIcon(R.mipmap.dog);
    }







    //crea el menu de acciones
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_actions, menu);
        return true;
    }


    // le da vida al menu de acciones
    public boolean onOptionsItemSelected(MenuItem item) {
    switch (item.getItemId()) {
        case R.id.ic_next:
            Intent intent = new Intent(this,FavMascotas.class);
            startActivity (intent);
            break;
        case R.id.iccontacto:
            Intent intent1 = new Intent(this,Contacto.class);
            startActivity(intent1);
            break;
        case R.id.icacercade:
            Intent intent2 = new Intent (this, Bio.class);
            startActivity(intent2);
            break;

    }
        return super.onOptionsItemSelected(item);
    }

    public void SetNavigation (){
        //realizar alguna accion con el set navigation
        actionbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });
    }


}




