package be.friend.domain.common.dto;

import lombok.*;

import java.time.LocalDate;

@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class FriendVaccinationDTO {

    private String oid;
    private VaccineInfoDTO vaccineInfo;
    private int vaccinationCount;
    private LocalDate lastVaccinationDate;
}
