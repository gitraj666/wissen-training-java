
import java.util.ArrayList;

interface Listeners {
    ArrayList<DoorListener> listeners = new ArrayList<>();
}

interface DoorListener {
    void on(DoorEvent event);

    void off(DoorEvent event);
}

class DoorEvent {

    private int floorNm;
    private int doorNum;

    public DoorEvent(int floorNm, int doorNum) {
        super();
        this.floorNm = floorNm;
        this.doorNum = doorNum;
    }

    public int getFloorNm() {
        return floorNm;
    }

    public int getDoorNum() {
        return doorNum;
    }

}

class Maintainer implements Listeners {
    public void eventOccured() {
        DoorEvent event = new DoorEvent(4, 5);
        for (DoorListener listener : listeners)
            listener.on(event);
    }

    public void addListeners(DoorListener listener) {
        listeners.add(listener);
        eventOccured();
    }

    public void removeListener(DoorListener listener) {
        listeners.remove(listener);
    }
}

class Door extends Maintainer implements Listeners {
    public void doorOpen() {
        System.out.println("Door Opened");
        eventOccured();
    }

    public void doorClose() {
        System.out.println("Door Closed");
        eventOccured();
    }
}

class Light extends Maintainer implements Listeners, DoorListener {

    @Override
    public void on(DoorEvent event) {
        System.out.println("Light is On");
    }

    @Override
    public void off(DoorEvent event) {
        System.out.println("Light << OFF " + event.getFloorNm() + "\t" + event.getDoorNum());
    }

    public void addListener(DoorListener listener) {
        addListeners(listener);
    }
}

public class Ex3 {
    public static void main(String[] args) {
        Door door = new Door();
        door.doorOpen();

        Light light = new Light();
        light.addListener(light);

        light.removeListener(light);
        door.doorOpen();

        door.doorClose();
    }
}
