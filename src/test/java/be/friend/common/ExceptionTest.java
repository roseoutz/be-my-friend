package be.friend.common;

import be.friend.domain.common.exception.BaseException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ExceptionTest {

    @Test
    void test_base_exception() {
        assertThrows(BaseException.class, () -> {
            throw new BaseException("error.undefined");
        });
    }
}
