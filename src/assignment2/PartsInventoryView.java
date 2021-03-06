package assignment2;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Toolkit;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

@SuppressWarnings("serial")
public class PartsInventoryView extends JFrame {	
	private PartsInventoryModel model;

	private JPanel inventoryFrame, inventoryUIPanel, inventoryListPanel; // layers 1, 2, 3
	private JButton addPart, deletePart, viewPart;
	private JButton headingName, headingNumber, headingVendor, headingQuantity;
	private JList<Part> inventory;
	private DefaultListModel<Part> list;
	private int GUIWidth;
	private int GUIHeight;
	private Color offWhite = new Color(232, 232, 232);
	private JScrollPane inventoryScroll;

	public PartsInventoryView(PartsInventoryModel model) {
		super("Cabinetron");
		this.model = model;

		GUIWidth = 400;
		GUIHeight = 500;

		this.setSize(GUIWidth, GUIHeight);
		this.setLocation((Toolkit.getDefaultToolkit().getScreenSize().width / 2) - (GUIWidth / 2), (Toolkit.getDefaultToolkit().getScreenSize().height / 2) - (GUIHeight / 2));
		this.setVisible(true);
		
		
		// Sets up the inventory frame 
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		inventoryFrame = new JPanel();
		inventoryFrame.setSize(GUIWidth, GUIHeight);
		inventoryFrame.setBackground(Color.LIGHT_GRAY);
		inventoryFrame.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(inventoryFrame);
		inventoryFrame.setLayout(null);
		
		// Creates and adds the "add" button to the inventory frame
		addPart = new JButton("Add");
		addPart.setBounds(15, 410, 70, 30);
		inventoryFrame.add(addPart);
		
		// Creates and adds the "delete" button to the inventory frame
		deletePart = new JButton("Delete");
		deletePart.setBounds(105, 410, 70, 30);
		inventoryFrame.add(deletePart);
		
		// Creates and adds the "view" button to the inventory frame
		viewPart = new JButton("View");
		viewPart.setBounds(295, 410, 70, 30);
		inventoryFrame.add(viewPart);
		
		// Creates the panel to hold the parts within the inventory frame
		inventoryListPanel = new JPanel();
		inventoryListPanel.setBackground(Color.WHITE);
		inventoryListPanel.setBounds(15, 15, inventoryFrame.getWidth() - 45, inventoryFrame.getHeight() - 150);
		inventoryListPanel.setLayout(null);
		
		headingName = new JButton("Part Name");
		headingName.setBackground(offWhite);
		headingName.setBounds(0, 0, inventoryListPanel.getWidth() / 4, 25);
		headingName.setFocusPainted(false);
		inventoryListPanel.add(headingName);
		
		headingNumber = new JButton("Part #");
		headingNumber.setBackground(offWhite);
		headingNumber.setBounds((inventoryListPanel.getWidth() / 4), 0, inventoryListPanel.getWidth() / 4, 25);
		headingNumber.setFocusPainted(false);
		inventoryListPanel.add(headingNumber);
		
		headingVendor = new JButton("Vendor");
		headingVendor.setBackground(offWhite);
		headingVendor.setBounds((inventoryListPanel.getWidth() / 4) * 2, 0, inventoryListPanel.getWidth() / 4, 25);
		headingVendor.setFocusPainted(false);
		inventoryListPanel.add(headingVendor);
		
		headingQuantity = new JButton("Quantity");
		headingQuantity.setBackground(offWhite);
		headingQuantity.setBounds((inventoryListPanel.getWidth() / 4) * 3, 0, inventoryListPanel.getWidth() / 4, 25);
		headingQuantity.setFocusPainted(false);
		inventoryListPanel.add(headingQuantity);
		
		
		// Creates the panel to hold the parts within the inventory frame
	//	inventoryListPanel.setBounds(15, 15, inventoryFrame.getWidth() - 45, inventoryFrame.getHeight() - 150);
		//inventoryFrame.add(inventoryListPanel);

		list = new DefaultListModel<Part>();
		for (Part p : model.getInventory()) {
			list.addElement(p);
		}

		inventory = new JList<Part>(list);
		inventory.setBackground(Color.WHITE);
		inventory.setBounds(0, 32, inventoryListPanel.getWidth(), inventoryListPanel.getHeight());
		inventoryListPanel.add(inventory);

		
		// Creates the scroll pane to navigate a large inventory in the inventory panel
		//inventoryArea = new JTextArea();
		//inventoryArea.setEditable(false);
		inventoryScroll = new JScrollPane(inventoryListPanel);
		inventoryScroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		inventoryScroll.setBounds(5, 0, 345, 345);
		inventoryFrame.add(inventoryScroll);
		//inventoryListPanel.addMouseListener(l);
		//inventoryArea.append("test");
		
		repaint();
	}
	
	public void updatePanel() {
		list.removeAllElements();
		
		for (Part p : model.getInventory()) {
			list.addElement(p);
		}
		inventory.removeAll();
		inventory.setModel(list);
		inventory.setBackground(Color.WHITE);
		inventory.setBounds(0, 32, inventoryListPanel.getWidth(), inventoryListPanel.getHeight());
		inventoryListPanel.remove(inventory);
		inventoryListPanel.add(inventory);
	}

	
	public void register(PartsInventoryController controller) {
		addPart.addActionListener(controller);
		deletePart.addActionListener(controller);
		viewPart.addActionListener(controller);
		headingName.addActionListener(controller);
		headingNumber.addActionListener(controller);
		headingVendor.addActionListener(controller);
		headingQuantity.addActionListener(controller);
		inventory.addListSelectionListener(controller);
	}
	
	public int getWidth() {
		return GUIWidth;
	}
	
	public int getHeight() {
		return GUIHeight;
	}
}
