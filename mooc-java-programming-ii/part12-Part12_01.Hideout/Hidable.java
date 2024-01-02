public interface Hidable<T> {
    public void putIntoHideout(T toHide);

    public T takeFromHideout();

    public boolean isInHideout();
}
