/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author JayBh
 */
import java.util.HashMap;
import java.util.ArrayList;

public class VehicleRegistry {
    private HashMap<LicensePlate, String> reg;
    
    public VehicleRegistry() {
        this.reg = new HashMap<>();
    }
    
    public boolean add(LicensePlate licensePlate, String owner) {
        if (this.reg.get(licensePlate) == null) {
            this.reg.put(licensePlate, owner);
            return true;
        } else {
            return false;
        }
    }
    
    public String get(LicensePlate licensePlate) {
        return this.reg.get(licensePlate);
    }
    
    public boolean remove(LicensePlate licensePlate) {
        if (this.reg.get(licensePlate) != null) {
            this.reg.remove(licensePlate);
            return true;
        } else {
            return false;
        }
    }
    
    public void printLicensePlates() {
        for (LicensePlate l : this.reg.keySet()) {
            System.out.println(l);
        }
    }
    
    public void printOwners() {
        ArrayList<String> previousOwners = new ArrayList<>();
        for (String o : this.reg.values()) {
            if (previousOwners.contains(o)) {
                continue;
            }
            
            System.out.println(o);
            previousOwners.add(o);
        }
    }
}
