using System;
using System.Collections.Generic;
using Microsoft.EntityFrameworkCore;
using Microsoft.EntityFrameworkCore.Metadata;

namespace pruebita.Models
{
    public partial class bdproyectoContext : DbContext
    {
        public bdproyectoContext()
        {
        }

        public bdproyectoContext(DbContextOptions<bdproyectoContext> options)
            : base(options)
        {
        }

        public virtual DbSet<Tipousuario> Tipousuarios { get; set; } = null!;
        public virtual DbSet<Usuario> Usuarios { get; set; } = null!;

        protected override void OnConfiguring(DbContextOptionsBuilder optionsBuilder)
        {
            if (!optionsBuilder.IsConfigured)
            {
#warning To protect potentially sensitive information in your connection string, you should move it out of source code. You can avoid scaffolding the connection string by using the Name= syntax to read it from configuration - see https://go.microsoft.com/fwlink/?linkid=2131148. For more guidance on storing connection strings, see http://go.microsoft.com/fwlink/?LinkId=723263.
                optionsBuilder.UseMySql("server=localhost;database=bdproyecto;uid=root", Microsoft.EntityFrameworkCore.ServerVersion.Parse("10.4.25-mariadb"));
            }
        }

        protected override void OnModelCreating(ModelBuilder modelBuilder)
        {
            modelBuilder.UseCollation("utf8mb4_general_ci")
                .HasCharSet("utf8mb4");

            modelBuilder.Entity<Tipousuario>(entity =>
            {
                entity.HasKey(e => e.TipoUsuario1)
                    .HasName("PRIMARY");

                entity.ToTable("tipousuario");

                entity.Property(e => e.TipoUsuario1)
                    .HasMaxLength(1)
                    .HasColumnName("Tipo_usuario");

                entity.Property(e => e.Desc)
                    .HasMaxLength(30)
                    .HasColumnName("desc");
            });

            modelBuilder.Entity<Usuario>(entity =>
            {
                entity.HasKey(e => e.IdUsuario)
                    .HasName("PRIMARY");

                entity.ToTable("usuario");

                entity.HasIndex(e => e.TipoUsuario, "Type");

                entity.Property(e => e.IdUsuario)
                    .HasMaxLength(12)
                    .HasColumnName("id_usuario")
                    .IsFixedLength();

                entity.Property(e => e.ApellidoUsuario)
                    .HasMaxLength(30)
                    .HasColumnName("apellido_usuario");

                entity.Property(e => e.CorreoUsuario)
                    .HasMaxLength(50)
                    .HasColumnName("correo_usuario");

                entity.Property(e => e.EdadUsuario)
                    .HasColumnType("int(2)")
                    .HasColumnName("edad_usuario");

                entity.Property(e => e.NombreUsuario)
                    .HasMaxLength(30)
                    .HasColumnName("nombre_usuario");

                entity.Property(e => e.NombreusuarioUsuario)
                    .HasMaxLength(30)
                    .HasColumnName("nombreusuario_usuario");

                entity.Property(e => e.PasswordUsuario)
                    .HasMaxLength(30)
                    .HasColumnName("password_usuario");

                entity.Property(e => e.TipoUsuario)
                    .HasMaxLength(1)
                    .HasColumnName("Tipo_usuario");
            });

            OnModelCreatingPartial(modelBuilder);
        }

        partial void OnModelCreatingPartial(ModelBuilder modelBuilder);
    }
}
