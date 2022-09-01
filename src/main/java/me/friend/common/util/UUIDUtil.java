package me.friend.common.util;

import com.fasterxml.uuid.EthernetAddress;
import com.fasterxml.uuid.Generators;
import com.fasterxml.uuid.impl.TimeBasedGenerator;

import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.UUID;

public class UUIDUtil {

    private static final TimeBasedGenerator generator = Generators.timeBasedGenerator(EthernetAddress.fromInterface());

    private UUIDUtil() {}

    public static String UUID() {
        return toBase64Url(generator.generate());
    }

    private static String toBase64Url(UUID uuid) {
        return Base64.getUrlEncoder().encodeToString(uuid.toString().getBytes(StandardCharsets.UTF_8));
    }

}
