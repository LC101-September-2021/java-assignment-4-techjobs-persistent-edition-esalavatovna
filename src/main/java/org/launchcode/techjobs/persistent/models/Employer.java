package org.launchcode.techjobs.persistent.models;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Employer extends AbstractEntity {
    @OneToMany
    @JoinColumn(name= "employer_id")
    private List<Job> jobs = new ArrayList<>();

    @NotBlank(message = "Location is required")
    @Size(min=3, max=50, message="Name must be between 3 and 50 characters")
    private String location;

    public Employer() {
    }

    public Employer(String aLocation) {
        super();
        this.location = aLocation;

    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;


    }
}
