package ui;

import java.awt.BorderLayout;
import java.awt.Color; 

import javax.swing.*;

import encode.Encoder;
import files.FileUtils;

public class FileDisplay extends JFrame {

	private JPanel dataPanel;
	private JPanel controlPanel;	
	private JMenuBar menu;

	JMenuItem openFile;
	JMenuItem saveFile;
	JMenuItem exitItem;

	private JComboBox<String> dropdown;
	private JTextArea textArea;

    public FileDisplay() {

		createMenu();
        createControlPanel();
        createDataPanel();

		setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

    }

	private void createMenu() {
		menu = new JMenuBar();     
		menu.add(createFileMenu());
		menu.setForeground(Color.GREEN); 
		setJMenuBar(menu);
	}

	private JMenu createFileMenu(){

		JMenu menu = new JMenu("File");

		openFile = new JMenuItem("Open File");
		saveFile = new JMenuItem("Save File");
		exitItem = new JMenuItem("Exit");

		openFile.addActionListener(e -> load(System.getProperty("user.dir")));
		saveFile.addActionListener(e -> {
			try {
				save(System.getProperty("user.dir"));
			} catch (Throwable e1) {
				e1.printStackTrace();
			}
		});
		exitItem.addActionListener(e -> System.exit(0));
		
		menu.add(openFile);
		menu.add(saveFile);
		menu.add(exitItem);
		
		return menu;

	}
	
    private void createControlPanel() {

        controlPanel = new JPanel();

        controlPanel.add(new JLabel("Encoding Method:"));
        controlPanel.add(createEncodingDropdownPanel());

        JButton encodeButton = new JButton("Encode");
        encodeButton.addActionListener(e -> encodeText());
        
		controlPanel.add(encodeButton);

        add(controlPanel, BorderLayout.NORTH);

    }

    private JPanel createEncodingDropdownPanel() {

    	dropdown = new JComboBox<>();
		dropdown.addItem("ROT13");
		dropdown.addItem("Numeric");
        dropdown.setEditable(false);

        JPanel panel = new JPanel();
        panel.add(dropdown);
        return panel;

    }
    
    private void encodeText() {
        String encodedText = Encoder.encode(textArea.getText(), (String) dropdown.getSelectedItem());
        textArea.setText(encodedText);
    }

	private void createDataPanel() {

		dataPanel = new JPanel();
		textArea = new JTextArea(20, 40);
		
		textArea.setEditable(false);
		JScrollPane scrollPane = new JScrollPane(textArea);

		dataPanel.add(scrollPane);
		
		add(dataPanel, BorderLayout.CENTER); 
		
	}

	private void save(String dir) {
		JFileChooser j = new JFileChooser(dir);
		int round = j.showSaveDialog(this);

		if (round == JFileChooser.APPROVE_OPTION) {
			String fileName = j.getSelectedFile().getAbsolutePath();
			String data = textArea.getText();
			FileUtils.saveFile(fileName, data);
		}
	}

	private void load(String dir) {
		JFileChooser jFileChooser = new JFileChooser(dir);
		int round = jFileChooser.showOpenDialog(this);

		if (round == JFileChooser.APPROVE_OPTION){

			String fileName = jFileChooser.getSelectedFile().getAbsolutePath();
			String data = FileUtils.readFile(fileName);
			textArea.setText(data);

		}
	}

	public static void main(String[] args) {
		try{
			JFrame fileDisplay = new FileDisplay();
			fileDisplay.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		} catch (Throwable e) {
			System.out.println("Error: " + e.getMessage());
		}

	}
}
