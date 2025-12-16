package view;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class Products_JPanel extends JPanel {

    private JTable table;
    private JTextField txtName, txtPriceFrom, txtPriceTo;
    private JComboBox<String> cboCategory, cboBrand;

    public Products_JPanel() {
        setLayout(new BorderLayout(10, 10));


        // ===== SEARCH PANEL =====
        JPanel searchPanel = new JPanel(new GridLayout(3, 4, 10, 10));
        searchPanel.setBorder(BorderFactory.createTitledBorder("Tra cứu sản phẩm"));

        searchPanel.add(new JLabel("Tên sản phẩm:"));
        txtName = new JTextField();
        searchPanel.add(txtName);
        
        searchPanel.add(new JLabel("Giá từ:"));
        txtPriceFrom = new JTextField();
        searchPanel.add(txtPriceFrom);

        searchPanel.add(new JLabel("Danh mục:"));
        cboCategory = new JComboBox<>();
        searchPanel.add(cboCategory);
        
        searchPanel.add(new JLabel("Đến:"));
        txtPriceTo = new JTextField();
        searchPanel.add(txtPriceTo);

        searchPanel.add(new JLabel("Thương hiệu:"));
        cboBrand = new JComboBox<>();
        searchPanel.add(cboBrand);



        JButton btnSearch = new JButton("Tìm kiếm");
        JButton btnReset = new JButton("Làm mới");

        searchPanel.add(btnSearch);
        searchPanel.add(btnReset);

        add(searchPanel, BorderLayout.NORTH);

        // ===== TABLE =====
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("ID");
        model.addColumn("Tên SP");
        model.addColumn("Giá");
        model.addColumn("Tồn kho");
        model.addColumn("Danh mục");
        model.addColumn("Thương hiệu");

        table = new JTable(model);
        add(new JScrollPane(table), BorderLayout.CENTER);
    }
}
