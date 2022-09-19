package be.friend.domain.common.dto;

import lombok.*;

@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class CertificationTypeDTO {

    private String oid;
    private String certificationType;
    private String description;
    private CertificationAgencyDTO certificationAgency;
}
