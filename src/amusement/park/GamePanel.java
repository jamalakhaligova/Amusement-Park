package amusement.park;

import amusement.park.model.Guest;
import amusement.park.model.buildings.Path;
import amusement.park.model.buildings.games.FirstGame;
import amusement.park.model.buildings.games.SecondGame;
import amusement.park.model.buildings.games.ThirdGame;
import amusement.park.model.buildings.gardens.Grass;
import amusement.park.model.buildings.gardens.Shrub;
import amusement.park.model.buildings.gardens.Tree;
import amusement.park.model.buildings.restaurants.Buffet;
import amusement.park.model.buildings.restaurants.HotDogStand;
import amusement.park.model.buildings.restaurants.SweetShop;
import amusement.park.ui.BuildingItem;
import amusement.park.model.buildings.gardens.Trash;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import static amusement.park.GameGUI.SCREEN_SIZE;
import amusement.park.model.SecurityBuilding;
import amusement.park.model.buildings.ATM;
import amusement.park.model.buildings.gardens.TrashCan;
import java.awt.event.ActionEvent;

public class GamePanel extends JPanel {

    private BuildingItem selectedItem;
    private int fps;
    private CoinsPanel coinsPanel;
    private JButton startButton = new JButton("Start game");

    public GamePanel(int fps, CoinsPanel coinsPanel) {
        super();
        this.fps = fps;
        this.coinsPanel = coinsPanel;

        GameArea gameArea = new GameArea(this);
        gameArea.setBackground(new Color(0x76909F));

        setLayout(new BorderLayout());
        JPanel itemsPanel = new JPanel();
        itemsPanel.setBackground(Color.LIGHT_GRAY);
        itemsPanel.setPreferredSize(new Dimension(SCREEN_SIZE.width, 200));
        itemsPanel.setPreferredSize(new Dimension(SCREEN_SIZE.height, 250));
        itemsPanel.setLayout(new FlowLayout());
        itemsPanel.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);

        BuildingItem buildingItem1 = new BuildingItem(new FirstGame());
        buildingItem1.addActionListener(createItemClickedListener());
        BuildingItem buildingItem2 = new BuildingItem(new SecondGame());
        buildingItem2.addActionListener(createItemClickedListener());
        BuildingItem buildingItem3 = new BuildingItem(new ThirdGame());
        buildingItem3.addActionListener(createItemClickedListener());
        BuildingItem buildingItem5 = new BuildingItem(new Path(0, 0));
        buildingItem5.addActionListener(createItemClickedListener());
        BuildingItem buildingItem6 = new BuildingItem(new Grass());
        buildingItem6.addActionListener(createItemClickedListener());
        BuildingItem buildingItem7 = new BuildingItem(new Tree());
        buildingItem7.addActionListener(createItemClickedListener());
        BuildingItem buildingItem8 = new BuildingItem(new Shrub());
        buildingItem8.addActionListener(createItemClickedListener());
        BuildingItem buildingItem4 = new BuildingItem(new HotDogStand());
        buildingItem4.addActionListener(createItemClickedListener());
        BuildingItem buildingItem9 = new BuildingItem(new SweetShop());
        buildingItem9.addActionListener(createItemClickedListener());
        BuildingItem buildingItem10 = new BuildingItem(new Buffet());
        buildingItem10.addActionListener(createItemClickedListener());
        BuildingItem buildingItem11 = new BuildingItem(new ATM());
        buildingItem11.addActionListener(createItemClickedListener());
        BuildingItem buildingItem12 = new BuildingItem(new TrashCan());
        buildingItem12.addActionListener(createItemClickedListener());
        BuildingItem buildingItem13 = new BuildingItem(new SecurityBuilding());
        buildingItem13.addActionListener(createItemClickedListener());

        itemsPanel.add(buildingItem1);
        itemsPanel.add(buildingItem2);
        itemsPanel.add(buildingItem3);
        itemsPanel.add(buildingItem5);
        itemsPanel.add(buildingItem6);
        itemsPanel.add(buildingItem7);
        itemsPanel.add(buildingItem8);
        itemsPanel.add(buildingItem4);
        itemsPanel.add(buildingItem9);
        itemsPanel.add(buildingItem10);
        itemsPanel.add(buildingItem11);
        itemsPanel.add(buildingItem12);
        itemsPanel.add(buildingItem13);
        JPanel jPanel1 = new JPanel();
        jPanel1.setPreferredSize(new Dimension(200, SCREEN_SIZE.height));
        jPanel1.setBackground(new Color(0x76909F));
        jPanel1.add(startButton);
        JPanel jPanel2 = new JPanel();
        jPanel2.setPreferredSize(new Dimension(200, SCREEN_SIZE.height));
        jPanel2.setBackground(new Color(0x76909F));

        add(BorderLayout.EAST, jPanel1);
        add(BorderLayout.WEST, jPanel2);
        add(BorderLayout.CENTER, gameArea);
        add(BorderLayout.SOUTH, itemsPanel);
    }

    public int getFps() {
        return fps;
    }

    private int getPrice() {
        while (true) {
            try {
                String value = JOptionPane.showInputDialog(
                        GamePanel.this,
                        "Price of the building",
                        0
                );
                return Integer.parseInt(value);
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        }
    }

    public JButton getStartButton() {
        return this.startButton;
    }

    private ActionListener createItemClickedListener() {
        return e -> {
            selectedItem = (BuildingItem) e.getSource();
            if (!selectedItem.getBuilding().hasPrice()) {
                int buildingPrice = getPrice();
                selectedItem.getBuilding().setBuildingPrice(buildingPrice);
            }
        };
    }

    public boolean hasEnoughMoney() {
        return coinsPanel.hasEnoughMoney(getSelectedItem().getBuilding().getBuildingPrice());
    }

    public boolean buyBuilding() {
        return coinsPanel.decreaseCoins(getSelectedItem().getBuilding().getBuildingPrice());
    }

    public boolean payentrancefee(int val) {
        return coinsPanel.increaseCoins(val);
    }

    public BuildingItem getSelectedItem() {
        return selectedItem;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
    }
}
