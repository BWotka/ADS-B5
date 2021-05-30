/**
 * Generic BinaryTree which is sorted.
 * Can be used to store and search information in log(N)
 *
 * @param <ContentType> Stored information of this datatype has to be comparable
 */
public class BinarySearchTree<ContentType extends Vergleichbar<ContentType>> {


  ContentType basis;
  BinarySearchTree<ContentType> left;
  BinarySearchTree<ContentType> right;

  public BinarySearchTree(ContentType pBasis) {
    basis = pBasis;
  }

  public BinarySearchTree() {
  }

  public void delete() {
    right.leftInsert(left);
    basis = right.getContent();
    right = right.getRight();
    left = right.getLeft();
  }

  public void insert(ContentType pInhalt) {
    if (this.isEmpty()) {
      basis = pInhalt;
      return;
    }
    if (pInhalt.isGreater(basis)) {
      right.insert(pInhalt);
      return;
    }
    if (pInhalt.isLess(basis)) {
      left.insert(pInhalt);
      return;
    }

  }

  public ContentType search(ContentType pSuch) {
    return null;
  }

  public BinarySearchTree<ContentType> getLeft() {
    return left;
  }

  public BinarySearchTree<ContentType> getRight() {
    return right;
  }

  public boolean isEmpty() {
    return basis == null;
  }

  public ContentType getContent() {
    return basis;
  }

  private void leftInsert(BinarySearchTree<ContentType> pfuegEin) {
    if (left.isEmpty()) {
      left = pfuegEin;
    } else {
      left.leftInsert(pfuegEin);
    }
  }

  public void remove(ContentType pRemove) {
    if (this.isEmpty()) {
      return;
    }
    if (pRemove.isEqual(basis)) {
      delete();
    }
    if (pRemove.isGreater(basis)) {
      right.remove(pRemove);
      return;
    }
    if (pRemove.isLess(basis)) {
      left.remove(pRemove);
      return;
    }
  }
}
