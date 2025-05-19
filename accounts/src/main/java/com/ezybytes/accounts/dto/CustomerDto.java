package com.ezybytes.accounts.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@Schema(
        name="Customer",
        description = "Schema to hold Customer and account information"
)
public class CustomerDto {

    @Schema(
           description = "Name of the Customer", example = "Eazy Bytes"
    )
    @NotEmpty(message = "Name can not null or empty")
    @Size(min=5,max=30, message="The length of the customer name should be between 5 and 30")
    private String name;

    @Schema(
            description = "Email address of the Customer", example = "tutor@eazybytes.com"
    )
    @NotEmpty(message = "Name can not null or empty")
    @Email(message="Email address shouldbe valid value ")
    private String email;

    @Schema(
            description = "Mobile Number of the Customer", example = "6789736789"
    )
    @Pattern(regexp = "(^$|[0-9]{10})", message="Mobile number must be 10 digits")
    private String mobileNumber;

    @Schema(
            description = "account details of the Customer"
    )
    private AccountsDto accountsDto;


}
