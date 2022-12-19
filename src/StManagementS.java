import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.PrinterException;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class StManagementS {
    private JPanel mainPanel;
    private JTextField textFieldname;
    private JTextField textFieldFname;
    private JTextField textFieldRoll;
    private JTextField textFieldEid;
    private JTextField textFieldNo;
    private JTextArea textAddress;
    private JTextField textFieldMark;
    private JRadioButton maleRadioButton;
    private JRadioButton femaleRadioButton;
    private JComboBox comboBox10;
    private JComboBox comboBox12;
    private JTextArea textReceipt;
    private JButton generateReceiptButton;
    private JButton printButton;
    private JButton resetButton;
    private JList listFee;
    private JList listFeeHost;
    private JButton showButton;
    private JRadioButton SLABSRadioButton;
    private JRadioButton SEASRadioButton;
    private JRadioButton HOSTELLERRadioButton;
    private JComboBox comboBoxBranch;
    private JRadioButton DAYSCHOLARRadioButton;
    private JTextField textFieldNat;
    public String school;
    public String fee;
    public String room;
    public String gender;
    public String routine;
    public String branch;
    public int total;

public StManagementS() {
    generateReceiptButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            File file=new File("Fee Receipt.txt");
            try {
                FileWriter writer=new FileWriter("Fee Receipt.txt");
                writer.write(textReceipt.getText());
                writer.close();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
            JOptionPane.showMessageDialog(mainPanel,"receipt generated","Fee",1);
        }
    });
    resetButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            textReceipt.setText("");
        }
    });
    printButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                textReceipt.print();
            } catch (PrinterException ex) {
                throw new RuntimeException(ex);
            }
        }
    });
    showButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            fee=(String)listFee.getSelectedValue();
            room=(String)listFeeHost.getSelectedValue();
            if(listFeeHost.getSelectedIndex()==1){
                total=250000+150000;
            }
            else if(listFeeHost.getSelectedIndex()==2){
                total=250000+140000;
            }else
                total=250000+120000;


            textReceipt.setText("-----------------Fee Receipt---------------"+"\n"+
                    "Student Name: "+textFieldname.getText()+"\n"+
                            "Student Father Name: "+textFieldFname.getText()+"\n"+
                                    "RollNumber: "+textFieldRoll.getText()+"\n"+
                                        "Email ID: "+textFieldEid.getText()+"\n"+
                    "Contact Number: "+textFieldNo.getText()+"\n"+
                    "passed 10th in: "+comboBox10.getSelectedItem()+"\n"+
                    "passed 10th in: "+comboBox12.getSelectedItem()+"\n"+
                    "Want to take: "+branch+"\n"+
                    school+"\n"+
                    "Want to be a "+routine+"\n"+
                    "Had choosen: "+fee+"\n"+
                    "Had choosen: "+room+"\n"+
                    "             Total amount to be paid is "+total+" Lakhs");


        }
    });
    comboBoxBranch.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            branch=(String)comboBoxBranch.getSelectedItem();

        }
    });


    maleRadioButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            gender="Male";
        }
    });
    femaleRadioButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            gender="Female";
        }
    });
    SEASRadioButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            school="School of Engineeing and ";
        }
    });
    SLABSRadioButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            school="School of Law Engineeing and A";
        }
    });
    HOSTELLERRadioButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            routine="Hosteller";
        }
    });
    DAYSCHOLARRadioButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            routine="Day Scholar";
        }
    });

}

    public static void main(String[] args) {
        JFrame frame = new JFrame("Student Details");
        frame.setContentPane(new StManagementS().mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
