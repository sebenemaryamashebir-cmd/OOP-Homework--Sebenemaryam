import java.util.Scanner;

public class PlayerSelection {
    public static void main(String[] args) {
        Scanner details = new Scanner(System.in);
        // Player details
        System.out.print("Enter your name:  ");
        String name = details.next();

        System.out.print("Enter your age:  ");
        int age = details.nextInt();

        System.out.print("Enter your height (in meters):  ");
        double height = details.nextDouble();

        System.out.print("Enter your weight (in pounds):  ");
        double weight = details.nextDouble();

        System.out.print("Enter your jersey number:  ");
        int jersey = details.nextInt();

        // Conversions
        double POUND = 0.45359237;
        int METER = 100;

        double weight_in_kilogram = POUND * weight;
        double height_in_centimeters = METER * height;

        int rounded_weight = (int) weight_in_kilogram;
        int rounded_height = (int) height_in_centimeters;

        // Category based on player's age
        String category ="";
        if (age < 20) {
            category = "Rising Star";
        } else if (age >= 20 && age <= 30) {
            category = "Prime Player";
        } else if (age > 30) {
            category = "Veteran";
        }
        // Position based on jersey number
        String position;
        switch (jersey) {
            case 1:
                position = "Goalkeeper";
                break;
            case 2:
            case 5:
                position = "Defender";
                break;
            case 6:
            case 8:
                position = "Midfielder";
                break;
            case 7:
            case 11:
                position = "Winger";
                break;
            case 9:
                position = "Striker";
                break;
            case 10:
                position = "Playmaker";
                break;
            default:
                position = "Player position not known";
        }
        // Eligibility
        String eligibility = (age >= 18 && age <= 35) && (rounded_weight < 90) ? "Eligible" : "Not Eligible";

        // Attacker check
        boolean isAttacker = (jersey == 7 || jersey == 9 || jersey == 10 || jersey == 11);

        // Lineup decision
        String lineupDecision;
        if (category.equals("Prime Player")) {
            lineupDecision = (rounded_weight < 80)?
                    "Lineup": "Bench";
        } else {
            lineupDecision = "Automatic bench";
        }
        // Final decision (Play/Rest)
        String finalDecision = eligibility.equals("Eligible") ? "Play" : "Rest";

        // Player report
        System.out.println("   Player Report  ");
        System.out.println("Player: " + name);
        System.out.println("Age: " + age + " (" + category + ")");
        System.out.println("Height: " + rounded_height + " cm");
        System.out.println("Weight: " + rounded_weight + " kg");
        System.out.println("Jersey: " + jersey);
        System.out.println("Position: " + position);
        System.out.println("Attacker jersey: " + (isAttacker ? "Yes" : "No"));
        System.out.println("Eligibility: " + eligibility);
        System.out.println("Lineup Decision: " + lineupDecision);
        System.out.println("Final Decision: " + finalDecision);

    }
    //  Unwanted fall-through demo
    public static void fallThroughDemo(int jersey) {
        switch (jersey) {
            case 2:
                System.out.println("Defender");
            case 5:
                System.out.println("Defender (fall through)");
            default:
                System.out.println("Unknown");
        }
    }
}