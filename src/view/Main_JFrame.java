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

        Category_JPanel category_JPanel = new Category_JPanel();
        contentPanel.add(category_JPanel, "CATEGORY");
        contentPanel.add(new Category_JPanel(), "CATEGORY");

        
        JPanel panel = new JPanel();
        category_JPanel.add(panel);
        contentPanel.add(new Brand_JPanel(), "BRAND");
        contentPanel.add(new Products_JPanel(), "PRODUCT");
        contentPanel.add(new SearchProducts_JPanel(), "SEARCH");

        getContentPane().add(contentPanel, BorderLayout.CENTER);

        JMenuBar menuBar = new JMenuBar();

        JMenu menuDanhMuc = new JMenu("Danh mục");
        JMenuItem mnuCategory = new JMenuItem("Danh mục");
        JMenuItem mnuBrand = new JMenuItem("Thương hiệu");

        menuDanhMuc.add(mnuCategory);
        menuDanhMuc.add(mnuBrand);

        JMenu menuProduct = new JMenu("Sản phẩm");
        JMenuItem mnuProduct = new JMenuItem("Thông tin sản phẩm");
        JMenuItem mnuSearch = new JMenuItem("Tra cứu sản phẩm");
        menuProduct.add(mnuProduct);
        menuProduct.add(mnuSearch);
        
        
        
        
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
        
        mnuSearch.addActionListener(e ->
        cardLayout.show(contentPanel, "SEARCH")
        );
        
        mnuSearch.addActionListener(e -> cardLayout.show(contentPanel,  "PRODUCT"));

        mnuExit.addActionListener(e -> System.exit(0));
    }

    // ======= MAIN METHOD =======
    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(() -> {
            new Main_JFrame().setVisible(true);
        });
    }
}
