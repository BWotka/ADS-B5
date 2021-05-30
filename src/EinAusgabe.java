import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Used to get data from user and share data with user.
 * Communicating using the Console
 */
public class EinAusgabe {
  boolean keepRunning = true;
  BufferedReader br;
  BinarySearchTree<SortierInt> intTree;
  BinarySearchTree<SortierString> stringTree;

  public EinAusgabe() {
    br = new BufferedReader(new InputStreamReader(System.in));
    intTree = new BinarySearchTree<SortierInt>();
    programLoop();
  }

  private void programLoop() {
    System.out.println("Willkommen zum binären Suchbaum");
    while (keepRunning) {
      getInput();
    }
    System.out.println("Programm wird beendet");
  }

  private void getInput() {
    System.out.println("Es gibt folgende Optionen:");
    System.out.println("Einfuegen 'e'");
    System.out.println("Loeschen 'l'");
    System.out.println("Modifizieren 'm'");
    System.out.println("Baumausgabe 'a'");
    System.out.println("Stopp 's'");
    System.out.println("Was moechtest du tun?");
    try {
      char eingabe = br.readLine().charAt(0);
      switch (eingabe) {
        case 'e':
          create();
          break;
        case 'l':
          remove();
          break;
        case 'm':
          modify();
          break;
        case 'a':
          System.out.println("Zuerst Preoder");
          System.out.println(preorder(intTree, 0));
          System.out.println("Jetzte Inorder");
          System.out.println(inorder(intTree, 0));

        case 's':
          keepRunning = false;
          break;
      }
    } catch (IOException pE) {
      System.out.println("Problem mit Eingabe");
    }
  }

  private void modify() {
    System.out.println("Modifizieren ausgewählt");
    System.out.println("Welche Zahl soll bearbeitet werden?");
    intTree.remove(new SortierInt(leseInteger()));
    System.out.println("Wie soll die Zahl jetzt lauten?");
    intTree.insert(new SortierInt(leseInteger()));
    System.out.println("Neue Zahl jetzt im Baum");
  }

  private void remove() {
    System.out.println("Loeschen ausgewählt");
    System.out.println("Welche Zahl soll geloescht werden(wenn vorhanden)?");
    intTree.remove(new SortierInt(leseInteger()));
    System.out.println("Zahl nicht (mehr) im Baum");
  }

  private void create() {
    System.out.println("Erstellen ausgewählt");
    System.out.println("Welche Zahl soll eingefuegt werden?");
    intTree.insert(new SortierInt(leseInteger()));
    System.out.println("Zahl erfolgreich eingefuegt");


  }

  private int leseInteger() {
    String input;
    try {
      input = br.readLine();
    } catch (IOException pIOException) {
      System.out.println("Einlesefehler");
      create();
      return leseInteger();
    }
    int neuInt;
    try {
      neuInt = Integer.parseInt(input);
    } catch (NumberFormatException pNumberFormatException) {
      System.out.println("Deine Eingabe konnte nicht als Zahl erkannt werden");
      return leseInteger();
    }
    return neuInt;
  }

  /**
   * Used to create String of complete tree in preorder.
   * Works recursive
   *
   * @param pWurzel current tree
   * @param pDepth  depth of pWurzel in complete tree
   * @return preorder String of tree
   */
  private String preorder(BinarySearchTree pWurzel, int pDepth) {
    String ausgabe = "";
    ausgabe += wertAusgabe(pWurzel, pDepth);
    ausgabe += " : ";
    ausgabe += wertAusgabe(pWurzel.getLeft(), pDepth + 1);
    ausgabe += wertAusgabe(pWurzel.getRight(), pDepth + 1);
    ausgabe += "\n";
    return ausgabe + preorder(pWurzel.getLeft(), pDepth + 1) + preorder(pWurzel.getRight(), pDepth + 1);
  }

  /**
   * Used to create String of complete tree in inorder.
   * Works recursive
   * Sorted for BinarySearchTree
   *
   * @param pWurzel current tree
   * @param pDepth  depth of pWurzel in complete tree
   * @return inorder String of tree
   */
  private String inorder(BinarySearchTree pWurzel, int pDepth) {
    String ausgabe = "";
    ausgabe += wertAusgabe(pWurzel, pDepth);
    ausgabe += " : ";
    ausgabe += wertAusgabe(pWurzel.getLeft(), pDepth + 1);
    ausgabe += wertAusgabe(pWurzel.getRight(), pDepth + 1);
    ausgabe += "\n";
    return preorder(pWurzel.getLeft(), pDepth + 1) + ausgabe + preorder(pWurzel.getRight(), pDepth + 1);
  }

  /**
   * Used to create string containing data from a single element in tree.
   *
   * @param pWurzel tree of which the return will be created
   * @param pDepth  depth of pWurzel in complete tree
   * @return String like "a(ha,ba)"
   */
  private String wertAusgabe(BinarySearchTree pWurzel, int pDepth) {
    if (pWurzel.isEmpty()) {
      return "null";
    }
    int balance = 0;
    if (! pWurzel.getLeft().isEmpty()) {
      balance++;
    }
    if (! pWurzel.getRight().isEmpty()) {
      balance++;
    }
    return pWurzel.getContent() + "(" + pDepth + " ," + balance + ")";
  }
}
