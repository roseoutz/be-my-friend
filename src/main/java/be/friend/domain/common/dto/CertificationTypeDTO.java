package be.friend.domain.common.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class CertificationTypeDTO {

    private String oid;
    private String certificationType;
    private String description;
    private CertificationAgencyDTO certificationAgencyDTO;
}
