/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author JayBh
 */
public interface Saveable {
    public abstract void save();
    public abstract void delete();
    public abstract void load(String address);
}
