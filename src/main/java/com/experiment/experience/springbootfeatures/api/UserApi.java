package com.experiment.experience.springbootfeatures.api;

import com.experiment.experience.springbootfeatures.domain.User;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.http.ResponseEntity;

public interface UserApi {

    @Operation(description = "get user details based on userid ex:id=1223", method = "getUserById")
    @Parameters(
            value = {
                @Parameter(
                        name = "corealationid",
                        required = true,
                        schema = @Schema(implementation = String.class),
                        in = ParameterIn.HEADER),
                @Parameter(
                        name = "id",
                        required = true,
                        schema = @Schema(implementation = String.class))
            })
    ResponseEntity<User> getByUserId(@Parameter Long id);

    @Operation(description = "get user details based on userName", method = "getUserByName")
    @Parameters(
            value = {
                @Parameter(
                        name = "corealationid",
                        required = true,
                        schema = @Schema(implementation = String.class),
                        in = ParameterIn.HEADER),
                @Parameter(
                        name = "userName",
                        required = true,
                        schema = @Schema(implementation = String.class))
            })
    ResponseEntity<User> getByUserName(@Parameter String userName);
}