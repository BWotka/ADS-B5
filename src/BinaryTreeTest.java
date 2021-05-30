import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BinaryTreeTest {

  @Test
  public void left() {
    BinaryTree<Integer> binTree = new BinaryTree<Integer>(3, new BinaryTree<Integer>(5), new BinaryTree<Integer>(7));
    assertEquals(5, binTree.getLeft().getContent());
  }

  @Test
  public void right() {
    BinaryTree<Integer> binTree = new BinaryTree<Integer>(3, new BinaryTree<Integer>(5), new BinaryTree<Integer>(7));
    assertEquals(7, binTree.getRight().getContent());
  }

  @Test
  public void value() {
    BinaryTree<Integer> binTree = new BinaryTree<Integer>(3, new BinaryTree<Integer>(5), new BinaryTree<Integer>(7));
    assertEquals(3, binTree.getContent());
  }

  @Test
  public void leer_isEmpty() {
    assertTrue(new BinaryTree<Integer>().isEmpty());
  }

  @Test
  public void voll_isEmpty() {
    assertFalse(new BinaryTree<Integer>(3, new BinaryTree<Integer>(5), new BinaryTree<Integer>(7)).isEmpty());
  }
}