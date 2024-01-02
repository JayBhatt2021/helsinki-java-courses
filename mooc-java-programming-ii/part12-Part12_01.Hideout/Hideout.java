public class Hideout<T> implements Hidable<T> {
    private T hiddenValue;

    public Hideout() {
        this.hiddenValue = null;
    }

    @Override
    public void putIntoHideout(T toHide) {
        this.hiddenValue = toHide;
    }

    @Override
    public T takeFromHideout() {
        T takenValue = this.hiddenValue;
        this.hiddenValue = null;

        return takenValue;
    }

    @Override
    public boolean isInHideout() {
        return this.hiddenValue != null;
    }
}
