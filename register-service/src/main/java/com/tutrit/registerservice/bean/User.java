package com.tutrit.registerservice.bean;

import java.util.List;
import java.util.Objects;

/**
 * User is person who registers somewhere.
 */
public class User {
    private String name;
    private String surname;
    private List<Slot> slots;

    public User(String name, String surname, List<Slot> slots) {
        this.name = name;
        this.surname = surname;
        this.slots = slots;
    }

    public User(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public List<Slot> getSlots() {
        return slots;
    }

    public void setSlots(List<Slot> slots) {
        this.slots = slots;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        if (!Objects.equals(name, user.name)) return false;
        if (!Objects.equals(surname, user.surname)) return false;
        return Objects.equals(slots, user.slots);
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (surname != null ? surname.hashCode() : 0);
        result = 31 * result + (slots != null ? slots.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() +
                "{name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", slots=" + slots +
                '}';
    }
}
