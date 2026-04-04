package com.zorvyn.dhananjay.Pagination;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.Page;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PaginatedResponse<T> {
    private List<T> content;
    private int pageNumber;      // 1‑based
    private int pageSize;
    private long totalElements;
    private int totalPages;
    private boolean last;
    private boolean empty;
    private boolean first;

    public static <T> PaginatedResponse<T> from(Page<T> page) {
        PaginatedResponse<T> response = new PaginatedResponse<>();
        response.setContent(page.getContent());
        response.setPageNumber(page.getNumber() + 1);  // convert to 1‑based
        response.setPageSize(page.getSize());
        response.setTotalElements(page.getTotalElements());
        response.setTotalPages(page.getTotalPages());
        response.setLast(page.isLast());
        response.setFirst(page.isFirst());
        response.setEmpty(page.isEmpty());
        return response;
    }

    // For in-memory pagination (e.g. AR Aging, AP Aging)
    public static <T> PaginatedResponse<T> fromManual(List<T> pagedContent, int zeroBasedPage, int pageSize, long totalElements) {
        int totalPages = (pageSize > 0) ? (int) Math.ceil((double) totalElements / pageSize) : 1;
        PaginatedResponse<T> response = new PaginatedResponse<>();
        response.setContent(pagedContent);
        response.setPageNumber(zeroBasedPage + 1);   // 1-based
        response.setPageSize(pageSize);
        response.setTotalElements(totalElements);
        response.setTotalPages(totalPages);
        response.setFirst(zeroBasedPage == 0);
        response.setLast(zeroBasedPage >= totalPages - 1);
        response.setEmpty(pagedContent.isEmpty());
        return response;
    }
}
