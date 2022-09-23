package be.friend.domain.adopt.service.impl;

import be.friend.domain.adopt.persistence.service.BreederPersistenceService;
import be.friend.domain.adopt.service.BreederService;
import be.friend.domain.common.dto.BreederDTO;
import be.friend.domain.common.dto.SearchParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service("breederServiceImpl")
public class BreederServiceImpl implements BreederService {

    private final BreederPersistenceService breederPersistenceService;

    public BreederServiceImpl(BreederPersistenceService breederPersistenceService) {
        this.breederPersistenceService = breederPersistenceService;
    }

    @Override
    public BreederDTO add(BreederDTO breederDTO) {
        return null;
    }

    @Override
    public BreederDTO get(String oid) {
        return null;
    }

    @Override
    public BreederDTO update(BreederDTO breederDTO) {
        return null;
    }

    @Override
    public void delete(BreederDTO breederDTO) {

    }

    @Override
    public void deleteById(String oid) {

    }

    @Override
    public List<BreederDTO> list(SearchParam searchParam) {
        return null;
    }
}
