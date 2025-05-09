package hk.edu.hkmu.myapplication;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import androidx.appcompat.app.AlertDialog;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {
    private ListView listView;
    private RouteAdapter adapter;
    private Button modeBtn;
    private ThemeManager themeManager;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        listView = findViewById(R.id.listview);
        themeManager = new ThemeManager(this, listView);
        modeBtn = findViewById(R.id.modeBtn);


        // 使用 JsonHandlerThread 獲取路線數據
        JsonHandlerThread jsonHandlerThread = new JsonHandlerThread();
        jsonHandlerThread.start();
        try {
            jsonHandlerThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Show晒有咩路線  (拎左API 做完 Finish))
        adapter = new RouteAdapter(
                this,
                RouteList.routeList,
                R.layout.list_view_layout,
                new String[]{RouteList.ROUTE, RouteList.ORIG, RouteList.DEST},
                new int[]{R.id.route, R.id.orig, R.id.dest}
        );
        listView.setAdapter(adapter);

        //撳落去顯示有咩站(未做 未拎API)
        listView.setOnItemClickListener((parent, view, position, id) -> {
            HashMap<String, String> route = RouteList.routeList.get(position);
            AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
            LayoutInflater inflater = getLayoutInflater();
            View dialogView = inflater.inflate(R.layout.duallog_layout, null);
            builder.setView(dialogView);
            TextView dialogTitle = dialogView.findViewById(R.id.dialog_title);
            TextView dialogMessage = dialogView.findViewById(R.id.dialog_message);
            dialogTitle.setText(route.get(RouteList.ROUTE)); // 顯示路線名稱
            dialogMessage.setText("1: " + route.get(RouteList.ORIG) + "\n2:\n3:\n4:\n5:\n6:\n7:\n8:\n9:\n10:\n11: " + route.get(RouteList.DEST)); //顯示有咩站(未做)
            AlertDialog alertDialog = builder.create();
            alertDialog.show();
        });






        // 最底嗰行 主頁/收藏  (做完 Finish)
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnItemSelectedListener(item -> {
            if (item.getItemId() == R.id.navigation_home) {
                // 顯示所有路線
                updateAdapter(RouteList.routeList);
                return true;
            } else if (item.getItemId() == R.id.navigation_favorite) {
                // 顯示收藏的路線
                updateAdapter(RouteList.favoriteRoutes);
                return true;
            } else {
                return false;
            }
        });


        //黑夜模式  (做完 Finish)
        modeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                themeManager.toggleTheme(modeBtn, findViewById(R.id.main));
            }
        });

    }

    //用嚟同步收藏+轉mode  (做完 Finish)
    private void updateAdapter(ArrayList<HashMap<String, String>> routeList) {
        adapter = new RouteAdapter(
                this,
                routeList,
                R.layout.list_view_layout,
                new String[]{RouteList.ROUTE, RouteList.ORIG, RouteList.DEST},
                new int[]{R.id.route, R.id.orig, R.id.dest}
        );
        listView.setAdapter(adapter);

    }






}