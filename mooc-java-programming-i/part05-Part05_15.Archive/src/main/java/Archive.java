/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author JayBh
 */
public class Archive {
    private String id;
    private String name;
    
    public Archive() {
        this("1", "lol");
    }
    
    public Archive(String id, String name) {
        this.id = id;
        this.name = name;
    }
    
    @Override
    public String toString() {
        return this.id + ": " + this.name;
    }
    
    @Override
    public boolean equals(Object compared) {
        if (this == compared) {
            return true;
        }
        if (!(compared instanceof Archive)) {
            return false;
        }
        Archive comparedArchive = (Archive) compared;
        return this.id.equals(comparedArchive.id);
    }
}
