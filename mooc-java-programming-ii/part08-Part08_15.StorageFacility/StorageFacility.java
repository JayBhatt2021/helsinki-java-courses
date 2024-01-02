import java.util.ArrayList;
import java.util.HashMap;

public class StorageFacility {
    private HashMap<String, ArrayList<String>> dict;

    public StorageFacility() {
        this.dict = new HashMap<>();
    }

    public void add(String unit, String item) {
        if (this.dict.get(unit) == null) {
            this.dict.put(unit, new ArrayList<>());
        }

        this.dict.get(unit).add(item);
    }

    public ArrayList<String> contents(String storageUnit) {
        if (this.dict.get(storageUnit) == null) {
            return new ArrayList<>();
        }

        return this.dict.get(storageUnit);
    }

    public void remove(String storageUnit, String item) {
        if (this.dict.get(storageUnit).size() == 1) {
            this.dict.remove(storageUnit);
            return;
        }

        this.dict.get(storageUnit).remove(item);
    }

    public ArrayList<String> storageUnits() {
        ArrayList<String> storageUnitsWithItems = new ArrayList<>();

        for (String unit : this.dict.keySet()) {
            if (this.dict.get(unit).isEmpty()) {
                continue;
            }
            storageUnitsWithItems.add(unit);
        }

        return storageUnitsWithItems;
    }
}
