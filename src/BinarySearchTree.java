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

  /**
   * removes this element and moves other elements up.
   * order stays intact
   */
  public void delete() {
    /**
     * switch
     * no child
     * one child
     * two children
     */
    int numberOfChildren = 0;
    if (! (left == null) && ! (left.isEmpty())) {
      numberOfChildren++;
    }
    if (! (right == null) && ! (right.isEmpty())) {
      numberOfChildren++;
    }
    switch (numberOfChildren) {
      case 0:
        basis = null;
        break;
      case 1:
        if (! (left == null) && ! (left.isEmpty())) {
          //rechts ist leer
          basis = left.getContent();
          left = left.getLeft();
          right = left.getRight();
        } else {
          //links ist leer
          basis = right.getContent();
          right = right.getRight();
          left = right.getLeft();
        }
        break;
      case 2:
        basis = right.furthestLeft();
        break;
    }


  }

  /**
   * inserts pInhalt at the correct spot.
   * works with recursion
   *
   * @param pInhalt which will be inserted
   */
  public void insert(ContentType pInhalt) {
    if (this.isEmpty()) {
      basis = pInhalt;
      return;
    }

    if (pInhalt.isGreater(basis)) {
      if (right == null) {
        right = new BinarySearchTree<ContentType>();
      }
      right.insert(pInhalt);
      return;
    }

    if (pInhalt.isLess(basis)) {
      if (left == null) {
        left = new BinarySearchTree<ContentType>();
      }
      left.insert(pInhalt);
      return;
    }

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

  private ContentType furthestLeft() {
    if (left == null | left.isEmpty()) {
      ContentType rueckgabe = basis;
      //rechten teil hochziehen / loeschen
      if (right == null | right.isEmpty()) {
        basis = null;

      } else {
        basis = right.getContent();
        right = right.getRight();
        left = right.getLeft();
      }
      return rueckgabe;
    } else {
      return left.furthestLeft();
    }
  }

  /**
   * removes pRemove from tree or children trees.
   * nothing happens if premove not in tree
   * works with recursion
   *
   * @param pRemove content which will be removed
   */
  public void remove(ContentType pRemove) {
    if (this.isEmpty()) {
      return;
    }
    if (basis == null) {
      return;
    }
    if (pRemove.isEqual(basis)) {
      delete();
      return;
    }
    if (pRemove.isGreater(basis)) {
      if (right == null) {
        return;
      }
      right.remove(pRemove);
      return;
    }
    if (pRemove.isLess(basis)) {
      if (left == null) {
        return;
      }
      left.remove(pRemove);
      return;
    }
  }

  /**
   * Returns boolean wether pInhalt is in Tree.
   *
   * @param pInhalt which will be searched
   * @return wether pInhalt is in the BinarySearchTree
   */
  public boolean contains(ContentType pInhalt) {
    return ! (search(pInhalt) == null);
  }

  /**
   * Searches for ContentType which isEqual() with pInhalt.
   *
   * @param pInhalt test object which will be searched for
   * @return object in tree which is searched
   */
  public ContentType search(ContentType pInhalt) {
    if (basis == null) {
      return null;
    }
    if (this.isEmpty()) {
      return null;
    }
    if (basis.isEqual(pInhalt)) {
      return basis;
    }
    if (pInhalt.isGreater(basis)) {
      if (right == null) {
        return null;
      }
      return right.search(pInhalt);

    }
    if (pInhalt.isLess(basis)) {
      if (left == null) {
        return null;
      }
      return left.search(pInhalt);

    }

    return null;
  }
}
