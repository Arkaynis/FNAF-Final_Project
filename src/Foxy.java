public class Foxy {
    private int level;
    private int stage = 1;
    private String location = "Pirate Cove";
    // Check 2A cam

    public Foxy(boolean night6){
        if (night6){
            level = 20;
        }
    }

    public Foxy(int customLevel){
        level = customLevel;
    }

    public void update(Camera cam, int counter, Doors doors){
        int move = (int)(Math.random() * 21) + 1;
        int delayAfterFail = (int)(Math.random() * 18);

        if (cam.getUsing() == true){
                if ((level > move) && (cam.getUsing() == false)){
                    stage++;

                    if (stage == 4){
                        move(cam, counter, doors);
                    }
                }
            } else {
            if ((level > move) && (cam.getUsing() == false)){
                stage++;

                if (stage == 4){
                    move(cam, counter, doors);
                }
            }
        }
    }

    public void nightlyLevel(int night){
        if (night == 2){
            level = 1;
        } else if (night == 3){
            level = 2;
        } else if (night == 4){
            level = 6;
        } else if (night == 5){
            level = 5;
        }
    }

    public void timeLevelInc(int time){
        if (time == 3){
            level++;
        }else if (time == 4){
            level++;
        }
    }

    public void move(Camera cam, int counter, Doors doors){
        if (cam.currentCam("West Hall") == true){
            location = "West Hall";

            if (counter % 5 == 0){
                location = "Office";
                foxyJumpscare(doors);
            }
        }

        if (counter % 25 == 0){
            location = "Office";
        }
    }

    public String getLocation(){
        return location;
    }

    public void setLocation(String loc){
        location = loc;
    }

    public int getStage(){
        return stage;
    }

    public void foxyJumpscare(Doors door){

        if (location.equals("Office") && door.getLeftDoorOpen() == false){
            location = "Jumpscare";
        }else {
            location = "Pirate Cove";
        }
    }
}
