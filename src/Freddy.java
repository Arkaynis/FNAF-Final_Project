public class Freddy{
    private int level = 0;
    private int movements;
    private String location = "Show Stage";
    private String[] moveString = {"Show Stage", "Dining Area", "Restrooms", "Kitchen", "East Hall", "East Hall Corner"};

    public void update(){
        int move = (int)(Math.random() * 21) + 1;
        Camera cam = new Camera();
        
        if (cam.getUsing() == true && level >= 10){
            update();
        }else {
            if ((level > move) && (cam.getUsing() == false) && !(location.equals("East Hall Corner"))){
                move();
            }
        }
    }

    public String move(){
        movements++;
        
        location = moveString[movements];
        return location;
    }

    public String getLocation(){
        return location;
    }
}
