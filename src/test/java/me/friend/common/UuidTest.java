package me.friend.common;

import com.fasterxml.uuid.EthernetAddress;
import com.fasterxml.uuid.Generators;
import com.fasterxml.uuid.impl.TimeBasedGenerator;
import me.friend.common.util.UUIDUtil;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

public class UuidTest {

    @Test
    void test_time_base_uuid_gen() {
        UUID timeBaseUid = Generators.timeBasedGenerator().generate();
        UUID timeBaseUid2 = Generators.timeBasedGenerator().generate();

        assertNotEquals(timeBaseUid, timeBaseUid2);
    }

    @Test
    void test_random_base_uuid_gen() {
        UUID randomBaseUid = Generators.randomBasedGenerator().generate();
        UUID randomBaseUid2 = Generators.randomBasedGenerator().generate();

        assertNotEquals(randomBaseUid, randomBaseUid2);
    }

    @Test
    void test_random_by_ethernet_uuid_gen() {
        TimeBasedGenerator generator = Generators.timeBasedGenerator(EthernetAddress.fromInterface());

        UUID randomBaseUid = generator.generate();
        UUID randomBaseUid2 = generator.generate();

        assertNotEquals(randomBaseUid, randomBaseUid2);

    }

    @Test
    void test_uuid_util() {
        String uuid = UUIDUtil.UUID();
        String uuid2 = UUIDUtil.UUID();

        assertNotEquals(uuid, uuid2);
    }
}
