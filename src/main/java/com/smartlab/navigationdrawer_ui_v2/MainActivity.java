package com.smartlab.navigationdrawer_ui_v2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.widget.Toolbar;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

    public DrawerLayout drawerLayout;
    public ActionBarDrawerToggle actionBarDrawerToggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(getWindow().FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);



        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer,toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this::onOptionsItemSelected);

        displayMenu();
        /*// Get a reference to the NavigationView in your layout
        NavigationView navigationView = findViewById(R.id.my_drawer_layout);

// Get a reference to the Menu object of the NavigationView
        Menu menu = navigationView.getMenu();

// Inflate the new menu items from an XML file
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.drawer, menu);
        String[] newItems = { "New Item 1", "New Item 2", "New Item 3" };
        for (int i = 0; i < newItems.length; i++) {
            MenuItem item = menu.add(newItems[i]);
            // Set any additional properties of the MenuItem here, such as icons or ids
        }


// Add any additional properties to the new items as needed
        menu.findItem(R.id.newItems);

// Set an onClickListener for the new items if needed
        menu.findItem(R.id.newItems).setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                // Handle click on new item 1
                return true;
            }
        });

*/
    }



    private void displayMenu (){
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
      //  final DrawerLayout drawerLayout = (DrawerLayout) findViewById(R.id.my_drawer_layout);
        Menu menu = navigationView.getMenu();
        Menu subMenu = menu.addSubMenu("Added Menu");
        subMenu.add("Menu 1")
                        .setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
                            @Override
                            public boolean onMenuItemClick(@NonNull MenuItem item) {
                                Toast.makeText(getApplicationContext(), "Menu 1", Toast.LENGTH_SHORT).show();
                                return true;
                            }
                        });
        subMenu.add("Menu 2")
                .setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(@NonNull MenuItem item) {
                        Toast.makeText(getApplicationContext(), "Menu 2", Toast.LENGTH_SHORT).show();
                        return true;
                    }
                });
        subMenu.add("Menu 3")
                .setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(@NonNull MenuItem item) {
                        Toast.makeText(getApplicationContext(), "Menu 3", Toast.LENGTH_SHORT).show();
                        return true;
                    }
                });
        subMenu.add("Menu 4")
                .setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(@NonNull MenuItem item) {
                        Toast.makeText(getApplicationContext(), "Menu 4", Toast.LENGTH_SHORT).show();
                        return true;
                    }
                });

        navigationView.invalidate();
   //    drawerLayout.closeDrawers();

    }

    // override the onOptionsItemSelected()
    // function to implement
    // the item click listener callback
    // to open and close the navigation
    // drawer when the icon is clicked
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if (actionBarDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
    }
/*public class MainActivity extends AppCompatActivity {

    private DrawerLayout drawerLayout;
    private ListView drawerList;
    private ActionBarDrawerToggle drawerToggle;
    private String[] dynamicMenuItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize the Navigation Drawer
        drawerLayout = findViewById(R.id.drawer_layout);
        drawerList = findViewById(R.id.drawer_list);
        dynamicMenuItems = getResources().getStringArray(R.array.dynamic_menu_items);

        // Set up the ActionBarDrawerToggle
        drawerToggle = new ActionBarDrawerToggle(this, drawerLayout,
                R.string.drawer_open, R.string.drawer_close);
        drawerLayout.addDrawerListener(drawerToggle);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);

        // Populate the Navigation Drawer with the static and dynamic menu items
        populateDrawer();
    }

    private void populateDrawer() {
        NavigationView drawerList = findViewById(R.id.drawer_layout);
// Inflate the menu items from the menu.xml file
        Menu menu = drawerList.getMenu();
        getMenuInflater().inflate(R.menu.drawer, menu);

// Make the divider item visible
        menu.findItem(R.id.nav_divider).setVisible(true);

// Add the dynamic menu items to the Navigation Drawer
        SubMenu dynamicMenu = menu.addSubMenu("Dynamic Menu Items");
        for (String item : dynamicMenuItems) {
            dynamicMenu.add(item);
        }

// Set the click listener for the Navigation Drawer items
        drawerList.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                // Handle item selection
                int itemId = menuItem.getItemId();
                switch (itemId) {
                    case R.id.nav_static_item1:
                        // Do something for static menu item 1
                        break;
                    case R.id.nav_static_item2:
                        // Do something for static menu item 2
                        break;
                    // Handle other static menu items as needed
                }
                // Close the Navigation Drawer
                DrawerLayout drawerLayout = findViewById(R.id.drawer_layout);
                drawerLayout.closeDrawer(GravityCompat.START);
                return true;
            }
        });
    }
}*/
