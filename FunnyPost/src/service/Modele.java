package service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.sql.PreparedStatement;

import entite.Connexion;
import entite.Post;

public class Modele {
  public Modele() throws SQLException {
    super();
 }
 
  
  public ArrayList<Post> SelectAllData() throws SQLException {
    try {
      Connection connection = Connexion.connectBDD();
      Statement statement = connection.createStatement();

      String query = "SELECT * FROM funnyPost";
      ResultSet resultSet = statement.executeQuery(query);
    
      ArrayList<Post> posts = new ArrayList<>();
    
      while (resultSet.next()) {
        Post post = new Post();
        post.setId(resultSet.getInt("id"));
        post.setTitle(resultSet.getString("title"));
        post.setBody(resultSet.getString("body"));

        posts.add(post);
      }
      return posts;
    }catch (Exception e) {
      e.printStackTrace();
    }
    return null;
  }
  
  public static void insertData(Post post) throws SQLException {
    try {
        Connection connection = Connexion.connectBDD();
        String sql = "INSERT INTO funnyPost (id, title, body) VALUES (?, ?, ?)";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, post.getId());
        statement.setString(2, post.getTitle());
        statement.setString(3, post.getBody());
        statement.executeUpdate();
    } catch (SQLException e) {
        e.printStackTrace();
    }
  }
  
  public static void deleteData(String text) throws SQLException {
    try {
    Connection connection = Connexion.connectBDD();
    String query = "DELETE FROM funnyPost WHERE id=?";
    PreparedStatement statement = connection.prepareStatement(query);
    statement.setString(1, text);
    statement.executeUpdate();
    } catch (SQLException e) {
      e.printStackTrace();

    }
  }
  
  public static void getDataFromURL() {
    try {
      URL url = new URL("https://jsonplaceholder.typicode.com/posts");
      HttpURLConnection connection = (HttpURLConnection) url.openConnection();
  
      connection.setConnectTimeout(200000);
      connection.setReadTimeout(200000);
      connection.setUseCaches(true);
      connection.setRequestMethod("GET");
      connection.setRequestProperty("Accept", "application/xml");
      connection.setRequestProperty("Content-Type", "application/xml");
  
      int responseCode = connection.getResponseCode();
      if(responseCode == 400) {
          System.out.println("Client Error !!");
      } else if (responseCode == 500) {
          System.out.println("Server Error !!");
      } 
      else if (responseCode == 200) {
        BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        StringBuilder responseBody = new StringBuilder();
        String inputLine;

        while ((inputLine = in.readLine()) != null) {
            responseBody.append(inputLine).append("\n");
        }

        in.close();

        JSONParser parser = new JSONParser();

        try {
            JSONArray jsonArray = (JSONArray) parser.parse(responseBody.toString());

            for (Object obj : jsonArray) {
                JSONObject jsonObject = (JSONObject) obj;

                Post post = new Post();
                post.setId(Integer.parseInt(jsonObject.get("id").toString()));
                post.setTitle((String) jsonObject.get("title"));
                post.setBody((String) jsonObject.get("body"));

               Modele.insertData(post);
            }
        } catch (Exception e1) {
            e1.printStackTrace();
        }
      }
    } catch (IOException e1) {
      e1.printStackTrace();
    }
  }
}
