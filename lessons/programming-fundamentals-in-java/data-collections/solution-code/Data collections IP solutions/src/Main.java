import java.util.ArrayList;

/**
 * Created by drewmahrt on 1/19/16.
 */
public class Main {
    public static void main(String[] args) {
        findTheSize();

        concreteJungle();

        System.out.println("The sum is: "+returnTheSum(new int[]{}));
        System.out.println("The sum is: "+returnTheSum(new int[]{1}));
        System.out.println("The sum is: "+returnTheSum(new int[]{3,4}));

        printPigLatin("pig");
        printPigLatin("banana");
        printPigLatin("twig");
        printPigLatin("apple");
    }

    public static void findTheSize(){
        int[] nums = {1,2,3,4,5,6,7,8,9,10};
        System.out.println("Find the size: Array length "+nums.length);
    }

    public static void concreteJungle(){
        ArrayList<String> wildlife = new ArrayList<>();

        wildlife.add("squirrel");
        wildlife.add("rabbit");
        wildlife.add("mouse");
        wildlife.add("fox");

        for(String animal: wildlife){
            System.out.println("Today, I spotted a "+ animal +" in the concrete jungle!");
        }
    }

    public static int returnTheSum(int[] nums){
        int sum = 0;
        if(nums.length == 0){
            return 0;
        }else if(nums.length == 1){
            return nums[0];
        }else{
            return nums[0] + nums[1];
        }
    }

    public static void printPigLatin(String word){
        final String vowels = "aeiouAEIOU";

        if(vowels.contains(""+word.charAt(0))){
            System.out.println(word+"way");
        }else{
            String slice = word.substring(1);
            System.out.println(slice+word.charAt(0)+"ay");
        }

    }
}
