package be.friend.domain.common.dto;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Builder
public class BreederCertificationDTO {

    private String oid;
    private String certificationNumber;
    private LocalDateTime acquisitionDate;
    private CertificationTypeDTO certificationTypeDTO;
    private BreederDTO breederDTO;
}
