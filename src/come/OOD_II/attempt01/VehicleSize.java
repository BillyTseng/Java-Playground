package come.OOD_II.attempt01;

public enum VehicleSize {
    Compact(1), Large(2);

    private final int size;
    VehicleSize(int size) {
        this.size = size;
    }
    public int getValue() {
        return size;
    }
}
