import java.util.*;
import java.io.*;
import java.util.regex.Pattern;

public class Hai{
    public String printar(ArrayList<String> s){
        String ret = "";
        for(int i = 0; i < s.size(); i++){
            if(i != s.size() - 1){
                ret += (s.get(i) + " ");
            }
            else ret += (s.get(i));
        }
        return ret;
    }

    public void run() throws Exception{
        //Scanner f = new Scanner(in);
        Scanner f = new Scanner(new File("data/hai.dat"));
        String[] line = f.nextLine().trim().split(" ");
        int times = f.nextInt();
        for(int i = 0; i < times; i++){
            String regex = f.next();
            ArrayList<String> match = new ArrayList<>();
            for(String s : line){
                if(Pattern.matches(regex, s)) match.add(s);
            }
            if(match.size() == 0) System.out.println("No matches.");
            else System.out.printf("%1$-10s%2$s%n", regex, printar(match));
        }

        f.close();
    }
    public static void main(String[] args) throws Exception{
        new Hai().run();
    }
}



