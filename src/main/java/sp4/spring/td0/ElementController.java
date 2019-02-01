package sp4.spring.td0;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import sp4.spring.models.Element;
@Controller
@SessionAttributes("elements")
public class ElementController {


	@ModelAttribute("elements")
	public List<Element> getElements(){
		List<Element> elements = new ArrayList<>();
		return elements;
	}
	@RequestMapping("/index")
	public String index(@ModelAttribute("elements") List<Element> elements) {
		Element elm = new Element();
		elm.setNom("test");
		elements.add(elm);
		return "index";
	}
	@RequestMapping("/nouveau")
	public String ajout() {
		return "nouveau";
	}
}
