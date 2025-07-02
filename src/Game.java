public class Game {
    private boolean alive = true;
    private String time = "12:00 AM"; 
    private int battery = 99;
    private String night = "1st Night";
    private int nightInt = 1;
    private int intUsage;
    private boolean powerOutState;

    Freddy freddy;
    Bonnie bonnie;
    Chica chica;
    Foxy foxy;
    Camera camera;
    Lights lights;
    Doors doors;

    public Game(){
        freddy = new Freddy(false);
        bonnie = new Bonnie(false);
        chica = new Chica(false);
        foxy = new Foxy(false);

        camera = new Camera();
        lights = new Lights();
        doors = new Doors();
    }

    public Game(int lastNight){
        freddy = new Freddy(true);
        bonnie = new Bonnie(true);
        chica = new Chica(true);
        foxy = new Foxy(true);

        camera = new Camera();
        lights = new Lights();
        doors = new Doors();
    }

    public Game(int bonnieLevel, int chicaLevel, int foxyLevel, int freddyLevel){
        freddy = new Freddy(freddyLevel);
        bonnie = new Bonnie(bonnieLevel);
        chica = new Chica(chicaLevel);
        foxy = new Foxy(foxyLevel);

        camera = new Camera();
        lights = new Lights();
        doors = new Doors();
    }

    public void tick(int count){

        if (powerOutState == false && alive == true){ {
            if (count % 3 == 0){
                freddy.update();
            }
            
            if (count % 5 ==0){
                bonnie.update(camera, doors, lights);
                chica.update(camera, doors, lights);
                foxy.update(camera, count, doors);
            }

            if (count % 7 == 0 && nightInt == 5){
                battery--;

                if (intUsage == 1){
                    battery--;
                }else if (intUsage == 2){
                    battery -= 2;
                }else if (intUsage == 3){
                    battery -= 3;
                }else if (intUsage == 4){
                    battery -= 4;
                }else if (intUsage == 5){
                    battery -= 5;
                }
            }

            if (count % 8 == 0 && (nightInt == 3) || (nightInt == 4)){
                battery--;

                if (intUsage == 1){
                    battery--;
                }else if (intUsage == 2){
                    battery -= 2;
                }else if (intUsage == 3){
                    battery -= 3;
                }else if (intUsage == 4){
                    battery -= 4;
                }else if (intUsage == 5){
                    battery -= 5;
                }
            }
            
            if (count % 9 == 0 && nightInt == 2){
                battery--;

                if (intUsage == 1){
                    battery--;
                }else if (intUsage == 2){
                    battery -= 2;
                }else if (intUsage == 3){
                    battery -= 3;
                }else if (intUsage == 4){
                    battery -= 4;
                }else if (intUsage == 5){
                    battery -= 5;
                }
            }

            if (count % 10 == 0 && nightInt == 1){
                battery--;

                if (intUsage == 1){
                    battery--;
                }else if (intUsage == 2){
                    battery -= 2;
                }else if (intUsage == 3){
                    battery -= 3;
                }else if (intUsage == 4){
                    battery -= 4;
                }else if (intUsage == 5){
                    battery -= 5;
                }
            }
            
            if (count % 80 == 0){
                updateTime();
            }
        }}
         else {
            if (count % 80 == 0){
                updateTime();
            }
        }
    }

    public String updateTime(){
        int index = time.indexOf(":");
        String timeIntString = time.substring(0, index);
        int timeInt = Integer.parseInt(timeIntString);
        timeInt++;

        if (timeInt % 12 != 0){
            time = (timeInt % 12) + ":00 AM";
        } else {
            time = timeInt + ":00 AM";
        }

        if (time.equals("2:00 AM")){
            bonnie.timeLevelInc(2);
            chica.timeLevelInc(2);
            foxy.timeLevelInc(2);
        }else if (time.equals("3:00 AM")){
            bonnie.timeLevelInc(3);
            chica.timeLevelInc(3);
            foxy.timeLevelInc(3);
        }else if (time.equals("4:00 AM")){
            bonnie.timeLevelInc(4);
            chica.timeLevelInc(4);
            foxy.timeLevelInc(4);
        }

        return time;
    }

    public String updateNight(int nightInteger){
        if (nightInteger == 2){
            night = "2nd Night";
            freddy.nightlyLevel(2);
            bonnie.nightlyLevel(2);
            chica.nightlyLevel(2);
        }else if (nightInteger == 3){
            night = "3rd Night";
            freddy.nightlyLevel(3);
            bonnie.nightlyLevel(3);
            chica.nightlyLevel(3);
        }else if (nightInteger == 4){
            night = "4th Night";
            freddy.nightlyLevel(4);
            bonnie.nightlyLevel(4);
            chica.nightlyLevel(4);
        }else if (nightInteger == 5){
            night = "5th Night";
            freddy.nightlyLevel(5);
            bonnie.nightlyLevel(5);
            chica.nightlyLevel(5);
        }
        return night;
    }

    public void currentCam(String camLoc){
        camera.currentCam(camLoc);
    }

    public void powerOutage(){
        doors.leftDoorDisable();
        doors.rightDoorDisable();
        lights.leftLightDisable();
        lights.rightLightDisable();
        camera.disable();

        powerOutState = true;
    }

//please rewrite
    public void setAlive(boolean alive){
        this.alive = alive;
    }

    public void reset(){
        alive = true;
        time = "12:00 AM";
        battery = 99;
        doors.resetDoors();
        lights.resetLights();

        bonnie.setLocation("Show Stage");
        chica.setLocation("Show Stage");
        freddy.setLocation("Show Stage");
        foxy.setLocation("Pirate Cove");
    }

    public void usingCamera(){
        camera.useCamera(); 
    }

    public String getBonnieLoc(){
        return bonnie.getLocation();
    }

    public String getChicaLoc(){
        return chica.getLocation();
    }

    public String getFreddyLoc(){
        return freddy.getLocation();
    }

    public String getFoxyLoc(){

        if (foxy.getLocation().equals("Office") && doors.getLeftDoorOpen() == true){
            battery -= nightInt;
        }

        return foxy.getLocation();
    }

    public boolean getAlive(){
        return alive;
    }

    public String getTime(){
        return time;
    }

    public int getBattery(){
        return battery;
    }

    public String getUsage(){ 
        intUsage = 0; // Reset usage count each time this is called
        if (camera.getUsing()){
            intUsage++;
        }
        if (doors.getLeftDoorOpen()){
            intUsage++;
        }
        if (doors.getRightDoorOpen()){
            intUsage++;
        }
        if (lights.getLeftLightsState()){
            intUsage++;
        }
        if (lights.getRightLightsState()){
            intUsage++;
        }
        
        if (intUsage == 0){
            return "Excellent";
        }
        else if (intUsage == 1){
            return "Good";
        }
        else if (intUsage == 2){
            return "Average";
        }
        else if (intUsage == 3){
            return "Poor";
        }
        else if(intUsage == 4){
            return "Very Poor";
        }
        return "Excellent";
    }

    public String getNight(){
        return night;
    }

    public boolean getUsingCamera(){
        return camera.getUsing();
    }

    public void useLeftLight(){
        lights.leftLightsTrigger();
    }

    public void useRightLight(){
        lights.rightLightsTrigger();
    }

    public void useLeftDoor(){
        doors.leftDoorTrigger();
    }

    public void useRightDoor(){
        doors.rightDoorTrigger();
    }

    public boolean getLeftLights(){
        return lights.getLeftLightsState();
    }

    public boolean getRightLights(){
        return lights.getRightLightsState();
    }

    public int getFoxyStage(){
        return foxy.getStage();
    }
}
