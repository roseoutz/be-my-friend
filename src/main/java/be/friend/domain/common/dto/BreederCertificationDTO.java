package be.friend.domain.common.dto;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@Builder
public class BreederCertificationDTO {

    private String oid;
    private String certificationNumber;
    private LocalDate acquisitionDate;
    private CertificationTypeDTO certificationType;
}
