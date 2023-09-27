using Microsoft.AspNetCore.Mvc;
using Newtonsoft.Json;
using pruebita.Models;
using System.Net;

namespace pruebita.Controllers
{
    public class HouseController : Controller
    {
        private readonly bdproyectoContext Context;

        public HouseController(bdproyectoContext Context)
        {
            this.Context = Context;
        }
        [HttpGet]
        public IActionResult Index()
        {
            return View();
        }

        public IActionResult Validar(UsuarioLogin usuario)
        {
            if (ModelState.IsValid)
            {
                var Obj = (from TUsuario in Context.Usuarios where TUsuario.PasswordUsuario == usuario.PasswordUsuario && TUsuario.CorreoUsuario ==usuario.CorreoUsuario select TUsuario).FirstOrDefault();

                if(Obj == null)
                {
                    return RedirectToAction("Index");
                }
                else
                {
                    HttpContext.Session.SetString("susuario",JsonConvert.SerializeObject(Obj));
                    return RedirectToAction(Obj.IdUsuario, "Interfaz"); 
                }

            }
            else
            {
                return View("Index");
            }
        }

        public IActionResult Register()
        {
            ViewBag.Tipo = Context.Tipousuarios;
            return View();
        }

        public IActionResult RegisterUsuario(Usuario Obj)
        {
            if (ModelState.IsValid)
            {
                Context.Usuarios.Add(Obj);
                Context.SaveChanges();

                return RedirectToAction("Index");
            }
            else
            {
                ViewBag.Tipo = Context.Tipousuarios;
                return View("Register");
            }
        }


        [Route("~/Interfaz/{id}")]
        public IActionResult Interfaz(string? id)
        {
            Console.Write("Holaa");
            var user = Context.Usuarios.Find(id);
            return View(user);
        }

        [HttpPost]
        [ValidateAntiForgeryToken]

        public IActionResult Interfaz(Usuario usuario)
        {
            if (ModelState.IsValid)
            {
                return View(usuario);
            }

            return NotFound();
        }


        public IActionResult EditPerfil(string? id)
        {
            if (id == null)
            {
                return NotFound();
            }
            var obj = Context.Usuarios.Find(id);

            if(obj == null)
            {
                return NotFound();
            }

            return View(obj);
        }
        [HttpPost]
        [ValidateAntiForgeryToken]

        public IActionResult EditPerfil(Usuario usuario)
        {
            if (ModelState.IsValid)
            {
                Context.Usuarios.Update(usuario);
                Context.SaveChanges();
                return RedirectToAction(usuario.IdUsuario, "Interfaz");
            }

            return View(usuario);
        }
        

        [Route("~/Sesion/{id?}")]
        public IActionResult Sesion(string? id, string mode)
        {
            if (id == null)
            {
                return NotFound();
            }

            Console.Write("Hola" + mode);
            
            var obj = Context.Usuarios.Find(id);

            if (obj == null)
            {
                return NotFound();
            }

            ViewData["mode"] = mode;
            return View(obj);
        }
        [HttpPost]
        [ValidateAntiForgeryToken]

        public IActionResult Sesion(Usuario user)
        {
            if (ModelState.IsValid)
            {
                return View(user);
            }

            return NotFound();
        }

    }

}
