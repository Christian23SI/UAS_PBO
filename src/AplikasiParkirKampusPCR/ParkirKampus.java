package AplikasiParkirKampusPCR;  

import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Queue;
import javax.swing.JTextArea;

public class ParkirKampus extends JFrame {

    private JPanel contentPane; 
    private JTextField textFieldNomorPolisi;
    private JComboBox comboBoxJenisKendaraan;
    private JTextField textFieldWarnaKendaraan;
    private JTextField textFieldJamMasuk;
    private JTextField textFieldJamKeluar;
    private JTextField textFieldDepan;
    private JTextField textFieldBelakang;
    private JTextField textFieldAmbilData;
    private JTextArea textAreaOutput;

    private Queue<String> queueParkir = new LinkedList<>();

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    ParkirKampus frame = new ParkirKampus();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public ParkirKampus() {
       setTitle("Aplikasi Parkir Kampus PCR");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 350);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblNomorPolisi = new JLabel("Nomor Polisi : ");
        lblNomorPolisi.setBounds(10, 11, 99, 14);
        contentPane.add(lblNomorPolisi);

        textFieldNomorPolisi = new JTextField();
        textFieldNomorPolisi.setBounds(119, 8, 158, 20);
        contentPane.add(textFieldNomorPolisi);
        textFieldNomorPolisi.setColumns(10);

        JLabel lblJenisKendaraan = new JLabel("Jenis : ");
        lblJenisKendaraan.setBounds(10, 36, 99, 14);
        contentPane.add(lblJenisKendaraan);

        comboBoxJenisKendaraan = new JComboBox();
        comboBoxJenisKendaraan.setModel(new DefaultComboBoxModel(new String[] {"Roda Dua", "Roda Empat"}));
        comboBoxJenisKendaraan.setBounds(119, 33, 158, 20);
        contentPane.add(comboBoxJenisKendaraan);

        JLabel lblWarnaKendaraan = new JLabel("Warna : ");
        lblWarnaKendaraan.setBounds(10, 61, 99, 14);
        contentPane.add(lblWarnaKendaraan);

        textFieldWarnaKendaraan = new JTextField();
        textFieldWarnaKendaraan.setBounds(119, 58, 158, 20);
        contentPane.add(textFieldWarnaKendaraan);
        textFieldWarnaKendaraan.setColumns(10);

        JLabel lblJamMasuk = new JLabel("Jam Masuk : ");
        lblJamMasuk.setBounds(10, 86, 99, 14);
        contentPane.add(lblJamMasuk);

        textFieldJamMasuk = new JTextField();
        textFieldJamMasuk.setBounds(119, 83, 158, 20);
        contentPane.add(textFieldJamMasuk);
        textFieldJamMasuk.setColumns(10);

        JLabel lblJamKeluar = new JLabel("Jam Keluar : ");
        lblJamKeluar.setBounds(10, 111, 99, 14);
        contentPane.add(lblJamKeluar);

        textFieldJamKeluar = new JTextField();
        textFieldJamKeluar.setBounds(119, 108, 158, 20);
        contentPane.add(textFieldJamKeluar);
        textFieldJamKeluar.setColumns(10);

        JLabel lblDepan = new JLabel("Depan");
        lblDepan.setBounds(10, 148, 46, 14);
        contentPane.add(lblDepan);

        JLabel lblBelakang = new JLabel("Belakang");
        lblBelakang.setBounds(119, 148, 64, 14);
        contentPane.add(lblBelakang);

        textFieldDepan = new JTextField();
        textFieldDepan.setBounds(10, 166, 100, 20);
        contentPane.add(textFieldDepan);
        textFieldDepan.setColumns(10);

        textFieldBelakang = new JTextField();
        textFieldBelakang.setBounds(119, 166,100, 20);
        contentPane.add(textFieldBelakang);
        textFieldBelakang.setColumns(10);

        JButton btnCreateQueue = new JButton("Create Queue");
        btnCreateQueue.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                queueParkir = new LinkedList<>();
                textAreaOutput.setText("");
                textFieldDepan.setText("");
                textFieldBelakang.setText("");
            }
        });
        btnCreateQueue.setBounds(299, 11, 122, 23);
        contentPane.add(btnCreateQueue);

        JButton btnEnqueue = new JButton("Enqueue");
        btnEnqueue.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String data = textFieldNomorPolisi.getText() + " " + 
                        comboBoxJenisKendaraan.getSelectedItem() + " " +
                        textFieldWarnaKendaraan.getText() + " " +
                        textFieldJamMasuk.getText() + " " +
                        textFieldJamKeluar.getText();
                queueParkir.add(data);
                updateOutput();
                textFieldNomorPolisi.setText("");
                comboBoxJenisKendaraan.setSelectedIndex(0);
                textFieldWarnaKendaraan.setText("");
                textFieldJamMasuk.setText("");
                textFieldJamKeluar.setText("");
            }
        });
        btnEnqueue.setBounds(299, 46, 122, 23);
        contentPane.add(btnEnqueue);

        JButton btnDequeue = new JButton("Dequeue");
        btnDequeue.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (!queueParkir.isEmpty()) {
                    queueParkir.poll();
                    updateOutput();
                }
            }
        });
        btnDequeue.setBounds(299, 81, 122, 23);
        contentPane.add(btnDequeue);

        JButton btnSelesai = new JButton("Selesai");
        btnSelesai.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (!queueParkir.isEmpty()) {
                    textFieldAmbilData.setText(queueParkir.peek());
                } else {
                    textFieldAmbilData.setText("");
                }
            }
        });
        btnSelesai.setBounds(299, 116, 122, 23);
        contentPane.add(btnSelesai);

        JLabel lblAmbilData = new JLabel("Ambil Data");
        lblAmbilData.setBounds(299, 151, 76, 14);
        contentPane.add(lblAmbilData);

        textFieldAmbilData = new JTextField();
        textFieldAmbilData.setBounds(299, 169, 122, 20);
        contentPane.add(textFieldAmbilData);
        textFieldAmbilData.setColumns(10);

        JLabel lblOutput = new JLabel("Output");
        lblOutput.setBounds(10, 201, 46, 14);
        contentPane.add(lblOutput);

        textAreaOutput = new JTextArea();
        textAreaOutput.setBounds(10, 219, 411, 100);
        contentPane.add(textAreaOutput);
    }

   private void updateOutput() {
    StringBuilder output = new StringBuilder();
    for (String data : queueParkir) {
        output.append(data).append("\n");
    }
    textAreaOutput.setText(output.toString());

    if (!queueParkir.isEmpty()) {
        String depan = queueParkir.peek();
        textFieldDepan.setText(depan);
    } else {
        textFieldDepan.setText("");
    }

    if (!queueParkir.isEmpty()) {
        ListIterator<String> iterator = new LinkedList<>(queueParkir).listIterator(queueParkir.size());
        String belakang = iterator.previous();
        textFieldBelakang.setText(belakang);
    } else {
        textFieldBelakang.setText("");
    }
   }
}