package Modelo.clases.subClases;

import Modelo.Personaje;
import Modelo.clases.Bestia;

public class Orco extends Bestia {
    public Orco(String nombre, int vida, int armadura) {
        super(nombre, vida, armadura);
    }


    public void recibirDanio(int danio) {
        //reduce la armadura del oponente en un 10%
        int armaduraReducida = (int) (danio * 0.10);
        super.recibirDanio(danio - armaduraReducida);
    }
}
