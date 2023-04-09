public class Bark {
    private String sound;

    Bark(String sound){
        this.sound = sound;
    }
    public String getSound(){
        return sound;
    }

    public boolean equals(Object bark){
        if(bark instanceof Bark){
            Bark objectBark = (Bark) bark;
            return (this.sound.equals(objectBark.getSound())) ? true: false;
        }
        return false;
    }
}
