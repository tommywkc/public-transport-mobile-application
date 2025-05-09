package hk.edu.hkmu.myapplication;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

public class RouteAdapter extends SimpleAdapter {
    private ArrayList<HashMap<String, String>> routeList;

    public RouteAdapter(Context context, ArrayList<HashMap<String, String>> routeList, int resource, String[] from, int[] to) {
        super(context, routeList, resource, from, to);
        this.routeList = routeList;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = super.getView(position, convertView, parent);
        ImageView favoriteIcon = view.findViewById(R.id.favorite_icon);

        HashMap<String, String> route = routeList.get(position);
        boolean isFavorite = RouteList.favoriteRoutes.contains(route);
        favoriteIcon.setImageResource(isFavorite ? R.drawable.star2 : R.drawable.star);

        favoriteIcon.setOnClickListener(v -> {
            if (isFavorite) {
                RouteList.removeFavoriteRoute(route);
                favoriteIcon.setImageResource(R.drawable.star);
            } else {
                RouteList.addFavoriteRoute(route);
                favoriteIcon.setImageResource(R.drawable.star2);
            }
            notifyDataSetChanged();
        });

        // 根據當前主題設置文本顏色
        TextView routeText = view.findViewById(R.id.route); // 假設這是路線的 TextView ID
        TextView origText = view.findViewById(R.id.orig); // 假設這是起點的 TextView ID
        TextView destText = view.findViewById(R.id.dest); // 假設這是終點的 TextView ID
        TextView godestText = view.findViewById(R.id.goDest);

        if (ThemeManager.isDarkMode) {
            routeText.setTextColor(Color.WHITE);
            origText.setTextColor(Color.WHITE);
            destText.setTextColor(Color.WHITE);
            godestText.setTextColor(Color.WHITE);
        } else {
            routeText.setTextColor(Color.BLACK);
            origText.setTextColor(Color.BLACK);
            destText.setTextColor(Color.BLACK);
            godestText.setTextColor(Color.BLACK);
        }

        return view;
    }
}