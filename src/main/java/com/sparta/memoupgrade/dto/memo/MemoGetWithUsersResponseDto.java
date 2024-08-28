package com.sparta.memoupgrade.dto.memo;

import com.sparta.memoupgrade.entity.Draft;
import com.sparta.memoupgrade.entity.Memo;
import com.sparta.memoupgrade.entity.User;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Getter
public class MemoGetWithUsersResponseDto {
    private Long id;
    private String writer;
    private String title;
    private String memoContents;
    private Long commentCount;
    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;
    private List<ManagerUserDto> userIds;

    public MemoGetWithUsersResponseDto(Memo memo) {
        this.writer = memo.getWriter().getName();
        this.id = memo.getId();
        this.title = memo.getTitle();
        this.memoContents = memo.getMemoContents();
        this.commentCount = (long) memo.getCommentList().size();
        this.createdAt = memo.getCreatedAt();
        this.modifiedAt = memo.getModifiedAt();
        this.userIds = memo.getDraftList().stream().
                map(draft -> new ManagerUserDto(draft.getManagerUser())).collect(Collectors.toList());
    }
    @Getter
    public static class ManagerUserDto {
        private Long id;
        private String name;
        private String email;

        public ManagerUserDto(User user) {
            this.id = user.getId();
            this.name = user.getName();
            this.email = user.getEmail();
        }
    }
}
