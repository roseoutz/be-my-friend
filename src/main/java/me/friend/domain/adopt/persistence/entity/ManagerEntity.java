package me.friend.domain.adopt.persistence.entity;

import lombok.Getter;
import lombok.Setter;
import me.friend.domain.common.persistence.entity.BaseEntity;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
@Table(
        name = "bmf_manager"
)
public class ManagerEntity extends BaseEntity {

    @Id
    private String oid;

    private String name;

    @OneToMany(mappedBy = "breeders", cascade = CascadeType.REMOVE)
    private List<BreederEntity> breeders;
}
