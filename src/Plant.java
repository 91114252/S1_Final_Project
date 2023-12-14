class Plant
{
    //Variables
    private String species;
    private int age;
    private boolean isWatered;
    private boolean isFlowering;
    private boolean isFruiting;
    private int growthStage;
    private boolean isAlive;
    private static int count;

    //Constructors
    public Plant()//default constructor
    {
        this.species = "";
        this.age = 0;
        this.isWatered = false;
        this.isFlowering = false;
        this.isFruiting = false;
        this.growthStage = 0;
        this.isAlive = true;
        count++;
    }

    public Plant (String pltSpecies, int pltAge, boolean pltWater, boolean pltFlower, boolean pltFruit, int pltGrowth, boolean pltAlive)
    {
        this.species = pltSpecies;
        this.age = pltAge;
        this.isWatered = pltWater;
        this.isFlowering = pltFlower;
        this.isFruiting = pltFruit;
        this.growthStage = pltGrowth;
        this.isAlive = pltAlive;
        count++;
    }

    //Getters

    public String getSpecies()
    {
        return species;
    }

    public int getAge()
    {
        return age;
    }

    public Boolean getIsWatered()
    {
        return isWatered;
    }

    public Boolean getIsFlowering()
    {
        return isFlowering;
    }

    public Boolean getIsFruiting()
    {
        return isFruiting;
    }

    public int getGrowthStage()
    {
        return growthStage;
    }

    public Boolean getIsAlive()
    {
        return isAlive;
    }

    public static int getCount()
    {
        return count;
    }

    //Setters
    public void setSpecies(String pltSpecies)
    {
        species = pltSpecies;
    }
    public void setAge(int pltAge)
    {
        age = pltAge;
    }

    public void setWatered(boolean pltWater)
    {
        isWatered = pltWater;
    }

    public void setFlowering(boolean pltFlower)
    {
        isFlowering = pltFlower;
    }

    public void setFruiting(boolean pltFruit)
    {
        isFruiting = pltFruit;
    }

    public void setGrowthStage(int pltGrowth)
    {
        growthStage = pltGrowth;
    }

    public void setIsAlive(boolean pltAlive)
    {
        isAlive = pltAlive;
    }

    //Methods
    public String toString()//converts to string
    {
        return "Species: " + species + "\nAge: " + age + "\nWatered: " + isWatered + "\nFlowering: " + isFlowering + "\nFruiting: " + isFruiting + "\nGrowth Stage: " + growthStage + "\nLife Status: " + isAlive;
    }

    public String healthStatus()//determines the health status
    {
        if (isAlive == true)
        {
            if (waterStatus().equals("watered"))
            {
                return "Healthy";
            }
            return "Not Healthy";
        }
        return "Dead";
    }
    public String waterStatus()//determines if it has been watered
    {
        if (isWatered == true)
        {
            return "watered";
        }
        return "Needs Water";
    }

}