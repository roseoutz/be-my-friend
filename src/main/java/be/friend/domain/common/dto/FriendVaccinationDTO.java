package be.friend.domain.common.dto;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@Builder
public class FriendVaccinationDTO {

    private String oid;
    private VaccineInfoDTO vaccineInfo;
    private int vaccinationCount;
    private LocalDate lastVaccinationDate;
}
