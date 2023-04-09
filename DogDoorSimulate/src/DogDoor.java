import java.util.*;

public class DogDoor {
    private boolean open;
    private List<Bark> barks = new ArrayList<>();

    public void open(){
        System.out.println("Door is Opened");

        open = true;

        final Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            public void run() {
                closed();
                timer.cancel();
            }
        }, 5000);
    }

    public void closed(){
        System.out.println("Door is closed");
    }

    public boolean isOpen(){
        return open;
    }

    public void addAllowedBark(Bark bark){
        barks.add(bark);
    }

    public List<Bark> getAllowedBarks(){
        return barks;
    }


}
