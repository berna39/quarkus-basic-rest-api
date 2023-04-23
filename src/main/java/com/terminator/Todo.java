package com.terminator;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Todo {
    public int id;
    public String title;
    public String detail;
    public boolean done;
}
