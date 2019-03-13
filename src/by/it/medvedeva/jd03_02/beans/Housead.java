package by.it.medvedeva.jd03_02.beans;

import java.util.Objects;

public class Housead {

        private int id;
        private String description;
        private String adress;
        private int floors;
        private double groundsquare;
        private int rooms;
        private double price;
        private int users_id;

        public int getId() {
                return id;
        }

        public void setId(int id) {
                this.id = id;
        }

        public String getDescription() {
                return description;
        }

        public void setDescription(String description) {
                this.description = description;
        }

        public String getAdress() {
                return adress;
        }

        public void setAdress(String adress) {
                this.adress = adress;
        }

        public int getFloors() {
                return floors;
        }

        public void setFloors(int floors) {
                this.floors = floors;
        }

        public double getGroundsquare() {
                return groundsquare;
        }

        public void setGroundsquare(double groundsquare) {
                this.groundsquare = groundsquare;
        }

        public int getRooms() {
                return rooms;
        }

        public void setRooms(int rooms) {
                this.rooms = rooms;
        }

        public double getPrice() {
                return price;
        }

        public void setPrice(double price) {
                this.price = price;
        }

        public int getUsers_id() {
                return users_id;
        }

        public void setUsers_id(int users_id) {
                this.users_id = users_id;
        }

        @Override
        public boolean equals(Object o) {
                if (this == o) return true;
                if (o == null || getClass() != o.getClass()) return false;
                Housead housead = (Housead) o;
                return id == housead.id &&
                        floors == housead.floors &&
                        Double.compare(housead.groundsquare, groundsquare) == 0 &&
                        rooms == housead.rooms &&
                        Double.compare(housead.price, price) == 0 &&
                        users_id == housead.users_id &&
                        Objects.equals(description, housead.description) &&
                        Objects.equals(adress, housead.adress);
        }

        @Override
        public int hashCode() {
                return Objects.hash(id, description, adress, floors, groundsquare, rooms, price, users_id);
        }

        public Housead(int id, String description, String adress, int floors, double groundsquare, int rooms, double price, int users_id) {
                this.id = id;
                this.description = description;
                this.adress = adress;
                this.floors = floors;
                this.groundsquare = groundsquare;
                this.rooms = rooms;
                this.price = price;
                this.users_id = users_id;
        }

        public Housead() {
        }

        @Override
        public String toString() {
                return "Housead{" +
                        "id=" + id +
                        ", description='" + description + '\'' +
                        ", adress='" + adress + '\'' +
                        ", floors=" + floors +
                        ", groundsquare=" + groundsquare +
                        ", rooms=" + rooms +
                        ", price=" + price +
                        ", users_id=" + users_id +
                        '}';
        }
}
