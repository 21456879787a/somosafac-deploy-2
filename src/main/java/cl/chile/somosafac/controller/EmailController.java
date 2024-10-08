package cl.chile.somosafac.controller;

import cl.chile.somosafac.DTO.PasswordDTO;
import cl.chile.somosafac.service.EmailService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/email")
@Tag(name = "Email", description = "Operaciones relacionadas con el envío de correos electrónicos")
public class EmailController {

    private final EmailService emailService;

    public EmailController(EmailService emailService) {
        this.emailService = emailService;
    }

//    @Operation(summary = "Enviar email de registro", description = "Envía un email de bienvenida con las credenciales de acceso tras el registro del usuario")
//    @ApiResponses(value = {
//            @ApiResponse(responseCode = "200", description = "Email enviado exitosamente"),
//            @ApiResponse(responseCode = "400", description = "Error en la solicitud de envío de email")
//    })
//    @PostMapping("/mensaje-registro")
//    public ResponseEntity<String> sendEmail(@RequestParam String email, @RequestBody PasswordDTO password) {
//        String mensaje = "Nos alegra enormemente que te hayas unido a nuestra comunidad, donde juntos trabajamos por el bienestar de niños, niñas y adolescentes en cuidado alternativo.\n\n" +
//                "Tu cuenta ha sido creada con éxito! Estas son las credenciales para acceder a la plataforma:\n\n" +
//                "Correo electrónico: " + email + "\n" +
//                "Contraseña: " + password.getContrasenaHash() + "\n\n" +
//                "Recuerda que debes cambiar tu contraseña al iniciar sesión por primera vez. ";
//
//        emailService.enviarEmail(
//                email,
//                "¡Bienvenido a la Asociación de Familias de Acogida de Chile (AFAC)! ✉️",
//                mensaje);
//        return ResponseEntity.ok("Email enviado exitosamente!");
//    }


    @Operation(summary = "Enviar email de registro", description = "Envía un email de bienvenida con las credenciales de acceso tras el registro del usuario")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Email enviado exitosamente"),
            @ApiResponse(responseCode = "400", description = "Error en la solicitud de envío de email")
    })
    @PostMapping("/mensaje-registro")
    public ResponseEntity<String> sendEmailPresentacion(@RequestParam String email, @RequestBody PasswordDTO password) {
        emailService.enviarEmailConPresentacion(
                email,
                "¡Bienvenido a la Asociación de Familias de Acogida de Chile (AFAC)! ✉️",
                "",
                password.getContrasenaHash());

        return ResponseEntity.ok("Email enviado exitosamente!");
    }

}
