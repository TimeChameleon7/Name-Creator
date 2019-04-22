import java.util.Scanner;

public class Main {
    private static String[] consonants = {"b","d","f","g","h","j","k","l","m","n","x","p",
            "r","s","t","v","w","y","z","th","ch","sh","zh"};
    private static String[] vowels = {"a","e","i","o","u","ae","ee","ie","oe","ue","oo",
            "ar","ur","au","er","ow","oi","air","ear","ure"};
    private static Scanner kb = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Generate a certain number of names, or calculate time and iterations to generate a name?" +
                "[many/name]");
        switch (kb.nextLine()) {
            case "many":
                manyNames();
                break;
            case "name":
                specificName();
                break;
            default:
                System.out.println("Invalid input, try again.\n");
                main(args);
        }
    }

    private static void manyNames(){
        System.out.print("Number of names to generate:  ");
        for(int numOfNames = kb.nextInt();numOfNames>0;numOfNames--){
            if(Math.random()<.26){
                System.out.println(randName()+" "+randName());
            }else{
                System.out.println(randName());
            }
        }
    }

    private static void specificName(){
        int count = 0;
        String name = "";
        System.out.print("Name to search for:\t");
        String searchName = kb.next();
        final long startTime = System.nanoTime();
        while(!name.equals(searchName)){
            count++;
            if(count%1000000==0){
                System.out.println("Gone through "+(count/1000000)+" million names");
            }
            name = randName();
        }
        System.out.println("\nSuccess");
        System.out.println("Time: "+((System.nanoTime()-startTime)/1000000)+" milliseconds");
        System.out.printf("Went through %,d names",count);
    }



    private static String randName(){
        String name = "";
        Boolean vowelStart = Math.random()<.5;
        for(int numOfSounds = (int)(Math.random()*3+1);numOfSounds>0;numOfSounds--){
            name+=randSound(vowelStart);
            if(Math.random()<.63){
                if(vowelStart){
                    name+=vowels[(int)(Math.random()*vowels.length-1)];
                }else{
                    name+=consonants[(int)(Math.random()*consonants.length-1)];
                }
            }
        }
        return name;
    }

    private static String randSound(Boolean vowelStart){
        if(vowelStart){
            return vowels[(int)(Math.random()*vowels.length-1)]+
                    consonants[(int)(Math.random()*consonants.length-1)];
        }else{
            return consonants[(int)(Math.random()*consonants.length-1)]+
                    vowels[(int)(Math.random()*vowels.length-1)];
        }
    }
}


