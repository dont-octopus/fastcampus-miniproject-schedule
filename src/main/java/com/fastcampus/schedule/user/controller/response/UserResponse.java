package com.fastcampus.schedule.user.controller.response;

import com.fastcampus.schedule.user.constant.Role;
import com.fastcampus.schedule.user.domain.User;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder
public class UserResponse {

	private String email;
	private String userName;
	private String phoneNumber;
	private Role role;
	private Integer vacationCount;

	public static UserResponse fromEntity(User user) {
		return UserResponse.builder()
						   .email(user.getEmail())
						   .userName(user.getUsername())
						   .phoneNumber(user.getPhoneNumber())
						   .role(user.getRole())
						   .vacationCount(user.getVacationCount())
						   .build();
	}
}
