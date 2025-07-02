public class Camera {
    private boolean using;
    private String currentCamera;
    private final boolean disabled = false;

    public boolean getUsing(){
        return using;
    }

    public void useCamera(){
        using = !using;
    }

    public boolean currentCam(String currentCam){
        currentCamera = currentCam;

        return true;
    }

    public void disable(){
        using = disabled;
    }

}
