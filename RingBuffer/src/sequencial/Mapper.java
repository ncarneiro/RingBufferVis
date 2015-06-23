package sequencial;

import java.awt.Color;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Mapper {

	private Color[] colors = {Color.RED, Color.GREEN, Color.BLUE, Color.ORANGE, Color.YELLOW, Color.MAGENTA, Color.PINK, Color.CYAN, Color.DARK_GRAY, Color.BLACK, Color.WHITE};
	private int[] sizes = {1,2,3};
	private int largura = 600;
	private int altura = 600;
	
	private int x;
	private int y;
	private int currentPoints = 4;
	
	List<HashMap<String, String>> categoricos = new ArrayList<HashMap<String,String>>();
	List<HashMap<String, Double>> continuos = new ArrayList<HashMap<String,Double>>();
	Metadata metadata;
	List<Item> item = new ArrayList<Item>();
	
	public Mapper(Metadata metadata, List<HashMap<String,String>> dados) {
		this.metadata = metadata;
		
		for (int i = 0; i < dados.size(); i++) {
			HashMap<String, Double> auxCont = new HashMap<String, Double>();
			HashMap<String, String> auxCat = new HashMap<String, String>();
			
			auxCont.put("ID", Double.parseDouble(dados.get(i).get("ID")));
			auxCont.put("NOTA1", Double.parseDouble(dados.get(i).get("NOTA1")));
			auxCont.put("NOTA2", Double.parseDouble(dados.get(i).get("NOTA2")));
			auxCont.put("NOTA3", Double.parseDouble(dados.get(i).get("NOTA3")));
			auxCont.put("NOTA4", Double.parseDouble(dados.get(i).get("NOTA4")));
			auxCont.put("MEDIA", Double.parseDouble(dados.get(i).get("MEDIA")));
			auxCat.put("SITUACAO", dados.get(i).get("SITUACAO"));
			auxCat.put("CONCEITO", dados.get(i).get("CONCEITO"));
			
			continuos.add(auxCont);
			categoricos.add(auxCat);
		}
	}
	
	public List<Item> map() {
	
		for (int i = 0; i < continuos.size(); i++) {
			item.add(new Item());
			item.get(i).setMappingsCatgoricos(categoricos.get(i));
			item.get(i).setMappingsContinuos(continuos.get(i));
			
			item.get(i).setColor(colors[metadata.getColor().getValues().indexOf(item.get(i).getMappingsCatgoricos().get(metadata.getColorName()))]);
			item.get(i).setSize(sizes[metadata.getSize().getValues().indexOf(item.get(i).getMappingsCatgoricos().get(metadata.getSizeName()))]);

			item.get(i).setNumberOfPoints(currentPoints);
			x = (int)metadata.getAxisX().convertToInterval(0, largura, item.get(i).getMappingsContinuos().get(metadata.getAxisXName()));
			y = (int)metadata.getAxisY().convertToInterval(0, altura, item.get(i).getMappingsContinuos().get(metadata.getAxisYName()));
			for (int j = 0; j < currentPoints; j++) {
				if (j==0 || j==3) {
					item.get(i).getX()[j] = x-10;
				} else {
					item.get(i).getX()[j] = x+10;
				}
				if (j<2) {
					item.get(i).getY()[j] = y;
				} else {
					item.get(i).getY()[j] = y+20;
				}
			}
		}
		return item;
	}
 }
