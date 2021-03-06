package com.example.ania.projekt;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

/** Główna klasa aplikacji. Ustawia widok activity_main.xml jako jedna z części głównego
 * interfejsu użytkownika oraz obsługuje jego aktywność.
 * @autor Anna Suwała
 */
public class MainActivity extends FragmentActivity {

    ViewPager viewPager = null;

    /** Metoda wywolujaca sie po uruchomieniu biezacej instancji. Uruchamia widok
     * activity_main.xml oraz steruje jego zachowaniem. */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewPager = (ViewPager) findViewById(R.id.pager);
        FragmentManager fragmentManager = getSupportFragmentManager();
        viewPager.setAdapter( new MyAdapter(fragmentManager));
    }

    /*
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
    */
}

/** Klasa zarzadzająca fragmentami należącymi do menu uzytkownika. */
class MyAdapter extends FragmentPagerAdapter {


    public MyAdapter(FragmentManager fm) {
        super(fm);
    }

    /** Metoda wywołująca odpowiednią klasę, reprezentujacą dany fragment/stronę, przypisaną do
     * danej pozycji p. */
    @Override
    public Fragment getItem(int i) {
        Fragment fragment=null;
        if(i==0)
        {
            fragment = new Glowna();
        }
        if(i==1)
        {
            fragment = new Uzytkownik();
        }
        if(i==2)
        {
            fragment = new Historia();
        }
        return fragment;
    }
    /** Metoda zwracajaca całkowita liczbę stron, należących do głównego menu. */
    @Override
    public int getCount() {
        return 3;
    }

    /** Metoda ustawiajaca tytuł strony w zalezności od aktualnego fragmenu/strony menu. */
    @Override
    public CharSequence getPageTitle(int position){

        if(position==0)
        {
            return "Home";
        }
        if(position==1)
        {
            return "User";
        }
        if(position==2)
        {
            return "History";
        }
        return null;
    }
}

