package cs319;

import javax.swing.tree.DefaultMutableTreeNode;

public class AnimalsTree extends DefaultMutableTreeNode {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	AnimalsTree() {
		super("Animals");
		
		DefaultMutableTreeNode mammals = new DefaultMutableTreeNode("Mammals");
		mammals.add(new DefaultMutableTreeNode("Human"));
		mammals.add(new DefaultMutableTreeNode("Kangaroo"));
		mammals.add(new DefaultMutableTreeNode("Elephant"));
		mammals.add(new DefaultMutableTreeNode("Goat"));
		add(mammals);
		
		DefaultMutableTreeNode reptiles = new DefaultMutableTreeNode("Reptiles");
		reptiles.add(new DefaultMutableTreeNode("Lizard"));
		reptiles.add(new DefaultMutableTreeNode("Boa"));
		reptiles.add(new DefaultMutableTreeNode("Iguana"));
		add(reptiles);
		
		DefaultMutableTreeNode birds = new DefaultMutableTreeNode("Birds");
		birds.add(new DefaultMutableTreeNode("Duck"));
		birds.add(new DefaultMutableTreeNode("Pigeon"));
		birds.add(new DefaultMutableTreeNode("Turkey"));
		birds.add(new DefaultMutableTreeNode("Goose"));
		add(birds);
		
		DefaultMutableTreeNode insects = new DefaultMutableTreeNode("Insects");
		insects.add(new DefaultMutableTreeNode("Termite"));
		insects.add(new DefaultMutableTreeNode("Ladybug"));
		insects.add(new DefaultMutableTreeNode("Fly"));
		insects.add(new DefaultMutableTreeNode("Ant"));
		add(insects);
		
		DefaultMutableTreeNode fish = new DefaultMutableTreeNode("Fish");
		fish.add(new DefaultMutableTreeNode("Sword Fish"));
		fish.add(new DefaultMutableTreeNode("Shark"));
		fish.add(new DefaultMutableTreeNode("Eel"));
		add(fish);
	}
	
}
