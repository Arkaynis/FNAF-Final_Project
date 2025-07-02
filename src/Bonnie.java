public class Bonnie {
    private int level = 0;
    final int maxLevel = 20;
    private String location = "Show Stage";
    //private String[] moveString = {"Show Stage", "Backstage", "Dining Area", "West Hall", "Supply Closet", "West Hall Corner", "Office", "Jumpscare"};
    // Cams: 1A, 5, 1B, 2A, 3, 2B
    Camera camera;
    Doors doors; 
    Lights lights;

    public Bonnie(boolean night6){
        if (night6){
            level = 20;
        }
    }

    public Bonnie(int customLevel){
        level = customLevel;
    }

    public boolean update(Camera cam, Doors door, Lights light){
        camera = cam;
        doors = door;
        lights = light;

        int move = (int)(Math.random() * 21);

        // If Bonnie is at the Office, only attempt jumpscare if move succeeds
        if (location.equals("Office")) {
            if (level > move) {
                bonnieJumpscare();
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
            level = 3;
        } else if (night == 3){
            level = 0;
        } else if (night == 4){
            level = 2;
        } else if (night == 5){
            level = 5;
        }
    }

    public void timeLevelInc(int time){
        if (level < maxLevel){
            if (time == 2){
                level++;
            }else if (time == 3){
                level++;
            }else if (time == 4){
                level++;
            }
        }
    }

    public void move(Camera cam, Doors door, Lights light){
        int choice = (int)(Math.random() * 2);

        if (location.equals("Show Stage")){
            if (choice == 1){
                location = "Backstage"; 
            }else {
                location = "Dining Area";
            }
        }else if (location.equals("Backstage") || location.equals("Dining Area")){
            location = "West Hall";
        }else if (location.equals("West Hall")){
             if (choice == 1){
                location = "West Hall Corner";
                retreat(cam);
            }else {
                location = "Supply Closet";
            }
        }else if (location.equals("West Hall Corner") || location.equals("Supply Closet")){
            location = "Office";
            // Force retreat if door is closed
            if (door.getLeftDoorOpen() == true) {
                retreat(cam);
            }
        }
    }

    public void retreat(Camera cam){
        if (location.equals("Office")){
            location = "Dining Area";
        }else if (location.equals("West Hall Corner") && cam.getUsing() == true){
            location = "Supply Closet";
        }
    }

    public void bonnieJumpscare(){
        if (location.equals("Office")){
            if (doors.getLeftDoorOpen() == false){
                doors.leftDoorDisable();
                if (camera.getUsing() == false){
                    location = "Jumpscare";
                }
            }else if(lights.getLeftLightsState() == true && doors.getLeftDoorOpen() == false){
                location = "Jumpscare";
            }else if(doors.getLeftDoorOpen() == true){
                retreat(camera);
            }else if (doors.getLeftDoorOpen() == false){
                location = "Jumpscare";
            }
        }
    }

    public void setLocation(String loc){
        location = loc;
    }

    public String getLocation(){
        return location;
    }
}