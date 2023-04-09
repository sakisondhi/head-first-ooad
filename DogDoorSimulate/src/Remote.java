public class Remote {
    DogDoor door;

    public Remote(DogDoor door){
        this.door = door;
    }

    public void pressButton(){
        if(door.isOpen())
            door.closed();
        else
            door.open();
    }
}
