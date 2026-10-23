public class Submarino extends ObjetoJuego {
    public static final int PROFUNDIDAD_MIN = 300;
    public static final int PROFUNDIDAD_MAX = 800;
    public static final int SALUD_MAX = 100;
    public static final double VELOCIDAD = 10;

    private int salud = SALUD_MAX;

    public Submarino(double x, double y) {
        super(x, acotarProfundidad(y));
    }

    public void subir() {
        setPosicionY(acotarProfundidad(getPosicionY() - VELOCIDAD));
    }

    public void bajar() {
        setPosicionY(acotarProfundidad(getPosicionY() + VELOCIDAD));
    }

    public void izquierda() {
        setPosicionX(getPosicionX() - VELOCIDAD);
    }

    public void derecha() {
        setPosicionX(getPosicionX() + VELOCIDAD);
    }

    public void recibirDanio(int porcentaje) {
        salud = Math.max(0, salud - porcentaje);
    }

    public boolean estaDestruido() {
        return salud == 0;
    }

    public void restaurarSalud() {
        salud = SALUD_MAX;
    }

    public int getSalud() {
        return salud;
    }

    private static double acotarProfundidad(double y) {
        return Math.max(PROFUNDIDAD_MIN, Math.min(PROFUNDIDAD_MAX, y));
    }
}
