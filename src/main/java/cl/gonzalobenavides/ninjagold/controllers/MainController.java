package cl.gonzalobenavides.ninjagold.controllers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Random;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cl.gonzalobenavides.ninjagold.model.Mensaje;
import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/Gold")
public class MainController {

	@GetMapping("")
	public String setGold(HttpSession sesh, Model mod) {
		List<Mensaje> msg = (List<Mensaje>)sesh.getAttribute("mensajes");
		Integer oro = (Integer)sesh.getAttribute("oro");
		if(msg == null) {
			msg = new ArrayList<Mensaje>();
			sesh.setAttribute("mensajes", msg);
		}
		if(oro == null) {
			oro = 0;
			sesh.setAttribute("oro", 0);
		}

		Collections.sort(msg, (m1, m2) -> { return m2.getFecha().compareTo(m1.getFecha()); });
		
		mod.addAttribute("oro",oro);
		mod.addAttribute("mensajes", msg);
		
		if(oro <= -100) {
			return this.goPrison(sesh, mod);
		}
		
		return "gold.jsp";
	}
	
	
	@PostMapping("/granja")
	public String goGranja(@RequestParam("action") String action, HttpSession sesh) {
		Integer oro = this.calcularOro(10, 20);
		Mensaje mensaje = this.generarMensaje(oro, action);
		sesh.setAttribute("oro", (Integer)sesh.getAttribute("oro") + oro);
		
		List<Mensaje> mens = new ArrayList<Mensaje>();
		mens = (List<Mensaje>) sesh.getAttribute("mensajes");
		mens.add(mensaje);
		sesh.setAttribute("mensajes", mens);
		
		return "redirect:/Gold";
	}
	
	@PostMapping("/cueva")
	public String goCueva(@RequestParam("action") String action, HttpSession sesh) {
		Integer oro = this.calcularOro(5, 10);
		Mensaje mensaje = this.generarMensaje(oro, action);
		
		sesh.setAttribute("oro", (Integer)sesh.getAttribute("oro") + oro);
		
		List<Mensaje> mens = new ArrayList<Mensaje>();
		mens = (List<Mensaje>) sesh.getAttribute("mensajes");
		mens.add(mensaje);
		sesh.setAttribute("mensajes", mens);
		
		return "redirect:/Gold";
	}
	
	@PostMapping("/casa")
	public String goCasa(@RequestParam("action") String action, HttpSession sesh) {
		Integer oro = this.calcularOro(2, 5);
		Mensaje mensaje = this.generarMensaje(oro, action);
		
		sesh.setAttribute("oro", (Integer)sesh.getAttribute("oro") + oro);
		
		List<Mensaje> mens = new ArrayList<Mensaje>();
		mens = (List<Mensaje>) sesh.getAttribute("mensajes");
		mens.add(mensaje);
		sesh.setAttribute("mensajes", mens);
		
		return "redirect:/Gold";
	}

	@PostMapping("/casino")
	public String goCasino(@RequestParam("action") String action, HttpSession sesh) {
		Integer oro = this.calcularOro(-50, 50);
		
		Mensaje mensaje = this.generarMensaje(oro, action);

		sesh.setAttribute("oro", (Integer)sesh.getAttribute("oro") + oro);
		
		List<Mensaje> mens = new ArrayList<Mensaje>();
		mens = (List<Mensaje>) sesh.getAttribute("mensajes");
		mens.add(mensaje);
		sesh.setAttribute("mensajes", mens);
		
		return "redirect:/Gold";
	}

	@PostMapping("/spa")
	public String goSpa(@RequestParam("action") String action, HttpSession sesh) {
		Integer oro = this.calcularOro(-20, -5);
		Mensaje mensaje = this.generarMensaje(oro, action);
		
		sesh.setAttribute("oro", (Integer)sesh.getAttribute("oro") + oro);
		
		List<Mensaje> mens = new ArrayList<Mensaje>();
		mens = (List<Mensaje>) sesh.getAttribute("mensajes");
		mens.add(mensaje);
		sesh.setAttribute("mensajes", mens);
		
		return "redirect:/Gold";
	}
	
	@RequestMapping("/reset")
	public String reset(HttpSession sesh) {
		sesh.removeAttribute("oro");
		sesh.removeAttribute("mensajes");
		
		return "redirect:/Gold";
	}
	
	@RequestMapping("/Prison")
	public String goPrison(HttpSession sesh, Model mod) {
		return "prison.jsp";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	//METODOS AUXILIARES
	public Integer calcularOro(int min, int max) {
		Random rand = new Random();
		return rand.nextInt(min, max);
	}
	
	public Mensaje generarMensaje(int oro, String action) {
		String mensaje = "";
		Date now = new Date();
		if(oro < 0) 
			mensaje = "<p class='negativo'> Entraste a " + action.toLowerCase() + " y perdiste. " + oro + " de oro. (" + now + ") </p>";
		else if(oro == 0)
			mensaje = "<p class='positivo'> Entraste a " + action.toLowerCase() + " y  no ganaste nada. (" + now + ") </p>";
		else
			mensaje = "<p class='positivo'> Entraste a " + action.toLowerCase() + " y ganaste. " + oro + " de oro. (" + now + ") </p>";
		
		return new Mensaje(mensaje, now);
	}
}
