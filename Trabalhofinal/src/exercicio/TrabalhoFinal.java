package exercicio;

import java.util.Scanner;

public class TrabalhoFinal {
	
	public static void planilhaGeral (int [][] mat_geral, String[] produtos) {
		
		System.out.println("\n\n Você escolheu a planilha geral!\n\n");
			
		System.out.println("                              "+"    Preço de custo    "+"    Preço de Venda    "+"    Lucro    "+"    Estoque    "+"    Vendas diárias    ");
		for(int i = 1; i < 6;i++) {
	
 				System.out.println(produtos[i]+"                  "+mat_geral[i][1]+"                     "+mat_geral[i][2]+"                "+mat_geral[i][3]+"              "+mat_geral[i][4]+"                 "+mat_geral[i][5]);
				
		}
	}


	public static void main(String[] args) {
		
		    Scanner sc = new Scanner(System.in);
			
			//Variáveis

			int escolha_menu, escolha_venda;
			int escolha_masc, escolha_tecido, venda, total_vendas = 0, valor_venda;
			int escolha_estoque, add_prod, prod_add;
			int escolha_preco, visu_preco;
			int escolha_relatorio;
			int escolha_lucro, add_custo;

			
			//Matriz e vetores

			int[][] mat_geral = new int [5][6];
			
			// Definindo um valor de cada tipo de máscara.
			mat_geral[1][2] = 10;
			mat_geral[2][2] = 12;	
			mat_geral[3][2] = 12;
			mat_geral[4][2] = 15;
			
			// Definindo um valor inicial para o custo de cada tipo de máscara.
			mat_geral[1][1] = 5;
			mat_geral[2][1] = 6;	
			mat_geral[3][1] = 7;
			mat_geral[4][1] = 7;
			
			int[][] rel_dia = new int [5][2];
			
			String produtos [] = {" ","Mascara ADULTO-LISTRADA", "Mascara ADULTO-ESTAMPADA", "Mascara INFANTIL-LISTRADA", "Mascara INFANTIL-ESTAMPADA"};
			


			//Inicio do Programa
			
			
			/* Esse 'looping' serve para que o programa realmente funcione. Com ele, eu vou poder usar cada opção de forma interativa,
			 	pois o meu programa vai salvar os dados e trabalhar com eles em cima do que eu coloquei, ja que no momento nao temos
			 	um banco de dado para armazena-los
			 */
			for(int looping = 0; looping < 1000;looping++) {
				
				System.out.println("Menu:");
				System.out.println("1. Caixa de venda.\n2. Estoque.\n3. Tabela de precos - Modificar preço.\n4. Relatório de venda.\n5. Lucro.");
				escolha_menu = sc.nextInt();
				
				switch(escolha_menu){
				

				/* A case 1 proporciona que o usuário escolha a opção de 'Venda de caixa', em que ele vai utilizar para fazer as vendas das
				mascaras que ele fabica. Nessa parte terão proscedimentos atualização no estoque, acionamento da planilha de vendas, tendo a atualiza
				ção de todos os componentes, para que tudo ocorra em ordem */
				case 1:
					System.out.println("Escolha o tipo de mascara:");
					System.out.println("1 . Máscara adulta\n2. Mascara Infantil");
					escolha_venda = sc.nextInt();

					//ESCOLHA VENDA MASCARA ADULTA
			
					if(escolha_venda == 1){

						System.out.println("Escolha o tipo de tecido:");

						System.out.println("1. A Mascara ADULTO-LISTRADA custa "+ mat_geral[1][2]+" ,contendo no estoque "+(mat_geral[1][4]));

						System.out.println("2. A Mascara ADULTO-ESTAMPADA custa "+ mat_geral[2][2]+" ,contendo no estoque "+mat_geral[2][4]);

						escolha_tecido = sc.nextInt();
						
						if(escolha_tecido == 1){
							if(mat_geral[1][4] <= 0) {
								
								System.out.println("Sem produto no estoque...\n\n");
								
							}
							else {
								
							System.out.println("\nQuantas mascaras serão vendidas:");
							venda = sc.nextInt();
							
							System.out.println("\nStatus da Venda:\n");
							
							for(int i = 1;i < 2;i++){

								for(int j = 4;j < 5;j++){
									

									mat_geral[i][j] -= venda; //Desconto no estoque
									
									/*Uma variável para contar o total de vendas no dia e uma para mostrar a quantidade
									vendida desse produto */
									total_vendas = venda;
									rel_dia [1][1] = venda;
									
									//Vendas totais diárias.
									mat_geral[i][5] += venda;      

									System.out.println("O número de mascaras no estoque agora são: "+ mat_geral[i][j]+"\n");	
									
								}
				
				
							}//FIM FOR

							

							/* Essa condição de repetição serve para calcular o valor total que o cliente tem que pagar.Além disso, vao 
							ocorrer o calculo de lucro em cima da venda realizada */
							for(int i = 1;i < 2;i++){
							

								for(int j = 2;j < 3;j++){

									valor_venda = mat_geral[i][j] * venda;
									
									//Lucro gerado por cada venda realizada, visando o valor de venda menos o valor de custo.
									mat_geral[i][3] = valor_venda - (mat_geral[i][1] * venda);

									System.out.println("O valor total a se pagar é de: "+ valor_venda+"\n");	
			
									System.out.println("Venda realizada com sucesso.\n");

								}
				
				
							}//FIM FOR	
							}
						}//FIM IF
						
						if(escolha_tecido == 2){
							
							if(mat_geral[1][4] <= 0) {
								
								System.out.println("Sem produto no estoque...\n\n");
								
							}
							else {
								
							System.out.println("\nQuantas mascaras serão vendidas:");
							venda = sc.nextInt();
							
							System.out.println("\nStatus da Venda:");

							for(int i = 2;i < 3;i++){

								for(int j = 4;j < 5;j++){
									

									mat_geral[i][j] -= venda; //Desconto no estoque
									
									/*Uma variável para contar o total de vendas no dia e uma para mostrar a quantidade
									vendida desse produto */
									total_vendas = venda;
									rel_dia [2][1] = venda;

									//Vendas totais diárias.
									mat_geral[i][5] += venda;    
  

									System.out.println("O número de mascaras no estoque agora são: "+ mat_geral[i][j]+"\n");	
									System.out.println("");
								}

							}//FIM FOR


							/* Essa condição de repetição serve para calcular o valor total que o cliente tem que pagar.Além disso, vai 
							ocorrer o calculo de lucro em cima da venda realizada */
							for(int i = 1;i < 2;i++){

								for(int j = 2;j < 3;j++){

									valor_venda = mat_geral[i][j] * venda;
									
									//Lucro gerado por cada venda realizada, visando o valor de venda menos o valor de custo.
									mat_geral[i][3] = valor_venda - (mat_geral[i][1] * venda);

									System.out.println("O valor total a se pagar é de: "+ valor_venda+"\n");	
									
									System.out.println("Venda realizada com sucesso.\n");

								}
				
							}//FIM FOR	
							}
						}//FIM IF
							
					}// FIM IF MASCARAS ADULTAS
					
					if(escolha_venda == 2){

						System.out.println("Escolha o tipo de tecido:");

						System.out.println("1. Listrada que custa "+ mat_geral[3][2]+" ,contendo no estoque "+mat_geral[3][4]);

						System.out.println("2. Estampada que custa "+ mat_geral[4][2]+" ,contendo no estoque "+mat_geral[4][4]);

						escolha_tecido = sc.nextInt();
						
						if(escolha_tecido == 1){
							
							if(mat_geral[1][4] <= 0) {
								
								System.out.println("Sem produto no estoque...\n\n");
								
							}
							else {
							System.out.println("\nQuantas mascaras serão vendidas:");
							venda = sc.nextInt();
							
							
							for(int i = 3;i < 4;i++){

								for(int j = 4;j < 5;j++){
									

									mat_geral[i][j] -= venda; //Desconto no estoque
									
									/*Uma variável para contar o total de vendas no dia e uma para mostrar a quantidade
									vendida desse produto */
									total_vendas = venda;
									rel_dia [3][1] = venda;

									//Vendas totais diárias.
									mat_geral[i][5] += venda;      

									System.out.println("O número de mascaras no estoque agora são: "+ mat_geral[i][j]);	

								}
				
				
							}//FIM FOR


							/* Essa condição de repetição serve para calcular o valor total que o cliente tem que pagar.Além disso, vao 
							ocorrer o calculo de lucro em cima da venda realizada */
							
							for(int i = 3;i < 4;i++){
							

								for(int j = 2;j < 3;j++){

									valor_venda = mat_geral[i][j] * venda;
									
									//Lucro gerado por cada venda realizada, visando o valor de venda menos o valor de custo.
									mat_geral[i][3] = valor_venda - (mat_geral[i][1] * venda);

									System.out.println("O valor total a se pagar é de: "+ valor_venda);			
				
									System.out.println("Venda realizada com sucesso.");

								}
				
				
							}//FIM FOR	
							}
						}//FIM IF
						
						if(escolha_tecido == 2){
							if(mat_geral[1][4] <= 0) {
								System.out.println("Sem produto no estoque...\n\n");
							}
							else {
							System.out.println("\nQuantas mascaras serão vendidas:");
							venda = sc.nextInt();

							for(int i = 4;i < 5;i++){

								for(int j = 4;j < 5;j++){
									

									mat_geral[i][j] -= venda; //Desconto no estoque
									
									/*Uma variável para contar o total de vendas no dia e uma para mostrar a quantidade
									vendida desse produto */
									total_vendas = venda;
									rel_dia [4][1] = venda;

									//Vendas totais diárias.
									mat_geral[i][5] += venda;      

									System.out.println("O número de mascaras no estoque agora são: "+ mat_geral[i][j]);	

								}

							}//FIM FOR

							

							/* Essa condição de repetição serve para calcular o valor total que o cliente tem que pagar.Além disso, vai 
							ocorrer o calculo de lucro em cima da venda realizada */
							for(int i = 4;i < 5;i++){

								for(int j = 2;j < 3;j++){

									valor_venda = mat_geral[i][j] * venda;
									
									//Lucro gerado por cada venda realizada, visando o valor de venda menos o valor de custo.
									mat_geral[i][3] = valor_venda - (mat_geral[i][1] * venda);

									System.out.println("O valor total a se pagar é de: "+ valor_venda);			
				
									System.out.println("Venda realizada com sucesso.");

								}
				
				
							}//FIM FOR	
							}
						}//FIM IF
							
					}// FIM IF MASCARAS ADULTAS
					
			    break;
			    
			    
				
					/*Nesse case tem as funções para o programa mostrar o estoque total para o pequno consumidor,
					  além de ter a opção de adicionar produtos no estoque */
				case 2:
					
					System.out.println("\nQual opção você deseja:");
					System.out.println("1. Vizualizar estoque\n2. Adicionar produtos no estoque\n");
					escolha_estoque = sc.nextInt();
					


					if(escolha_estoque == 1){
						
						//Esse 'IF' é responsável por mostrar o estoque para o pequeno consumidor .
						System.out.println("ESTOQUE DE MÁSCARAS:");
						
						for(int i = 1;i < mat_geral.length;i++){
							
							for(int j = 4;j < 5;j++){
								
								System.out.println("Temos "+mat_geral[i][j]+" "+produtos[i]+ " disponíveis no estoque. ");
						
							} 
					
						}//FIM FOR
						
						System.out.println("\n\n");
						
					}
					
					
					/*Nesse for teremos uma condição para adicionar produtos ao estoque. Esse estoque vai ser atualizado
					  em divérsas partes do nosso programa. */
					else if(escolha_estoque == 2){
						
						System.out.println("\nQual o produto que você quer adicionar no estoque?");
						System.out.println("1. PRODUTO 1( Máscara ADULTO - LISTRADA )\n2. PRODUTO 2( Máscara  ADULTO - ESTAMPADA )");
						System.out.println("3. PRODUTO 3( Máscara  INFANTIL - LISTRADA )\n4. PRODUTO 4( Máscara  INFANTIL - ESTAMAPDA )");
						add_prod = sc.nextInt();
						
							switch(add_prod) {
							
							case 1:
								
								System.out.println("Produto 1 escolhido!");
								System.out.println("Deseja colocar quantas máscaras?");
								
								for (int i = 1; i < 2;i++) {
									
									for(int j = 4;j < 5;j++) {
										
										prod_add = sc.nextInt();
										mat_geral[i][j] += prod_add;
										
										System.out.println("\nProduto realizado com Sucesso !\n\n");
							
									}
									
								}
								
								break;
								
							case 2:
								
								System.out.println("Produto 2 escolhido!");
								
								System.out.println("Deseja colocar quantas máscaras?");
								
								for (int i = 2; i < 3;i++) {
									
									for(int j = 4;j < 5;j++) {
										
										prod_add = sc.nextInt();
										mat_geral[i][j] += prod_add;
										
										System.out.println("\nProduto realizado com Sucesso !\n\n");
									}
									
								}
								
								break;
								
							case 3:
								
								System.out.println("Produto 3 escolhido!");
								System.out.println("Deseja colocar quantas máscaras?");
								
								for (int i = 3; i < 4;i++) {
									
									for(int j = 4;j < 5;j++) {
										
										prod_add = sc.nextInt();
										mat_geral[i][j] += prod_add;
										
										System.out.println("\nProduto realizado com Sucesso !\n\n");
									}
									
								}
								
								break;
								
							case 4:	
								
								System.out.println("Produto 4 escolhido!");
								System.out.println("Deseja colocar quantas máscaras?");
								
								for (int i = 4; i < 5;i++) {
									
									for(int j = 4;j < 5;j++) {
										
										prod_add = sc.nextInt();
										mat_geral[i][j] += prod_add;
										
										System.out.println("\nProduto realizado com Sucesso !\n\n");
									}
									
								}
								
								break;
								
							}//FIM SWITCH ADD_ESTOQUE
						
					}//FIM IF
					
					break;
					
					
					
				/* Nessa case tem as funções em que o programa vai vuscar na matriz geral o proço de cada máscara e além disso,
				   o pequeno produtor vai poder adicionar/modificar o preço de cada produto */
				case 3:
					
					
					System.out.println("Qual opção você deseja:");
					System.out.println("1. Visualizar a tabela de preços\n2. Adicionar/Alterar os preços das máscaras");
					escolha_preco = sc.nextInt();
					
					if(escolha_preco == 1) {
						
						//Esse 'IF' é responsável por mostrar a tabela de preços para o pequeno consumidor .
						System.out.println("TABELA DE PREÇOS:");
						
						for(int i = 1;i < mat_geral.length;i++){
							
							for(int j = 2;j < 3;j++){
								
								System.out.println("O preço do produto "+i+". "+produtos[i]+" é de: " +mat_geral[i][j]);
								
							} 
					
						}//FIM FOR
						
						System.out.println("\n\n");
						
					}
					
					
					
					/*Nesse for teremos uma condição para adicionar produtos ao estoque. Esse estoque vai ser atualizado
					  em divérsas partes do nosso programa. */
					else if(escolha_preco == 2) {

						System.out.println("Qual o produto que você quer mudar ou adicionar o preço?");
						System.out.println("1. PRODUTO 1( Máscara ADULTO - LISTRADA )\n2. PRODUTO 2( Máscara  ADULTO - ESTAMPADA )");
						System.out.println("3. PRODUTO 3( Máscara  INFANTIL - LISTRADA )\n4. PRODUTO 4( Máscara  INFANTIL - ESTAMAPDA )");
						add_prod = sc.nextInt();
						
							switch(add_prod) {
							
							case 1:
								
								System.out.println("Produto 1 escolhido!");
								System.out.println("Qual será o preço?");
								
								for (int i = 1; i < 2;i++) {
									
									for(int j = 2;j < 3;j++) {
										
										mat_geral[i][j] = sc.nextInt();
										
										System.out.println("\nModificação de preço realizado com Sucesso !\n\n");
									}
									
								}
								
								break;
								
							case 2:
								
								System.out.println("Produto 2 escolhido!");
								
								System.out.println("Qual será o preço?");
								
								for (int i = 2; i < 3;i++) {
									
									for(int j = 2;j < 3;j++) {
										
										mat_geral[i][j] = sc.nextInt();
										
										System.out.println("\nModificação de preço realizado com Sucesso !\n\n");
									}
									
								}
								
								break;
								
							case 3:
								
								System.out.println("Produto 3 escolhido!");
								System.out.println("Qual será o preço?");
								
								for (int i = 3; i < 4;i++) {
									
									for(int j = 2;j < 3;j++) {
										
										mat_geral[i][j] = sc.nextInt();
										
										System.out.println("\nModificação de preço realizado com Sucesso !\n\n");
										
									}
									
								}
								
								break;
								
							case 4:	
								
								System.out.println("Produto 4 escolhido!");
								System.out.println("Qual será o preço?");
								
								for (int i = 4; i < 5;i++) {
									
									for(int j = 2;j < 3;j++) {
										
										mat_geral[i][j] = sc.nextInt();
										
										System.out.println("\nModificação de preço realizado com Sucesso !\n\n");
										
									}
									
								}
								
								break;
								
							}//FIM SWITCH ADD_ESTOQUE
						
					}//FIM IF PRECO
					
				break;
					
				
				
				/* 
				   Esse case serve pra mostrar os relatórios das vendas. Nele o pequeno produtor consegue ver quantas máscaras ele 
				   vendeu no dia.Além disso, ele consegue ver qual o valor total de mascaras vendido e qual é o seu lucro 
				*/
					
				case 4:
					
					System.out.println("Qual opção você deseja:");
					System.out.println("1. Relatório geral do dia.\n2. Relatório geral ");
					escolha_relatorio = sc.nextInt();
					
					if(escolha_relatorio == 1) {
						
						System.out.println("Relatório de vendas do dia:\n");
						
						System.out.println("Foram vendidas "+ total_vendas + " máscaras no total.");
						
							for(int i = 1;i < 5;i++) {
								
								for(int j = 1;j < 2;j++) {
									
									System.out.println("Foram vendidas "+rel_dia[i][j]+" "+produtos[i]+".");
									
								}//FOR REL DIARIO
								
							}//FOR REL DIARIO
							System.out.println("\n");
					}//IF OPÇÃO 1
					
					else if(escolha_relatorio == 2) {
						System.out.println("\n\n Você escolheu a planilha geral !");
						
						planilhaGeral(mat_geral, produtos);
						
					}
					break;
					
					
					/* Nessa case 5 a pessoa vai poder ver o lucro que ela obteve no dia de venda e 
					   alterar o preço de custo das máscaras */
					 
				case 5:	
					
					System.out.println("Qual opção você deseja:");
					System.out.println("1. Lucro do dia.\n2. Alterar preço de custo ");
					escolha_lucro = sc.nextInt();
					
					if(escolha_lucro == 1) {
						
						System.out.println("O lucro diário com cada produto é:");
						
						for(int i = 1; i < 5;i++) {
							
							System.out.println("Com "+produtos[i]+ " você faturou"+mat_geral[i][3]);
							
						}
						
					}
					
					else if (escolha_lucro == 2) {
						
						System.out.println("Qual o produto que você quer alterar o preço de custo?\n");
						System.out.println("1. PRODUTO 1( Máscara ADULTO - LISTRADA )\n2. PRODUTO 2( Máscara  ADULTO - ESTAMPADA )");
						System.out.println("3. PRODUTO 3( Máscara  INFANTIL - LISTRADA )\n4. PRODUTO 4( Máscara  INFANTIL - ESTAMAPDA )");
						add_custo = sc.nextInt();
						
							switch(add_custo) {
							
							case 1:
								
								System.out.println("Produto 1 escolhido!");
								
								System.out.println("Qual será o preço?");
								
								for (int i = 1; i < 2;i++) {
									
									for(int j = 1;j < 2;j++) {
										
										mat_geral[i][j] = sc.nextInt();
										
										System.out.println("\nModificação de preço realizado com Sucesso !\n\n");
										
									}
									
								}
								
								break;
								
							case 2:
								
								System.out.println("Produto 2 escolhido!");
								System.out.println("Qual será o preço?");
								
								for (int i = 2; i < 3;i++) {
									
									for(int j = 1;j < 2;j++) {
										
										mat_geral[i][j] = sc.nextInt();
										
										System.out.println("\nModificação de preço realizado com Sucesso !\n\n");
									}
									
								}
								
								break;
								
							case 3:
								
								System.out.println("Produto 3 escolhido!");
								System.out.println("Qual será o preço?");
								
								for (int i = 3; i < 4;i++) {
									
									for(int j = 1;j < 2;j++) {
										
										mat_geral[i][j] = sc.nextInt();
										
										System.out.println("\nModificação de preço realizado com Sucesso !\n\n");
										
									}
									
								}
								
								break;
								
							case 4:	
								
								System.out.println("Produto 4 escolhido!");
								System.out.println("Qual será o preço?");
								
								for (int i = 4; i < 5;i++) {
									
									for(int j = 1;j < 2;j++) {
										
										mat_geral[i][j] = sc.nextInt();
										
										System.out.println("\nModificação de preço realizado com Sucesso !\n\n");
										
									}
									
								}
								
								break;
								
						}//FIM SWITCH ADD_ESTOQUE
						
					}
					
				}//Chave FIM SWITCH MENU
				
			}

		}
	
	}


