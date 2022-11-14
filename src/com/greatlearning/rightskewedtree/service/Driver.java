package com.greatlearning.rightskewedtree.service;

import java.util.ArrayList;

public class Driver {

	public static Node node;
	Node root = null;
	Node new_node = null;
	static ArrayList<Integer> nodeList = new ArrayList<Integer>();

	// Use inorder traversal to get BST nodes in increasing order.
	static void traverse(Node root) {
		if (root != null) {
			traverse(root.left);
			nodeList.add(root.val);
			traverse(root.right);
		}
	}

	// Create the right skewed BT using nodelist
	public void createRightSkewedBT(ArrayList<Integer> nodeList) {
		for (int i = 0; i < nodeList.size(); i++) {
			int node_data = nodeList.get(i);
			new_node = new Node(node_data);
			if (root == null) {
				root = new_node;
			} else {
				insert(root, new_node);
			}
			System.out.print(new_node.val + " ");
		}		
	}

	// Function for inserting the node
	public void insert(Node root, Node nn) {		
		if (root.right == null) {
			root.right = nn;
			root.left = null;
		} else {
			insert(root.right, nn);
		}		
	}

	public static void main(String[] args) {
		Driver driver = new Driver();
		Driver.node = new Node(50);
		Driver.node.left = new Node(30);
		Driver.node.right = new Node(60);
		Driver.node.left.left = new Node(10);
		Driver.node.right.left = new Node(55);

		traverse(node);
		driver.createRightSkewedBT(nodeList);
	}

}
