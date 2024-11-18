import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {

        Scanner sc= new Scanner(System.in);
        int N= sc.nextInt();

        for (int a=0; a<N; a++){

            for (int i = 0; i <=a; i++) {
                System.out.print("*");
            }
            System.out.print("\n");
//            System.out.println("\n");
        }

    }
}