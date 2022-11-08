package FPL;

public abstract class parentAirCraft {

    public void safertyGuildline(){
        System.out.println("Guildlines for all is same ");
    }

    public abstract void color();

    public static int solution(int N) {
        // write your code in Java SE 8
        System.out.println("this is a debug message");
        return N+5;
    }

    public static void main(){

        System.out.println(solution(3));
    }


}
