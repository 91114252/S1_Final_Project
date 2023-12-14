import java.util.Scanner;

class Main
{

    public static void main(String[] args)
    {
        //include the ability to try again
        Plant plt1 = new Plant();
        Scanner scan = new Scanner(System.in);
        int day = 0;
        int money = 0;
        int growthStage = plt1.getGrowthStage();
        menu();
        boolean run;
        for (int i = 0; i < 3; i++)
        {
            run = true;
            while (run != false)
            {
                String command = scan.nextLine();
                if (command.equalsIgnoreCase("GrowPlant"))
                {
                    System.out.println("What plant do you want to grow?");
                    plt1.setSpecies(scan.nextLine());
                    plt1.setIsAlive(true);
                    menu();
                }
                if (command.equalsIgnoreCase("healthStatus"))
                {
                    System.out.println(plt1.healthStatus());
                    menu();
                }
                if (command.equalsIgnoreCase("water"))
                {
                    System.out.println("Watered!");
                    plt1.setWatered(true);
                    menu();
                }
                if (command.equalsIgnoreCase("shop"))
                {
                    shop(money);
                }
                if (command.equalsIgnoreCase("endday"))
                {
                    day++;
                    System.out.println("Day: " + day);
                    menu();
                    money += 3;
                    if (day == growthTime(plt1.getSpecies(), growthStage))
                    {
                        growthStage++;
                    }
                    if (growthStage == 4)
                    {
                        plt1.setFlowering(true);
                        System.out.println("Flowering!");
                    }
                }
                if (command.equalsIgnoreCase("endGame"))
                {
                    run = false;
                }

                if (command.equalsIgnoreCase("pollinate"))
                {
                    if(plt1.getIsFlowering() == true)
                    {
                        plt1.setFruiting(true);
                        plt1.setFlowering(false);
                        System.out.println("Pollinated");
                        menu();
                    }
                    System.out.println("not flowering, try again later");
                    menu();
                }
                if (command.equalsIgnoreCase("harvest"))
                {
                    if (plt1.getIsFruiting() == true)
                    {
                        plt1.setFruiting(false);
                        System.out.println("Harvested!");
                        menu();
                    }
                    System.out.println("Not fruiting, try again later");
                    menu();
                }
                if (command.equalsIgnoreCase("plantbio"))
                {
                    System.out.println(plt1.toString());
                    menu();
                }

            }
        }


    }

    public static void menu()//include the commands you can do
    {
        Scanner scan = new Scanner(System.in);
        System.out.println("Menu" +
                "\nCommands:" +
                "\nGrowPlant HealthStatus PlantBio Water \nPollinate Harvest Shop endDay \nitems endgame");
        System.out.println("Type in a command: ");
    }
    //test comment by Rioux
    public static void shop(int money)//shows the shop
    {
        Scanner scan = new Scanner(System.in);
        boolean hasFertilizer;
        boolean hasPesticide;
        boolean hasInsecticide;
        System.out.println("Shop:" +
                "\nFertilizer 5$\nInsecticide 3$\nFungicide 3$");
        System.out.println("type in the item name to buy");
        String Items = scan.nextLine();
        boolean run = true;
        while (run == true)
        {
            if (Items.equalsIgnoreCase("fertilizer"))
            {
                if (money == 5)
                {
                    System.out.println("bought fertilizer");
                    hasFertilizer = true;
                    run = false;
                    menu();
                }
                System.out.println("Insuficient Funds");
            }
            if (Items.equalsIgnoreCase("insecticide"))
            {
                if (money == 3)
                {
                    System.out.println("bought insecticide");
                    hasInsecticide = true;
                    run = false;
                    menu();
                }
                System.out.println("Insuficient Funds");
            }
            if (Items.equalsIgnoreCase("fungicide"))
            {
                if (money == 3)
                {
                    System.out.println("bought fungicide");
                    hasPesticide = true;
                    run = false;
                    menu();
                }
                System.out.println("Insuficient Funds");
            }
        }
        menu();
    }

    public static int growthTime(String speciesName, int growthStage)//determines how long it will grow to each stage
    {
        if (growthStage == 1)
        {
            return speciesName.length() / 4;
        }
        if (growthStage == 2)
        {
            return speciesName.length() / 3;
        }
        if (growthStage == 3)
        {
            return speciesName.length() / 2;
        }
        return speciesName.length() - ((speciesName.length() / 4) + (speciesName.length() / 3) + (speciesName.length() / 2));
    }

}
