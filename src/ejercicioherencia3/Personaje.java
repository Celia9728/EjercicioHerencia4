package ejercicioherencia3;

public class Personaje {

    // ATRIBUTOS
    protected String nombre;
    protected int posicionVertical;
    protected int posicionHorizontal;
    protected double puntosVida;
    protected double puntosEscudo;
    protected double puntosAtaque;

    // CONSTRUCTOR
    public Personaje(String nombre, int posicionVertical, int posicionHorizontal, double puntosVida, double puntosEscudo, double puntosAtaque) {
        this.nombre = nombre;
        this.posicionVertical = validarPosicion(this.posicionVertical, posicionVertical);
        this.posicionHorizontal = validarPosicion(this.posicionHorizontal, posicionHorizontal);
        this.puntosVida = puntosVida;
        this.puntosEscudo = puntosEscudo;
        this.puntosAtaque = puntosAtaque;
    }

    // SETTERS
    public String getNombre() {
        return this.nombre;
    }

    public int getPosicionVertical() {
        return this.posicionVertical;
    }

    public int getPosicionHorizontal() {
        return this.posicionHorizontal;
    }

    public double getPuntosVida() {
        return this.puntosVida;
    }

    public double getPuntosEscudo() {
        return this.puntosEscudo;
    }

    public double getPuntosAtaque() {
        return this.puntosAtaque;
    }
    
    
    // SETTERS
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPosicionVertical(int posicionVertical) {
        this.posicionVertical = posicionVertical;
    }

    public void setPosicionHorizontal(int posicionHorizontal) {
        this.posicionHorizontal = posicionHorizontal;
    }

    public void setPuntosVida(double puntosVida) {
        this.puntosVida = puntosVida;
    }

    public void setPuntosEscudo(double puntosEscudo) {
        this.puntosEscudo = puntosEscudo;
    }

    public void setPuntosAtaque(double puntosAtaque) {
        this.puntosAtaque = puntosAtaque;
    }
    
    // METODOS
    public void desplazarse(int x, int y) {
        this.posicionHorizontal = validarPosicion(this.posicionHorizontal, x);
        this.posicionVertical = validarPosicion(this.posicionVertical, y);
    }

    // METODOS PARA USAR DENTRO DE LA CLASE
    private int validarPosicion(int posicion, int nuevo) {
        int nuevaPosicion = posicion + nuevo;
        posicion = (nuevaPosicion < 0) ? 0 : nuevaPosicion;
        return posicion;
    }

    // METODO TOSTRING
    @Override
    public String toString() {
        String mensaje;
        mensaje = "Nombre: " + this.nombre + "\n";
        mensaje += "Posicion vertical: " + this.posicionVertical + "\n";
        mensaje += "Posicion horizontal: " + this.posicionHorizontal + "\n";
        mensaje += "Puntos de vida: " + this.puntosVida + "\n";
        mensaje += "Puntos de ataque: " + this.puntosAtaque + "\n";
        mensaje += "Puntos de escudo: " + this.puntosEscudo + "\n";
        return mensaje;
    }
    
    public int random(int numero1, int numero2) {
        int random = numero1 + (int) (Math.random() * ( numero2 - numero1 + 1));
        return random;
    }
}
