package be.friend.domain.common.dto;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
public class FriendMedicalInfoDTO {

    private String oid;
    private List<FriendVaccinationDTO> friendVaccinations;
}
