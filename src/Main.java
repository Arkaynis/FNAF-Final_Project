import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("FIVE NIGHT AT FREDDY'S");
        System.out.println("Please make an option below:" + "\n");
        System.out.println("1. Start Game");
        System.out.println("2. 6th Night");
        System.out.println("3. Ultra Custom Night");
        System.out.println();

        int choice = scan.nextInt();
        int count = 1;

        if (choice == 1) {
            System.out.println("\nStarting Game..." + "\n\n" + "12:00 AM" + "\n" + "1st Night" + "\n\n");
                Game game = new Game();

                while (game.getAlive() == true && count <= 480){
                    game.tick(count);
                    System.out.println();
                    System.out.println("Time: " + game.getTime());
                    System.out.println("Night: " + game.getNight());
                    System.out.println("Battery: " + game.getBattery());
                    System.out.println("Usage: " + game.getUsage() + "\n");

                    System.out.print("What is your action? "+ "\n");
                    String action = scan.nextLine();
                    System.out.println();

                        if (action.equals("c")){
                            count++;
                            game.usingCamera();

                            System.out.println("Freddy is at: " + game.getFreddyLoc());
                            System.out.println("Bonnie is at: " + game.getBonnieLoc());
                            System.out.println("Chica is at: " + game.getChicaLoc());
                            System.out.println("Foxy is at: " + game.getFoxyLoc() + " (" + game.getFoxyStage() + ")");
                        }else if (action.equals("help")){
                            System.out.println("(in front of action add 'o' to open and 'c' to close)");
                            System.out.println("c: camera");
                            System.out.println("ll: left lights");
                            System.out.println("rl: right lights");
                            System.out.println("ld: left door");
                            System.out.println("rd: right lights");
                        }else if (action.equals("oll")){
                            count++;
                            game.useLeftLight();
                            System.out.println("Left Light On");
                        }else if (action.equals( "orl")){
                            count++;
                            game.useRightLight();
                            System.out.println("Right Light On");
                        }else if (action.equals("cld")){
                            count++;
                            game.useLeftDoor();
                            System.out.println("Left Door Closed");
                        }else if (action.equals("crd")){
                            count++;
                            game.useRightDoor();
                            System.out.println("Right Door Closed");
                        }else if (action.equals("old")){
                            count++;
                            game.useLeftDoor();
                            System.out.println("Left Door Open");
                        }else if (action.equals("ord")){
                            count++;
                            game.useRightDoor();
                            System.out.println("Right Door Open");
                        }else if (action.equals("cll")){
                            count++;
                            game.useLeftLight();
                            System.out.println("Left Light Off");
                        }else if (action.equals("crl")){
                            count++;
                            game.useRightLight();
                            System.out.println("Right Light Off");
                        }else {
                            count++;
                        }
                    if (game.getChicaLoc().equals("Jumpscare") || game.getBonnieLoc().equals("Jumpscare") || game.getFoxyLoc().equals("Jumpscare") || game.getFreddyLoc().equals("Jumpscare")){
                        System.out.println("Game Over");
                        break;
                    }
                }

                if (count == 480 || game.getTime().equals("6:00 AM")){
                    count = 1;
                    for (int night = 2; night <= 5; night++){
                        game.updateNight();
                        game.reset();

                        System.out.println("12:00 AM");
                            if (night == 2){
                                System.out.println(night + "nd Night");
                            }else if (night == 3){
                                System.out.println(night + "rd Night");
                            }else if (night == 4){
                                System.out.println(night + "th Night");
                            }else if (night == 5){
                                System.out.println(night + "th Night");
                            }

                        while (game.getAlive() == true && count <= 480){
                            game.tick(count);
                            System.out.println();
                            System.out.println("Time: " + game.getTime());
                            System.out.println("Night: " + game.getNight());
                            System.out.println("Battery: " + game.getBattery());
                            System.out.println("Usage: " + game.getUsage() + "\n");

                            System.out.print("What is your action? "+ "\n");
                            String action = scan.nextLine();
                            System.out.println();

                                if (action.equals("c")){
                                    count++;
                                    game.usingCamera();

                                    System.out.println("Freddy is at: " + game.getFreddyLoc());
                                    System.out.println("Bonnie is at: " + game.getBonnieLoc());
                                    System.out.println("Chica is at: " + game.getChicaLoc());
                                    System.out.println("Foxy is at: " + game.getFoxyLoc() + " (" + game.getFoxyStage() + ")");
                                }else if (action.equals("help")){
                                    System.out.println("(in front of action add 'o' to open and 'c' to close)");
                                    System.out.println("c: camera");
                                    System.out.println("ll: left lights");
                                    System.out.println("rl: right lights");
                                    System.out.println("ld: left door");
                                    System.out.println("rd: right lights");
                                }else if (action.equals("oll")){
                                    count++;
                                    game.useLeftLight();
                                    System.out.println("Left Light On");
                                }else if (action.equals( "orl")){
                                    count++;
                                    game.useRightLight();
                                    System.out.println("Right Light On");
                                }else if (action.equals("cld")){
                                    count++;
                                    game.useLeftDoor();
                                    System.out.println("Left Door Closed");
                                }else if (action.equals("crd")){
                                    count++;
                                    game.useRightDoor();
                                    System.out.println("Right Door Closed");
                                }else if (action.equals("old")){
                                    count++;
                                    game.useLeftDoor();
                                    System.out.println("Left Door Open");
                                }else if (action.equals("ord")){
                                    count++;
                                    game.useRightDoor();
                                    System.out.println("Right Door Open");
                                }else if (action.equals("cll")){
                                    count++;
                                    game.useLeftLight();
                                    System.out.println("Left Light Off");
                                }else if (action.equals("crl")){
                                    count++;
                                    game.useRightLight();
                                    System.out.println("Right Light Off");
                                }else {
                                    count++;
                                }
                            if (game.getChicaLoc().equals("Jumpscare") || game.getBonnieLoc().equals("Jumpscare") || game.getFoxyLoc().equals("Jumpscare") || game.getFreddyLoc().equals("Jumpscare")){
                                System.out.println("Game Over");
                                break;
                            }
                        }
                    }
                }


        } else if (choice == 2) {
            System.out.println("\nStarting 6th Night...");
        } else if (choice == 3) {
            System.out.println("\nStarting Ultra Custom Night...");
        } else if (choice == 4) {
            System.out.println("\nOpening Options...");
        } else {
            System.out.println("\nInvalid choice. Please try again.");
        }

        scan.close();
    }
}
