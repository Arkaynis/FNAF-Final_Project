import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("FIVE NIGHTS AT FREDDY'S");
        System.out.println("Please make an option below:" + "\n");
        System.out.println("1. New Game");
        System.out.println("2. 6th Night");
        System.out.println("3. Ultimate Custom Night");
        System.out.println();

        int choice = scan.nextInt();
        int count = 1;
        boolean gameOver = false;

        if (choice == 1) {
            System.out.println("\nStarting Game...");
            for (int i = 1; i <= 5; i++){
            System.out.println("12:00 AM" + "\n" + "Night " + i + "\n\n");
                Game game = new Game();

                while (game.getAlive() == true && count <= 480){
                    game.tick(count);
                    System.out.println();
                    System.out.println("Time: " + game.getTime());
                    System.out.println("Night: " + i);
                    System.out.println("Battery: " + game.getBattery());
                    System.out.println("Usage: " + game.getUsage() + "\n");

                    System.out.print("What is your action? "+ "\n");
                    String action = scan.nextLine();
                    System.out.println();

                        if (action.equals("c")){
                            count++;
                            game.usingCamera();
                            if (!(game.getBonnieLoc().equals("Office")) && !(game.getChicaLoc().equals("Office")) && !(game.getFoxyLoc().equals("Office")) && !(game.getFreddyLoc().equals("Office"))){
                                System.out.println("Freddy is at: " + game.getFreddyLoc());
                                System.out.println("Bonnie is at: " + game.getBonnieLoc());
                                System.out.println("Chica is at: " + game.getChicaLoc());
                                System.out.println("Foxy is at: " + game.getFoxyLoc() + " (" + game.getFoxyStage() + ")");
                            }else if (game.getFreddyLoc().equals("Office")){
                                System.out.println("Freddy is at: ");
                                System.out.println("Bonnie is at: " + game.getBonnieLoc());
                                System.out.println("Chica is at: " + game.getChicaLoc());
                                System.out.println("Foxy is at: " + game.getFoxyLoc() + " (" + game.getFoxyStage() + ")");
                            }else if (game.getBonnieLoc().equals("Office")){
                                System.out.println("Freddy is at: " + game.getFreddyLoc());
                                System.out.println("Bonnie is at: ");
                                System.out.println("Chica is at: " + game.getChicaLoc());
                                System.out.println("Foxy is at: " + game.getFoxyLoc() + " (" + game.getFoxyStage() + ")");
                            }else if (game.getChicaLoc().equals("Office")){
                                System.out.println("Freddy is at: " + game.getFreddyLoc());
                                System.out.println("Bonnie is at: " + game.getBonnieLoc());
                                System.out.println("Chica is at: ");
                                System.out.println("Foxy is at: " + game.getFoxyLoc() + " (" + game.getFoxyStage() + ")");
                            }else if (game.getFoxyLoc().equals("Office")){
                                System.out.println("Freddy is at: " + game.getFreddyLoc());
                                System.out.println("Bonnie is at: " + game.getBonnieLoc());
                                System.out.println("Chica is at: " + game.getChicaLoc());
                                System.out.println("Foxy is at: ");
                            }
                            game.usingCamera();
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

                                if (game.getBonnieLoc().equals("Office")){
                                    System.out.println("Bonnie is outside your office");
                                }
                        }else if (action.equals( "orl")){
                            count++;
                            game.useRightLight();
                            System.out.println("Right Light On");

                                if (game.getChicaLoc().equals("Office")){
                                    System.out.println("Chica is outside your office");
                                }
                        }else if (action.equals("cld")){
                            count++;
                            game.useLeftDoor();
                            System.out.println("Left Door Closed");

                            if (game.getFoxyLoc().equals("Office")){
                                System.out.println("You hear Foxy banging on the door");
                            }
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
                    if (game.getChicaLoc().equals("Jumpscare")){
                        System.out.println("Chica jumpscared you" + "\n" + "Game Over");
                        gameOver = true;
                        break;
                    }else if (game.getBonnieLoc().equals("Jumpscare")){
                        System.out.println("Bonnie jumpscared you" + "\n" + "Game Over");
                        gameOver = true;
                        break;
                    }else if (game.getFoxyLoc().equals("Jumpscare")){
                        System.out.println("Foxy jumpscared you" + "\n" + "Game Over");
                        gameOver = true;
                        break;
                    } else if (game.getFreddyLoc().equals("Jumpscare")){
                        System.out.println("Freddy jumpscared you" + "\n" + "Game Over");
                        gameOver = true;
                        break;
                    }
                    if (game.getBattery() <= 0){
                        game.powerOutage();
                    }
                }

                if (count == 480 || game.getTime().equals("6:00 AM")){
                    count = 1;
                    game.updateNight(i);
                    game.reset();
                }
                if (gameOver) {
                    break;
                }
            }

            System.out.println("\nCongratulations! You completed the game!");
            System.out.println("You survived all 5 nights!");
            System.out.println("Thank you for playing!");
        } else if (choice == 2) {
            System.out.println("\nStarting 6th Night...");

            System.out.println("12:00 AM" + "\n" + "Night " + 6 + "\n\n");
                Game game = new Game(1);

                while (game.getAlive() == true && count <= 480){
                    game.tick(count);
                    System.out.println();
                    System.out.println("Time: " + game.getTime());
                    System.out.println("Night: " + 6);
                    System.out.println("Battery: " + game.getBattery());
                    System.out.println("Usage: " + game.getUsage() + "\n");

                    System.out.print("What is your action? "+ "\n");
                    String action = scan.nextLine();
                    System.out.println();

                        if (action.equals("c")){
                            count++;
                            game.usingCamera();
                            if (!(game.getBonnieLoc().equals("Office")) && !(game.getChicaLoc().equals("Office")) && !(game.getFoxyLoc().equals("Office")) && !(game.getFreddyLoc().equals("Office"))){
                                System.out.println("Freddy is at: " + game.getFreddyLoc());
                                System.out.println("Bonnie is at: " + game.getBonnieLoc());
                                System.out.println("Chica is at: " + game.getChicaLoc());
                                System.out.println("Foxy is at: " + game.getFoxyLoc() + " (" + game.getFoxyStage() + ")");
                            }else if (game.getFreddyLoc().equals("Office")){
                                System.out.println("Freddy is at: ");
                                System.out.println("Bonnie is at: " + game.getBonnieLoc());
                                System.out.println("Chica is at: " + game.getChicaLoc());
                                System.out.println("Foxy is at: " + game.getFoxyLoc() + " (" + game.getFoxyStage() + ")");
                            }else if (game.getBonnieLoc().equals("Office")){
                                System.out.println("Freddy is at: " + game.getFreddyLoc());
                                System.out.println("Bonnie is at: ");
                                System.out.println("Chica is at: " + game.getChicaLoc());
                                System.out.println("Foxy is at: " + game.getFoxyLoc() + " (" + game.getFoxyStage() + ")");
                            }else if (game.getChicaLoc().equals("Office")){
                                System.out.println("Freddy is at: " + game.getFreddyLoc());
                                System.out.println("Bonnie is at: " + game.getBonnieLoc());
                                System.out.println("Chica is at: ");
                                System.out.println("Foxy is at: " + game.getFoxyLoc() + " (" + game.getFoxyStage() + ")");
                            }else if (game.getFoxyLoc().equals("Office")){
                                System.out.println("Freddy is at: " + game.getFreddyLoc());
                                System.out.println("Bonnie is at: " + game.getBonnieLoc());
                                System.out.println("Chica is at: " + game.getChicaLoc());
                                System.out.println("Foxy is at: ");
                            }
                            game.usingCamera();
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

                                if (game.getBonnieLoc().equals("Office")){
                                    System.out.println("Bonnie is outside your office");
                                }
                        }else if (action.equals( "orl")){
                            count++;
                            game.useRightLight();
                            System.out.println("Right Light On");

                                if (game.getChicaLoc().equals("Office")){
                                    System.out.println("Chica is outside your office");
                                }
                        }else if (action.equals("cld")){
                            count++;
                            game.useLeftDoor();
                            System.out.println("Left Door Closed");

                            if (game.getFoxyLoc().equals("Office")){
                                System.out.println("You hear Foxy banging on the door");
                            }
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
                    if (game.getChicaLoc().equals("Jumpscare")){
                        System.out.println("Chica jumpscared you" + "\n" + "Game Over");
                        gameOver = true;
                        break;
                    }else if (game.getBonnieLoc().equals("Jumpscare")){
                        System.out.println("Bonnie jumpscared you" + "\n" + "Game Over");
                        gameOver = true;
                        break;
                    }else if (game.getFoxyLoc().equals("Jumpscare")){
                        System.out.println("Foxy jumpscared you" + "\n" + "Game Over");
                        gameOver = true;
                        break;
                    } else if (game.getFreddyLoc().equals("Jumpscare")){
                        System.out.println("Freddy jumpscared you" + "\n" + "Game Over");
                        gameOver = true;
                        break;
                    }
                    if (game.getBattery() <= 0){
                        game.powerOutage();
                    }
                }

                if (count == 480 || game.getTime().equals("6:00 AM")){
                    System.out.println("\nCongratulations! You completed the 6th night!");
                    System.out.println("Thank you for playing!");
                }
                
        } else if (choice == 3) {
            System.out.println("\nStarting Ultimate Custom Night..." + "\n");

            System.out.println("Please enter the difficulty level (1-20) for each animatronic");
            System.out.print("Bonnie: ");
                int bonLev = scan.nextInt();
            System.out.print("Chica: ");
                int chiLev = scan.nextInt();
            System.out.print("Foxy: ");
                int foxLev = scan.nextInt();
            System.out.print("Freddy: ");
                int freLev = scan.nextInt();
            System.out.println();

            Game game = new Game(bonLev, chiLev, foxLev, freLev);


            System.out.println("\nStarting Ultimate Custom Night..." + "\n");

            System.out.println("12:00 AM" + "\n" + "Night " + 7 + "\n\n");

                while (game.getAlive() == true && count <= 480){
                    game.tick(count);
                    System.out.println();
                    System.out.println("Time: " + game.getTime());
                    System.out.println("Night: " + 6);
                    System.out.println("Battery: " + game.getBattery());
                    System.out.println("Usage: " + game.getUsage() + "\n");

                    System.out.print("What is your action? "+ "\n");
                    String action = scan.nextLine();
                    System.out.println();

                        if (action.equals("c")){
                            count++;
                            game.usingCamera();
                            if (!(game.getBonnieLoc().equals("Office")) && !(game.getChicaLoc().equals("Office")) && !(game.getFoxyLoc().equals("Office")) && !(game.getFreddyLoc().equals("Office"))){
                                System.out.println("Freddy is at: " + game.getFreddyLoc());
                                System.out.println("Bonnie is at: " + game.getBonnieLoc());
                                System.out.println("Chica is at: " + game.getChicaLoc());
                                System.out.println("Foxy is at: " + game.getFoxyLoc() + " (" + game.getFoxyStage() + ")");
                            }else if (game.getFreddyLoc().equals("Office")){
                                System.out.println("Freddy is at: ");
                                System.out.println("Bonnie is at: " + game.getBonnieLoc());
                                System.out.println("Chica is at: " + game.getChicaLoc());
                                System.out.println("Foxy is at: " + game.getFoxyLoc() + " (" + game.getFoxyStage() + ")");
                            }else if (game.getBonnieLoc().equals("Office")){
                                System.out.println("Freddy is at: " + game.getFreddyLoc());
                                System.out.println("Bonnie is at: ");
                                System.out.println("Chica is at: " + game.getChicaLoc());
                                System.out.println("Foxy is at: " + game.getFoxyLoc() + " (" + game.getFoxyStage() + ")");
                            }else if (game.getChicaLoc().equals("Office")){
                                System.out.println("Freddy is at: " + game.getFreddyLoc());
                                System.out.println("Bonnie is at: " + game.getBonnieLoc());
                                System.out.println("Chica is at: ");
                                System.out.println("Foxy is at: " + game.getFoxyLoc() + " (" + game.getFoxyStage() + ")");
                            }else if (game.getFoxyLoc().equals("Office")){
                                System.out.println("Freddy is at: " + game.getFreddyLoc());
                                System.out.println("Bonnie is at: " + game.getBonnieLoc());
                                System.out.println("Chica is at: " + game.getChicaLoc());
                                System.out.println("Foxy is at: ");
                            }
                            game.usingCamera();
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

                                if (game.getBonnieLoc().equals("Office")){
                                    System.out.println("Bonnie is outside your office");
                                }
                        }else if (action.equals( "orl")){
                            count++;
                            game.useRightLight();
                            System.out.println("Right Light On");

                                if (game.getChicaLoc().equals("Office")){
                                    System.out.println("Chica is outside your office");
                                }
                        }else if (action.equals("cld")){
                            count++;
                            game.useLeftDoor();
                            System.out.println("Left Door Closed");

                            if (game.getFoxyLoc().equals("Office")){
                                System.out.println("You hear Foxy banging on the door");
                            }
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
                    if (game.getChicaLoc().equals("Jumpscare")){
                        System.out.println("Chica jumpscared you" + "\n" + "Game Over");
                        gameOver = true;
                        break;
                    }else if (game.getBonnieLoc().equals("Jumpscare")){
                        System.out.println("Bonnie jumpscared you" + "\n" + "Game Over");
                        gameOver = true;
                        break;
                    }else if (game.getFoxyLoc().equals("Jumpscare")){
                        System.out.println("Foxy jumpscared you" + "\n" + "Game Over");
                        gameOver = true;
                        break;
                    } else if (game.getFreddyLoc().equals("Jumpscare")){
                        System.out.println("Freddy jumpscared you" + "\n" + "Game Over");
                        gameOver = true;
                        break;
                    }
                    if (game.getBattery() <= 0){
                        game.powerOutage();
                    }
                }

                if (count == 480 || game.getTime().equals("6:00 AM")){
                    System.out.println("\nCongratulations! You completed the 6th night!");
                    System.out.println("Thank you for playing!");
                }

        } else {
            System.out.println("\nInvalid choice. Please try again.");
        }

        scan.close();
    }
}
