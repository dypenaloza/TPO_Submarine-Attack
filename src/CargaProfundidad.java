import java.util.Random;

public class CargaProfundidad extends ObjetoJuego implements EntidadMovil {
    public static final int PROFUNDIDAD_EXPLOSION_MIN = 300;
    public static final int PROFUNDIDAD_EXPLOSION_MAX = 700;

    private static final Random RANDOM = new Random();

    private final double velocidadCaida;
    private final int profundidadExplosion;
    private boolean exploto = false;

    public CargaProfundidad(double x, double y, double velocidadCaida) {
        this(x, y, velocidadCaida,
                PROFUNDIDAD_EXPLOSION_MIN + RANDOM.nextInt(PROFUNDIDAD_EXPLOSION_MAX - PROFUNDIDAD_EXPLOSION_MIN + 1));
    }

    public CargaProfundidad(double x, double y, double velocidadCaida, int profundidadExplosion) {
        super(x, y);
        this.velocidadCaida = velocidadCaida;
        this.profundidadExplosion = profundidadExplosion;
    }

    @Override
    public void moverse() {
        if (exploto) {
            return;
        }
        double nuevaY = getPosicionY() + velocidadCaida;
        if (nuevaY >= profundidadExplosion) {
            nuevaY = profundidadExplosion;
            exploto = true;
        }
        setPosicionY(nuevaY);
    }

    public boolean exploto() {
        return exploto;
    }

    public int getProfundidadExplosion() {
        return profundidadExplosion;
    }

    public double getVelocidadCaida() {
        return velocidadCaida;
    }
}
