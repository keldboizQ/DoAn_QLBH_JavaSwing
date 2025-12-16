package view;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class Brand_JPanel extends JPanel {

    private JTable table;
    private JTextField txtId, txtName;
    private DefaultTableModel model;

    public Brand_JPanel() {
        setLayout(new BorderLayout(10, 10));

        // PANEL TOP (FORM + BUTTON)
        JPanel topPanel = new JPanel(new BorderLayout(10, 10));

        // FORM
        JPanel formPanel = new JPanel(new GridLayout(2, 2, 10, 10));
        formPanel.setBorder(BorderFactory.createTitledBorder("Thông tin thương hiệu"));

        formPanel.add(new JLabel("ID:"));
        txtId = new JTextField();
        txtId.setEnabled(false);
        formPanel.add(txtId);

        formPanel.add(new JLabel("Tên thương hiệu:"));
        txtName = new JTextField();
        formPanel.add(txtName);

        
        // BUTTON
        JPanel btnPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 15, 5));
        JButton btnAdd = new JButton("Thêm");
        JButton btnUpdate = new JButton("Sửa");
        JButton btnDelete = new JButton("Xóa");
        JButton btnReset = new JButton("Làm mới");

        btnPanel.add(btnAdd);
        btnPanel.add(btnUpdate);
        btnPanel.add(btnDelete);
        btnPanel.add(btnReset);

        topPanel.add(formPanel, BorderLayout.NORTH);
        topPanel.add(btnPanel, BorderLayout.SOUTH);

        add(topPanel, BorderLayout.NORTH);

        // TABLE
        model = new DefaultTableModel();
        model.addColumn("ID");
        model.addColumn("Tên thương hiệu");

        table = new JTable(model);
        add(new JScrollPane(table), BorderLayout.CENTER);
    }
}
