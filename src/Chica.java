public class Chica {
    private int level = 0;
    private int maxLevel = 20;
    private String location = "Show Stage";
    //private String[] moveString = {"Show Stage", "Dining Area", "Restrooms", "Kitchen", "East Hall", "East Hall Corner", "Office"};
    // Cams: 1A, 1B, 7, 6, 4A, 4B
    Camera camera;
    Doors doors;
    Lights lights;

    public Chica(boolean night6){
        if (night6){
            level = 20;
        }
    }

    public Chica(int customLevel){
        level = customLevel;
    }

    public boolean update(Camera cam, Doors door, Lights light){
        camera = cam;
        doors = door;
        lights = light;
        
        int move = (int)(Math.random() * 21);

        if (location.equals("Office")) {
            if (level > move) {
                chicaJumpscare();
            }      
        }

        if (level > move){
            move(camera, doors, lights);
            return true;
        }
        return false;
    }

    public void nightlyLevel(int night){
        if (night == 2){
            level = 1;
        } else if (night == 3){
            level = 5;
        } else if (night == 4){
            level = 4;
        } else if (night == 5){
            level = 7;
        }
    }

    public void timeLevelInc(int time){
        if (level < maxLevel){
            if (time == 3){
                level++;
            }else if (time == 4){
                level++;
            }
        }
    }

    public void move(Camera cam, Doors door, Lights light){
        int choice = (int)(Math.random() * 2);

        if (location.equals("Show Stage")){
            location = "Dining Area";
        }else if (location.equals("Dining Area")){
            if (choice == 1){
                location = "Restrooms";
            }else {
                location = "Kitchen";
            }
        }else if (location.equals("Restrooms") || location.equals("Kitchen")){
            location = "East Hall";
        }else if (location.equals("East Hall")){
            location = "East Hall Corner";
        }else if (location.equals("East Hall Corner")){
            location = "Office";
        }
    }

    public void retreat(){
        int choice = (int)(Math.random() * 2);

        if (location.equals("Office")){
            if (choice == 1){
                location = "Dining Area";
            }else {
                location = "East Hall";
            }
        }
    }

    public String getLocation(){
        return location;
    }

    public void setLocation(String loc){
        location = loc;
    }

    public boolean chicaJumpscare(){

        if (location.equals("Office")){
            if (doors.getRightDoorOpen() == false){
                doors.rightDoorDisable();

                if (camera.getUsing() == false){
                    location = "Jumpscare";
                }
            }else if(doors.getRightDoorOpen() == true){
                retreat();
            }
        }
        return true;
    }
}