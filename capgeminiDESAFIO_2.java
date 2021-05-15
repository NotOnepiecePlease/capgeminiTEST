/*Bom dia, boa tarde e boa noite você jovem que esta analisando meu codigo
 * espero que esteja tendo um excelente e maravilhoso dia, quero pedir desculpas
 * pela falta de comentarios no codigo, eu fiz isso em um dia porque acabou me sobrando
 * um tempo das atividades da faculdade e eu to cheio de dor de cabeça entao mil perdoes
 * pelos armengues que fiz (foram muitos kk) tambem desculpa por nao usar bando de dados
 * tudo isso teria sido muito melhor mas eu nao to em casa entao nao vai ser possivel instalar
 * banco de dados na maquina do meu amigo, ou seja, me virei com os limoes que a vida me deu...
 * 
 * Espero de coração que você não perca sanidade perante a loucura e confusão que está esse codigo
 * porque nem eu compreendo o que diabos eu fiz aqui, só quero muito passar nisso kkk.
 * 
 * 
 * tamo junto meu/minha nobre
 * 
 * 
 */


package Project;

import java.util.Calendar;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import org.joda.time.DateTime;

public class capgeminiDESAFIO_2 {

	public static double[] valorTotalInvestido = new double[999];
	public static double[] qntMaximaViews = new double[999];
	public static double[] qntMaximaClicks = new double[999];
	public static double[] qntMaximaShares = new double[999];

	public static int indiceAnuncios = 0;
	public static String[] nomeAnuncio = new String[999];
	public static String[] nomeCliente = new String[999];
	public static int[] diaInicio = new int[999];
	public static int[] mesInicio = new int[999];
	public static int[] anoInicio = new int[999];
	public static double[] investDia = new double[999];
	public static Calendar[] dataAnuncio = new Calendar[999];

	public static void main(String[] args) {
		// calculadoraAlcance();
		Scanner dadosIniciais = new Scanner(System.in);
		Scanner relatorio = new Scanner(System.in);
		Scanner nome = new Scanner(System.in);

//		nomeAnuncio[0] = "Anuncio 01";
//		nomeAnuncio[1] = "Anuncio 02";
//
//		nomeCliente[0] = "Adriano Andrade";
//		nomeCliente[1] = "Rafael Silva";
//
//		dataAnuncio[0] = Calendar.getInstance();
//		dataAnuncio[1] = Calendar.getInstance();
//		diaInicio[0] = 26;
//		mesInicio[0] = 8;
//		anoInicio[0] = 1996;
//
//		diaInicio[1] = 1;
//		mesInicio[1] = 2;
//		anoInicio[1] = 1998;
//
//		investDia[0] = 200;
//		investDia[1] = 400;

		while (true) {
			if (indiceAnuncios < 1) {
				System.out.println(
						"Deseja cadastrar um anuncio numero: " + ((indiceAnuncios) + 1) + " ? Digite 'S' ou 'N'");
				String desejo = dadosIniciais.next().toUpperCase();
				if (desejo.equals("S")) {
					cadastroAnuncio();
				} else {
					break;
				}
			} else {
				System.out.println(
						"Deseja cadastrar um anuncio numero: " + ((indiceAnuncios) + 1) + " ? Digite 'S' ou 'N'");
				String desejo = dadosIniciais.next().toUpperCase();
				if (desejo.equals("S")) {
					cadastroAnuncio();
				} else {
					System.out.println("Deseja fazer um Relatorio por Cliente digite 1, Relatorio por Data digite 2 ou Digite 0 para sair.");
					int opcao = relatorio.nextInt();
					if (opcao == 1) {
						System.out.println("Digite o nome do cliente ou 0 para sair");
						String nomeCliente = nome.nextLine();
						if (nomeCliente.equals("0")) {
							break;
						} else {
							relatorioPorCliente(nomeCliente);
						}
					}else if(opcao == 2) {
						System.out.println("Digite o dia da data inicial, ex: 26");
						int diaInicial = relatorio.nextInt();
						System.out.println("Digite o mes da data inicial, ex: 08");
						int mesInicial = relatorio.nextInt();
						System.out.println("Digite o ano da data inicial, ex: 2000");
						int anoInicial = relatorio.nextInt();
						
						for(int i =0; i<10; i++) {
							System.out.println();
						}
						
						System.out.println("Agora digite o dia da data final, ex: 30");
						int diaFinal = relatorio.nextInt();
						System.out.println("Agora digite o mes da data final, ex: 12");
						int mesFinal = relatorio.nextInt();
						System.out.println("Agora digite o ano da data final, ex: 2021");
						int anoFinal = relatorio.nextInt();
						relatorioPorData(diaInicial, mesInicial, anoInicial, diaFinal, mesFinal, anoFinal);
					}
				}
			}
		}
	}

	public static void calculadoraAlcance(double _valor, int _indice) {
		Scanner calcAlcan = new Scanner(System.in);
		double valor = 0.0, views = 0.0, clicks = 0.0, share = 0.0, viewShares = 0.0;
		valor = _valor;

		for (double i = valor; i > 0; i--) {
			views += 30;
			clicks += 3.60;
		}

		for (double clicksCont = clicks; clicksCont > 20; clicksCont -= 20) {
			share += 3;
			if (share >= 4) {
				break;
			}
		}
		viewShares = (40 * share);
		
		valorTotalInvestido[_indice] = _valor;
		qntMaximaViews[_indice] = views + viewShares;
		qntMaximaClicks[_indice] = clicks;
		qntMaximaShares[_indice] = share;

		System.out.println("\nValores aproximados");
		System.out.println("Valor Total Investido: ~" + valorTotalInvestido[_indice]);
		System.out.println("Maximo de Views: ~" + qntMaximaViews[_indice]);
		System.out.println("Maximo de Clicks: ~" + String.format("%.2f", qntMaximaClicks[_indice]) + "");
		System.out.println("Maximo de Compartilhamentos: ~"+qntMaximaShares[_indice]);
		
//		System.out.println("\nValores aproximados");
//		System.out.println("Valor: ~" + valor);
//		System.out.println("Views: ~" + views);
//		System.out.println("Clicks: ~ " + String.format("%.2f", clicks) + "");
//		System.out.println("Share: ~" + share);
//		System.out.println("View Shares: ~" + viewShares);
	}

	public static void cadastroAnuncio() {
		Scanner cadAnun = new Scanner(System.in);

		System.out.println("Nome do anuncio: ");
		nomeAnuncio[indiceAnuncios] = cadAnun.nextLine();
		
		System.out.println("Nome do Cliente:");
		nomeCliente[indiceAnuncios] = cadAnun.nextLine();

		System.out.println("Dia (ex 26):");
		dataAnuncio[indiceAnuncios] = Calendar.getInstance();
		diaInicio[indiceAnuncios] = cadAnun.nextInt();
		dataAnuncio[indiceAnuncios].set(Calendar.DAY_OF_MONTH, (diaInicio[indiceAnuncios]) - 1);

		System.out.println("Mes (ex 08):");
		mesInicio[indiceAnuncios] = cadAnun.nextInt();
		dataAnuncio[indiceAnuncios].set(Calendar.MONTH, (mesInicio[indiceAnuncios]) - 1);

		System.out.println("Ano (ex 1995):");
		anoInicio[0] = cadAnun.nextInt();
		dataAnuncio[indiceAnuncios].set(Calendar.YEAR, anoInicio[indiceAnuncios]);

		System.out.println("Investimento:");
		investDia[indiceAnuncios] = cadAnun.nextDouble();

		System.out.println("\n\n");
		System.out.println(nomeAnuncio[indiceAnuncios]);
		System.out.println(nomeCliente[indiceAnuncios]);
		System.out
				.println(diaInicio[indiceAnuncios] + "/" + mesInicio[indiceAnuncios] + "/" + anoInicio[indiceAnuncios]);
		System.out.println(investDia[indiceAnuncios]);

		indiceAnuncios++;
	}

	public static void relatorioPorCliente(String _nome) {
		System.out.println("Busca pelo Cliente: "+ _nome);
		try {
			System.out.println(
					"--------------------------------------------------------------------------------------------");
			for (int i = 0; i < indiceAnuncios; i++) {
				if (nomeCliente[i].equalsIgnoreCase(_nome)) {
					System.out.print("Anuncio: " + nomeAnuncio[i] + " || Cliente: " + nomeCliente[i] + " || Data: "
							+ diaInicio[i] + "/" + mesInicio[i] + "/" + anoInicio[i] + " || Valor Investido: "
							+ investDia[i]);

					calculadoraAlcance(investDia[i], i);

					System.out.println(
							"\n--------------------------------------------------------------------------------------------");
				}
			}
		} catch (Exception e) {
			System.out.println("\n\nFim dos Dados");
		}
	}

	public static void relatorioPorData(int _startDia, int _startMes, int _startAno, int _endDia, int _endMes,int _endAno) {

		DateTime dataInicialJoda = new DateTime(_startAno, _startMes, _startDia, 0, 0);
		DateTime dataFinalJoda = new DateTime(_endAno, _endMes, _endDia, 0, 0);

		System.out.println("\nBusca entre: " + _startDia + "/" + _startMes + "/" + _startAno + " e " + _endDia + "/" + _endMes + "/" + _endAno);
		try {
			System.out.println("--------------------------------------------------------------------------------------------");
			for (int i = 0; i < indiceAnuncios; i++) {
				DateTime dataAnuncio = new DateTime(anoInicio[i], mesInicio[i], diaInicio[i], 0, 0);
				
				if (dataAnuncio.isAfter(dataInicialJoda) && dataAnuncio.isBefore(dataFinalJoda)) {
					System.out.print("Anuncio: " + nomeAnuncio[i] + " || Cliente: " + nomeCliente[i] + " || Data: "+ diaInicio[i] 
							+ "/" + mesInicio[i] + "/" + anoInicio[i] + " || Valor Investido: "+ investDia[i]);

					calculadoraAlcance(investDia[i], i);

					System.out.println("\n--------------------------------------------------------------------------------------------");
				} else {
					System.out.println("Falso");
				}
			}
		} catch (Exception e) {
			System.out.println("Fim dos Dados");
		}
	}
}
