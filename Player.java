import javax.naming.Name;

public class Player {
    private String name;
    private int position; // Private field
    private int scraps;
    private boolean finished;
    private int waterBuckets;
    private boolean answeredQuestionCorrectly;
    private boolean completedDiceChallenge;
    private boolean passedstartwith100scraps;
    private Objective currentobjective;
    private int taskcompleted;

    public Player(String name) {
        this.name = name;
        this.position = 0;
        this.scraps = 20;
        this.finished = false;
        this.waterBuckets = 5;
        this.answeredQuestionCorrectly = false;
        this.completedDiceChallenge = false;
        this.passedstartwith100scraps = false;
        this.taskcompleted = 0;
        this.assignNewObjective();
    }

    // Getter for player name
    public String getName() {
        return name;
    }

    // Getter for player position
    public int getPosition() {
        return position;
    }

    // Setter for player position
    public void setPosition(int position) {
        this.position = position;
    }

    // Move the player by a number of steps
    public void move(int steps) {
        this.position += steps;
        System.out.println(name + " moved to position " + position);
        if(position >= 40) {
            position %= 40;
            if(scraps >= 100) {
                passedstartwith100scraps = true;
            }
        }
    }

    public void assignNewObjective() {
        switch (taskcompleted/2){
            case 0: currentobjective = new Task1_Building_Pipe(); break;
            case 1: currentobjective = new Task2_Building_Tank(); break;
            case 2: currentobjective = new Task3_Building_Filter(); break;
            case 3: currentobjective = new Task4_Building_Pump(); break;
            default: finished = true; return;
        }
        System.out.println(name + " received new objective" + currentobjective.Objectives);
    }

    public void completeTask(){
        if(passedstartwith100scraps){
            taskcompleted++;
            System.out.println(name + " task completed" + currentobjective.Objectives);
            if(taskcompleted % 2 == 0) {
                System.out.println(name + " task completed" + currentobjective.Objectives);
                assignNewObjective();
            }
            else {
                System.out.println(name + " needs pass start with 100scraps" );
            }
        }
    }

    public boolean cancompletechallenge() {
        return passedstartwith100scraps;
    }

    // Getter for scraps
    public int getTotalScraps() {
        return scraps;
    }

    // Add scraps to the player
    public void addScraps(int amount) {
        scraps += amount;
        System.out.println(name + " gained " + amount + " scraps. Total scraps: " + scraps);
    }

    // Subtract scraps from the player
    public void subtractScraps(int amount) {
        scraps -= amount;
        System.out.println(name + " lost " + amount + " scraps. Total scraps: " + scraps);
    }

    // Getter for water buckets
    public int getWaterBuckets() {
        return waterBuckets;
    }

    // Add water buckets to the player
    public void addWaterBucket(int amount) {
        waterBuckets += amount;
        System.out.println(name + " gained " + amount + " water buckets. Total water buckets: " + waterBuckets);
    }

    // Subtract water buckets from the player
    public void subtractWaterBucket(int amount) {
        waterBuckets -= amount;
        System.out.println(name + " lost " + amount + " water buckets. Total water buckets: " + waterBuckets);
    }

    // Check if the player has finished the game
    public boolean hasFinished() {
        return finished;
    }

    // Setter for finished status
    public void setFinished(boolean finished) {
        this.finished = finished;
    }

    // Check if the player has answered a question correctly
    public boolean hasAnsweredQuestionCorrectly() {
        return answeredQuestionCorrectly;
    }

    // Setter for answeredQuestionCorrectly
    public void setAnsweredQuestionCorrectly(boolean answeredQuestionCorrectly) {
        this.answeredQuestionCorrectly = answeredQuestionCorrectly;
    }

    // Check if the player has completed the dice challenge
    public boolean hasCompletedDiceChallenge() {
        return completedDiceChallenge;
    }

    // Setter for completedDiceChallenge
    public void setCompletedDiceChallenge(boolean completedDiceChallenge) {
        this.completedDiceChallenge = completedDiceChallenge;
    }


    // Display the player's current status
    public void displayStatus() {
        System.out.println(name + " - Position: " + position + ", Scraps: " + scraps + ", Water Buckets: " + waterBuckets);
    }
}