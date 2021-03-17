package com.revature;

import java.util.Scanner;

import com.revature.pojo.FamilyTree;
import com.revature.pojo.Person;

public class Driver {
	
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		FamilyTree tree = new FamilyTree();
		
		System.out.println("Welcome to your Family Tree!");
		System.out.println("  1. Add Person");
		System.out.println("  2. Search by Name");
		System.out.println("  3. Update Relationship");
		System.out.println("  4. Delete Person");
		System.out.println("  5. View Tree");
		System.out.println("  0. Exit");

		String input;
		
		do {
			
			while (!scan.hasNext()) {
				System.out.println("["+scan.next() + "] Try again");
			}
			
			input = scan.nextLine();
			
			switch (input) {
			case "1":
				System.out.println("  Parent: ");
				String parent = scan.nextLine();
				System.out.println("  Child Name: ");
				try {
					Person child = tree.addChild(parent, scan.nextLine());
					System.out.println("  " + child.getName() + " is now child of " + parent);
				} catch (Exception e) {
					System.out.println("  Parent not found in Family Tree");
				}
				break;
			case "2":
				break;
			case "3":
				break;
			case "4":
				System.out.println("  Person to Delete : ");
				if (tree.removeChild(scan.nextLine())) {
					System.out.println("  Branch successfully severed from tree");
				} else {
					System.out.println("  Error deleting Person");
				}
				break;
			case "5":
				tree.printTree(tree.getFamilyTreeRoot(), " ");
				break;
//			case "0":
//				break;
			default:
				break;	
			}
			
		} while (input != "0");
		
		
		System.out.println("Goodbye!");
		
	}

}
