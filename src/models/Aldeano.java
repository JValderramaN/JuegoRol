/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

public class Aldeano extends Personaje {

    public static final int ataqueAldeanoBase = 5;

    private boolean berserker = false;

    public Aldeano(int pt_vida, int pt_ataque, String nombre) {
        super(pt_vida, pt_ataque, nombre);
    }

    public Aldeano(String nombre) {
        super(Personaje.vidaMax, ataqueAldeanoBase, nombre);
    }

    @Override
    public void setPt_vida(int pt_vida) {
        super.setPt_vida(pt_vida);

        //modo berserker
        if (this.getPt_vida() > 0 && this.getPt_vida() <= 20 && !berserker) {
            this.setPt_ataque(this.getPt_ataque() * 8);
            this.berserker = true;
        }

    }

}
