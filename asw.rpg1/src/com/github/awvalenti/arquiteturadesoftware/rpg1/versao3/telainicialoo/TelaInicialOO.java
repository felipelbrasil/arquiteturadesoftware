package com.github.awvalenti.arquiteturadesoftware.rpg1.versao3.telainicialoo;

import java.awt.GridLayout;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class TelaInicialOO {

	final JFrame frame = new JFrame();
	private int numeroColunas = 0;
	
	public TelaInicialOO(Elemento[][] disposicaoInicial) throws IOException {
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		int numeroLinhas = disposicaoInicial.length;
		this.numeroColunas = disposicaoInicial[0].length;

		frame.setLayout(new GridLayout(numeroLinhas, numeroColunas));

		for (int i = 0; i < numeroLinhas; i++) {
			for (int j = 0; j < numeroColunas; j++) {
				frame.add(new JLabel(new ImageIcon(ImageIO.read(TelaInicialOO.class.getResourceAsStream(
						disposicaoInicial[i][j].getCaminhoImagem())))));
			}
		}

		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

	public void alterarElemento(int linha, int coluna, Elemento novoElemento) throws IOException {
		((JLabel) frame.getContentPane().getComponent(linha * this.numeroColunas + coluna)).setIcon(new ImageIcon(ImageIO.read(TelaInicialOO.class.getResourceAsStream(
				novoElemento.getCaminhoImagem()))));
	}

}
