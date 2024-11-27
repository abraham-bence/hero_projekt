package hu.petrik.szuperhosprojekt;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Kepregeny{

    public static List<Szuperhos> szuperhosLista = new ArrayList<>();

    public static void szereplok(String fileName){
        try {
            File myObj = new File(fileName);
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                String type = data.split(" ")[0];
                int callQuantity = Integer.parseInt(data.split(" ")[1]);

                if (type.equals("Vasember")) {
                    Vasember vasember = new Vasember();
                    szuperhosLista.add(vasember);
                    for (int i = 0; i < callQuantity; i++) {
                        vasember.kutyutKeszit();
                    }
                } else if (type.equals("Batman")) {
                    Batman batman = new Batman();
                    szuperhosLista.add(batman);
                    for (int i = 0; i < callQuantity; i++) {
                        batman.kutyutKeszit();
                    }
                }
            }
            myReader.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void szuperhosok() {
        for (Szuperhos szuperhos : szuperhosLista) {
            System.out.println(szuperhos);
        }
    }
}
