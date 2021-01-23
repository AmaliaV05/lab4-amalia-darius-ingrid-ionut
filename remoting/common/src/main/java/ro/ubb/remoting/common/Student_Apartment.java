package ro.ubb.remoting.common;

import java.io.Serializable;

public class Student_Apartment implements Serializable {

    private Long id;
    private Long idStudent;
    private Long idApartment;

    public Student_Apartment(Long id, Long idStudent, Long idApartment) {
        this.id = id;
        this.idStudent = idStudent;
        this.idApartment = idApartment;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdStudent() {
        return idStudent;
    }

    public void setIdStudent(Long idStudent) {
        this.idStudent = idStudent;
    }

    public Long getIdApartment() {
        return idApartment;
    }

    public void setIdApartment(Long idApartment) {
        this.idApartment = idApartment;
    }

    @Override
    public String toString() {
        return "Student_Apartment{" +
                "id=" + id +
                ", idStudent=" + idStudent +
                ", idApartment=" + idApartment +
                '}';
    }
}
