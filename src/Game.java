public class Game {
    private boolean alive = true;
    private String time;
    private int battery;
    private int tickCount;

    Freddy freddy;
    Bonnie bonnie;
    Chicka chicka;
    Foxy foxy;

    public Game(){
        freddy = new Freddy();
        bonnie = new Bonnie();
        chicka = new Chicka();
        foxy = new Foxy();
    }

    public void tick(){
        tickCount++;

        if (tickCount % 3 == 0){
            freddy.update();
        }else {
//bonnie, etc. update
        }
    }

    public boolean getAlive(){
        return alive;
    }

    public String getTime(){
        return time;
    }
}
