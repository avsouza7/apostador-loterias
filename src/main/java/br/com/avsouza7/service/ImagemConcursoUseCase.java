package br.com.avsouza7.service;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.springframework.stereotype.Service;

import br.com.avsouza7.model.ParaMontarImagem;

@Service
public class ImagemConcursoUseCase {

	private int width = 1800, height = 1600;
	private int x = 50, y = 100;
	private BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
	private Graphics2D g = image.createGraphics();

	public void imprimir(ParaMontarImagem para) throws IOException {
		// Fundo branco
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, width, height);

		// Texto título
		g.setColor(Color.BLACK);
		g.setFont(new Font("Arial", Font.BOLD, 32));
		g.drawString(String.format("🟦 Resultado concurso %s %s", para.getIdLoteria(), para.getLoteriaEnum().getNome()), 50, 50);

		// Dezenas sorteadas
		g.setFont(new Font("Arial", Font.PLAIN, 20));
		g.drawString("Dezenas sorteadas:", x, y);
		y += 20;

		para.getSorteio().getDezenas().forEach(d -> {
			g.setColor(Color.BLUE);
			g.fillOval(x, y, 40, 40);
			g.setColor(Color.WHITE);
			g.drawString(String.format("%02d", d.getIdDezena()), x + 12, y + 27);
			x += 60;
		});
		// Demais informações
		y += 80;
		x = 50;
		g.setColor(Color.BLACK);
		g.drawString(String.format("Data do sorteio: %s", para.getSorteio().getDtSorteioFormatado()), x, y);
		y += 30;
		g.drawString(String.format("Acumulado próximo concurso: %s", para.getSorteio().getDtProximoSorteioFormatado()), x, y);
		g.drawString(String.format("Próximo sorteio: %s", para.getSorteio().getDtSorteioFormatado()), x, y);
		y += 30;
		y += 30;
		g.drawString(String.format("Acumulado sorteio especial: %s %s", para.getSorteio().getAcumuladoSorteioEspecial(), para.getSorteio().getValorAcumuladoConcursoEspecialFormatado()), x, y);
		y += 40;
		g.drawString("Suas apostas:", x, y);
		y += 30;
		g.drawString(String.format("Valor do seu prêmio: %s", para.getValorDoPremio()), x, y);
		para.getResultados().forEach(r -> {
			r.getDezenas().forEach(d -> {
				g.setColor(d.isFoiSorteada() ? Color.BLUE : Color.decode("#911687"));
				g.fillOval(x, y, 40, 40);
				g.setColor(Color.WHITE);
				g.drawString(String.format("%02d", d.getIdDezena()), x + 12, y + 27);
				x += 60;
			});
			g.setColor(Color.BLUE);
			g.fillOval(x, y, 40, 40);
			g.setColor(Color.WHITE);
			g.drawString(String.format("%02d", r.getNuAcertos()), x + 12, y + 27);
			x += 60;
		});
		g.dispose();

		// Salvar imagem
		ImageIO.write(image, "png", new File("resultado_concurso.png"));
	}
}
