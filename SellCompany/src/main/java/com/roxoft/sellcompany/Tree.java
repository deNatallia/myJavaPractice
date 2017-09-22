package com.roxoft.sellcompany;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.roxoft.sellcompany.threads.MyDeadlock;

public class Tree {
	private final static Logger log = LogManager.getLogger(MyDeadlock.class);
	private Node root;

	public Tree() {
		root = null;
	}

	public void addItem(double value) {
		Node newNode = new Node();
		newNode.setValue(value);
		if (root == null)
			root = newNode;
		else {
			Node current = root;
			Node parent;
			while (current != null) {
				parent = current;
				if (value < current.getValue()) {
					current = current.getLeftChild();
					if (current == null) {
						parent.setLeftChild(newNode);
						return;
					}
				} else {
					current = current.getRightChild();
					if (current == null) {
						parent.setRightChild(newNode);
						return;
					}
				}
			}
		}
	}

	private Node minimum(Node x) {
		if (x.getLeftChild() == null) {
			return x;
		}
		return minimum(x.getLeftChild());
	}

	public void delItemx(double value) {
		delNode(root, value);
	}

	private Node delNode(Node root, double value) {
		if (root == null) {
			return root;
		}
		if (value < root.getValue()) {
			root.setLeftChild(delNode(root.getLeftChild(), value));
		} else if (value > root.getValue()) {
			root.setRightChild(delNode(root.getRightChild(), value));
		} else if (root.getLeftChild() != null && root.getRightChild() != null) {
			root.setValue(minimum(root.getRightChild()).getValue());
			root.setRightChild(delNode(root.getRightChild(), root.getValue()));
		} else {
			if (root.getLeftChild() != null) {
				root = root.getLeftChild();
			} else {
				root = root.getRightChild();
			}
		}
		return root;
	}

	public boolean delItem(double value) {
		Node current = root;
		Node parent = root;
		boolean isLeftChild = true;
		while (current.getValue() != value) {
			parent = current;
			if (value < current.getValue()) {
				isLeftChild = true;
				current = current.getLeftChild();
			} else {
				isLeftChild = false;
				current = current.getRightChild();
			}
			if (current == null) {
				return false;
			}
		}

		if (current.getLeftChild() == null && current.getRightChild() == null) {
			if (current == root) {
				root = null;
			} else if (isLeftChild) {
				parent.setLeftChild(null);
			} else {
				parent.setRightChild(null);
			}
		}

		else if (current.getRightChild() == null) {
			if (current == root) {
				root = current.getLeftChild();
			} else if (isLeftChild) {
				parent.setLeftChild(current.getLeftChild());
			} else {
				parent.setRightChild(current.getLeftChild());
			}
		} else if (current.getLeftChild() == null) {
			if (current == root) {
				root = current.getRightChild();
			} else if (isLeftChild) {
				parent.setLeftChild(current.getRightChild());
			} else {
				parent.setRightChild(current.getRightChild());
			}
		} else {
			Node inheritor = getInheritor(current);

			if (current == root) {
				root = inheritor;
			} else if (isLeftChild) {
				parent.setLeftChild(inheritor);
			} else {
				parent.setRightChild(inheritor);
			}
			inheritor.setLeftChild(current.getLeftChild());
		}

		return true;
	}

	private Node getInheritor(Node delNode) {
		Node inheritorParent = delNode;
		Node inheritor = delNode;
		Node current = delNode.getRightChild();
		while (current != null) {
			inheritorParent = inheritor;
			inheritor = current;
			current = current.getLeftChild();
		}

		if (inheritor != delNode.getRightChild()) {
			inheritorParent.setLeftChild(inheritor.getRightChild());
			inheritor.setRightChild(delNode.getRightChild());
		}
		return inheritor;
	}

	void printNode(Node x) {
		if (x != null) {
			printNode(x.getLeftChild());
			log.info(x.getValue() + " ");
			printNode(x.getRightChild());
		}
	}

	public void printTree() {
		printNode(root);
	}

}
