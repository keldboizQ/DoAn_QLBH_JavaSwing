package view;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class SearchProducts_JPanel extends JPanel {

    JTextField txtTenSP, txtDanhMuc, txtThuongHieu, txtSoLuong, txtGia;
    JTextArea txtMoTa;
    JTable table;
    DefaultTableModel model;

    JButton btnThem, btnSua, btnXoa, btnLamMoi;

    public SearchProducts_JPanel() {

        initUI();
    }

    private void initUI() {
        this.setLayout(new BorderLayout(10, 10));


        JPanel panelForm = new JPanel(new GridLayout(6, 2, 10, 10));
        panelForm.setBorder(BorderFactory.createTitledBorder("Thông tin sản phẩm"));
        panelForm.setPreferredSize(new Dimension(600, 220));

        txtTenSP = new JTextField();
        txtDanhMuc = new JTextField();
        txtThuongHieu = new JTextField();
        txtMoTa = new JTextArea(3, 20);
        txtSoLuong = new JTextField();
        txtGia = new JTextField();

        panelForm.add(new JLabel("Tên SP:"));
        panelForm.add(txtTenSP);

        panelForm.add(new JLabel("Danh mục:"));
        panelForm.add(txtDanhMuc);

        panelForm.add(new JLabel("Thương hiệu:"));
        panelForm.add(txtThuongHieu);
        
        
        txtMoTa = new JTextArea(6, 30);
        txtMoTa.setLineWrap(true);
        txtMoTa.setWrapStyleWord(true);

        JScrollPane scrollMoTa = new JScrollPane(txtMoTa);
        scrollMoTa.setPreferredSize(new Dimension(200, 200));

        JPanel moTaPanel = new JPanel(new BorderLayout());
        moTaPanel.add(scrollMoTa, BorderLayout.CENTER);

        panelForm.add(new JLabel("Mô tả:"));
        panelForm.add(new JScrollPane(txtMoTa));

        panelForm.add(new JLabel("Số lượng:"));
        panelForm.add(txtSoLuong);

        panelForm.add(new JLabel("Giá:"));
        panelForm.add(txtGia);

    
        JPanel panelButton = new JPanel(new FlowLayout(FlowLayout.CENTER, 15, 10));
        btnThem = new JButton("Thêm");
        btnSua = new JButton("Sửa");
        btnXoa = new JButton("Xóa");
        btnLamMoi = new JButton("Làm mới");

        panelButton.add(btnThem);
        panelButton.add(btnSua);
        panelButton.add(btnXoa);
        panelButton.add(btnLamMoi);


        String[] columns = {"Tên SP", "Danh mục", "Thương hiệu", "Mô tả", "Số lượng", "Giá"};
        model = new DefaultTableModel(columns, 0);
        table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);


        this.add(panelForm, BorderLayout.NORTH);
        this.add(panelButton, BorderLayout.CENTER);
        this.add(scrollPane, BorderLayout.SOUTH);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new SearchProducts_JPanel().setVisible(true));
    }
}
