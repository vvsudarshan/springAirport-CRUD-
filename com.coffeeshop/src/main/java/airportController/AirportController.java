package airportController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.airportDAO.AirportDAOImpl;
import com.airportEntity.AirportEntity;
import com.airportService.AirportServices;

@Controller
public class AirportController {
	
	@Autowired
	AirportServices airportServices;
	
	@Autowired
	AirportDAOImpl airportDAOImp;

	public AirportController() {
		System.out.println("enter shopp AirportController");
	}
	
	
	@RequestMapping(value= "/getDatafromHtml")
	public String acceptFirstReq(@RequestParam String airportName,
	        @RequestParam String airportLocation,
	        @RequestParam int noOfPlanes, 
	        @RequestParam int noOfRunways , Model model) {
		System.out.println("airportName :"+airportName);
		System.out.println("airportLocation :"+airportLocation);
		System.out.println("airportRunways :"+noOfPlanes);
		System.out.println("airportPlane :"+noOfRunways);
		boolean saveAirportEntity = false;
		
		boolean valid = airportServices.airportValidate(airportName, airportLocation, noOfPlanes, noOfRunways);
		
		if(valid) {
			AirportEntity airport = new AirportEntity(airportName,airportLocation,noOfPlanes,noOfRunways);
			saveAirportEntity = airportDAOImp.saveAirportEntity(airport);
			System.out.println("saveAirportEntity :"+saveAirportEntity);
		}
	
		if(valid && saveAirportEntity) {
			model.addAttribute("savesuccess", "VALID DATA and SUCCSSFULL YOUR REGISTATION");
			return "/index.jsp";
		}
		else {
			model.addAttribute("saveerror", "INVALID DATA and SUCCSSFULL YOUR REGISTATION");
			return "/index.jsp";
		}	
	}

	@RequestMapping(value="/searchById")
	public String searchById(@RequestParam int search , Model model) {
		System.out.println("searchById :"+search);
		
		boolean isvalid = airportServices.isExitByid(search);
		if(isvalid) {
			AirportEntity entity = airportDAOImp.getAirportEntityById(search);
			if(entity!=null) {
				model.addAttribute("airportName", entity.getAirport_name());
				model.addAttribute("airportLocation", entity.getAirport_location());
				model.addAttribute("noOfPlanes", entity.getNo_of_planes());
				model.addAttribute("noOfRunways", entity.getNo_of_runways());
				System.out.println(entity.getAirport_name());
				System.out.println(entity.getAirport_location());
				System.out.println(entity.getNo_of_planes());
				System.out.println(entity.getNo_of_runways());
				return "/index.jsp";
			}
			else {
				model.addAttribute("notregister", "Airport not Register Please Register");
				return "/index.jsp";
			}
			
		}
		else {
			model.addAttribute("error", "Enter Valid ID range between from 1.....");
			return "/index.jsp";
		}
	}
	@RequestMapping(value="/searchByName")
	public String getByAirportName(String searchName,Model model) {
		System.out.println("searchName :"+searchName);
		
		boolean valid = airportServices.isExitByName(searchName);
		if(valid) {
			AirportEntity entity = airportDAOImp.getAirportEntityByName(searchName);
			if(entity!=null) {
				model.addAttribute("airportNamename", entity.getAirport_name());
				model.addAttribute("airportLocationname", entity.getAirport_location());
				model.addAttribute("noOfPlanesname", entity.getNo_of_planes());
				model.addAttribute("noOfRunwaysname", entity.getNo_of_runways());
				System.out.println(entity.getAirport_name());
				System.out.println(entity.getAirport_location());
				System.out.println(entity.getNo_of_planes());
				System.out.println(entity.getNo_of_runways());
				return "/index.jsp";
				
			}
			else {
				model.addAttribute("entitynottfound", "Airport not found make register....");
				return "/index.jsp";
			}
			
			
		}
		else {
			model.addAttribute("Incorrectname", "for Emptty spaces Invalid Name..... Enter Correct Name ");
			return "/index.jsp";
		}
		
	}
	@RequestMapping(value="/deleteById")
	public String deleteAirportEntity(@RequestParam int Id,Model model) {
		System.out.println("ID :"+Id);
		boolean valid = airportServices.isExitByid(Id);
		if(valid) {
			boolean deleteByIdValid = airportDAOImp.deleteById(Id);
			if(deleteByIdValid) {
				model.addAttribute("delId", "Successfully delete the airport Entity");
				return "/index.jsp";
			}
			else {
				model.addAttribute("delnotsucces", "Unsuccessfully to Delete.....Airport not avialable...");
				return "/index.jsp";
			}
			
		}
		else {
			model.addAttribute("Deletenothappenid", "enter range 1 to infinity..");
			return "/index.jsp";
		}
		
		
		
		
	}
	@RequestMapping(value="/deleteByName")
	public String deleteAirportEntity(@RequestParam String Name,Model model) {
		System.out.println("Name :"+Name);
		
		boolean valid = airportServices.isExitByName(Name);
		
		if(valid) {
			
			  boolean deleteValid = airportDAOImp.deleteByName(Name);
			
			if(deleteValid) {
				model.addAttribute("delsuccessname", "Successfully delete the airport Entity");
				return "redirect:/index.jsp";
			}
			else {
				model.addAttribute("delnotsuccesname", "Unsuccessfully to Delete.....Airport not avialable...");
				return "redirect:/index.jsp";
			}
			
		}
		else {
			model.addAttribute("delname", "enter range 1 to infinity..");
			return "/index.jsp";
		}
	}
	@RequestMapping(value="/getAllAirports")
	public String getAllAirportEntity(Model model) {
		System.out.println("getAllAirportEntity");
		List<AirportEntity> allAirportEntities = airportDAOImp.getAllAirportEntity();
		boolean tableExist = airportServices.isTableExist(allAirportEntities);
		if(tableExist) {
				
			model.addAttribute("airportList", allAirportEntities);
			return "/index.jsp";
		}
		else {
			model.addAttribute("nodata", "NO data there please update data");
			return "/index.jsp";
		}
	}
	
	@RequestMapping(value="/editAirport/{id}")
	public String editAirportByID(@PathVariable int id,Model model) {
		System.out.println("id :"+id);
		AirportEntity airport = airportDAOImp.getAirportEntityById(id);
		
		model.addAttribute("ID", airport.getAirport_id());
		model.addAttribute("NAME", airport.getAirport_name());
		model.addAttribute("LOCATION", airport.getAirport_location());
		model.addAttribute("NO_OF_PLANES", airport.getNo_of_planes());
		model.addAttribute("NO_OF_RUNWAYS", airport.getNo_of_runways());
		return "/WEB-INF/edit.jsp";

	}
	
	@RequestMapping(value="/updateAirport")
	public String UpdateAirportById(@RequestParam int airportId , @RequestParam String airportName,
	        @RequestParam String airportLocation,
	        @RequestParam int noOfPlanes, 
	        @RequestParam int noOfRunways , Model model) {
		
		AirportEntity entity = new AirportEntity(airportId, airportName, airportLocation, noOfPlanes, noOfRunways);
		boolean valid = airportServices.airportValidate(airportId, airportName, airportLocation, noOfPlanes, noOfRunways);
		
		if(valid) {
			boolean updateAirportById = airportDAOImp.updateAirportById(entity);
			model.addAttribute("success", "update successfully done...");
			return "redirect:/getAllAirports";
			
		}
		else {
			model.addAttribute("responseMessage", "Enter correct output..");
			return "/WEB-INF/edit.jsp";
		}
		
	}
	@GetMapping("/deleteAirport/{id}")
	public String deleteById(@PathVariable int id,Model model) {
	    System.out.println("id: " + id);
	    boolean deleteById = airportDAOImp.deleteById(id);
	    if(deleteById) {
	    	model.addAttribute("delete", "delete happpens");	    	
	    }
	    return "redirect:/getAllAirports";
	    
	}


	

}
