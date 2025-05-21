public class Lights {
    private static boolean leftLightsState;
    private static boolean rightLightsState;

    public Lights(){
        leftLightsState = false;
        rightLightsState = false;
    }

    public static void leftLightsTrigger(){
        System.out.println("Left Lights triggered");
        leftLightsState = true;
    }

    public static void rightLightsTrigger(){
        System.out.println("Right Lights triggered");
        rightLightsState = true;    
    }

    public static void leftLightDisable(){
        System.out.println("Left Lights disabled");
        leftLightsState = false;
    }

    public static void rightLightDisable(){
        System.out.println("Right Lights disabled");
        rightLightsState = false;
    }

    
}
