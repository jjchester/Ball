/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Rectangle;

/**
 *
 * @author Justin
 */
public class movement {

    int nX = 50;
    int nY = 50;
    int nVy = 0;
    int nVx = 0;
    int nLives = 3;
    Boolean bDir = null;
    Main main;

    public void Move() {
        Edge(nX, nY);
        XY();
        nY += nVy;
        nX += nVx;
    }

    public int getX() {
        return nX;
    }

    public int getY() {
        return nY;
    }

    public void isHitBox(Rectangle rect, Rectangle[] box) {
        for (int i = 0; i < box.length; i++) {
            if (rect.overlaps(box[i])) {
                restart();
                break;
            }
        }
    }

    public void isHitBar(Rectangle r1, Rectangle r2) {
        if (r1.overlaps(r2)){
            restart();
        }
    }

    private void Edge(int nX, int nY) {
        if (nX <= 0 || nX + 16 >= Gdx.graphics.getWidth() || nY <= 0 || nY + 16 >= Gdx.graphics.getHeight()) {
            restart();

        }
//        if (nX <= 0) {
//            nX += 20;
//            nVx = 0;
//            nVy = 0;
//        } else if (nX + 16 >= Gdx.graphics.getWidth()) {
//            nX -= 20;
//            nVx = 0;
//            nVy = 0;
//        } else if (nY <= 0) {
//            nY += 20;
//            nVx = 0;
//            nVy = 0;
//        } else if (nY + 16 >= Gdx.graphics.getHeight()) {
//            nY-=20;
//            nVx = 0;
//            nVy = 0;
//        }
    }

    private void restart() {
        nLives--;
        nVy = 0;
        nVx = 0;
        nX = 100;
        nY = 100;
    }

    private void XY() {
        if (Gdx.input.isKeyJustPressed(Keys.UP)) {
            nVy = 5;
            nVx = 0;
        } else if (Gdx.input.isKeyJustPressed(Keys.DOWN)) {
            nVy = -5;
            nVx = 0;
        } else if (Gdx.input.isKeyJustPressed(Keys.RIGHT)) {
            nVy = 0;
            nVx = 5;
        } else if (Gdx.input.isKeyJustPressed(Keys.LEFT)) {
            nVy = 0;
            nVx = -5;
        }
    }
}
