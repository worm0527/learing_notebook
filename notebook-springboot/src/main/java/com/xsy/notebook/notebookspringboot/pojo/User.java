package com.xsy.notebook.notebookspringboot.pojo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class User {

    private String name;

    private Integer age;

}
