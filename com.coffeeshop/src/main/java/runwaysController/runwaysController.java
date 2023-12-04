package runwaysController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.runwayService.RunwaysService;
import com.runwaysDAO.RunwaysDAOimp;

import runwaysEntity.RunwaysEntity;


@Controller
public class runwaysController {
	
	@Autowired
	RunwaysService  runwaysService;
	
	@Autowired
	RunwaysDAOimp runwaysDAOimp;

	public runwaysController() {
		System.out.println("RunwaysController methos()");
	}
	
	@RequestMapping(value="/getrunwaysData")
	public void savingRunways(@RequestParam int runwaylength, 
			@RequestParam int runwayWidth,
			@RequestParam String suit,@RequestParam String direction, Model model) {
		
		System.out.println("runwaylength :"+runwaylength);
		System.out.println("runwayWidth :"+runwayWidth);
		System.out.println("suit :"+suit);
		System.out.println("direction :"+direction);
		
		boolean validateRunway = runwaysService.ValidateRunway(runwaylength, runwayWidth, suit, direction);
		RunwaysEntity entity = new RunwaysEntity(runwaylength,runwayWidth,suit,direction);
		
		boolean isValid = runwaysDAOimp.saveRunways(entity);
		if(validateRunway && isValid) {
			model.addAttribute("runway_saved", "Successfull...");
			
		}
		else{
			model.addAttribute("runway_notsaved", "UnSuccessfull...");
		}
	}
	

}
