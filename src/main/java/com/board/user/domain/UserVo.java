package com.board.user.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

// @Data: @Getter, @Setter, @ToString, @NoargsConstructor, @EqualsAndHashCode, @RequiredArgsConstructor
@Data
@AllArgsConstructor
public class UserVo {
	private String userid;
	private String passwd;
	private String username;
	private String email;
	private int    upoint;
	private String indate;
}
