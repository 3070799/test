import com.google.gson.Gson;
import dao.DAO;
import dao.UserDAO;
import entities.User;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;

public class JsonParse {
    public static JSONObject urlToJson(String urlString) {
        StringBuilder sb = null;
        URLConnection urlCon = null;
        JSONObject jo = null;
        try {
            URL url = new URL(urlString);
            urlCon = url.openConnection();

            BufferedReader in = null;
            in = new BufferedReader(new InputStreamReader(urlCon.getInputStream()));

            String inputLine;
            sb = new StringBuilder();

            while ((inputLine = in.readLine()) != null) {
                sb.append(inputLine);
            }

            in.close();
            jo = new JSONObject(sb.toString());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }


        return jo;
    }

    public static ArrayList<User> jsonToUsers(JSONObject json){
        JSONArray arr = null;
        try {
            arr = json.getJSONArray("results");
        } catch (JSONException e) {
            e.printStackTrace();
        }

        ArrayList<User> users = new ArrayList<User>();

        Gson g = new Gson();
        for (int i = 0; i < arr.length(); i++) {
            User user = null;
            try {
                user = g.fromJson(arr.get(i).toString(), User.class);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            users.add(user);
        }

        return users;
    }

}
