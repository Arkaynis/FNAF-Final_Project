public class Lights {
    private boolean leftLightsState;
    private boolean rightLightsState;
    private final boolean disabled = false;

    public Lights(){
        leftLightsState = false;
        rightLightsState = false;
    }

    public void leftLightsTrigger(){
        leftLightsState = !leftLightsState;
    }

    public void rightLightsTrigger(){
        rightLightsState = !rightLightsState;    
    }

    public void leftLightDisable(){
        leftLightsState = disabled;
    }

    public void rightLightDisable(){
        rightLightsState = disabled;
    }

    public boolean getLeftLightsState(){
        return leftLightsState;
    }

    public boolean getRightLightsState(){
        return rightLightsState;
    }

    public void resetLights() {
        leftLightsState = false;
        rightLightsState = false;
    }
}
