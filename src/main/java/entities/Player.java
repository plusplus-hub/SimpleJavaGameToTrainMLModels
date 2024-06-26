package entities;

import lombok.Getter;
import lombok.Setter;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

@Setter @Getter
public class Player implements KeyListener, Entity {

    private int x, y;
    @Getter
    private boolean finished = false;
    private int dx, dy;
    private int prevX, prevY;
    private int coinsCollected = 0;
    private int playerDeaths = 0;
    private final int width = 20, height = 20;

    public Player(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Player() {
        this(0, 0);
    }

    public void move() {
        prevX = x;
        prevY = y;
        x += dx;
        y += dy;
    }

    public void undoMove() {
        x = prevX;
        y = prevY;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        if (key == KeyEvent.VK_LEFT) {
            dx = -2;
        } else if (key == KeyEvent.VK_RIGHT) {
            dx = 2;
        } else if (key == KeyEvent.VK_UP) {
            dy = -2;
        } else if (key == KeyEvent.VK_DOWN) {
            dy = 2;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();
        if (key == KeyEvent.VK_LEFT || key == KeyEvent.VK_RIGHT) {
            dx = 0;
        } else if (key == KeyEvent.VK_UP || key == KeyEvent.VK_DOWN) {
            dy = 0;
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {}

    @Override
    public Rectangle getBounds() {
        return new Rectangle(x, y, width, height);
    }

    public void respawn(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void incrementPlayerDeaths() {
        playerDeaths++;
        System.out.println("Player deaths: " + playerDeaths);
    }

    public void incrementCoinsCollected() {
        coinsCollected++;
        System.out.println("Coins collected: " + coinsCollected);
    }
}