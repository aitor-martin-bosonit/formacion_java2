package Modelo.clases.subClases;

import Modelo.Personaje;
import Modelo.clases.Heroe;

public class Hobbit extends Heroe {
    public Hobbit(String nombre, int vida, int armadura) {
        super(nombre, vida, armadura);
    }


    public void atacar(Personaje objetivo) {

        int dado1 = (int) (Math.random() * 101);
        int dado2 = (int) (Math.random() * 101);


        int valorAtaque = Math.max(dado1, dado2) - 5;

        //comprobamos si el objetivo es un trasgo y ajusta el valor de ataque
        if (objetivo instanceof Trasgo) {
            // No permitas que el valor de ataque sea negativo
            valorAtaque = Math.max(valorAtaque, 0);
        }

        //comprobamos si el valor de ataque supera la armadura del objetivo
        if (valorAtaque > objetivo.getArmadura()) {
            int danio = valorAtaque - objetivo.getArmadura();
            objetivo.recibirDanio(danio);
            //actualiza el valor de ataque del hobbit
            setAtaque(danio);
        }
    }
}
