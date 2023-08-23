package com.hritvik.SunbaseDataAssignment.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class LoginDto {

      private String login_id;
      private String  password;
}
