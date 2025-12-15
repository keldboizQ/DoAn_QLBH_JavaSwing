package view;

import java.awt.BorderLayout;
import java.awt.CardLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JSeparator;

public class Main_JFrame extends JFrame {

    CardLayout cardLayout = new CardLayout();
    JPanel contentPanel = new JPanel(cardLayout);

    public Main_JFrame() {
        setTitle("Hệ thống bán hàng");
        setSize(951, 567);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        contentPanel.add(new Category_JPanel(), "CATEGORY");
        contentPanel.add(new Brand_JPanel(), "BRAND");
        contentPanel.add(new Products_JPanel(), "PRODUCT");

        getContentPane().add(contentPanel, BorderLayout.CENTER);

        JMenuBar menuBar = new JMenuBar();

        JMenu menuDanhMuc = new JMenu("Danh mục");
        JMenuItem mnuCategory = new JMenuItem("Danh mục");
        JMenuItem mnuBrand = new JMenuItem("Thương hiệu");

        menuDanhMuc.add(mnuCategory);
        menuDanhMuc.add(mnuBrand);

        JMenu menuProduct = new JMenu("Sản phẩm");
        JMenuItem mnuProduct = new JMenuItem("Quản lý sản phẩm");
        menuProduct.add(mnuProduct);
        
        JMenu menuSystem = new JMenu("Hệ thống");
        JMenuItem mnuExit = new JMenuItem("Thoát");
        menuSystem.add(new JSeparator());
        menuSystem.add(mnuExit);

        menuBar.add(menuDanhMuc);
        menuBar.add(menuProduct);
        menuBar.add(menuSystem);

        setJMenuBar(menuBar);

        mnuCategory.addActionListener(e ->
            cardLayout.show(contentPanel, "CATEGORY")
        );

        mnuBrand.addActionListener(e ->
            cardLayout.show(contentPanel, "BRAND")
        );

        mnuProduct.addActionListener(e ->
            cardLayout.show(contentPanel, "PRODUCT")
        );

        mnuExit.addActionListener(e -> System.exit(0));
    }

    // ======= MAIN METHOD =======
    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(() -> {
            new Main_JFrame().setVisible(true);
        });
    }
}
