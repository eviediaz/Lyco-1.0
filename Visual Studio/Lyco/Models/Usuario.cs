using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
#nullable disable

namespace pruebita.Models
{
    public partial class Usuario
    {
        [Key]
        [Required(ErrorMessage = "El campo DNI es Obligatorio")]
        public string IdUsuario { get; set; } = null!;

        [Required(ErrorMessage = "El campo NOMBRE es Obligatorio")]
        public string? NombreUsuario { get; set; }

        [Required(ErrorMessage = "El campo APELLIDO es Obligatorio")]
        public string? ApellidoUsuario { get; set; }

        [Required(ErrorMessage = "El campo EDAD USUARIO es Obligatorio")]
        public int? EdadUsuario { get; set; }

        [Required(ErrorMessage = "El campo NOMBRE USUARIO es Obligatorio")]
        public string? NombreusuarioUsuario { get; set; }

        [Required(ErrorMessage = "El campo CORREO es Obligatorio")]
        public string? CorreoUsuario { get; set; }

        [Required(ErrorMessage = "El campo CONTRASEÑA es Obligatorio")]
        public string? PasswordUsuario { get; set; }

        [Required(ErrorMessage = "El campo TIPO es Obligatorio")]
        public string? TipoUsuario { get; set; }
    }
    public partial class UsuarioLogin
    {
        public string CorreoUsuario { get; set; }

        public string PasswordUsuario { get; set; }
    }

    public partial class UsuarioModificar
    {
        public string IdUsuario { get; set; }

        public string? NombreUsuario { get; set; }

        public string? ApellidoUsuario { get; set; }



    }
}
