package ru.vsu.cs.roshchupkin_ya_a.view;

import com.intellij.uiDesigner.core.GridConstraints;
import com.intellij.uiDesigner.core.GridLayoutManager;
import com.intellij.uiDesigner.core.Spacer;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class MainFrame extends JFrame {
    private JPanel mainPanel;
    private JTable gamefieldTable;
    private JPanel controlsPanel;
    private JTextField gamefieldTextField;
    private JButton button1;
    private JScrollPane gamefieldScrollPane;

    public MainFrame() {
        this.setTitle("Tanks");
        this.setSize(Toolkit.getDefaultToolkit().getScreenSize());
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setContentPane(mainPanel);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setVisible(true);
        setupTable();
    }

    private void setupTable() {
        gamefieldTable.setFont(new Font("Serif", Font.BOLD, 25));
        gamefieldTable.setRowHeight(30);
        //gamefieldTable.wi
        DefaultTableCellRenderer renderer = new DefaultTableCellRenderer();
        renderer.setHorizontalAlignment(SwingConstants.CENTER);
        renderer.setVerticalAlignment(SwingConstants.CENTER);
        gamefieldTable.setDefaultRenderer(Object.class, renderer);
        gamefieldTable.setCellSelectionEnabled(false);
        gamefieldTable.setColumnSelectionAllowed(false);
        gamefieldTable.setRowSelectionAllowed(false);
        gamefieldTable.getTableHeader().setUI(null);
        gamefieldTable.setFocusable(false);
    }

    public void setModel(String[][] gameField) {
        DefaultTableModel model = new DefaultTableModel(gameField, new String[gameField[0].length]) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        gamefieldTable.setModel(model);

    }

    {
// GUI initializer generated by IntelliJ IDEA GUI Designer
// >>> IMPORTANT!! <<<
// DO NOT EDIT OR ADD ANY CODE HERE!
        $$$setupUI$$$();
    }

    /**
     * Method generated by IntelliJ IDEA GUI Designer
     * >>> IMPORTANT!! <<<
     * DO NOT edit this method OR call it in your code!
     *
     * @noinspection ALL
     */
    private void $$$setupUI$$$() {
        mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayoutManager(1, 2, new Insets(0, 0, 0, 0), -1, -1));
        controlsPanel = new JPanel();
        controlsPanel.setLayout(new GridLayoutManager(3, 2, new Insets(0, 0, 0, 2), -1, -1));
        mainPanel.add(controlsPanel, new GridConstraints(0, 1, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        gamefieldTextField = new JTextField();
        gamefieldTextField.setText("");
        controlsPanel.add(gamefieldTextField, new GridConstraints(1, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        final Spacer spacer1 = new Spacer();
        controlsPanel.add(spacer1, new GridConstraints(2, 0, 1, 2, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_VERTICAL, 1, GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        button1 = new JButton();
        button1.setText("Button");
        controlsPanel.add(button1, new GridConstraints(1, 1, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label1 = new JLabel();
        label1.setText("Gamefield file");
        controlsPanel.add(label1, new GridConstraints(0, 0, 1, 2, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        gamefieldScrollPane = new JScrollPane();
        mainPanel.add(gamefieldScrollPane, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        gamefieldTable = new JTable();
        gamefieldTable.setCellSelectionEnabled(false);
        gamefieldScrollPane.setViewportView(gamefieldTable);
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return mainPanel;
    }

}
