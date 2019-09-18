package com.monapp;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;


import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.monapp.model.Car;
import com.monapp.model.Parking;


public class Entry {

	public static void main(String[] args) {
		parking();

	}
	public static void parking()
	{
		Parking parking1 = new Parking(1, "Jean Jaures");
		Parking parking2 = new Parking(2, "Capitole");
		
		parking1.addCar(new Car(11,"VD334JK", "Peugeot", "Rouge"));
		parking1.addCar(new Car(23,"VFERSJK", "Renault", "Bleu"));
		parking1.addCar(new Car(465,"VH342JG", "Ford", "Rouge"));
		parking1.addCar(new Car(52,"DG4T2JK", "Ford", "Bleu"));
		parking1.addCar(new Car(85,"VD332JR", "Peugeot", "Rouge"));
		
		parking2.addCar(new Car(34,"VD334EK", "Peugeot", "Vert"));
		parking2.addCar(new Car(22,"VFERSAK", "Fiat", "Rouge"));
		parking2.addCar(new Car(624,"VH34HJG", "Ford", "Vert"));
		parking2.addCar(new Car(888,"VDADJR", "Renault", "Rouge"));
		
		
		List<Parking> parkings  = new ArrayList<Parking>();
		parkings.add(parking1);
		parkings.add(parking2);
		
		
		
		try {
			
			DocumentBuilder docBuilder= DocumentBuilderFactory.newInstance().newDocumentBuilder();
			Document doc= docBuilder.newDocument();
			
			Element rootElement= doc.createElement("parkings");

			doc.appendChild(rootElement);
			
			for(int k=0;k<parkings.size();k++)
			{
				
			
			
			Element parking=doc.createElement("parking");
			parking.setAttribute("id",  Integer.toString(parkings.get(k).getId())); //Parking Jean Jaures
			
			Element nameParkingJeanJaures=doc.createElement("name");
			nameParkingJeanJaures.appendChild(doc.createTextNode(parkings.get(k).getName()));
			
			
			Element cars=doc.createElement("cars");
			
			
			
			parking.appendChild(cars);
			
			for(int i=0;i<parkings.get(k).getCars().size(); i++)
			{	
				Element car=doc.createElement("car");
				car.setAttribute("id",Integer.toString(parkings.get(k).getCars().get(i).getId()));
				car.setAttribute("immat",parkings.get(k).getCars().get(i).getImmat());
				
				Element carsModel=doc.createElement("model");
				
				
				
				
				rootElement.appendChild(parking);
				parking.appendChild(nameParkingJeanJaures);
				Element carsColor=doc.createElement("color");
				cars.appendChild(car);
				car.appendChild(carsColor);
				car.appendChild(carsModel);
				carsColor.appendChild(doc.createTextNode(parkings.get(k).getCars().get(i).getColor()));
				carsModel.appendChild(doc.createTextNode(parkings.get(k).getCars().get(i).getModel()));
			}
			}
			
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			DOMSource source = new DOMSource(doc);
			StreamResult result = new StreamResult(new File("parking.xml"));
			
			transformer.transform(source, result);
			
	} 	catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		//Créer un fichier json plus rapidement. Ici avec la liste "parkings"
		ObjectMapper mapper = new ObjectMapper();
		
		try {
			mapper.writeValue(new File("string.json") , parkings); //Nom du fichier .json et l'objet de création, ici les parkings
		}
		catch (JsonGenerationException e) {
			// TODO: handle exception
		}
		catch (JsonMappingException e) {
			// TODO: handle exception
		}
		catch (IOException e) {
			// TODO: handle exception
		}
		
		
		try
		{
			parkings = mapper.readValue(new File("string.json"), new TypeReference<List<Parking>>() {});
					System.out.println(parkings.get(0).getName());
					System.out.println(parkings.get(1).getName());
		}
		catch (JsonParseException e) {
			e.printStackTrace();
		}
		catch (JsonMappingException e) {
			e.printStackTrace();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		
	}
	
	/*Création d'un fichier XML
	 * 
	 * 
	 */
	public static void createXMLSailor()
	{
		try {
			
			//Création d'un nouveau document
			DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
			
			Document doc= docBuilder.newDocument();
			Element sailors= doc.createElement("sailors"); //Création d'une balise "sailors"
			
			Element sailor1=doc.createElement("sailor"); //Création d'une balise "sailor1"
			Element sailor2=doc.createElement("sailor"); //Création d'une balise "sailor2"
			
			Element firstNameElementSailor1= doc.createElement("firstName"); //Création d'une balise "firstNamElementSailor1"
			firstNameElementSailor1.appendChild(doc.createTextNode("Olivier")); //Attribut texte de firstNamElementSailor1
			

			Element firstNameElementSailor2= doc.createElement("firstName"); //Création d'une balise "firstNamElementSailor2"
			firstNameElementSailor2.appendChild(doc.createTextNode("Robert")); //Attribut texte de firstNamElementSailor2
			
			Element infoSailor1 = doc.createElement("Info"); //Création d'une balise "Info"
			infoSailor1.setAttribute("lang", "FR"); //SetAttribute "lang" et value "FR" dans "Info"
			infoSailor1.appendChild(doc.createTextNode("Navigateur et chroniqueur")); //Création d'un text dans la balise "infoSailor1"
			
			Element infoSailor2 = doc.createElement("Info");
			infoSailor2.setAttribute("lang", "FR");
			infoSailor2.appendChild(doc.createTextNode("Capitaine Corsair"));
			
			
			Element lastNameElementSailor2 = doc.createElement("lastName");
			lastNameElementSailor2.appendChild(doc.createTextNode("Surcouf"));
			
			Element lastNameElementSailor1 = doc.createElement("lastName");
			lastNameElementSailor1.appendChild(doc.createTextNode("De Kersauson"));
		
			
			sailor1.appendChild(firstNameElementSailor1);
			sailor1.appendChild(lastNameElementSailor1);
			sailor1.appendChild(infoSailor1);
			sailor1.setAttribute("id", "15");
			
			sailor2.appendChild(firstNameElementSailor2);
			sailor2.appendChild(lastNameElementSailor2);
			sailor2.appendChild(infoSailor2);
			sailor2.setAttribute("id", "12");
			
			sailors.appendChild(sailor1);
			sailors.appendChild(sailor2);
			
			doc.appendChild(sailors);
			
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			DOMSource source = new DOMSource(doc);
			StreamResult result = new StreamResult(new File("sailor.xml"));
			
			transformer.transform(source, result);
			
	} 	catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		
	}
	public static void createXMLFile()
	{
		try {
			DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
			
			Document doc= docBuilder.newDocument();
			Element rootElement= doc.createElement("Stagiaires");
			doc.appendChild(rootElement);
			
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			DOMSource source = new DOMSource(doc);
			StreamResult result = new StreamResult(new File("file.xml"));
			
			transformer.transform(source, result);
			
	} 	catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		
	}

}
