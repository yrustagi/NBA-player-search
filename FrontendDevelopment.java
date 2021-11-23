import java.util.Scanner;
import java.util.zip.DataFormatException;

import javax.security.auth.x500.X500Principal;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FrontendDeveloper {

  private static Backend backend;

  public static void main(String[] args) throws FileNotFoundException, IOException, DataFormatException {

    backend = new Backend(args);
    play();
  }
  public static void play() {
    Scanner sc = new Scanner(System.in);
    System.out.println(" ---------------------------------------");
    System.out.print("||");
    System.out.print("WELCOME TO THE BASKETBALL SEARCH ENGINE");
    System.out.println("||");
    System.out.println(" ---------------------------------------");
    String s = "Press \"T\" to seach by team or press \"P\" to search by player";
    System.out.println(s);
    String input = sc.nextLine();
    if (input.length() < 1) {
      System.out.println("Wrong input");
    }
    if (input.equals("T") || input.equals("t")) {
      selectionByTeam();
    } else if (input.equals("P") || input.equals("p")) {
      selectionByPlayer();
    }
  }

  private static String helper(ArrayList<Player> teams, char option) {
    // System.out.println("Press \"T\" to seach by team or press \"P\" to search by
    // player");

    String output = "";

    switch (option) {
    case 'R':
    case 'r':

      for (Player p : teams) {
        System.out.println(p.playerName + " " + p.getRPG());
      }
      break;

    case 'A':
    case 'a':

      for (Player p : teams) {
        System.out.println(p.playerName + " " + p.getAPG());
      }
      break;

    case 'P':
    case 'p':

      for (Player p : teams) {
        System.out.println(p.playerName + " " + p.getPPG());
      }
      break;

    default:
      output = "Wrong";
      break;
    }
    return output;
  }

  private static String playerHelper(Player p, char c) {

    String output = "";

    switch (c) {
    case 'R':
    case 'r':
      System.out.println(p.playerName + " " + p.getRPG());
      break;

    case 'A':
    case 'a':

      System.out.println(p.playerName + " " + p.getAPG());
      break;

    case 'P':
    case 'p':

      System.out.println(p.playerName + " " + p.getPPG());
      break;

    default:
      output = "Wrong";
      break;
    }
    return output;
  }

  private static void selectionByPlayer() {
    // TODO Auto-generated method stub
    Scanner sc = new Scanner(System.in);
    System.out.println("\n======================");
    System.out.println(" Search By Player Mode");
    System.out.println("======================\n");
    Player p = null;
    boolean search = true;
    while (search) {
      System.out.println("Please type the name the player");
      System.out.println("OR press [X] to return to the previous page");
      String name = sc.nextLine();
      if (name.equalsIgnoreCase("X")) {
        search = false;
        play();
      }
      while (true) {
        try {
          if (backend.searchByName(name) != null) {
            p = backend.searchByName(name);
            search = false;
            break;
          }
        } catch (Exception e) {
          System.out.println("Invalid input or the player doesn't exist");
          System.out.println("Please type the name the player");
          System.out.println("OR press [X] to return to the previous page");
          name = sc.nextLine();
          if (name.equalsIgnoreCase("X")) {
            search = false;
            selectionByPlayer();
          }
        }
      }
      if (name.equalsIgnoreCase("X")) {
        search = false;
        play();
      }
      System.out.println("Searched name: " + name);
      System.out.println("Would you like to see the player's [A]PG, [R]PG, or [P]PG?");
      System.out.println("OR press [X] to return to the previous page");
      String input = sc.nextLine();
      playerHelper(p, input.trim().charAt(0));
    }
  }

  public static void selectionByTeam() {
    Scanner sc = new Scanner(System.in);
    System.out.println("\n======================");
    System.out.println(" Search By Team Mode");
    System.out.println("======================\n");
    while (true) {
      System.out.println("Please type the name the team");
      System.out.println("OR press [X] to return to the previous page");
      String name = sc.nextLine();
      if (name.equalsIgnoreCase("X")) {
        play();
        break;
      }
      while (true) {
        if (name.length() < 1 || backend.searchByTeam(name) != null) {
          System.out.println("\n==Invalid input! Please try again!==\n");
          System.out.println("Please type the name the team");
          System.out.println("OR press [X] to return to the previous page");
          name = sc.nextLine();
          if (name.equalsIgnoreCase("X")) {
          }
        } else {
          break;
        }
      }
      if (name.equalsIgnoreCase("X")) {
        play();
      } else {
        ArrayList<Player> teams = (ArrayList<Player>) backend.searchByTeam(name);
        System.out.print("Searched team: " + name + " ");
        System.out.println("Would you like to see team's [A]PG, [R]PG, or [P]PG?");
        System.out.println("OR press [X] to return to the previous page");
        String input = sc.nextLine();
        helper(teams, input.trim().charAt(0));
        if (input.equalsIgnoreCase("X")) {
          break;
        }

      }

    }

  }
}
