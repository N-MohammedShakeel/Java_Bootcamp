package Java_Bootcamp.Infosys;

import java.util.Scanner;

public class HeroVillain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int nVillains = sc.nextInt();
        int nHeros = sc.nextInt();
        int hHealth = sc.nextInt();

        int[] heroHealth = new int[nHeros];
        int[] villainHealth = new int[nVillains];

        for (int i = 0; i < nHeros; i++) {
            heroHealth[i] = hHealth;
        }

        for (int i = 0; i < nVillains; i++) {
            villainHealth[i] = sc.nextInt();
        }

        int heroIndex = 0, villainIndex = 0;

        while (heroIndex < nHeros && villainIndex < nVillains) {
            if (heroHealth[heroIndex] > villainHealth[villainIndex]) {
                // Hero wins but takes damage
                heroHealth[heroIndex] -= villainHealth[villainIndex];
                villainHealth[villainIndex] = 0;
                villainIndex++; // Move to the next villain
            } else if (heroHealth[heroIndex] < villainHealth[villainIndex]) {
                // Villain wins, keeps remaining health
                villainHealth[villainIndex] -= heroHealth[heroIndex];
                heroHealth[heroIndex] = 0;
                heroIndex++; // Move to the next hero
            } else {
                // Both die
                heroHealth[heroIndex] = 0;
                villainHealth[villainIndex] = 0;
                heroIndex++;
                villainIndex++;
            }
        }

        boolean villainsLeft = false;
        for (int v : villainHealth) {
            if (v > 0) {
                villainsLeft = true;
                break;
            }
        }

        if (villainsLeft) {
            System.out.println("Villains win");
        } else {
            System.out.println("Heroes win");
        }

        sc.close();
    }
}
