package assignment2;

import java.io.IOException;

public class Tester {
	private static PartsInventoryView partsInventoryView;
	private static PartsInventoryController partsInventoryController;
	private static PartsInventoryModel partsInventoryModel;
	
	public static void main(String args[]) {
		partsInventoryModel = new PartsInventoryModel();
	
		try {
			Part p;
			p = new Part(24, "Bauer Jacks", "Bauer-24", "CTS");
			partsInventoryModel.addPart(p);
			
			p = new Part(1, "Apple Jacks", "Mills-YUM", "General Mills");
			partsInventoryModel.addPart(p);
			
			p = new Part(4, "Homework Do@Home Kit", "D@H-HK1", "");
			partsInventoryModel.addPart(p);
			
			p = new Part(24, "Zebra Stripes", "GUM-10101", "CTS");
			partsInventoryModel.addPart(p);
			
			p = new Part(24, "101 Vaults", "Vault 101", "Fallout Technologies");
			partsInventoryModel.addPart(p);
			
			p = new Part(24, "Bauer Jacks1", "Bauer-24", "CTS");
			partsInventoryModel.addPart(p);
			
			p = new Part(1, "Apple Jacks1", "Mills-YUM", "General Mills");
			partsInventoryModel.addPart(p);
			
			p = new Part(4, "Homework Do@Home Kit1", "D@H-HK1", "");
			partsInventoryModel.addPart(p);
			
			p = new Part(24, "Zebra Stripes1", "GUM-10101", "CTS");
			partsInventoryModel.addPart(p);
			
			p = new Part(24, "101 Vaults1", "Vault 101", "Fallout Technologies");
			partsInventoryModel.addPart(p);
			
			p = new Part(24, "Bauer Jacks2", "Bauer-24", "CTS");
			partsInventoryModel.addPart(p);
			
			p = new Part(1, "Apple Jacks2", "Mills-YUM", "General Mills");
			partsInventoryModel.addPart(p);
			
			p = new Part(4, "Homework Do@Home Kit2", "D@H-HK1", "");
			partsInventoryModel.addPart(p);
			
			p = new Part(24, "Zebra Stripes2", "GUM-10101", "CTS");
			partsInventoryModel.addPart(p);
			
			p = new Part(24, "101 Vaults2", "Vault 101", "Fallout Technologies");
			partsInventoryModel.addPart(p);
			
			p = new Part(24, "Bauer Jacks3", "Bauer-24", "CTS");
			partsInventoryModel.addPart(p);
			
			p = new Part(1, "Apple Jacks3", "Mills-YUM", "General Mills");
			partsInventoryModel.addPart(p);
			
			p = new Part(4, "Homework Do@Home Kit3", "D@H-HK1", "");
			partsInventoryModel.addPart(p);
			
			p = new Part(24, "Zebra Stripes3", "GUM-10101", "CTS");
			partsInventoryModel.addPart(p);
			
			p = new Part(24, "101 Vaults3", "Vault 101", "Fallout Technologies");
			partsInventoryModel.addPart(p);
		}
		catch (IOException e) {
			e.printStackTrace();
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		
		partsInventoryView = new PartsInventoryView(partsInventoryModel);
		
		partsInventoryController = new PartsInventoryController(partsInventoryModel, partsInventoryView);
			
		partsInventoryView.register(partsInventoryController);
		
		
		
	}
}
