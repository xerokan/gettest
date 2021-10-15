import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.springframework.core.style.ToStringCreator;
import org.springframework.http.ResponseEntity;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;
import java.util.List;

public class main {
    public static String SERVER_URL = "http://localhost:18549/";
    public static SessionKeys login (String login, String hash){
        String result = "ERROR";
        try {
            URL url = new URL(SERVER_URL + "login/?login=" + login +"&hash="+hash);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            con.setRequestProperty("Content-length", "0");
            con.setUseCaches(false);
            con.setAllowUserInteraction(false);
            con.connect();
            BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream())); // This line makes the request
            StringBuilder sb = new StringBuilder();
            String line;
            while ((line = br.readLine()) != null) {
                sb.append(line + "\n");
            }
            br.close();
            result = sb.toString();
            System.out.println(result);
            GsonBuilder builder = new GsonBuilder();
            Gson gson = builder.create();
            SessionKeys keys = gson.fromJson(result, SessionKeys.class);
            return keys;
        } catch (MalformedURLException | ProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void sessionClose (String value){
        String result = "ERROR";
        try {
            URL url = new URL(SERVER_URL + value +"/" + "/close");
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("DELETE");
            con.setRequestProperty("Content-length", "0");
            con.setUseCaches(false);
            con.setAllowUserInteraction(false);
            con.connect();
            result = Integer.toString(con.getResponseCode());
            System.out.println(result);
        } catch (MalformedURLException | ProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static List<Users> getUsersList (String value){
        String result = "ERROR";
        try {
            URL url = new URL(SERVER_URL + value +"/users/list" );
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            con.setRequestProperty("Content-length", "0");
            con.setUseCaches(false);
            con.setAllowUserInteraction(false);
            con.connect();
            BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream())); // This line makes the request
            StringBuilder sb = new StringBuilder();
            String line;
            while ((line = br.readLine()) != null) {
                sb.append(line + "\n");
            }
            br.close();
            result = sb.toString();
            System.out.println(result);
            GsonBuilder builder = new GsonBuilder();
            Gson gson = builder.create();
            List<Users> userList = gson.fromJson(result, List.class);
            System.out.println(userList.get(0));
            return userList;
        } catch (MalformedURLException | ProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } return null;
    }

    public static void deleteUser (String value, int user_id){
        String result = "ERROR";
        try {
            URL url = new URL(SERVER_URL + value +"/users/"+ user_id);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("DELETE");
            con.setRequestProperty("Content-length", "0");
            con.setUseCaches(false);
            con.setAllowUserInteraction(false);
            con.connect();
            result = Integer.toString(con.getResponseCode());
            System.out.println(result);
        } catch (MalformedURLException | ProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void resetPassword (String value, int user_id){
        String result = "ERROR";
        try {
            URL url = new URL(SERVER_URL + value +"/users/"+ user_id+"/reset_password");
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("PUT");
            con.setRequestProperty("Content-length", "0");
            con.setUseCaches(false);
            con.setAllowUserInteraction(false);
            con.connect();
            result = Integer.toString(con.getResponseCode());
            System.out.println(result);
        } catch (MalformedURLException | ProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void getGrant (String value, int user_id){
        String result = "ERROR";
        try {
            URL url = new URL(SERVER_URL + value +"/users/"+ user_id+"/grant");
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("PUT");
            con.setRequestProperty("Content-length", "0");
            con.setUseCaches(false);
            con.setAllowUserInteraction(false);
            con.connect();
            result = Integer.toString(con.getResponseCode());
            System.out.println(result);
        } catch (MalformedURLException | ProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void userUpdate (String login, String name, String last, String family,
                                   Double weight, Integer age){
        String result = "ERROR";
        try {
            URL url = new URL(SERVER_URL + "users/data/add?login=" + login +"&name=" +
                    name + "&last=" + last + "&family=" + family + "&weight=" + weight + "&age=" + age);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("PUT");
            con.setRequestProperty("Content-length", "0");
            con.setUseCaches(false);
            con.setAllowUserInteraction(false);
            con.connect();
            BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream())); // This line makes the request
            StringBuilder sb = new StringBuilder();
            String line;
            while ((line = br.readLine()) != null) {
                sb.append(line + "\n");
            }
            br.close();
            result = sb.toString();
            System.out.println(result);
        } catch (MalformedURLException | ProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void adduser (String login, String hash){
        String result = "ERROR";
        try {
            URL url = new URL(SERVER_URL + "users/add?login=" + login +"&hash="+hash);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("PUT");
            con.setRequestProperty("Content-length", "0");
            con.setUseCaches(false);
            con.setAllowUserInteraction(false);
            con.connect();
            BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream())); // This line makes the request
            StringBuilder sb = new StringBuilder();
            String line;
            while ((line = br.readLine()) != null) {
                sb.append(line + "\n");
            }
            br.close();
            result = sb.toString();
            System.out.println(result);
        } catch (MalformedURLException | ProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void addProsthesis (String value, String code){
        String result = "ERROR";
        try {
            URL url = new URL(SERVER_URL + value+ "/prosthesis/add?code=" + code);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("PUT");
            con.setRequestProperty("Content-length", "0");
            con.setUseCaches(false);
            con.setAllowUserInteraction(false);
            con.connect();
            BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream())); // This line makes the request
            StringBuilder sb = new StringBuilder();
            String line;
            while ((line = br.readLine()) != null) {
                sb.append(line + "\n");
            }
            br.close();
            result = sb.toString();
            System.out.println(result);
        } catch (MalformedURLException | ProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //some issues
    public static void removeProsthesis (String value, int id){
        String result = "ERROR";
        try {
            URL url = new URL(SERVER_URL + value + "/my/prosthesis/" + id);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("DELETE");
            con.setRequestProperty("Content-length", "0");
            con.setUseCaches(false);
            con.setAllowUserInteraction(false);
            con.connect();
            BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream())); // This line makes the request
            StringBuilder sb = new StringBuilder();
            String line;
            while ((line = br.readLine()) != null) {
                sb.append(line + "\n");
            }
            br.close();
            result = sb.toString();
            System.out.println(result);
        } catch (MalformedURLException | ProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<Prosthesis> getProsthesisList (String value){
        String result = "ERROR";
        try {
            URL url = new URL(SERVER_URL + value +"/prosthesis/list" );
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            con.setRequestProperty("Content-length", "0");
            con.setUseCaches(false);
            con.setAllowUserInteraction(false);
            con.connect();
            BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream())); // This line makes the request
            StringBuilder sb = new StringBuilder();
            String line;
            while ((line = br.readLine()) != null) {
                sb.append(line + "\n");
            }
            br.close();
            result = sb.toString();
            System.out.println(result);
            GsonBuilder builder = new GsonBuilder();
            Gson gson = builder.create();
            List<Prosthesis> prosthesisList = gson.fromJson(result, List.class);
            System.out.println(prosthesisList.get(0));
            return prosthesisList;
        } catch (MalformedURLException | ProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } return null;
    }

    public static void bindProsthesis (String value, String code){
        String result = "ERROR";
        try {
            URL url = new URL(SERVER_URL + value+ "/my/prosthesis/bind?code=" + code);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("PUT");
            con.setRequestProperty("Content-length", "0");
            con.setUseCaches(false);
            con.setAllowUserInteraction(false);
            con.connect();
            BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream())); // This line makes the request
            StringBuilder sb = new StringBuilder();
            String line;
            while ((line = br.readLine()) != null) {
                sb.append(line + "\n");
            }
            br.close();
            result = sb.toString();
            System.out.println(result);
        } catch (MalformedURLException | ProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<Tests> getTests(String value){
        String result = "ERROR";
        try {
            URL url = new URL(SERVER_URL + value +"/my/tests/list" );
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            con.setRequestProperty("Content-length", "0");
            con.setUseCaches(false);
            con.setAllowUserInteraction(false);
            con.connect();
            BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream())); // This line makes the request
            StringBuilder sb = new StringBuilder();
            String line;
            while ((line = br.readLine()) != null) {
                sb.append(line + "\n");
            }
            br.close();
            result = sb.toString();
            System.out.println(result);
            GsonBuilder builder = new GsonBuilder();
            Gson gson = builder.create();
            List<Tests> testsList = gson.fromJson(result, List.class);
            System.out.println(testsList);
            return testsList;
        } catch (MalformedURLException | ProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } return null;
    }


    public static void main(String[] args) {
    getTests(login("log","123").value);
    }
}
