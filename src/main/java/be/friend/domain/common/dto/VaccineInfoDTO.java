package be.friend.domain.common.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class VaccineInfoDTO {

    private String oid;
    private String name;
    private String description;
    private String priority;
    private int vaccinationCount;
}
