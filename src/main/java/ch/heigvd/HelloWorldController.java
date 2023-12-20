package ch.heigvd;

import io.javalin.http.Context;

public class HelloWorldController {
    public void hello(Context ctx) {
        ctx.result("Hello world");
    }
}
