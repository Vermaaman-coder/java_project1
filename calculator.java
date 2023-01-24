import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class calculator implements ActionListener
{
    JFrame frame;
    JTextField tf;
    JButton[] numberButtons=new JButton[10];
    JButton[] functionButtons=new JButton[8];
    JButton ab,sb,mb,db,decButton,equButton,delButton,clrButton,negButton;
    JPanel panel;

    Font myFont = new Font("Ink Free",Font.BOLD,30);

    double num1=0,num2=0,result=0;
    char operator;

    calculator()
    {
        frame =new JFrame("Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420,550);
        frame.setLayout(null);

        tf=new JTextField();
        tf.setBounds(50,25,300,50);
        tf.setEditable(false);
        tf.setFont(myFont);

        ab=new JButton("+");
        sb=new JButton("-");
        mb=new JButton("*");
        db=new JButton("/");
        decButton=new JButton(".");
        equButton=new JButton("=");
        delButton=new JButton("Delete");
        clrButton=new JButton("Clear");

        functionButtons[0]=ab;
        functionButtons[1]=sb;
        functionButtons[2]=mb;
        functionButtons[3]=db;
        functionButtons[4]=decButton;
        functionButtons[5]=equButton;
        functionButtons[6]=delButton;
        functionButtons[7]=clrButton;

        for(int i=0;i<8;i++)
        {
            functionButtons[i].addActionListener(this);
            functionButtons[i].setFocusable(false);
        }

        for(int i=0;i<10;i++)
        {
            numberButtons[i]=new JButton(String.valueOf(i));
            numberButtons[i].addActionListener(this);
            numberButtons[i].setFocusable(false);
        }

        delButton.setBounds(50,430,145,50);
        clrButton.setBounds(205,430,145,50);

        panel=new JPanel();
        panel.setBounds(50,100,300,300);
        panel.setLayout(new GridLayout(4,4,10,10));
        // panel.setBackground(Color.BLACK);
        panel.add(numberButtons[1]);
        panel.add(numberButtons[2]);
        panel.add(numberButtons[3]);
        panel.add(ab);
        panel.add(numberButtons[4]);
        panel.add(numberButtons[5]);
        panel.add(numberButtons[6]);
        panel.add(sb);
        panel.add(numberButtons[7]);
        panel.add(numberButtons[8]);
        panel.add(numberButtons[9]);
        panel.add(mb);
        panel.add(decButton);
        panel.add(numberButtons[0]);
        panel.add(equButton);
        panel.add(delButton);
        panel.add(db);

        

        frame.add(tf);
        frame.add(delButton);
        frame.add(clrButton);
        frame.add(panel);
        frame.setVisible(true);
    }
    public static void main(String args[])
    {
        calculator cal=new calculator();
    }

   
    /* (non-Javadoc)
     * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
     */
    public void actionPerformed(ActionEvent e)
    {
        for(int i=0;i<10;i++)
        {
            if(e.getSource()==numberButtons[i])
            {
                tf.setText(tf.getText().concat(String.valueOf(i)));
            }
        }

        if(e.getSource()==decButton)
        {
            tf.setText(tf.getText().concat("."));
        }

        if(e.getSource()==ab)
        {
            num1=Double.parseDouble(tf.getText());
            operator='+';
            tf.setText("");
        }

        if(e.getSource()==sb)
        {
            num1=Double.parseDouble(tf.getText());
            operator='-';
            tf.setText("");
        }

        if(e.getSource()==mb)
        {
            num1=Double.parseDouble(tf.getText());
            operator='*';
            tf.setText("");
        }

        if(e.getSource()==db)
        {
            num1=Double.parseDouble(tf.getText());
            operator='/';
            tf.setText("");
        }

        if(e.getSource()==equButton)
        {
            num2=Double.parseDouble(tf.getText());

            switch(operator)
            {
                case'+' :
                result=num1+num2;
                break;

                case'-' :
                result=num1-num2;
                break;

                case'*' :
                result=num1*num2;
                break;

                case'/' :
                result=num1/num2;
                break;
            }
            tf.setText(String.valueOf(result));
            num1=result;
        }

        if(e.getSource()==clrButton)
        {
            tf.setText("");
        }

        if(e.getSource()==delButton)
        {
            String string=tf.getText();
            tf.setText("");
            for(int i=0;i<string.length()-1;i++)
            {
                tf.setText(tf.getText()+string.charAt(i));
            }
        }
    }
}