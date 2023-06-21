package GUI;

import comp_decomp.Compressor;
import comp_decomp.Decompressor;

import javax.swing.*;
import javax.swing.JFrame;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class AppFrame extends JFrame implements ActionListener {
    JButton compressedButton;
    JButton decompressedButton;
    AppFrame()
    {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        compressedButton=new JButton("Select file to compress");
        compressedButton.setBounds(20,100,200,30);
        compressedButton.addActionListener(this);
        decompressedButton=new JButton("Select file to decompress");
        decompressedButton.setBounds(50,100,200,30);
        decompressedButton.addActionListener(this);
        this.add(compressedButton);
        this.add(decompressedButton);
        this.setVisible(true);
        this.setSize(1000,500);
        this.getContentPane().setBackground(Color.green);
    }
    @Override
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource()==compressedButton)
        {
            JFileChooser fileChooser = new JFileChooser();
            int response = fileChooser.showSaveDialog(null);
            if(response==JFileChooser.APPROVE_OPTION) {
                File file = new File(fileChooser.getSelectedFile().getAbsolutePath());
                System.out.print(file);
                try {
                    Compressor.method(file);
                } catch (Exception ee) {
                    JOptionPane.showMessageDialog(null, ee.toString());
                }

            }
        }
        if(e.getSource()==decompressedButton)
        {
            JFileChooser fileChooser = new JFileChooser();
            int response = fileChooser.showSaveDialog(null);
            if(response==JFileChooser.APPROVE_OPTION) {
                File file = new File(fileChooser.getSelectedFile().getAbsolutePath());
                System.out.print(file);
                try {
                    Decompressor.method(file);
                } catch (Exception ee) {
                    JOptionPane.showMessageDialog(null, ee.toString());
                }

            }
        }

    }
}

