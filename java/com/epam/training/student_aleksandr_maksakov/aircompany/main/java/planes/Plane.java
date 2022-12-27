package planes;

import java.util.Objects;

abstract public class Plane {
    String planeModel;
    private final int maxSpeed;
    private final int maxFlightDistance;
    private final int maxLoadCapacity;

    public Plane(String planeModel, int maxSpeed, int maxFlightDistance, int maxLoadCapacity) {
        this.planeModel = planeModel;
        this.maxSpeed = maxSpeed;
        this.maxFlightDistance = maxFlightDistance;
        this.maxLoadCapacity = maxLoadCapacity;
    }

    public String getPlaneModel() {
        return planeModel;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public int getMaxFlightDistance() {
        return maxFlightDistance;
    }

    public int getMinLoadCapacity() {
        return this.maxLoadCapacity;
    }

    @Override
    public String toString() {
        return "Plane{" +
                "model='" + planeModel + '\'' +
                ", maxSpeed=" + maxSpeed +
                ", maxFlightDistance=" + maxFlightDistance +
                ", maxLoadCapacity=" + maxLoadCapacity +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Plane)) return false;
        return maxSpeed == ((Plane) o).maxSpeed &&
                maxFlightDistance == ((Plane) o).maxFlightDistance &&
                maxLoadCapacity == ((Plane) o).maxLoadCapacity &&
                Objects.equals(planeModel, ((Plane) o).planeModel);
    }

    @Override
    public int hashCode() {
        return Objects.hash(planeModel, maxSpeed, maxFlightDistance, maxLoadCapacity);
    }
}
