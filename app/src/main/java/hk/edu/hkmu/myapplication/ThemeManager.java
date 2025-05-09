package hk.edu.hkmu.myapplication;
import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ListView;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar; // 導入 Toolbar 類
import androidx.core.content.ContextCompat;

import com.google.android.material.bottomnavigation.BottomNavigationView;
//set 日間/黑夜模式 Finish
public class ThemeManager {
    public static boolean isDarkMode = false;
    private ListView listView;
    private Context context;



    public ThemeManager(Context context, ListView listView) {
        this.context = context;
        this.listView = listView;
    }

    public void toggleTheme(Button modeBtn, View rootView) {
        isDarkMode = !isDarkMode;
        Toolbar myToolbar = rootView.findViewById(R.id.my_toolbar);
        BottomNavigationView bottomNavigationView = rootView.findViewById(R.id.bottom_navigation);
        EditText searchBox = rootView.findViewById(R.id.search_box);
        FrameLayout mainLayout = rootView.findViewById(R.id.main);

        if (isDarkMode) {
            modeBtn.setText("白");
            setTextColor(rootView, Color.WHITE);
            listView.setBackgroundColor(ContextCompat.getColor(context, R.color.listbgB));
            myToolbar.setBackgroundColor(Color.BLACK);
            bottomNavigationView.setBackgroundColor(Color.BLACK);
            bottomNavigationView.setItemIconTintList(ContextCompat.getColorStateList(context, R.color.white));

            searchBox.setTextColor(Color.WHITE);
            searchBox.setHintTextColor(Color.LTGRAY);
            mainLayout.setBackgroundColor(ContextCompat.getColor(context, R.color.black));
        } else {
            modeBtn.setText("黑");
            setTextColor(rootView, Color.BLACK);
            listView.setBackgroundColor(ContextCompat.getColor(context, R.color.listbgW));
            myToolbar.setBackgroundColor(ContextCompat.getColor(context, R.color.red));
            bottomNavigationView.setBackgroundColor(ContextCompat.getColor(context, R.color.red));
            bottomNavigationView.setItemIconTintList(ContextCompat.getColorStateList(context, R.color.black));
            searchBox.setTextColor(Color.BLACK);
            searchBox.setHintTextColor(Color.BLACK);
            mainLayout.setBackgroundColor(ContextCompat.getColor(context, R.color.white));
        }
    }

    private void setTextColor(View view, int color) {
        if (view instanceof TextView) {
            ((TextView) view).setTextColor(color);
        } else if (view instanceof ViewGroup) {
            ViewGroup group = (ViewGroup) view;
            for (int i = 0; i < group.getChildCount(); i++) {
                setTextColor(group.getChildAt(i), color);
            }
        }
    }



}