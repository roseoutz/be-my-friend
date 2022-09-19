package be.friend.domain.common.dto;

import lombok.*;

import java.util.List;

@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class FriendMedicalInfoDTO {

    private String oid;
    private List<FriendVaccinationDTO> friendVaccinations;
}
