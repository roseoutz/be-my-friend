package be.friend.domain.common.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class CertificationAgencyDTO {

    private String oid;
    private String name;
    private String mobileContact;
    private String homeContact;
    private String address;
    private String homepage;
    private String businessNumber;
}
