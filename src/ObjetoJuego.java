public abstract class ObjetoJuego {
    private double posicionX;
    private double posicionY;

    protected ObjetoJuego(double x, double y) {
        this.posicionX = x;
        this.posicionY = y;
    }

    public double getPosicionX() {
        return posicionX;
    }

    public double getPosicionY() {
        return posicionY;
    }

    protected void setPosicionX(double posicionX) {
        this.posicionX = posicionX;
    }

    protected void setPosicionY(double posicionY) {
        this.posicionY = posicionY;
    }

    public double distanciaA(ObjetoJuego otro) {
        double dx = otro.posicionX - this.posicionX;
        double dy = otro.posicionY - this.posicionY;
        return Math.hypot(dx, dy);
    }
}
