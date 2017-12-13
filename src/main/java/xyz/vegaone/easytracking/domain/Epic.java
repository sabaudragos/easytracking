package xyz.vegaone.easytracking.domain;

import lombok.Getter;
import lombok.Setter;
import xyz.vegaone.easytracking.utils.Status;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
public class Epic {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "status")
    private Status status;

    @Column(name = "sprint")
    @ManyToOne
    private Sprint sprint;

    @Column(name = "feature")
    @OneToMany(mappedBy = "epic")
    private List<Feature> features;

    @Override
    public String toString() {
        return "Epic{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", status=" + status +
                ", sprint=" + sprint +
                ", features=" + features +
                '}';
    }
}