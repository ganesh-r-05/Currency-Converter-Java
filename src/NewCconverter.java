import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.*;
public class NewCconverter extends JFrame implements ActionListener{
    JComboBox fromcountry,tocountry;
    JButton convert,reset,exit;
    JLabel fromunit,tounit;
    TextField fromtext;
    TextField Answer;

    String[] currencyUnits=
            {
                    "units",
                    "Indian Rupee",
                    "Pakistani Rupee",
                    "US Dollar",
                    "Canadian Dollar",
                    "Kenyan Shilling",
                    "Nigerian Naira",
                    "Brazilian Real",
                    "Indonesian Rupiah",
                    "Philippine_Pisco",
            };

    double Indian_Rupee = 82.73;
    double Pakistani_Rupee = 225.62;
    double US_Dollar = 1;
    double Canadian_Dollar = 1.37;
    double Kenyan_Shilling = 123.45;
    double Nigerian_Naira = 445.98;
    double Brazilian_Real = 5.31;
    double Indonesian_Rupiah = 15615.95;
    double Philippine_Pisco = 55.53;

    NewCconverter()
    {
        setBounds(300,60,790,700);
        getContentPane().setBackground(Color.LIGHT_GRAY);

        JLabel maintitle = new JLabel("Currency Converter");
        maintitle.setBounds(150,30,650,60);
        maintitle.setFont(new Font("Rockwell",Font.BOLD,50));
        maintitle.setForeground(Color.BLACK);
        add(maintitle);

        JLabel from = new JLabel("From");
        from.setBounds(10,160,50,50);
        from.setFont(new Font("Rockwell",Font.BOLD,18));
        from.setForeground(Color.black);
        add(from);

        fromcountry = new JComboBox(new String[] { "Select One..", "India", "Pakistan", "USA", "Canada", "Kenyan", "Ngeria", "Brazil", "Indonesia", "Philippine" });
        fromcountry.setBounds(100,165,200,40);
        fromcountry.setFont(new Font("Rockwell",Font.BOLD,20));
        //fromcountry.setForeground(Color.white);
        fromcountry.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent evt) {
                fromcountryItemStateChanged(evt);
            }
        });
        add(fromcountry);

        fromtext = new TextField();
        fromtext.setBounds(350,165,250, 40);
        fromtext.setFont(new Font("Rockwell",Font.BOLD,20));
        fromtext.setForeground(Color.BLACK);
        add(fromtext);

        fromunit = new JLabel("Unit");
        fromunit.setBounds(655,185,200,40);
        fromunit.setFont(new Font("Rockwell",Font.BOLD,15));
        fromunit.setForeground(Color.BLACK);
        add(fromunit);

        JLabel to = new JLabel("To");
        to.setBounds(10,310,50,50);
        to.setFont(new Font("Rockwell",Font.BOLD,20));
        to.setForeground(Color.black);
        add(to);

        tocountry = new JComboBox(new String[] { "Select One..", "India", "Pakistan", "USA", "Canada", "Kenyan", "Ngeria", "Brazil", "Indonesia", "Philippine" });
        tocountry.setBounds(100,310,200,40);
        tocountry.setFont(new Font("Rockwell",Font.BOLD,20));
        //tocountry.setForeground(Color.white);
        tocountry.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent evt) {
                tocountryItemStateChanged(evt);
            }
        });
        add(tocountry);

        Answer = new TextField(" ");
        Answer.setBounds(350,310,250, 40);
        Answer.setFont(new Font("Rockwell",Font.BOLD,20));
        Answer.setForeground(Color.BLACK);
        add(Answer);

        tounit = new JLabel("Unit");
        tounit.setBounds(655,290,250,90);
        tounit.setFont(new Font("Rockwell",Font.BOLD,15));
        tounit.setForeground(Color.BLACK);
        add(tounit);

        convert = new JButton("Convert Currency");
        convert.setBounds(100,450,200,40);
        convert.setFont(new Font("Rockwell",Font.BOLD,15));
        convert.addActionListener(this);
        add(convert);


        reset = new JButton("Reset");
        reset.setBounds(450,450,200,40);
        reset.setFont(new Font("Rockwell",Font.BOLD,15));
        reset.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        add(reset);

        exit = new JButton("Exit");
        exit.setBounds(300,550,100,40);
        exit.setFont(new Font("Rockwell",Font.BOLD,15));
        exit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        add(exit);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    private void jButton3ActionPerformed(ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        //reset panel
        fromcountry.setSelectedIndex(0);
        tocountry.setSelectedIndex(0);
        fromtext.setText(null);
        Answer.setText(null);
    }

    private void jButton4ActionPerformed(ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        //to Exit
        System.exit(0);
    }

    public static void main(String[] args)
    {
        new NewCconverter();
    }


    private void fromcountryItemStateChanged(ItemEvent evt) {//GEN-FIRST:event_fromcountryItemStateChanged
        //units
        int position = fromcountry.getSelectedIndex();
        fromunit.setText(currencyUnits[position]);
    }

    private void tocountryItemStateChanged(ItemEvent evt) {//GEN-FIRST:event_tocountryItemStateChanged
        //units
        int position = tocountry.getSelectedIndex();
        tounit.setText(currencyUnits[position]);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == convert) {
            if (fromcountry.getSelectedIndex() == 0 || tocountry.getSelectedIndex() == 0 || fromtext.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Invalid Input", "Getting Error", JOptionPane.ERROR_MESSAGE);

            } else {
                double amountToChange = Double.parseDouble(fromtext.getText());
                double amountInPounds = 0.0;
                //From Ammout change into pounds
                switch (fromcountry.getSelectedItem().toString()) {
                    case "India":
                        amountInPounds = amountToChange / Indian_Rupee;
                        break;
                    case "Pakistan":
                        amountInPounds = amountToChange / Pakistani_Rupee;
                        break;
                    case "USA":
                        amountInPounds = amountToChange / US_Dollar;
                        break;
                    case "Canada":
                        amountInPounds = amountToChange / Canadian_Dollar;
                        break;
                    case "Kenyan":
                        amountInPounds = amountToChange / Kenyan_Shilling;
                        break;
                    case "Ngeria":
                        amountInPounds = amountToChange / Nigerian_Naira;
                        break;
                    case "Brazil":
                        amountInPounds = amountToChange / Brazilian_Real;
                        break;
                    case "Indonesia":
                        amountInPounds = amountToChange / Indonesian_Rupiah;
                        break;
                    case "Philippine":
                        amountInPounds = amountToChange / Philippine_Pisco;
                        break;
                    default:
                        amountInPounds = 0.0;
                }
                double newamount = 0.0;
                switch (tocountry.getSelectedItem().toString()) {
                    case "India":
                        newamount = amountInPounds * Indian_Rupee;
                        break;
                    case "Pakistan":
                        newamount = amountInPounds * Pakistani_Rupee;
                        break;
                    case "USA":
                        newamount = amountInPounds * US_Dollar;
                        break;
                    case "Canada":
                        newamount = amountInPounds * Canadian_Dollar;
                        break;
                    case "Kenyan":
                        newamount = amountInPounds * Kenyan_Shilling;
                        break;
                    case "Ngeria":
                        newamount = amountInPounds * Nigerian_Naira;
                        break;
                    case "Brazil":
                        newamount = amountInPounds * Brazilian_Real;
                        break;
                    case "Indonesia":
                        newamount = amountInPounds * Indonesian_Rupiah;
                        break;
                    case "Philippine":
                        newamount = amountInPounds * Philippine_Pisco;
                        break;
                    default:
                        newamount = amountInPounds = 0.0;
                }
                String amount = String.format("%.2f", newamount);
                Answer.setText(amount);
            }
        }
    }
}