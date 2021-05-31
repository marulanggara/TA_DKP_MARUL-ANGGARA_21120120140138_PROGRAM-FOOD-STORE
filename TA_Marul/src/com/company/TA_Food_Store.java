package com.company;

import javax.swing.*;
import java.awt.event.*;

public class TA_Food_Store {
    private JPanel panelFood;
    private JTextField textSaldo;
    private JButton masukButton;
    private JTextField textNama;
    private JComboBox comboPesanan;
    private JTextField textJumlah;
    private JTextField textHarga;
    private JTextField textTotal;
    private JButton cetakButton;
    private JButton resetButton;
    private JTextArea textStruk;
    private JButton pesanButton;
    private JButton simpanButton1;
    private JTextArea textMenu;
    private JButton hitungButton;
    private JPasswordField passwordPin;
    private JLabel labelEnama;
    private JLabel labelEjumlah;


    public static void main(String[] args) {
        JFrame frame=new JFrame("FOOD STORE");
        frame.setContentPane(new TA_Food_Store().panelFood);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
    public TA_Food_Store() {
        masukButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(passwordPin.getText().equals("12345")){
                    textSaldo.setText("500000");
                }else if (passwordPin.getText().equals("")){
                    JOptionPane.showMessageDialog(null, "PIN masih kosong!!!");
                }else {
                    JOptionPane.showMessageDialog(null, "PIN salah!!");
                }
            }
        });
        comboPesanan.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String pesanan=comboPesanan.getSelectedItem().toString();
                if (comboPesanan.getSelectedItem()=="-Pilih-"){
                    textHarga.setText(null);
                }else if (comboPesanan.getSelectedItem()=="Paket Rekomendasi"){
                    textHarga.setText("20000");
                }else if (comboPesanan.getSelectedItem()=="Paket Gandul"){
                    textHarga.setText("17500");
                }else if (comboPesanan.getSelectedItem()=="Paket Soto Kemiri"){
                    textHarga.setText("12000");
                }else {
                    textHarga.setText("15000");
                }
            }
        });

        resetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                passwordPin.setText("");
                textSaldo.setText("");
                textNama.setText("");
                textJumlah.setText("");
                textTotal.setText("");
                textStruk.setText("");
                labelEnama.setText("");
                labelEjumlah.setText("");
            }
        });
        cetakButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (textSaldo.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Saldo anda kosong!!!");
                } else if (textNama.getText().equals("") || textTotal.getText().equals("") || textJumlah.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Lengkapi Pesanan Dahulu!!!");
                }else {
                    int h= Integer.parseInt(textHarga.getText());
                    int j= Integer.parseInt(textJumlah.getText());
                    int s= Integer.parseInt(textSaldo.getText());
                    int t=h*j;
                    int sisa= s-t;
                    if (s<t){
                        JOptionPane.showMessageDialog(null, "Saldo Anda Kurang!!!");
                    }else {
                        textStruk.setText("-------Food Store-------\n\nStruk Pembayaran\n\n"+" Atas Nama : "+textNama.getText()+ "\n Pesanan : "+comboPesanan.getSelectedItem()+ "\n Jumlah : "+textJumlah.getText()+ "\n Total Harga : "+textTotal.getText()+ "\n Sisa Saldo : "+sisa+"\n\n\nNote : simpan struk pembayaran sebagai bukti transaksi\n-------Terimakasih-------");
                    }
                }
            }
        });
        pesanButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (textStruk.getText().equals("")){
                    JOptionPane.showMessageDialog(null, "Silahkan Lakukan Pemesanan Terlebih Dahulu!!!");
                }else {
                    JOptionPane.showMessageDialog(null, "Pemesanan Berhasil");
                }
            }
        });
        simpanButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (textStruk.getText().equals("")){
                    JOptionPane.showMessageDialog(null, "Error");
                }else {
                    JOptionPane.showMessageDialog(null, "Berhasil Menyimpan");
                }
            }
        });
        hitungButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (comboPesanan.getSelectedItem()=="-Pilih-" || textJumlah.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Lengkapi Pesanan Anda!!!");
                }else{
                    int h= Integer.parseInt(textHarga.getText());
                    int j= Integer.parseInt(textJumlah.getText());
                    int total=h * j;
                    textTotal.setText(String.valueOf(total));
                }

            }
        });
        textNama.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent name) {
                super.keyPressed(name);
                char nama= name.getKeyChar();
                if (Character.isLetter(nama) || Character.isWhitespace(nama) || Character.isISOControl(nama)) {
                    textNama.setEditable(true);
                    labelEnama.setText("");
                }else {
                    textNama.setEditable(false);
                    labelEnama.setText("*Nama tidak boleh angka");
                }
            }
        });
        textJumlah.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent jum) {
                super.keyPressed(jum);
                char jumlah= jum.getKeyChar();
                if (Character.isLetter(jumlah)) {
                    textJumlah.setEditable(false);
                    labelEjumlah.setText("*Jumlah harus angka");
                }else if (Character.isWhitespace(jumlah)){
                    textTotal.setText("");
                }else {
                    textJumlah.setEditable(true);
                }
            }
        });
    }
}
