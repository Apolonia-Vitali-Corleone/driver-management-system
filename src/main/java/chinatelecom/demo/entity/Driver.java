package chinatelecom.demo.entity;

import lombok.Data;

@Data
public class Driver {
    private Long id;
    private String name;
    private String gender;
    private Integer age;
    private String idCardNumber;
    private String phoneNumber;
    private String vehicleType;
    private String licenseStatus;
}