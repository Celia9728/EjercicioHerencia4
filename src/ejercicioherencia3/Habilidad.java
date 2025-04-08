package ejercicioherencia3;

public class Habilidad {

    String nombre;
    int nivelHabilidad;
    char tecla;
    private double costeMana;
    private double danoBasico;

    public Habilidad(String nombre, char tecla) {
        this.nombre = nombre;
        this.tecla = tecla;
        this.nivelHabilidad = 1;
        this.costeMana = calcularCosteMana();
        this.danoBasico = calcularDanoBasico();
    }

    public void subirNivel() {
        this.nivelHabilidad++;
        this.costeMana = calcularCosteMana();
        this.danoBasico = calcularDanoBasico();
    }

    // MEOTDO TOSTRING
    @Override
    public String toString() {
        String mensaje;
        mensaje = "Nombre: " + this.nombre + "\n";
        mensaje += "Tecla asignada: " + this.tecla + "\n";
        mensaje += "Coste de mana: " + this.costeMana + "\n";
        mensaje += "Daño basico: " + this.danoBasico + "\n";
        return mensaje;
    }

    // METODOS PARA USAR DENTRO DE LA CLASE
    private double calcularCosteMana() {
        return (random(0, 10) + (this.nivelHabilidad / 2));
    }

    private double calcularDanoBasico() {
        return random(5, 20) + (this.costeMana / 3);
    }

    public int random(int numero1, int numero2) {
        int random = numero1 + (int) (Math.random() * (numero2 - numero1 + 1));
        return random;
    }
}
