package be.friend.domain.common.dto;

import be.friend.domain.common.dto.base.TimeBaseDTO;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Getter
@SuperBuilder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class CertificationAgencyDTO extends TimeBaseDTO {

    private String oid;
    private String name;
    private String mobileContact;
    private String homeContact;
    private String address;
    private String homepage;
    private String businessNumber;
}
