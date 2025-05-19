package com.ezybytes.accounts.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import org.aspectj.bridge.IMessage;

@Data
@Schema(
        name= "Account",
        description = "Schema to hold account information"
)
public class AccountsDto {

    @NotEmpty(message="AccountNumber can not be a null or empty")
    @Pattern(regexp = "(^$|[0-9]{10})", message="Mobile number must be 10 digits")
    @Schema(
            description = "Account Number of Eazy Bank account"
    )
    private Long accountNumber;

    @NotEmpty(message="AccountType can not be a null or empty")
    @Schema(
            description = "Account type of Eazy Bank account", example = "Savings"
    )
    private String accountType;

    @NotEmpty(message="BranchAddress can not be a null or empty")
    @Schema(
            description = "Eazy Bank branch address",example = "123NewYork"
    )
    private String branchAddress;


}
