package com.example.hacaton2020;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import com.example.hacaton2020.Entity.User;
import com.example.hacaton2020.Entity.Users;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.CharArrayWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class LoginActivity extends AppCompatActivity {

    private EditText editTextTextPersonName;
    private EditText editTextTextPassword;
    private int isLogin;
    private Users users;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        User user = new User("Иванов", "Иван", "Иванович","login","password");
        User user2 = new User("Иванов", "Иван", "Иванович","test","test");
        User user3 = new User("Иванов", "Иван", "Иванович","test2","test");

        List<User> userList = new ArrayList<>();
        userList.add(user);
        userList.add(user2);
        userList.add(user3);

        users = new Users(userList);


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        editTextTextPersonName = findViewById(R.id.editTextTextPersonName);
        editTextTextPassword = findViewById(R.id.editTextTextPassword);
        isLogin = 0;
    }

    public void redirect(View view) {


        if (users.searchByLoginAndPassword(editTextTextPersonName.getText().toString(), editTextTextPassword.getText().toString()) != null ){
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        }

        /*
        DownloadJSONTask task = new DownloadJSONTask();
        String result = null;
        String url = String.format("http://hacaton.ru/login.php?login=%s&password=%s", editTextTextPersonName.getText(), editTextTextPassword.getText());

        task.execute(url);
        */


    }
    private static class DownloadJSONTask extends AsyncTask<String, Void, String> {

        @Override
        protected String doInBackground(String... strings) {

            StringBuilder result = new StringBuilder();
            URL url = null;
            HttpURLConnection urlConnection = null;

            try {
                url = new URL(strings[0]);
                urlConnection = (HttpURLConnection) url.openConnection();
                InputStream inputStream = urlConnection.getInputStream();
                InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                String line = bufferedReader.readLine();
                while (line != null){
                    result.append(line);
                    line = bufferedReader.readLine();
                }
                return result.toString();
            }catch(MalformedURLException e){
                e.printStackTrace();
            }catch(IOException e){
                e.printStackTrace();
            }finally{
                if(urlConnection != null){
                    urlConnection.disconnect();
                }
            }

            return result.toString();
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            try {
                JSONObject jsonObject = new JSONObject(s);
                jsonObject.getString("id");
                Log.i("11111",jsonObject.getString("id"));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }
}