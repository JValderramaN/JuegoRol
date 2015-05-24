/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.util.Random;

/**
 *
 * @author eduardo
 */
public class Paladin extends Personaje {

    //probabilidad de guillotina
    static public final int guillotinaProb = 5;
    public static final int ataquePaladinBase = 20;

    private boolean guillotina;

    public Paladin(int pt_vida, int pt_ataque, String nombre) {
        super(pt_vida, pt_ataque, nombre);
    }

    public Paladin(String nombre) {
        super(Personaje.vidaMax, ataquePaladinBase, nombre);
    }

    @Override
    public void atacar(Personaje objetivo) {

        if (objetivo != null && !objetivo.equals(this)) {
            Random rand = new Random();
            int randomNum = rand.nextInt((guillotinaProb - 1) + 1) + 1;
            //guillotina
            if (randomNum == guillotinaProb) {//randomNum == guillotinaProb
                objetivo.setPt_vida(0);
                this.setPt_vida(Math.round(this.getPt_vida() / 2));
                this.setGuillotina(true);
            } else {
                super.atacar(objetivo);
            }
        }
    }

    public boolean isGuillotina() {
        return guillotina;
    }

    public void setGuillotina(boolean guillotina) {
        this.guillotina = guillotina;
    }

}
