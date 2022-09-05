package be.friend.domain.common.dto;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
public class BreederDTO {

    private String oid;
    private String name;
    private String mobileContact;
    private String homeContact;
    private String address;
    private String snsAddress;
    private String imageUrl;
    private List<BreederCertificationDTO> certificationDTOS;
    private List<FriendDTO> friendDTOS;
    private ManagerDTO managerDTO;
}
