import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import javax.swing.table.DefaultTableModel;

public class GUI extends javax.swing.JFrame {
    String userID="", userPass="", userType="";
    Manage manage = new Manage();

    public GUI(String id, String pass) {
        initComponents();
        this.setResizable(false);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
        mainMenu.setEnabledAt(1, false);
        mainMenu.setTitleAt(1, "");
        mainMenu.setEnabledAt(2, false);
        mainMenu.setTitleAt(2, "");
        mainMenu.setEnabledAt(3, false);
        mainMenu.setTitleAt(3, "");
        if(!id.equals("")) {
            verifyLogin(id, pass);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainMenu = new javax.swing.JTabbedPane();
        loginLogin = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        btnLoginExit = new javax.swing.JButton();
        btnLoginEnter = new javax.swing.JButton();
        txtLoginPass = new javax.swing.JTextField();
        txtLoginID = new javax.swing.JTextField();
        labelLoginMessage = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jTabbedPane3 = new javax.swing.JTabbedPane();
        jPanel7 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        txtMOOrderTotalFragile = new javax.swing.JTextField();
        txtMOOrderTotalAmount = new javax.swing.JTextField();
        txtMOOrderFragieRate = new javax.swing.JTextField();
        txtMOOrderCusID = new javax.swing.JTextField();
        txtMOOrderDate = new javax.swing.JTextField();
        btnMOOrderSearch = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        txtMOSearchID = new javax.swing.JTextField();
        jLabel24 = new javax.swing.JLabel();
        jSeparator4 = new javax.swing.JSeparator();
        jLabel25 = new javax.swing.JLabel();
        txtMOOrderID = new javax.swing.JTextField();
        jPanel9 = new javax.swing.JPanel();
        jLabel26 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        btnTerminalMode = new javax.swing.JButton();
        btnLogOut = new javax.swing.JButton();
        jLabel27 = new javax.swing.JLabel();
        txtMOOrderTotalPrice = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        tableMO = new javax.swing.JTable();
        jLabel23 = new javax.swing.JLabel();
        txtMOQuantity = new javax.swing.JTextField();
        btnMOCheckOut = new javax.swing.JButton();
        btnMOAdd = new javax.swing.JButton();
        btnMOCancel = new javax.swing.JButton();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel5 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        txtMPProductDate = new javax.swing.JTextField();
        txtMPProductPrice = new javax.swing.JTextField();
        txtMPProductName = new javax.swing.JTextField();
        txtMPProductID = new javax.swing.JTextField();
        btnMPDelete = new javax.swing.JButton();
        btnMPEdit = new javax.swing.JButton();
        btnMPClear = new javax.swing.JButton();
        btnMPAdd = new javax.swing.JButton();
        txtMPProductSearchID = new javax.swing.JTextField();
        btnMPSearch = new javax.swing.JButton();
        jLabel18 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        rbMPFragile = new javax.swing.JRadioButton();
        rbMPNonFragile = new javax.swing.JRadioButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableMP = new javax.swing.JTable();
        jTabbedPane4 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableMC = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtMCCusDate = new javax.swing.JTextField();
        txtMCCusContact = new javax.swing.JTextField();
        txtMCCusAddress = new javax.swing.JTextField();
        txtMCCusName = new javax.swing.JTextField();
        txtMCCusPass = new javax.swing.JTextField();
        txtMCCusID = new javax.swing.JTextField();
        btnMCDelete = new javax.swing.JButton();
        btnMCEdit = new javax.swing.JButton();
        btnMCClear = new javax.swing.JButton();
        btnMCAdd = new javax.swing.JButton();
        txtMCCusSearchID = new javax.swing.JTextField();
        btnMCSearch = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txtMCCusType = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Retail Order Management System");
        setMaximumSize(new java.awt.Dimension(800, 600));
        setMinimumSize(new java.awt.Dimension(800, 600));
        setResizable(false);

        mainMenu.setBackground(new java.awt.Color(0, 153, 153));
        mainMenu.setForeground(new java.awt.Color(0, 51, 51));
        mainMenu.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        mainMenu.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        mainMenu.setMaximumSize(new java.awt.Dimension(800, 600));
        mainMenu.setMinimumSize(new java.awt.Dimension(800, 600));
        mainMenu.setPreferredSize(new java.awt.Dimension(800, 600));
        mainMenu.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                mainMenuKeyPressed(evt);
            }
        });

        loginLogin.setForeground(new java.awt.Color(0, 51, 51));
        loginLogin.setTabPlacement(javax.swing.JTabbedPane.BOTTOM);
        loginLogin.setAlignmentX(0.0F);
        loginLogin.setAlignmentY(0.0F);
        loginLogin.setFont(new java.awt.Font("Arial", 0, 3)); // NOI18N

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Login", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 36), new java.awt.Color(0, 153, 153))); // NOI18N
        jPanel3.setMaximumSize(new java.awt.Dimension(400, 250));
        jPanel3.setMinimumSize(new java.awt.Dimension(400, 250));
        jPanel3.setPreferredSize(new java.awt.Dimension(400, 250));

        btnLoginExit.setForeground(new java.awt.Color(0, 102, 102));
        btnLoginExit.setText("Exit");
        btnLoginExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginExitActionPerformed(evt);
            }
        });

        btnLoginEnter.setForeground(new java.awt.Color(0, 102, 102));
        btnLoginEnter.setText("Enter");
        btnLoginEnter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginEnterActionPerformed(evt);
            }
        });

        txtLoginPass.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtLoginPassKeyPressed(evt);
            }
        });

        jLabel2.setForeground(new java.awt.Color(0, 102, 102));
        jLabel2.setText("USER ID:");

        jLabel3.setForeground(new java.awt.Color(0, 102, 102));
        jLabel3.setText("PASSWORD:");

        jLabel4.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnLoginEnter, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(txtLoginPass, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtLoginID, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnLoginExit, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(labelLoginMessage, javax.swing.GroupLayout.PREFERRED_SIZE, 341, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(20, Short.MAX_VALUE))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtLoginID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtLoginPass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnLoginEnter)
                    .addComponent(btnLoginExit))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                .addComponent(labelLoginMessage, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(188, 188, 188)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(202, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(120, 120, 120)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(179, Short.MAX_VALUE))
        );

        loginLogin.addTab("", jPanel1);

        mainMenu.addTab("   ::: Login   ", loginLogin);

        jTabbedPane3.setTabPlacement(javax.swing.JTabbedPane.BOTTOM);
        jTabbedPane3.setAlignmentX(0.0F);
        jTabbedPane3.setAlignmentY(0.0F);
        jTabbedPane3.setFont(new java.awt.Font("Arial", 0, 3)); // NOI18N

        jLabel15.setForeground(new java.awt.Color(0, 102, 102));
        jLabel15.setText("FRAGILE RATE (RM 1.5 FOR EACH):");

        jLabel19.setForeground(new java.awt.Color(0, 102, 102));
        jLabel19.setText("TOTAL FRAGILE ITEMS:");

        jLabel20.setForeground(new java.awt.Color(0, 102, 102));
        jLabel20.setText("TOTAL AMOUNT:");

        jLabel21.setForeground(new java.awt.Color(0, 102, 102));
        jLabel21.setText("ORDERED DATE:");

        jLabel22.setForeground(new java.awt.Color(0, 102, 102));
        jLabel22.setText("ORDER ID:");

        txtMOOrderTotalFragile.setEnabled(false);

        txtMOOrderTotalAmount.setEnabled(false);

        txtMOOrderFragieRate.setEnabled(false);

        txtMOOrderCusID.setEnabled(false);

        txtMOOrderDate.setEnabled(false);

        btnMOOrderSearch.setForeground(new java.awt.Color(0, 102, 102));
        btnMOOrderSearch.setText("Search");
        btnMOOrderSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMOOrderSearchActionPerformed(evt);
            }
        });

        jButton4.setForeground(new java.awt.Color(0, 102, 102));
        jButton4.setText("Delete");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        txtMOSearchID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMOSearchIDActionPerformed(evt);
            }
        });

        jLabel24.setForeground(new java.awt.Color(0, 102, 102));
        jLabel24.setText("ENTER THE ORDER ID:");

        jLabel25.setForeground(new java.awt.Color(0, 102, 102));
        jLabel25.setText("CUSTOMER ID:");

        txtMOOrderID.setEnabled(false);
        txtMOOrderID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMOOrderIDActionPerformed(evt);
            }
        });

        jLabel26.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(0, 102, 102));
        jLabel26.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel26.setText("ORDER MANAGEMENT SYSTEM");

        jLabel28.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(0, 102, 102));
        jLabel28.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel28.setText("Wahidul Alam Riyad & Muhammad Hamza");

        btnTerminalMode.setForeground(new java.awt.Color(0, 102, 102));
        btnTerminalMode.setText("Terminal Mode");
        btnTerminalMode.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnTerminalModeMouseClicked(evt);
            }
        });
        btnTerminalMode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTerminalModeActionPerformed(evt);
            }
        });

        btnLogOut.setForeground(new java.awt.Color(0, 102, 102));
        btnLogOut.setText("Log Out");
        btnLogOut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogOutActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel26, javax.swing.GroupLayout.DEFAULT_SIZE, 345, Short.MAX_VALUE)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel28, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGap(67, 67, 67)
                        .addComponent(btnTerminalMode, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnLogOut, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addComponent(jLabel26)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnTerminalMode)
                    .addComponent(btnLogOut))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel27.setForeground(new java.awt.Color(0, 102, 102));
        jLabel27.setText("TOTAL PRICE:");

        txtMOOrderTotalPrice.setEnabled(false);

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator4)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(jLabel24, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(txtMOSearchID, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnMOOrderSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addComponent(jLabel15)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtMOOrderFragieRate, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addComponent(jLabel19)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtMOOrderTotalFragile, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addComponent(jLabel20)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtMOOrderTotalAmount, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addComponent(jLabel25)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtMOOrderCusID, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addComponent(jLabel22)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtMOOrderID, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addComponent(jLabel27)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtMOOrderTotalPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                                .addComponent(jLabel21)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtMOOrderDate, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(18, 18, 18)
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel24)
                            .addComponent(txtMOSearchID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnMOOrderSearch)
                            .addComponent(jButton4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtMOOrderID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel22))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtMOOrderCusID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel25))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtMOOrderTotalAmount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel20))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtMOOrderTotalFragile, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel19))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtMOOrderFragieRate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel15))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtMOOrderTotalPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel27))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtMOOrderDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel21))
                        .addGap(0, 16, Short.MAX_VALUE)))
                .addGap(6, 6, 6))
        );

        tableMO.setBackground(new java.awt.Color(240, 240, 240));
        tableMO.setForeground(new java.awt.Color(0, 102, 102));
        tableMO.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Product ID", "Product Name", "Product Type", "Product Price", "Product Quantity", "Product Total Price"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableMO.setMaximumSize(null);
        tableMO.setMinimumSize(null);
        tableMO.setPreferredSize(null);
        tableMO.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableMOMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tableMO);

        jLabel23.setForeground(new java.awt.Color(0, 102, 102));
        jLabel23.setText("QUANTITY:");

        txtMOQuantity.setText("0");
        txtMOQuantity.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMOQuantityActionPerformed(evt);
            }
        });

        btnMOCheckOut.setForeground(new java.awt.Color(0, 102, 102));
        btnMOCheckOut.setText("Check Out");
        btnMOCheckOut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMOCheckOutActionPerformed(evt);
            }
        });

        btnMOAdd.setForeground(new java.awt.Color(0, 102, 102));
        btnMOAdd.setText("Add to Card");
        btnMOAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMOAddActionPerformed(evt);
            }
        });

        btnMOCancel.setForeground(new java.awt.Color(0, 102, 102));
        btnMOCancel.setText("Cancel");
        btnMOCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMOCancelActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 780, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel23)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtMOQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnMOAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnMOCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnMOCheckOut, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)))
                .addContainerGap())
            .addComponent(jScrollPane3)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnMOCheckOut)
                    .addComponent(btnMOCancel)
                    .addComponent(btnMOAdd)
                    .addComponent(txtMOQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel23))
                .addContainerGap(70, Short.MAX_VALUE))
        );

        jTabbedPane3.addTab("", jPanel7);

        mainMenu.addTab("   :::   Manage Order   ", jTabbedPane3);

        jTabbedPane1.setTabPlacement(javax.swing.JTabbedPane.BOTTOM);
        jTabbedPane1.setAlignmentX(0.0F);
        jTabbedPane1.setAlignmentY(0.0F);
        jTabbedPane1.setFont(new java.awt.Font("Arial", 0, 3)); // NOI18N

        jLabel12.setForeground(new java.awt.Color(0, 102, 102));
        jLabel12.setText("PRODUCT ID:");

        jLabel13.setForeground(new java.awt.Color(0, 102, 102));
        jLabel13.setText("PRODUCT NAME:");

        jLabel14.setForeground(new java.awt.Color(0, 102, 102));
        jLabel14.setText("PRODUCT PRICE:");

        jLabel16.setForeground(new java.awt.Color(0, 102, 102));
        jLabel16.setText("PRODUCT REGISTERED DATE:");

        jLabel17.setForeground(new java.awt.Color(0, 102, 102));
        jLabel17.setText("PRODUCT TYPE:");

        txtMPProductDate.setEnabled(false);

        txtMPProductID.setEnabled(false);

        btnMPDelete.setForeground(new java.awt.Color(0, 102, 102));
        btnMPDelete.setText("Delete");
        btnMPDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMPDeleteActionPerformed(evt);
            }
        });

        btnMPEdit.setForeground(new java.awt.Color(0, 102, 102));
        btnMPEdit.setText("Save");
        btnMPEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMPEditActionPerformed(evt);
            }
        });

        btnMPClear.setForeground(new java.awt.Color(0, 102, 102));
        btnMPClear.setText("Clear");
        btnMPClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMPClearActionPerformed(evt);
            }
        });

        btnMPAdd.setForeground(new java.awt.Color(0, 102, 102));
        btnMPAdd.setText("Add");
        btnMPAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMPAddActionPerformed(evt);
            }
        });

        txtMPProductSearchID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMPProductSearchIDActionPerformed(evt);
            }
        });

        btnMPSearch.setForeground(new java.awt.Color(0, 102, 102));
        btnMPSearch.setText("Search");
        btnMPSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMPSearchActionPerformed(evt);
            }
        });

        jLabel18.setForeground(new java.awt.Color(0, 102, 102));
        jLabel18.setText("ENTER PRODUCT ID TO SEARCH:");

        rbMPFragile.setForeground(new java.awt.Color(0, 102, 102));
        rbMPFragile.setText("FRAGILE");
        rbMPFragile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbMPFragileActionPerformed(evt);
            }
        });

        rbMPNonFragile.setForeground(new java.awt.Color(0, 102, 102));
        rbMPNonFragile.setSelected(true);
        rbMPNonFragile.setText("NON-FRAGILE");
        rbMPNonFragile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbMPNonFragileActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel16)
                            .addComponent(jLabel14)
                            .addComponent(jLabel13)
                            .addComponent(jLabel12))
                        .addGap(26, 26, 26)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(txtMPProductID, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnMPAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(txtMPProductName, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnMPClear, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(txtMPProductPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnMPEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(jPanel6Layout.createSequentialGroup()
                                        .addComponent(rbMPFragile)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(rbMPNonFragile))
                                    .addComponent(txtMPProductDate, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnMPDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(122, 122, 122))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel17)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(jLabel18)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtMPProductSearchID, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnMPSearch, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(jSeparator2))
                        .addGap(212, 212, 212))))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(txtMPProductID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnMPAdd))
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(txtMPProductName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnMPClear))
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(txtMPProductPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnMPEdit))
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnMPDelete)
                    .addComponent(jLabel16)
                    .addComponent(txtMPProductDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(rbMPFragile)
                    .addComponent(rbMPNonFragile))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(txtMPProductSearchID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnMPSearch))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tableMP.setBackground(new java.awt.Color(240, 240, 240));
        tableMP.setForeground(new java.awt.Color(0, 102, 102));
        tableMP.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Product ID", "Product Name", "Product Price", "Product Type", "Registered Date"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableMP.setMaximumSize(null);
        tableMP.setMinimumSize(null);
        tableMP.setName(""); // NOI18N
        tableMP.setPreferredSize(null);
        tableMP.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableMPMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tableMP);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addGap(0, 141, Short.MAX_VALUE)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 509, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(140, 140, 140))
            .addComponent(jScrollPane2)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(479, 479, 479))
        );

        jTabbedPane1.addTab("", jPanel5);

        mainMenu.addTab("   :::   Manage Product   ", jTabbedPane1);

        jTabbedPane4.setTabPlacement(javax.swing.JTabbedPane.BOTTOM);
        jTabbedPane4.setAlignmentX(0.0F);
        jTabbedPane4.setAlignmentY(0.0F);
        jTabbedPane4.setFont(new java.awt.Font("Arial", 0, 3)); // NOI18N

        tableMC.setBackground(new java.awt.Color(240, 240, 240));
        tableMC.setForeground(new java.awt.Color(0, 102, 102));
        tableMC.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "User ID", "Type", "Name", "Password", "Address", "Contact", "Date"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableMC.setMaximumSize(null);
        tableMC.setMinimumSize(null);
        tableMC.setPreferredSize(null);
        tableMC.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableMCMouseClicked(evt);
            }
        });
        tableMC.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tableMCKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(tableMC);

        jLabel1.setForeground(new java.awt.Color(0, 102, 102));
        jLabel1.setText("CUSTOMER ID:");

        jLabel5.setForeground(new java.awt.Color(0, 102, 102));
        jLabel5.setText("CUSTOMER PASSWORD:");

        jLabel6.setForeground(new java.awt.Color(0, 102, 102));
        jLabel6.setText("CUSTOMER NAME:");

        jLabel7.setForeground(new java.awt.Color(0, 102, 102));
        jLabel7.setText("CUSTOMER ADDRESS:");

        jLabel8.setForeground(new java.awt.Color(0, 102, 102));
        jLabel8.setText("CUSTOMER CONTACT:");

        jLabel9.setForeground(new java.awt.Color(0, 102, 102));
        jLabel9.setText("CUSTOMER REGISTRED DATE:");

        txtMCCusDate.setEnabled(false);

        txtMCCusID.setEnabled(false);

        btnMCDelete.setForeground(new java.awt.Color(0, 102, 102));
        btnMCDelete.setText("Delete");
        btnMCDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMCDeleteActionPerformed(evt);
            }
        });

        btnMCEdit.setForeground(new java.awt.Color(0, 102, 102));
        btnMCEdit.setText("Save");
        btnMCEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMCEditActionPerformed(evt);
            }
        });

        btnMCClear.setForeground(new java.awt.Color(0, 102, 102));
        btnMCClear.setText("Clear");
        btnMCClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMCClearActionPerformed(evt);
            }
        });

        btnMCAdd.setForeground(new java.awt.Color(0, 102, 102));
        btnMCAdd.setText("Add");
        btnMCAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMCAddActionPerformed(evt);
            }
        });

        txtMCCusSearchID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMCCusSearchIDActionPerformed(evt);
            }
        });

        btnMCSearch.setForeground(new java.awt.Color(0, 102, 102));
        btnMCSearch.setText("Search");
        btnMCSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMCSearchActionPerformed(evt);
            }
        });

        jLabel10.setForeground(new java.awt.Color(0, 102, 102));
        jLabel10.setText("ENTER CUSTOMER ID TO SEARCH:");

        jLabel11.setForeground(new java.awt.Color(0, 102, 102));
        jLabel11.setText("CUSTOMER TYPE:");

        txtMCCusType.setEnabled(false);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addGap(18, 18, 18)
                        .addComponent(txtMCCusSearchID, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnMCSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel11)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtMCCusType, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel9)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtMCCusID, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtMCCusPass, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtMCCusName, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtMCCusAddress, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtMCCusContact, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtMCCusDate, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.LEADING))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnMCAdd, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnMCClear, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnMCEdit, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnMCDelete, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(24, 24, 24))))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtMCCusID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnMCAdd))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtMCCusPass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnMCClear))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtMCCusName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnMCEdit))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtMCCusAddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(btnMCDelete))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtMCCusContact, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txtMCCusDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(txtMCCusType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(txtMCCusSearchID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnMCSearch))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(130, 130, 130)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(142, Short.MAX_VALUE))
            .addComponent(jScrollPane1)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(58, 58, 58))
        );

        jTabbedPane4.addTab("", jPanel2);

        mainMenu.addTab("   :::   Manage Customer   ", jTabbedPane4);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainMenu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainMenu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnLoginExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginExitActionPerformed
        this.dispose();        // TODO add your handling code here:
    }//GEN-LAST:event_btnLoginExitActionPerformed

    private void btnLoginEnterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginEnterActionPerformed
        verifyLogin(txtLoginID.getText().toUpperCase(), txtLoginPass.getText().toUpperCase());
    }//GEN-LAST:event_btnLoginEnterActionPerformed

    private void mainMenuKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_mainMenuKeyPressed
                // TODO add your handling code here:
    }//GEN-LAST:event_mainMenuKeyPressed

    private void btnMCAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMCAddActionPerformed
        Manage manage = new Manage();
        manage.addCustomer(txtMCCusPass.getText().toUpperCase(), txtMCCusName.getText().toUpperCase(), txtMCCusAddress.getText().toUpperCase(), txtMCCusContact.getText().toUpperCase());
        updateMCTable();
        clearMCInputs();
    }//GEN-LAST:event_btnMCAddActionPerformed

    private void btnMCDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMCDeleteActionPerformed
        Manage manage = new Manage();
        manage.deleteCustomer(txtMCCusID.getText());
        updateMCTable();
        clearMCInputs();
    }//GEN-LAST:event_btnMCDeleteActionPerformed

    private void txtMCCusSearchIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMCCusSearchIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMCCusSearchIDActionPerformed

    private void btnMCSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMCSearchActionPerformed
        searchCustomer(txtMCCusSearchID.getText().toUpperCase());   // TODO add your handling code here:
    }//GEN-LAST:event_btnMCSearchActionPerformed

    private void btnMCClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMCClearActionPerformed
        clearMCInputs();        // TODO add your handling code here:
    }//GEN-LAST:event_btnMCClearActionPerformed

    private void tableMCKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tableMCKeyPressed

        
    }//GEN-LAST:event_tableMCKeyPressed

    private void tableMCMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableMCMouseClicked
        int row = tableMC.getSelectedRow();
        String id = String.valueOf(tableMC.getValueAt(row, 0));
        searchCustomer(id);
    }//GEN-LAST:event_tableMCMouseClicked

    private void btnMCEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMCEditActionPerformed
        Manage manage = new Manage();
        manage.editCustomer(txtMCCusID.getText(), txtMCCusPass.getText().toUpperCase(), txtMCCusName.getText().toUpperCase(), txtMCCusAddress.getText().toUpperCase(), txtMCCusContact.getText().toUpperCase());
        updateMCTable();
        clearMCInputs();
    }//GEN-LAST:event_btnMCEditActionPerformed

    private void btnMPSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMPSearchActionPerformed
        searchProduct(txtMPProductSearchID.getText().toUpperCase());
    }//GEN-LAST:event_btnMPSearchActionPerformed

    private void searchProduct(String id) {
        clearMPInputs();
        boolean idFound = false;
        ObjectInputStream ois = null;
        try {
            ois = new ObjectInputStream(new FileInputStream(new Login().getDataProduct()));
            Object obj = null;
            while ((obj = ois.readObject()) != null) {
                if(((Product)obj).getProductID().equals(id)){
                    idFound = true;
                    System.out.println("\nSearch result for '" + id + "':");
                    System.out.println(((Product)obj).toString());
                    txtMPProductID.setText(((Product)obj).getProductID());
                    txtMPProductName.setText(((Product)obj).getProductName());
                    txtMPProductPrice.setText(((Product)obj).getProductPrice());
                    txtMPProductDate.setText(((Product)obj).getProductDate());
                    if(((Product)obj).getProductType().equals("FRAGILE")){
                        rbMPFragile.setSelected(true);
                        rbMPNonFragile.setSelected(false);
                    }
                    txtMPProductSearchID.setText("");
                }
            }
        } catch (EOFException ex) {}
        catch (ClassNotFoundException ex) { ex.printStackTrace(); }
        catch (FileNotFoundException ex) { ex.printStackTrace(); }
        catch (IOException ex) { ex.printStackTrace(); }
        finally {
            try {
                if (ois != null) {
                    ois.close();
                }
            } catch (IOException ex) { ex.printStackTrace(); }
        }
        
        if (idFound == false) {
            System.out.println("\nProduct '" + id + "' is not found!\n");
        }
    }
    private void txtMPProductSearchIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMPProductSearchIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMPProductSearchIDActionPerformed

    private void btnMPAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMPAddActionPerformed
        String type = "NON-FRAGILE";
        if(rbMPFragile.isSelected()) {
            type = "FRAGILE";
        }
        Manage manage = new Manage();
        manage.addProduct(txtMPProductName.getText().toUpperCase(), type, txtMPProductPrice.getText().toUpperCase());
        updateMPTable();
        updateMOTable();
        clearMPInputs();
    }//GEN-LAST:event_btnMPAddActionPerformed

    private void btnMPClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMPClearActionPerformed
        clearMPInputs();
    }//GEN-LAST:event_btnMPClearActionPerformed

    private void clearMPInputs(){
        txtMPProductID.setText("");
        txtMPProductName.setText("");
        txtMPProductPrice.setText("");
        txtMPProductDate.setText("");
        txtMPProductSearchID.setText("");
        rbMPFragile.setSelected(false);
        rbMPNonFragile.setSelected(true);
    }
    
    private void updateMPTable() {
        DefaultTableModel table = (DefaultTableModel) tableMP.getModel();
        table.setRowCount(0);
        int count=0;
        ObjectInputStream ois = null;
        try {
            ois = new ObjectInputStream(new FileInputStream(new Login().getDataProduct()));
            Object obj = null;
            while ((obj = ois.readObject()) != null) {
                count++;
                String[] row = { ((Product)obj).getProductID(), ((Product)obj).getProductName(), "RM " + ((Product)obj).getProductPrice(), ((Product)obj).getProductType(), ((Product)obj).getProductDate() };
                table.addRow(row);
                System.out.println(((Product)obj).toString());
            }
        } catch (EOFException ex) {
            System.out.println("\nTotal " + count + " product.");
        } catch (ClassNotFoundException ex) { ex.printStackTrace(); }
        catch (FileNotFoundException ex) { ex.printStackTrace(); }
        catch (IOException ex) { ex.printStackTrace(); }
        finally {
            try {
                if (ois != null) {
                    ois.close();
                }
            } catch (IOException ex) { ex.printStackTrace(); }
        }
    }
    
    private void updateMOTable() {
        DefaultTableModel table = (DefaultTableModel) tableMO.getModel();
        table.setRowCount(0);
        int count=0;
        ObjectInputStream ois = null;
        try {
            ois = new ObjectInputStream(new FileInputStream(new Login().getDataProduct()));
            Object obj = null;
            while ((obj = ois.readObject()) != null) {
                count++;
                String[] row = { ((Product)obj).getProductID(), ((Product)obj).getProductName(), ((Product)obj).getProductType(), "RM " + ((Product)obj).getProductPrice(), "0", "0" };
                table.addRow(row);
                System.out.println(((Product)obj).toString());
            }
        } catch (EOFException ex) {
            System.out.println("\nTotal " + count + " product.");
        } catch (ClassNotFoundException ex) { ex.printStackTrace(); }
        catch (FileNotFoundException ex) { ex.printStackTrace(); }
        catch (IOException ex) { ex.printStackTrace(); }
        finally {
            try {
                if (ois != null) {
                    ois.close();
                }
            } catch (IOException ex) { ex.printStackTrace(); }
        }
    }
    
    private void btnMPEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMPEditActionPerformed
        String type = "NON-FRAGILE";
        if(rbMPFragile.isSelected()) {
            type = "FRAGILE";
        }
        Manage manage = new Manage();
        manage.editProduct(txtMPProductID.getText(), txtMPProductName.getText().toUpperCase(), type, txtMPProductPrice.getText().toUpperCase());
        updateMPTable();
        updateMOTable();
        clearMPInputs();
    }//GEN-LAST:event_btnMPEditActionPerformed

    private void btnMPDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMPDeleteActionPerformed
        Manage manage = new Manage();
        manage.deleteProduct(txtMPProductID.getText());
        updateMPTable();
        updateMOTable();
        clearMPInputs();
    }//GEN-LAST:event_btnMPDeleteActionPerformed

    private void rbMPNonFragileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbMPNonFragileActionPerformed
        rbMPFragile.setSelected(false);        // TODO add your handling code here:
    }//GEN-LAST:event_rbMPNonFragileActionPerformed

    private void rbMPFragileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbMPFragileActionPerformed
        rbMPNonFragile.setSelected(false);    
    }//GEN-LAST:event_rbMPFragileActionPerformed

    private void tableMPMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableMPMouseClicked
        int row = tableMP.getSelectedRow();
        String id = String.valueOf(tableMP.getValueAt(row, 0));
        searchProduct(id);
    }//GEN-LAST:event_tableMPMouseClicked

    private void txtMOOrderIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMOOrderIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMOOrderIDActionPerformed

    private void txtMOSearchIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMOSearchIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMOSearchIDActionPerformed

    private void txtMOQuantityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMOQuantityActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMOQuantityActionPerformed

    private void btnMOAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMOAddActionPerformed
        DefaultTableModel table = (DefaultTableModel) tableMO.getModel();
        int index = tableMO.getSelectedRow();
        String id = String.valueOf(table.getValueAt(index, 0));
        String type = String.valueOf(table.getValueAt(index, 2));
        String price = String.valueOf(table.getValueAt(index, 3));
        price = price.substring(3,price.length());
        String quantity = txtMOQuantity.getText();
        String totalPrice = String.valueOf(Double.parseDouble(price) * Integer.parseInt(quantity));
        Double totalPriceDouble = Double.parseDouble(totalPrice);
        totalPriceDouble = (Math.round(totalPriceDouble * 100.0)) / 100.0;
        manage.makeOrder(id, quantity, type, price);
        table.setValueAt(quantity, index, 4);
        table.setValueAt(totalPriceDouble, index, 5);
        txtMOQuantity.setText("0");
    }//GEN-LAST:event_btnMOAddActionPerformed

    private void tableMOMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableMOMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tableMOMouseClicked

    private void btnMOCheckOutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMOCheckOutActionPerformed
        String orderID = manage.addOrder(userID);
        manage=null;
        manage = new Manage();
        updateMOTable();
        searchOrder(orderID);
    }//GEN-LAST:event_btnMOCheckOutActionPerformed

    private void btnMOOrderSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMOOrderSearchActionPerformed
        searchOrder(txtMOSearchID.getText().toUpperCase());
        updateMOTable();
    }//GEN-LAST:event_btnMOOrderSearchActionPerformed

    private void btnMOCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMOCancelActionPerformed
        manage = null;
        manage = new Manage();
        updateMOTable();
        clearMOInputs();
    }//GEN-LAST:event_btnMOCancelActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        manage.deleteOrder(txtMOSearchID.getText().toUpperCase());
        updateMOTable();
        clearMOInputs();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void btnTerminalModeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTerminalModeMouseClicked

    }//GEN-LAST:event_btnTerminalModeMouseClicked

    private void btnTerminalModeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTerminalModeActionPerformed
        Login login = new Login(userID, userPass, userType);
        login.clearConsole();
        this.dispose();
        if(userType.equals("ADMIN")) {
            login.adminMenu();
        } else {
            login.customerMenu();
        }
    }//GEN-LAST:event_btnTerminalModeActionPerformed

    private void btnLogOutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogOutActionPerformed
        userID=""; userPass=""; userType="";
        mainMenu.setEnabledAt(0, true);
        mainMenu.setTitleAt(0, "Login");
        mainMenu.setEnabledAt(1, false);
        mainMenu.setTitleAt(1, "");
        mainMenu.setEnabledAt(2, false);
        mainMenu.setTitleAt(2, "");
        mainMenu.setEnabledAt(3, false);
        mainMenu.setTitleAt(3, "");
        mainMenu.setSelectedIndex(0);
        txtLoginPass.setText("");
    }//GEN-LAST:event_btnLogOutActionPerformed

    private void txtLoginPassKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtLoginPassKeyPressed
        verifyLogin(txtLoginID.getText().toUpperCase(), txtLoginPass.getText().toUpperCase());        
    }//GEN-LAST:event_txtLoginPassKeyPressed
    
    private void clearMOInputs() {
        txtMOOrderID.setText("");
        txtMOOrderCusID.setText("");
        txtMOOrderTotalAmount.setText("");
        txtMOOrderTotalFragile.setText("");
        txtMOOrderFragieRate.setText("");
        txtMOOrderDate.setText("");
        txtMOOrderTotalPrice.setText("");
    }
    
    private void searchOrder (String id) {
        String[] temp = new String[8];
        System.out.println(id);
        temp = manage.searchOrder(id);
        txtMOOrderID.setText(temp[0]);
        txtMOOrderCusID.setText(temp[1]);
        txtMOOrderTotalAmount.setText(temp[2]);
        txtMOOrderDate.setText(temp[3]);
        txtMOOrderTotalFragile.setText(temp[5]);
        if (temp[0].equals("")) {
            txtMOOrderFragieRate.setText("");
            txtMOOrderTotalPrice.setText("");
        } else {
            txtMOOrderFragieRate.setText("RM " + temp[6]);
            txtMOOrderTotalPrice.setText("RM " + temp[7]);
        }
    }
    
    private void clearMCInputs () {
        txtMCCusID.setText("");
        txtMCCusType.setText("");
        txtMCCusPass.setText("");
        txtMCCusName.setText("");
        txtMCCusAddress.setText("");
        txtMCCusContact.setText("");
        txtMCCusDate.setText("");
        txtMCCusSearchID.setText("");
    }
    
    private void searchCustomer(String id) {
        boolean idFound = false;
        ObjectInputStream ois = null;
        try {
            ois = new ObjectInputStream(new FileInputStream(new Login().getDataUser()));
            Object obj = null;
            while ((obj = ois.readObject()) != null) {
                if(((Customer)obj).getCusID().equals(id)){
                    idFound = true;
                    System.out.println("\nSearch result for '" + id + "':");
                    System.out.println(((Customer)obj).toString());
                    txtMCCusID.setText(((Customer)obj).getCusID());
                    txtMCCusType.setText(((Customer)obj).getCusType());
                    txtMCCusPass.setText(((Customer)obj).getCusPassword());
                    txtMCCusName.setText(((Customer)obj).getCusName());
                    txtMCCusAddress.setText(((Customer)obj).getCusAddress());
                    txtMCCusContact.setText(((Customer)obj).getCusContact());
                    txtMCCusDate.setText(((Customer)obj).getCusDate());
                    txtMCCusSearchID.setText("");
                }
            }
        } catch (EOFException ex) {}
        catch (ClassNotFoundException ex) { ex.printStackTrace(); }
        catch (FileNotFoundException ex) { ex.printStackTrace(); }
        catch (IOException ex) { ex.printStackTrace(); }
        finally {
            try {
                if (ois != null) {
                    ois.close();
                }
            } catch (IOException ex) { ex.printStackTrace(); }
        }
        
        if (idFound == false) {
            System.out.println("\nCustomer '" + id + "' is not found!\n");
        }
    }
    
    public void verifyLogin(String id, String pass) {
        labelLoginMessage.setText("");
        boolean idFound = false;
            ObjectInputStream ois = null;
            try {
                ois = new ObjectInputStream(new FileInputStream(new Login().getDataUser()));
                Object obj = null;
                while ((obj = ois.readObject()) != null) {
                    if (((Customer) obj).getCusID().equals(id)) {
                        idFound = true;
                        userID = ((Customer) obj).getCusID();
                        userPass = ((Customer) obj).getCusPassword();
                        userType = ((Customer) obj).getCusType();
                    }
                }
            } catch (EOFException ex) {}
            catch (ClassNotFoundException ex) { ex.printStackTrace(); }
            catch (FileNotFoundException ex) { ex.printStackTrace(); }
            catch (IOException ex) { ex.printStackTrace(); }
            finally {
                try {
                    if (ois != null) {
                        ois.close();
                    }
                } catch (IOException ex) { ex.printStackTrace(); }
            }
            
            if(idFound) {
                if(userPass.equals(pass)) {
                    mainMenu.setSelectedIndex(1);
                    mainMenu.setEnabledAt(0, false);
                    mainMenu.setTitleAt(0, "");
                    mainMenu.setEnabledAt(1, true);
                    mainMenu.setTitleAt(1, "Manage Order");
                    updateMOTable();
                    this.setAlwaysOnTop (true);
                    if(userType.equals("ADMIN")) {
                        mainMenu.setEnabledAt(2, true);
                        mainMenu.setTitleAt(2, "Manage Product");
                        mainMenu.setEnabledAt(3, true);
                        mainMenu.setTitleAt(3, "Manage Customer");
                        updateMCTable();
                        updateMPTable();
                    }
                } else {
                    labelLoginMessage.setText("Password is not correct!");
                }
            } else {
                labelLoginMessage.setText("User ID is not correct!");
            }
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GUI("", "").setVisible(true);
            }
        });
    }

    private void updateMCTable() {
        DefaultTableModel table = (DefaultTableModel) tableMC.getModel();
        table.setRowCount(0);
        int count=0;
        ObjectInputStream ois = null;
        try {
            ois = new ObjectInputStream(new FileInputStream(new Login().getDataUser()));
            Object obj = null;
            while ((obj = ois.readObject()) != null) {
                count++;
                String[] row = { ((Customer)obj).getCusID(), ((Customer)obj).getCusType(), ((Customer)obj).getCusName(), ((Customer)obj).getCusPassword(), ((Customer)obj).getCusAddress(), ((Customer)obj).getCusContact(), ((Customer)obj).getCusDate() };
                table.addRow(row);
                System.out.println(((Customer)obj).toString());
            }
        } catch (EOFException ex) {
            System.out.println("\nTotal " + count + " customers.");
        } catch (ClassNotFoundException ex) { ex.printStackTrace(); }
        catch (FileNotFoundException ex) { ex.printStackTrace(); }
        catch (IOException ex) { ex.printStackTrace(); }
        finally {
            try {
                if (ois != null) {
                    ois.close();
                }
            } catch (IOException ex) { ex.printStackTrace(); }
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLogOut;
    private javax.swing.JButton btnLoginEnter;
    private javax.swing.JButton btnLoginExit;
    private javax.swing.JButton btnMCAdd;
    private javax.swing.JButton btnMCClear;
    private javax.swing.JButton btnMCDelete;
    private javax.swing.JButton btnMCEdit;
    private javax.swing.JButton btnMCSearch;
    private javax.swing.JButton btnMOAdd;
    private javax.swing.JButton btnMOCancel;
    private javax.swing.JButton btnMOCheckOut;
    private javax.swing.JButton btnMOOrderSearch;
    private javax.swing.JButton btnMPAdd;
    private javax.swing.JButton btnMPClear;
    private javax.swing.JButton btnMPDelete;
    private javax.swing.JButton btnMPEdit;
    private javax.swing.JButton btnMPSearch;
    private javax.swing.JButton btnTerminalMode;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTabbedPane jTabbedPane3;
    private javax.swing.JTabbedPane jTabbedPane4;
    private javax.swing.JLabel labelLoginMessage;
    private javax.swing.JTabbedPane loginLogin;
    private javax.swing.JTabbedPane mainMenu;
    private javax.swing.JRadioButton rbMPFragile;
    private javax.swing.JRadioButton rbMPNonFragile;
    private javax.swing.JTable tableMC;
    private javax.swing.JTable tableMO;
    private javax.swing.JTable tableMP;
    private javax.swing.JTextField txtLoginID;
    private javax.swing.JTextField txtLoginPass;
    private javax.swing.JTextField txtMCCusAddress;
    private javax.swing.JTextField txtMCCusContact;
    private javax.swing.JTextField txtMCCusDate;
    private javax.swing.JTextField txtMCCusID;
    private javax.swing.JTextField txtMCCusName;
    private javax.swing.JTextField txtMCCusPass;
    private javax.swing.JTextField txtMCCusSearchID;
    private javax.swing.JTextField txtMCCusType;
    private javax.swing.JTextField txtMOOrderCusID;
    private javax.swing.JTextField txtMOOrderDate;
    private javax.swing.JTextField txtMOOrderFragieRate;
    private javax.swing.JTextField txtMOOrderID;
    private javax.swing.JTextField txtMOOrderTotalAmount;
    private javax.swing.JTextField txtMOOrderTotalFragile;
    private javax.swing.JTextField txtMOOrderTotalPrice;
    private javax.swing.JTextField txtMOQuantity;
    private javax.swing.JTextField txtMOSearchID;
    private javax.swing.JTextField txtMPProductDate;
    private javax.swing.JTextField txtMPProductID;
    private javax.swing.JTextField txtMPProductName;
    private javax.swing.JTextField txtMPProductPrice;
    private javax.swing.JTextField txtMPProductSearchID;
    // End of variables declaration//GEN-END:variables
}
