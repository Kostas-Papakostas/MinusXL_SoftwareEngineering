package minusxlgui;
 
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
 
import net.miginfocom.swing.MigLayout;
 
    public class CreateChartDialog{
     
        private JDialog dialog;
        private JTextField title;
        private JTextField titleX;
        private JTextField titleY;
        private JLabel titleXLabel;
 
     
         
     
    public CreateChartDialog (String title, JFrame frame){
        dialog = new JDialog(frame, title, true);
        dialog.setTitle("Function Dialog");
        dialog.setDefaultCloseOperation(JDialog.HIDE_ON_CLOSE);   
        dialog.setMinimumSize(new Dimension(400, 200));
        init();
    }
     
    public void setVisible(Boolean flag){
        dialog.setVisible(flag);
    }
     
    public static String  getInput(String title, JFrame frame){
        CreateChartDialog input = new CreateChartDialog (title, frame);
        input.setVisible(true);
        String a = input.title.getText() +"/"+ input.titleX.getText()+"/"+ input.titleY.getText()+"/";
        return a;       
    }
     
    private void init(){
        JLabel titleLabel = new JLabel("Title");
        dialog.getContentPane().setLayout(new MigLayout("", "[92px][][92px][][92px][92px]", "[30px][][][][2.00px][30.00][-25.00][][][][][][][][][40px][][]"));
     
        dialog.getContentPane().add(titleLabel, "cell 0 0,grow");
         
            title = new JTextField(5);
            dialog.getContentPane().add(title, "cell 2 0 3 1,grow");
            titleXLabel = new JLabel("Title of X");
            dialog.getContentPane().add(titleXLabel, "cell 0 5,growx");
            titleXLabel.setLabelFor(titleX);
            titleX = new JTextField(5);
            dialog.getContentPane().add(titleX, "flowy,cell 2 5 3 1,grow");
            JButton okButton = new JButton("OK");
            okButton.addActionListener(new ActionListener(){
     
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        dialog.dispose();
                    }
     
            });
            JLabel titleYLabel = new JLabel("Title of Y");
            dialog.getContentPane().add(titleYLabel, "cell 0 9 2 1,grow");
            titleY = new JTextField(5);
            dialog.getContentPane().add(titleY, "cell 2 9 3 1,grow");
            dialog.getContentPane().add(okButton, "cell 2 15 2 1,grow");
        dialog.pack();     
    }
     
    public static void main(String args []){
        String s = getInput("Dialog",null);
        System.out.println(s);
    }
     
}