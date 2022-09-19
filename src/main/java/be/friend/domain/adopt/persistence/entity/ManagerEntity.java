package be.friend.domain.adopt.persistence.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import be.friend.domain.common.persistence.entity.TimeBaseEntity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table(
        name = "bmf_manager"
)
public class ManagerEntity extends TimeBaseEntity {

    @Id
    private String oid;

    private String name;

    @OneToMany(mappedBy = "oid", cascade = CascadeType.REMOVE)
    private List<BreederEntity> breeders;
}
