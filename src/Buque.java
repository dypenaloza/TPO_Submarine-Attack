public class Buque extends ObjetoJuego implements EntidadMovil {
    public static final int PROFUNDIDAD = 0;

    private final boolean derecha;
    private double velocidad;
    private double velocidadCaidaCargas;

    public Buque(double x, boolean derecha, double velocidad, double velocidadCaidaCargas) {
        super(x, PROFUNDIDAD);
        this.derecha = derecha;
        this.velocidad = velocidad;
        this.velocidadCaidaCargas = velocidadCaidaCargas;
    }

    @Override
    public void moverse() {
        if (derecha) {
            setPosicionX(getPosicionX() + velocidad);
        } else {
            setPosicionX(getPosicionX() - velocidad);
        }
    }

    public CargaProfundidad lanzarCarga() {
        return new CargaProfundidad(getPosicionX(), getPosicionY(), velocidadCaidaCargas);
    }

    public void aumentarVelocidad(double factor) {
        velocidad *= factor;
        velocidadCaidaCargas *= factor;
    }

    public boolean salioDelCampo(double anchoCampo) {
        return getPosicionX() < 0 || getPosicionX() > anchoCampo;
    }

    public boolean isDerecha() {
        return derecha;
    }

    public double getVelocidad() {
        return velocidad;
    }

    public double getVelocidadCaidaCargas() {
        return velocidadCaidaCargas;
    }
}
