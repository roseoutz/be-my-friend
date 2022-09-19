package be.friend.common;

import be.friend.common.util.UUIDUtil;
import be.friend.domain.adopt.persistence.entity.FriendEntity;
import be.friend.domain.common.dto.FriendDTO;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ObjectMapperTest {

    private ObjectMapper getObjectMapper() {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
        objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        objectMapper.registerModule(new JavaTimeModule());
        objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);

        return objectMapper;
    }

    private Class<FriendDTO> getDtoClass() {
        return FriendDTO.class;
    }

    private Class<FriendEntity> getEntityClass() {
        return FriendEntity.class;
    }

    private FriendDTO convertToDTO(FriendEntity entity) {
        return getObjectMapper().convertValue(entity, getDtoClass());
    }

    private FriendEntity convertToEntity(FriendDTO dto) {
        return getObjectMapper().convertValue(dto, getEntityClass());
    }

    @Test
    void test_convert_to_entity() {
        FriendDTO friendDTO = FriendDTO.builder()
                .oid(UUIDUtil.UUID())
                .build();

        FriendEntity entity = convertToEntity(friendDTO);

        assertEquals(friendDTO.getOid(), entity.getOid());
    }

    @Test
    void test_convert_to_dto() {
        FriendEntity entity = new FriendEntity();
        entity.setOid(UUIDUtil.UUID());

        FriendDTO dto = convertToDTO(entity);

        assertEquals(entity.getOid(), dto.getOid());
    }

}
