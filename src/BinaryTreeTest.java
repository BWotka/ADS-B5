import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class BinaryTreeTest {

  /*
  left(bin(x, b, y)) = x
   */
  @Test
  public void left() {
    BinaryTree<Integer> binTree = new BinaryTree<Integer>(3, new BinaryTree<Integer>(5), new BinaryTree<Integer>(7));
    assertEquals(5, binTree.getLeft().getContent());
  }

  /*
  right(bin(x, b, y)) = y
   */
  @Test
  public void right() {
    BinaryTree<Integer> binTree = new BinaryTree<Integer>(3, new BinaryTree<Integer>(5), new BinaryTree<Integer>(7));
    assertEquals(7, binTree.getRight().getContent());
  }

  /*
  value(bin(x, b, y)) = b
   */
  @Test
  public void value() {
    BinaryTree<Integer> binTree = new BinaryTree<Integer>(3, new BinaryTree<Integer>(5), new BinaryTree<Integer>(7));
    assertEquals(3, binTree.getContent());
  }

  /*
  is_empty(empty) = true
   */
  @Test
  public void leer_isEmpty() {
    assertTrue(new BinaryTree<Integer>().isEmpty());
  }

  /*
  is_empty(bin(x, b, y)) = false
   */
  @Test
  public void voll_isEmpty() {
    assertFalse(new BinaryTree<Integer>(3, new BinaryTree<Integer>(5), new BinaryTree<Integer>(7)).isEmpty());
  }
}