package be.friend.domain.common.dto;

import lombok.*;

import java.time.LocalDate;

@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class BreederCertificationDTO {

    private String oid;
    private String certificationNumber;
    private LocalDate acquisitionDate;
    private CertificationTypeDTO certificationType;
}
