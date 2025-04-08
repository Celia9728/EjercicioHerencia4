package ejercicioherencia3;

public class Campeon extends Personaje {

    // ATRIBUTOS
    private double puntosMagia;
    private int nivel;
    private String rol;
    private int numeroHabilidadesCampeon;

    private Habilidad[] listaHabilidad = new Habilidad[4];

    // CONSTANTES
    static private final String[] listaRoles = {"Tanque", "Carry", "Support", "Mago", "Jungla"};

    // CONSTRUCTOR
    public Campeon(
            String nombre,
            int posicionVertical,
            int posicionHorizontal,
            double puntosVida,
            double puntosEscudo,
            double puntosAtaque,
            double puntosMagia,
            String rol,
            Habilidad habilidad) {
        super(nombre, posicionVertical, posicionHorizontal, puntosVida, puntosEscudo, puntosAtaque);
        super.nombre = "campeon";
        this.puntosMagia = puntosMagia;
        this.nivel = 1;
        this.rol = validarRol(rol);

        this.listaHabilidad[this.numeroHabilidadesCampeon] = habilidad;
        this.numeroHabilidadesCampeon++;

        super.posicionVertical = super.random(1000, 1920);
        super.posicionHorizontal = super.random(1000, 1920);

        asignarPuntos();
    }

    // GETTERS
    public int getNumeroHabilidadesCampeon() {
        return numeroHabilidadesCampeon;
    }

    public double getPuntosMagia() {
        return puntosMagia;
    }

    // SETTERS
    public void setNumeroHabilidadesCampeon(int numeroHabilidadesCampeon) {
        this.numeroHabilidadesCampeon = numeroHabilidadesCampeon;
    }

    public void setPuntosMagia(double puntosMagia) {
        this.puntosMagia = puntosMagia;
    }

    // METODOS
    public void subirNivel(Habilidad nueva) {
        this.nivel++;
        super.puntosVida += (super.random(1, 9));
        super.puntosEscudo += (super.random(1, 9) / 10);
        super.puntosAtaque += (super.random(1, 9) / 10);
        if (nivel == 4 || nivel == 6 || nivel == 8) {
            this.listaHabilidad[this.numeroHabilidadesCampeon] = nueva;
            this.numeroHabilidadesCampeon++;
        }
    }

    public void atacar(Minions minion) {
        minion.setPuntosVida(minion.getPuntosVida() - 5);
    }

    public void atacar(Campeon campeon2) {
        if (this.numeroHabilidadesCampeon > campeon2.getNumeroHabilidadesCampeon()) {
            campeon2.setPuntosVida(campeon2.getPuntosVida() - 5);
        } else if (this.numeroHabilidadesCampeon < campeon2.getNumeroHabilidadesCampeon()) {
            this.puntosVida -= 5;
        } else if (this.numeroHabilidadesCampeon == campeon2.getNumeroHabilidadesCampeon()) {
            if (this.puntosMagia > campeon2.getPuntosMagia()) {
                campeon2.setPuntosVida(campeon2.getPuntosVida() - 5);
            } else if (this.puntosMagia < campeon2.getPuntosMagia()) {
                super.puntosVida -= 5;
            } else if (this.puntosMagia == campeon2.getPuntosMagia()) {
                if (super.puntosAtaque > campeon2.getPuntosEscudo()) {
                    campeon2.setPuntosVida(campeon2.getPuntosVida() - 5);
                } else if (super.puntosAtaque < campeon2.getPuntosEscudo()) {
                    super.puntosVida -= 5;
                } else {
                    campeon2.setPuntosVida(campeon2.getPuntosVida() - 2);
                    super.puntosVida -= 2;
                }
            }
        }
    }

    // VALIDACIONES
    private String validarRol(String rol) {
        for (int i = 0; i < this.listaRoles.length; i++) {
            if (rol.equalsIgnoreCase(this.listaRoles[i])) {
                return rol;
            }
        }
        return "Carry";
    }

    private void asignarPuntos() {
        if (rol.equalsIgnoreCase("Tanque")) {
            super.puntosVida = 50;
            super.puntosEscudo = 12;
            super.puntosAtaque = 20;
            this.puntosMagia = 100;
        } else if (rol.equalsIgnoreCase("Carry")) {
            super.puntosVida = 15;
            super.puntosEscudo = 30;
            super.puntosAtaque = 40;
            this.puntosMagia = 300;
        } else if (rol.equalsIgnoreCase("Support")) {
            super.puntosVida = 70;
            super.puntosEscudo = 10;
            super.puntosAtaque = 30;
            this.puntosMagia = 300;
        } else if (rol.equalsIgnoreCase("Mago")) {
            super.puntosVida = 40;
            super.puntosEscudo = 20;
            super.puntosAtaque = 20;
            this.puntosMagia = 500;
        } else if (rol.equalsIgnoreCase("Jungla")) {
            super.puntosVida = 50;
            super.puntosEscudo = 10;
            super.puntosAtaque = 10;
            this.puntosMagia = 200;
        }
    }

}
