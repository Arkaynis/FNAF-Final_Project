public class Doors {
    private boolean leftDoorState;
    private boolean rightDoorState;
    private final boolean disabled = false;

    public Doors(){
        leftDoorState = false;
        rightDoorState = false;
        //both are open at start (false)
    }

     public void leftDoorTrigger(){
        leftDoorState = !leftDoorState;
    }

    public void rightDoorTrigger(){
        rightDoorState = !rightDoorState;    
    }

    public void leftDoorDisable(){
        leftDoorState = disabled;
    }

    public void rightDoorDisable(){
        rightDoorState = disabled;
    }

    public boolean getLeftDoorOpen() {
        return leftDoorState;
    }

    public boolean getRightDoorOpen() {
        return rightDoorState;
    }

    public void resetDoors() {
        leftDoorState = false;
        rightDoorState = false;
    }
}
