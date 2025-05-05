package com.securegate.securegate.domains;

import lombok.Data;

@Data
public class Metadata {
    private String device;
    private String ip;
    private String timestamp;
}
