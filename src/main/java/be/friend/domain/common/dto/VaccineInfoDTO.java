package be.friend.domain.common.dto;

import lombok.*;

@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class VaccineInfoDTO {

    private String oid;
    private String name;
    private String description;
    private String priority;
    private int vaccinationCount;
}
