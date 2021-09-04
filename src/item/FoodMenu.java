  package item;


import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.table.DefaultTableModel;

import customer.CustomerLogin;
import customer.CustomerProfile;
import customer.Email_Storage;
import database.Datebase;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Font;


public class FoodMenu {
	static public JFrame frame;
	static private JButton backButton;// orderButton;
	private static JButton orderButton_1;
	private JButton ProfileButton ;
	static private JTextField textField;
	public static JTextField EmailUserTextField;
	static private GridBagConstraints gbc;
	private JTable table;
	DefaultTableModel dtm;
	Double[] price;
	Double[] priceDrinks;
	Double[] priceDesserts;
	double totalPrice = 0;
	double p1, p2, p3, p4, p5, p6, p7, p8, p9;
	double d1, d2, d3, d4, d5;
	double de1, de2;

	private JSpinner[] numSpinner;
	static private JLabel[] foodLabel;
	static private JLabel[] foodImage;
	private String[] file;

	int quantity;
	int rows;
	
	private JSpinner[] numSpinnerDrinks;
	static private JLabel[] drinkLabel;
	static private JLabel[] drinkImage;
	private String[] fileDrinks;

	private JSpinner[] numSpinnerDesserts;
	static private JLabel[] dessertLabel;
	static private JLabel[] dessertImage;
	private String[] fileDesserts;

	private static final int ELEMENTS = 9;
	private static final int DRINK_ELEMENTS = 5;
	private static final int DESSERT_ELEMENTS = 2;

	double total = 0;
	double food1, food2, food3, food4, food5, food6, food7, food8, food9;
	double drink1, drink2, drink3, drink4, drink5;
	double pr, pr1;

	double totalForFoods;
	double totalForDrinks;
	double totalForDesserts;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FoodMenu window = new FoodMenu();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public FoodMenu() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("Main Menu ");
		frame.setResizable(false);
		frame.setBounds(100, 100, 750, 550);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setLocationRelativeTo(null);
		JLabel lblFoodOrdered = new JLabel("Food Ordered");
		lblFoodOrdered.setBounds(529, 11, 81, 14);

		frame.getContentPane().add(lblFoodOrdered);

		table = new JTable();
		backButton = new JButton();
		//orderButton = new JButton();
		dtm = new DefaultTableModel(0, 0);
		final String header[] = new String[] { "Item", "Qty", "Price", "Spinner" };
		dtm.setColumnIdentifiers(header);
		dtm.addRow(header);
		table = new JTable();
		table.setModel(dtm);
		table.setBounds(475, 31, 1, 1); // int x, int y, int width, int height
		table.setSize(245, 300); // width,height
		table.getColumnModel().getColumn(0).setPreferredWidth(80);
		table.getColumnModel().getColumn(1).setPreferredWidth(30);
		table.getColumnModel().getColumn(2).setPreferredWidth(30);
		table.getColumnModel().getColumn(3).setMinWidth(0); // hide spinner
															// column
		table.getColumnModel().getColumn(3).setMaxWidth(0); // hide spinner
															// column
		table.setShowGrid(false); // remove cell boarder
		frame.getContentPane().add(table);
		JLabel lblTotal = new JLabel("Total  : ");
		lblTotal.setBounds(519, 340, 46, 14);
		frame.getContentPane().add(lblTotal);
		textField = new JTextField();
		textField.setBounds(585, 340, 86, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		orderButton_1 = new JButton("Order");
		orderButton_1.setBounds(500, 385, 89, 23);
		frame.getContentPane().add(orderButton_1);
		backButton = new JButton("Back");
		backButton.setBounds(610, 385, 89, 23);
		frame.getContentPane().add(backButton);
		//orderButton_1.setEnabled(false);
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		try {
			addIt(tabbedPane, "Foods");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			addIt1(tabbedPane, "Drinks");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			addIt2(tabbedPane, "Desserts");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		tabbedPane.setBounds(18, 31, 450, 430);
		frame.getContentPane().add(tabbedPane);
		
		ProfileButton = new JButton("PROFILE");
		ProfileButton.setBackground(Color.MAGENTA);
		ProfileButton.setBounds(500, 424, 199, 23);
		frame.getContentPane().add(ProfileButton);
		
		EmailUserTextField = new JTextField();
		EmailUserTextField.setEditable(false);
		EmailUserTextField.setBackground(Color.WHITE);
		EmailUserTextField.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		EmailUserTextField.setBounds(273, 7, 195, 20);
		frame.getContentPane().add(EmailUserTextField);
		EmailUserTextField.setColumns(10);
		
		JLabel UserLabel = new JLabel("  User");
		UserLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		UserLabel.setBounds(217, 10, 46, 14);
		frame.getContentPane().add(UserLabel);
		
		// add Button
		ButtonHandler handler = new ButtonHandler();
		orderButton_1 .addActionListener(handler);
		ProfileButton.addActionListener(handler);
		backButton.addActionListener(handler);
		
	}
	
	void addIt(JTabbedPane tabbedPane, String text) throws IOException {
		JPanel panel = new JPanel(new GridBagLayout());
		gbc = new GridBagConstraints(); // getting constraints for the specified
										// component
		gbc.insets = new Insets(10, 0, 0, 0);
		foodImage = new JLabel[ELEMENTS];
		foodLabel = new JLabel[ELEMENTS];
		numSpinner = new JSpinner[ELEMENTS];
		file = new String[ELEMENTS];
		price = new Double[ELEMENTS];

		file[0] = new String("/MedSalad.png");
		file[1] = new String("/JapanesePanNoodles.png");
		file[2] = new String("/spaghetti.jpg");
		file[3] = new String("/PadThai.png");
		file[4] = new String("/RamenNoodles.png");
		file[5] = new String("/kids spaghetti.png");
		file[6] = new String("/chickenRice.jpg");
		file[7] = new String("/thaiFood.jpeg");
		file[8] = new String("/vietnamFood.jpg");
		foodLabel[0] = new JLabel("Salad");
		foodLabel[1] = new JLabel("Japanese Noodles");
		foodLabel[2] = new JLabel("Spaghetti");
		foodLabel[3] = new JLabel("Spaghetti Meat Balls");
		foodLabel[4] = new JLabel("Noodles");
		foodLabel[5] = new JLabel("Kids Spaghetti");
		foodLabel[6] = new JLabel("Chicken Rice");
		foodLabel[7] = new JLabel("Thai Food");
		foodLabel[8] = new JLabel("Vietnam Food");
		price[0] = 3.50;
		price[1] = 4.50;
		price[2] = 3.70;
		price[3] = 4.50;
		price[4] = 5.50;
		price[5] = 4.00;
		price[6] = 3.50;
		price[7] = 6.50;
		price[8] = 6.50;
		for (int i = 0; i < ELEMENTS; i++) {
			Image image = ImageIO.read(this.getClass().getResource(file[i]));
			Image imageScaled = image.getScaledInstance(80, 95, Image.SCALE_SMOOTH);
			ImageIcon imageIcon = new ImageIcon(imageScaled);
			SpinnerNumberModel spnummodel = new SpinnerNumberModel(0, 0, 10, 1); // value,minimum,maximum,stepSize
			
			numSpinner[i] = new JSpinner(spnummodel);
			numSpinner[i].addChangeListener(ForFood);
			foodImage[i] = new JLabel(imageIcon);
		}
		gbc.gridx = 0; // gridx 0 represent the most left
		for (int i = 0; i < ELEMENTS; i++) {
			if (i % 3 == 0) {
				gbc.gridy += 2;
				gbc.gridx = 0;
			}
			panel.add(foodImage[i], gbc);
			gbc.gridy++; // gridy---> add one row,for foodLabel
			panel.add(foodLabel[i], gbc);
			gbc.gridy--; // remove the row
			gbc.gridx++; // move to next column
			
			
			
			
			
			
			panel.add(numSpinner[i], gbc);
			numSpinner[i].setEnabled(false); // the item frame is by default disable
			gbc.gridx++; // move to next column
			tabbedPane.addTab(text, panel);
		}
		
	
		numSpinner[0].addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				
				for (int i = 0; i < ELEMENTS; i++)
				{
					if(i==0)
					{   
						numSpinner[0].setEnabled(true);
						numSpinner[i].setValue(0);
					}
					else
					{  
						numSpinner[i].setValue(0);
						numSpinner[i].setEnabled(false);
					}
					
					
				}
				
			}
		});
		
		numSpinner[1].addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				for (int i = 0; i < ELEMENTS; i++)
				{
					if(i== 1)
					{   
						numSpinner[1].setEnabled(true);
						numSpinner[i].setValue(0);
					}
					else
					{
						numSpinner[i].setValue(0);
						numSpinner[i].setEnabled(false);
						
					}
					
					
				}
				
			}
		});
		
		numSpinner[2].addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				for (int i = 0; i < ELEMENTS; i++)
				{
					if(i==2)
					{
						numSpinner[2].setEnabled(true);
					}
					else
					{
						numSpinner[i].setValue(0);
						numSpinner[i].setEnabled(false);
					}
				}
				
			}
		});
		
		numSpinner[3].addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				for (int i = 0; i < ELEMENTS; i++)
				{
					if(i==3)
					{
						numSpinner[3].setEnabled(true);
					}
					else
					{
						numSpinner[i].setValue(0);
						numSpinner[i].setEnabled(false);
					}
				}
				
			}
		});
		
		numSpinner[4].addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				for (int i = 0; i < ELEMENTS; i++)
				{
					if(i==4)
					{
						numSpinner[4].setEnabled(true);
					}
					else
					{
						numSpinner[i].setValue(0);
						numSpinner[i].setEnabled(false);
					}
				}
				
			}
		});
		
		numSpinner[5].addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				for (int i = 0; i < ELEMENTS; i++)
				{
					if(i==5)
					{
						numSpinner[5].setEnabled(true);
					}
					else
					{
						numSpinner[i].setValue(0);
						numSpinner[i].setEnabled(false);
					}
				}
				
			}
		});
		
		numSpinner[6].addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				for (int i = 0; i < ELEMENTS; i++)
				{
					if(i==6)
					{
						numSpinner[6].setEnabled(true);
					}
					else
					{
						numSpinner[i].setValue(0);
						numSpinner[i].setEnabled(false);
					}
				}
				
			}
		});
		
		numSpinner[7].addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				for (int i = 0; i < ELEMENTS; i++)
				{
					if(i==7)
					{
						numSpinner[7].setEnabled(true);
					}
					else
					{
						numSpinner[i].setValue(0);
						numSpinner[i].setEnabled(false);
					}
				}
				
			}
		});
		
		numSpinner[8].addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				for (int i = 0; i < ELEMENTS; i++)
				{
					if(i==8)
					{
						numSpinner[8].setEnabled(true);
					}
					else
					{
						numSpinner[i].setValue(0);
						numSpinner[i].setEnabled(false);
					}
				}
				
			}
		});
		
		
		
		
	//numSpinnerDrinks	
	
			
		
		frame.setVisible(true);
		
		
	}// end of addIt method ForFood
	
	
	
	ChangeListener ForFood = new ChangeListener() {
		public void stateChanged(ChangeEvent e) {
			 quantity = (int) ((JSpinner) e.getSource()).getValue();
			 rows = table.getRowCount();
			for (int row = 0; row < rows; row++) {
				if (dtm.getValueAt(row, 3) == e.getSource()) {
					if (dtm.getValueAt(row, 0).equals("Salad")) {
						table.clearSelection();
						dtm.setValueAt(quantity, row, 1); // obj, row, column
						//System.out.println(p1*quantity+"checking"+quantity+"checking"+2);
						
						dtm.setValueAt(p1 * quantity, row, 2);
						
						//System.out.println(p1*quantity+"checking"+quantity+"checking"+2);
						food1 = p1 * quantity;

					} else if (dtm.getValueAt(row, 0).equals("Japanese Noodles")) {

						dtm.setValueAt(quantity, row, 1);
						dtm.setValueAt(p2 * quantity, row, 2);
						food2 = p2 * quantity;
					} else if (dtm.getValueAt(row, 0).equals("Spaghetti")) {

						dtm.setValueAt(quantity, row, 1);
						dtm.setValueAt(p3 * quantity, row, 2);
						food3 = p3 * quantity;
					} else if (dtm.getValueAt(row, 0).equals("Spaghetti Meat Balls")) {

						dtm.setValueAt(quantity, row, 1);
						dtm.setValueAt(p4 * quantity, row, 2);
						food4 = p4 * quantity;
					} else if (dtm.getValueAt(row, 0).equals("Noodles")) {

						dtm.setValueAt(quantity, row, 1);
						dtm.setValueAt(p5 * quantity, row, 2);  
						food5 = p5 * quantity;
					} else if (dtm.getValueAt(row, 0).equals("Kids Spaghetti")) {

						dtm.setValueAt(quantity, row, 1);
						dtm.setValueAt(p6 * quantity, row, 2);
						food6 = p6 * quantity;
					} else if (dtm.getValueAt(row, 0).equals("Chicken Rice")) {

						dtm.setValueAt(quantity, row, 1); // obj, row,
															// column
						dtm.setValueAt(p7 * quantity, row, 2);
						food7 = p7 * quantity;
					} else if (dtm.getValueAt(row, 0).equals("Thai Food")) {

						dtm.setValueAt(quantity, row, 1); // obj, row,
															// column
						dtm.setValueAt(p8 * quantity, row, 2);
						food8 = p8 * quantity;
					} else if (dtm.getValueAt(row, 0).equals("Vietnam Food")) {

						dtm.setValueAt(quantity, row, 1); // obj, row,
															// column
						dtm.setValueAt(p9 * quantity, row, 2);
						food9 = p9 * quantity;
					}

					if (quantity == 0) {
						dtm.removeRow(row);
					}
					totalForFoods = food1 + food2 + food3 + food4 + food5 + food6 + food7 + food8 + food9;
					total = totalForFoods + totalForDrinks + totalForDesserts;
					textField.setText(total + "");
					return;
				}
			}

			// there was no row with this JSpinner, so we have to add it
			for (int i = 0; i < ELEMENTS; i++) {
				// looking for the "clicked" JSpinner
				if (numSpinner[i] == e.getSource()) {
					totalPrice = price[i];
					switch (foodLabel[i].getText()) {
					case "Salad":
						p1 = 3.50;
						food1 = p1;
						break;
					case "Japanese Noodles":
						p2 = 4.50;
						food2 = p2;
						break;
					case "Spaghetti":
						p3 = 3.70;
						food3 = p3;
						break;
					case "Spaghetti Meat Balls":
						p4 = 4.50;
						food4 = p4;
						break;
					case "Noodles":
						p5 = 5.50;
						food5 = p5;
						break;
					case "Kids Spaghetti":
						p6 = 4.00;
						food6 = p6;
						break;
					case "Chicken Rice":
						p7 = 3.50;
						food7 = p7;
						break;
					case "Thai Food":
						p8 = 6.50;
						food8 = p8;
						break;
					case "Vietnam Food":
						p9 = 6.50;
						food9 = p9;
						break;
					}
					totalForFoods = food1 + food2 + food3 + food4 + food5 + food6 + food7 + food8 + food9;
					total = totalForFoods + totalForDrinks + totalForDesserts;
					textField.setText(total + "");
					dtm.addRow(new Object[] { foodLabel[i].getText(), quantity, totalPrice, numSpinner[i] });
					return;
				}

			}
		}
	}; // end of ChangeListener ForFood class
	
	
	void addIt1(JTabbedPane tabbedPane, String text) throws IOException {
		JPanel panel = new JPanel(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		drinkImage = new JLabel[DRINK_ELEMENTS];
		drinkLabel = new JLabel[DRINK_ELEMENTS];
		numSpinnerDrinks = new JSpinner[DRINK_ELEMENTS];
		priceDrinks = new Double[DRINK_ELEMENTS];

		fileDrinks = new String[DRINK_ELEMENTS];
		fileDrinks[0] = new String("/raspberry.jpg");
		fileDrinks[1] = new String("/chocalate_pudding.jpg");
		fileDrinks[2] = new String("/blue hawailan.jpg");
		fileDrinks[3] = new String("/Pina.jpg");
		fileDrinks[4] = new String("/lemon ice.jpg");

		drinkLabel[0] = new JLabel("Raspberry");
		drinkLabel[1] = new JLabel("Chocolate Pudding");
		drinkLabel[2] = new JLabel("Blue Hawailan");
		drinkLabel[3] = new JLabel("Pina");
		drinkLabel[4] = new JLabel("Lemon Ice");
        
		priceDrinks[0] = 3.50;
		priceDrinks[1] = 4.50;
		priceDrinks[2] = 3.00;
		priceDrinks[3] = 5.00;
		priceDrinks[4] = 3.00;

		for (int i = 0; i < DRINK_ELEMENTS; i++) {
			Image image = ImageIO.read(this.getClass().getResource(fileDrinks[i]));
			Image imageScaled = image.getScaledInstance(80, 95, Image.SCALE_SMOOTH);
			ImageIcon imageIcon = new ImageIcon(imageScaled);
			SpinnerNumberModel spnummodel = new SpinnerNumberModel(0, 0, 10, 1); // value,minimum,maximum,stepSize
			numSpinnerDrinks[i] = new JSpinner(spnummodel);
			numSpinnerDrinks[i].addChangeListener(listenerForDrinks);
			drinkImage[i] = new JLabel(imageIcon);
		}
		gbc.gridx = 0; // gridx 0 represent the most left
		gbc.insets = new Insets(10, 5, 0, 0); // top,left,bottom,right
		for (int i = 0; i < DRINK_ELEMENTS; i++) {
			if (i % 3 == 0) {
				gbc.gridx = 0;
				gbc.gridy += 2;
			}
			panel.add(drinkImage[i], gbc);
			gbc.gridy++; // gridy---> add one row,for foodLabel
			panel.add(drinkLabel[i], gbc);
			gbc.gridy--; // remove the row
			gbc.gridx++; // move to next column
			
			
			panel.add(numSpinnerDrinks[i], gbc);
			numSpinnerDrinks[i].setEnabled(false);
			gbc.gridx++; // move to next column
			tabbedPane.addTab(text, panel);

		}
		
		numSpinnerDrinks[0].addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				for (int i = 0; i < DRINK_ELEMENTS; i++)
				{
					if(i==0)
					{
						numSpinnerDrinks[0].setEnabled(true);
						numSpinnerDrinks[i].setValue(0);
					}
					else
					{
						numSpinnerDrinks[i].setValue(0);
						numSpinnerDrinks[i].setEnabled(false);
					}
					
					
				}
				
			}
		});
		
		numSpinnerDrinks[1].addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				orderButton_1.setEnabled(true);
				for (int i = 0; i < DRINK_ELEMENTS; i++)
				{
					if(i== 1)
					{
						numSpinnerDrinks[1].setEnabled(true);
						numSpinnerDrinks[i].setValue(0);
					}
					else
					{
						numSpinnerDrinks[i].setValue(0);
						numSpinnerDrinks[i].setEnabled(false);
						
					}
					
					
				}
				
			}
		});
		
		numSpinnerDrinks[2].addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				for (int i = 0; i < DRINK_ELEMENTS; i++)
				{
					if(i==2)
					{
						numSpinnerDrinks[2].setEnabled(true);
					}
					else
					{
						numSpinnerDrinks[i].setValue(0);
						numSpinnerDrinks[i].setEnabled(false);
					}
				}
				
			}
		});
		
		numSpinnerDrinks[3].addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				for (int i = 0; i < DRINK_ELEMENTS; i++)
				{
					if(i==3)
					{
						numSpinnerDrinks[3].setEnabled(true);
					}
					else
					{
						numSpinnerDrinks[i].setValue(0);
						numSpinnerDrinks[i].setEnabled(false);
					}
				}
				
			}
		});
		
		numSpinnerDrinks[4].addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				for (int i = 0; i < DRINK_ELEMENTS; i++)
				{
					if(i==4)
					{
						numSpinnerDrinks[4].setEnabled(true);
					}
					else
					{
						numSpinnerDrinks[i].setValue(0);
						numSpinnerDrinks[i].setEnabled(false);
					}
				}
				
			}
		});
		
	}// end of addIt1 Method (Drinks) 
	
	ChangeListener listenerForDrinks = new ChangeListener() {
		public void stateChanged(ChangeEvent e) {

			 quantity = (int) ((JSpinner) e.getSource()).getValue();
			final int rows = table.getRowCount();
			for (int row = 0; row < rows; row++) {
				if (dtm.getValueAt(row, 3) == e.getSource()) {
					if (dtm.getValueAt(row, 0).equals("Raspberry")) {
						
						dtm.setValueAt(quantity, row, 1);
						dtm.setValueAt(d1 * quantity, row, 2);     
						drink1 = d1 * quantity;

					} else if (dtm.getValueAt(row, 0).equals("Chocolate Pudding")) {
						dtm.setValueAt(quantity, row, 1); // obj, row,
															// column
						dtm.setValueAt(d2 * quantity, row, 2);          
						drink2 = d2 * quantity;

					} else if (dtm.getValueAt(row, 0).equals("Blue Hawailan")) {

						dtm.setValueAt(quantity, row, 1);
						dtm.setValueAt(d3 * quantity, row, 2);
						drink3 = d3 * quantity;

					} else if (dtm.getValueAt(row, 0).equals("Pina")) {

						dtm.setValueAt(quantity, row, 1);
						dtm.setValueAt(d4 * quantity, row, 2);
						drink4 = d4 * quantity;

					} else if (dtm.getValueAt(row, 0).equals("Lemon Ice")) {

						dtm.setValueAt(quantity, row, 1); // obj, row,
															// column
						dtm.setValueAt(d5 * quantity, row, 2);
						drink5 = d5 * quantity;

					}
					if (quantity == 0) {
						dtm.removeRow(row);
					}
					totalForDrinks = drink1 + drink2 + drink3 + drink4 + drink5;
					total = totalForFoods + totalForDrinks + totalForDesserts;
					textField.setText(total + "");

					return;
				}
			}

			// there was no row with this JSpinner, so we have to add it
			for (int i = 0; i < DRINK_ELEMENTS; i++) {
				// looking for the "clicked" JSpinner
				if (numSpinnerDrinks[i] == e.getSource()) {
					totalPrice = priceDrinks[i];
					switch (drinkLabel[i].getText()) {
					case "Raspberry":
						d1 = 3.50;
						drink1 = d1;
						break;
					case "Chocolate Pudding":
						d2 = 4.50;
						drink2 = d2;
						break;
					case "Blue Hawailan":
						d3 = 3.00;
						drink3 = d3;
						break;
					case "Pina":
						d4 = 5.00;
						drink4 = d4;
						break;
					case "Lemon Ice":
						d5 = 3.00;
						drink5 = d5;
						break;
					}
					totalForDrinks = drink1 + drink2 + drink3 + drink4 + drink5;
					total = totalForFoods + totalForDrinks + totalForDesserts;
					textField.setText(total + "");
					dtm.addRow(new Object[] { drinkLabel[i].getText(), quantity, totalPrice, numSpinnerDrinks[i] });
					return;
				}

			}

		}
	};// end of listenerForDrinks class
	
	void addIt2(JTabbedPane tabbedPane, String text) throws IOException {
		JPanel panel = new JPanel(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		dessertImage = new JLabel[DESSERT_ELEMENTS];
		dessertLabel = new JLabel[DESSERT_ELEMENTS];
		numSpinnerDesserts = new JSpinner[DESSERT_ELEMENTS];
		priceDesserts = new Double[DESSERT_ELEMENTS];

		fileDesserts = new String[DESSERT_ELEMENTS];
		fileDesserts[0] = new String("/strawberry cake.jpg");
		fileDesserts[1] = new String("/chocolate cake.jpg");

		dessertLabel[0] = new JLabel("Strawberry Cake");
		dessertLabel[1] = new JLabel("Chocolate Cake");

		priceDesserts[0] = 2.50;
		priceDesserts[1] = 3.00;

		for (int i = 0; i < DESSERT_ELEMENTS; i++) {
			Image image = ImageIO.read(this.getClass().getResource(fileDesserts[i]));
			Image imageScaled = image.getScaledInstance(80, 95, Image.SCALE_SMOOTH);
			ImageIcon imageIcon = new ImageIcon(imageScaled);
			SpinnerNumberModel spnummodel = new SpinnerNumberModel(0, 0, 10, 1); // value,minimum,maximum,stepSize
			numSpinnerDesserts[i] = new JSpinner(spnummodel);
			numSpinnerDesserts[i].addChangeListener(listenerForDesserts);
			dessertImage[i] = new JLabel(imageIcon);
		}
		gbc.gridx = 0; // gridx 0 represent the most left
		gbc.insets = new Insets(10, 5, 0, 0); // top,left,bottom,right
		for (int i = 0; i < DESSERT_ELEMENTS; i++) {
			if (i % 3 == 0) {
				gbc.gridx = 0;
				gbc.gridy += 2;
			}
			panel.add(dessertImage[i], gbc);
			gbc.gridy++; // gridy---> add one row,for foodLabel
			panel.add(dessertLabel[i], gbc);
			gbc.gridy--; // remove the row
			gbc.gridx++; // move to next column
			
			
			panel.add(numSpinnerDesserts[i], gbc);
			numSpinnerDesserts[i].setEnabled(false);
			gbc.gridx++; // move to next column
			tabbedPane.addTab(text, panel);
		}
		
		numSpinnerDesserts[0].addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				for (int i = 0; i < DESSERT_ELEMENTS; i++)
				{
					if(i==0)
					{
						numSpinnerDesserts[0].setEnabled(true);
						numSpinnerDesserts[i].setValue(0);
					}
					else
					{
						numSpinnerDesserts[i].setValue(0);
						numSpinnerDesserts[i].setEnabled(false);
					}
					
					
				}
				
			}
		});
		
		numSpinnerDesserts[1].addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				orderButton_1.setEnabled(true);
				for (int i = 0; i < DESSERT_ELEMENTS; i++)
				{
					if(i== 1)
					{
						numSpinnerDesserts[1].setEnabled(true);
						numSpinnerDesserts[i].setValue(0);
					}
					else
					{
						numSpinnerDesserts[i].setValue(0);
						numSpinnerDesserts[i].setEnabled(false);
						
					}
					
					
				}
				
			}
		});
		

	}// end of addIt2 method for Dessert
	
	ChangeListener listenerForDesserts = new ChangeListener() {
		public void stateChanged(ChangeEvent e) {

			 quantity = (int) ((JSpinner) e.getSource()).getValue();
			final int rows = table.getRowCount();

			for (int row = 0; row < rows; row++) {
				if (dtm.getValueAt(row, 3) == e.getSource()) {
					if (dtm.getValueAt(row, 0).equals("Strawberry Cake")) {
						dtm.setValueAt(quantity, row, 1); // obj, row,
						pr = de1 * quantity; // column
						dtm.setValueAt(de1 * quantity, row, 2);
					} else if (dtm.getValueAt(row, 0).equals("Chocolate Cake")) {
						dtm.setValueAt(quantity, row, 1); // obj, row, // column
						dtm.setValueAt(de2 * quantity, row, 2);
						pr1 = de2 * quantity;
					}
					if (quantity == 0) {
						dtm.removeRow(row);
					}
					totalForDesserts = pr + pr1;
					total = totalForFoods + totalForDrinks + totalForDesserts;
					textField.setText(total + "");
					return;
				}
			}

			// there was no row with this JSpinner, so we have to add it
			for (int i = 0; i < DESSERT_ELEMENTS; i++) {
				// looking for the "clicked" JSpinner
				if (numSpinnerDesserts[i] == e.getSource()) {
					totalPrice = priceDesserts[i];
					switch (dessertLabel[i].getText()) {
					case "Strawberry Cake":
						de1 = 2.50;
						pr = de1;
						break;
					case "Chocolate Cake":
						de2 = 3.00;
						pr1 = de2;
						break;
					}
					totalForDesserts = pr + pr1;
					total = totalForFoods + totalForDrinks + totalForDesserts;
					textField.setText(total + "");
					dtm.addRow(new Object[] { dessertLabel[i].getText(), quantity, totalPrice, numSpinnerDesserts[i] });
					return;
				}

			}
		}

	};// end of listenerForDesserts class
	
	
	  private class ButtonHandler implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent event) {
			
			
			Datebase data = new Datebase();
			
		//	Email_Storage[] email_Session = new Email_Storage[1];
			//Email_Storage storage;
			
		    String Statuts = "received";
			
			CustomerLogin t= new CustomerLogin();
			String email_Stored = EmailUserTextField.getText();
           
		 
			if(event.getSource()==orderButton_1)
			{ 
		        
				if(email_Stored.length()<=0)
				{
					JOptionPane.showMessageDialog(null, "Please Login First");
				}
				
				
				else
				{
	
				
				rows = table.getRowCount();
				                                       
				for (int row = 0; row < rows; row++) {
				if (dtm.getValueAt(row, 0).equals("Salad")) {
					
					System.out.println(p1*quantity+"\tQTY"+quantity+"\tSalad");
					try {
						
						
						data.orders(email_Stored, "Salad", quantity, p1, Statuts, p1*quantity);
						JOptionPane.showMessageDialog(null, "Order Received successfully\nTrack the statuts in your profile");
					} 
					catch (SQLException e) 
					{
						JOptionPane.showMessageDialog(null, "Sorry Unexpectated Error\n Try again!!");
						e.printStackTrace();
					}
				}
                 
				else if (dtm.getValueAt(row, 0).equals("Japanese Noodles")) {
					System.out.println(p2*quantity+"\tQTY"+quantity+"\tJapanese Noodles");
					try {
						data.orders(email_Stored, "Japanese Noodles",quantity,p2, Statuts, p2*quantity);
						JOptionPane.showMessageDialog(null, "Order Received successfully\nTrack the statuts in your profile");
					} catch (SQLException e) {
						JOptionPane.showMessageDialog(null, "Sorry Unexpectated Error\n Try again!!");
						e.printStackTrace();
					}
					
				}
				
				else if (dtm.getValueAt(row, 0).equals("Spaghetti")) {
					System.out.println(p3*quantity+"\tQTY"+quantity+"\tSpaghetti");
					try {
						data.orders(email_Stored, "Spaghetti", quantity, p3, Statuts, p3*quantity);
						JOptionPane.showMessageDialog(null, "Order Received successfully\nTrack the statuts in your profile");
					} catch (SQLException e) {
						JOptionPane.showMessageDialog(null, "Sorry Unexpectated Error\n Try again!!");
						e.printStackTrace();
					}
				}
				         
				else if (dtm.getValueAt(row, 0).equals("Spaghetti Meat Balls")) {
					System.out.println(p4*quantity+"\tQTY"+quantity+"\tSpaghetti Meat Balls");
					try {
						data.orders(email_Stored, "Spaghetti Meat Balls", quantity, p4, Statuts, p4*quantity);
						JOptionPane.showMessageDialog(null, "Order Received successfully\nTrack the statuts in your profile");
					} catch (SQLException e) {
						JOptionPane.showMessageDialog(null, "Sorry Unexpectated Error\n Try again!!");
						e.printStackTrace();
					}
				}
				 
				else if (dtm.getValueAt(row, 0).equals("Noodles")) {
					System.out.println(p5*quantity+"\tQTY"+quantity+"\tNoodles");
					try {
						data.orders(email_Stored, "Noodles", quantity, p5, Statuts, p5*quantity);
						JOptionPane.showMessageDialog(null, "Order Received successfully\nTrack the statuts in your profile");
					} catch (SQLException e) {
						JOptionPane.showMessageDialog(null, "Sorry Unexpectated Error\n Try again!!");
						e.printStackTrace();
					}
				}
				
				else if (dtm.getValueAt(row, 0).equals("Kids Spaghetti")) {
					System.out.println(p6*quantity+"\tQTY"+quantity+"\tKids Spaghetti");
					try {
						data.orders(email_Stored, "Kids Spaghetti", quantity, p6, Statuts, p6*quantity);
						JOptionPane.showMessageDialog(null, "Order Received successfully\nTrack the statuts in your profile");
					} catch (SQLException e) {
						JOptionPane.showMessageDialog(null, "Sorry Unexpectated Error\n Try again!!");
						e.printStackTrace();
					}
				}
				
				else if (dtm.getValueAt(row, 0).equals("Chicken Rice")) {
					System.out.println(p7*quantity+"\tQTY"+quantity+"\tChicken Rice");
					try {
						data.orders(email_Stored, "Chicken Rice", quantity, p7, Statuts, p7*quantity);
						JOptionPane.showMessageDialog(null, "Order Received successfully\nTrack the statuts in your profile");
					} catch (SQLException e) {
						JOptionPane.showMessageDialog(null, "Sorry Unexpectated Error\n Try again!!");
						e.printStackTrace();
					}
				}
				
				else if (dtm.getValueAt(row, 0).equals("Thai Food")) {
					System.out.println(p8*quantity+"\tQTY"+quantity+"\tThai Food");
					try {
						data.orders(email_Stored, "Thai Food", quantity, p8, Statuts, p8*quantity);
						JOptionPane.showMessageDialog(null, "Order Received successfully\nTrack the statuts in your profile");
					} catch (SQLException e) {
						JOptionPane.showMessageDialog(null, "Sorry Unexpectated Error\n Try again!!");
						e.printStackTrace();
					}
				}
				
				else if (dtm.getValueAt(row, 0).equals("Vietnam Food")) {
					System.out.println(p9*quantity+"\tQTY"+quantity+"\tVietnam Food");
					try {
						data.orders(email_Stored, "Vietnam Food", quantity, p9, Statuts, p9*quantity);
						JOptionPane.showMessageDialog(null, "Order Received successfully\nTrack the statuts in your profile");
					} catch (SQLException e) {
						JOptionPane.showMessageDialog(null, "Sorry Unexpectated Error\n Try again!!");
						e.printStackTrace();
					}
				}
/*********************************** else if statement of Drinks price quantity items************************************************************/
				
				else if (dtm.getValueAt(row, 0).equals("Raspberry")) {
					System.out.println(d1*quantity+"\tQTY"+quantity+"\tRaspberry");
					try {
						data.orders(email_Stored, "Raspberry", quantity, d1, Statuts, d1*quantity);
						JOptionPane.showMessageDialog(null, "Order Received successfully\nTrack the statuts in your profile");
					} catch (SQLException e) {
						JOptionPane.showMessageDialog(null, "Sorry Unexpectated Error\n Try again!!");
						e.printStackTrace();
					}
				}
				
				else if (dtm.getValueAt(row, 0).equals("Chocolate Pudding")) {
					System.out.println(d2*quantity+"\tQTY"+quantity+"\tChocolate Pudding");
					try {
						data.orders(email_Stored, "Chocolate Pudding", quantity, d2, Statuts, d2*quantity);
						JOptionPane.showMessageDialog(null, "Order Received successfully\nTrack the statuts in your profile");
					} catch (SQLException e) {
						JOptionPane.showMessageDialog(null, "Sorry Unexpectated Error\n Try again!!");
						e.printStackTrace();
					}
				}
				
				else if (dtm.getValueAt(row, 0).equals("Blue Hawailan")) {
					System.out.println(d3*quantity+"\tQTY"+quantity+"\tBlue Hawailan");
					try {
						data.orders(email_Stored, "Blue Hawailan", quantity, d3, Statuts, d3*quantity);
						JOptionPane.showMessageDialog(null, "Order Received successfully\nTrack the statuts in your profile");
					} catch (SQLException e) {
						JOptionPane.showMessageDialog(null, "Sorry Unexpectated Error\n Try again!!");
						e.printStackTrace();
					}
				}
				
				else if (dtm.getValueAt(row, 0).equals("Pina")) {
					System.out.println(d4*quantity+"\tQTY"+quantity+"\tPina");
					try {
						data.orders(email_Stored, "Pina", quantity, d4, Statuts, d4*quantity);
						JOptionPane.showMessageDialog(null, "Order Received successfully\nTrack the statuts in your profile");
					} catch (SQLException e) {
						JOptionPane.showMessageDialog(null, "Sorry Unexpectated Error\n Try again!!");
						e.printStackTrace();
					}
				}
				
				else if (dtm.getValueAt(row, 0).equals("Lemon Ice")) {
					System.out.println(d5*quantity+"\tQTY"+quantity+"\tLemon Ice");
					try {
						data.orders(email_Stored, "Lemon Ice", quantity, d5, Statuts, d5*quantity);
						JOptionPane.showMessageDialog(null, "Order Received successfully\nTrack the statuts in your profile");
					} catch (SQLException e) {
						JOptionPane.showMessageDialog(null, "Sorry Unexpectated Error\n Try again!!");
						e.printStackTrace();
					}
				}
/********************************** else if statement for dessert*******************************************************************************/				
				
				

				else if (dtm.getValueAt(row, 0).equals("Strawberry Cake")) {
					System.out.println(de1*quantity+"\tQTY"+quantity+"\tStrawberry Cake");
					try {
						data.orders(email_Stored, "Strawberry Cake", quantity, de1, Statuts, de1*quantity);
						JOptionPane.showMessageDialog(null, "Order Received successfully\nTrack the statuts in your profile");
					} catch (SQLException e) {
						JOptionPane.showMessageDialog(null, "Sorry Unexpectated Error\n Try again!!");
						e.printStackTrace();
					}
				}
				
				else if (dtm.getValueAt(row, 0).equals("Chocolate Cake")) {
					System.out.println(de2*quantity+"\tQTY"+quantity+"\tChocolate Cake");
					try {
						data.orders(email_Stored, "Chocolate Cake", quantity, de2, Statuts, de2*quantity);
						JOptionPane.showMessageDialog(null, "Order Received successfully\nTrack the statuts in your profile");
					} catch (SQLException e) {
						JOptionPane.showMessageDialog(null, "Sorry Unexpectated Error\n Try again!!");
						e.printStackTrace();
					}
				}
				
				
				
				/*else {
				System.out.println(p2*quantity+"\tQTY"+quantity+"\trow"+2);
				System.out.println(p3*quantity+"\tQTY"+quantity+"\trow"+2);
				System.out.println(p4*quantity+"\tQTY"+quantity+"\trow"+2);*/
				}
				
				
				
				
			} // end of the else orderbutton
	
		}// end of else statement for checking if the EmailTextfield is not empty!!!		
		
			else if(event.getSource()==ProfileButton)
			{
				if(email_Stored.length()<=0)
				{
					JOptionPane.showMessageDialog(null, "Please Login First");
				}
				else
				{
				
				CustomerProfile window = new CustomerProfile();
				CustomerProfile.emailCustomerprofiletextField_1.setText(email_Stored);
				window.frame.setVisible(true);
				
				
				
			}// end of else statement for ProfileButton
			
			}// end of else if of ProfileButton
			
			else if(event.getSource()==backButton)
			{
				
					frame.setVisible(false);
					CustomerLogin window = new CustomerLogin();
					window.frmWelcomeToOur.setVisible(true);
					
				} 
				
				
			
			
		}// end of actionPerformed method 
		  
		  
		  
		  
	  }//end of inner class ButtonHandler
}
