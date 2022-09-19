package be.friend.domain.common.dto;

import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

@Getter
public class SearchParam {

    private final int pagePerSize;
    private final int currentPage;
    private final Map<String, Object> searchKeyword;

    private SearchParam(Builder builder) {
        this.pagePerSize = builder.pagePerSize;
        this.currentPage = builder.currentPage;
        this.searchKeyword = Map.copyOf(builder.searchKeyword);
    }

    public static class Builder {
        private Builder() {}

        private int pagePerSize;
        private int currentPage;
        private Map<String, Object> searchKeyword = new HashMap<>();

        public Builder pagePerSize(int pagePerSize) {
            this.pagePerSize = pagePerSize;
            return this;
        }

        public Builder currentPage(int currentPage) {
            this.currentPage = currentPage;
            return this;
        }

        public Builder searchKeyword(String key, Object value) {
            this.searchKeyword.put(key, value);
            return this;
        }

        public SearchParam build() {
            return new SearchParam(this);
        }

    }
}
