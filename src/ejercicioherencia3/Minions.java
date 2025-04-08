package ejercicioherencia3;

public class Minions extends Personaje {

    // ATRIBUTOS
    private String tipo;

    // CONSTANTES
    static private final String[] listaTipos = {"Melee", "Mago", "Cañon"};

    public Minions(
            String nombre,
            int posicionVertical,
            int posicionHorizontal,
            double puntosVida,
            double puntosEscudo,
            double puntosAtaque,
            String tipo) {
        super(nombre, posicionVertical, posicionHorizontal, puntosVida, puntosEscudo, puntosAtaque);
        this.tipo = validarTipos(tipo);
        super.nombre = "minion";
        super.posicionVertical = super.random(400, 1520);
        super.posicionHorizontal = super.random(400, 1520);

        asignarAtributosPorTipo();
        
    }

    public void atacar(Campeon campeon) {
        super.puntosVida -= 5;
    }

    public void atacar(Minions minion) {
        if (super.puntosAtaque > minion.getPuntosEscudo()) {
            minion.setPuntosVida(minion.getPuntosVida() - 5);
        } else if (super.puntosAtaque < minion.getPuntosEscudo()) {
            super.puntosVida -= 5;
        } else {
            minion.setPuntosVida(minion.getPuntosVida() - 2);
            super.puntosVida -= 2;
        }
    }

    // VALIDACIONES
    private String validarTipos(String tipo) {
        for (int i = 0; i < this.listaTipos.length; i++) {
            if (tipo.equals(this.listaTipos[i])) {
                return tipo;
            }
        }
        return "Melee";
    }

    private void asignarAtributosPorTipo() {
        if (this.tipo.equalsIgnoreCase("Melee")) {
            super.puntosVida = 50;
            super.puntosEscudo = 10;
            super.puntosAtaque = 10;
        } else if (this.tipo.equalsIgnoreCase("Mago")) {
            super.puntosVida = 12;
            super.puntosEscudo = 40;
            super.puntosAtaque = 30;
        } else if (this.tipo.equalsIgnoreCase("Cañon")) {
            super.puntosVida = 75;
            super.puntosEscudo = 5;
            super.puntosAtaque = 25;
        }
    }
}
