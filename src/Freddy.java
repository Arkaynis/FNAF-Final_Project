public class Freddy{
    private int level;
    private int movements;
    private String location = "Show Stage";
    private String[] moveString = {"Show Stage", "Dining Area", "Restrooms", "Kitchen", "East Hall", "East Hall Corner", "Office"};
    private boolean ready = false;
    private int count;
    Camera cam = new Camera();
    Doors doors = new Doors();
    Lights lights = new Lights();

    public Freddy(boolean night6){
        if (night6){
            level = 20;
        }
    }
    public Freddy(int customLevel){
        level = customLevel;
    }

    public boolean update(){
        int move = (int)(Math.random() * 21);
        
        if ((level > move) && (cam.getUsing() == false) && (location != "East Hall Corner")){
            move(count);
            return true;
        }
        return false;
    }

    public void nightlyLevel(int night){
        if (night == 3){
            level = 1;
        } else if (night == 4){
            if ((int)(Math.random() * 2) == 0){
                level = 1;
            }else {
                level = 2;
            }
        } else if (night == 5){
            level = 3;
        } 
    }

    public void delayMove(){

        if (movements < moveString.length - 1){
            if (count % ((1000 - 100 * (level))/60) == 0){
                movements++;
                location = moveString[movements];
            }
        }
    }

    public void move(int counter){

        if (ready == false){
            delayMove();
        }else if (ready == true){
            if (movements < moveString.length - 1){
                movements++;
                location = moveString[movements];
            }
        }
    }

    //figure out what to do here
    public boolean freddyJumpscare(){
        if (location.equals("Office")){
            if (update() == true && doors.getRightDoorOpen() == false){
             
            }
        }    
        return true;
    }

    public String getLocation(){
        return location;
    }
    
    public void setLocation(String loc){
        location = loc;
    }
}