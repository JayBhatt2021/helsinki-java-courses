public interface Saveable {
    public abstract void save();

    public abstract void delete();

    public abstract void load(String address);
}
