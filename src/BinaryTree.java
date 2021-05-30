/**
 * Generic class for BinaryTree.
 *
 * @param <ContentType> Class which is stored in the BinaryTree
 */
public class BinaryTree<ContentType> {


  ContentType basis;
  BinaryTree<ContentType> left;
  BinaryTree<ContentType> right;

  /**
   * Constructor for BinaryTree.
   *
   * @param pbasis Content
   * @param pleft  left tree
   * @param pright right tree
   */
  public BinaryTree(ContentType pbasis, BinaryTree<ContentType> pleft, BinaryTree<ContentType> pright) {
    basis = pbasis;
    left = pleft;
    right = pright;
  }

  public BinaryTree() {
  }

  public BinaryTree(ContentType pBasis) {
    basis = pBasis;
  }

  /**
   * Removes this content from the tree and moves other content up.
   */
  public void delete() {
    right.leftInsert(left);
    basis = right.getContent();
    right = right.getRight();
    left = right.getLeft();
  }


  public BinaryTree<ContentType> getLeft() {
    return left;
  }

  public BinaryTree<ContentType> getRight() {
    return right;
  }

  public ContentType getContent() {
    return basis;
  }

  public void setContent(ContentType pInhalt) {
    basis = pInhalt;
  }

  public void setLeft(BinaryTree<ContentType> pLeft) {
    left = pLeft;
  }

  public void setRight(BinaryTree<ContentType> pRight) {
    right = pRight;
  }

  public boolean isEmpty() {
    return basis == null;
  }

  /**
   * Puts paramter tree at the left most free location.
   * Used when deleting a higher tree to move the lower trees accordingly
   *
   * @param pfuegEin tree which will be inserted
   */
  private void leftInsert(BinaryTree<ContentType> pfuegEin) {
    if (left.isEmpty()) {
      left = pfuegEin;
    } else {
      left.leftInsert(pfuegEin);
    }
  }
}
