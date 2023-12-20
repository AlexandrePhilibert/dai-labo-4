package ch.heigvd;

import io.javalin.Javalin;

public class Main {
  public final static int PORT = 8080;

  public static void main(String[] args) {
    Javalin app = Javalin.create();

    HelloWorldController helloWorldController = new HelloWorldController();

    app.get("/", helloWorldController::hello);

    app.start(PORT);
  }
}
