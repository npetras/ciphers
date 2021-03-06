package com.nicolaspetras.ciphers.java;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application
{

   @Override
   public void start(Stage primaryStage) throws Exception
   {
      Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
      primaryStage.setTitle("Hello World");
      primaryStage.setScene(new Scene(root, 300, 275));
      primaryStage.show();
   }


   public static void main(String[] args)
   {
      // make sure that caesar key is fully numerical and that vigenere key is fully alphabetical
      launch(args);
   }
}
