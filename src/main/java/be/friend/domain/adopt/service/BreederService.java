package be.friend.domain.adopt.service;

import be.friend.domain.common.dto.BreederDTO;
import be.friend.domain.common.dto.SearchParam;

import java.util.List;

public interface BreederService {

    /**
     *
     * @param breederDTO
     */
    BreederDTO add(BreederDTO breederDTO);

    /**
     *
     * @param oid
     */
    BreederDTO get(String oid);

    /**
     *
     * @param breederDTO
     */
    BreederDTO update(BreederDTO breederDTO);

    /**
     *
     * @param breederDTO
     */
    void delete(BreederDTO breederDTO);

    /**
     *
     * @param oid
     */
    void deleteById(String oid);

    /**
     *
     * @param searchParam
     */
    List<BreederDTO> list(SearchParam searchParam);

}
