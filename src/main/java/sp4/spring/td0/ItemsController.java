package sp4.spring.td0;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.view.RedirectView;

import sp4.spring.models.Element;
@Controller
@SessionAttributes("elements")
public class ItemsController {
	private List<Element> elements = new ArrayList<Element>();
	
	public ItemsController() {
		this.elements.add(new Element("premier", 1));
	}
	@ModelAttribute("elements")
	public List<Element> getElements(){
		return elements;
	}
	@RequestMapping("/items")
	public String items() {
		return "items";
	}
	@RequestMapping("/items/new")
	public String newItem() {
		return "new";
	}

	//	public RedirectView addNew(HttpServletRequest request@RequestParam("nom") String nom, @RequestParam int evaluation) {
	// request.getParameter("nom");
	
	@PostMapping("/items/addNew")
	public RedirectView addNew(@RequestParam("nom") String nom, @RequestParam int evaluation) {
		Element elm = new Element();
		elm.setNom(nom);
		elm.setEvaluation(evaluation);
		getElements().add(elm);
		return new RedirectView("");
	}
	@GetMapping("/items/inc/{nom}")
	public RedirectView inc(@PathVariable String nom) {
		for(Element elemen : elements) {
			if (elemen.getNom() == nom) {
				elemen.setEvaluation(elemen.getEvaluation()+1);
			}
		}
		return new RedirectView("items");
	}
}
