package me.friend.domain.common.dto;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Builder
public class FriendVaccinationDTO {

    private String oid;
    private VaccineInfoDTO vaccineInfoDTO;
    private int vaccinationCount;
    private LocalDateTime lastVaccinationDate;
}
