package ch.heigvd.trucks;

import io.javalin.http.Context;
import io.javalin.http.HttpStatus;
import io.javalin.http.NotFoundResponse;

import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class TrucksController {

    ConcurrentHashMap<Integer, Truck> trucks;
    private final AtomicInteger nextId = new AtomicInteger(1);

    public TrucksController(ConcurrentHashMap<Integer, Truck> trucks) {
        this.trucks = trucks;
    }

    public void create(Context ctx) {
        Truck truck = ctx.bodyAsClass(Truck.class);
        truck.id = nextId.getAndIncrement();

        trucks.put(truck.id, truck);

        ctx.json(truck);
        ctx.status(HttpStatus.CREATED);
    }

    public void findOneById(Context ctx) {
        Integer id = ctx.pathParamAsClass("id", Integer.class).get();

        Truck truck = trucks.get(id);
        if (truck == null) {
            throw new NotFoundResponse();
        }

        ctx.json(truck);
        ctx.status(HttpStatus.OK);
    }

    public void updateOneById(Context ctx) {
        Integer id = ctx.pathParamAsClass("id", Integer.class).get();

        Truck updateTruckDto = ctx.bodyValidator(Truck.class).get();

        Truck truck = trucks.get(id);
        if (truck == null) {
            throw new NotFoundResponse();
        }

        truck.driver = updateTruckDto.driver;
        truck.name = updateTruckDto.name;

        ctx.json(truck);
        ctx.status(HttpStatus.OK);
    }

    public void findAll(Context ctx) {
        var trucks = new ArrayList<>(this.trucks.values());

        ctx.json(trucks);
        ctx.status(HttpStatus.OK);
    }

    public void deleteOneById(Context ctx) {
        Integer id = ctx.pathParamAsClass("id", Integer.class).get();

        Truck truck = trucks.get(id);
        if (truck == null) {
            throw new NotFoundResponse();
        }

        trucks.remove(id);

        ctx.json(truck);
        ctx.status(HttpStatus.OK);
    }
}
