package hk.edu.hkmu.myapplication;

import java.util.ArrayList;
import java.util.HashMap;

public class RouteList {
    public static String ROUTE = "route";
    public static String ORIG = "orig_tc";
    public static String DEST = "dest_tc";

    public static ArrayList<HashMap<String, String>> routeList = new ArrayList<>();

    public static ArrayList<HashMap<String, String>> favoriteRoutes = new ArrayList<>(); // 收藏的路線


    // Creates and add contact to contact list
    public static void addRoute(String route, String orig, String dest, String bound, String serviceType) {
        HashMap<String, String> routeInfo = new HashMap<>();
        routeInfo.put(ROUTE, route);
        routeInfo.put(ORIG, orig);
        routeInfo.put(DEST, dest);
        routeInfo.put("bound", bound);
        routeInfo.put("service_type", serviceType);

        routeList.add(routeInfo);
    }


    public static void addFavoriteRoute(HashMap<String, String> route) {
        favoriteRoutes.add(route);
    }

    public static void removeFavoriteRoute(HashMap<String, String> route) {
        favoriteRoutes.remove(route);
    }


}
