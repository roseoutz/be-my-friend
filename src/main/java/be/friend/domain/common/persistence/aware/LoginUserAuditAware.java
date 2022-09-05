package be.friend.domain.common.persistence.aware;

import org.springframework.data.domain.AuditorAware;

import java.util.Optional;

public class LoginUserAuditAware implements AuditorAware<String> {
    @Override
    public Optional<String> getCurrentAuditor() {
        // Todo: Security context에서 사용자 ID를 가져오자
        return Optional.empty();
    }
}
