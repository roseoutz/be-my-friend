package be.friend.domain.common.dto;

import be.friend.domain.common.dto.base.TimeBaseDTO;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;

@Getter
@SuperBuilder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class FriendDTO extends TimeBaseDTO {

    private String oid;
    private String type;
    private String breed;
    private String name;
    private BreederDTO breeder;
    private FriendMedicalInfoDTO friendMedicalInfo;
    private String imageUrl;
    private LocalDateTime birthdate;
    @Builder.Default
    private boolean adopted = false;

}
