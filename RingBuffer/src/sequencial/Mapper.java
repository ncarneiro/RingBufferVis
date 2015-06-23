package sequencial;

import java.awt.Color;
import java.util.HashMap;

public class Mapper {

	private Color[] colors = {Color.RED, Color.GREEN, Color.BLUE, Color.ORANGE, Color.YELLOW, Color.MAGENTA, Color.PINK, Color.CYAN, Color.DARK_GRAY, Color.BLACK, Color.WHITE};
	private int[] sizes = {1,2,3};
	private int largura = 600;
	private int altura = 600;
	
	private int x;
	private int y;
	private int currentPoints = 4;
	
	
	HashMap<String, String>[] categoricos;
	HashMap<String, Double>[] continuos;
	Metadata metadata;
	Item item;
	
	public Mapper(Metadata metadata, String[] dados) {
		this.metadata = metadata;
		
		for (int i = 0; i < dados.length; i++) {
			String[] vetor = dados[i].split(";");	
			continuos[i].put("ID", Double.parseDouble(vetor[0]));
			continuos[i].put("NOTA1", Double.parseDouble(vetor[1]));
			continuos[i].put("NOTA2", Double.parseDouble(vetor[2]));
			continuos[i].put("NOTA3", Double.parseDouble(vetor[3]));
			continuos[i].put("NOTA4", Double.parseDouble(vetor[4]));
			continuos[i].put("MEDIA", Double.parseDouble(vetor[5]));
			categoricos[i].put("SITUACAO", vetor[6]);
			categoricos[i].put("CONCEITO", vetor[7]);
		}
	}
	
	public void map() {
	
		//categoricos
		item.setColor(colors[metadata.getColor().getValues().indexOf(item.getMappingsCatgoricos().get(metadata.getColorName()))]);
		item.setSize(sizes[metadata.getSize().getValues().indexOf(item.getMappingsCatgoricos().get(metadata.getSizeName()))]);
		//continuos
		item.setNumberOfPoints(currentPoints);
		x = (int)metadata.getAxisX().convertToInterval(0, largura, item.getMappingsContinuos().get(metadata.getAxisXName()));
		y = (int)metadata.getAxisY().convertToInterval(0, altura, item.getMappingsContinuos().get(metadata.getAxisYName()));
		for (int i = 0; i < currentPoints; i++) {
			if (i==0 || i==3) {
				item.getX()[i] = x-10;
			} else {
				item.getX()[i] = x+10;
			}
			if (i<2) {
				item.getY()[i] = y;
			} else {
				item.getY()[i] = y+20;
			}
		}
	
		
	}
 }
